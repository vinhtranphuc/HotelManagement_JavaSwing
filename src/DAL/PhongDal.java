package DAL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import DTO.Phong;

public class PhongDal extends DataProvider {

	public DefaultTableModel getPhong(String tenphong)
	{
	String query="select * from tb_phong where ten_phong='"+tenphong+"'";
	String[] tieude={"ID_Phong","Tên Phòng","Loại Phòng","Giá Phòng","Tình Trạng","Chú Thích"};
	String[] field={"ma_phong","ten_phong","loai_phong","gia_phong","tinhtrang","chuthich"};
	if(tieude.length!=field.length) System.out.println("tieude != field");
	return getTb(query,tieude,field);
	}
	
	//get phòng, tinhtrang=0 > phòng trống, tinhtrang=1, phòng k trống
	public DefaultTableModel getPhong1(int tinhtrang)
	{
	String query="select ma_phong,ten_phong,case loai_phong when 1 then N'phòng đơn' when 2 then N'phòng đôi' when 3 then N'phòng ba' else N'phòng Vip' end as loai_phong from tb_phong where tinhtrang=1 order by ma_phong asc";
	String[] tieude={"Mã Phòng","Tên Phòng","Loại Phòng"};
	String[] field={"ma_phong","ten_phong","loai_phong"};
	return getTb(query,tieude,field);
	}
	
	public DefaultTableModel timPhong(int j)
	{
	String where="";
	if(j==0) where="where tinhtrang=N'0'";
	else if(j==1) where="where tinhtrang=N'1'";
	else if(j==2) where="where loai_phong=N'1'";
	else if(j==3) where="where loai_phong=N'2'";
	else if(j==4) where="where loai_phong=N'3'";
	else if(j==5) where="where loai_phong=N'4'";
	else if(j==6) where="where tinhtrang=N'2'";
	else where="";
	String query="select ma_phong,ten_phong,case loai_phong when 1 then N'phòng đơn' when 2 then N'phòng đôi' when 3 then N'phòng ba' else N'phòng Vip' end as loai_phong,gia_phong,chuthich,case tinhtrang when 0 then N'Phòng trống' when 1 then N'Phòng đã thuê' else N'Phòng bị khóa' end as tinhtrang from tb_phong "+where+" order by ma_phong asc";
	String[] tieude={"ID_Phong","Tên Phòng","Loại Phòng","Giá(.000đ)","Tình Trạng","Chú Thích"};
	String[] field={"ma_phong","ten_phong","loai_phong","gia_phong","tinhtrang","chuthich"};
	if(tieude.length!=field.length) System.out.println("tieude != field");
	return getTb(query,tieude,field);
	}
	
	public DefaultComboBoxModel<String> getPhongCmb()
	{
	String query="select ten_phong from tb_phong, tb_hdtp where tb_hdtp.ma_phong=tb_phong.ma_phong";
	String element="Chọn Phòng";
	String field="ten_phong";
	return getCmb(query,element,field);
	}
	
	public DefaultTableModel getDvPhong(String maphong)
	{
	String query="select tb_dichvu.ma_dv,tb_dichvu.ten_dv,tb_dichvu.gia_dv,tb_hoadondv.gio_hddv,tb_hoadondv.ngay_hddv,tb_phong.ten_phong from tb_dichvu,tb_hoadondv,tb_hdtp,tb_bienlai,tb_phong where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tb_hoadondv.ma_hddv=tb_bienlai.ma_hddv and tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_phong.ma_phong=tb_hdtp.ma_phong and tb_phong.ma_phong=N'"+maphong+"' order by ma_dv asc";
	String[] tieudecot={"Tên Dv","Giá Dv","Thời gian đặt","Ngày đặt","Tên phòng"};
	String[] field={"ten_dv","gia_dv","gio_hddv","ngay_hddv","ten_phong"};
	return getTb(query,tieudecot,field);
	}
	
	public String getStt(String Id)
	{
	String query="select * from tb_phong where ma_phong='"+Id+"'";
	String col="tinhtrang";
	return getCell(query,col);
	}
	
	public String getGiaPhong(String maphong)
	{
	String query="select DISTINCT * from tb_phong where tb_phong.ma_phong=N'"+maphong+"'";
	String col="gia_phong";
	return getCell(query,col);
	}

	public String demPhong(int tt)
	{
	String where="";
	if(tt==0) where="where tinhtrang='0'";
	if(tt==1) where="where tinhtrang='1'";
	if(tt==2) where="where loai_phong='1'";
	if(tt==3) where="where loai_phong='2'";
	if(tt==4) where="where loai_phong='3'";
	if(tt==5) where="where loai_phong='4'";
	if(tt==6) where="where tinhtrang='2'";
	String query="select DISTINCT * from tb_phong "+where+"";
	return demDong(query);
	}
	
	public boolean themPh(Phong ph)
	{
	try{
	String query="insert into tb_Phong values(N'"+Ai("tb_phong","ma_phong")+"',N'"+ph.getTenPh()+"',N'"+ph.getLoaiPh()+"',N'"+ph.getGiaPh()+"',N'"+ph.getChuThich()+"',N'"+ph.getTinhTrang()+"')";	
	exU(query);
	return true;
	}catch(Exception ex)
	{
	System.out.println("Lỗi PhongDal/themPh "+ex);
	}
	return false;
	}
	
    public boolean suaPh(Phong ph)
	{
	try 
	{ 
	String query="update tb_phong set ma_phong=N'"+ph.getMaPh()+"', ten_phong=N'"+ph.getTenPh()+"', loai_phong=N'"+ph.getLoaiPh()+"',gia_phong=N'"+ph.getGiaPh()+"',chuthich=N'"+ph.getChuThich()+"',tinhtrang=N'"+ph.getTinhTrang()+"' where ma_phong=N'"+ph.getMaPh()+"'";
	exU(query);
	return true;
	} catch (Exception e) {
	System.out.println("Loi PhongDal/suaPh: "+e);
	} 
	return false;
	}
    
    public boolean capNhatPh(int TinhTrang,String MaPhong)
	{
	try 
	{ 
	String query= "update tb_phong set tinhtrang='"+TinhTrang+"' where ma_phong=N'"+MaPhong+"'";
	exU(query);
	return true;
	} catch (Exception e) {
	System.out.println("Loi PhongDal/capNhatPh: "+e);
	} 
	return false;
	}
    
	public boolean xoaPh(Phong ph)
	{
	try 
    {  
    PreSta("delete from tb_phong where ma_phong=N'"+ph.getMaPh()+"'");	
    return true;
	} catch (Exception e) {
	System.out.println("Loi PhongDal/xoaPh: "+e);
	} 
    return false;
	} 	
}
