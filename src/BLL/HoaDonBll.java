package BLL;

import javax.swing.table.DefaultTableModel;

import DAL.HoaDonDal;
import DTO.HoaDon;

public class HoaDonBll extends NhanVienBll {
    HoaDonDal da=new HoaDonDal();
	public DefaultTableModel getHoaDon()
	{
	return da.getHoaDon();
	}
	
	public String demHoaDon()
	{
	return da.demHoaDon();
	}
	
	public boolean themHdon(HoaDon hd)
	{
	return da.themHdon(hd);
	}
	
    public boolean suaHdon(HoaDon hd)
	{
	return da.suaHdon(hd);
	}
    
	public boolean xoaHdon(String mahoadon)
	{
    return da.xoaHdon(mahoadon);
	} 
	
	public boolean xoaHdon()
	{
    return da.xoaHdon();
	} 
	
}
