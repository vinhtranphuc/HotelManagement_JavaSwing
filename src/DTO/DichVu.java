package DTO;

public class DichVu {
  public String _MaDv;
  public String _TenDv;
  public String _GiaDv;
  
  public DichVu()
  {
  }
  
  public DichVu(String MaDv,String TenDv,String GiaDv)
  {
	  this._MaDv=MaDv;
	  this._TenDv=TenDv;
	  this._GiaDv=GiaDv;
  }
  
  public String getMaDv()
  {
	  return _MaDv;
  }
  public void setMaDv(String MaDv)
  { 
	this._MaDv=MaDv;
  }
  
  public String getTenDv()
  {
	  return _TenDv;
  }
  public void setTenDv(String TenDv)
  { 
	this._TenDv=TenDv;
  }
  
  public String getGiaDv()
  {
	  return _GiaDv;
  }
  public void setGiaDv(String GiaDv)
  { 
	this._GiaDv=GiaDv;
  }
  
}
