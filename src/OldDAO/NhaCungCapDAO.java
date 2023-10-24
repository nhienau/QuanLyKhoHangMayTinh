/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OldDAO;

import DTO.NhaCungCapDTO;
import DTO.ChiTietCungCapDTO;
import com.sun.jdi.connect.spi.Connection;
import database.JDBCUtil;
import java.sql.Date;
import java.util.ArrayList;
import model.NhaCungCap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Phieu;
import org.apache.poi.hwmf.record.HwmfTernaryRasterOp;

/**
 *
 * @author kali
 */
public class NhaCungCapDAO implements DAOInterface<NhaCungCapDTO> {

    public static NhaCungCapDAO getInstance() {
        return new NhaCungCapDAO();
    }

    @Override
    public int insert(NhaCungCapDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO nhacungcap ( `tennhacungcap`, `sdt`, `diachi`)  VALUES (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
              pst.setString(1, t.getTenNhaCungCap());
              pst.setString(2, t.getSdt());
              pst.setString(3, t.getDiaChi());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Không thêm được nhà cung cấp " + t.getMaNhaCungCap(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return ketQua;

    }

    @Override
    public int update(NhaCungCapDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE NhaCungCap SET maNhaCungCap=?, tenNhaCungCap=?, Sdt=?, diaChi=? WHERE maNhaCungCap=? and trangthai = 1";
            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setString(1, t.getMaNhaCungCap());
//            pst.setString(2, t.getTenNhaCungCap());
//            pst.setString(3, t.getSdt());
//            pst.setString(4, t.getDiaChi());
//            pst.setString(5, t.getMaNhaCungCap());
            pst.setInt(1, t.getMaNhaCungCap());
            pst.setString(2, t.getTenNhaCungCap());
            pst.setString(3, t.getSdt());
            pst.setString(4, t.getDiaChi());
            pst.setInt(5, t.getMaNhaCungCap());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;

    }

    @Override
    public int delete(NhaCungCapDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE NhaCungCap SET trangthai = 0 WHERE maNhaCungCap=?";
            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setString(1, t.getMaNhaCungCap());
            pst.setInt(1, t.getMaNhaCungCap());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<NhaCungCapDTO> selectAll() {
        ArrayList<NhaCungCapDTO> ketQua = new ArrayList<NhaCungCapDTO>();
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM NhaCungCap WHERE trangthai = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {   
                NhaCungCapDTO ncc = new NhaCungCapDTO();
                ncc.setMaNhaCungCap(rs.getInt("manhacungcap"));
                ncc.setTenNhaCungCap(rs.getString("tennhacungcap"));
                ncc.setSdt(rs.getString("Sdt"));
                ncc.setDiaChi(rs.getString("diachi"));
                ketQua.add(ncc);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }


    @Override
    public NhaCungCapDTO selectById(String t) {
        NhaCungCapDTO ketQua = null;
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM NhaCungCap WHERE maNhaCungCap=? and trangthai = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maNhaCungCap = rs.getInt("manhacungcap");
                String tenNhaCungCap = rs.getString("tenNhaCungCap");
                String sdt = rs.getString("Sdt");
                String diaChi = rs.getString("diaChi");
                ketQua = new NhaCungCapDTO(maNhaCungCap, tenNhaCungCap, sdt, diaChi);
//                ketQua = new NhaCungCap(maNhaCungCap, tenNhaCungCap, sdt, diaChi);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public boolean hasSDT(String sdt){
        boolean result = false;
        
            try {
                java.sql.Connection con = JDBCUtil.getConnection();
                String sql = "SELECT * FROM nhacungcap WHERE sdt = '" + sdt + "'";
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                result = rs.next();
            } catch (Exception e) {
                System.out.println(e);
            } 
        return result;
    }
    
    public ArrayList<ChiTietCungCapDTO> getListChiTietCungCap(int id){
        ArrayList<ChiTietCungCapDTO> list = new ArrayList<ChiTietCungCapDTO>();
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM chitietcungcap WHERE trangthai = 1 and manhacungcap = " + id;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {   
                ChiTietCungCapDTO ccsp = new ChiTietCungCapDTO();
                ccsp.setMaSanPham(rs.getInt("masanpham"));
                ccsp.setTenSanPham("hihi");
                ccsp.setGiaNhap(rs.getInt("gianhap"));
                list.add(ccsp);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return list;
        
    }
    
}
