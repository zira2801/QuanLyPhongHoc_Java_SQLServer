use master
if exists (select * from sysdatabases where name = 'QLPH')
	drop database QLPH
go
create database QLPH
go
use QLPH
go

CREATE TABLE TaiKhoan (
  Email NVARCHAR(255) primary key,
  tkpassword NVARCHAR(255),
  Ten nvarchar(100),
  avatar varbinary(max)
);

CREATE TABLE PhongHoc (
  id_phong int identity(1,1) PRIMARY KEY,
  tenPhong CHAR(3) ,
  SoChoNgoi INT,
  LoaiPhong NVARCHAR(50),
  CoSo CHAR(1),	
  TrangThai NVARCHAR(50),
  Solansudung int,
  Email NVARCHAR(255)
  FOREIGN KEY (Email) REFERENCES TaiKhoan(Email)
);

CREATE TABLE GiangVien (
  id_gv int identity(1,1) PRIMARY KEY,
  MaGV Char(4) ,
  tenGiangVien NVARCHAR(255),
  GioiTinh NVARCHAR(10),
  SoDT char(12),
  NgaySinh DATE,
  AnhGV varbinary(max),
Email NVARCHAR(255),
  FOREIGN KEY (Email) REFERENCES TaiKhoan(Email)
);



CREATE TABLE MonHoc (
  id_mh int identity(1,1) primary key,
  tenMonHoc NVARCHAR(255),
  SoTinChi int,
  id_gv int,
  AnhGV varbinary(max),
  Email NVARCHAR(255),
  FOREIGN KEY (id_gv) REFERENCES GiangVien(id_gv) ON DELETE CASCADE,
  FOREIGN KEY (Email) REFERENCES TaiKhoan(Email)
);
CREATE TABLE KhoThietBi (
  id_tb int identity(1,1) PRIMARY KEY,
  MaTB CHAR(4),
  TenTB NVARCHAR(100),
  LoaiTB NVARCHAR(100),
  SoLuongTB INT,
  NhaSX NVARCHAR(100),
  NgayNhap DATE,
  AnhTB varbinary(max),
  Email NVARCHAR(255),
  FOREIGN KEY (Email) REFERENCES TaiKhoan(Email)
);
CREATE TABLE ThietBi (
  id int identity(1,1) primary key,
  id_tb int,
  soLuong INT,
  id_phong int,
  TinhTrangTB NVARCHAR(100),
  Email NVARCHAR(255),
  FOREIGN KEY (id_phong) REFERENCES PhongHoc(id_phong) ON DELETE CASCADE,
  FOREIGN KEY (Email) REFERENCES TaiKhoan(Email),
  FOREIGN KEY (id_tb) REFERENCES KhoThietBi(id_tb) ON DELETE CASCADE,
  FOREIGN KEY (Email) REFERENCES TaiKhoan(Email)
);




CREATE TABLE LichHoc (
  id INT identity(1,1) PRIMARY KEY,
  id_gv int,
  id_phong int,
  ngayHoc DATE,
  tietbd int,
  tietkt int,
  tenmonhoc Nvarchar(100),
  Email NVARCHAR(255),
  FOREIGN KEY (id_gv) REFERENCES GiangVien(id_gv),
  FOREIGN KEY (id_phong) REFERENCES PhongHoc(id_phong) ON DELETE CASCADE,
  FOREIGN KEY (Email) REFERENCES TaiKhoan(Email)
);



set dateformat dmy
ALTER TABLE dbo.ThietBi CHECK CONSTRAINT FK__ThietBi__tenPhon__4316F928
Alter TABLE dbo.ThietBi CHECK CONSTRAINT FK__ThietBi__tenPhon__4316F928


INSERT INTO TaiKhoan(Email, password, Ten,avatar) VALUES (?,?,?,?)
select tenPhong from PhongHoc



Delete tb
from ThietBi tb join PhongHoc ph on tb.id_phong = ph.id_phong
where tb.Email = N'duy456@gmail.com'  and ph.tenPhong = 'A25'
Delete from PhongHoc where Email = 'duy456@gmail.com' and tenPhong = 'B25'
SELECT id_mh,tenMonHoc,SoTinChi,gv.tenGiangVien,mh.Email FROM MonHoc mh join GiangVien gv on mh.MaGV = gv.MaGV WHERE Email = N'duy@gmail.com'