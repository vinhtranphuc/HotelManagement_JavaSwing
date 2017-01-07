package DTO;

public class User {

	public String _MaUser;
	public String _TkUser;
	public String _MkUser;
	public String _TenUser;
	public String _TinhTrang;
	public String _MaNv;
	
	public User()
	{
	}
	
	public User(String MaUser,String TkUser,String MkUser,String TenUser,String TinhTrang,String MaNv)
	{
		this._MaUser=MaUser;
		this._TkUser=TkUser;
		this._MkUser=MkUser;
		this._TenUser=TenUser;
		this._TinhTrang=TinhTrang;
		this._MaNv=MaNv;
	}
	
	public String getMaUser()
	{
		return _MaUser;
	}
	public void setMaUser(String MaUser)
	{
		this._MaUser=MaUser;
	}
	
	public String getTkUser()
	{
		return _TkUser;
	}
	public void setTkUser(String TkUser)
	{
		this._TkUser=TkUser;
	}
	
	public String getMkUser()
	{
		return _MkUser;
	}
	public void setMkUser(String MkUser)
	{
		this._MkUser=MkUser;
	}
	
	public String getTenUser()
	{
		return _TenUser;
	}
	public void setTenUser(String TenUser)
	{
		this._TenUser=TenUser;
	}
	
	public String getTinhTrang()
	{
		return _TinhTrang;
	}
	public void setTinhTrang(String TinhTrang)
	{
		this._TinhTrang=TinhTrang;
	}
	
	public String getMaNv()
	{
		return _MaNv;
	}
	public void setMaNv(String MaNv)
	{
		this._MaNv=MaNv;
	}
}
