/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.tonKhoDTO;
import com.mysql.cj.xdevapi.PreparableStatement;
import database.JDBCUtil;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
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
        ArrayList<tonKhoDTO> list = new ArrayList<tonKhoDTO>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM tonkho  WHERE trangthai = 1 AND makho = " + makho;
            Statement stmt =  con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                tonKhoDTO tonkho = new tonKhoDTO();
                tonkho.setMaKho(rs.getInt("makho"));
                tonkho.setMaSanPham(rs.getInt("masanpham"));
                tonkho.setMaNhaCungCap(rs.getInt("nhacungcap"));
                tonkho.setSoLuong(rs.getInt("soluong"));
                tonkho.setGiaNhap(rs.getInt("gianhap"));
                list.add(tonkho);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
