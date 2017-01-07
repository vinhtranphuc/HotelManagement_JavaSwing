package DTO;

public class TinNhan {
 public String _MaTn;
 public String _NoiDung;
 public String _MaUser;
 public String _NgayTn;
 
 public TinNhan()
 {}
 
 public TinNhan(String MaTn,String NoiDung,String User,String NgayTn)
 {
  this._MaTn=MaTn;
  this._NoiDung=NoiDung;
  this._MaUser=User;
  this._NgayTn=NgayTn;
 }
 
 public String getMaTn()
 {
	 return _MaTn;
 }
 public void setMaTn(String MaTn)
 {
	 this._MaTn=MaTn;
 }
 
 public String getNoiDung()
 {
	 return _NoiDung;
 }
 public void setNoiDung(String NoiDung)
 {
	 this._NoiDung=NoiDung;
 }
 
 public String getMaUser()
 {
	 return _MaUser;
 }
 public void setUser(String MaUser)
 {
	 this._MaUser=MaUser;
 }
 
 public String getNgayTn()
 {
	 return _NgayTn;
 }
 public void setNgayTn(String NgayTn)
 {
	 this._NgayTn=NgayTn;
 }
}
