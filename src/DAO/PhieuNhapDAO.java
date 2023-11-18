/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.ChiTietPhieuNhapDTO;
import database.JDBCUtil;
import java.sql.Statement;
import java.sql.Date;
import DTO.PhieuNhapDTO;
import DTO.SanPhamDTO;
import DTO.ChiTietCungCapDTO;
/**
 *
 * @author DELL
 */
public class PhieuNhapDAO {
        public static PhieuNhapDAO getInstance() {
        return new PhieuNhapDAO();
    }
    public static int luuPhieuNhapPending(PhieuNhapDTO phieuNhap, ArrayList<ChiTietPhieuNhapDTO> listChiTietPN) {
        int result = -1;
        Connection conn = JDBCUtil.getConnection();
        try {
            conn.setAutoCommit(false);

            PreparedStatement phieuNhapStatement = 
                    conn.prepareStatement("INSERT INTO phieunhap (thoigiantao, makho, nguoitao, tongtien, trangthai) VALUES (?, ?, ?, ?, ?)", 
                            Statement.RETURN_GENERATED_KEYS);
            phieuNhapStatement.setDate(1, phieuNhap.getThoiGianTao());
            phieuNhapStatement.setInt(2, phieuNhap.getMaKho());
            phieuNhapStatement.setString(3, phieuNhap.getNguoiTao());
            phieuNhapStatement.setInt(4, phieuNhap.getTongTien());
            phieuNhapStatement.setInt(5, phieuNhap.getTrangThai());
            phieuNhapStatement.executeUpdate();

            ResultSet phieuNhapResultSet = phieuNhapStatement.getGeneratedKeys();
            int maPhieuNhap = -1;
            if (phieuNhapResultSet.next()) {
                maPhieuNhap = phieuNhapResultSet.getInt(1);
            }

            PreparedStatement chiTietPhieuNhapStatement = 
                    conn.prepareStatement("INSERT INTO chitietphieunhap (maphieunhap, manhacungcap, masanpham, soluongnhap, dongia, soluongtonkho ) VALUES (?, ?, ?, ?, ?, ?)");
            for (ChiTietPhieuNhapDTO chiTietPhieuNhap : listChiTietPN) {
                chiTietPhieuNhapStatement.setInt(1, maPhieuNhap);
                chiTietPhieuNhapStatement.setInt(2, chiTietPhieuNhap.getMaNhaCungCap());
                chiTietPhieuNhapStatement.setInt(3, chiTietPhieuNhap.getMaSanPham());
                chiTietPhieuNhapStatement.setInt(4, chiTietPhieuNhap.getSoLuongNhap());
                chiTietPhieuNhapStatement.setInt(5, chiTietPhieuNhap.getDonGia());
                chiTietPhieuNhapStatement.setInt(6, chiTietPhieuNhap.getSoLuongTonKho());
                chiTietPhieuNhapStatement.executeUpdate();
            }

            conn.commit();
            result = maPhieuNhap;
        } catch (SQLException e) {
            // Rollback the transaction if there is an error
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    
    public int xacNhanPhieuNhap(PhieuNhapDTO phieuNhap, ArrayList<ChiTietPhieuNhapDTO> listChiTietPN) {
        int result = -1;
        Connection conn = JDBCUtil.getConnection();
        try {
            conn.setAutoCommit(false);

            String sql1 = "UPDATE phieunhap SET trangthai = 3 WHERE maphieunhap = ?";
            
            try (PreparedStatement pstmt1 = conn.prepareStatement(sql1)) {
                pstmt1.setInt(1, phieuNhap.getMaPhieuNhap());
                pstmt1.executeUpdate();
            }

            String sql2 = "UPDATE chitietphieunhap SET manhacungcap = ? WHERE maphieunhap = ? AND masanpham = ?";
            

            // Create a PreparedStatement object for the second SQL statement
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            for (ChiTietPhieuNhapDTO chiTietPhieuNhap : listChiTietPN) {
                try (PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
                    pstmt2.setInt(1, chiTietPhieuNhap.getMaNhaCungCap());
                    pstmt2.setInt(2, phieuNhap.getMaPhieuNhap());
                    pstmt2.setInt(3, chiTietPhieuNhap.getMaSanPham());
                    pstmt2.executeUpdate();
                }
                
            }
            result = 1;
            conn.commit();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
    
    public ArrayList<PhieuNhapDTO> danhSachPhieuNhapTheoTrangThai(int trangThai) {
        ArrayList<PhieuNhapDTO> dsPhieuNhap = new ArrayList();
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM phieunhap WHERE trangthai=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, trangThai);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                    int maPhieuNhap = rs.getInt("maphieunhap");
                    Date thoiGianTao = rs.getDate("thoigiantao");
                    int maKho = rs.getInt("makho");
                    String nguoiTao = rs.getString("nguoitao");
                    int tongTien = rs.getInt("tongtien");
                    int status = rs.getInt("trangthai");

                    PhieuNhapDTO phieuNhap = new PhieuNhapDTO(maPhieuNhap, thoiGianTao, maKho, nguoiTao, tongTien, trangThai);
                    dsPhieuNhap.add(phieuNhap);
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return dsPhieuNhap;
    }
    
    public ArrayList<ChiTietPhieuNhapDTO> danhSachCTPNTheoMaPhieuNhap(int maPhieuNhap) {
        ArrayList<ChiTietPhieuNhapDTO> dsCTPN = new ArrayList();
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "select * from chitietphieunhap ct , phieunhap pn where ct.maphieunhap = " + maPhieuNhap +" and ct.maphieunhap = pn.maphieunhap and pn.trangthai not in (2)";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                    int MaPhieuNhap = rs.getInt("maphieunhap");
                    int MaNhaCungCap = rs.getInt("manhacungcap");
                    int MaSanPham = rs.getInt("masanpham");
                    int MaKho = rs.getInt("makho");
                    int SoLuongNhap = rs.getInt("soluongnhap");
                    int DonGia = rs.getInt("dongia");
                    int SoLuongTonKho = rs.getInt("soluongtonkho");

                    ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO(
                            MaPhieuNhap, 
                            MaNhaCungCap, 
                            MaSanPham, 
                            SoLuongNhap, 
                            DonGia, 
                            SoLuongTonKho);
                    dsCTPN.add(ctpn);
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return dsCTPN;
    }
    
    public static ArrayList<PhieuNhapDTO> layDanhSachPNTheoNgay(Date startDate, Date endDate) {
        ArrayList<PhieuNhapDTO> listPN = new ArrayList<>();
        Connection con = JDBCUtil.getConnection();
        try {
                String sql = "SELECT * FROM phieunhap WHERE thoigiantao BETWEEN ? AND ? AND trangthai=?";
                PreparedStatement preStatement = con.prepareStatement(sql);
                preStatement.setDate(1, startDate);
                preStatement.setDate(2, endDate);
                preStatement.setInt(3, 4);
                ResultSet result = preStatement.executeQuery();
                while(result.next()) {
                    PhieuNhapDTO pn = new PhieuNhapDTO();
                    pn.setMaPhieuNhap(result.getInt(1));
                    pn.setThoiGianTao(result.getDate(2));
                    pn.setMaKho(result.getInt(3));
                    pn.setNguoiTao(result.getString(4));
                    pn.setTongTien(result.getInt(5));
                    pn.setTrangThai(result.getInt(6));
                    listPN.add(pn);
                }

        } catch (Exception e) {
                e.printStackTrace();
        }
        return listPN;
    }
    
    public static ArrayList<PhieuNhapDTO> layDanhSachPNTheoGia(int giaMin, int giaMax) {
        ArrayList<PhieuNhapDTO> listPN = new ArrayList<>();
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM phieunhap WHERE tongtien BETWEEN ? AND ? AND trangthai=?";
            PreparedStatement preStatement = con.prepareStatement(sql);
            preStatement.setInt(1, giaMin);
            preStatement.setInt(2, giaMax);
            preStatement.setInt(3, 4);
            ResultSet result = preStatement.executeQuery();
            while(result.next()) {
                    PhieuNhapDTO pn = new PhieuNhapDTO();
                    pn.setMaPhieuNhap(result.getInt(1));
                    pn.setThoiGianTao(result.getDate(2));
                    pn.setMaKho(result.getInt(3));
                    pn.setNguoiTao(result.getString(4));
                    pn.setTongTien(result.getInt(5));
                    pn.setTrangThai(result.getInt(6));
                    listPN.add(pn);
            }

        } catch (Exception e) {
                e.printStackTrace();
        }
        return listPN;
    }
    
    public int capNhatPhieuNhap(int maPhieuNhap, int trangThai) {
        Connection con = JDBCUtil.getConnection();
        try {
            String query = "UPDATE phieunhap SET trangthai = ? WHERE maphieunhap = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, 4);
            pstmt.setInt(2, maPhieuNhap);
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public PhieuNhapDTO layPhieuNhapTheoMa(int maPhieuNhap) {
        PhieuNhapDTO phieuNhap = null;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM phieunhap WHERE maphieunhap=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, maPhieuNhap);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int maPN = rs.getInt("maphieunhap");
                Date thoiGianTao = rs.getDate("thoigiantao");
                int maKho = rs.getInt("makho");
                String nguoiTao = rs.getString("nguoitao");
                int tongTien = rs.getInt("tongtien");
                int trangThai = rs.getInt("trangthai");

                phieuNhap = new PhieuNhapDTO(maPhieuNhap, thoiGianTao, maKho, nguoiTao, tongTien, trangThai);
                break;
            }

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return phieuNhap;
    }
    
     public ChiTietCungCapDTO findOne(int maSanPham) {
        ChiTietCungCapDTO ctcc = null;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM chitietcungcap WHERE masanpham=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, maSanPham);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                    int ma = rs.getInt("masanpham");
                    //String tenSanPham = rs.getString("tensanpham");
                    int giaNhap = rs.getInt("gianhap");

//                    ctcc = new ChiTietCungCapDTO(maSanPham, tenSanPham, giaNhap);
                        ctcc = new ChiTietCungCapDTO();
                    break;
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return ctcc;
    }
    
     public int getMaKhoFromMaPhieuNhap(int maPhieuNhap){
         int makho = -1;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT makho FROM phieunhap WHERE maphieunhap=" + maPhieuNhap +" and trangthai not in(2)";
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                    makho = rs.getInt("makho");

            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return makho;
     }
}