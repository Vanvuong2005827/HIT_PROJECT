package commons;

import models.book_information.Book;
import models.book_information.BookCategory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class BookGrid3ColPanel {
    public static JPanel customBookGrid3(int index, int panelWidth, int panelHeight, int imgWidth, int imgHeight, ArrayList<Book> books, Color cusColor, String baseUrl, Font customFont1, Font customFont2) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(cusColor);
        panel.setPreferredSize(new Dimension(panelWidth, panelHeight));
        String baseUrlAllBook = baseUrl;
        String posterPathAllBook = books.get(index).getThumbnail();
        String fullUrlAllBook = baseUrlAllBook + posterPathAllBook;

        try {
            URL urlAllbook = new URL(fullUrlAllBook);
            Image imageAllBook = ImageIO.read(urlAllbook);

            Image resizedImageAllBook = imageAllBook.getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);

            JLabel jLabel1 = new JLabel(new ImageIcon(resizedImageAllBook));

            panel.add(jLabel1);
        } catch (IOException e) {
            e.printStackTrace();
            JLabel errorLabel = new JLabel("Không thể tải ảnh!");
            errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(errorLabel, BorderLayout.CENTER);
        }

        StringBuilder categories = new StringBuilder();
        for (BookCategory x : books.get(index).getCategory()) {
            if (categories.length() > 0) {
                categories.append(", ");
            }
            categories.append(x.getName());
        }

        // Details
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(panel.getBackground());

        JLabel titleArea = new JLabel(books.get(index).getName());
        titleArea.setFont(customFont1);
        titleArea.setBackground(cusColor);
        textPanel.add(titleArea);

        JLabel categoriesArea = new JLabel(categories.toString());
        categoriesArea.setFont(customFont2);
        categoriesArea.setBackground(cusColor);
        categoriesArea.setForeground(Color.GRAY);
        textPanel.add(categoriesArea);

        panel.add(textPanel);
        return panel;
    }
}
