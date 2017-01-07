package BLL;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import DAL.HopDongDal;
import DTO.HopDong;

public class HopDongBll extends PhongBll{
	HopDongDal da=new HopDongDal();
	NhanVienBll nv=new NhanVienBll();
	
	public DefaultTableModel getHopDong()
	{
	return da.getHopDong();
	}
	
	public JButton TTP(String btn)
	{
	return da.TTP(btn);
	}
	
	public String getTenPhong(String Id)
	{
	return da.getTenPhong(Id);
	}
	
	public String SttPhong(String tp)
	{
	return da.SttPhong(tp);
	}
	
	public String getGDP(String maphong)
	{
	return da.getGDP(maphong);
	}
	
	public String getNDP(String maphong)
	{
	return da.getNDP(maphong);
	}
	
	public boolean themHd(HopDong hd)
	{
	return da.themHd(hd);
	}
	
    public boolean suaHd(HopDong hd)
	{
	return da.suaHd(hd);
	}
    
	public boolean xoaHdTraPhong(String maphong)
	{
    return da.xoaHdTraPhong(maphong);
	}

}