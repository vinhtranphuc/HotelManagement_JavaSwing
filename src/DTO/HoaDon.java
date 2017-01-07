package DTO;

public class HoaDon {
 public String _MaHdon;
 public String _MaDv;
 public String _GioHdon;
 public String _NgayHdon;
 public String _TinhTrang;
 
 public HoaDon()
 {
 }
 
 public HoaDon(String MaHdon,String MaDv,String GioHdon,String NgayHdon,String TinhTrang)
 {
  this._MaHdon=MaHdon;
  this._MaDv=MaDv;
  this._GioHdon=GioHdon;
  this._NgayHdon=NgayHdon;
  this._TinhTrang=TinhTrang;
 }
 
 public String getMaHdon()
 {
 return _MaHdon;
 }
 
 public void setMaHdon(String MaHdon)
 {
 this._MaHdon=MaHdon;
 }
 
 public String getMaDv()
 {
 return _MaDv;
 }
 
 public void setMaDv(String MaDv)
 {
 this._MaDv=MaDv;
 }
 
 public String getGioHdon()
 {
 return _GioHdon;
 }
 
 public void setGioHdon(String MaGioHdon)
 {
 this._GioHdon=MaGioHdon;
 }
 
 public String getNgayHdon()
 {
 return _NgayHdon;
 }
 
 public void setNgayHdon(String NgayHdon)
 {
 this._NgayHdon=NgayHdon;
 }
 
 public String getTinhTrang()
 {
 return _TinhTrang;
 }
 
 public void setTinhTrang(String TinhTrang)
 {
 this._TinhTrang=TinhTrang;
 }
}
