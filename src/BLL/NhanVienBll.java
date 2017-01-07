package BLL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import DAL.NhanVienDal;
import DTO.NhanVien;

public class NhanVienBll extends HandlingBLL{
    NhanVienDal da=new NhanVienDal();
    
	public DefaultTableModel getNhanVien()
	{
	return da.getNhanVien();
	}
	
	public DefaultComboBoxModel<String> getNv()
	{
	return da.getNv();
	}
	///lấy Id nhân viên đăng nhập
	public String getIdNv1(String ma_tk)
	{
	return da.getIdNv1(ma_tk);
	}
	
	public String getIdNv(String tennv)
	{
	return da.getIdNv(tennv);
	}
	
	public String demNvien(int i)
	{
	return da.demNvien(i);
	}
	
	public boolean themNv(NhanVien nv)
	{
	return da.themNv(nv);
	}
	
    public boolean suaNv(NhanVien nv)
	{
	return da.suaNv(nv);
	}
    
	public boolean xoaNv(NhanVien nv)
	{
    return da.xoaNv(nv);
	} 	
	
}
