package DAL;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import DTO.NhanVien;

public class NhanVienDal extends DataProvider{
	
	public DefaultTableModel getNhanVien()
	{
	String query="select ma_nv,ten_nv,chucvu_nv,luong_nv,namsinh_nv,case when gioitinh_nv=1 then N'Nam' else N'Nữ' end as gioitinh_nv,chuthich_nv from tb_nhanvien order by ma_nv asc";
	String[] tieude={"Mã NV","Tên NV","Chức vụ","Lương","Năm sinh","Giới tính","Chú thích"};
	String[] field={"ma_nv","ten_nv","chucvu_nv","luong_nv","namsinh_nv","gioitinh_nv","chuthich_nv"};
	if(tieude.length!=field.length) System.out.println("tieude != field");
	return getTb(query,tieude,field);
	}
	
	public DefaultComboBoxModel<String> getNv()
	{
	String query="select * from tb_nhanvien,tb_login where tb_nhanvien.ma_nv!=tb_login.ma_nv and chucvu_nv=N'Lễ tân'";
	String element="Nhân viên lễ tân:";
	String col="ten_nv";
	return getCmb(query,element,col);
	}
	
	public String getIdNv(String tennv)
	{
	String query="select * from tb_nhanvien where ten_nv=N'"+tennv+"'";
	String col="ma_nv";
	return getCell(query,col);
	}
	
	public String getIdNv1(String ma_tk)
	{
	String query="select * from tb_login where ma_tk=N'"+ma_tk+"'";
	String col="ma_nv";
	return getCell(query,col);
	}
	
	public String demNvien(int i)
	{
	String where="";
	if(i==1) where="where gioitinh_nv='1'";
	if(i==0) where="where gioitinh_nv='0'";
	String query="select DISTINCT * from tb_nhanvien "+where;
	return demDong(query);
	}
	
	public boolean themNv(NhanVien nv)
	{
	try{
	String query="insert into tb_nhanvien values(N'"+Ai("tb_nhanvien","ma_nv")+"',N'"+nv.getTenNv()+"',N'" +nv.getChucVu()+"',N'" +nv.getLuong()+"',N'" +nv.getNamSinh()+"',N'" +nv.getGioiTinh()+"',N'" +nv.getChuThich()+"')";	
	exU(query);
	return true;
	}catch(Exception ex)
	{
	System.out.println("Lỗi NhanVienDal/themNv "+ex);
	}
	return false;
	}
	
    public boolean suaNv(NhanVien nv)
	{
	try 
	{ 
	String query="update tb_nhanvien set ma_nv=N'"+nv.getMaNv()+"', ten_nv=N'"+nv.getTenNv()+"', chucvu_nv=N'"+nv.getChucVu()+"', luong_nv=N'"+nv.getLuong()+"', namsinh_nv=N'"+nv.getNamSinh()+"', gioitinh_nv=N'"+nv.getGioiTinh()+"', chuthich_nv=N'"+nv.getChuThich()+"' where ma_nv=N'"+nv.getMaNv()+"'";
	exU(query);
	return true;
	} catch (Exception e) {
	System.out.println("Loi NhanVienDal/suaNv : "+e);
	} 
	return false;
	}
    
	public boolean xoaNv(NhanVien nv)
	{
	try 
    {  
    PreSta("delete from tb_nhanvien where ma_nv=N'"+nv.getMaNv()+"'");	
    return true;
	} catch (Exception e) {
	System.out.println("Loi NhanVienDal/xoaNv: "+e);
	} 
    return false;
	} 	
	
}
