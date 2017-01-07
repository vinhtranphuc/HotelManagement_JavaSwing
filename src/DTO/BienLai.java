package DTO;

public class BienLai {
 public String _MaHd;
 public String _MaHdon;
 
 public BienLai()
 {}
 
 public BienLai(String MaHd,String MaHdon)
 {
	 this._MaHd=MaHd;
	 this._MaHdon=MaHdon;
 }
 public String getMaHd()
 {
	 return _MaHd;
 }
 
 public void setMaHd(String MaHd)
 {
	 this._MaHd=MaHd;
 }
 
 
 public String getMaHdon()
 {
	 return _MaHdon;
 }
 public void setMaHdon(String MaHdon)
 {
	 this._MaHdon=MaHdon;
 }
 
}
