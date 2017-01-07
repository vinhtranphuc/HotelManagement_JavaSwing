package DAL;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import DTO.KNP;

public class KnpDal extends DataProvider {

	public DefaultTableModel getKnp()
	{
	String query="select * from tb_khachnhanphong";
	String[] tieude={"Ma_Kh","Ma_Ph"};
	String[] field={"ma_kh","ma_phong"};
	if(tieude.length!=field.length) System.out.println("tieude != field");
	return getTb(query,tieude,field);
	}
	
	public boolean themKnp(KNP knp)
	{
	try{
	String query="insert into tb_khachnhanphong select ma_kh,ma_phong from tb_phong,tb_khachhang where tb_khachhang.tinhtrang='0' and tb_phong.ma_phong='"+knp.getMaPh()+"'";
	exU(query);
	return true;
	}catch(Exception ex){
	System.out.println("Lỗi KnpDal/themKnp "+ex);
	}
	return false;
	}
	
    public boolean suaKnp(KNP knp)
	{
	try 
	{ 
	String query="update tb_khachnhanphong set ma_kh=N'"+knp.getMaKh()+"', ma_phong=N'"+knp.getMaPh()+"' where ma_kh=N'"+knp.getMaKh()+"'";
	exU(query);
	return true;
	} catch (SQLException e) {
	System.out.println("Loi KnpDal/suaKnp: "+e);
	} 
	return false;
	}
    
	public boolean xoaKnpTraPhong(String maphong)
	{
	try 
    {  
    PreSta("delete from tb_khachnhanphong where ma_kh in (select tb_khachnhanphong.ma_kh from tb_khachnhanphong,tb_phong where tb_khachnhanphong.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+maphong+"')");
    return true;
	} catch (Exception e) {
	System.out.println("Loi KnpDal/XoaKnp: "+e);
	} 
    return false;
	} 
	
}
