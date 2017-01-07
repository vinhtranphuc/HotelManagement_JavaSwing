package BLL;

import javax.swing.table.DefaultTableModel;
import DAL.BienLaiDal;
import DTO.BienLai;

public class BienLaiBll extends HopDongBll{
	BienLaiDal da=new BienLaiDal();
	public DefaultTableModel getBl()
	{
	return da.getBl();
	}
	
	public boolean themBl(BienLai bl)
	{
	return da.themBl(bl);
	}
	
    public boolean suaBl(BienLai bl)
	{
	return da.suaBl(bl);
	}
    
	public boolean xoaBl(BienLai bl)
	{
    return da.xoaBl(bl);
	} 
	
	public boolean xoaBlTraPhong(String maphong)
	{
    return da.xoaBlTraPhong(maphong);
	} 
	
}

