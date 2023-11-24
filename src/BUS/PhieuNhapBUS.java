/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuNhapDAO;

/**
 *
 * @author trant
 */
public class PhieuNhapBUS {
    PhieuNhapDAO pnDAO = new PhieuNhapDAO();
    
    
    public String capNhatPhieuNhap( int maPhieuNhap,int trangThai){
        if(pnDAO.getInstance().capNhatPhieuNhap(maPhieuNhap, trangThai))
            return "Cập nhật phiếu nhập hàng thành công!";
        return "Cập nhật phiếu nhập hàng thất bại!";
    }
    

}
