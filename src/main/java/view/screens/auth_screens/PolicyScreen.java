package view.screens.auth_screens;

import utils.Gradient;
import utils.MouseDragCommon;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static commons.ColorMain.*;
import static commons.ColorMain.colorMain3;

public class PolicyScreen extends JFrame {
    private JFrame previousFrame;
    private PolicyScreen policyScreen = this;

    public PolicyScreen(JFrame previousFrame) {
        this.previousFrame = previousFrame;
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        jPanel1 = new Gradient(colorMain1, colorMain2, colorMain3);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(colorDefault);

        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTextArea1.setRows(5);
        jTextArea1.setText("1. Giới thiệu Chào mừng bạn đến với KV Comic. Việc \n bạn sử dụng ứng dụng đồng nghĩa với việc bạn đã \n đồng ý với các điều khoản và chính sách sử dụng sau \n đây. Chúng tôi cam kết mang đến cho bạn trải nghiệm\n đọc truyện tốt nhất, đồng thời bảo vệ quyền lợi và \n thông tin cá nhân của bạn.\n\n2. Quyền và Trách nhiệm Của Người Dùng\n • Bạn phải chịu trách nhiệm về tài khoản và mật khẩu. \n Nếu phát hiện có hành vi truy cập trái phép, bạn cần \n thông báo ngay cho KV Comic.\n • Không sử dụng ứng dụng vào mục đích phi pháp, \n xâm phạm quyền lợi hợp pháp của người khác.\n • Không đăng tải nội dung phản cảm, bạo lực, hoặc vi\n phạm thuần phong mỹ tục.\n • Không thực hiện các hành vi lừa đảo, xâm nhập, phá \n hoại hệ thống của KV Comic.\n\n3. Quyền Sở Hữu Trí Tuệ\n • Toàn bộ nội dung trên KV Comic được bảo vệ bởi \n pháp luật về quyền sở hữu trí tuệ.\n • Nghiêm cấm sao chép, phân phát, sửa đổi nội dung\n khi chưa có đồng ý bằng văn bản từ KV Comic.\n • Các tác giả có quyền đối với tác phẩm của mình khi\n đăng tải trên KV Comic. Người dùng phải tôn trọng\n quyền tác giả và không được sử dụng lại nội dung vì\n mục đích thương mại khi chưa có sự cho phép.\n\n4. Quyền Riêng Tư\n • Thông tin cá nhân của bạn sẽ được bảo mật và chỉ\n sử dụng vào mục đích phát triển, nâng cao chất lượng\n dịch vụ.\n • Chúng tôi không cung cấp thông tin cá nhân của bạn\n cho bên thứ ba khi chưa có sự đồng ý của bạn.\n • KV Comic áp dụng các biện pháp bảo mật hiện đại\n nhằm đảm bảo thông tin người dùng không bị rò rỉ,\n đánh cắp.\n • Người dùng có quyền yêu cầu chỉnh sửa hoặc xóa\n thông tin cá nhân khi cần thiết.\n\n5. Giới Hạn Trách Nhiệm\n • KV Comic không chịu trách nhiệm với bất kỳ thiệt hại\n nào phát sinh từ việc bạn sử dụng nội dung trên ứng\n dụng.\n • Chúng tôi không đảm bảo ứng dụng sẽ hoạt động\n liên tục, không có lỗi. Trong trường hợp xảy ra sự cố\n kỹ thuật, KV Comic sẽ cố gắng khắc phục trong thời\n gian sớm nhất.\n • KV Comic không chịu trách nhiệm với nội dung do\n người dùng đăng tải. Tuy nhiên, chúng tôi có quyền\n xóa bỏ các nội dung vi phạm mà không cần thông\n báo trước.\n\n6. Thay Đổi Điều Khoản\n • KV Comic có quyền thay đổi nội dung điều khoản và\n chính sách bất kỳ lúc nào.\n • Mọi thay đổi sẽ được thông báo trên ứng dụng hoặc\n qua đường dẫn thông báo.\n • Người dùng cần thường xuyên theo dõi để cập nhật\n những thay đổi mới nhất. Việc tiếp tục sử dụng ứng\n dụng sau khi có thay đổi đồng nghĩa với việc bạn\n chấp nhận các nội dung cập nhật đó.\n\n7.Liên Hệ Mọi thông tin thắc mắc, khiếu nại về điều\n khoản và chính sách, vui lòng liên hệ qua email:\n support@kvcomic.com. Bạn cũng có thể liên hệ qua\n hotline hỗ trợ khách hàng: 1900 123 456 để được\n giải đáp nhanh chóng.\n\n8.Định Nghĩa và Giải Thích Thuật Ngữ\n • \"KV Comic\": là ứng dụng đọc truyện trực tuyến cung\n cấp các nội dung truyện tranh từ nhiều tác giả khác\n nhau.\n • \"Người dùng\": là cá nhân hoặc tổ chức sử dụng dịch\n vụ của KV Comic.\n • \"Nội dung\": bao gồm tất cả các bài viết, truyện tranh,\n hình ảnh, video, bình luận, và các thông tin khác trên\n ứng dụng.\n\n\n");
        jTextArea1.setBorder(null);
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Điều khoản và chính sách");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel2.setText("<");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jTextArea1.setBackground(colorFix);
        backEvent();
        mouseDrag();
        SwingUtilities.invokeLater(() -> {
            jTextArea1.setCaretPosition(0);
        });


        pack();
    }

    private void backEvent(){
        jLabel2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                previousFrame.setVisible(true);
                policyScreen.setVisible(false);
            }
        });
    }
    private void mouseDrag(){
        MouseDragCommon mouseDragCommon = new MouseDragCommon(jScrollPane1, 1.5, 80, true);
        jTextArea1.addMouseListener(mouseDragCommon);
        jTextArea1.addMouseMotionListener(mouseDragCommon);
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
}
