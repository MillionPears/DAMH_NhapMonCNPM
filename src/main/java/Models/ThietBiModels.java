/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author trieu
 */
public class ThietBiModels {
    private String anh;
    private ArrayList<String> vungTap;
    private String quyDinh ;
    private String hDSD;

    public String getQuyDinh() {
        return quyDinh;
    }

    public void setQuyDinh(String quyDinh) {
        this.quyDinh = quyDinh;
    }

    public String gethDSD() {
        return hDSD;
    }

    public void sethDSD(String hDSD) {
        this.hDSD = hDSD;
    }
    public ArrayList<String> getVungTap() {
        return vungTap;
    }

    public void setVungTap(ArrayList<String> vungTap) {
        this.vungTap = vungTap;
    }
    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    private String maThietBi;
    private String tenThietBi;
    private int soluong;
    private String mota ;
    private String thuocTinhKhac;

    public ThietBiModels() {
    }

    public String getMaThietBi() {
        return maThietBi;
    }

    public void setMaThietBi(String maThietBi) {
        this.maThietBi = maThietBi;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getThuocTinhKhac() {
        return thuocTinhKhac;
    }

    public void setThuocTinhKhac(String thuocTinhKhac) {
        this.thuocTinhKhac = thuocTinhKhac;
    }
    
}
