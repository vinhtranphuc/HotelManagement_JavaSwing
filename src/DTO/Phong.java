package DTO;

public class Phong {
	
	  private String _MaPh;
	  private String _TenPh;
	  private String _LoaiPh;
	  private String _GiaPh;
	  private String _ChuThich;
	  private String _TinhTrang;
	  
	  public Phong(String MaPh,String TenPh,String LoaiPh,String GiaPh,String ChuThich,String TinhTrang)
	  {
		  this._MaPh=MaPh;
		  this._TenPh=TenPh;
		  this._LoaiPh=LoaiPh;
		  this._GiaPh=GiaPh;
		  this._ChuThich=ChuThich;
		  this._TinhTrang=TinhTrang;
	  } 
	  
	 public Phong() {
	}

	public String getMaPh()
	  {
		return _MaPh;
	  }
	  public void setMaPh(String MaPh)
	  {
		  this._MaPh=MaPh;
	  }
	  
	  public String getTenPh()
	  {
		return _TenPh;
	  }
	  public void setTenPh(String TenPh)
	  {
		  this._TenPh=TenPh;
	  }
	  
	  public String getLoaiPh()
	  {
		return _LoaiPh;
	  }
	  public void setLoaiPh(String LoaiPh)
	  {
		  this._LoaiPh=LoaiPh;
	  }
	  
	  public String getGiaPh()
	  {
		return _GiaPh;
	  }
	  public void setGiaPh(String GiaPh)
	  {
		  this._GiaPh=GiaPh;
	  }
	  
	  public String getChuThich()
	  {
		return _ChuThich;
	  }
	  public void setChuThich(String ChuThich)
	  {
		  this._ChuThich=ChuThich;
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
