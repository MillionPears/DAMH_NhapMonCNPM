package Controller;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Test {

    public static void main(String[] args) {
        // Tạo JTable mới
        JTable table = new JTable();

        // Tạo DefaultTableModel để lưu trữ dữ liệu cho JTable
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);

        // Tạo ArrayList String và thêm dữ liệu
        ArrayList<String> data = new ArrayList<>();
        data.add("Item 1");
        data.add("Item 2");
        data.add("Item 3");

        // Chuyển ArrayList String thành một mảng để thêm vào hàng mới của JTable
        String[] rowData = data.toArray(new String[data.size()]);
        model.addRow(rowData);

        // Tạo JFrame mới và thêm JScrollPane chứa JTable vào giao diện người dùng
        JFrame frame = new JFrame();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}
