/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.Xuatkho.list_id;
import Other.ShareData;
import DAO.*;
import Other.Check;
import Other.DataExcel;
import Other.getModel;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author KYrA
 */
public class Nhaphang extends javax.swing.JPanel {

    DAO dao = new DAO();

    Nhap_ThemVao_Dialog nhap_themvao = new Nhap_ThemVao_Dialog();

    public Nhaphang() {
        initComponents();
        tableThietBi.setRowHeight(35);
        tableTT_PN.setRowHeight(35);
        dao.Load_Tb_to_Edit(tableThietBi);
//        ArrayList<String> list = nhap_themvao.get_list_CTPN;
//        if (list.size()!=0) {
//            DefaultTableModel model = (DefaultTableModel) tableTT_PN.getModel();
//            model.addRow(new Object[]{
//                1, list.get(0),list.get(0),list.get(0),list.get(0),list.get(0),list.get(0),list.get(0)
//            });
//            model.fireTableDataChanged();
//        }
        //Fill_to_table_TTPN("adas", "ada",3, "adas", "adas");
    }

    public void Fill_to_table_TTPN(String id, String ten, int soluong, String trangthai, String makho) {

        DefaultTableModel model = (DefaultTableModel) tableTT_PN.getModel();
        model.setRowCount(0);
        System.out.println(id);
        System.out.println(ten);

        //int i = tableTT_PN.getRowCount();
        model.addRow(new Object[]{
            1, id, ten, 3, trangthai, makho
        });
        model.fireTableDataChanged();

    }

    public ArrayList<String> fill(ArrayList<String> list) {
        return list;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableThietBi = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaPN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnThemMoi = new javax.swing.JButton();
        btnReSet = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTT_PN = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnBoChon = new javax.swing.JButton();

        tableThietBi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "ID THIẾT BỊ", "TÊN THIẾT BỊ"
            }
        ));
        tableThietBi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tableThietBiMouseMoved(evt);
            }
        });
        tableThietBi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableThietBiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableThietBi);
        if (tableThietBi.getColumnModel().getColumnCount() > 0) {
            tableThietBi.getColumnModel().getColumn(1).setMinWidth(150);
            tableThietBi.getColumnModel().getColumn(2).setMinWidth(300);
        }

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("TÌm Kiếm Thiết Bị:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nhập mã Phiếu Nhập:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Chi tiêt phiếu nhập");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaPN, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addComponent(txtTimKiem))
                .addGap(328, 328, 328)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnThemMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/icons8-add-new-46.png"))); // NOI18N
        btnThemMoi.setText("Thêm mới");
        btnThemMoi.setToolTipText("");
        btnThemMoi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThemMoi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThemMoi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnThemMoiMouseMoved(evt);
            }
        });
        btnThemMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThemMoiMouseExited(evt);
            }
        });
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnReSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/RESET.png"))); // NOI18N
        btnReSet.setText("ReLoad");
        btnReSet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReSet.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReSet.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnReSetMouseMoved(evt);
            }
        });
        btnReSet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReSetMouseExited(evt);
            }
        });
        btnReSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReSetActionPerformed(evt);
            }
        });

        tableTT_PN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "TÊN THIẾT BỊ", "SỐ LƯỢNG", "TRẠNG THÁI", "ĐƠN GIÁ", "MÃ KHO", "MÃ NCC", "Link File"
            }
        ));
        jScrollPane3.setViewportView(tableTT_PN);
        if (tableTT_PN.getColumnModel().getColumnCount() > 0) {
            tableTT_PN.getColumnModel().getColumn(1).setMinWidth(200);
            tableTT_PN.getColumnModel().getColumn(4).setMinWidth(100);
        }

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/SAVE50.png"))); // NOI18N
        btnSave.setText("Save");
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

        btnBoChon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/BO_CHON.png"))); // NOI18N
        btnBoChon.setText("Bỏ chọn");
        btnBoChon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBoChon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBoChon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBoChonMouseMoved(evt);
            }
        });
        btnBoChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBoChonMouseExited(evt);
            }
        });
        btnBoChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(285, 285, 285)
                                .addComponent(btnThemMoi)
                                .addGap(83, 83, 83)
                                .addComponent(btnReSet, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBoChon)
                                .addGap(27, 27, 27)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(203, 203, 203))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBoChon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnReSet, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        DefaultTableModel model = (DefaultTableModel) tableThietBi.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        tableThietBi.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txtTimKiem.getText().trim()));
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void tableThietBiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableThietBiMouseClicked
        Check check = new Check();

        if (txtMaPN.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Mã phiếu nhập không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaPN.requestFocus(true);
        } else if (!check.isText_Number(txtMaPN.getText())) {
            JOptionPane.showMessageDialog(null, "Mã phiếu nhập không được chứa kí tự trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaPN.requestFocus(true);
        } else if (txtMaPN.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Mã phiếu nhập không được vượt qua 10 kí tự", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaPN.requestFocus(true);
        } else if (dao.Check_PN_Trung(txtMaPN.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Mã phiếu nhập đã tồn tại!\nVui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaPN.requestFocus(true);
        } else {
            int row = tableThietBi.rowAtPoint(evt.getPoint());
            String id = (String) tableThietBi.getValueAt(row, 1);
            String ten = (String) tableThietBi.getValueAt(row, 2);
            Nhap_ThemVao_Dialog nhap_ThemVao_Dialog = new Nhap_ThemVao_Dialog(null, true, txtMaPN.getText(), id, ten, this);
            nhap_ThemVao_Dialog.setTitle("Nhập thiết bị đã có sẵn");
            nhap_ThemVao_Dialog.setVisible(true);
        }
    }//GEN-LAST:event_tableThietBiMouseClicked

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        Check check = new Check();
        if (txtMaPN.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Mã phiếu nhập không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaPN.requestFocus(true);
        } else if (!check.isText_Number(txtMaPN.getText())) {
            JOptionPane.showMessageDialog(null, "Mã phiếu nhập không được chứa kí tự trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaPN.requestFocus(true);
        } else if (txtMaPN.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "Mã phiếu nhập không được vượt qua 10 kí tự", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaPN.requestFocus(true);
        } else if (dao.Check_PN_Trung(txtMaPN.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Mã phiếu nhập đã tồn tại!\nVui lòng nhập lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaPN.requestFocus(true);
        } else {
            Nhap_TaoMoi_Dialog nhap_TaoMoi_Dialog = new Nhap_TaoMoi_Dialog(null, true, txtMaPN.getText(), this);
            nhap_TaoMoi_Dialog.setTitle("Nhập thêm thiết bị chưa có dữ liệu");
            nhap_TaoMoi_Dialog.setVisible(true);
        }
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnReSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReSetActionPerformed
        dao.Load_Tb_to_Edit(tableThietBi);
    }//GEN-LAST:event_btnReSetActionPerformed

    private void tableThietBiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableThietBiMouseMoved
        tableThietBi.setToolTipText("Click vào dòng chỉ định để nhập thiết bị ở dòng đó!");
    }//GEN-LAST:event_tableThietBiMouseMoved

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int row = tableTT_PN.getRowCount();
        int tt = -1;

        int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu thông tin thiết bị vào phiếu nhập không?", "Thông báo!", JOptionPane.YES_NO_OPTION);
        if (row == 0) {
            JOptionPane.showMessageDialog(null, "Phiếu nhập đang rỗng!", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
        } else if (input == JOptionPane.YES_OPTION) {
//            boolean a = dao.add_PN(txtMaPN.getText(), dao.get_MANV_from_USERNAME(ShareData.taikhoandangnhap.getUserName()));
            boolean a = dao.add_PN(txtMaPN.getText(), ShareData.taikhoandangnhap.getUserName());

            for (int i = 0; i < row; i++) {
                ArrayList<String> list = new ArrayList<>();
                try {
                    list = DataExcel.readExcelFile((String) tableTT_PN.getValueAt(i, 7));
                    if (dao.Check_ID_Trung((String) tableTT_PN.getValueAt(i, 0))) {
                        boolean add_tb = dao.add_ThietBi((String) tableTT_PN.getValueAt(i, 0), (String) tableTT_PN.getValueAt(i, 1));
                    }
                    for (int j = 0; j < list.size(); j++) {
                        if (tableTT_PN.getValueAt(i, 3).equals("Mới")) {
                            tt = 1;
                        } else {
                            tt = 2;
                        }
                        Object value = tableTT_PN.getValueAt(i, 4);
                        int gia = Integer.parseInt(value.toString());
                        boolean b = dao.add_soseri(list.get(j), (String) tableTT_PN.getValueAt(i, 0), tt, (String) txtMaPN.getText(), (String) tableTT_PN.getValueAt(i, 5), (String) tableTT_PN.getValueAt(i, 6), gia);
                    }
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                    System.out.println("338_nhaphang");
                } catch (InvalidFormatException ex) {
                    System.out.println(ex.toString());
                    System.out.println("342_nhaphang");
                }

            }
            JOptionPane.showMessageDialog(null, "Lưu thành công");
            tableTT_PN.removeAll();
            ShareData.file_excel = "";
        } else {
            JOptionPane.showMessageDialog(null, "Lưu không thành công");

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnBoChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoChonActionPerformed
        int[] selectedRows = tableTT_PN.getSelectedRows(); // Lấy về các dòng được chọn trong bảng 2
        if (selectedRows.length > 0) {

            // Lấy ra model của bảng 1 và bảng 2
            DefaultTableModel model2 = (DefaultTableModel) tableTT_PN.getModel();
            Object[] row = new Object[2];
            // Lặp qua các dòng được chọn trong bảng 2
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                ShareData.file_excel.replace((String) tableTT_PN.getValueAt(selectedRows[i], 7), "");
                model2.removeRow(selectedRows[i]);
            }
        }
    }//GEN-LAST:event_btnBoChonActionPerformed

    private void btnThemMoiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMoiMouseExited
       btnThemMoi.setBackground(Color.white);
        btnThemMoi.setForeground(Color.black);
    }//GEN-LAST:event_btnThemMoiMouseExited

    private void btnThemMoiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMoiMouseMoved
       btnThemMoi.setBackground(Color.blue);
        btnThemMoi.setForeground(Color.white);
    }//GEN-LAST:event_btnThemMoiMouseMoved

    private void btnReSetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReSetMouseExited
       btnReSet.setBackground(Color.white);
        btnReSet.setForeground(Color.black);
    }//GEN-LAST:event_btnReSetMouseExited

    private void btnReSetMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReSetMouseMoved
       btnReSet.setBackground(Color.blue);
        btnReSet.setForeground(Color.white);
    }//GEN-LAST:event_btnReSetMouseMoved

    private void btnBoChonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoChonMouseExited
       btnBoChon.setBackground(Color.white);
        btnBoChon.setForeground(Color.black);
    }//GEN-LAST:event_btnBoChonMouseExited

    private void btnBoChonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoChonMouseMoved
        btnBoChon.setBackground(Color.blue);
        btnBoChon.setForeground(Color.white);
    }//GEN-LAST:event_btnBoChonMouseMoved

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
       btnSave.setBackground(Color.white);
        btnSave.setForeground(Color.black);
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseMoved
        btnSave.setBackground(Color.blue);
        btnSave.setForeground(Color.white);
    }//GEN-LAST:event_btnSaveMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBoChon;
    private javax.swing.JButton btnReSet;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable tableTT_PN;
    private javax.swing.JTable tableThietBi;
    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
