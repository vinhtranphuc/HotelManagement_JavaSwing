package DAL;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
public class DataProvider {
	DateFormat ngay = new SimpleDateFormat("dd-MM-yyyy");
	DateFormat gio= new SimpleDateFormat("HH:mm");
	Calendar cal = Calendar.getInstance();
	public String ngayHt=ngay.format(cal.getTime());
	public String gioHt=gio.format(cal.getTime());
	
    private Connection con=null;
    private Statement stmt = null;
    private PreparedStatement pstmt=null;
    private ResultSet rs = null;
    private String url, serverName="VINH", user="", pass="", dbName="hotel";
    private JButton button;
    public DataProvider() {
    }
 //Khai báo connect
    public DataProvider(String serName, String user, String pass, String dbName) {
        this.serverName = serName;
        this.user = user;
        this.pass = pass;
        this.dbName = dbName;
    }
  // lấy kết nối
    public Connection getCon() throws SQLException {
        url = "jdbc:sqlserver://"+serverName+";databaseName="+dbName+";integratedSecurity=true";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
   // lấy Statement
    public Statement getSta() throws SQLException {
      stmt = getCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return stmt;
    }
   // lấy Rs
    public ResultSet exQ(String query) throws SQLException {
    rs=getSta().executeQuery(query);
    return rs;
     }
  // xoa, dk
    public void PreSta(String query) throws SQLException{
    pstmt=getCon().prepareStatement(query);
    pstmt.executeUpdate();	
    }
    // chèn, sửa, đk
    public void exU(String query) throws SQLException {
    	getSta().executeUpdate(query);
     }
     
    // lấy dữ liệu bảng   
	public DefaultTableModel getTb(String query,String[] tieude,String[] field)
	{
	DefaultTableModel tb=new DefaultTableModel();
	try {
	String _query=query;
	ResultSet rs = exQ(_query);
	ArrayList<String[]> dulieubang = new ArrayList<String[]>();
		while(rs.next())
		{
			String[] dong = new String[tieude.length];
			for(int i=0;i<=tieude.length-1;i++)
			dong[i]=rs.getString(field[i]);
			dulieubang.add(dong);
		}
	String[][] data = new String[dulieubang.size()][tieude.length];
	for(int i=0; i<dulieubang.size(); i++)
	{
		data[i]=dulieubang.get(i);
	}
	tb.setDataVector(data,tieude);
	return tb;
	    }
	catch(Exception ex){
    System.out.println("Loi: "+ex);
    return null;
	}		
	}
	
    // lấy dữ liệu comboBox
	public DefaultComboBoxModel<String> getCmb(String query,String element,String field)
	{ 
	DefaultComboBoxModel<String> cmbModel=new DefaultComboBoxModel<String>();
	cmbModel.addElement(element);
	try {
	exQ(query);
	while(rs.next()){
	cmbModel.addElement(rs.getString(field));
	}
	return cmbModel;
	}
	catch(Exception e)
	{
	System.out.println("Loi: "+e);
	return null;
	}

	}
	// Id tự tăng
	String Ai(String tb,String ma)
	{
	    int id1=0,id2=0;
		String id = null;
		try {
			exQ("select * from "+tb+"");
				while(rs.next())
				{
					id = new String();
					id = rs.getString(ma);
					id1=Integer.parseInt(id);
					if(id1>=id2)
					{
						id2=id1;
					}
				}
				id=String.valueOf(id2+1);
				return id;
			}
			catch(Exception ex){
		    System.out.println("Lỗi tăng Id - DAL/Connect/Id");
			return null;
			}
	}
	// Đếm số dòng 
	public String demDong(String query)
	{
		String soDong="";
		int countRow=0;
		try {
	        exQ(query);
				while(rs.next())
				{
					countRow++;
				}
				soDong=""+countRow;
				return soDong;
			}
			catch(Exception ex){
				System.out.println("Lỗi đếm dòng - DAL/Connect: "+ex);
				return null;
			}
	}
	// Trạng thái phòng (Button)
	public JButton TTP(String btn,String query,String ten_phong,String loai_phong)
	{ 
		button =new JButton();
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setHorizontalAlignment(SwingConstants.LEFT);
        String tenphong="Lỗi";
        String loaiphong="Lỗi";
        String tinhtrang="Lỗi";
		try {
		exQ(query);
		while(rs.next())
			{
		tenphong=rs.getString(ten_phong);
		loaiphong=rs.getString(loai_phong);
		if(btn.equals(tenphong))
					{
		button.setText(tenphong);
	
		if(loaiphong.equals("1")) 
button.setIcon(new ImageIcon(this.getClass().getResource(("/ICONS/Single Bed Filled-30.png"))));
		else if(loaiphong.equals("2"))
button.setIcon(new ImageIcon(this.getClass().getResource(("/ICONS/Two Beds Filled-30.png"))));
		else if(loaiphong.equals("3"))
button.setIcon(new ImageIcon(this.getClass().getResource(("/ICONS/Three Beds Filled-30.png"))));			
		else 
button.setIcon(new ImageIcon(this.getClass().getResource(("/ICONS/VIP-30.png"))));					
		tinhtrang=rs.getString("tinhtrang");
		if(tinhtrang.equals("1"))
				{
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(102, 153, 204));
				}
		else if(tinhtrang.equals("0"))
			{
		button.setForeground(new Color(70, 130, 180));
		button.setBackground(new Color(255, 255, 255));
			}
		else 
		{
		button.setIcon(new ImageIcon(this.getClass().getResource(("/ICONS/keyhole.png"))));
		button.setForeground(new Color(70, 130, 180));
		button.setBackground(new Color(255, 255, 255));
		}
				}
			}
		return button;
		}
		catch(Exception ex){
		System.out.println("fail status room: "+ex);
		return button;
		}
	}
	// lấy ô Table
	public String getCell(String query,String col)
	{
		String cell="null";
		try {
			exQ(""+query+"");
				while(rs.next())
				{
					cell = rs.getString(col);;
				}
				return cell;
			}
			catch(Exception ex){
		System.out.println("Lỗi: "+ex);
				return "Lỗi";
			}
	}
	
    public void setSta(Statement stmt) {
        this.stmt = stmt;
    }
    public void setRs(ResultSet rs) {
        this.rs=rs;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getServerName() {
        return serverName;
    }
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getDbName() {
        return dbName;
    }
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}

