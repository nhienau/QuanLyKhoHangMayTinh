/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhoDTO;
import database.JDBCUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author trant
 */
public class khoDAO {
    
    public static khoDAO getInstance() {
        return new khoDAO();
    }
    
    public ArrayList<KhoDTO> getListWareHouse() {
        ArrayList<KhoDTO> listKho = new ArrayList<KhoDTO>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM kho WHERE trangthai = 1";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                KhoDTO kho = new KhoDTO();
                kho.setMaKho(rs.getInt("makho"));
                kho.setTenKho(rs.getString("tenkho"));
                kho.setDiaChi(rs.getString("diachi"));
                kho.setTrangThai(1);
                listKho.add(kho);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return listKho;
    }
    
    public boolean addWareHouse(KhoDTO kho){
        boolean result = false;
        
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO kho(tenkho,diachi,trangthai) VALUES(?,?,1)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, kho.getTenKho());
            stmt.setString(2, kho.getDiaChi());
            if(stmt.executeUpdate() >= 1){
                result = true;
            }
            
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
