package BLL;

import DAL.UserDal;

public class UserBll extends HeThongBll {
	UserDal da=new UserDal();
	
	public String demTaiKhoan(String taikhoan,String matkhau)
	{
	return da.demTaiKhoan(taikhoan, matkhau);
	}
	
	public String getId(String taikhoan,String matkhau)
	{
	return da.getId(taikhoan, matkhau);
	}
}
