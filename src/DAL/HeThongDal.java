package DAL;

import javax.swing.table.DefaultTableModel;
import DTO.User;

public class HeThongDal extends DataProvider {
	
	public DefaultTableModel getTvien()
	{
	String query="select * from tb_login";
	String[] tieude={"Id_User","Tài Khoản","Mật Khẩu","Họ Tên"};
	String[] field={"ma_tk","taikhoan","matkhau","ten_tk"};
	if(tieude.length!=field.length) System.out.println("tieude != field");
	return getTb(query,tieude,field);
	}
	
	public String quyenUser()
	{
	String query="select tinhtrang from tb_login where ma_tk=N'"+getIdUser()+"'";
	String col="tinhtrang";
	return getCell(query,col);
	}
	
	public String getNameUser()
	{
	String query="select * from tb_login where ma_tk=N'"+getIdUser()+"'";
	String col="ten_tk";
	return getCell(query,col);
	}
	
	public String getIdUser()
	{
	String query="select * from id where Id=N'*' order by ma_id asc";
	String col="Id_1";
	return getCell(query,col);
	}
	
	public String getPass()
	{
	String query="select * from tb_login where ma_tk=N'"+getIdUser()+"'";
	String col="matkhau";
	return getCell(query,col);
	}
	
	public boolean themUser(User us)
	{
	try{
	String query="insert into tb_login values(N'"+Ai("tb_login","ma_tk")+"',N'"+us.getTkUser()+"',N'" +us.getMkUser()+"',N'" +us.getTenUser()+"',N'" +us.getTinhTrang()+"',N'" +us.getMaNv()+"')";	
	exU(query);
	return true;
	}catch(Exception ex)
	{
	System.out.println("Lỗi UserDal/themUs "+ex);
	}
	return false;
	}
	
    public boolean DoiMk(String mk)
	{
	try 
	{ 
	String query="update tb_login set ma_tk=N'"+getIdUser()+"', matkhau=N'"+mk+"' where ma_tk=N'"+getIdUser()+"'";
	exU(query);
	return true;
	} catch (Exception e) {
	System.out.println("Loi UserDal/suaUser: "+e);
	} 
	return false;
	}
    
	public boolean xoaUser(User us)
	{
	try 
    {  
    PreSta("delete from tb_login where ma_tk=N'"+us.getMaUser()+"'");	
    return true;
	} catch (Exception e) {
	System.out.println("Loi UserDal/xoaNv: "+e);
	} 
    return false;
	} 	
	
}

