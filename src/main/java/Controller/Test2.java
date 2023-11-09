/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.*;
import javax.swing.*;

public class Test2 {
    public static void main(String[] args) {
        // Tạo một JFrame
        JFrame frame = new JFrame("Web Style Background");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Tạo một JPanel để hiển thị nội dung
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // Vẽ một hình chữ nhật làm nền
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());

                // Vẽ hình ảnh làm nền
                ImageIcon icon = new ImageIcon("D:\\HK2_3\\Gym_EquipMent\\Gym\\src\\main\\resources\\Image_resources\\HOME.png");
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        contentPane.setLayout(new BorderLayout());
        frame.setContentPane(contentPane);

        // Thêm các thành phần vào contentPane
        // ...

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
