/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Controller;

import Other.Chuc_nang_Khac;
import Other.Check;
import DAO.*;
import Models.*;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author trieu
 */
public class Edit_TB_Dialog extends javax.swing.JDialog {

    Chuc_nang_Khac cnk = new Chuc_nang_Khac();
    DAO dao = new DAO();
    //Class_Tmp class_Tmp = new Class_Tmp();
    public static String id_tb;

    public Edit_TB_Dialog(java.awt.Frame parent, boolean modal, String id) {
        super(parent, modal);
        initComponents();
        String id_tmp = id;
        ThietBiModels tb = new ThietBiModels();
        tb = dao.getTB_From_ID(id);
        txtTenTB.setText(tb.getTenThietBi());
        id_tb = tb.getMaThietBi();
        txtAMota.setText(tb.getMota());
        txtAHDSD.setText(tb.gethDSD());
        DefaultListModel<String> model = new DefaultListModel<>();
        for (int i = 0; i < tb.getVungTap().size(); i++) {
            model.addElement(tb.getVungTap().get(i));

        }
        listVungTap.setModel(model);

        txtLinkAnhTB.setText(tb.getAnh());
        lblAnhTB.setIcon(cnk.reSizeImage(tb.getAnh(), lblAnhTB));
        txtTenTB.setEditable(false);
        txtAMota.setEditable(false);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnhTB = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenTB = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLinkAnhTB = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAMota = new javax.swing.JTextArea();
        btnEditTB = new javax.swing.JButton();
        btnEditSeri = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAHDSD = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        listVungTap = new javax.swing.JList<>();
        btnChonVT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.darkGray);

        lblAnhTB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblAnhTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhTBMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên thiết bị");

        txtTenTB.setEditable(false);
        txtTenTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenTBActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Link ảnh");

        txtLinkAnhTB.setEditable(false);
        txtLinkAnhTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLinkAnhTBActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mã vùng tập");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mô tả");

        txtAMota.setEditable(false);
        txtAMota.setColumns(20);
        txtAMota.setRows(5);
        jScrollPane1.setViewportView(txtAMota);

        btnEditTB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/EDIT.png"))); // NOI18N
        btnEditTB.setText("Edit TB");
        btnEditTB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEditTB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditTB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditTB.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEditTBMouseMoved(evt);
            }
        });
        btnEditTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditTBMouseExited(evt);
            }
        });
        btnEditTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTBActionPerformed(evt);
            }
        });

        btnEditSeri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/EDIT_SERI.png"))); // NOI18N
        btnEditSeri.setText("Edit serial");
        btnEditSeri.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEditSeri.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditSeri.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditSeri.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnEditSeriMouseMoved(evt);
            }
        });
        btnEditSeri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditSeriMouseExited(evt);
            }
        });
        btnEditSeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSeriActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/SAVE50.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("HDSD");

        txtAHDSD.setColumns(20);
        txtAHDSD.setRows(5);
        jScrollPane2.setViewportView(txtAHDSD);

        jScrollPane3.setViewportView(listVungTap);

        btnChonVT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/CHON30.png"))); // NOI18N
        btnChonVT.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnChonVTMouseMoved(evt);
            }
        });
        btnChonVT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnChonVTMouseExited(evt);
            }
        });
        btnChonVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonVTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAnhTB, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(btnEditTB, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenTB)
                            .addComponent(txtLinkAnhTB)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChonVT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnEditSeri, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAnhTB, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 102, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenTB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLinkAnhTB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(btnChonVT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditSeri, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblAnhTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhTBMouseClicked

        try {
            JFileChooser f = new JFileChooser("D:\\HK2_3\\Gym_EquipMent\\Gym\\src\\main\\resources\\Image_resources");
            f.setDialogTitle("Mở File");
            f.showOpenDialog(null);
            File ftenAnh = f.getSelectedFile();
            String anh_Address = ftenAnh.getAbsolutePath();
            if (anh_Address != null) {
                lblAnhTB.setIcon(cnk.reSizeImage(String.valueOf(anh_Address), lblAnhTB));
            }
            txtLinkAnhTB.setText(anh_Address);

        } catch (Exception e) {
            System.out.println("162_Edit_Tb_Dialog");
        }

    }//GEN-LAST:event_lblAnhTBMouseClicked

    private void txtLinkAnhTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLinkAnhTBActionPerformed

    }//GEN-LAST:event_txtLinkAnhTBActionPerformed

    private void txtTenTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenTBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenTBActionPerformed

    private void btnEditTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTBActionPerformed
        txtTenTB.setEditable(true);
        txtAMota.setEditable(true);

    }//GEN-LAST:event_btnEditTBActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Check check = new Check();
        if (!check.isEmpty(txtTenTB)) {
            JOptionPane.showMessageDialog(null, "Tên thiết bị không được để trống!");
        } else {
            txtTenTB.setText(check.formatName(txtTenTB.getText()));
            int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu thông tin thiết bị sau khi chỉnh sửa không?", "Thông báo!", JOptionPane.YES_NO_OPTION);
            if (input == JOptionPane.YES_OPTION) {
                DefaultListModel<String> model = (DefaultListModel<String>) listVungTap.getModel();

                for (int i = 0; i < model.getSize(); i++) {

                    if (dao.Check_Mavt(model.get(i), id_tb) == true) {

                        boolean a = dao.add_CTVT(model.get(i), id_tb);
                    }

                }
                boolean b = dao.update_TB(txtTenTB, txtLinkAnhTB, txtAMota, id_tb);
                JOptionPane.showMessageDialog(null, "Lưu thông tin thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Thông tin chỉnh sửa chưa được lưu!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditSeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSeriActionPerformed
        JComboBox cbb = new JComboBox<>();
        cbb = dao.get_ALL_Soseri_From_IDTB(id_tb, cbb);
        int input = JOptionPane.showConfirmDialog(null, cbb, "Chọn Số Seri cần chỉnh sửa!", JOptionPane.DEFAULT_OPTION);
        if (input == JOptionPane.OK_OPTION) {
            Edit_SoSeri_Dialog edit_SoSeri_Dialog = new Edit_SoSeri_Dialog(null, true, (String) cbb.getSelectedItem());
            edit_SoSeri_Dialog.setTitle("Thông tin có thể chỉnh sửa của số seri này");
            edit_SoSeri_Dialog.setVisible(true);
        }
    }//GEN-LAST:event_btnEditSeriActionPerformed

    private void btnEditTBMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditTBMouseMoved
        btnEditTB.setToolTipText("Click vào để chỉnh sửa thông tin của thiết bị!");
        btnEditTB.setBackground(Color.blue);
        btnEditTB.setForeground(Color.white);
    }//GEN-LAST:event_btnEditTBMouseMoved

    private void btnEditSeriMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditSeriMouseMoved
        btnEditSeri.setToolTipText("Click vào để chỉnh sửa thông tin chi tiết của một số seri!");
        btnEditSeri.setBackground(Color.blue);
        btnEditSeri.setForeground(Color.white);
    }//GEN-LAST:event_btnEditSeriMouseMoved

    private void btnChonVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonVTActionPerformed

        JList<String> lst_mavt = dao.getMaVT();
        DefaultListModel<String> model1 = (DefaultListModel<String>) listVungTap.getModel();
        DefaultListModel<String> model2 = (DefaultListModel<String>) lst_mavt.getModel();

        for (int i = 0; i < model2.getSize(); i++) {
            String value = model2.getElementAt(i);
            if (model1.contains(value)) {

                model2.removeElement(value);
                i--;
            }
        }
        JScrollPane scrollPane = new JScrollPane(lst_mavt);
        JOptionPane.showConfirmDialog(null, scrollPane, "Chọn thêm mã vùng tập cho thiết bị này!", JOptionPane.INFORMATION_MESSAGE);
        List<String> ds_vt_dachon = lst_mavt.getSelectedValuesList();
        for (String tmp : ds_vt_dachon) {

            model1.addElement(tmp);
        }

    }//GEN-LAST:event_btnChonVTActionPerformed

    private void btnChonVTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonVTMouseExited
        btnChonVT.setBackground(Color.white);
        btnChonVT.setForeground(Color.black);
    }//GEN-LAST:event_btnChonVTMouseExited

    private void btnChonVTMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonVTMouseMoved
        btnChonVT.setBackground(Color.blue);
        btnChonVT.setForeground(Color.white);
    }//GEN-LAST:event_btnChonVTMouseMoved

    private void btnEditTBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditTBMouseExited
        btnEditTB.setBackground(Color.white);
        btnEditTB.setForeground(Color.black);
    }//GEN-LAST:event_btnEditTBMouseExited

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        btnSave.setBackground(Color.white);
        btnSave.setForeground(Color.black);
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseMoved
        btnSave.setBackground(Color.blue);
        btnSave.setForeground(Color.white);
    }//GEN-LAST:event_btnSaveMouseMoved

    private void btnEditSeriMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditSeriMouseExited
        btnEditSeri.setBackground(Color.white);
        btnEditSeri.setForeground(Color.black);
    }//GEN-LAST:event_btnEditSeriMouseExited

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
            java.util.logging.Logger.getLogger(Edit_TB_Dialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_TB_Dialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_TB_Dialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_TB_Dialog.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DiaLog_EditThietBi dialog = new DiaLog_EditThietBi(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Edit_TB_Dialog dialog = new Edit_TB_Dialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnChonVT;
    private javax.swing.JButton btnEditSeri;
    private javax.swing.JButton btnEditTB;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAnhTB;
    private javax.swing.JList<String> listVungTap;
    private javax.swing.JTextArea txtAHDSD;
    private javax.swing.JTextArea txtAMota;
    private javax.swing.JTextField txtLinkAnhTB;
    private javax.swing.JTextField txtTenTB;
    // End of variables declaration//GEN-END:variables
}
