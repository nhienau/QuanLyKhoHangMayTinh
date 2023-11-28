/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietTonKhoDTO;
import DTO.tonKhoDTO;
import database.JDBCUtil;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author trant
 */
public class tonKhoDAO {
    
    public static tonKhoDAO getInstance(){
        return new tonKhoDAO();
    }
    
    public ArrayList<tonKhoDTO> getTonKho(int makho){
        ArrayList<tonKhoDTO> list = new ArrayList<>();
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("""
                            WITH temp_table AS (
                            	SELECT DISTINCT K.makho, PN.maphieunhap, CTPN.masanpham, SP.tensanpham, soluongtonkho
                            	FROM phieunhap PN, chitietphieunhap CTPN, kho K, trangthaiphieunhap TTPN, chitietcungcap CTCC, sanpham SP
                            	WHERE PN.maphieunhap = CTPN.maphieunhap AND K.makho = PN.makho AND PN.trangthai = TTPN.matrangthai AND CTCC.masanpham = CTPN.masanpham AND CTCC.masanpham = SP.masanpham AND TTPN.tentrangthai LIKE '%delivered%'
                                AND soluongtonkho > 0 AND K.makho = ?
                            )
                            SELECT makho, masanpham, tensanpham, SUM(soluongtonkho) AS soluong FROM temp_table
                            GROUP BY masanpham
                            ORDER BY tensanpham
                            """);
        try {
            Connection con = JDBCUtil.getConnection();
            
//            String sql = "SELECT DISTINCT K.makho, CTPN.masanpham, SP.tensanpham, soluongtonkho FROM phieunhap PN, chitietphieunhap CTPN, kho K, trangthaiphieunhap TTPN, chitietcungcap CTCC, sanpham SP WHERE PN.maphieunhap = CTPN.maphieunhap AND K.makho = PN.makho AND PN.trangthai = TTPN.matrangthai AND CTCC.masanpham = CTPN.masanpham AND CTCC.masanpham = SP.masanpham AND TTPN.tentrangthai LIKE '%delivered%' AND soluongtonkho > 0 AND K.makho = " +makho+ " ORDER BY masanpham;";
//            Statement stmt =  con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement ps = con.prepareStatement(queryBuilder.toString());
            ps.setInt(1, makho);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tonKhoDTO tonkho = new tonKhoDTO();
                tonkho.setMaKho(rs.getInt("makho"));
                tonkho.setMaSanPham(rs.getInt("masanpham"));
                tonkho.setTenSanPham(rs.getString("tensanpham"));
                tonkho.setSoLuong(rs.getInt("soluong"));
                list.add(tonkho);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<ChiTietTonKhoDTO> getDetailTonKho(int masanpham, int makho, boolean restrictGiaNhap) throws SQLException {
        ArrayList<ChiTietTonKhoDTO> list = new ArrayList<>();
        
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("""
                            SELECT DISTINCT K.makho, PN.maphieunhap, PN.thoigiantao, CTPN.masanpham, SP.tensanpham, NCC.manhacungcap, tennhacungcap
                            """);
        
        if (!restrictGiaNhap) {
            queryBuilder.append(", CTPN.dongia");
        }
        
        queryBuilder.append("""
                            , soluongtonkho
                            FROM phieunhap PN, chitietphieunhap CTPN, kho K, trangthaiphieunhap TTPN, chitietcungcap CTCC, sanpham SP, nhacungcap NCC
                            WHERE PN.maphieunhap = CTPN.maphieunhap 
                                AND K.makho = PN.makho 
                                AND PN.trangthai = TTPN.matrangthai 
                                AND CTCC.masanpham = CTPN.masanpham 
                                AND CTCC.masanpham = SP.masanpham 
                                AND CTPN.manhacungcap = CTCC.manhacungcap 
                                AND CTCC.manhacungcap = NCC.manhacungcap 
                                AND TTPN.tentrangthai LIKE '%delivered%' 
                                AND soluongtonkho > 0 
                                AND CTPN.masanpham = ? 
                                AND K.makho = ?
                            ORDER BY PN.thoigiantao DESC
                            """);
        try {
            Connection con = JDBCUtil.getConnection();
//            String sql = "SELECT DISTINCT K.makho, PN.maphieunhap, CTPN.masanpham, SP.tensanpham, NCC.manhacungcap, soluongtonkho, CTPN.dongia FROM phieunhap PN, chitietphieunhap CTPN, kho K, trangthaiphieunhap TTPN, chitietcungcap CTCC, sanpham SP, nhacungcap NCC  WHERE PN.maphieunhap = CTPN.maphieunhap AND K.makho = PN.makho AND PN.trangthai = TTPN.matrangthai AND CTCC.masanpham = CTPN.masanpham AND CTCC.masanpham = SP.masanpham AND CTPN.manhacungcap = CTCC.manhacungcap AND CTCC.manhacungcap = NCC.manhacungcap AND TTPN.tentrangthai LIKE '%delivered%' AND soluongtonkho > 0 AND CTPN.masanpham = " + masanpham + " AND K.makho = " + makho + " ORDER BY masanpham;";
//            Statement stmt =  con.createStatement();
            PreparedStatement ps = con.prepareStatement(queryBuilder.toString());
            ps.setInt(1, masanpham);
            ps.setInt(2, makho);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ChiTietTonKhoDTO cttk = new ChiTietTonKhoDTO();
                cttk.setMaKho(makho);
                cttk.setMaPhieuNhap(rs.getInt("maphieunhap"));
                Timestamp timestamp = rs.getTimestamp("thoigiantao");
                LocalDateTime thoiGianTao = timestamp.toLocalDateTime();
                cttk.setThoiGianTao(thoiGianTao);
                cttk.setMaSanPham(masanpham);
                cttk.setMaNhaCungCap(rs.getInt("manhacungcap"));
                cttk.setTenNhaCungCap(rs.getString("tennhacungcap"));
                cttk.setSoLuongTonKho(rs.getInt("soluongtonkho"));
                cttk.setDonGia(restrictGiaNhap ? -1 : rs.getLong("dongia"));             
                list.add(cttk);
            }
        } catch (SQLException e) {
            throw e;
        }
        return list;
    }
}
