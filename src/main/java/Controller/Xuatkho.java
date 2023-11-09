/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.*;
import Other.ShareData;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Xuatkho extends javax.swing.JPanel {

    ArrayList<Integer> list_tt = new ArrayList<>();
    DAO dao = new DAO();
    static String list_id ="";
    public Xuatkho() {
        initComponents();
        tableThietBi.setRowHeight(35);
        tableCTPX.setRowHeight(35);
        tableSoseri.setRowHeight(35);
        dao.Load_Tb_to_Xuathang(tableThietBi);
        //txtMapx.setDocument(new JTextfieldCharLimit(10));
        //jTextField1.setDocument(new JTextfieldCharLimit(10));
        //jTextField3.setDocument(new JTextfieldCharLimit(10));
        xuatDialog.setDefaultCloseOperation(xuatDialog.DO_NOTHING_ON_CLOSE); // không cho phép tắt dialog bằng nút đóng (x)
        xuatDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát không?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    xuatDialog.dispose();
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

        xuatDialog = new javax.swing.JDialog();
        txtTimKiemSeri = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSoseri = new javax.swing.JTable();
        btnChon = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtTimKiemTB = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableThietBi = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCTPX = new javax.swing.JTable();
        btnBoChon = new javax.swing.JButton();
        btnLap = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        txtMapx = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dateNgayTao = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        xuatDialog.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                xuatDialogComponentShown(evt);
            }
        });

        txtTimKiemSeri.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiemSeri.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemSeriCaretUpdate(evt);
            }
        });
        txtTimKiemSeri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemSeriKeyPressed(evt);
            }
        });

        tableSoseri.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableSoseri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "STT", "Số seri"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSoseri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSoseriMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableSoseri);

        btnChon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnChon.setText("Chọn");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Tìm Kiếm");

        javax.swing.GroupLayout xuatDialogLayout = new javax.swing.GroupLayout(xuatDialog.getContentPane());
        xuatDialog.getContentPane().setLayout(xuatDialogLayout);
        xuatDialogLayout.setHorizontalGroup(
            xuatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, xuatDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(xuatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addGroup(xuatDialogLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiemSeri, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnChon)))
                .addGap(29, 29, 29))
        );
        xuatDialogLayout.setVerticalGroup(
            xuatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, xuatDialogLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(xuatDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemSeri, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        txtTimKiemTB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiemTB.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemTBCaretUpdate(evt);
            }
        });
        txtTimKiemTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemTBActionPerformed(evt);
            }
        });
        txtTimKiemTB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemTBKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tìm kiếm theo ID:");

        tableThietBi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "ID Thiết bị", "Tên thiết bị"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableThietBi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableThietBiMouseClicked(evt);
            }
        });
        tableThietBi.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tableThietBiCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tableThietBi);

        tableCTPX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableCTPX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên thiết bị", "Serial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableCTPX);

        btnBoChon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        btnLap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/SAVE50.png"))); // NOI18N
        btnLap.setText("Lập");
        btnLap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLap.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLap.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnLapMouseMoved(evt);
            }
        });
        btnLap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLapMouseExited(evt);
            }
        });
        btnLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        txtMapx.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMapx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMapxActionPerformed(evt);
            }
        });
        txtMapx.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMapxKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Mã PX:");

        dateNgayTao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dateNgayTaoKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Ngày tạo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnBoChon, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnLap, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMapx, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(dateNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMapx, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateNgayTao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLap, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBoChon, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/RESET.png"))); // NOI18N
        btnReset.setText("ReLoad");
        btnReset.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReset.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReset.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnResetMouseMoved(evt);
            }
        });
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnResetMouseExited(evt);
            }
        });
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Thông tin phiếu xuất");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTimKiemTB))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(484, 484, 484)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableThietBiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableThietBiMouseClicked
        // TODO add your handling code here:
        tableThietBi.setRowSelectionAllowed(true);
        int row = tableThietBi.rowAtPoint(evt.getPoint());
        String id = (String) tableThietBi.getValueAt(row, 1);
//        jTextField2.setText(id);
        
        dao.Load_serial(tableSoseri, tableCTPX, id,list_id);
        xuatDialog.setSize(392, 293);
        xuatDialog.setLocationRelativeTo(null);
        xuatDialog.setVisible(true);
    }//GEN-LAST:event_tableThietBiMouseClicked

    private void tableSoseriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSoseriMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tableSoseriMouseClicked

    private void txtTimKiemTBCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemTBCaretUpdate
        // TODO add your handling code here:
//        nhapxuatDAO.Load_tb_Theo_ID(jTable1, jTextField1);
        DefaultTableModel model = (DefaultTableModel) tableThietBi.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        tableThietBi.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txtTimKiemTB.getText().trim()));
    }//GEN-LAST:event_txtTimKiemTBCaretUpdate

    private void txtTimKiemSeriCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemSeriCaretUpdate
        // TODO add your handling code here:
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        jTextField2.setText(model.getValueAt(row, 1));
//        System.out.print(id);
//        nhapxuatDAO.Load_tb_Theo_Serial(jTable2, jTextField3, jTextField2.getText());
        DefaultTableModel model = (DefaultTableModel) tableSoseri.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        tableSoseri.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txtTimKiemSeri.getText().trim()));
    }//GEN-LAST:event_txtTimKiemSeriCaretUpdate

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        //dao.Xuat_serial(tableThietBi, tableSoseri, tableCTPX);
        
        DefaultTableModel model3 = (DefaultTableModel) tableThietBi.getModel();
        int index = tableThietBi.getSelectedRow();
        int[] selectedRows = tableSoseri.getSelectedRows(); // Lấy về các dòng được chọn trong bảng 1

        if (selectedRows.length > 0) {
            // Lấy ra model của bảng 1 và bảng 2
            DefaultTableModel model1 = (DefaultTableModel) tableSoseri.getModel();
            DefaultTableModel model2 = (DefaultTableModel) tableCTPX.getModel();
            Object[] row = new Object[3];
            // Lặp qua các dòng được chọn trong bảng 1
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                row[2] = model1.getValueAt(selectedRows[i], 1);
                row[0] = model3.getValueAt(index, 1);
                row[1] = model3.getValueAt(index, 2);
                model2.addRow(row);
                //list_tt.add(dao.update_TrangThai_Soseri_initial((String) model1.getValueAt(selectedRows[i], 1), -1));
                //cập nhật lại trạng thái của các số seri
                //boolean a = dao.update_TrangThai_Soseri((String) model1.getValueAt(selectedRows[i], 1), 3);
                // Xóa dữ liệu khỏi bảng 1
                list_id+=model1.getValueAt(selectedRows[i], 1)+",";
                model1.removeRow(selectedRows[i]);
            }
        }

    }//GEN-LAST:event_btnChonActionPerformed

    private void txtMapxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMapxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtMapxActionPerformed

    private void xuatDialogComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_xuatDialogComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_xuatDialogComponentShown

    private void btnBoChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoChonActionPerformed
        // TODO add your handling code here:

        int[] selectedRows = tableCTPX.getSelectedRows(); // Lấy về các dòng được chọn trong bảng 2
        if (selectedRows.length > 0) {

            // Lấy ra model của bảng 1 và bảng 2
            DefaultTableModel model2 = (DefaultTableModel) tableCTPX.getModel();
            Object[] row = new Object[2];
            // Lặp qua các dòng được chọn trong bảng 2
            for (int i = selectedRows.length - 1; i >= 0; i--) {

                //dao.update_TrangThai_Soseri((String) model2.getValueAt(selectedRows[i], 2), 2);
                // Xóa dữ liệu khỏi bảng 1
                list_id= list_id.replace((String) model2.getValueAt(selectedRows[i], 2), "");
                model2.removeRow(selectedRows[i]);
                
            }
        }
        
    }//GEN-LAST:event_btnBoChonActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableCTPX.getModel();

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn thật sự muốn hủy?", "Xác nhận", dialogButton);
        if (dialogResult == 0) {
            model.setRowCount(0);
            list_id="";
            txtMapx.setText(null);
            dateNgayTao.setDate(null);
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnLapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapActionPerformed
        // TODO add your handling code here:     
        

        DefaultTableModel model = (DefaultTableModel) tableCTPX.getModel();
        if (txtMapx.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mã Phiếu Xuất đang để trống!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            txtMapx.requestFocus();
        } else if (dao.Kiem_tra_PX(txtMapx.getText())) {
            JOptionPane.showMessageDialog(null, "Mã Phiếu Xuất đã tồn tại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            txtMapx.requestFocus();
        } else if (dateNgayTao.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ngày Xuất đang để trống!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else if (tableCTPX.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Không có thông tin về sản phẩm cần xuất kho!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(dateNgayTao.getDate());
            
            int input = JOptionPane.showConfirmDialog(this, "Bạn thật sự muốn lập?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (input == JOptionPane.YES_OPTION) {
                
                //String manv = dao.get_MANV_from_USERNAME(ShareData.taikhoandangnhap.getUserName());
                String manv = ShareData.taikhoandangnhap.getUserName();
                System.out.println(manv);
                dao.Lap_phieu_xuat(txtMapx.getText(), manv, date);
                int indexs = tableCTPX.getRowCount();
//          Object[] row = new Object[4];
                String[] s = new String[indexs];
                for (int i = 0; i < indexs; i++) {
                    s[i] = model.getValueAt(i, 2).toString();
//              System.out.print(s[i]);
                    dao.Gan_phieuxuat_vao_serial(tableCTPX, txtMapx.getText(), s[i]);
                }
//             nhapxuatDAO.Gan_phieuxuat_vao_serial(jTable2, mapx);

                JOptionPane.showMessageDialog(null, "Lập thành công.");
                model.setRowCount(0);

                txtMapx.setText(null);
                dateNgayTao.setDate(null);

            } else {
                JOptionPane.showMessageDialog(null, "Phiếu xuất chưa được lưu!");
            }
//            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();

        }

    }//GEN-LAST:event_btnLapActionPerformed

    private void tableThietBiCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tableThietBiCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tableThietBiCaretPositionChanged

    private void txtMapxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMapxKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isAlphabetic(c) || Character.isDigit(c) || Character.isISOControl(c)) {
            txtMapx.setEditable(true);
        } else
            txtMapx.setEditable(false);
    }//GEN-LAST:event_txtMapxKeyPressed

    private void txtTimKiemTBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemTBKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isAlphabetic(c) || Character.isDigit(c) || Character.isISOControl(c)) {
            txtTimKiemTB.setEditable(true);
        } else
            txtTimKiemTB.setEditable(false);
    }//GEN-LAST:event_txtTimKiemTBKeyPressed

    private void txtTimKiemSeriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemSeriKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isAlphabetic(c) || Character.isDigit(c) || Character.isISOControl(c)) {
            txtTimKiemSeri.setEditable(true);
        } else
            txtTimKiemSeri.setEditable(false);
    }//GEN-LAST:event_txtTimKiemSeriKeyPressed

    private void txtTimKiemTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemTBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemTBActionPerformed

    private void dateNgayTaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateNgayTaoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateNgayTaoKeyPressed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        dao.Load_Tb_to_Xuathang(tableThietBi);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseExited
        btnReset.setBackground(Color.white);
        btnReset.setForeground(Color.black);
    }//GEN-LAST:event_btnResetMouseExited

    private void btnResetMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseMoved
       btnReset.setBackground(Color.blue);
        btnReset.setForeground(Color.white);
    }//GEN-LAST:event_btnResetMouseMoved

    private void btnBoChonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoChonMouseExited
       btnBoChon.setBackground(Color.white);
        btnBoChon.setForeground(Color.black);
    }//GEN-LAST:event_btnBoChonMouseExited

    private void btnBoChonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoChonMouseMoved
        btnBoChon.setBackground(Color.blue);
        btnBoChon.setForeground(Color.white);
    }//GEN-LAST:event_btnBoChonMouseMoved

    private void btnHuyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseExited
        btnHuy.setBackground(Color.white);
        btnHuy.setForeground(Color.black);
    }//GEN-LAST:event_btnHuyMouseExited

    private void btnHuyMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseMoved
        btnHuy.setBackground(Color.blue);
        btnHuy.setForeground(Color.white);
    }//GEN-LAST:event_btnHuyMouseMoved

    private void btnLapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLapMouseExited
        btnLap.setBackground(Color.white);
        btnLap.setForeground(Color.black);
    }//GEN-LAST:event_btnLapMouseExited

    private void btnLapMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLapMouseMoved
        btnLap.setBackground(Color.blue);
        btnLap.setForeground(Color.white);
    }//GEN-LAST:event_btnLapMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBoChon;
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLap;
    private javax.swing.JButton btnReset;
    private com.toedter.calendar.JDateChooser dateNgayTao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableCTPX;
    private javax.swing.JTable tableSoseri;
    private javax.swing.JTable tableThietBi;
    private javax.swing.JTextField txtMapx;
    private javax.swing.JTextField txtTimKiemSeri;
    private javax.swing.JTextField txtTimKiemTB;
    private javax.swing.JDialog xuatDialog;
    // End of variables declaration//GEN-END:variables
}
