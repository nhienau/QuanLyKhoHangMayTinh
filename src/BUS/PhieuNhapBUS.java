/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;

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
    
    public String xacNhanPhieuNhap(PhieuNhapDTO phieuNhap, ArrayList<ChiTietPhieuNhapDTO> listChiTietPN){
        if(pnDAO.xacNhanPhieuNhap(phieuNhap, listChiTietPN) == 1)
            return "Xác nhận phiếu nhập thành công!";
        return "Xác nhận phiếu nhập thất bại!";
    }
}
