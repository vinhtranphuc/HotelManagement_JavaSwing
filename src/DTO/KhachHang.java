package DTO;

public class KhachHang {
  private String _MaKh;
  private String _TenKh;
  private String _Cmnd;
  private String _QuocTich;
  private String _GioiTinh;
  private String _Tuoi;
  private String _LienLac;
  private String _TinhTrang;
  
  public KhachHang()
  {}
  
  public KhachHang(String MaKh,String TenKh,String Cmnd,String QuocTich,String GioiTinh,String Tuoi,String LienLac,String TinhTrang)
  {
	  this._MaKh=MaKh;
	  this._TenKh=TenKh;
	  this._Cmnd=Cmnd;
	  this._QuocTich=QuocTich;
	  this._GioiTinh=GioiTinh;
	  this._Tuoi=Tuoi;
	  this._LienLac=LienLac;
	  this._TinhTrang=TinhTrang;
  }
  
  public String getMaKh()
  {
	return _MaKh;
  }
  public void setMaKh(String MaKh)
  {
	  this._MaKh=MaKh;
  }
  
  public String getTenKh()
  {
	return _TenKh;
  }
  public void setTenKh(String TenKh)
  {
	  this._TenKh=TenKh;
  }
  
  public String getCmnd()
  {
	return _Cmnd;
  }
  public void setCmnd(String Cmnd)
  {
	  this._Cmnd=Cmnd;
  }
  
  public String getQuocTich()
  {
	return _QuocTich;
  }
  public void setQuocTich(String QuocTich)
  {
	 this._QuocTich=QuocTich;
  }
  
  public String getGioiTinh()
  {
	return _GioiTinh;
  }
  public void setGioiTinh(String GioiTinh)
  {
	  this._GioiTinh=GioiTinh;
  }
  
  public String getTuoi()
  {
	return _Tuoi;
  }
  public void setTuoi(String Tuoi)
  {
	  this._Tuoi=Tuoi;
  }
  
  public String getLienLac()
  {
	return _LienLac;
  }
  public void setLienLac(String LienLac)
  {
	  this._LienLac=LienLac;
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
