package DTO;

public class SanPhamDTO {
    private int maSanPham;
    private int maLoaiSanPham;
    private String tenSanPham;
    private int soLuong;
    private int giaNhap;
    private int giaXuat;
    private String cpu;
    private String ram;
    private String vga;
    private String oCung;
    private String manHinh;
    private String pin;
    private String trongLuong;
    private String mauSac;
    private String os;
    private String trangThai;

    public SanPhamDTO(int maSanPham, String tenSanPham, int soLuong, int giaNhap, int giaXuat, String cpu, String ram, String vga, String oCung, String manHinh, String pin, String trongLuong, String mauSac, String os, String trangThai) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaXuat = giaXuat;
        this.cpu = cpu;
        this.ram = ram;
        this.vga = vga;
        this.oCung = oCung;
        this.manHinh = manHinh;
        this.pin = pin;
        this.trongLuong = trongLuong;
        this.mauSac = mauSac;
        this.os = os;
        this.trangThai = trangThai;
    }

    public SanPhamDTO(int maSanPham, int maLoaiSanPham, String tenSanPham, int soLuong, int giaNhap, int giaXuat, String cpu, String ram, String vga, String oCung, String manHinh, String pin, String trongLuong, String mauSac, String os, String trangThai) {
        this.maSanPham = maSanPham;
        this.maLoaiSanPham = maLoaiSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaXuat = giaXuat;
        this.cpu = cpu;
        this.ram = ram;
        this.vga = vga;
        this.oCung = oCung;
        this.manHinh = manHinh;
        this.pin = pin;
        this.trongLuong = trongLuong;
        this.mauSac = mauSac;
        this.os = os;
        this.trangThai = trangThai;
    }
    
    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public void setMaLoaiSanPham(int maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getGiaXuat() {
        return giaXuat;
    }

    public void setGiaXuat(int giaXuat) {
        this.giaXuat = giaXuat;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public String getoCung() {
        return oCung;
    }

    public void setoCung(String oCung) {
        this.oCung = oCung;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(String trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
