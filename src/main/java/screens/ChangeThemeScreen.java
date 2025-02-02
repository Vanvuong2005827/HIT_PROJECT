package screens;

import DAO.ConnectDB;

import javax.swing.*;

import static commons.ColorMain.colorMain;
import static commons.ColorMain.listColor;

public class ChangeThemeScreen extends javax.swing.JFrame {
    JFrame previousScreen;

    public ChangeThemeScreen(JFrame jf) {
        previousScreen = jf;
        initComponents();
        setLocationRelativeTo(null);

        color1.setBackground(listColor.get(0));
        color2.setBackground(listColor.get(1));
        color3.setBackground(listColor.get(2));
        color4.setBackground(listColor.get(3));
        color5.setBackground(listColor.get(4));
        color6.setBackground(listColor.get(5));
        color7.setBackground(listColor.get(6));
        color8.setBackground(listColor.get(7));
        color9.setBackground(listColor.get(8));
        color10.setBackground(listColor.get(9));
        color11.setBackground(listColor.get(10));
        color12.setBackground(listColor.get(11));
        color13.setBackground(listColor.get(12));
        color14.setBackground(listColor.get(13));
        color15.setBackground(listColor.get(14));
        color16.setBackground(listColor.get(15));

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        color1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        color2 = new javax.swing.JPanel();
        color3 = new javax.swing.JPanel();
        color4 = new javax.swing.JPanel();
        color7 = new javax.swing.JPanel();
        color6 = new javax.swing.JPanel();
        color8 = new javax.swing.JPanel();
        color5 = new javax.swing.JPanel();
        color9 = new javax.swing.JPanel();
        color10 = new javax.swing.JPanel();
        color11 = new javax.swing.JPanel();
        color12 = new javax.swing.JPanel();
        color13 = new javax.swing.JPanel();
        color14 = new javax.swing.JPanel();
        color16 = new javax.swing.JPanel();
        color15 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(colorMain);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        color1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color1Event(evt);
            }
        });

        javax.swing.GroupLayout color1Layout = new javax.swing.GroupLayout(color1);
        color1.setLayout(color1Layout);
        color1Layout.setHorizontalGroup(
                color1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color1Layout.setVerticalGroup(
                color1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 60, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setText("<");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backEvent(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel2.setText("Chọn màu bạn muốn");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 210, 40));

        color2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color2Event(evt);
            }
        });

        javax.swing.GroupLayout color2Layout = new javax.swing.GroupLayout(color2);
        color2.setLayout(color2Layout);
        color2Layout.setHorizontalGroup(
                color2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color2Layout.setVerticalGroup(
                color2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 60, 50));

        color3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color3Event(evt);
            }
        });

        javax.swing.GroupLayout color3Layout = new javax.swing.GroupLayout(color3);
        color3.setLayout(color3Layout);
        color3Layout.setHorizontalGroup(
                color3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color3Layout.setVerticalGroup(
                color3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 60, 50));

        color4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color4Event(evt);
            }
        });

        javax.swing.GroupLayout color4Layout = new javax.swing.GroupLayout(color4);
        color4.setLayout(color4Layout);
        color4Layout.setHorizontalGroup(
                color4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color4Layout.setVerticalGroup(
                color4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        color7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color7Event(evt);
            }
        });

        javax.swing.GroupLayout color7Layout = new javax.swing.GroupLayout(color7);
        color7.setLayout(color7Layout);
        color7Layout.setHorizontalGroup(
                color7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color7Layout.setVerticalGroup(
                color7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        color6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color6Event(evt);
            }
        });

        javax.swing.GroupLayout color6Layout = new javax.swing.GroupLayout(color6);
        color6.setLayout(color6Layout);
        color6Layout.setHorizontalGroup(
                color6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color6Layout.setVerticalGroup(
                color6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        color8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color8Event(evt);
            }
        });

        javax.swing.GroupLayout color8Layout = new javax.swing.GroupLayout(color8);
        color8.setLayout(color8Layout);
        color8Layout.setHorizontalGroup(
                color8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color8Layout.setVerticalGroup(
                color8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        color5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color5Event(evt);
            }
        });

        javax.swing.GroupLayout color5Layout = new javax.swing.GroupLayout(color5);
        color5.setLayout(color5Layout);
        color5Layout.setHorizontalGroup(
                color5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color5Layout.setVerticalGroup(
                color5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 60, 50));

        color9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color9Event(evt);
            }
        });

        javax.swing.GroupLayout color9Layout = new javax.swing.GroupLayout(color9);
        color9.setLayout(color9Layout);
        color9Layout.setHorizontalGroup(
                color9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color9Layout.setVerticalGroup(
                color9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 60, 50));

        color10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color10Event(evt);
            }
        });

        javax.swing.GroupLayout color10Layout = new javax.swing.GroupLayout(color10);
        color10.setLayout(color10Layout);
        color10Layout.setHorizontalGroup(
                color10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color10Layout.setVerticalGroup(
                color10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 60, 50));

        color11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color11Event(evt);
            }
        });

        javax.swing.GroupLayout color11Layout = new javax.swing.GroupLayout(color11);
        color11.setLayout(color11Layout);
        color11Layout.setHorizontalGroup(
                color11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color11Layout.setVerticalGroup(
                color11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 60, 50));

        color12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color12Event(evt);
            }
        });

        javax.swing.GroupLayout color12Layout = new javax.swing.GroupLayout(color12);
        color12.setLayout(color12Layout);
        color12Layout.setHorizontalGroup(
                color12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color12Layout.setVerticalGroup(
                color12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        color13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color13Event(evt);
            }
        });

        javax.swing.GroupLayout color13Layout = new javax.swing.GroupLayout(color13);
        color13.setLayout(color13Layout);
        color13Layout.setHorizontalGroup(
                color13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color13Layout.setVerticalGroup(
                color13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 60, 50));

        color14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color14Event(evt);
            }
        });

        javax.swing.GroupLayout color14Layout = new javax.swing.GroupLayout(color14);
        color14.setLayout(color14Layout);
        color14Layout.setHorizontalGroup(
                color14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color14Layout.setVerticalGroup(
                color14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, -1, -1));

        color16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color16Event(evt);
            }
        });

        javax.swing.GroupLayout color16Layout = new javax.swing.GroupLayout(color16);
        color16.setLayout(color16Layout);
        color16Layout.setHorizontalGroup(
                color16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color16Layout.setVerticalGroup(
                color16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        color15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color15Event(evt);
            }
        });

        javax.swing.GroupLayout color15Layout = new javax.swing.GroupLayout(color15);
        color15.setLayout(color15Layout);
        color15Layout.setHorizontalGroup(
                color15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );
        color15Layout.setVerticalGroup(
                color15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(color15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 60, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Xác nhận");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmEvent(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 660, 280, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void backEvent(java.awt.event.MouseEvent evt) {
        previousScreen.setVisible(true);
        this.setVisible(false);
    }

    private void confirmEvent(java.awt.event.MouseEvent evt) {
        jPanel1.setBackground(colorMain);
        jPanel1.repaint();
        jPanel1.revalidate();
        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có muốn đăng xuất để áp dụng màu nền này không?",
                "Đăng xuất?",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            new ConnectDB();
            LoginScreen lg = new LoginScreen();
            lg.setVisible(true);
            this.setVisible(false);
        }

    }

    private void color1Event(java.awt.event.MouseEvent evt) {
        colorMain = color1.getBackground();
    }

    private void color2Event(java.awt.event.MouseEvent evt) {
        colorMain = color2.getBackground();
    }

    private void color3Event(java.awt.event.MouseEvent evt) {
        colorMain = color3.getBackground();
    }

    private void color4Event(java.awt.event.MouseEvent evt) {
        colorMain = color4.getBackground();
    }

    private void color5Event(java.awt.event.MouseEvent evt) {
        colorMain = color5.getBackground();
    }

    private void color6Event(java.awt.event.MouseEvent evt) {
        colorMain = color6.getBackground();
    }

    private void color7Event(java.awt.event.MouseEvent evt) {
        colorMain = color7.getBackground();
    }

    private void color8Event(java.awt.event.MouseEvent evt) {
        colorMain = color8.getBackground();
    }

    private void color9Event(java.awt.event.MouseEvent evt) {
        colorMain = color9.getBackground();
    }

    private void color10Event(java.awt.event.MouseEvent evt) {
        colorMain = color10.getBackground();
    }

    private void color11Event(java.awt.event.MouseEvent evt) {
        colorMain = color11.getBackground();
    }

    private void color12Event(java.awt.event.MouseEvent evt) {
        colorMain = color12.getBackground();
    }

    private void color13Event(java.awt.event.MouseEvent evt) {
        colorMain = color13.getBackground();
    }

    private void color14Event(java.awt.event.MouseEvent evt) {
        colorMain = color14.getBackground();
    }

    private void color15Event(java.awt.event.MouseEvent evt) {
        colorMain = color15.getBackground();
    }

    private void color16Event(java.awt.event.MouseEvent evt) {
        colorMain = color16.getBackground();
    }

    private javax.swing.JPanel color1;
    private javax.swing.JPanel color10;
    private javax.swing.JPanel color11;
    private javax.swing.JPanel color12;
    private javax.swing.JPanel color13;
    private javax.swing.JPanel color14;
    private javax.swing.JPanel color15;
    private javax.swing.JPanel color16;
    private javax.swing.JPanel color2;
    private javax.swing.JPanel color3;
    private javax.swing.JPanel color4;
    private javax.swing.JPanel color5;
    private javax.swing.JPanel color6;
    private javax.swing.JPanel color7;
    private javax.swing.JPanel color8;
    private javax.swing.JPanel color9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
}
