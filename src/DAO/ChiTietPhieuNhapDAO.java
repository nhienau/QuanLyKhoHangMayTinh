/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietPhieuNhapDTO;
import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author trant
 */
public class ChiTietPhieuNhapDAO {
    
    public static ChiTietPhieuNhapDAO getInstance(){
        return new ChiTietPhieuNhapDAO();
    }
    
    public ArrayList<ChiTietPhieuNhapDTO> getDetailPhieuNhap(int maPhieuNhap) throws SQLException{
        ArrayList<ChiTietPhieuNhapDTO> ctpnList = new ArrayList<>();
        try{
            Connection conn = JDBCUtil.getConnection();
            String query = "SELECT * FROM chitietphieunhap WHERE maphieunhap = " + maPhieuNhap;
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietPhieuNhapDTO ctpn =  new ChiTietPhieuNhapDTO();
                ctpn.setMaPhieuNhap(maPhieuNhap);
                ctpn.setDonGia(rs.getInt("dongia"));
                ctpn.setMaNhaCungCap(rs.getInt("manhacungcap"));
                ctpn.setMaSanPham(rs.getInt("masanpham"));
                ctpn.setSoLuongNhap(rs.getInt("soluongnhap"));
                ctpn.setSoLuongTonKho(rs.getInt("soluongtonkho"));
                ctpnList.add(ctpn);
            }
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw e;
        }
        return ctpnList;
    }
    
    

}
