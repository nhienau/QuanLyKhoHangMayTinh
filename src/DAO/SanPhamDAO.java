/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanPhamDTO;
import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author trant
 */
public class SanPhamDAO {
    
    public static SanPhamDAO getInstance() {
        return new SanPhamDAO();
    }
    public ArrayList<SanPhamDTO> getlistProduct(){
        ArrayList<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM sanpham WHERE trangthai = 1";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SanPhamDTO sp = new SanPhamDTO();
                sp.setMaSanPham( rs.getInt("masanpham"));
                sp.setMaLoaiSanPham(rs.getInt("maloaisanpham"));
                sp.setTenSanPham(rs.getString("tensanpham"));
                sp.setSoLuong( rs.getInt("soluong"));
                sp.setGiaXuat(rs.getInt("giaxuat"));
                sp.setCpu(rs.getString("cpu"));
                sp.setRam( rs.getString("ram"));
                sp.setVga( rs.getString("vga"));
                sp.setoCung( rs.getString("ocung"));
                sp.setManHinh( rs.getString("manhinh"));
                sp.setPin( rs.getString("pin"));
                sp.setMauSac( rs.getString("mausac"));
                sp.setTrongLuong( rs.getFloat("trongluong"));
                sp.setOs( rs.getString("os"));
                list.add(sp);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return list;
    }
    
    public SanPhamDTO selectProductByID(int id){
        SanPhamDTO spDTO = null;
        
        try{
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM sanpham WHERE trangthai = 1 and masanpham = " + id  ;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){

                int maSanPham = id;
                int maLoaiSanPham = rs.getInt("maloaisanpham");
                String tenSanPham = rs.getString("tensanpham");
                int soLuong = rs.getInt("soluong");
                String cpu = rs.getString("cpu");
                String ram = rs.getString("ram");
                String vga = rs.getString("vga");
                int giaXuat = rs.getInt("giaxuat");
                String manHinh = rs.getString("manhinh");
                String pin = rs.getString("pin");
                String mauSac = rs.getString("mausac");
                String os = rs.getString("os");
                String oCung = rs.getString("ocung");
                Float trongLuong = rs.getFloat("trongluong");
                
                spDTO = new SanPhamDTO(maSanPham, maLoaiSanPham, tenSanPham, soLuong, giaXuat, cpu, ram, vga, oCung, manHinh, pin, trongLuong, mauSac, os, 1);
            }
            JDBCUtil.closeConnection(con);
        } catch(Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return spDTO;
    }
    
    public boolean  addProduct(SanPhamDTO sp){
        boolean result = false;
        
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO sanpham VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
            PreparedStatement presttm = con.prepareStatement(sql);
            presttm.setInt(1, sp.getMaSanPham());
            presttm.setInt(2, sp.getMaLoaiSanPham());
            presttm.setString(3, sp.getTenSanPham());
            presttm.setInt(4, sp.getSoLuong());
            presttm.setInt(5, sp.getGiaXuat());
            presttm.setString(6, sp.getCpu());
            presttm.setString(7, sp.getRam());
            presttm.setString(8, sp.getVga());
            presttm.setString(9, sp.getoCung());
            presttm.setString(10, sp.getManHinh());
            presttm.setString(11, sp.getPin());
            presttm.setFloat(12, sp.getTrongLuong());
            presttm.setString(13, sp.getMauSac());
            presttm.setString(14, sp.getOs());
            if(presttm.executeUpdate() >= 1){
                result = true;
            }
            
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    public int deleteProduct(int id) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE sanpham SET trangthai = 0 WHERE masanpham = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ketQua = pst.executeUpdate();

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public int updateProduct(SanPhamDTO sp) {
        int ketqua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE sanpham SET tensanpham = ? , giaxuat = ? , cpu = ?, ram = ?, mausac = ?, manhinh=  ?, vga = ?, ocung = ?, trongluong = ? WHERE masanpham=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, sp.getTenSanPham());
            pst.setInt(2, sp.getGiaXuat());
            pst.setString(3, sp.getCpu());
            pst.setString(4, sp.getRam());
            pst.setString(5, sp.getMauSac());
            pst.setString(6, sp.getManHinh());
            pst.setString(7, sp.getVga());
            pst.setString(8, sp.getoCung());
            pst.setFloat(9, sp.getTrongLuong());
            pst.setInt(10, sp.getMaSanPham());
            ketqua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }
}
