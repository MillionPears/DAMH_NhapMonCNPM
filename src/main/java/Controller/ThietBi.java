/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package controller;

import DAO.*;

import Controller.VungTap_ChiTiet_Dialog;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ThietBi extends javax.swing.JPanel {

    VungTap_ChiTiet_Dialog thietBi_ChiTiet_Dialog;
    DAO dao = new DAO();

    public ThietBi() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnNguc = new javax.swing.JButton();
        btnVai = new javax.swing.JButton();
        btnTay = new javax.swing.JButton();
        btnBung = new javax.swing.JButton();
        btnDui = new javax.swing.JButton();
        btnChan = new javax.swing.JButton();
        btnLung = new javax.swing.JButton();

        setBackground(java.awt.Color.darkGray);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/aaa.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnNguc.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnNguc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/NGUC.png"))); // NOI18N
        btnNguc.setText("Vùng Ngực");
        btnNguc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));
        btnNguc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNguc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNguc.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnNgucMouseMoved(evt);
            }
        });
        btnNguc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNgucMouseExited(evt);
            }
        });
        btnNguc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgucActionPerformed(evt);
            }
        });

        btnVai.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnVai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/VAI.png"))); // NOI18N
        btnVai.setText("Vùng Vai");
        btnVai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));
        btnVai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVai.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVai.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnVaiMouseMoved(evt);
            }
        });
        btnVai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVaiMouseExited(evt);
            }
        });
        btnVai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaiActionPerformed(evt);
            }
        });

        btnTay.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnTay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/TAY.jpg"))); // NOI18N
        btnTay.setText("Vùng Tay");
        btnTay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));
        btnTay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTay.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTay.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTayMouseMoved(evt);
            }
        });
        btnTay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTayMouseExited(evt);
            }
        });
        btnTay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTayActionPerformed(evt);
            }
        });

        btnBung.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnBung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/BUNG.png"))); // NOI18N
        btnBung.setText("Vùng Bụng");
        btnBung.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));
        btnBung.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBung.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBung.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBungMouseMoved(evt);
            }
        });
        btnBung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBungMouseExited(evt);
            }
        });
        btnBung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBungActionPerformed(evt);
            }
        });

        btnDui.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnDui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/DUI.png"))); // NOI18N
        btnDui.setText("Vùng Đùi");
        btnDui.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));
        btnDui.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDui.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDui.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnDuiMouseMoved(evt);
            }
        });
        btnDui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDuiMouseExited(evt);
            }
        });
        btnDui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuiActionPerformed(evt);
            }
        });

        btnChan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnChan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/CHAN.png"))); // NOI18N
        btnChan.setText("Vùng Chân");
        btnChan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));
        btnChan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChan.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnChanMouseMoved(evt);
            }
        });
        btnChan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnChanMouseExited(evt);
            }
        });
        btnChan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChanActionPerformed(evt);
            }
        });

        btnLung.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnLung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image_resources/LUNG.png"))); // NOI18N
        btnLung.setText("Vùng Lưng");
        btnLung.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));
        btnLung.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLung.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLung.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnLungMouseMoved(evt);
            }
        });
        btnLung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLungMouseExited(evt);
            }
        });
        btnLung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVai, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNguc, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTay, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBung, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDui, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLung, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNguc, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTay, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBung, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDui, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChan, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLung, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVai, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNgucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgucActionPerformed
        String mavt = "NGUC";
        VungTap_ChiTiet_Dialog vungTap_ChiTiet_Dialog = new VungTap_ChiTiet_Dialog(null, true, mavt);
        vungTap_ChiTiet_Dialog.setTitle("Các thiết bị thuộc vùng tập này!");
        vungTap_ChiTiet_Dialog.setVisible(true);

    }//GEN-LAST:event_btnNgucActionPerformed

    private void btnVaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaiActionPerformed
        String mavt = "VAI";
        VungTap_ChiTiet_Dialog vungTap_ChiTiet_Dialog = new VungTap_ChiTiet_Dialog(null, true, mavt);
        vungTap_ChiTiet_Dialog.setTitle("Các thiết bị thuộc vùng tập này!");
        vungTap_ChiTiet_Dialog.setVisible(true);

    }//GEN-LAST:event_btnVaiActionPerformed

    private void btnTayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTayActionPerformed
        String mavt = "TAY";
        VungTap_ChiTiet_Dialog vungTap_ChiTiet_Dialog = new VungTap_ChiTiet_Dialog(null, true, mavt);
        vungTap_ChiTiet_Dialog.setTitle("Các thiết bị thuộc vùng tập này!");
        vungTap_ChiTiet_Dialog.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnTayActionPerformed

    private void btnBungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBungActionPerformed
        String mavt = "BUNG";
        VungTap_ChiTiet_Dialog vungTap_ChiTiet_Dialog = new VungTap_ChiTiet_Dialog(null, true, mavt);
        vungTap_ChiTiet_Dialog.setTitle("Các thiết bị thuộc vùng tập này!");
        vungTap_ChiTiet_Dialog.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnBungActionPerformed

    private void btnDuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuiActionPerformed
        String mavt = "DUI";
        VungTap_ChiTiet_Dialog vungTap_ChiTiet_Dialog = new VungTap_ChiTiet_Dialog(null, true, mavt);
        vungTap_ChiTiet_Dialog.setTitle("Các thiết bị thuộc vùng tập này!");
        vungTap_ChiTiet_Dialog.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnDuiActionPerformed

    private void btnChanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChanActionPerformed
        String mavt = "CHAN";
        VungTap_ChiTiet_Dialog vungTap_ChiTiet_Dialog = new VungTap_ChiTiet_Dialog(null, true, mavt);
        vungTap_ChiTiet_Dialog.setTitle("Các thiết bị thuộc vùng tập này!");
        vungTap_ChiTiet_Dialog.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnChanActionPerformed

    private void btnLungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLungActionPerformed
        String mavt = "LUNG";
        VungTap_ChiTiet_Dialog vungTap_ChiTiet_Dialog = new VungTap_ChiTiet_Dialog(null, true, mavt);
        vungTap_ChiTiet_Dialog.setTitle("Các thiết bị thuộc vùng tập này!");
        vungTap_ChiTiet_Dialog.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnLungActionPerformed

    private void btnVaiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVaiMouseMoved
        btnVai.setToolTipText("Click vào để xem thông tin những thiết bị thuộc vùng tập Vai!");
        btnVai.setBackground(Color.blue);
        btnVai.setForeground(Color.white);
    }//GEN-LAST:event_btnVaiMouseMoved

    private void btnNgucMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNgucMouseMoved
        btnNguc.setToolTipText("Click vào để xem thông tin những thiết bị thuộc vùng tập Ngực!");
        btnNguc.setBackground(Color.blue);
        btnNguc.setForeground(Color.white);
    }//GEN-LAST:event_btnNgucMouseMoved

    private void btnTayMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTayMouseMoved
        btnTay.setToolTipText("Click vào để xem thông tin những thiết bị thuộc vùng tập Tay!");
        btnTay.setBackground(Color.blue);
        btnTay.setForeground(Color.white);

    }//GEN-LAST:event_btnTayMouseMoved

    private void btnBungMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBungMouseMoved
        btnBung.setToolTipText("Click vào để xem thông tin những thiết bị thuộc vùng tập Bụng!");
        btnBung.setBackground(Color.blue);
        btnBung.setForeground(Color.white);

    }//GEN-LAST:event_btnBungMouseMoved

    private void btnDuiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDuiMouseMoved
        btnDui.setToolTipText("Click vào để xem thông tin những thiết bị thuộc vùng tập Đùi!");
        btnDui.setBackground(Color.blue);
        btnDui.setForeground(Color.white);

    }//GEN-LAST:event_btnDuiMouseMoved

    private void btnChanMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChanMouseMoved
        btnChan.setToolTipText("Click vào để xem thông tin những thiết bị thuộc vùng tập Chân!");
        btnChan.setBackground(Color.blue);
        btnChan.setForeground(Color.white);

    }//GEN-LAST:event_btnChanMouseMoved

    private void btnLungMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLungMouseMoved
        btnLung.setToolTipText("Click vào để xem thông tin những thiết bị thuộc vùng tập Lưng!");
        btnLung.setBackground(Color.blue);
        btnLung.setForeground(Color.white);

    }//GEN-LAST:event_btnLungMouseMoved

    private void btnVaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVaiMouseExited
        btnVai.setBackground(Color.white);
        btnVai.setForeground(Color.black);
    }//GEN-LAST:event_btnVaiMouseExited

    private void btnNgucMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNgucMouseExited
        btnNguc.setBackground(Color.white);
        btnNguc.setForeground(Color.black);
    }//GEN-LAST:event_btnNgucMouseExited

    private void btnTayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTayMouseExited
        btnTay.setBackground(Color.white);
        btnTay.setForeground(Color.black);
    }//GEN-LAST:event_btnTayMouseExited

    private void btnBungMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBungMouseExited
        btnBung.setBackground(Color.white);
        btnBung.setForeground(Color.black);
    }//GEN-LAST:event_btnBungMouseExited

    private void btnDuiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDuiMouseExited
       btnDui.setBackground(Color.white);
        btnDui.setForeground(Color.black);
    }//GEN-LAST:event_btnDuiMouseExited

    private void btnChanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChanMouseExited
        btnChan.setBackground(Color.white);
        btnChan.setForeground(Color.black);
    }//GEN-LAST:event_btnChanMouseExited

    private void btnLungMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLungMouseExited
        btnLung.setBackground(Color.white);
        btnLung.setForeground(Color.black);
    }//GEN-LAST:event_btnLungMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBung;
    private javax.swing.JButton btnChan;
    private javax.swing.JButton btnDui;
    private javax.swing.JButton btnLung;
    private javax.swing.JButton btnNguc;
    private javax.swing.JButton btnTay;
    private javax.swing.JButton btnVai;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
