package BLL;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import DAL.PhongDal;
import DTO.Phong;

public class PhongBll extends KnpBll { 
	
	PhongDal da=new PhongDal();

	public DefaultTableModel getPhong(String tenphong)
	{
	return da.getPhong(tenphong);
	}
	
	public DefaultTableModel getPhong1(int tinhtrang)
	{
	return da.getPhong1(tinhtrang);
	}
	
	public DefaultTableModel timPhong(int j)
	{
	return da.timPhong(j);
	}
	
	public DefaultComboBoxModel<String> getPhongCmb()
	{
	return da.getPhongCmb();
	}
	
	public String getStt(String Id)
	{
	return da.getStt(Id);
	}
	
	public String getGiaPhong(String maphong)
	{
	return da.getGiaPhong(maphong);
	}
	
	public DefaultTableModel getDvPhong(String maphong)
	{
	return da.getDvPhong(maphong);
	}
	
	public String demPhong(int tt)
	{
	return da.demPhong(tt);
	}
	
	public boolean themPh(Phong ph)
	{
	return da.themPh(ph);
	}
	
    public boolean suaPh(Phong ph)
	{
	return da.suaPh(ph);
	}
    
    public boolean capNhatPh(int TinhTrang,String MaPhong)
	{
	return da.capNhatPh(TinhTrang,MaPhong);
	}
    
	public boolean xoaPh(Phong ph)
	{
    return da.xoaPh(ph);
	} 	
	
}
