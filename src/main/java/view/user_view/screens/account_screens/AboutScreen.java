package view.user_view.screens.account_screens;

import controllers.account.AboutController;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import utils.Gradient;

import javax.swing.*;

import java.awt.*;

import static commons.ColorMain.*;

public class AboutScreen  extends JFrame {

    public AboutScreen(JFrame previousScreen){
        initComponents();
        setLocationRelativeTo(null);
        new AboutController(previousScreen, this);
    }

    private void initComponents() {

        jPanel2 = new Gradient(colorMain1, colorMain2, colorMain3);
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        email1 = new javax.swing.JLabel();
        facebook1 = new javax.swing.JLabel();
        github1 = new javax.swing.JLabel();
        PhoneNumber1 = new javax.swing.JLabel();
        PhoneNumber2 = new javax.swing.JLabel();
        email2 = new javax.swing.JLabel();
        github2 = new javax.swing.JLabel();
        facebook2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        policy = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        linkGithub = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel3.setText("Điều khoản và Chính sách");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 230, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel4.setText("<");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel1.setText("2. Đinh Văn Vượng (2005)");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 340, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel2.setText("Tên truyên: KV Comic - Truyện tranh online");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 300, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel5.setText("Phiên bản: v1.0.0");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel6.setText("Thông tin ứng dụng:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel7.setText("Ngày hoàn thành: 19/2/2025");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 200, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel8.setText("Nhóm HIT ThreeJS gồm 2 thành viên :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 250, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel9.setText("1. Phạm Minh Khương (2005)");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 340, 20));
        jPanel2.add(email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 60, 40));
        jPanel2.add(facebook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 60, 40));
        jPanel2.add(github1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 60, 40));
        jPanel2.add(PhoneNumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 60, 40));
        jPanel2.add(PhoneNumber2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, 60, 40));
        jPanel2.add(email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, 60, 40));
        jPanel2.add(github2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 60, 40));
        jPanel2.add(facebook2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 60, 40));

        jLabel11.setText("Hiện đang học chuyên ngành Kĩ Thuật Phần Mềm tại Đại học Công Nghiệp");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 410, -1));

        jLabel10.setText("Hà Nội.");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 50, -1));

        jLabel12.setText("Hiện đang học chuyên ngành Công Nghệ Thông Tin tại Đại học Công Nghiệp");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 420, -1));

        jLabel13.setText("Hà Nội.");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 50, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel14.setText("Thông tin tác giả:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 180, 30));

        policy.setFont(new java.awt.Font("Segoe UI", 2, 12));
        policy.setText("Điều khoản và chính sách");
        jPanel2.add(policy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 180, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel15.setText("Email hỗ trợ:  wu.kongv1999@gmail.com");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 280, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel16.setText("Link github: ");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 80, -1));

        jLabel17.setText("Copyright © 2025 KhuongVuongComic");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 760, 220, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel18.setText("Xin cảm ơn các bạn đã tin tưởng và sử dụng ứng dụng !");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 720, 320, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel19.setText("Xin cảm ơn những người đã giúp đỡ chúng mình hoàn thiện dự án !");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, 380, -1));

        linkGithub.setFont(new java.awt.Font("Segoe UI", 2, 14));
        linkGithub.setText("https://github.com/Vanvuong2005827/HIT_PROJECT");
        jPanel2.add(linkGithub, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 340, 20));

        jPanel1.setBackground(colorMain3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 790, 320, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        facebook1.setIcon(IconFontSwing.buildIcon(FontAwesome.FACEBOOK, 30, Color.black));
        facebook2.setIcon(IconFontSwing.buildIcon(FontAwesome.FACEBOOK, 30, Color.black));
        github1.setIcon(IconFontSwing.buildIcon(FontAwesome.GITHUB, 30, Color.black));
        github2.setIcon(IconFontSwing.buildIcon(FontAwesome.GITHUB, 30, Color.black));
        email1.setIcon(IconFontSwing.buildIcon(FontAwesome.ENVELOPE, 30, Color.black));
        email2.setIcon(IconFontSwing.buildIcon(FontAwesome.ENVELOPE, 30, Color.black));
        PhoneNumber1.setIcon(IconFontSwing.buildIcon(FontAwesome.PHONE, 30, Color.black));
        PhoneNumber2.setIcon(IconFontSwing.buildIcon(FontAwesome.PHONE, 30, Color.black));


        pack();
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel PhoneNumber1;
    private javax.swing.JLabel PhoneNumber2;
    private javax.swing.JLabel email1;
    private javax.swing.JLabel email2;
    private javax.swing.JLabel facebook1;
    private javax.swing.JLabel facebook2;
    private javax.swing.JLabel github1;
    private javax.swing.JLabel github2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel linkGithub;
    private javax.swing.JLabel policy;

    public JLabel getPhoneNumber1() {
        return PhoneNumber1;
    }

    public JLabel getPhoneNumber2() {
        return PhoneNumber2;
    }

    public JLabel getEmail1() {
        return email1;
    }

    public JLabel getEmail2() {
        return email2;
    }

    public JLabel getFacebook2() {
        return facebook2;
    }

    public JLabel getFacebook1() {
        return facebook1;
    }

    public JLabel getGithub1() {
        return github1;
    }

    public JLabel getGithub2() {
        return github2;
    }

    public JLabel getLinkGithub() {
        return linkGithub;
    }

    public JLabel getPolicy() {
        return policy;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }
}
