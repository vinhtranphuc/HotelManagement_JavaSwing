package DAL;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import DTO.KhachHang;

public class KhachDal extends DataProvider {

	public DefaultTableModel getKhach()
	{
	String query="select * from tb_khachhang where tinhtrang='1'";
	String[] tieude={"ID","Tên KH","CMND","Quốc tịch","Giới tính","Tuổi","Liên lạc"};
	String[] field={"ma_kh","ten_kh","cmnd_kh","quoctich_kh","gioitinh_kh","tuoi_kh","sdt_kh"};
	if(tieude.length!=field.length) System.out.println("tieude != field");
	return getTb(query,tieude,field);
	}
	
	public DefaultTableModel getKhachCho()
	{
	String query="select * from tb_khachhang where tinhtrang='0'";
	String[] tieude={"ID","Tên KH","Giới tính"};
	String[] field={"ma_kh","ten_kh","gioitinh_kh"};
	if(tieude.length!=field.length) System.out.println("tieude != field");
	return getTb(query,tieude,field);
	}
	
	public DefaultTableModel getTimKhach(int i,String phong)
	{
	String tenphong="";
	if(i==1) tenphong="and ten_phong=N'"+phong+"'";
	String query="select DISTINCT tb_khachhang.ma_kh,ten_kh,cmnd_kh,quoctich_kh,case when gioitinh_kh=1 then N'Nam' else N'Nữ' end as gioitinh_kh,tuoi_kh,sdt_kh,tb_phong.ten_phong from tb_khachhang,tb_khachnhanphong,tb_phong where tb_khachhang.ma_kh=tb_khachnhanphong.ma_kh and tb_phong.ma_phong=tb_khachnhanphong.ma_phong "+tenphong+" order by ma_kh asc";
	String[] tieude={"ID","Tên KH","CMND","Quốc tịch","Giới tính","Tuổi","Liên lạc","Phòng"};
	String[] field={"ma_kh","ten_kh","cmnd_kh","quoctich_kh","gioitinh_kh","tuoi_kh","sdt_kh","ten_phong"};
	if(tieude.length!=field.length) System.out.println("tieude != field");
	return getTb(query,tieude,field);
	}
	
	public DefaultTableModel getQuocTich(String quoctich)
	{
	String query="select DISTINCT tb_khachhang.ma_kh,ten_kh,quoctich_kh,case when gioitinh_kh=1 then N'Nam' else N'Nữ' end as gioitinh_kh,tuoi_kh,tb_phong.ten_phong from tb_khachhang,tb_khachnhanphong,tb_phong where tb_khachhang.ma_kh=tb_khachnhanphong.ma_kh and tb_phong.ma_phong=tb_khachnhanphong.ma_phong and quoctich_kh=N'"+quoctich+"' order by ma_kh asc";
	String[] tieude={"Tên KH","Quốc tịch","Giới tính","Phòng"};
	String[] field={"ten_kh","quoctich_kh","gioitinh_kh","ten_phong"};
	if(tieude.length!=field.length) System.out.println("tieude != field");
	return getTb(query,tieude,field);
	}
	
	public DefaultComboBoxModel<String> getQtichCmb()
	{
	String query="select DISTINCT quoctich_kh from tb_khachhang where tinhtrang='1'";
	String element="chọn Quốc Tịch";
	String field="quoctich_kh";
	return getCmb(query,element,field);
	}
	
	public String demKhach(int i)
	{
	String dk="";
	if(i==0) dk="where tinhtrang='0'";
	if(i==1) dk="where tinhtrang='1'";
	if(i==2) dk="where gioitinh_kh='0'";
	if(i==3) dk="where gioitinh_kh='1'";
	String query="select DISTINCT * from tb_khachhang "+dk+"";
	return demDong(query);
	}
	
	public String demKhachTheoPhong(String maphong)
	{
	String query="select DISTINCT * from tb_khachhang,tb_khachnhanphong,tb_phong where tb_khachnhanphong.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+maphong+"'";
	return demDong(query);
	}
	
	public boolean themKh(KhachHang kh)
	{
	try{
	String query="insert into tb_khachhang values(N'"+Ai("tb_khachhang","ma_kh")+"',N'"+kh.getTenKh()+"',N'" +kh.getCmnd()+"',N'" +kh.getQuocTich()+"',N'" +kh.getGioiTinh()+"',N'" +kh.getTuoi()+"',N'" +kh.getLienLac()+"',N'0')";	
	exU(query);
	return true;
	}catch(Exception ex)
	{
	System.out.println("Lỗi KhachDal/themKh "+ex);
	}
	return false;
	}
	
    public boolean suaKh(KhachHang kh)
	{
	try 
	{ 
	String query="update tb_khachhang set ma_kh=N'"+kh.getMaKh()+"', ten_kh=N'"+kh.getTenKh()+"', cmnd_kh=N'"+kh.getCmnd()+"', quoctich_kh=N'"+kh.getQuocTich()+"', gioitinh_kh=N'"+kh.getGioiTinh()+"', tuoi_kh=N'"+kh.getTuoi()+"', sdt_kh=N'"+kh.getLienLac()+"', tinhtrang=N'"+kh.getTinhTrang()+"' where ma_kh=N'"+kh.getMaKh()+"'";
	exU(query);
	return true;
	} catch (SQLException e) {
	System.out.println("Loi KhachHangDal/suaKh: "+e);
	} 
	return false;
	}
    
    public boolean luuKh()
    {
    try 
    { 
    String query="update tb_khachhang set tinhtrang='1' where tinhtrang='0'";
    exU(query);
    return true;
    } catch (SQLException e) {
    System.out.println("Loi KhachHangDal/luuKh: "+e);
    } 
    return false; 		
    }
    
	public boolean xoaKh(KhachHang kh)
	{
	try 
    {  
    PreSta("delete from tb_khachhang where ma_kh=N'"+kh.getMaKh()+"'");	
    return true;
	} catch (Exception e) {
	System.out.println("Loi KhachHangDal/XoaKh: "+e);
	} 
    return false;
	} 
	
	public boolean XoaKhach_TraPhong(String maphong)
	{
	try 
	{  
	PreSta("delete from tb_khachhang where ma_kh in (select tb_khachhang.ma_kh from tb_khachhang,tb_khachnhanphong,tb_phong where tb_khachhang.ma_kh=tb_khachnhanphong.ma_kh and tb_khachnhanphong.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+maphong+"')");
	return true;
	} catch (Exception e) {
	System.out.println("Loi KhachHangDal/XoaKhach_TraPhong: "+e);
	return false;
	} 
	}
}
    
    
	
	 
