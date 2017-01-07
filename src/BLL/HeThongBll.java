package BLL;

import javax.swing.table.DefaultTableModel;
import DAL.HeThongDal;
import DTO.User;

public class HeThongBll extends TinNhanBll{
	HeThongDal da=new HeThongDal();
	
	public DefaultTableModel getTvien()
	{
	return da.getTvien();
	}
	
	public String getNameUser()
	{
	return da.getNameUser();
	}
	
	public String getPass()
	{
	return da.getPass();
	}
	
	public String quyenUser()
	{
	return da.quyenUser();
	}
	
	public boolean themUser(User us)
	{
	return da.themUser(us);
	}
	
    public boolean DoiMk(String mk)
	{
	return da.DoiMk(mk);
	}
    
	public boolean xoaUser(User us)
	{
    return da.xoaUser(us);
	}

	public String itemLogin(String id) {
		// TODO Auto-generated method stub
		return null;
	} 	
	
}