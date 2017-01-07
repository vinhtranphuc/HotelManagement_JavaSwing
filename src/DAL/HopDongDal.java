package DAL;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import DTO.HopDong;

public class HopDongDal extends DataProvider {

	public DefaultTableModel getHopDong()
	{
	String query="select ten_phong,case loai_phong when 1 then N'phòng đơn' when 2 then N'phòng đôi' when 3 then N'phòng ba' else N'Phòng Vip' end as loai_phong,gia_phong,tb_hdtp.ngay_dp,tb_hdtp.gio_dp from tb_phong,tb_hdtp where tb_phong.tinhtrang='1' and tb_phong.ma_phong=tb_hdtp.ma_phong order by ma_hd asc";
	String[] tieude={"Tên Phòng","Loại Phòng","Giá Phòng","Ngày DP","Giờ DP"};
	String[] field={"ten_phong","loai_phong","gia_phong","ngay_dp","gio_dp"};
	if(tieude.length!=field.length) System.out.println("tieude != field");
	return getTb(query,tieude,field);
	}
	
	public JButton TTP(String btn)
	{
	String query="select * from tb_phong";
	String tenphong="ten_phong";
	String loaiphong="loai_phong";
	return TTP(btn,query,tenphong,loaiphong);
	}
	
	public String getTenPhong(String Id)
	{
	String query="select * from tb_phong where ma_phong='"+Id+"'";
	String col="ten_phong";
	return getCell(query,col);
	}
	
	public String SttPhong(String tp)
	{
	String query="select * from tb_phong where ten_phong='"+tp+"'";
	String col="tinhtrang";
	return getCell(query,col);
	}
	
	public String getNDP(String maphong)
	{
	String query="select DISTINCT * from tb_phong,tb_hdtp where tb_phong.ma_phong=tb_hdtp.ma_phong and tb_phong.ma_phong=N'"+maphong+"'";
	String col="ngay_dp";
	return getCell(query,col);
	}
	
	public String getGDP(String maphong)
	{
	String query="select DISTINCT * from tb_phong,tb_hdtp where tb_phong.ma_phong=tb_hdtp.ma_phong and tb_phong.ma_phong=N'"+maphong+"'";
	String col="gio_dp";
	return getCell(query,col);
	}
	
	public boolean themHd(HopDong hd)
	{
	try{
	String query="insert into tb_hdtp values(N'"+Ai("tb_hdtp","ma_hd")+"',N'"+hd.getMaHd()+"',N'" +hd.getMaNv()+"',N'"+ngayHt+"',N'" +gioHt+"')";	
	exU(query);
	return true;
	}catch(Exception ex)
	{
	System.out.println("Lỗi HopDongDal/themHd "+ex);
	}
	return false;
	}
	
    public boolean suaHd(HopDong hd)
	{
	try 
	{ 
	String query="update tb_hdtp set ma_hd=N'"+hd.getMaHd()+"', ma_phong=N'"+hd.getMaPh()+"', ma_nv=N'"+hd.getMaNv()+"', ngay_dp=N'"+hd.getGioDp()+"', gio_dp=N'"+hd.getNgayDp()+"' where ma_hd=N'"+hd.getMaHd()+"'";
	exU(query);
	return true;
	} catch (Exception e) {
	System.out.println("HopDongDal/suaHd: "+e);
	} 
	return false;
	}
    
	public boolean xoaHdTraPhong(String maphong)
	{
	try 
    {  
    PreSta("delete from tb_hdtp where ma_phong in (select tb_hdtp.ma_phong from tb_hdtp, tb_phong where tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong=N'"+maphong+"')");
    return true;
	} catch (Exception e) {
	System.out.println("Loi HopDongDal/XoaHd: "+e);
	} 
    return false;
	} 	
	
}
