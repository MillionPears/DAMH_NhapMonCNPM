/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Controller;

import DAO.*;
import Models.*;
import Other.DataExcel;
import Other.ShareData;
import Other.DataValidator;
import Other.Check;
import Other.getModel;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Nhap_ThemVao_Dialog extends javax.swing.JDialog {

    DAO dao = new DAO();
    String mapn_tmp = "";
    Nhaphang nhaphang;
    //static String ShareData.file_excel = "";
    static String addressExcel ="";
    //static DefaultTableModel tblModel = new DefaultTableModel();
    public static ArrayList<String> get_list_CTPN = new ArrayList<>();

    public Nhap_ThemVao_Dialog(java.awt.Frame parent, boolean modal, String mapn, String id, String tentb, Nhaphang nhaphang) {

        super(parent, modal);
        initComponents();
        mapn_tmp = mapn;
        txtIDTB.setText(id);
        txtTenTB.setText(tentb);
        cbbTrangThai.addItem("Mới");
        cbbTrangThai.addItem("Cũ");

        this.nhaphang = nhaphang;

        for (int i = 0; i < dao.get_MaKho_From_Kho().size(); i++) {
            cbbMaKho.addItem(dao.get_MaKho_From_Kho().get(i));
        }
        for (int i = 0; i < dao.get_MaNCC_From_NCC().size(); i++) {
            cbbMaNCC.addItem(dao.get_MaNCC_From_NCC().get(i));
        }
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

    public Nhap_ThemVao_Dialog() {
    }
//    public static ArrayList<String> get_list_CTPN(String id, String ten,String sl, String gia, String tt, String makho, String NCC)
//    {
//        ArrayList<String> list = new ArrayList<>();
//        list.add(id);
//        list.add(ten);
//        list.add(gia);
//        list.add(sl);
//        list.add(tt);
//        list.add(makho);
//        list.add(NCC);
//        return list;
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIDTB = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenTB = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbbDS_Soseri = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbbMaKho = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnNhapFile = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbbMaNCC = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.darkGray);

        jLabel1.setText("ID Thiết Bị:");

        txtIDTB.setEditable(false);

        jLabel2.setText("Tên Thiết Bị:");

        txtTenTB.setEditable(false);

        jLabel3.setText("Danh Sách Số Seri");

        jLabel4.setText("Trạng Thái:");

        jLabel6.setText("Mã Kho:");

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

        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/HUY.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHuy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHuy.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnHuyMouseMoved(evt);
            }
        });
        btnHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHuyMouseExited(evt);
            }
        });
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnNhapFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/CHON30.png"))); // NOI18N
        btnNhapFile.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnNhapFileMouseMoved(evt);
            }
        });
        btnNhapFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNhapFileMouseExited(evt);
            }
        });
        btnNhapFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapFileActionPerformed(evt);
            }
        });

        jLabel5.setText("Số Lượng Cần Nhập:");

        jLabel7.setText("Mã Nhà Cung Cấp:");

        jLabel8.setText("Đơn Giá:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDTB, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenTB, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbMaKho, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbbDS_Soseri, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnNhapFile, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 76, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(btnSave)
                .addGap(68, 68, 68)
                .addComponent(btnHuy)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenTB, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDTB, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbDS_Soseri, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNhapFile, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMaKho, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhapFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapFileActionPerformed
        StringBuilder sb = new StringBuilder();
        if (DataValidator.empty_Data(txtSoLuong, sb, "")) {
            txtSoLuong.requestFocus();
            return;
        }
        try {
            int input = 0;
            ArrayList<String> list_seri = null;

            String link_file = "D:\\HK2_3\\Gym_EquipMent\\DSSeri";
            JFileChooser f = new JFileChooser(link_file);
            f.setDialogTitle("Mở File");
            f.showOpenDialog(null);
            File fExcelEmei = f.getSelectedFile();
            addressExcel = fExcelEmei.getAbsolutePath();
            //System.out.println(ShareData.link_file_seriString);
            if (addressExcel != null) {
                if (ShareData.file_excel.indexOf(addressExcel) != -1) {
                    JOptionPane.showConfirmDialog(null, "file này đã được chọn mới đây, vui lòng chọn lại!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                    btnNhapFileActionPerformed(evt);
                } else {
                    ShareData.file_excel += addressExcel + ",";
                    list_seri = DataExcel.readExcelFile(addressExcel);
                }
            }
            if (list_seri.size() != Integer.parseInt(txtSoLuong.getText())) {
                input = JOptionPane.showConfirmDialog(null, "Số lượng seri nhạp vào không trùng khớp với số lượng mua!\n Bạn có muốn chọn lại file!", "Thông báo!", JOptionPane.YES_NO_OPTION);
                if (input == JOptionPane.YES_OPTION) {
                    list_seri = null;
                    btnNhapFileActionPerformed(evt);
                }
            }

            for (int i = 0; i < list_seri.size(); i++) {
                cbbDS_Soseri.addItem(list_seri.get(i));
            }
        } catch (Exception e) {
            System.out.println("217- Nhap_themVao_Dialog");
        }

    }//GEN-LAST:event_btnNhapFileActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Check check = new Check();
        //nhaphang.Fill_to_table_TTPN(txtIDTB.getText(), txtTenTB.getText(), 3, "abc", "abc");
        if (!check.isNumber(txtSoLuong.getText())) {
            JOptionPane.showMessageDialog(null, "Số lượng không được chứa kí tự!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtSoLuong.requestFocus();
        } else if (!check.isNumber(txtDonGia.getText())) {
            JOptionPane.showMessageDialog(null, "Đơn giá không được chứa kí tự!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtDonGia.requestFocus();
        } else {
            int soluong_seri = cbbDS_Soseri.getItemCount();
            if (soluong_seri == 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập vào số seri", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                int flag = 0;
                for (int i = 0; i < soluong_seri; i++) {
                    if (!dao.Check_SERI_Trung(cbbDS_Soseri.getItemAt(i))) {
                        flag = 1;
                        cbbDS_Soseri.removeAllItems();
                        JOptionPane.showMessageDialog(null, "Số Seri thứ " + i + 1 + "đã tồn tại!\n Vui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (flag == 0) {
                    int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu thông tin thiết bị vào phiếu nhập không?", "Thông báo!", JOptionPane.YES_NO_OPTION);
                    if (input == JOptionPane.YES_OPTION) {
                        System.out.println(addressExcel);
                        DefaultTableModel model = (DefaultTableModel) this.nhaphang.tableTT_PN.getModel();
                        model.addRow(new Object[]{
                             txtIDTB.getText(), txtTenTB.getText(), txtSoLuong.getText(),cbbTrangThai.getSelectedItem(),txtDonGia.getText(),cbbMaKho.getSelectedItem(), cbbMaNCC.getSelectedItem(),addressExcel
                        });
                        model.fireTableDataChanged();
                        //PhieuNhapModels pn_model = getModel.get_PN_Model(txtIDTB.getText(), txtTenTB.getText(), Integer.valueOf(txtSoLuong.getText()), (String) cbbTrangThai.getSelectedItem(), (String) cbbMaKho.getSelectedItem());
                        //mapn_tmp.toUpperCase();
                        //boolean a = dao.add_PN(mapn_tmp, dao.get_MANV_from_USERNAME(ShareData.taikhoandangnhap.getUserName()));
//                        int tt = -1;
//                        if (cbbTrangThai.getSelectedItem().equals("Mới")) {
//                            tt = 1;
//                        } else {
//                            tt = 2;
//                        }
//                        for (int i = 0; i < soluong_seri; i++) {
//                            boolean b = dao.add_soseri(cbbDS_Soseri.getItemAt(i), txtIDTB.getText(), tt, mapn_tmp, (String) cbbMaKho.getSelectedItem(), (String) cbbMaNCC.getSelectedItem(), Integer.valueOf(txtDonGia.getText()));
//                        }
                        this.setVisible(false);
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Sản phẩm không được lưu vào phiếu nhập?", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        JOptionPane.showMessageDialog(this, "Thông tin chỉnh sửa chưa được lưu!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnNhapFileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhapFileMouseExited
       btnNhapFile.setBackground(Color.white);
        btnNhapFile.setForeground(Color.black);
    }//GEN-LAST:event_btnNhapFileMouseExited

    private void btnNhapFileMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhapFileMouseMoved
      btnNhapFile.setBackground(Color.blue);
        btnNhapFile.setForeground(Color.white);
    }//GEN-LAST:event_btnNhapFileMouseMoved

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
       btnSave.setBackground(Color.white);
        btnSave.setForeground(Color.black);
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseMoved
        btnSave.setBackground(Color.blue);
        btnSave.setForeground(Color.white);
    }//GEN-LAST:event_btnSaveMouseMoved

    private void btnHuyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseExited
        btnHuy.setBackground(Color.white);
        btnHuy.setForeground(Color.black);
    }//GEN-LAST:event_btnHuyMouseExited

    private void btnHuyMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseMoved
        btnHuy.setBackground(Color.blue);
        btnHuy.setForeground(Color.white);
    }//GEN-LAST:event_btnHuyMouseMoved

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
            java.util.logging.Logger.getLogger(Nhap_ThemVao_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nhap_ThemVao_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nhap_ThemVao_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nhap_ThemVao_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Nhap_ThemVao_Dialog dialog = new Nhap_ThemVao_Dialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnNhapFile;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbbDS_Soseri;
    private javax.swing.JComboBox<String> cbbMaKho;
    private javax.swing.JComboBox<String> cbbMaNCC;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtIDTB;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenTB;
    // End of variables declaration//GEN-END:variables
}
