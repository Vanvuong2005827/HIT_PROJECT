package view.screens.account_screens;

import dao.ConnectDB;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import utils.Gradient;
import view.screens.auth_screens.LoginScreen;

import javax.swing.*;

import java.awt.*;

import static commons.ColorMain.*;
import static commons.CurrentUser.userServices;
import static utils.NetworkChecker.curFrame;

public class ChangeThemeScreen extends javax.swing.JFrame {
    private JFrame previousScreen;

    public ChangeThemeScreen(JFrame jf) {
        previousScreen = jf;
        initComponents();
        setLocationRelativeTo(null);
        curFrame = this;
    }

    private void initComponents() {
        jPanel1 = new Gradient(colorMain1, colorMain2, colorMain3);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        color1 = new Gradient(listColorGradient.get(0).getColor1(), listColorGradient.get(0).getColor2(), listColorGradient.get(0).getColor3());
        color2 = new Gradient(listColorGradient.get(1).getColor1(), listColorGradient.get(1).getColor2(), listColorGradient.get(1).getColor3());
        color3 = new Gradient(listColorGradient.get(2).getColor1(), listColorGradient.get(2).getColor2(), listColorGradient.get(2).getColor3());
        color4 = new Gradient(listColorGradient.get(3).getColor1(), listColorGradient.get(3).getColor2(), listColorGradient.get(3).getColor3());
        color5 = new Gradient(listColorGradient.get(4).getColor1(), listColorGradient.get(4).getColor2(), listColorGradient.get(4).getColor3());
        color6 = new Gradient(listColorGradient.get(5).getColor1(), listColorGradient.get(5).getColor2(), listColorGradient.get(5).getColor3());
        color7 = new Gradient(listColorGradient.get(6).getColor1(), listColorGradient.get(6).getColor2(), listColorGradient.get(6).getColor3());
        color8 = new Gradient(listColorGradient.get(7).getColor1(), listColorGradient.get(7).getColor2(), listColorGradient.get(7).getColor3());
        color9 = new Gradient(listColorGradient.get(8).getColor1(), listColorGradient.get(8).getColor2(), listColorGradient.get(8).getColor3());
        color10 = new Gradient(listColorGradient.get(9).getColor1(), listColorGradient.get(9).getColor2(), listColorGradient.get(9).getColor3());
        color11 = new Gradient(listColorGradient.get(10).getColor1(), listColorGradient.get(10).getColor2(), listColorGradient.get(10).getColor3());
        color12 = new Gradient(listColorGradient.get(11).getColor1(), listColorGradient.get(11).getColor2(), listColorGradient.get(11).getColor3());
        color13 = new Gradient(listColorGradient.get(12).getColor1(), listColorGradient.get(12).getColor2(), listColorGradient.get(12).getColor3());
        color14 = new Gradient(listColorGradient.get(13).getColor1(), listColorGradient.get(13).getColor2(), listColorGradient.get(13).getColor3());
        color15 = new Gradient(listColorGradient.get(14).getColor1(), listColorGradient.get(14).getColor2(), listColorGradient.get(14).getColor3());
        color16 = new Gradient(listColorGradient.get(15).getColor1(), listColorGradient.get(15).getColor2(), listColorGradient.get(15).getColor3());
        color17 = new Gradient(listColorGradient.get(16).getColor1(), listColorGradient.get(16).getColor2(), listColorGradient.get(16).getColor3());
        color18 = new Gradient(listColorGradient.get(17).getColor1(), listColorGradient.get(17).getColor2(), listColorGradient.get(17).getColor3());
        color19 = new Gradient(listColorGradient.get(18).getColor1(), listColorGradient.get(18).getColor2(), listColorGradient.get(18).getColor3());
        color20 = new Gradient(listColorGradient.get(19).getColor1(), listColorGradient.get(19).getColor2(), listColorGradient.get(19).getColor3());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        color1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color1Event(evt);
            }
        });

        javax.swing.GroupLayout color1Layout = new javax.swing.GroupLayout(color1);
        color1.setLayout(color1Layout);
        color1Layout.setHorizontalGroup(color1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color1Layout.setVerticalGroup(color1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

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
        color2Layout.setHorizontalGroup(color2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color2Layout.setVerticalGroup(color2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 60, 50));

        color4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color4Event(evt);
            }
        });

        javax.swing.GroupLayout color3Layout = new javax.swing.GroupLayout(color4);
        color4.setLayout(color3Layout);
        color3Layout.setHorizontalGroup(color3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color3Layout.setVerticalGroup(color3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 60, 50));

        color3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color3Event(evt);
            }
        });

        javax.swing.GroupLayout color4Layout = new javax.swing.GroupLayout(color3);
        color3.setLayout(color4Layout);
        color4Layout.setHorizontalGroup(color4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color4Layout.setVerticalGroup(color4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        color6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color6Event(evt);
            }
        });

        javax.swing.GroupLayout color7Layout = new javax.swing.GroupLayout(color6);
        color6.setLayout(color7Layout);
        color7Layout.setHorizontalGroup(color7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color7Layout.setVerticalGroup(color7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        color7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color7Event(evt);
            }
        });

        javax.swing.GroupLayout color6Layout = new javax.swing.GroupLayout(color7);
        color7.setLayout(color6Layout);
        color6Layout.setHorizontalGroup(color6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color6Layout.setVerticalGroup(color6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        color5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color5Event(evt);
            }
        });

        javax.swing.GroupLayout color8Layout = new javax.swing.GroupLayout(color5);
        color5.setLayout(color8Layout);
        color8Layout.setHorizontalGroup(color8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color8Layout.setVerticalGroup(color8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        color8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color8Event(evt);
            }
        });

        javax.swing.GroupLayout color5Layout = new javax.swing.GroupLayout(color8);
        color8.setLayout(color5Layout);
        color5Layout.setHorizontalGroup(color5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color5Layout.setVerticalGroup(color5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 60, 50));

        color9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color9Event(evt);
            }
        });

        javax.swing.GroupLayout color9Layout = new javax.swing.GroupLayout(color9);
        color9.setLayout(color9Layout);
        color9Layout.setHorizontalGroup(color9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color9Layout.setVerticalGroup(color9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 60, 50));

        color10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color10Event(evt);
            }
        });

        javax.swing.GroupLayout color10Layout = new javax.swing.GroupLayout(color10);
        color10.setLayout(color10Layout);
        color10Layout.setHorizontalGroup(color10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color10Layout.setVerticalGroup(color10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 60, 50));

        color12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color12Event(evt);
            }
        });

        javax.swing.GroupLayout color11Layout = new javax.swing.GroupLayout(color12);
        color12.setLayout(color11Layout);
        color11Layout.setHorizontalGroup(color11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color11Layout.setVerticalGroup(color11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 60, 50));

        color11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color11Event(evt);
            }
        });

        javax.swing.GroupLayout color12Layout = new javax.swing.GroupLayout(color11);
        color11.setLayout(color12Layout);
        color12Layout.setHorizontalGroup(color12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color12Layout.setVerticalGroup(color12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        color16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color16Event(evt);
            }
        });

        javax.swing.GroupLayout color13Layout = new javax.swing.GroupLayout(color16);
        color16.setLayout(color13Layout);
        color13Layout.setHorizontalGroup(color13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color13Layout.setVerticalGroup(color13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 60, 50));

        color15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color15Event(evt);
            }
        });

        javax.swing.GroupLayout color14Layout = new javax.swing.GroupLayout(color15);
        color15.setLayout(color14Layout);
        color14Layout.setHorizontalGroup(color14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color14Layout.setVerticalGroup(color14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, -1, -1));

        color13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color13Event(evt);
            }
        });

        javax.swing.GroupLayout color16Layout = new javax.swing.GroupLayout(color13);
        color13.setLayout(color16Layout);
        color16Layout.setHorizontalGroup(color16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color16Layout.setVerticalGroup(color16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        color14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color14Event(evt);
            }
        });

        javax.swing.GroupLayout color15Layout = new javax.swing.GroupLayout(color14);
        color14.setLayout(color15Layout);
        color15Layout.setHorizontalGroup(color15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color15Layout.setVerticalGroup(color15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));

        jPanel1.add(color14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 60, 50));

        color17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color17Event(evt);
            }
        });
        javax.swing.GroupLayout color17Layout = new javax.swing.GroupLayout(color17);
        color17.setLayout(color17Layout);
        color17Layout.setHorizontalGroup(color17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color17Layout.setVerticalGroup(color17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));
        jPanel1.add(color17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 60, 50));

        color18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color18Event(evt);
            }
        });
        javax.swing.GroupLayout color18Layout = new javax.swing.GroupLayout(color18);
        color18.setLayout(color18Layout);
        color18Layout.setHorizontalGroup(color18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color18Layout.setVerticalGroup(color18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));
        jPanel1.add(color18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 60, 50));

        color19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color19Event(evt);
            }
        });
        javax.swing.GroupLayout color19Layout = new javax.swing.GroupLayout(color19);
        color19.setLayout(color19Layout);
        color19Layout.setHorizontalGroup(color19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color19Layout.setVerticalGroup(color19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));
        jPanel1.add(color19, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 60, 50));

        color20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                color20Event(evt);
            }
        });
        javax.swing.GroupLayout color20Layout = new javax.swing.GroupLayout(color20);
        color20.setLayout(color20Layout);
        color20Layout.setHorizontalGroup(color20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 60, Short.MAX_VALUE));
        color20Layout.setVerticalGroup(color20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 50, Short.MAX_VALUE));
        jPanel1.add(color20, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, 60, 50));


        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Xác nhận ");
        jLabel3.setIcon(IconFontSwing.buildIcon(FontAwesome.CHECK, 23, Color.black));
        jLabel3.setHorizontalTextPosition(SwingConstants.LEFT);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    confirmEvent(evt);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi kết nối mạng! Vui lòng kiểm tra Internet.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 660, 280, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE));

        pack();
    }

    private void backEvent(java.awt.event.MouseEvent evt) {
        previousScreen.setVisible(true);
        this.setVisible(false);
    }

    private void confirmEvent(java.awt.event.MouseEvent evt) throws Exception {
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất để áp dụng màu nền này không?", "Đăng xuất?", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            userServices.updateGradientColorToUser(colorMain1, colorMain2, colorMain3, colorFix);
            new ConnectDB();
            LoginScreen lg = new LoginScreen();
            lg.setVisible(true);
            this.setVisible(false);
        }

    }

    private void color1Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(0).getColor1();
        colorMain2 = listColorGradient.get(0).getColor2();
        colorMain3 = listColorGradient.get(0).getColor3();
        colorFix = listColorGradient.get(0).getColor4();
    }

    private void color2Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(1).getColor1();
        colorMain2 = listColorGradient.get(1).getColor2();
        colorMain3 = listColorGradient.get(1).getColor3();
        colorFix = listColorGradient.get(1).getColor4();
    }

    private void color3Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(2).getColor1();
        colorMain2 = listColorGradient.get(2).getColor2();
        colorMain3 = listColorGradient.get(2).getColor3();
        colorFix = listColorGradient.get(2).getColor4();
    }

    private void color4Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(3).getColor1();
        colorMain2 = listColorGradient.get(3).getColor2();
        colorMain3 = listColorGradient.get(3).getColor3();
        colorFix = listColorGradient.get(3).getColor4();
    }

    private void color5Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(4).getColor1();
        colorMain2 = listColorGradient.get(4).getColor2();
        colorMain3 = listColorGradient.get(4).getColor3();
        colorFix = listColorGradient.get(4).getColor4();
    }

    private void color6Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(5).getColor1();
        colorMain2 = listColorGradient.get(5).getColor2();
        colorMain3 = listColorGradient.get(5).getColor3();
        colorFix = listColorGradient.get(5).getColor4();
    }

    private void color7Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(6).getColor1();
        colorMain2 = listColorGradient.get(6).getColor2();
        colorMain3 = listColorGradient.get(6).getColor3();
        colorFix = listColorGradient.get(6).getColor4();
    }

    private void color8Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(7).getColor1();
        colorMain2 = listColorGradient.get(7).getColor2();
        colorMain3 = listColorGradient.get(7).getColor3();
        colorFix = listColorGradient.get(7).getColor4();
    }

    private void color9Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(8).getColor1();
        colorMain2 = listColorGradient.get(8).getColor2();
        colorMain3 = listColorGradient.get(8).getColor3();
        colorFix = listColorGradient.get(8).getColor4();
    }

    private void color10Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(9).getColor1();
        colorMain2 = listColorGradient.get(9).getColor2();
        colorMain3 = listColorGradient.get(9).getColor3();
        colorFix = listColorGradient.get(9).getColor4();
    }

    private void color11Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(10).getColor1();
        colorMain2 = listColorGradient.get(10).getColor2();
        colorMain3 = listColorGradient.get(10).getColor3();
        colorFix = listColorGradient.get(10).getColor4();
    }

    private void color12Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(11).getColor1();
        colorMain2 = listColorGradient.get(11).getColor2();
        colorMain3 = listColorGradient.get(11).getColor3();
        colorFix = listColorGradient.get(11).getColor4();
    }

    private void color13Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(12).getColor1();
        colorMain2 = listColorGradient.get(12).getColor2();
        colorMain3 = listColorGradient.get(12).getColor3();
        colorFix = listColorGradient.get(12).getColor4();
    }

    private void color14Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(13).getColor1();
        colorMain2 = listColorGradient.get(13).getColor2();
        colorMain3 = listColorGradient.get(13).getColor3();
        colorFix = listColorGradient.get(13).getColor4();
    }

    private void color15Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(14).getColor1();
        colorMain2 = listColorGradient.get(14).getColor2();
        colorMain3 = listColorGradient.get(14).getColor3();
        colorFix = listColorGradient.get(14).getColor4();
    }

    private void color16Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(15).getColor1();
        colorMain2 = listColorGradient.get(15).getColor2();
        colorMain3 = listColorGradient.get(15).getColor3();
        colorFix = listColorGradient.get(15).getColor4();
    }

    private void color17Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(16).getColor1();
        colorMain2 = listColorGradient.get(16).getColor2();
        colorMain3 = listColorGradient.get(16).getColor3();
        colorFix = listColorGradient.get(16).getColor4();
    }

    private void color18Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(17).getColor1();
        colorMain2 = listColorGradient.get(17).getColor2();
        colorMain3 = listColorGradient.get(17).getColor3();
        colorFix = listColorGradient.get(17).getColor4();
    }

    private void color19Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(18).getColor1();
        colorMain2 = listColorGradient.get(18).getColor2();
        colorMain3 = listColorGradient.get(18).getColor3();
        colorFix = listColorGradient.get(18).getColor4();
    }

    private void color20Event(java.awt.event.MouseEvent evt) {
        colorMain1 = listColorGradient.get(19).getColor1();
        colorMain2 = listColorGradient.get(19).getColor2();
        colorMain3 = listColorGradient.get(19).getColor3();
        colorFix = listColorGradient.get(19).getColor4();
    }

    private javax.swing.JPanel color1;
    private javax.swing.JPanel color10;
    private javax.swing.JPanel color12;
    private javax.swing.JPanel color11;
    private javax.swing.JPanel color16;
    private javax.swing.JPanel color15;
    private javax.swing.JPanel color14;
    private javax.swing.JPanel color13;
    private javax.swing.JPanel color2;
    private javax.swing.JPanel color4;
    private javax.swing.JPanel color3;
    private javax.swing.JPanel color8;
    private javax.swing.JPanel color7;
    private javax.swing.JPanel color6;
    private javax.swing.JPanel color5;
    private javax.swing.JPanel color9;
    private javax.swing.JPanel color17;
    private javax.swing.JPanel color18;
    private javax.swing.JPanel color19;
    private javax.swing.JPanel color20;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
}
