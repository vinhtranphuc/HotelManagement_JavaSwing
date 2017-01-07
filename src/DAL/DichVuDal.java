package DAL;
import javax.swing.table.DefaultTableModel;
import DTO.DichVu;

public class DichVuDal extends DataProvider {

	public DefaultTableModel getDv()
	{
	String query="select * from tb_dichvu";
	String[] element={"Id_Dv","Tên Dv","Giá Dv"};
	String[] field={"ma_dv","ten_dv","gia_dv"};
	return getTb(query,element,field);
	}
	
	public DefaultTableModel getThanhToanDv()
	{
	String query="select tb_dichvu.ten_dv,gio_hddv,tb_dichvu.gia_dv from tb_hoadondv, tb_dichvu where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tinhtrang=0 order by ma_hddv asc";
	String[] element ={"Dịch vụ","Giá*1000đ","Thời gian đặt"};
	String[] field={"ten_dv","gia_dv","gio_hddv"};
	return getTb(query,element,field);
	}
	
	public String demSLDV(String maphong)
	{
	String query="select DISTINCT * from tb_hoadondv,tb_bienlai,tb_hdtp,tb_phong where tb_hoadondv.ma_hddv=tb_bienlai.ma_hddv and tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_hdtp.ma_phong='"+maphong+"'";
	return demDong(query);
	}
	
	public String getDDV(String maphong)
	{
	String query="select DISTINCT tb_hoadondv.ngay_hddv from tb_hoadondv,tb_bienlai,tb_hdtp,tb_phong where tb_hoadondv.ma_hddv=tb_bienlai.ma_hddv and tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong='"+maphong+"'";
	String col="ngay_hddv";
	return getCell(query,col);
	}
	
	public boolean themDv(DichVu dv)
	{
	try{
	String Id=Ai("tb_dichvu","ma_dv");
	String query="insert into tb_dichvu values(N'"+Id+"',N'"+dv.getTenDv()+"',N'"+dv.getGiaDv()+"')";	
	exU(query);
	return true;
	}catch(Exception ex){
	System.out.println("Loi DAL/DichVuDal/themDv "+ex);
	}
	return false;
	}
	
    public boolean suaDv(DichVu dv)
	{
	try 
	{ 
	String query="update tb_dichvu set ma_dv=N'"+dv.getMaDv()+"', ten_dv=N'"+dv.getTenDv()+"', gia_dv=N'"+dv.getGiaDv()+"' where ma_dv=N'"+dv.getMaDv()+"'";
	exU(query);
	return true;
	} catch (Exception e) {
	System.out.println("Loi DichVuDal/suaDv: "+e);
	} 
	return false;
	}
    
	public boolean xoaDv(DichVu dv)
	{
	try 
    {  
    PreSta("delete from tb_dichvu where ma_dv=N'"+dv.getMaDv()+"'");	
    return true;
	} catch (Exception e) {
	System.out.println("Loi DichVuDal/xoaDv: "+e);
	} 
    return false;
	} 
	
}
