package DAL;

import javax.swing.table.DefaultTableModel;
import DTO.HoaDon;

public class HoaDonDal extends DataProvider {
	public DefaultTableModel getHoaDon()
	{
	String query="select ma_hddv,tb_dichvu.ten_dv,gio_hddv,ngay_hddv from tb_hoadondv, tb_dichvu where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tinhtrang=N'0' order by ma_hddv asc";
	String[] tieude={"ID","Tên Dv","Tgian đặt","Ngày đặt"};
	String[] field={"ma_hddv","ten_dv","gio_hddv","ngay_hddv"};
	if(tieude.length!=field.length) System.out.println("tieude != field");
	return getTb(query,tieude,field);
	}
	
	public String demHoaDon()
	{
	String query="select DISTINCT * from tb_hoadondv where tb_hoadondv.tinhtrang=N'0'";
	return demDong(query);
	}
	
	public boolean themHdon(HoaDon hd)
	{
	try{
	String query="insert into tb_hoadondv values(N'"+Ai("tb_hoadondv","ma_hddv")+"',N'"+hd.getMaDv()+"',N'"+hd.getGioHdon()+"',N'"+hd.getNgayHdon()+"',N'"+hd.getTinhTrang()+"')";	
	exU(query);
	return true;
	}catch(Exception ex)
	{
	System.out.println("Lỗi HoaDonDal/themHdon "+ex);
	}
	return false;
	}
	
    public boolean suaHdon(HoaDon hd)
	{
	try 
	{ 
	String query="update tb_hoadondv set ma_dv=N'"+hd.getMaDv()+"', gio_hddv=N'"+hd.getGioHdon()+"', ngay_hddv=N'"+hd.getNgayHdon()+"', tinhtrang=N'"+hd.getTinhTrang()+"' where ma_hddv=N'"+hd.getMaHdon()+"'";
	exU(query);
	return true;
	} catch (Exception e) {
	System.out.println("Loi HoaDonDal/suaHdon: "+e);
	} 
	return false;
	}
    
	public boolean xoaHdon(String mahoadon)
	{
	try 
    {  
    PreSta("delete from tb_hoadondv where ma_hddv='"+mahoadon+"'");
    return true;
	} catch (Exception e) {
	System.out.println("Loi HoaDonDal/XoaHdon: "+e);
	} 
    return false;
	} 
	
	public boolean xoaHdon()
	{
	try 
    {  
    PreSta("delete from tb_hoadondv where tinhtrang='0'");
    return true;
	} catch (Exception e) {
	System.out.println("Loi HoaDonDal/XoaHdon: "+e);
	} 
    return false;
	} 
	

}
