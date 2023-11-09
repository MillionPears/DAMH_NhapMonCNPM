/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Other;
import Models.PhieuNhapModels;
/**
 *
 * @author trieu
 */
public class getModel {
    public static PhieuNhapModels get_PN_Model(String id, String ten , int soluong, String tt , String makho)
    {
        PhieuNhapModels pn = new PhieuNhapModels();
        pn.setIdtb(id);
        pn.setTentb(ten);
        pn.setSoluong(soluong);
        pn.setTrangThai(tt);
        pn.setMaKho(makho);
        return pn;
    }
}
