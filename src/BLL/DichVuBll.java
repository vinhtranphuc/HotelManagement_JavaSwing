package BLL;

import javax.swing.table.DefaultTableModel;

import DAL.DichVuDal;
import DTO.DichVu;

public class DichVuBll extends HoaDonBll{
    DichVuDal da=new DichVuDal();
    
	public DefaultTableModel getDv()
	{
	return da.getDv();
	}
	
	public DefaultTableModel getThanhToanDv()
	{
	return da.getThanhToanDv();
	}
	
	public String demSLDV(String maphong)
	{
	return da.demSLDV(maphong);
	}
	
	public String getDDV(String maphong)
	{
	return da.getDDV(maphong);
	}
	
	public boolean themDv(DichVu dv)
	{
	return da.themDv(dv);
	}
	
    public boolean suaDv(DichVu dv)
	{
	return da.suaDv(dv);
	}
    
	public boolean xoaDv(DichVu dv)
	{
    return da.xoaDv(dv);
	} 
	
}
