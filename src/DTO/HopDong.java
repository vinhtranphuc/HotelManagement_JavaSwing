package DTO;

public class HopDong {

	public String _MaHd;
	public String _MaPh;
	public String _MaNv;
	public String _NgayDp;
	public String _GioDp;
	
	public HopDong()
	{}
	
	public HopDong(String MaHd,String MaPh,String MaNv,String NgayDp,String GioDp)
	{
		this._MaHd=MaHd;
		this._MaPh=MaPh;
		this._MaNv=MaNv;
		this._NgayDp=NgayDp;
		this._GioDp=GioDp;
	}
	public String getMaHd()
	{
	return this._MaHd;
	}
	
	public void setMaHd(String MaHd)
	{
	this._MaHd=MaHd;
	}
	
	public String getMaPh()
	{
	return this._MaPh;
	}
	
	public void setMaPh(String MaPh)
	{
	this._MaPh=MaPh;
	}
	
	public String getMaNv()
	{
	return this._MaNv;
	}
	
	public void setMaNv(String MaNv)
	{
	this._MaNv=MaNv;
	}
	
	public String getNgayDp()
	{
	return this._NgayDp;
	}
	
	public void setNgayDp(String NgayDp)
	{
	this._NgayDp=NgayDp;
	}
	
	public String getGioDp()
	{
	return this._GioDp;
	}
	
	public void setGioDp(String GioDp)
	{
	this._GioDp=GioDp;
	}
}
