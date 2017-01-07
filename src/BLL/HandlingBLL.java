package BLL;
import DAL.HandlingDal;

public class HandlingBLL {
HandlingDal da=new HandlingDal();
public String ngay=da.Ngay;
public String gio=da.Gio;

public String TienThanhToan(String maphong)
{
return da.TienThanhToan(maphong);
}

public String demTienDv()
{
return da.demTienDv();
}

public void xulyHoaDon(String maphong)
{
da.xulyHoaDon(maphong);
}

public void luuId(String idHd,String idTk)
{
da.luuId(idHd, idTk);
}

public String ThanhToanPhong(String id)
{
return da.ThanhToanPhong(id);
}

public String demNgay(String ngayden,String gioden,String ngaydi,String giodi)
{
return da.demNgay(ngayden, gioden, ngaydi, giodi);
}

public String demGio(String ngayden,String gioden,String ngaydi,String giodi)
{
return da.demGio(ngayden, gioden, ngaydi, giodi);
}

public String getIdLuu(String idlay,String idloai)
{
return da.getIdLuu(idlay,idloai);
}

}
