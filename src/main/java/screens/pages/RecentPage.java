
package screens.pages;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;


public class RecentPage extends javax.swing.JFrame {


    public RecentPage() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(176, 223, 251));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    // MouseAdapter dragScrollListenerMainScroll = new MouseAdapter() {
//            private Point origin;
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                origin = e.getPoint(); // Vị trí ban đầu khi nhấn chuột
//            }
//
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                JViewport viewport = jScrollPane1.getViewport();
//                Point viewPosition = viewport.getViewPosition(); // Vị trí hiện tại của viewport
//                int deltaX = origin.x - e.getX(); // Tính khoảng cách kéo ngang
//                int deltaY = origin.y - e.getY(); // Tính khoảng cách kéo dọc
//
//                // Tính vị trí mới của viewport
//                int newX = viewPosition.x + deltaX;
//                int newY = viewPosition.y + deltaY;
//
//                // Cần fix giới hạn kéo theo các panel con
//                // Đảm bảo không cuộn vượt quá giới hạn
////                newX = Math.max(0, Math.min(newX, homeMainPanel.getWidth() - viewport.getWidth()));
//                newY = Math.max(0, Math.min(newY, jPanel1.getHeight() - viewport.getHeight()));
//
//                // Cập nhật vị trí viewport
//
//                viewport.setViewPosition(new Point(0, newY));
//            }
//        };
    public JPanel recentPanel(){
        return jPanel1;
    }
    // Variables declaration - do not modify
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}
