/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAO;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author trieu
 */
public class ThongKe_SLPN {

    DAO dao = new DAO();
    int year = 2023;

    public ThongKe_SLPN() {
        JComboBox cbb_year = new JComboBox();
        cbb_year = dao.get_Year("PHIEU_NHAP", "NGAYNHAP");
        if (cbb_year.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa tồn tại phiếu nhập nào!", "Lỗi ", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, cbb_year, "Chọn năm cần thống kê ", JOptionPane.INFORMATION_MESSAGE);
            year = (int) cbb_year.getSelectedItem();
            initUI();
        }
    }

    private void initUI() {
        ChartPanel chartPanel = new ChartPanel(createChart());
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 1; i <= 12; i++) {
            int total = dao.get_tongPN_theothang(i, year);
            dataset.setValue(total, "SỐ LƯỢNG", String.valueOf(i));
        }
        return dataset;
    }

    public JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "TỔNG PHIẾU NHẬP THEO TỪNG THÁNG",
                "THÁNG", "SÓ LƯỢNG",
                createDataset());
        return barChart;

    }
}
