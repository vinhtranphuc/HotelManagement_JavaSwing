package DAL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class HandlingDal extends DataProvider{
	public String Ngay=ngayHt;
	public String Gio=gioHt;
	
	public String demTienDv()
	{
	    String tien="";
	    int congtien=0;
		try {
			String query="select gia_dv from tb_hoadondv, tb_dichvu where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tb_hoadondv.tinhtrang=N'0' order by ma_hddv asc";
			ResultSet rs = exQ(query);
				while(rs.next())
				{
					congtien+=Integer.parseInt(rs.getString("gia_dv"));
				}
				tien=String.valueOf(congtien);
				return tien;
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Cộng tiền bị lỗi");
				return null;
			}
	}
	public String TienThanhToan(String maphong)
	{
	    String tien="";
	    int congtien=0;
		try {
			String query="select tb_dichvu.gia_dv from tb_hoadondv,tb_dichvu,tb_bienlai,tb_hdtp,tb_phong where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tb_hoadondv.ma_hddv=tb_bienlai.ma_hddv and tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong='"+maphong+"'";
			ResultSet rs = exQ(query);
				while(rs.next())
				{
					congtien+=Integer.parseInt(rs.getString("gia_dv"));
				}
				tien=String.valueOf(congtien);
				return tien;
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Cộng tiền bị lỗi");
				return null;
			}
	}
	public String ThanhToanPhong(String id)
	{
	    String tien="";
	    int congtien=0;
		try {
			String query="select tb_dichvu.gia_dv from tb_hoadondv,tb_dichvu,tb_bienlai,tb_hdtp,tb_phong where tb_dichvu.ma_dv=tb_hoadondv.ma_dv and tb_hoadondv.ma_hddv=tb_bienlai.ma_hddv and tb_bienlai.ma_hd=tb_hdtp.ma_hd and tb_hdtp.ma_phong=tb_phong.ma_phong and tb_phong.ma_phong='"+id+"'";
			ResultSet rs = exQ(query);
				while(rs.next())
				{
					congtien+=Integer.parseInt(rs.getString("gia_dv"));
				}
				tien=String.valueOf(congtien);
				return tien;
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Cộng tiền bị lỗi");
				return null;
			}
	}
	
	void updateHoaDon(String mot,String ko)
	{
	     try 
	     {  
	     exU("update tb_hoadondv set tinhtrang=N'"+mot+"' where tinhtrang=N'"+ko+"'");					    				
		} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Lỗi khi update HDDV!" + e.toString());
		} 
	}

	public boolean themvaoBl(String ma_hd)
	{
			try{
			exU("insert into tb_bienlai select tb_hdtp.ma_hd, ma_hddv from tb_hoadondv,tb_hdtp where tb_hoadondv.tinhtrang=N'2' and tb_hdtp.ma_hd='"+ma_hd+"'");
			return true;
			}catch(Exception ex)
			{
			JOptionPane.showMessageDialog(null, "Lỗi thêm HDdv,Hd vao bien lai!" + ex.toString());
			}
			return false;
	}
	
	public String getIdHopDong(String maphong)
	{
		String id="báo lỗi";
		try {
			ResultSet rs = exQ("select DISTINCT tb_hdtp.ma_hd from tb_hdtp where ma_phong=N'"+maphong+"'");
				while(rs.next())
				{
					id = rs.getString("ma_hd");;
				}
				return id;
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Báo lỗi: " + ex.toString());
				return null;
			}
	}
	public void xulyHoaDon(String maphong)
	{
	//update cot tinh trang của tb_hoadondv từ 0 thành 2
		updateHoaDon("2","0");
		//lấy những cột tinhtrang=2 + ma_hd( tương ứng phòng được chọn) chèn vào tb_bienlai
		themvaoBl(getIdHopDong(maphong));
		//sau update cot tinhtrang của tb_hoadondv từ 2 thành 1, những cột có có tinhtrang=1 được lưu lại!
		updateHoaDon("1","2");
	}
	
	public void luuId(String idHd,String idTk)
	{
	try{
	//idHd: id hóa đơn
	  exU("insert into id values(N'"+Ai("id","ma_id")+"',N'"+idHd+"',N'"+idTk+"')");
	}catch(Exception ex)
	{
	JOptionPane.showMessageDialog(null,"lỗi lưu id");
	}
	}
	// lấy Id lưu tạm: id user(Id) và id hoadon (Id_1)
	public String getIdLuu(String idlay,String idloai)
	{
		String ma="0";
		try {
			ResultSet rs = exQ("select * from id where "+idloai+"=N'*' order by ma_id asc");
			while(rs.next()) 
				{
				ma=new String();
				ma = rs.getString(idlay);;
				}
			return ma;
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, "lỗi id: " + ex.toString());
				return null;
			}
	}
	
	public String demNgay(String ngayden,String gioden,String ngaydi,String giodi)
	{
		//String dateStart = "15/2/2012 09:29";
		String dateStart=ngayden+" "+gioden;
		//String dateStop = "15/5/2016 10:31";
		String dateStop=ngaydi+" "+giodi;

		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");

		Date d1 = null;
		Date d2 = null;

		try {
		d1 = format.parse(dateStart);
		d2 = format.parse(dateStop);

		//in milliseconds
		long diff = d2.getTime() - d1.getTime();

		//long diffSeconds = diff / 1000 % 60;
//		long diffMinutes = diff / (60 * 1000) % 60;
//		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
		System.out.print(diffDays + " days, ");
		
		return diffDays+"";

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"lỗi đếm ngày: "+e.toString());
		return null;
		}
	}
	public String demGio(String ngayden,String gioden,String ngaydi,String giodi)
	{
		//String dateStart = "15/2/2012 09:29";
		String dateStart=ngayden+" "+gioden;
		//String dateStop = "15/5/2016 10:31";
		String dateStop=ngaydi+" "+giodi;

		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");

		Date d1 = null;
		Date d2 = null;

		try {
		d1 = format.parse(dateStart);
		d2 = format.parse(dateStop);

		//in milliseconds
		long diff = d2.getTime() - d1.getTime();

		//long diffSeconds = diff / 1000 % 60;
//		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
//		long diffDays = diff / (24 * 60 * 60 * 1000);
		//System.out.print(diffDays + " days, ");
		
		//System.out.print(diffHours + " hours, ");
		//System.out.print(diffMinutes + " minutes, ");
//		System.out.print(diffSeconds + " seconds.");
		return diffHours+"";

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"lỗi đếm giờ: "+e.toString());
		return null;
		}
	}
}
