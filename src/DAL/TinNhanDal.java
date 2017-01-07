package DAL;

import java.sql.ResultSet;

import DTO.TinNhan;

public class TinNhanDal extends DataProvider{

	public String getTinNhan()
	{
	String tn="";
	String alltn="";
	try
	{
	ResultSet rs=exQ("select * from tb_login,tb_tinnhan where tb_login.ma_tk=tb_tinnhan.ma_tk order by ma_tn asc");
	while(rs.next()) 
	{
	tn=rs.getString("ten_tk")+" "+rs.getString("ngay_tn")+" : "+rs.getString("noidung_tn")+"\n";
	alltn+=tn;
	}
	return alltn;
	}
	catch(Exception ex)
	{
	System.out.println("lỗi tn TinNhanDal/getTinNhan() " + ex.toString());
	return null;
	}
	}
	
	
	public boolean themTn(TinNhan tn)
	{
	try{
	String query="insert into tb_tinnhan values(N'"+Ai("tb_tinnhan","ma_tn")+"',N'"+tn.getNoiDung()+"',N'" +tn.getMaUser()+"',N'" +tn.getNgayTn()+"')";	
	exU(query);
	return true;
	}catch(Exception ex)
	{
	System.out.println("Loi TinNhanDal/themTn "+ex);
	}
	return false;
	}
	
    public boolean suaTn(TinNhan tn)
	{
	try 
	{ 
	String query="update tb_tinnhan set ma_tn=N'"+tn.getMaTn()+"', noidung_tn=N'"+tn.getNoiDung()+"', ma_tk=N'"+tn.getMaUser()+"', ngay_tn=N'"+tn.getNgayTn()+"' where ma_tn=N'"+tn.getMaTn()+"'";
	exU(query);
	return true;
	}catch(Exception e) {
	System.out.println("Loi TinNhanDal/suaTn : "+e);
	} 
	return false;
	}
    
	public boolean xoaTn()
	{
	try 
    {  
    PreSta("delete from tb_tinnhan");	
    return true;
	} catch (Exception e) {
	System.out.println("Loi TinNhanDal/xoaTn: "+e);
	} 
    return false;
	} 	
	
}
