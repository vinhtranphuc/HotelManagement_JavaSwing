package DTO;

public class KNP {
  public String _MaKh;
  public String _MaPh;
  
  public KNP()
  {  }
  
  public KNP(String MaKh,String MaPh)
  {
	  this._MaKh=MaKh;
	  this._MaPh=MaPh;
  }
  
  public String getMaKh()
  {
	  return this._MaKh;
  }
  
  public void setMaKh(String MaKh)
  {
	  this._MaKh=MaKh;
  }
  
  public String getMaPh()
  {
	  return this._MaPh;
  }
  
  public void setMaPh(String MaPh)
  {
	  this._MaPh=MaPh;
  }
}
