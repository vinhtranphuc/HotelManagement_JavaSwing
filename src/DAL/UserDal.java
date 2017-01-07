package DAL;

public class UserDal extends DataProvider {
	
public String demTaiKhoan(String taikhoan,String matkhau)
{
String query="select * from tb_login where taikhoan=N'"+taikhoan+"' and matkhau=N'"+matkhau+"'";
return demDong(query);
}

public String getId(String taikhoan,String matkhau)
{
String query="select * from tb_login where taikhoan=N'"+taikhoan+"' and matkhau=N'"+matkhau+"'";
String col="ma_tk";
return getCell(query,col);
}

}