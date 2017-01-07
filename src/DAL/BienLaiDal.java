package DAL;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import DTO.BienLai;

public class BienLaiDal extends DataProvider {

	public DefaultTableModel getBl()
	{
	String query="select * from tb_bienlai";
	String[] tieude={"Id_HopDong","Id_HoaDon"};
	String[] field={"ma_hd","ma_hddv"};
	if(tieude.length!=field.length) System.out.println("tieude != field");
	return getTb(query,tieude,field);
	}
	
	public boolean themBl(BienLai bl)
	{
	try{
	String query="insert into tb_bienlai values(N'"+bl.getMaHd()+"',N'"+bl.getMaHdon()+"')";	
	exU(query);
	return true;
	}catch(Exception ex){
	System.out.println("Lỗi BienLaiDal/themBl "+ex);
	}
	return false;
	}
	
    public boolean suaBl(BienLai bl)
	{
	try 
	{ 
	String query="update tb_bienlai set ma_hd=N'"+bl.getMaHd()+"', ma_hddv=N'"+bl.getMaHdon()+"' where ma_hd=N'"+bl.getMaHd()+"'";
	exU(query);
	return true;
	} catch (SQLException e) {
	System.out.println("Loi BienLaiDal/suabl: "+e);
	} 
	return false;
	}
    
	public boolean xoaBl(BienLai bl)
	{
	try 
    {  
    PreSta("delete from tb_bienlai where ma_hd=N'"+bl.getMaHd()+"'");	
    return true;
	} catch (Exception e) {
	System.out.println("Loi BienLaiDal/xoaBl: "+e);
	} 
    return false;
	} 
	
	public boolean xoaBlTraPhong(String maphong)
	{
	try 
    {  
    PreSta("delete from tb_bienlai where ma_hddv in (select tb_bienlai.ma_hddv from tb_bienlai,tb_hdtp,tb_phong where tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong='"+maphong+"')");
    return true;
	} catch (Exception e) {
	System.out.println("Loi BienLaiDal/xoaBl: "+e);
	} 
    return false;
	} 
}
