package DTO;

public class NhanVien {
  public String _MaNv;
  public String _TenNv;
  public String _ChucVu;
  public String _Luong;
  public String _NamSinh;
  public String _GioiTinh;
  public String _ChuThich;
  
  public NhanVien()
  { }
  
  public NhanVien(String MaNv,String TenNv,String ChucVu,String Luong,String NamSinh,String GioiTinh,String ChuThich)
  {
	  this._MaNv=MaNv;
	  this._TenNv=TenNv;
	  this._ChucVu=ChucVu;
	  this._Luong=Luong;
	  this._NamSinh=NamSinh;
	  this._GioiTinh=GioiTinh;
	  this._ChuThich=ChuThich;
  }
  
  public String getMaNv()
  {
	  return _MaNv;
  }
  public void setMaNv(String MaNv)
  {
	  this._MaNv=MaNv;
  }
  
  public String getTenNv()
  {
	  return _TenNv;
  }
  public void setTenNv(String TenNv)
  {
	  this._TenNv=TenNv;
  }
  
  public String getChucVu()
  {
	  return _ChucVu;
  }
  public void setChucVu(String ChucVu)
  {
	  this._ChucVu=ChucVu;
  }
  
  public String getLuong()
  {
	  return _Luong;
  }
  public void setLuong(String Luong)
  {
	  this._Luong=Luong;
  }
  
  public String getNamSinh()
  {
	  return _NamSinh;
  }
  public void setNamSinh(String NamSinh)
  {
	  this._NamSinh=NamSinh;
  }
  
  public String getGioiTinh()
  {
	  return _GioiTinh;
  }
  public void setGioiTinh(String GioiTinh)
  {
	  this._GioiTinh=GioiTinh;
  }
  
  public String getChuThich()
  {
	  return _ChuThich;
  }
  public void setChuThich(String ChuThich)
  {
	  this._ChuThich=ChuThich;
  }
  
}
