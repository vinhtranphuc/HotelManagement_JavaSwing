package BLL;

import javax.swing.table.DefaultTableModel;

import DAL.KnpDal;
import DTO.KNP;

public class KnpBll extends KhachBll{
	
    KnpDal da=new KnpDal();
    
	public DefaultTableModel getKnp()
	{
	return da.getKnp();
	}
	
	public boolean themKnp(KNP knp)
	{
	return da.themKnp(knp);
	}
	
    public boolean suaKnp(KNP knp)
	{
	return da.suaKnp(knp);
	}
    
	public boolean xoaKnpTraPhong(String maphong)
	{
    return da.xoaKnpTraPhong(maphong);
	} 
	
}
