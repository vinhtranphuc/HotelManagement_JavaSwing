package BLL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import DAL.KhachDal;
import DTO.KhachHang;

public class KhachBll extends HandlingBLL{
	KhachDal da=new KhachDal();
	
	public DefaultTableModel getKhach() {return da.getKhach();}
	
	public DefaultTableModel getKhachCho() {return da.getKhachCho();}
	
	public DefaultTableModel getQuocTich(String quoctich) {return da.getQuocTich(quoctich);}
	
	public DefaultComboBoxModel<String> getQtichCmb() {return da.getQtichCmb();}
	
	public DefaultTableModel getTimKhach(int i,String phong) {return da.getTimKhach(i,phong);}
	
	public String demKhach(int i)  {return da.demKhach(i);}
	
	public String demKhachTheoPhong(String maphong)
	{
	return da.demKhachTheoPhong(maphong);
	}
	
	public boolean themKh(KhachHang kh) {return da.themKh(kh);}
	
	public boolean suaKh(KhachHang kh) {return da.suaKh(kh);}
	
	public boolean luuKh() {return da.luuKh();}
	
	public boolean xoaKh(KhachHang kh) {return da.xoaKh(kh);}
	
	public boolean XoaKhach_TraPhong(String maphong)
	{
	return da.XoaKhach_TraPhong(maphong);
	} 
	
}
