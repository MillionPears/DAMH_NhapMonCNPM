/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Other;

import java.awt.Color;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class Check {

    public String formatName(String name) {
        // Xoá khoảng trắng dư thừa
        name = name.trim().replaceAll("\\s+", " ");

        // Tách các từ riêng lẻ và định dạng lại tên
        String[] words = name.split(" ");
        StringBuilder formattedName = new StringBuilder();
        for (String word : words) {
            if (word.matches("[\\p{L}]+")) { // chỉ chấp nhận các kí tự chữ cái trong Tiếng Việt
                formattedName.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return formattedName.toString().trim().toUpperCase();
    }

    public boolean isEmpty(JTextField textField) {
        if (textField.getText().trim().isEmpty()) {
            // Đổi màu nền của text field sang màu xám
            //textField.setBackground(Color.LIGHT_GRAY);
            // Focus vào text field
            textField.requestFocus();
            return false;
        } else {
            // Đổi màu nền của text field về màu trắng (mặc định)
            textField.setBackground(Color.WHITE);
        }
        return true;
    }

    public boolean isText(String str) {
        return str.matches("[a-zA-Z]+");
    }

    // Kiểm tra chuỗi chỉ chứa kí tự chữ và số, khong khoảng trắng và ksi tự đặc biệt
    public boolean kiemTraChuoi1(String chuoi) {
        // Tạo biểu thức chính quy để kiểm tra chuỗi
        String regex = "^[\\pL\\pN]+$"; // chỉ chứa chữ cái và số trong bảng mã Unicode

        // Kiểm tra chuỗi có khớp với biểu thức chính quy không
        return Pattern.matches(regex, chuoi);
    }

    public boolean kiemTraEmail(String email) {
        // Tạo biểu thức chính quy để kiểm tra email
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        // Kiểm tra email có khớp với biểu thức chính quy không
        return Pattern.matches(regex, email);
    }

    public boolean Kiemtrachuoi(String str) {
    // Tạo biểu thức chính quy để kiểm tra chuỗi
    String regex = "^[a-zA-Z0-9À-ỹ\\s\\/]+$";
    
    // Kiểm tra chuỗi với biểu thức chính quy
    return str.matches(regex);
}

    public boolean isText_Number(String str) {
        str = str.trim();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isLetterOrDigit(charArray[i])) {
                return false;
            }
        }
        return true;
    }

    public String Lay_10Kitu(String input) {
        String result = input.substring(0, 10).toUpperCase();
        return result;
    }

    public boolean isNumber(String str) {
        return str.matches("\\d+");
    }
// chấp nhận dấu trong tiếng việt
    public boolean isValidString(String str) {
        // Tạo biểu thức chính quy để kiểm tra chuỗi
        String regex = "^[a-zA-ZÀ-Ỹà-ỹ\\s\\/]+$";

        // Kiểm tra chuỗi với biểu thức chính quy
        return str.matches(regex);
    }
}
