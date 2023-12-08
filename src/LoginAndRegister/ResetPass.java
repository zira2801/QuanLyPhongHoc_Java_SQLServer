/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package LoginAndRegister;

import Database.Connect_DB;
import TrangHome.ToanCuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ResetPass extends javax.swing.JFrame {

    /**
     * Creates new form ResetPass
     */
    public ResetPass() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        right = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NhapLaiMK = new javax.swing.JPasswordField();
        DongYReset = new javax.swing.JButton();
        BackVe = new javax.swing.JButton();
        txtMatKhauMoi = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(800, 500));
        bg.setLayout(null);

        right.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(56, 161, 222));
        jLabel3.setText("Đặt lại mật khẩu");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mật khẩu mới:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nhập lại mật khẩu:");

        NhapLaiMK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        DongYReset.setBackground(new java.awt.Color(56, 161, 222));
        DongYReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DongYReset.setForeground(new java.awt.Color(255, 255, 255));
        DongYReset.setText("Đồng ý");
        DongYReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DongYResetActionPerformed(evt);
            }
        });

        BackVe.setBackground(new java.awt.Color(56, 161, 222));
        BackVe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BackVe.setForeground(new java.awt.Color(255, 255, 255));
        BackVe.setText("Trở về");
        BackVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackVeActionPerformed(evt);
            }
        });

        txtMatKhauMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightLayout.createSequentialGroup()
                        .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(rightLayout.createSequentialGroup()
                                .addComponent(DongYReset, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(BackVe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
                            .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(NhapLaiMK)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))))
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(NhapLaiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DongYReset, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackVe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        bg.add(right);
        right.setBounds(170, 10, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DongYResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DongYResetActionPerformed

        Connect_DB cn = new Connect_DB();
        char[] matKhauChars = NhapLaiMK.getPassword();
        char[] matkhaumoi = txtMatKhauMoi.getPassword();
        String matKhau = new String(matKhauChars);
        String matKhauMoi = new String(matkhaumoi);
        int avatar = 0;
        try{
            ToanCuc tt = new ToanCuc();
    Connection conn = cn.getConnection();
    if (matkhaumoi.equals("") || matKhauChars.equals("")) {
        JOptionPane.showMessageDialog(this, "Bạn phải nhập đủ thông tin");
        // Xét điều kiện nếu txt trống thì báo lỗi lên
    } else {
        if (matKhau.length() < 8) {
            JOptionPane.showMessageDialog(this, "Mật khẩu phải có ít nhất 8 ký tự");
        } else {
            if (!matKhau.matches(".*[a-zA-Z].*")) {
                JOptionPane.showMessageDialog(this, "Mật khẩu phải chứa ít nhất 1 chữ cái");
            } else {
                if (!matKhau.matches(".*\\d+.*")) {
                    JOptionPane.showMessageDialog(this, "Mật khẩu phải chứa ít nhất 1 số");
                } else {
                    if (matKhauMoi.equals(matKhau)) {
                        String sql = "UPDATE TaiKhoan SET tkpassword = ? WHERE Email = ?";
                        PreparedStatement statement = conn.prepareStatement(sql);
                        statement.setString(1, matKhauMoi);
                        statement.setString(2, tt.getEmail());
                        int rowCount = statement.executeUpdate();
                        if (rowCount > 0) {
                            JOptionPane.showMessageDialog(this, "Đặt lại mật khẩu thành công");
                            LoginForm login = new LoginForm();
                            login.setVisible(true);
                            login.pack();
                            login.setLocationRelativeTo(null);
                            this.dispose();
                            tt.setEmail(null);
                        } else {
                            JOptionPane.showMessageDialog(this, "Không thành công khi cập nhật mật khẩu");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không đúng");
                    }
                }
            }
        }
    }
        } catch(Exception ex){
            // Handle database errors
            JOptionPane.showMessageDialog(this, "Lỗi khi đăng ký tài khoản: " + ex.getMessage());
        }
    }//GEN-LAST:event_DongYResetActionPerformed

    private void BackVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackVeActionPerformed
        // TODO add your handling code here:
        QuenMK qmk = new QuenMK();
        qmk.setVisible(true);
        qmk.pack();
        qmk.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BackVeActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ResetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResetPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackVe;
    private javax.swing.JButton DongYReset;
    private javax.swing.JPasswordField NhapLaiMK;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel right;
    private javax.swing.JPasswordField txtMatKhauMoi;
    // End of variables declaration//GEN-END:variables
}