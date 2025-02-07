package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseDragAdvanced extends MouseAdapter {
    private Point origin;
    private Timer inertiaTimer;
    private int velocity = 0;
    private final JScrollPane scrollPane;
    private final double SCROLL_FACTOR ;
    private final int MAX_DELTA;
    private final boolean isHaveSize;
    private final Runnable loadMoreCallback;

    public MouseDragAdvanced(JScrollPane scrollPane, double SCROLL_FACTOR, int MAX_DELTA, boolean isHaveSize, Runnable loadMoreCallback) {
        this.scrollPane = scrollPane;
        this.SCROLL_FACTOR = SCROLL_FACTOR;
        this.MAX_DELTA = MAX_DELTA;
        this.isHaveSize = isHaveSize;
        this.loadMoreCallback = loadMoreCallback;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        origin = e.getPoint();
        if (inertiaTimer != null && inertiaTimer.isRunning()) {
            inertiaTimer.stop();
        }
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if (origin == null) return;
        JViewport viewport = scrollPane.getViewport();
        Point viewPosition = viewport.getViewPosition();
        int deltaY = origin.y - e.getY();
        deltaY = (int) Math.signum(deltaY) * Math.min(MAX_DELTA, Math.abs((int) (deltaY * SCROLL_FACTOR)));
        velocity = deltaY;
        int newY = viewPosition.y + deltaY;
        Component view = viewport.getView();
        int maxHeight = (isHaveSize) ? 1450 : view.getHeight() - viewport.getHeight();
        newY = Math.max(0, Math.min(newY, maxHeight));
        int finalNewY = newY;
        SwingUtilities.invokeLater(() -> {
            viewport.setViewPosition(new Point(viewPosition.x, finalNewY));
            checkLoadMore();
        });
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        origin = null;
        applyInertia();
    }
    private void applyInertia() {
        inertiaTimer = new Timer(16, event -> {
            if (Math.abs(velocity) < 1) {
                ((Timer) event.getSource()).stop();
                return;
            }
            JViewport viewport = scrollPane.getViewport();
            Point viewPosition = viewport.getViewPosition();
            int newY = viewPosition.y + velocity;
            Component view = viewport.getView();
            int maxHeight = (isHaveSize) ? 1450 : view.getHeight() - viewport.getHeight();
            newY = Math.max(0, Math.min(newY, maxHeight));
            int finalNewY = newY;
            SwingUtilities.invokeLater(() -> {
                viewport.setViewPosition(new Point(viewPosition.x, finalNewY));
                checkLoadMore();
            });
            velocity *= 0.9;
        });
        inertiaTimer.start();
    }

    private void checkLoadMore() {
        JViewport viewport = scrollPane.getViewport();
        Component view = viewport.getView();
        int viewHeight = view.getHeight();
        int viewportHeight = viewport.getHeight();
        int scrollY = viewport.getViewPosition().y;

        if (scrollY + viewportHeight >= viewHeight - 100) { // Nếu kéo gần cuối trang (còn 100px)
            if (loadMoreCallback != null) {
                loadMoreCallback.run(); // Gọi processNewBook() từ callback
            }
        }
    }
}
