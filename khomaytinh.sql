-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 13, 2023 at 07:31 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `khomaytinh`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `maphieunhap` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `dongia` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieuxuat`
--

CREATE TABLE `chitietphieuxuat` (
  `maphieuxuat` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `dongia` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `chitietquyen`
--

CREATE TABLE `chitietquyen` (
  `manhomquyen` int(11) NOT NULL,
  `machucnang` varchar(50) NOT NULL,
  `hanhdong` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chitietquyen`
--

INSERT INTO `chitietquyen` (`manhomquyen`, `machucnang`, `hanhdong`) VALUES
(1, 'nhacungcap', 'view'),
(1, 'phieunhap', 'view'),
(1, 'phieuxuat', 'view'),
(1, 'sanpham', 'view'),
(1, 'taikhoan', 'create'),
(1, 'taikhoan', 'delete'),
(1, 'taikhoan', 'update'),
(1, 'taikhoan', 'view'),
(1, 'thongke', 'view'),
(1, 'tonkho', 'view_price_restricted'),
(2, 'nhacungcap', 'create'),
(2, 'nhacungcap', 'delete'),
(2, 'nhacungcap', 'update'),
(2, 'nhacungcap', 'view'),
(2, 'phieunhap', 'create'),
(2, 'phieunhap', 'view'),
(2, 'phieuxuat', 'create'),
(2, 'phieuxuat', 'view'),
(2, 'sanpham', 'create'),
(2, 'sanpham', 'delete'),
(2, 'sanpham', 'update'),
(2, 'sanpham', 'view'),
(2, 'taikhoan', 'create'),
(2, 'taikhoan', 'delete'),
(2, 'taikhoan', 'view'),
(2, 'thongke', 'view'),
(2, 'tonkho', 'view'),
(3, 'nhacungcap', 'view'),
(3, 'phieunhap', 'create'),
(3, 'phieunhap', 'view'),
(3, 'sanpham', 'create'),
(3, 'sanpham', 'view'),
(3, 'tonkho', 'view_price_restricted'),
(4, 'phieuxuat', 'create'),
(4, 'phieuxuat', 'view'),
(4, 'sanpham', 'view'),
(4, 'tonkho', 'view_price_restricted');

-- --------------------------------------------------------

--
-- Table structure for table `chucnang`
--

CREATE TABLE `chucnang` (
  `machucnang` varchar(50) NOT NULL,
  `tenchucnang` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chucnang`
--

INSERT INTO `chucnang` (`machucnang`, `tenchucnang`, `trangthai`) VALUES
('nhacungcap', 'Quản lý nhà cung cấp', 1),
('phieunhap', 'Quản lý phiếu nhập', 1),
('phieuxuat', 'Quản lý phiếu xuất', 1),
('sanpham', 'Quản lý sản phẩm', 1),
('taikhoan', 'Quản lý tài khoản', 1),
('thongke', 'Thống kê', 1),
('tonkho', 'Quản lý tồn kho', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nguoidung`
--

CREATE TABLE `nguoidung` (
  `taikhoan` varchar(255) NOT NULL,
  `matkhau` varchar(255) NOT NULL,
  `hoten` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `manhomquyen` int(11) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nguoidung`
--

INSERT INTO `nguoidung` (`taikhoan`, `matkhau`, `hoten`, `email`, `manhomquyen`, `trangthai`) VALUES
('an', '$2a$12$phthu7KkJNlcmJ0oRfP1SOoFcAu2murqtpOD1XA9mgDCnLL4JfSRm', 'Nguyễn Thiên Ân', 'thienan@gmail.com', 2, 1),
('anh', '$2a$12$5b64FYmh9Gz4DAU.qQqPt.3svz7QsS3WDHMakRgKB4xugxMzxC2ce', 'Nguyễn Trung Anh', 'trunganh@gmail.com', 2, 1),
('duy', '$2a$12$K/ENOCA71OHp7z3XfSP1MutwfEOCfaeTZ6TA8WhIQD90ptnuUORjW', 'Nguyễn Lê Bảo Duy', 'baoduy@gmail.com', 2, 1),
('duyen', '$2a$12$q/i1Ap90Go4/sIdz1s3ZAOYhCAOMZDXIIi45QMIDDHOzDWcC/P7cW', 'Nguyễn Thuỳ Duyên', 'thuyduyen@gmail.com', 2, 1),
('nam', '$2a$12$0rHGEBziwTtk29BSlwmju.R0OuvKu8Oc/LoI1O5hvQPuANbQfYAwC', 'Thân Trọng Hoài Nam', 'hoainam@gmail.com', 2, 1),
('nhien', '$2a$12$SJ8XeAbcof9oiBJjQFR61ebfdmrgnTp05HuujJ8q7NrDSEJf/P6ze', 'Âu Hạo Nhiên', 'nhienau@gmail.com', 1, 1),
('nvnhap', '$2a$12$vK9g/aY1nPKvpEASL7fzeugVAHdm281zb8akeHO4I1g7sdE/pH7Wm', 'Test nhan vien nhap', 'nvnhap@gmail.com', 3, 1),
('nvxuat', '$2a$12$kiRyqK5HypKi.n4CpbS3PO6lFXcZRdtyEMO96HhrY4TAYOKQwSfJq', 'Test nhan vien xuat', 'nvxuat@gmail.com', 4, 1),
('test', '$2a$12$uDmFamJCdeTYHhKqzQE6nu3e03gSCqXpaX7Lk1Ojx8GUT6ytIUjd.', 'Test', 'test@gmail.com', 3, 0),
('tram', '$2a$12$LIrqqUIO.S.UqZyj1i0Dp.klvpvhUb/4V40hGKfkoNrs4xMfJk7cW', 'Võ Hồ Ngọc Trâm', 'ngoctram@gmail.com', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `manhacungcap` int(11) NOT NULL,
  `tennhacungcap` varchar(255) NOT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`manhacungcap`, `tennhacungcap`, `sdt`, `diachi`, `trangthai`) VALUES
(1, 'Công Ty TNHH Điều Khiển Tự Động An Phát', '02835109735', '86/21 Phan Tây Hồ, P. 7, Q. Phú Nhuận TP. Hồ Chí Minh', 1),
(2, 'Công Ty TNHH Thương Mại Dịch Vụ Hoàng Cố Đô', '02838115345', '622/16/5 Cộng Hòa, Phường 13, Quận Tân Bình, TP HCM', 1),
(3, 'Công Ty Cổ Phần Bán Lẻ Kỹ Thuật Số FPT', '02873023456', '261 - 263 Khánh Hội, P2, Q4, TP. Hồ Chí Minh', 1),
(4, 'Công ty Cổ phần đầu tư công nghệ HACOM', '1900 1903', 'Số 129 - 131, phố Lê Thanh Nghị, Phường Đồng Tâm, Quận Hai Bà Trưng, Hà Nội', 1),
(5, 'Công Ty TNHH Thương Mại Hoàng Phát Hải Phòng', '02253250888', 'Số 4, Lô 2A Lê Hồng Phong, Ngô Quyền, Tp. Hải Phòng', 1),
(6, 'Công ty cổ phần dịch vụ - thương mại Phong Vũ', '0967567567', 'Tầng 5, Số 117-119-121 Nguyễn Du, Phường Bến Thành, Quận 1, Thành Phố Hồ Chí Minh', 1),
(7, 'Công ty cổ phần Thế Giới Di Động', '028 38125960', '128 Trần Quang Khải, P. Tân Định, Q.1, TP.Hồ Chí Minh', 1),
(8, 'Công ty CP Công nghệ Thương mại Dịch vụ Vietstars', '090 469 0212', ' Số 109 Lê Thanh Nghị, TP Hải Dương', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhomquyen`
--

CREATE TABLE `nhomquyen` (
  `manhomquyen` int(11) NOT NULL,
  `tennhomquyen` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhomquyen`
--

INSERT INTO `nhomquyen` (`manhomquyen`, `tennhomquyen`, `trangthai`) VALUES
(1, 'Admin', 1),
(2, 'Quản lý kho', 1),
(3, 'Nhân viên nhập hàng', 1),
(4, 'Nhân viên xuất hàng', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maphieunhap` int(11) NOT NULL,
  `thoigiantao` datetime NOT NULL DEFAULT current_timestamp(),
  `nguoitao` varchar(255) NOT NULL,
  `manhacungcap` int(11) NOT NULL,
  `tongtien` bigint(20) NOT NULL DEFAULT 0,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `maphieuxuat` int(11) NOT NULL,
  `thoigiantao` datetime NOT NULL DEFAULT current_timestamp(),
  `nguoitao` varchar(255) NOT NULL,
  `tongtien` bigint(20) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `masanpham` int(11) NOT NULL,
  `tensanpham` varchar(255) NOT NULL,
  `soluong` int(11) NOT NULL DEFAULT 0,
  `gianhap` bigint(20) NOT NULL,
  `giaxuat` bigint(20) NOT NULL,
  `cpu` varchar(255) DEFAULT NULL,
  `ram` varchar(255) DEFAULT NULL,
  `vga` varchar(255) DEFAULT NULL,
  `ocung` varchar(255) DEFAULT NULL,
  `manhinh` varchar(255) DEFAULT NULL,
  `pin` varchar(255) DEFAULT NULL,
  `trongluong` float DEFAULT NULL,
  `mausac` varchar(255) DEFAULT NULL,
  `os` varchar(255) DEFAULT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`masanpham`, `tensanpham`, `soluong`, `gianhap`, `giaxuat`, `cpu`, `ram`, `vga`, `ocung`, `manhinh`, `pin`, `trongluong`, `mausac`, `os`, `trangthai`) VALUES
(1, 'Lenovo Ideapad Slim 5 Light 14ABR8 82XS002JVN', 19, 15150000, 16890000, 'AMD Ryzen™ 7 7730U (8 Cores / 16 Threads, 2.0 to 4.5GHz, 4MB L2 / 16MB L3)', '16GB Onboard DDR4 3200MHz', 'AMD Radeon™ Graphics', '512GB SSD M.2 2242 PCIe® 4.0x4 NVMe', '14\" FHD (1920x1080) IPS 300nits Anti-glare, 100% sRGB', 'Integrated 47Wh', 1.17, 'Cloud Grey', 'Windows 11 Home', 1),
(2, 'MSI Modern 14 C11M 011VN', 0, 8750000, 9990000, 'Intel Core i3-1115G4 (up to 4.1Ghz, 6MB)', '8GB DDR4 3200Mhz Onboard (Không nâng cấp)', 'Intel® UHD Graphics', '512GB NVMe PCIe Gen 3x4 SSD (1 Slot)', '14.0\" FHD (1920x1080), IPS-Level , 45% NTSC', '3 cell, 39Whr', 1.3, 'Đen', 'Windows 11 Home', 1),
(3, 'Asus Vivobook Pro 15 OLED M6500QC MA002W', 0, 19290000, 21490000, 'AMD Ryzen 5-5600H up to 4.2GHz 19MB, 6 nhân, 12 luồng', '16GB (Onboard) DDR4 3200MHz (không nâng cấp)', 'NVIDIA GeForce RTX 3050 4GB GDDR6', '512GB SSD M.2 PCIE G3X2', '15.6-inch 2.8K (2880 x 1620) OLED 16:9 aspect ratio, 120Hz refresh rate, 600nits peak brightness, 100% DCI-P3 color gamut, VESA CERTIFIED Display HDR True Black 600, PANTONE Validated, Glossy display, 70% less harmful blue light', '70WHrs, 3S1P, 3-cell Li-ion', 1.8, 'Bạc', 'Windows 11 Home', 1),
(4, 'MSI Katana 15 B13VEK 1205VN', 10, 21990000, 24490000, 'Intel Core i5-13420H (3.40GHz~4.60GHz) 8 Cores 12 Threads, 12 MB Intel® Smart Cache', '8GB (1 x 8GB) DDR5 5200MHz (2x SO-DIMM socket, up to 64GB SDRAM)', 'NVIDIA GeForce RTX 4050 Laptop GPU 6GB GDDR6 + MUX Switch', '512GB NVMe PCIe Gen 4 SSD (2 slots)', '15.6\" FHD (1920x1080), 144Hz, IPS-Level, 45% NSTC', '3 cell, 53.5Whr', 2.25, 'Đen', 'Windows 11 Home', 1),
(5, 'Acer Predator Helios 300 PH315 55 76KG', 0, 29990000, 33990000, 'Intel® Core™ i7-12700H (up to 4.7Ghz, 24MB cache)', '16GB DDR5 4800Mhz (2x8GB) (2x SO-DIMM socket, up to 32GB SDRAM)', 'NVIDIA GeForce RTX 3060 6GB GDDR6', '	512GB NVMe PCIe Gen3x4 SSD (2 slot)', '15.6 inch QHD (2560 x1440) IPS 165Hz, DCI-P3 100%, 5ms, 300nits, SlimBezel', '4 cell, 90Whr', 2.4, 'Đen', 'Windows 11 Home', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`maphieunhap`,`masanpham`),
  ADD KEY `FK_CHITIETPHIEUNHAP_SANPHAM` (`masanpham`);

--
-- Indexes for table `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD PRIMARY KEY (`maphieuxuat`,`masanpham`),
  ADD KEY `FK_CHITIETPHIEUXUAT_SANPHAM` (`masanpham`);

--
-- Indexes for table `chitietquyen`
--
ALTER TABLE `chitietquyen`
  ADD PRIMARY KEY (`manhomquyen`,`machucnang`,`hanhdong`) USING BTREE,
  ADD KEY `FK_CHITIETQUYEN_CHUCNANG` (`machucnang`);

--
-- Indexes for table `chucnang`
--
ALTER TABLE `chucnang`
  ADD PRIMARY KEY (`machucnang`);

--
-- Indexes for table `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`taikhoan`),
  ADD KEY `FK_NGUOIDUNG_NHOMQUYEN` (`manhomquyen`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`manhacungcap`);

--
-- Indexes for table `nhomquyen`
--
ALTER TABLE `nhomquyen`
  ADD PRIMARY KEY (`manhomquyen`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`maphieunhap`),
  ADD KEY `FK_PHIEUNHAP_TAIKHOAN` (`nguoitao`),
  ADD KEY `FK_PHIEUNHAP_NHACUNGCAP` (`manhacungcap`);

--
-- Indexes for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`maphieuxuat`),
  ADD KEY `FK_PHIEUXUAT_NGUOIDUNG` (`nguoitao`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`masanpham`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `manhacungcap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `nhomquyen`
--
ALTER TABLE `nhomquyen`
  MODIFY `manhomquyen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `maphieunhap` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  MODIFY `maphieuxuat` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `masanpham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `FK_CHITIETPHIEUNHAP_PHIEUNHAP` FOREIGN KEY (`maphieunhap`) REFERENCES `phieunhap` (`maphieunhap`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_CHITIETPHIEUNHAP_SANPHAM` FOREIGN KEY (`masanpham`) REFERENCES `sanpham` (`masanpham`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD CONSTRAINT `FK_CHITIETPHIEUXUAT_PHIEUXUAT` FOREIGN KEY (`maphieuxuat`) REFERENCES `phieuxuat` (`maphieuxuat`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_CHITIETPHIEUXUAT_SANPHAM` FOREIGN KEY (`masanpham`) REFERENCES `sanpham` (`masanpham`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `chitietquyen`
--
ALTER TABLE `chitietquyen`
  ADD CONSTRAINT `FK_CHITIETQUYEN_CHUCNANG` FOREIGN KEY (`machucnang`) REFERENCES `chucnang` (`machucnang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_CHITIETQUYEN_NHOMQUYEN` FOREIGN KEY (`manhomquyen`) REFERENCES `nhomquyen` (`manhomquyen`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD CONSTRAINT `FK_NGUOIDUNG_NHOMQUYEN` FOREIGN KEY (`manhomquyen`) REFERENCES `nhomquyen` (`manhomquyen`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `FK_PHIEUNHAP_NHACUNGCAP` FOREIGN KEY (`manhacungcap`) REFERENCES `nhacungcap` (`manhacungcap`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_PHIEUNHAP_TAIKHOAN` FOREIGN KEY (`nguoitao`) REFERENCES `nguoidung` (`taikhoan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `FK_PHIEUXUAT_NGUOIDUNG` FOREIGN KEY (`nguoitao`) REFERENCES `nguoidung` (`taikhoan`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
