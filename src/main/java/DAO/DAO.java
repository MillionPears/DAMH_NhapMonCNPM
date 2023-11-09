/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.*;
import Other.*;
import Models.*;
import Models.ThietBiModels;
import com.toedter.calendar.JDateChooser;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trieu
 */
public class DAO {

    public Connection conn;
    PreparedStatement sttm = null;

// Kết nối db
    public DAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS01:1433;database=GYM_EQUIPMENT;trustServerCertificate=true;";
            String username = "sa";
            String password = "19001005";
            conn = DriverManager.getConnection(connectionUrl, username, password);
            // Statement stmt = conn.createStatement();

        } catch (Exception e) {
            System.out.println("30");
        }
    }

    public static void main(String[] args) {
        new DAO();
    }

    // Lấy thông tin thiết bị từ DB
    public ArrayList<ThietBiModels> getTBModel() {
        ArrayList<ThietBiModels> list = new ArrayList<>();
        String sql = "SELECT * FROM THIET_BI";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                ThietBiModels tb = new ThietBiModels();
                tb.setMaThietBi(rs.getString("IDTHIETBI"));
                tb.setTenThietBi(rs.getString("TENTHIETBI"));
                //tb.setSoluong(rs.getInt("SOLUONG"));
                tb.setMota(rs.getString("MOTA"));
                //tb.setThuocTinhKhac(rs.getString("THUOCTINHKHAC"));
                tb.setAnh(rs.getString("ANH"));
                list.add(tb);
            }
        } catch (Exception e) {
            System.out.println("63");
            System.out.println("Error: " + e.toString());
        }
        return list;
    }

    // Đổ thông tin thiết bị vào bảng Edit
    public void Load_Tb_to_Edit(JTable table) {
        ArrayList<ThietBiModels> list = getTBModel();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {

            model.addRow(new Object[]{
                i + 1, list.get(i).getMaThietBi(), list.get(i).getTenThietBi()
            });
        }
        model.fireTableDataChanged();
    }

    // Tìm kiếm thiết bị theo tên
    public ArrayList<ThietBiModels> TimKiemTheoTen(String s) {
        ArrayList<ThietBiModels> list = new ArrayList<>();
        String sql = "SELECT * FROM THIET_BI WHERE TENTHIETBI LIKE '%" + s + "%' ";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();

            while (rs.next()) {
                ThietBiModels tb = new ThietBiModels();
                tb.setMaThietBi(rs.getString("IDTHIETBI"));
                tb.setTenThietBi(rs.getString("TENTHIETBI"));
                list.add(tb);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("97");
        }
        return list;
    }

    // Gợi ý Thiết Bị
    public void Load_tb_GoiY(JTable table, JTextField txt) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<ThietBiModels> tmp = TimKiemTheoTen(txt.getText());
        for (int i = 0; i < tmp.size(); i++) {
            model.addRow(new Object[]{
                i + 1, tmp.get(i).getMaThietBi(), tmp.get(i).getTenThietBi()
            });
        }
        model.fireTableDataChanged();
    }

    // Lấy tất cả các mã vùng tập của 1 thiết bị
    public ArrayList<String> getMaVT_From_ID(String id) {

        String sql = "SELECT MAVT FROM CT_VUNGTAP WHERE IDTHIETBI ='" + id + "'";
        ArrayList<String> res = new ArrayList<>();
        try {
            sttm = conn.prepareStatement(sql);
            //sttm.setString(1, id);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                res.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("134");
        }
        return res;
    }

    // Lấy thông tin thiết bị từ ID
    public ThietBiModels getTB_From_ID(String id) {
        String sql = "SELECT * FROM THIET_BI WHERE IDTHIETBI = '" + id + "'";
        ArrayList<String> list = getMaVT_From_ID(id);

        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                ThietBiModels tb = createThietBi(rs, id);
                tb.setVungTap(list);
                return tb;
            }
        } catch (Exception e) {
            System.out.println("154");
            //e.printStackTrace();
            System.out.println("Error: " + e.toString());
        }
        return null;
    }

    // Hàm láy thông tin thiết bị từ database
    private ThietBiModels createThietBi(ResultSet rs, String id) throws SQLException {
        ThietBiModels tb = new ThietBiModels();
        tb.setMaThietBi(rs.getString("IDTHIETBI"));
        tb.setTenThietBi(rs.getString("TENTHIETBI"));
        tb.setSoluong(get_SoLuongTB_From_id(id));
        tb.setMota(rs.getString("MOTA"));
        //tb.setThuocTinhKhac(rs.getString("THUOCTINHKHAC"));
        tb.setAnh(rs.getString("ANH"));
        //tb.setQuyDinh(rs.getString("QUYDINH"));
        tb.sethDSD(rs.getString("HDSD"));
        return tb;

    }

    // Cập nhật dữ liệu cho thiết bị
    public boolean update_TB(JTextField txt1, JTextField txt2, JTextArea txt3, String id_tb) {
        try {
//            String ten = txt1.getText();
            String sql = "update THIET_BI SET "
                    + "TENTHIETBI = N'" + txt1.getText() + "',  ANH = '" + txt2.getText() + "', "
                    + "MOTA =N'" + txt3.getText() + "' WHERE IDTHIETBI = '" + id_tb + "'";
            sttm = conn.prepareStatement(sql);
            //sttm.setInt(2, 0);
            //sttm.setInt(3, 0);
            return sttm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("186");
        }
        return false;
    }
    // Hàm lấy thông tin số seri từ database

    private SoSeriModels createSoSeri(ResultSet rs) throws SQLException {
        SoSeriModels seri = new SoSeriModels();
        seri.setSoseri(rs.getString("SOSERI"));
        seri.setGia(rs.getInt("GIA"));
        seri.setIDTHIETBI(rs.getString("IDTHIETBI"));
        seri.setTrangThai(rs.getInt("TRANGTHAI"));
        seri.setMaPN(rs.getString("MAPN"));
        seri.setMaPX(rs.getString("MAPX"));
        seri.setMaNCC(rs.getString("MANCC"));
        seri.setMaPhong(rs.getString("MAPHONG"));
        seri.setMaKho(rs.getString("MAKHO"));
        return seri;
    }

    // Hàm lấy tất cả số seri từ IDTHIETBI
    public ArrayList<String> get_Soseri_From_IDTB(String id) {
        ArrayList<String> list_seri = new ArrayList<>();
        String sql = "SELECT SOSERI FROM SOSERI WHERE IDTHIETBI = '" + id + "'";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                String seri = rs.getString("SOSERI");
                list_seri.add(seri);
            }
        } catch (Exception e) {
            System.out.println("222");
            //e.printStackTrace();
            System.out.println("Error: " + e.toString());
        }
        return list_seri;
    }

    // Lấy thông tin của số seri từ số seri
    public SoSeriModels get_ALL_Soseri_From_Soseri(String soseri) {

        String sql = "SELECT * FROM SOSERI WHERE SOSERI = '" + soseri + "'";

        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                SoSeriModels seri = createSoSeri(rs);
                return seri;
            }
        } catch (Exception e) {
            System.out.println("245");
            System.out.println("Error: " + e.toString());
        }

        return null;
    }

    // Cập nhật dữ liệu cho số seri
    // Thêm dữ liệu Thiết bị vào DB
    public boolean update_Soseri(JTextField txt1, JTextField txt2, JTextField txt3, String soseri) {
        int tt = -1;
        if (txt1.getText().equals("Bình thường")) {
            tt = 0;
        } else if (txt1.getText().equals("Đang bảo trì")) {
            tt = 1;
        } else {
            tt = 2;
        }
        String sql = "";
        if (txt2.getText().isEmpty()) {
            sql = "update SOSERI SET "
                    + "TRANGTHAI =" + tt + ","
                    + "MAKHO='" + txt3.getText() + "' WHERE SOSERI = '" + soseri + "'";
        } else {
            sql = "update SOSERI SET "
                    + "TRANGTHAI =" + tt + ","
                    + "  MAPHONG = '" + txt2.getText() + "', "
                    + "MAKHO='" + txt3.getText() + "' WHERE SOSERI = '" + soseri + "'";
        }
        try {
            sttm = conn.prepareStatement(sql);
            return sttm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("273");
        }
        return false;
    }

    // Lấy thông tin của phiếu nhập
    public ArrayList<String> get_PhieuNhap() {
        String sql = "SELECT MAPN FROM PHIEU_NHAP ";
        ArrayList<String> list_pn = new ArrayList<>();
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            String mapn;
            while (rs.next()) {
                mapn = rs.getString("MAPN");
                list_pn.add(mapn);
            }
        } catch (Exception e) {
            System.out.println("278");
            System.out.println("Error: " + e.toString());
        }
        return list_pn;
    }

    // đổ Danh sách phiếu nhập vào bảng DSPN
    public void Load_to_DSPN(JTable table) {
        ArrayList<String> list = get_PhieuNhap();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {

            model.addRow(new Object[]{
                i + 1, list.get(i)
            });
        }
        model.fireTableDataChanged();
    }

    // Tìm kiếm phiếu nhạp theo tên
    public ArrayList<String> TimKiemPhieuNhap(String s) {
        ArrayList<String> list_pn = new ArrayList<>();
        String sql = "SELECT MAPN FROM PHIEU_NHAP WHERE MAPN LIKE '%" + s + "%' ";

        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();

            while (rs.next()) {
                String mapn = rs.getString("MAPN");
                list_pn.add(mapn);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("311");
        }
        return list_pn;
    }

    // Gợi ý phiếu nhập
    public void Load_PN_GoiY(JTable table, JTextField txt) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<String> tmp = TimKiemPhieuNhap(txt.getText());
        for (int i = 0; i < tmp.size(); i++) {
            model.addRow(new Object[]{
                i + 1, tmp.get(i)
            });
        }
        model.fireTableDataChanged();
    }

    // Lấy giá từ số seri
    public int getGia_from_Soseri(String soseri) {
        String sql = "SELECT GIA FROM SOSERI WHERE SOSERI ='" + soseri + "' ";
        int seri = 0;
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                seri = rs.getInt("GIA");
                return seri;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("345");
        }
        return 0;
    }

    //Lấy tên Thiết bị từ số seri
    public String gettenTB_from_Soseri(String soseri) {
        String sql = "SELECT TENTHIETBI FROM THIET_BI WHERE IDTHIETBI = (SELECT IDTHIETBI FROM SOSERI WHERE SOSERI ='" + soseri + "')";
        String tentb = "";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                tentb = rs.getString("TENTHIETBI");

                return tentb;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("357");
        }
        return null;
    }

    //Láy MAPN từ số seri
    public ArrayList<String> getSoseri_From_MAPN(String mapn) {
        String sql = "SELECT SOSERI FROM SOSERI WHERE MAPN ='" + mapn + "' ";
        ArrayList<String> list_soseri = new ArrayList<>();
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                String soseri = rs.getString("SOSERI");
                list_soseri.add(soseri);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("380");
        }

        return list_soseri;
    }

    // Đổ Thông tin Phiếu nhập vào bảng Chi tiết DSPN
    public void Load_CTPN_to_DSPN(JTable table, String mapn) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<String> list_soseri = getSoseri_From_MAPN(mapn);
        for (int i = 0; i < list_soseri.size(); i++) {

            String tentb = gettenTB_from_Soseri(list_soseri.get(i));
            int gia = getGia_from_Soseri(list_soseri.get(i));
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String str1 = currencyVN.format(gia);
            model.addRow(new Object[]{
                i + 1, list_soseri.get(i), tentb, str1
            });
        }
        model.fireTableDataChanged();
//        for (int i = 0; i < list_soseri.size(); i++) {
//            System.out.println(list_soseri.get(i));
//        }
    }

    // Lấy thông tin nhân viên từ MAPN
    public String getNV_from_MAPN(String mapn) {
        String sql = "SELECT MANV, HOTEN=HO +' '+ TEN FROM NHAN_VIEN WHERE MANV = (SELECT MANV FROM PHIEU_NHAP WHERE MAPN ='" + mapn + "')";
        String manv = "";
        String hoten = "";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                manv = rs.getString("MANV");
                hoten = rs.getString("HOTEN");
                return manv + " - " + hoten;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("429");
        }
        return null;
    }
//    // Láy ngày tạo từ MAPN

    public String getNgay_from_MAPN(String mapn) {
        String sql = "SELECT NGAYNHAP FROM PHIEU_NHAP WHERE MAPN = '" + mapn + "'";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                Date date = rs.getDate("NGAYNHAP");
                String dateFormat = date.toString();
                return dateFormat;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("449");
        }
        return null;
    }
    // Lấy thông tin của phiếu xuất

    public ArrayList<String> get_PhieuXuat() {
        String sql = "SELECT MAPX FROM PHIEU_XUAT ";
        ArrayList<String> list_px = new ArrayList<>();
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            String mapx;
            while (rs.next()) {
                mapx = rs.getString("MAPX");
                list_px.add(mapx);
            }
        } catch (Exception e) {
            System.out.println("466");
            System.out.println("Error: " + e.toString());
        }
        return list_px;
    }

    // đổ Danh sách phiếu xuất vào bảng DSPX
    public void Load_to_DSPX(JTable table) {
        ArrayList<String> list = get_PhieuXuat();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {

            model.addRow(new Object[]{
                i + 1, list.get(i)
            });
        }
        model.fireTableDataChanged();
    }

    // Tìm kiếm phiếu xuất theo tên
    public ArrayList<String> TimKiemPhieuXuat(String s) {
        ArrayList<String> list_pn = new ArrayList<>();
        String sql = "SELECT MAPX FROM PHIEU_XUAT WHERE MAPX LIKE '%" + s + "%' ";

        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();

            while (rs.next()) {
                String mapx = rs.getString("MAPX");
                list_pn.add(mapx);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("499");
        }
        return list_pn;
    }

    // Gợi ý phiếu nhập
    public void Load_PX_GoiY(JTable table, JTextField txt) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<String> tmp = TimKiemPhieuXuat(txt.getText());
        for (int i = 0; i < tmp.size(); i++) {
            model.addRow(new Object[]{
                i + 1, tmp.get(i)
            });
        }
        model.fireTableDataChanged();
    }

    // Lấy thông tin nhân viên từ MAPN
    public String getNV_from_MAPX(String mapx) {
        String sql = "SELECT MANV, HOTEN=HO +' '+ TEN FROM NHAN_VIEN WHERE MANV = (SELECT MANV FROM PHIEU_XUAT WHERE MAPX ='" + mapx + "')";
        String manv = "";
        String hoten = "";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                manv = rs.getString("MANV");
                hoten = rs.getString("HOTEN");
                return manv + " - " + hoten;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("531");
        }
        return null;
    }

    //Láy MAPX từ số seri
    public ArrayList<String> getSoseri_From_MAPX(String mapx) {
        String sql = "SELECT SOSERI FROM SOSERI WHERE MAPX ='" + mapx + "' ";
        ArrayList<String> list_soseri = new ArrayList<>();
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                String soseri = rs.getString("SOSERI");
                list_soseri.add(soseri);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("548");
        }

        return list_soseri;
    }

    // Lấy trạng thái từ số seri
    public String gettt_from_Soseri(String soseri) {
        String sql = "SELECT TRANGTHAI FROM SOSERI WHERE SOSERI ='" + soseri + "' ";
        String trangthaiString = "";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                int tt = rs.getInt("TRANGTHAI");
                if (tt == 1) {
                    trangthaiString = "Bình thường";
                } else if (tt == 2) {
                    trangthaiString = "Đang bảo trì";
                } else {
                    trangthaiString = "Bị hỏng";
                }
                return trangthaiString;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("580");
        }
        return null;
    }

    // Đổ Thông tin Phiếu Xuất vào bảng Chi tiết DSPX
    public void Load_CTPX_to_DSPX(JTable table, String mapx) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<String> list_soseri = getSoseri_From_MAPX(mapx);
        for (int i = 0; i < list_soseri.size(); i++) {

            String tentb = gettenTB_from_Soseri(list_soseri.get(i));
            String tt = gettt_from_Soseri(list_soseri.get(i));
            model.addRow(new Object[]{
                i + 1, list_soseri.get(i), tentb, tt
            });
        }
        model.fireTableDataChanged();
//        for (int i = 0; i < list_soseri.size(); i++) {
//            System.out.println(list_soseri.get(i));
//        }
    }

//Kiểm tra xem Mã Phiếu nhập có bị trùng hay không
    public boolean Check_PN_Trung(String mapn) {
        //? tìm thấy ..hỏi có muốn khôi phục kh
        String sql = "select * from PHIEU_NHAP  where MAPN=?";

        try {
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, mapn);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("615");
        }
        return true;
    }
// Láy mã Kho từ KHo

    public ArrayList<String> get_MaKho_From_Kho() {

        String sql = "select MAKHO FROM KHO";
        ArrayList<String> list_maKHo = new ArrayList<>();
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                String makho = rs.getString("MAKHO");
                list_maKHo.add(makho);
            }

        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("640");
        }
        return list_maKHo;
    }

    // Lấy Thiết bị từ mã vùng tập trong CT_VT
    public ArrayList<String> get_IDTB_From_MaVT(String mavt) {

        String sql = "select IDTHIETBI FROM CT_VUNGTAP WHERE MAVT ='" + mavt + "'";
        ArrayList<String> list_id = new ArrayList<>();
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("IDTHIETBI");

                list_id.add(id);
            }

        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("661");
        }
        return list_id;
    }

//    public ThietBiModels getTB_From_IDTB(String id) {
//        String sql = "SELECT * FROM THIET_BI WHERE IDTHIETBI = '" + id + "'";
//        try {
//            sttm = conn.prepareStatement(sql);
//            ResultSet rs = sttm.executeQuery();
//            if (rs.next()) {
//                ThietBiModels tb = createThietBi(rs, id);
//                return tb;
//            }
//        } catch (Exception e) {
//            System.out.println("154");
//            //e.printStackTrace();
//            System.out.println("Error: " + e.toString());
//        }
//        return null;
//    }
    // ĐỔ thiết bị vào bảng CTVT
    public void Load_Tb_to_CTVT(JTable table, String mavt) {
        ArrayList<String> list_idtb = get_IDTB_From_MaVT(mavt);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list_idtb.size(); i++) {
            ThietBiModels tb = getTB_From_ID(list_idtb.get(i));
            model.addRow(new Object[]{
                i + 1, tb.getMaThietBi(), tb.getTenThietBi()
            });
            model.fireTableDataChanged();
        }
    }

    // Lấy tất cả só seri từ IDTHietBI
    public JComboBox get_ALL_Soseri_From_IDTB(String idtb, JComboBox cbb) {

        String sql = "SELECT SOSERI FROM SOSERI WHERE IDTHIETBI = '" + idtb + "' AND TRANGTHAI != 2";
        //ArrayList<SoSeriModels> list = new ArrayList<>();
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            cbb.removeAllItems();
            while (rs.next()) {
                String soseri = rs.getString("SOSERI");
                cbb.addItem(soseri);
            }
        } catch (Exception e) {
            System.out.println("715");
            System.out.println("Error: " + e.toString());
        }

        return cbb;
    }

    // Hàm lấy thông tin của phòng
    private PhongModels createPhong(ResultSet rs) throws SQLException {
        PhongModels phong = new PhongModels();
        phong.setMaPhong(rs.getString("MAPHONG"));
        phong.setTenPhong(rs.getString("TENPHONG"));
        return phong;
    }

    // Lấy thông tin các phòng
    public JComboBox get_PhongModels(JComboBox cbb) {

        String sql = "select MAPHONG FROM PHONG";
        //ArrayList<PhongModels> list_maphong= new ArrayList<>();
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                String maphong = rs.getString("MAPHONG");
                cbb.addItem(maphong);
            }

        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("742");
        }
        return cbb;
    }

    // Lấy mã kho từ Kho _ CBB
    public JComboBox get_MaKho_toComboBox(JComboBox cbb) {

        String sql = "select MAKHO FROM KHO";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                String makho = rs.getString("MAKHO");
                cbb.addItem(makho);
            }

        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("760");
        }
        return cbb;
    }

    //Láy mã NCC từ NCC
    public ArrayList<String> get_MaNCC_From_NCC() {

        String sql = "select MANCC FROM NHA_CUNG_CAP";
        ArrayList<String> list_mancc = new ArrayList<>();
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                String mancc = rs.getString("MANCC");
                list_mancc.add(mancc);
            }

        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("788");
        }
        return list_mancc;
    }

    // Thêm số seri vào DB
    public boolean add_soseri(String seri, String id, int tt, String mapn, String makho, String mancc, int gia) {
        try {
            String sql = "insert SOSERI(SOSERI,IDTHIETBI,TRANGTHAI,MAPN,MAKHO,MANCC,GIA)"
                    + "values(?,?,?,?,?,?,?)";

            sttm = conn.prepareStatement(sql);
            sttm.setString(1, seri);
            sttm.setString(2, id);
            sttm.setInt(3, tt);
            sttm.setString(4, mapn);
            sttm.setString(5, makho);
            sttm.setString(6, mancc);
            sttm.setInt(7, gia);
            return sttm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("810");
        }
        return false;
    }

    // Thêm phiếu nhập vào db
    public boolean add_PN(String mapn, String manv) {
        try {
            String sql = "insert PHIEU_NHAP(MAPN,NGAYNHAP,MANV)"
                    + "values(?,?,?)";

            sttm = conn.prepareStatement(sql);
            sttm.setString(1, mapn);
            Calendar cal = Calendar.getInstance();
            java.util.Date date = cal.getTime();

            //String tmp = String.valueOf(cal);
            sttm.setDate(2, new java.sql.Date(date.getTime()));
            sttm.setString(3, manv);
            return sttm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("831");
        }
        return false;
    }

    //Kiểm tra xem ID THIẾT BỊ có bị trùng hay không
    public boolean Check_ID_Trung(String id) {
        //? tìm thấy ..hỏi có muốn khôi phục kh
        String sql = "select IDTHIETBI from THIET_BI  where IDTHIETBI=?";

        try {
            sttm = conn.prepareStatement(sql);

            sttm.setString(1, id);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("853");
        }
        return true;
    }

    //Kiểm tra xem TÊN THIẾT BỊ có bị trùng hay không
    public boolean Check_tenTB_Trung(String ten) {
        String sql = "select TENTHIETBI from THIET_BI  where TENTHIETBI=?";

        try {
            sttm = conn.prepareStatement(sql);

            sttm.setString(1, ten);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("872");
        }
        return true;
    }

    //Kiểm tra xem ID THIẾT BỊ có bị trùng hay không
    public boolean Check_SERI_Trung(String seri) {
        //? tìm thấy ..hỏi có muốn khôi phục kh
        String sql = "select SOSERI from SOSERI  where SOSERI=?";

        try {
            sttm = conn.prepareStatement(sql);

            sttm.setString(1, seri);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("890");
        }
        return true;
    }

    // Thêm Thiết bị vào DB
    // Thêm số seri vào DB
    public boolean add_ThietBi(String idtb, String ten) {
        try {
            String sql = "insert THIET_BI(IDTHIETBI,TENTHIETBI)"
                    + "values(?,?)";

            sttm = conn.prepareStatement(sql);
            sttm.setString(1, idtb);
            sttm.setString(2, ten);

            return sttm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("913");
        }
        return false;
    }

    // Lọc phiếu xuất theo ngày
    public void Search_PX_theo_ngay(JDateChooser dateChooser1, JDateChooser dateChooser2, JTable table) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        String dateTuNgay = sdf.format(dateChooser1.getDate());
        System.out.println(dateTuNgay);

        String dateDenNgay = sdf.format(dateChooser2.getDate());

        if (dateTuNgay.compareTo(dateDenNgay) > 0) {
            JOptionPane.showMessageDialog(null, "Khung ngày lựa chọn không hợp lệ \n Vui lòng chọn lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {

            String sql = "select MAPX from PHIEU_XUAT  where NGAYXUAT BETWEEN '" + dateTuNgay + "' AND '" + dateDenNgay + "'";
            ArrayList<String> list_mapx = new ArrayList<>();
            try {
                sttm = conn.prepareStatement(sql);
                ResultSet rs = sttm.executeQuery();
                while (rs.next()) {
                    String mapx = rs.getString("MAPX");
                    list_mapx.add(mapx);
                }
            } catch (Exception e) {
                System.out.println("Error:" + e.toString());
                System.out.println("962");
            }
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (int i = 0; i < list_mapx.size(); i++) {

                model.addRow(new Object[]{
                    i + 1, list_mapx.get(i)
                });
            }
            model.fireTableDataChanged();
        }

    }

    // Tổng hợp số lượng phiếu xuất theo từng tháng
    public int get_tongPX_theothang(int thang) {
        String sql = "Select count(MAPX) AS SL_MAPX FROM PHIEU_XUAT WHERE MONTH(NGAYXUAT) =" + thang;
        int total = 0;
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                total = (rs.getInt("SL_MAPX"));
            }
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("988");
        }
        return total;
    }

    // Lấy thông tin tài khoản khi đăng nhập
    public TaiKhoanModels checkLogin(String tenDangNhap, String MatKhau) throws NoSuchAlgorithmException {
        TestMD5 test_mk = new TestMD5();
        MatKhau = test_mk.convertHashToString(MatKhau);
        String sql = "select USERNAME, PASS, MAQUYEN, TRANGTHAI from TAI_KHOAN where USERNAME ='" + tenDangNhap + "' AND PASS='" + MatKhau + "' AND TRANGTHAI = 1";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                TaiKhoanModels tk = new TaiKhoanModels();
                tk.setUserName(rs.getString("USERNAME"));
                //tk.setPassWord(rs.getString("PASS"));
                tk.setMaQuyen(rs.getString("MAQUYEN"));
                tk.setTrangThai(rs.getInt("TRANGTHAI"));
                return tk;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("1011");
        }
        return null;
    }

    // Lấy mã nv từ userName
//    public String get_MANV_from_USERNAME(String username) {
//
//        String sql = "select MANV FROM NHAN_VIEN WHERE USERNAME ='" + username + "'";
//        String manv = "";
//        try {
//            sttm = conn.prepareStatement(sql);
//            ResultSet rs = sttm.executeQuery();
//            if (rs.next()) {
//                manv = rs.getString("MANV");
//            }
//        } catch (Exception e) {
//            System.out.println("Error:" + e.toString());
//            System.out.println("1035");
//        }
//        return manv;
//    }
    // Lấy thông tin nhân viên từ username
    public NhanVienModels get_NV_from_USERNAME(String username) {

        String sql = "select * FROM NHAN_VIEN WHERE MANV ='" + username + "'";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                NhanVienModels nv = new NhanVienModels();
                nv.setMaNV(rs.getString("MANV"));
                String ho = rs.getString("HO");
                String ten = rs.getString("TEN");
                nv.setHoTen(ho + " " + ten);
                nv.setGioiTinh(rs.getString("PHAI"));
                nv.setChucVu(rs.getString("CHUCVU"));
                nv.setDiachi(rs.getString("DIACHI"));
                nv.setEmail(rs.getString("EMAIL"));
                nv.setSdt(rs.getString("SDT"));
                nv.setGioiTinh(rs.getString("PHAI"));
                nv.setNgaysinh(rs.getString("NGAYSINH"));
                return nv;
            }

        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("1060");
        }
        return null;
    }

    // Thay đổi mật khẩu của nhân viên
    public boolean update_Password(String user, String password) throws NoSuchAlgorithmException {
        TestMD5 test_mk = new TestMD5();
        String MatKhau = test_mk.convertHashToString(password);
        String sql = "update TAI_KHOAN SET PASS ='" + MatKhau + "' WHERE USERNAME = '" + user + "'";
        try {
            sttm = conn.prepareStatement(sql);
            return sttm.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("1074");
        }
        return false;
    }

    // Tổng hợp số lượng phiếu nhập theo từng tháng
    public int get_tongPN_theothang(int thang, int nam) {
        String sql = "Select count(MAPN) AS SL_MAPN FROM PHIEU_NHAP WHERE MONTH(NGAYNHAP) =" + thang + "AND YEAR(NGAYNHAP) =" + nam;
        int total = 0;
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                total = (rs.getInt("SL_MAPN"));
            }
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("1093");
        }
        return total;
    }

    // Lấy ngày xuất từ mapx
    public String getNgay_from_MAPX(String mapx) {
        String sql = "SELECT NGAYXUAT FROM PHIEU_XUAT WHERE MAPX = '" + mapx + "'";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                Date date = rs.getDate("NGAYXUAT");
                String dateFormat = date.toString();
                return dateFormat;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("1112");
        }
        return null;
    }

    // Lấy tất cả các mã vùng tập 
    public JList<String> getMaVT() {

        String sql = "SELECT MAVT FROM VUNG_TAP";
        DefaultListModel<String> model1 = new DefaultListModel<>();
        JList<String> myList1 = new JList<>(model1);

        try {
            sttm = conn.prepareStatement(sql);
            //sttm.setString(1, id);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                model1.addElement(rs.getString("MAVT"));
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("1131");
        }
        return myList1;
    }

    // Thêm số seri vào DB
    public boolean add_CTVT(String mavtString, String idtb) {
        try {
            String sql = "insert CT_VUNGTAP(MAVT, IDTHIETBI)"
                    + "values(?,?)";
            
            sttm = conn.prepareStatement(sql);
            sttm.setString(1, mavtString);
            sttm.setString(2, idtb);

            return sttm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("1149");
        }
        return false;
    }

    //Đổ số serial theo ID
    public ArrayList<String> Load_Serial_theo_id(String id) {
        // ArrayList<SoSeriModels> list = getSerialModel();
        String sql = "SELECT SOSERI FROM SOSERI WHERE IDTHIETBI = '" + id + "' AND TRANGTHAI = 2";
        ArrayList<String> list_seri = new ArrayList<String>();
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();

            while (rs.next()) {
                //SoSeriModels sr = new SoSeriModels();
                String seri = rs.getString("SOSERI");
                list_seri.add(seri);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("1171");
        }
        return list_seri;
    }

    //Đổ serial vào bảng
    public void Load_serial(JTable table, JTable table2, String id, String tmp) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
//        DefaultTableModel model3 = (DefaultTableModel) table3.getModel();
        model.setRowCount(0);
        ArrayList<String> sr = Load_Serial_theo_id(id);
        for (int i = 0; i < sr.size(); i++) {
            if (tmp.indexOf(sr.get(i)) == -1) {
                model.addRow(new Object[]{
                    i + 1, sr.get(i)
                });
                tmp += sr.get(i) + ",";
            } else {
                continue;
            }
        }
        model.fireTableDataChanged();
    }
    // Đổ thông tin vào bảng Xuathang

    public void Load_Tb_to_Xuathang(JTable table) {
        ArrayList<ThietBiModels> list = getTBModel();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {

            model.addRow(new Object[]{
                i + 1, list.get(i).getMaThietBi(), list.get(i).getTenThietBi()
            });
        }
        model.fireTableDataChanged();
    }

    public void Xuat_serial(JTable table1, JTable table2, JTable table3) {

//        TableModel model1 = jTable1.getModel();
//        TableModel model2 = jTable2.getModel();
        DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
        DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
        DefaultTableModel model3 = (DefaultTableModel) table3.getModel();
        int index = table1.getSelectedRow();
        int[] indexs = table2.getSelectedRows();
        Object[] row = new Object[4];
        for (int i = 0; i < indexs.length; i++) {
            row[2] = model2.getValueAt(indexs[i], 1);
            row[0] = model1.getValueAt(index, 1);
            row[1] = model1.getValueAt(index, 2);
            model3.addRow(row);
        }
    }

    public void Lap_phieu_xuat(String mapx, String manv, String date) {
        String query = "INSERT PHIEU_XUAT(MAPX, NGAYXUAT, MANV) VALUES(?,?,?)";
        try {
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, mapx);
            stm.setString(2, date);

            stm.setString(3, manv);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("1230");
        }
    }

    public void Gan_phieuxuat_vao_serial(JTable table, String mapx, String s) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int row = table.getRowCount();
//        String value = model.getValueAt(row, 2).toString();
        String query = "UPDATE SOSERI SET MAPX=? WHERE SOSERI= '" + s + "'";
        try {
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, mapx);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("1243");
        }
    }

    public Boolean Kiem_tra_PX(String mapx) {
        String query = "SELECT MAPX FROM PHIEU_XUAT WHERE MAPX like '" + '%' + mapx + '%' + "'";
        try {
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("1256");
        }
        return false;
    }

    // Hàm lấy số lượng thiết bị trong database
    public int get_SoLuongTB_From_id(String id) {
        // ArrayList<SoSeriModels> list = getSerialModel();
        String sql = "SELECT COUNT(SOSERI) FROM SOSERI WHERE IDTHIETBI = '" + id + "' AND TRANGTHAI != 2 ";
        int i = 0;
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();

            while (rs.next()) {
                i++;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("1263");
        }
        return i;
    }

    // Lấy tài khoản model
    public ArrayList<TaiKhoanModels> get_TaiKhoan_Model(String username) {
        ArrayList<TaiKhoanModels> list = new ArrayList<>();
        String sql = "SELECT * FROM TAI_KHOAN WHERE USERNAME != '" + username + "'";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();

            while (rs.next()) {
                TaiKhoanModels tk = new TaiKhoanModels();
                tk.setUserName(rs.getString("USERNAME"));
                tk.setTrangThai(rs.getInt("TRANGTHAI"));
                //tk.setMaNV(get_MANV_from_USERNAME(tk.getUserName()));
                tk.setMaQuyen(rs.getString("MAQUYEN"));
                list.add(tk);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("1285");
        }
        return list;
    }

    // Đổ vào table Danh Sách tài khoản
    public void Load_to_DSTK(JTable table, String username) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<TaiKhoanModels> list = get_TaiKhoan_Model(username);
        for (int i = 0; i < list.size(); i++) {
            int tt = list.get(i).getTrangThai();
//            String trangthai = " Đang hoạt động";
//            if (tt == 0) {
//                trangthai = "đã xóa";
//            }
            model.addRow(new Object[]{
                i + 1, list.get(i).getUserName(), tt
            });
        }
        model.fireTableDataChanged();
//        for (int i = 0; i < list_soseri.size(); i++) {
//            System.out.println(list_soseri.get(i));
//        }
    }
    // Thay đổi trạng thái của tài khoản
    public boolean update_TrangThai(String user, int tt) {

        String sql = "update TAI_KHOAN SET TRANGTHAI = " + tt + "WHERE USERNAME ='" + user + "'";
        try {
            sttm = conn.prepareStatement(sql);
            return sttm.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("1321");
        }
        return false;
    }

    // Hàm lấy tên quyền
    public ArrayList<String> get_Quyen() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT TENQUYEN FROM QUYEN_TRUY_CAP ";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();

            while (rs.next()) {

                String maquyen = rs.getString("TENQUYEN");
                list.add(maquyen);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("1364");
        }
        return list;
    }

    // Thêm Tài khoản vào db
    public boolean add_TK(String usename, String pass, String quyen, int tt) throws NoSuchAlgorithmException {
        TestMD5 test_mk = new TestMD5();
        String MatKhau = test_mk.convertHashToString(pass);
        try {
            String sql = "insert TAI_KHOAN(USERNAME, PASS, MAQUYEN, TRANGTHAI)"
                    + "values(?,?,?,?)";

            sttm = conn.prepareStatement(sql);
            sttm.setString(1, usename);
            sttm.setString(2, MatKhau);
            sttm.setString(3, quyen);
            sttm.setInt(4, tt);
            return sttm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("1384");
        }
        return false;
    }

    //Kiểm tra xem username có bị trùng hay không
    public boolean Check_NV_Trung(String id) {
        //? tìm thấy ..hỏi có muốn khôi phục kh
        String sql = "select MANV from NHAN_VIEN  where MANV=?";

        try {
            sttm = conn.prepareStatement(sql);

            sttm.setString(1, id);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("1405");
        }
        return true;
    }

    //Lấy những năm khác nhau trong bảng phiếu nhập
    public JComboBox get_Year(String tenbang, String tencot) {
        JComboBox year = new JComboBox();
        try {
            String sql = "SELECT DISTINCT YEAR(" + tencot + ") FROM " + tenbang;
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                year.addItem(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("1423");
        }
        return year;
    }
    // Thay đổi trạng thái của tài khoản

    public boolean update_TrangThai_Soseri(String seri, int tt) {
        String sql = "update SOSERI SET TRANGTHAI = " + tt + "WHERE SOSERI ='" + seri + "'";
        try {
            sttm = conn.prepareStatement(sql);

            return sttm.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("1438");
        }
        return false;
    }

// Thay đổi trạng thái của tài khoản
    public int update_TrangThai_Soseri_initial(String seri, int tt) {

        String sql = "UPDATE SOSERI SET TRANGTHAI = " + tt + " OUTPUT deleted.TRANGTHAI WHERE SOSERI = '" + seri + "'";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getInt(1));
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("1457");
        }
        return -1;
    }

    // Lọc phiếu nhập theo ngày
    public void Search_PN_theo_ngay(JDateChooser dateChooser1, JDateChooser dateChooser2, JTable table) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        String dateTuNgay = sdf.format(dateChooser1.getDate());
        System.out.println(dateTuNgay);

        String dateDenNgay = sdf.format(dateChooser2.getDate());

        if (dateTuNgay.compareTo(dateDenNgay) > 0) {
            JOptionPane.showMessageDialog(null, "Khung ngày lựa chọn không hợp lệ \n Vui lòng chọn lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {

            String sql = "select MAPN from PHIEU_NHAP  where NGAYNHAPBETWEEN '" + dateTuNgay + "' AND '" + dateDenNgay + "'";
            ArrayList<String> list_mapx = new ArrayList<>();
            try {
                sttm = conn.prepareStatement(sql);
                ResultSet rs = sttm.executeQuery();
                while (rs.next()) {
                    String mapx = rs.getString("MAPX");
                    list_mapx.add(mapx);
                }
            } catch (Exception e) {
                System.out.println("Error:" + e.toString());
                System.out.println("1486");
            }
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            for (int i = 0; i < list_mapx.size(); i++) {

                model.addRow(new Object[]{
                    i + 1, list_mapx.get(i)
                });
            }
            model.fireTableDataChanged();
        }

    }

    // Ktra mã vật tư đã trùng hay chưa
    public boolean Check_Mavt(String mavt, String id) {

        String sql = "SELECT MAVT FROM CT_VUNGTAP WHERE IDTHIETBI = '" + id + "' AND MAVT = '"+mavt+"'";
        int flag =0;
        try {
            
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while(rs.next()) {
                flag=1;
                
            }
            if(flag==1) return false;
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("1513");
        }
        return true;
    }
    // Thêm NHhana Viên vào db

    public boolean add_NV(String manv, String ho, String ten, String gt, String ngaysinh, String diachi, String email, String sdt, String chucvu) throws ParseException {
//       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//       Date date = (Date) dateFormat.parse(ngaysinh);

        try {
            String sql = "insert NHAN_VIEN(MANV,HO,TEN,PHAI, NGAYSINH,DIACHI, EMAIL,SDT,CHUCVU)"
                    + "values(?,?,?,?,?,?,?,?,?)";

            sttm = conn.prepareStatement(sql);
            sttm.setString(1, manv);
            sttm.setString(2, ho);
            sttm.setString(3, ten);
            sttm.setString(4, gt);
            sttm.setString(5, ngaysinh);
            sttm.setString(6, diachi);
            sttm.setString(7, email);
            sttm.setString(8, sdt);
            sttm.setString(9, chucvu);
            return sttm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("1538");
        }
        return false;
    }

    // Hàm lấy tên quyền
    public String get_Maquyen_From_Tenquyen(String tenquyen) {
        String maquyen = " ";
        String sql = "SELECT MAQUYEN FROM QUYEN_TRUY_CAP WHERE TENQUYEN ='" + tenquyen + "'";
        try {
            sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                maquyen = rs.getString("MAQUYEN");
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("1555");
        }
        return maquyen;
    }

    public boolean add_NCC(String mancc, String ten, String email, String sdt, String diachi) {
//       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//       Date date = (Date) dateFormat.parse(ngaysinh);

        try {
            String sql = "insert NHA_CUNG_CAP(MANCC,TENNCC,DIACHI, EMAIL,SDT)"
                    + "values(?,?,?,?,?)";

            sttm = conn.prepareStatement(sql);
            sttm.setString(1, mancc);
            sttm.setString(2, ten);
            sttm.setString(3, diachi);
            sttm.setString(4, email);
            sttm.setString(5, sdt);
            return sttm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("1577");
        }
        return false;
    }
    //Kiểm tra xem nhà cung cấp có bị trùng hay không

    public boolean Check_NCC_Trung(String id) {
        //? tìm thấy ..hỏi có muốn khôi phục kh
        String sql = "select MANCC from NHA_CUNG_CAP  where MANCC=?";

        try {
            sttm = conn.prepareStatement(sql);

            sttm.setString(1, id);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("1594");
        }
        return true;
    }

    //Kiểm tra xem nhà cung cấp có bị trùng hay không
    public boolean Check_Phong_Trung(String id) {
        //? tìm thấy ..hỏi có muốn khôi phục kh
        String sql = "select MAPHONG from PHONG  where MAPHONG=?";

        try {
            sttm = conn.prepareStatement(sql);

            sttm.setString(1, id);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
            System.out.println("1613");
        }
        return true;
    }

    public boolean add_Phong(String maphong, String ten) {
//       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//       Date date = (Date) dateFormat.parse(ngaysinh);

        try {
            String sql = "insert PHONG(MAPHONG,TENPHONG)"
                    + "values(?,?)";

            sttm = conn.prepareStatement(sql);
            sttm.setString(1, maphong);
            sttm.setString(2, ten);

            return sttm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("1632");
        }
        return false;
    }

    public boolean add_Kho(String makho, String ten, String diachi) {


        try {
            String sql = "insert KHO(MAKHO,TENKHO,DIACHI)"
                    + "values(?,?,?)";

            sttm = conn.prepareStatement(sql);
            sttm.setString(1, makho);
            sttm.setString(2, ten);
            sttm.setString(3, diachi);
            return sttm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println("1652");
        }
        return false;
    }
    
}
