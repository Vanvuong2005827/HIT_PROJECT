package commons;

import models.book_information.Book;
import models.book_information.BookCategory;
import models.book_information.ListBook;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BookGrid1ColPanel {
//    public static JPanel customBookGrid1(int index, int panelWidth, int panelHeight, int imgWidth, int imgHeight, ArrayList<Book> books, Color cusColor, String baseUrl, Font customFont1, Font customFont2) {
//        ListBook lb = new ListBook();
//        ColorMain cl = new ColorMain();
//        ArrayList<Book> books = lb.getBooksHoanThanh();
//        ArrayList<Color> colors = cl.getColorMain();
//
//        for (int i = 0; i < books.size(); i++) {
//            // Panel chính
//            JPanel panel = new JPanel(new BorderLayout(10, 10));
//            Color cusColor = colors.get(i);
//            Font customFont = new Font("Segoe UI", Font.BOLD, 13);
//            panel.setBackground(cusColor);
//
//            // Gen ảnh
//            String baseUrlAllBook = "https://img.otruyenapi.com/uploads/comics/";
//            String posterPathAllBook = books.get(i).getThumbnail();
//            String fullUrlAllBook = baseUrlAllBook + posterPathAllBook;
//            try {
//                URL urlAllbook = new URL(fullUrlAllBook);
//                Image imageAllBook = ImageIO.read(urlAllbook);
//                Image resizedImageAllBook = imageAllBook.getScaledInstance(120, 169, Image.SCALE_SMOOTH);
//                JLabel jLabel1 = new JLabel(new ImageIcon(resizedImageAllBook));
//
//                panel.add(jLabel1, BorderLayout.WEST);
//            } catch (IOException e) {
//                e.printStackTrace();
//                JLabel errorLabel = new JLabel("Không thể tải ảnh!");
//                errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
//                panel.add(errorLabel, BorderLayout.CENTER);
//            }
//
//            // Phan text ben phai
//            JPanel mainTextPanel = new JPanel();
//            mainTextPanel.setBackground(cusColor);
//            mainTextPanel.setPreferredSize(new Dimension(320, 160));
//
//            // Panel chua text
//            JPanel textPanel = new JPanel(new GridLayout(4, 1, 5, 5)); // 2 hàng, 1 cột
//            textPanel.setBackground(cusColor);
//            textPanel.setPreferredSize(new Dimension(288, 158));
//
//            // Xu ly updateLast
//            String inputDateTime = books.get(i).getUpdatedAt();
//            LocalDateTime dateTime = LocalDateTime.parse(inputDateTime.substring(0, 19));
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
//            String updateAt = dateTime.format(formatter);
//
//            StringBuilder categories = new StringBuilder();
//            for (BookCategory x : books.get(i).getCategory()) {
//                if (categories.length() > 0) {
//                    categories.append(", ");
//                }
//                categories.append(x.getName());
//            }
//
//            // Cac text area
//            JPanel emptyPanel = new JPanel();
//            JTextArea titleArea = new JTextArea(books.get(i).getName());
//            JTextArea statusArea = new JTextArea("Status: " + books.get(i).getStatus());
//            JTextArea updatedAtArea = new JTextArea("Last update: " + updateAt);
//            JTextArea categoryArea = new JTextArea(categories.toString());
//
//            // Cấu hình text area
//            emptyPanel.setSize(new Dimension(50, 1));
//            emptyPanel.setBackground(cusColor);
//
//            titleArea.setFont(customFont);
//            titleArea.setBackground(cusColor);
//            titleArea.setWrapStyleWord(true);
//            titleArea.setLineWrap(true);
//            titleArea.setEditable(false);
//
//            statusArea.setFont(customFont);
//            statusArea.setBackground(cusColor);
//            statusArea.setLineWrap(true);
//            statusArea.setWrapStyleWord(true);
//            statusArea.setEditable(false);
//
//            updatedAtArea.setFont(customFont);
//            updatedAtArea.setBackground(cusColor);
//            updatedAtArea.setLineWrap(true);
//            updatedAtArea.setWrapStyleWord(true);
//            updatedAtArea.setEditable(false);
//
//            categoryArea.setFont(customFont);
//            categoryArea.setBackground(cusColor);
//            categoryArea.setLineWrap(true);
//            categoryArea.setWrapStyleWord(true);
//            categoryArea.setEditable(false);
//
//            // Add vao phan chua text
//            textPanel.add(titleArea);
//            textPanel.add(statusArea);
//            textPanel.add(updatedAtArea);
//            textPanel.add(categoryArea);
//
//            // Add vao panel ben phai
//            mainTextPanel.add(emptyPanel);
//            mainTextPanel.add(textPanel, BorderLayout.CENTER);
//            mainTextPanel.add(emptyPanel);
//
//            // Add vao panel chinh
//            panel.add(mainTextPanel, BorderLayout.CENTER);
//
//            homePageViewPanel.add(panel);
//        }
//        homePageViewPanel.revalidate();
//        homePageViewPanel.repaint();
//    }
}
