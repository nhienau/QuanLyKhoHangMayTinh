package DTO.ThongKe;

public class ChiTietSanPhamNhapDTO {
    private int maNhaCungCap;
    private String tenNhaCungCap;
    private int tongSoLuongNhap;
    private Long donGia;

    public ChiTietSanPhamNhapDTO(int maNhaCungCap, String tenNhaCungCap, int tongSoLuongNhap, Long donGia) {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.tongSoLuongNhap = tongSoLuongNhap;
        this.donGia = donGia;
    }

    public int getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(int maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public int getTongSoLuongNhap() {
        return tongSoLuongNhap;
    }

    public void setTongSoLuongNhap(int tongSoLuongNhap) {
        this.tongSoLuongNhap = tongSoLuongNhap;
    }

    public Long getDonGia() {
        return donGia;
    }

    public void setDonGia(Long donGia) {
        this.donGia = donGia;
    }
}
