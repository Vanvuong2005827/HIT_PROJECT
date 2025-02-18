package controllers.other;

import utils.MouseDragCommon;
import view.user_view.screens.home_screens.ChatBotScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static services.impl.IChatBotServiceImpl.askGemini;
import static utils.CustomChatMessage.customChat;

public class ChatBotController {
    private ChatBotScreen chatBotScreen;
    private boolean isReply = false;

    public ChatBotController(ChatBotScreen chatBotScreen) {
        this.chatBotScreen = chatBotScreen;
        sendMessageEvent();
        mouseDrag();
    }

    private void sendMessageEvent() {
        chatBotScreen.getjLabel1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getMessage();
            }
        });

        chatBotScreen.getjTextField1().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    getMessage();
                }
            }
        });

    }

    private void getMessage() {
        String userText = chatBotScreen.getjTextField1().getText().trim();
        if (isReply) return;
        if (!userText.isEmpty()) {
            isReply = true;
            chatBotScreen.getjTextField1().setText("");
            chatBotScreen.getjTextField1().setEnabled(false);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;
            gbc.gridx = 1;
            gbc.gridy = chatBotScreen.getMainPanel().getComponentCount();
            chatBotScreen.getMainPanel().add(customChat(userText, true), gbc);
            JLabel botLabel = customChat("...", false);
            gbc.gridy = chatBotScreen.getMainPanel().getComponentCount();
            chatBotScreen.getMainPanel().add(botLabel, gbc);
            chatBotScreen.getMainPanel().revalidate();
            chatBotScreen.getMainPanel().repaint();
            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                String message;

                @Override
                protected Void doInBackground() throws Exception {
                    message = askGemini(userText);
                    message.trim();
                    return null;
                }

                @Override
                protected void done() {
                    botLabel.setText("<html><p style='width: 250px; word-wrap: break-word;text-align: left;margin: 0;'>" + message + "</p></html>");
                    chatBotScreen.getMainPanel().revalidate();
                    chatBotScreen.getMainPanel().repaint();
                    SwingUtilities.invokeLater(() -> {
                        JScrollBar verticalBar = chatBotScreen.getChatScroll().getVerticalScrollBar();
                        verticalBar.setValue(verticalBar.getMaximum());
                    });

                    chatBotScreen.getjTextField1().setEnabled(true);
                    isReply = false;
                }
            };
            worker.execute();
            chatBotScreen.getMainPanel().revalidate();
            chatBotScreen.getMainPanel().repaint();
        }
    }

    private void mouseDrag() {
        MouseDragCommon mouseDragCommon = new MouseDragCommon(chatBotScreen.getChatScroll(), 1.5, 80, false);
        chatBotScreen.getMainPanel().addMouseListener(mouseDragCommon);
        chatBotScreen.getMainPanel().addMouseMotionListener(mouseDragCommon);
    }

}
