/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Controller;

import static Controller.Edit_TB_Dialog.id_tb;
import DAO.*;
import Models.*;
import Other.Check;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author trieu
 */
public class Edit_SoSeri_Dialog extends javax.swing.JDialog {

    /**
     * Creates new form Dialog_EditSoseri
     */
    DAO dao = new DAO();

    public Edit_SoSeri_Dialog(java.awt.Frame parent, boolean modal, String soseri) {
        super(parent, modal);
        initComponents();

        SoSeriModels seri = dao.get_ALL_Soseri_From_Soseri(soseri);
        txtSoSeri.setText(soseri);
        int Gia = seri.getGia();
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(Gia);
        txtGia.setText(str1);
        int tt = seri.getTrangThai();
        if (tt == 1) {
            txtTrangThai.setText("Bình thường");
        } else if (tt == 2) {
            txtTrangThai.setText("Đang bảo trì");
        } else {
            txtTrangThai.setText("Bị hỏng");
        }
//            txtMaPN.setText(soSeriModels.getMaPN());
        txtMaKho.setText(seri.getMaKho());
//            txtMaPX.setText(soSeriModels.getMaPX());
        txtMaPhong.setText(seri.getMaPhong());
//            txtMaNCC.setText(soSeriModels.getMaNCC());
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE); // không cho phép tắt dialog bằng nút đóng (x)
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát không?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        txtTrangThai = new javax.swing.JTextField();
        txtMaPhong = new javax.swing.JTextField();
        txtMaKho = new javax.swing.JTextField();
        btnTrangThai = new javax.swing.JButton();
        btnMaKho = new javax.swing.JButton();
        btnMaPhong = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtSoSeri = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.darkGray);

        jLabel2.setText("Trạng thái");

        jLabel5.setText("Mã Phòng");

        jLabel6.setText("Mã Kho");

        jLabel7.setText("Giá");

        txtGia.setEditable(false);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/SAVE50.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSaveMouseMoved(evt);
            }
        });
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMouseExited(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtTrangThai.setEditable(false);

        txtMaPhong.setEditable(false);

        txtMaKho.setEditable(false);

        btnTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/CHON30.png"))); // NOI18N
        btnTrangThai.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTrangThaiMouseMoved(evt);
            }
        });
        btnTrangThai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrangThaiMouseExited(evt);
            }
        });
        btnTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangThaiActionPerformed(evt);
            }
        });

        btnMaKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/CHON30.png"))); // NOI18N
        btnMaKho.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnMaKhoMouseMoved(evt);
            }
        });
        btnMaKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMaKhoMouseExited(evt);
            }
        });
        btnMaKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaKhoActionPerformed(evt);
            }
        });

        btnMaPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/CHON30.png"))); // NOI18N
        btnMaPhong.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnMaPhongMouseMoved(evt);
            }
        });
        btnMaPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMaPhongMouseExited(evt);
            }
        });
        btnMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaPhongActionPerformed(evt);
            }
        });

        jLabel8.setText("Số Seri");

        txtSoSeri.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaKho)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(111, 111, 111))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnMaKho, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnMaPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGia)
                            .addComponent(txtSoSeri))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSoSeri)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtMaPhong))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMaKho, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtMaKho))
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangThaiActionPerformed
        JComboBox cbb = new JComboBox<>();
        cbb.addItem("Bình Thường");
        cbb.addItem("Đang bảo trì");
        cbb.addItem("Bị hỏng");
        int input = JOptionPane.showConfirmDialog(null, cbb, "Chọn Trạng thái cho số seri này!", JOptionPane.DEFAULT_OPTION);
        if (input == JOptionPane.OK_OPTION) {
            txtTrangThai.setText((String) cbb.getSelectedItem());
        }
    }//GEN-LAST:event_btnTrangThaiActionPerformed

    private void btnMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaPhongActionPerformed
        JComboBox cbb = new JComboBox<>();
        cbb = dao.get_PhongModels(cbb);
        int input = JOptionPane.showConfirmDialog(null, cbb, "Chọn Mã Phòng chứa số seri này!", JOptionPane.DEFAULT_OPTION);
        if (input == JOptionPane.OK_OPTION) {
            txtMaPhong.setText((String) cbb.getSelectedItem());
        }
    }//GEN-LAST:event_btnMaPhongActionPerformed

    private void btnMaKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaKhoActionPerformed
        JComboBox cbb = new JComboBox<>();
        cbb = dao.get_MaKho_toComboBox(cbb);
        int input = JOptionPane.showConfirmDialog(null, cbb, "Chọn mã Kho chứa số seri này!", JOptionPane.DEFAULT_OPTION);
        if (input == JOptionPane.OK_OPTION) {
            txtMaKho.setText((String) cbb.getSelectedItem());
        }
    }//GEN-LAST:event_btnMaKhoActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu thông tin chỉnh sửa không?", "Thông báo!", JOptionPane.YES_NO_OPTION);
        if (input == JOptionPane.YES_OPTION) {
            boolean b = dao.update_Soseri(txtTrangThai, txtMaPhong, txtMaKho, txtSoSeri.getText());
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Thông tin chỉnh sửa chưa được lưu!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnTrangThaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangThaiMouseExited
       btnTrangThai.setBackground(Color.white);
        btnTrangThai.setForeground(Color.black);
    }//GEN-LAST:event_btnTrangThaiMouseExited

    private void btnTrangThaiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangThaiMouseMoved
       btnTrangThai.setBackground(Color.blue);
        btnTrangThai.setForeground(Color.white);
    }//GEN-LAST:event_btnTrangThaiMouseMoved

    private void btnMaPhongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaPhongMouseExited
       btnMaPhong.setBackground(Color.white);
        btnMaPhong.setForeground(Color.black);
    }//GEN-LAST:event_btnMaPhongMouseExited

    private void btnMaPhongMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaPhongMouseMoved
       btnMaPhong.setBackground(Color.blue);
        btnMaPhong.setForeground(Color.white);
    }//GEN-LAST:event_btnMaPhongMouseMoved

    private void btnMaKhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaKhoMouseExited
       btnMaKho.setBackground(Color.white);
        btnMaKho.setForeground(Color.black);
    }//GEN-LAST:event_btnMaKhoMouseExited

    private void btnMaKhoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaKhoMouseMoved
       btnMaKho.setBackground(Color.blue);
        btnMaKho.setForeground(Color.white);
    }//GEN-LAST:event_btnMaKhoMouseMoved

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        btnSave.setBackground(Color.white);
        btnSave.setForeground(Color.black);
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseMoved
        btnSave.setBackground(Color.blue);
        btnSave.setForeground(Color.white);
    }//GEN-LAST:event_btnSaveMouseMoved

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
            java.util.logging.Logger.getLogger(Edit_SoSeri_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_SoSeri_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_SoSeri_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_SoSeri_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Edit_SoSeri_Dialog dialog = new Edit_SoSeri_Dialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMaKho;
    private javax.swing.JButton btnMaPhong;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTrangThai;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaKho;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtSoSeri;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
