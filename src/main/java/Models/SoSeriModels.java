/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author trieu
 */
public class SoSeriModels {
    private String soseri ;
    private int gia;
    private String IDTHIETBI;
    private int trangThai; // 1: đang sử dụng , 2: Đang bảo trì , 3: Hỏng
    private String maPX;
    private String maPN;
    private String maPhong;
    private String maKho;
    private String maNCC;

    public SoSeriModels() {
    }

    public String getSoseri() {
        return soseri;
    }

    public void setSoseri(String soseri) {
        this.soseri = soseri;
    }

    public int getGia() {
        
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getIDTHIETBI() {
        return IDTHIETBI;
    }

    public void setIDTHIETBI(String IDTHIETBI) {
        this.IDTHIETBI = IDTHIETBI;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaPX() {
        return maPX;
    }

    public void setMaPX(String maPX) {
        this.maPX = maPX;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }
    
}
