/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Controller;

import DAO.DAO;
import Other.Check;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author trieu
 */
public class ThemPhong_Dialog extends javax.swing.JDialog {

    /**
     * Creates new form ThemPhong_Dialog
     */
    public ThemPhong_Dialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jLabel3 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenPhong = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mã Phòng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tên Phòng");

        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/SAVE50.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLuu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLuu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnLuuMouseMoved(evt);
            }
        });
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLuuMouseExited(evt);
            }
        });
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaPhong))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLuu)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaPhong)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenPhong)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        Check check = new Check();
        DAO dao = new DAO();
        if (txtMaPhong.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Mã phòng đang để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaPhong.requestFocus();
        } else if (!check.kiemTraChuoi1(txtMaPhong.getText())) {
            JOptionPane.showMessageDialog(null, "Mã phòng không được chứa kí tự khác ngoài chữ và số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaPhong.requestFocus();
        } else if (!dao.Check_Phong_Trung(txtMaPhong.getText())) {
            JOptionPane.showMessageDialog(null, "Mã phòng đã tồn tại từ trước", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaPhong.requestFocus();
        } else if (txtTenPhong.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tên phòng đang để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtTenPhong.requestFocus();
        } else if (!check.isValidString(txtTenPhong.getText())) {
            JOptionPane.showMessageDialog(null, "Tên phòng không được chứa kí tự đặc biệt!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtTenPhong.requestFocus();
        } else {
            txtTenPhong.setText(check.formatName(txtTenPhong.getText()));
            int option = JOptionPane.showConfirmDialog(null, "Bạn vẫn muốn thêm phòng này!", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                boolean a = dao.add_Phong(txtMaPhong.getText(), txtTenPhong.getText());
                JOptionPane.showConfirmDialog(null, "Lưu thành công!", "Thông báo", JOptionPane.OK_OPTION);
                this.setVisible(false);
            } else {
                JOptionPane.showConfirmDialog(null, "Lưu không thành công!", "Thông báo", JOptionPane.OK_OPTION);

            }
        }

    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnLuuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseExited
       btnLuu.setBackground(Color.white);
        btnLuu.setForeground(Color.black);
    }//GEN-LAST:event_btnLuuMouseExited

    private void btnLuuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseMoved
        btnLuu.setBackground(Color.blue);
        btnLuu.setForeground(Color.white);
    }//GEN-LAST:event_btnLuuMouseMoved

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
            java.util.logging.Logger.getLogger(ThemPhong_Dialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemPhong_Dialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemPhong_Dialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemPhong_Dialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemPhong_Dialog dialog = new ThemPhong_Dialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtTenPhong;
    // End of variables declaration//GEN-END:variables
}
