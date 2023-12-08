
 
package LoginAndRegister;


import Database.Connect_DB;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register extends javax.swing.JFrame {
    String duongdananh = null;
    public Register() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        left = new javax.swing.JPanel();
        hanhAVATAR = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        right = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenTK = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        DangKy = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REGISTER");
        setPreferredSize(new java.awt.Dimension(800, 500));

        bg.setBackground(new java.awt.Color(204, 204, 204));
        bg.setPreferredSize(new java.awt.Dimension(800, 500));
        bg.setLayout(null);

        left.setBackground(new java.awt.Color(255, 255, 255));

        hanhAVATAR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hanhAVATAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setBackground(new java.awt.Color(56, 161, 222));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Chọn ảnh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 161, 222));
        jLabel1.setText("Avatar");

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                        .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hanhAVATAR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)))
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(154, 154, 154))))
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(hanhAVATAR, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );

        bg.add(left);
        left.setBounds(0, 0, 400, 500);

        right.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(56, 161, 222));
        jLabel3.setText("Đăng ký");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên:");

        txtTenTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Email:");

        txtTenEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mật khẩu:");

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        DangKy.setBackground(new java.awt.Color(56, 161, 222));
        DangKy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DangKy.setForeground(new java.awt.Color(255, 255, 255));
        DangKy.setText("Đăng ký");
        DangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangKyActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(56, 161, 222));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Trở về");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(146, 146, 146))
            .addGroup(rightLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenTK)
                    .addComponent(txtTenEmail)
                    .addComponent(txtMatKhau)
                    .addComponent(jLabel6)
                    .addGroup(rightLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(DangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtTenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtTenEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        bg.add(right);
        right.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
      LoginForm login = new LoginForm();
      login.setVisible(true);
      login.pack();
      login.setLocationRelativeTo(null);
      this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void DangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangKyActionPerformed

        Connect_DB cn = new Connect_DB();
        char[] matKhauChars = txtMatKhau.getPassword();
        String matKhau = new String(matKhauChars);
        try{
            Connection conn = cn.getConnection();
            if(txtTenTK.getText().equals("") || txtTenEmail.getText().equals("") || matKhau.equals("") || hanhAVATAR.getIcon() == null){
                JOptionPane.showMessageDialog(this,"Bạn phải nhập đủ thông tin");
                //Xét điều kiện nếu txt trống thì báo lỗi lên
            }
            else{
                String myemail = txtTenEmail.getText();
                String email = "@gmail.com";
                if(!myemail.endsWith(email))
                {
                    JOptionPane.showMessageDialog(this,"Email nhập phải có dạng example@gmail.com");
                }
                else{
                    int atIndex = myemail.indexOf(email);
                    if(atIndex >= 0){
                        String userName = myemail.substring(0, atIndex);
                    if(userName.isEmpty()){
                       JOptionPane.showMessageDialog(this,"Email bạn nhập không hợp lệ");
                    }
                    else{
                        if(matKhau.length()< 8){
                            JOptionPane.showMessageDialog(this,"Mật khẩu nhập từ 8 chữ số trở lên");
                        }
                        else{
                            if(!matKhau.matches(".*[a-zA-Z].*")){
                           JOptionPane.showMessageDialog(this,"Mật khẩu nhập phải có ít nhất 1 chữ cái");
                       }
                       else{
                                if(!matKhau.matches(".*\\d+.*")){
                                    JOptionPane.showMessageDialog(this,"Mật khẩu nhập phải có ít nhất 1 số");
                                }
                                else{
                                 String sql = "select Email from TaiKhoan where Email='"+txtTenEmail.getText()+"'";
                           PreparedStatement statement =  conn.prepareCall(sql);
                            ResultSet resultSet = statement.executeQuery();
                           if (resultSet.next()) {
                           JOptionPane.showMessageDialog(this, "Email đã được sử dụng");
            
                        }
                        else{  
                          String insert = "INSERT INTO TaiKhoan(Email, tkpassword, Ten,avatar) VALUES (?,?,?,?)";
                           PreparedStatement insertStatement = conn.prepareCall(insert);
                          insertStatement.setString(1,txtTenEmail.getText() );
                          insertStatement.setString(2, matKhau);
                          insertStatement.setString(3, txtTenTK.getText());
                          InputStream is = new FileInputStream(new File(duongdananh));
                            insertStatement.setBlob(4, is);
                          insertStatement.executeUpdate();
                          JOptionPane.showMessageDialog(this, "Đăng ký tài khoản thành công");
                          xoatrang();
                    LoginForm login = new LoginForm();
                    login.setVisible(true);
                    login.pack();
                    login.setLocationRelativeTo(null);
                    this.dispose();
                } 
            }
                       
        }
                        
    }
}   
}
 else{
     JOptionPane.showMessageDialog(this, "Email bạn nhập không hợp lệ");             
}
                    
}
                           
}   
    } catch(Exception ex){
            // Handle database errors
       JOptionPane.showMessageDialog(this, "Lỗi khi đăng ký tài khoản: " + ex.getMessage());
        }
    }//GEN-LAST:event_DangKyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser f = new JFileChooser();
            f.setDialogTitle("Mở file ảnh");
            f.showOpenDialog(null);
            File ftenanh = f.getSelectedFile();
            if(ftenanh != null){
                String path = ftenanh.getAbsolutePath();
           try{
               BufferedImage bi = ImageIO.read(new File(path));
               Image img = bi.getScaledInstance(184, 225, Image.SCALE_SMOOTH);
               ImageIcon icon  =new ImageIcon(img);
               hanhAVATAR.setIcon(icon);
               JOptionPane.showMessageDialog(this, "Chọn ảnh thành công"); 
               duongdananh = path;
           } 
        catch(Exception ex){
            System.out.println("Chưa chọn ảnh");
            System.out.println(duongdananh);
        }
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void xoatrang(){
        txtTenEmail.setText("");
        txtMatKhau.setText("");
        txtTenTK.setText("");
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DangKy;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel hanhAVATAR;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel left;
    private javax.swing.JPanel right;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenEmail;
    private javax.swing.JTextField txtTenTK;
    // End of variables declaration//GEN-END:variables
}
