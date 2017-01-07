package BLL;

import DAL.TinNhanDal;
import DTO.TinNhan;

public class TinNhanBll extends HandlingBLL {
    TinNhanDal da=new TinNhanDal();
    
	public String getTinNhan()
	{
	return da.getTinNhan();
	}
	
	public boolean themTn(TinNhan tn)
	{
	return da.themTn(tn);
	}
	
    public boolean suaTn(TinNhan tn)
	{
	return da.suaTn(tn);
	}
    
	public boolean xoaTn()
	{
    return da.xoaTn();
	} 	
	
}

