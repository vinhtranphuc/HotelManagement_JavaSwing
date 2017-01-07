package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import BLL.BienLaiBll;
import BLL.DichVuBll;
import BLL.HeThongBll;
import BLL.HoaDonBll;
import BLL.KnpBll;

public class BienLaiGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txttenphong;
	private JTextField txtloaiphong;
	private JTextField txtgiaphong;
	private JTextField txtsokhach;
	private JTextField txtngayden;
	private JTextField txtngayht;
	private JTextField txttongngay;
	private JTable tblphong;
	private JTextField txtngaydv;
	private JTextField txtsldv;
	private JTextField txttiendv;
	private JTextField txttongtien;
	String idP="0";
	private JTextField txtnhanvien;
	private JLabel lblngaytt;
	private JTextField txttonggio;
	private float tien;
	private JLabel lbltientt;
	private JTextField txtgioden;
	private JTextField txtgioht;
	BienLaiBll bll=new BienLaiBll();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BienLaiGui frame = new BienLaiGui();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public BienLaiGui() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
		Open();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 526);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(null, "Ch\u1ECDn ph\u00F2ng:", TitledBorder.LEADING, TitledBorder.TOP, null,new Color(0, 102, 255)));
		panel.setBounds(10, 50, 229, 437);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tblphong = new JTable();
		tblphong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		idP=tblphong.getModel().getValueAt(tblphong.getSelectedRow(),0).toString();
			}
		});
		scrollPane.setViewportView(tblphong);	
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin ks:", TitledBorder.LEADING, TitledBorder.TOP, null,new Color(0, 102, 255)));
		panel_1.setBounds(249, 84, 525, 403);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel txtNewLabel_1 = new JLabel("T\u00EAn Ph\u00F2ng:");
		txtNewLabel_1.setBounds(13, 36, 81, 14);
		panel_1.add(txtNewLabel_1);
		
		JLabel txtNewLabel_2 = new JLabel("Ngày Ht:");
		txtNewLabel_2.setBounds(13, 275, 56, 14);
		panel_1.add(txtNewLabel_2);
		
		JLabel txtNewLabel_3 = new JLabel("Ng\u00E0y \u0111\u1EBFn:");
		txtNewLabel_3.setBounds(13, 228, 56, 14);
		panel_1.add(txtNewLabel_3);
		
		JLabel txtNewLabel_4 = new JLabel("Lo\u1EA1i ph\u00F2ng:");
		txtNewLabel_4.setBounds(13, 84, 81, 14);
		panel_1.add(txtNewLabel_4);
		
		JLabel txtNewLabel_5 = new JLabel("Giá phòng/đêm:");
		txtNewLabel_5.setBounds(13, 130, 95, 14);
		panel_1.add(txtNewLabel_5);
		
		JLabel txtNewLabel_6 = new JLabel("S\u1ED1 kh\u00E1ch:");
		txtNewLabel_6.setBounds(13, 181, 81, 14);
		panel_1.add(txtNewLabel_6);
		
		JLabel txtNewLabel = new JLabel("số ngày:");
		txtNewLabel.setBounds(13, 319, 56, 14);
		panel_1.add(txtNewLabel);
		
		txttenphong = new JTextField();
		txttenphong.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txttenphong.setEditable(false);
		txttenphong.setBounds(104, 33, 139, 20);
		panel_1.add(txttenphong);
		txttenphong.setColumns(10);
		
		txtloaiphong = new JTextField();
		txtloaiphong.setEditable(false);
		txtloaiphong.setBounds(104, 81, 138, 20);
		panel_1.add(txtloaiphong);
		txtloaiphong.setColumns(10);
		
		txtgiaphong = new JTextField();
		txtgiaphong.setEditable(false);
		txtgiaphong.setBounds(104, 127, 139, 20);
		panel_1.add(txtgiaphong);
		txtgiaphong.setColumns(10);
		
		txtsokhach = new JTextField();
		txtsokhach.setEditable(false);
		txtsokhach.setBounds(104, 178, 139, 20);
		panel_1.add(txtsokhach);
		txtsokhach.setColumns(10);
		
		txtngayden = new JTextField();
		txtngayden.setEditable(false);
		txtngayden.setBounds(72, 225, 62, 20);
		panel_1.add(txtngayden);
		txtngayden.setColumns(10);
		
		txtngayht = new JTextField();
		txtngayht.setEditable(false);
		txtngayht.setBounds(72, 272, 62, 20);
		panel_1.add(txtngayht);
		txtngayht.setColumns(10);
		
		txttongngay = new JTextField();
		txttongngay.setEditable(false);
		txttongngay.setBounds(72, 316, 62, 20);
		panel_1.add(txttongngay);
		txttongngay.setColumns(10);
		
		JLabel txtNewLabel_8 = new JLabel("Ng\u00E0y \u0111\u1EB7t d\u1ECBch v\u1EE5:");
		txtNewLabel_8.setBounds(253, 36, 95, 14);
		panel_1.add(txtNewLabel_8);
		
		txtngaydv = new JTextField();
		txtngaydv.setEditable(false);
		txtngaydv.setBounds(358, 33, 153, 20);
		panel_1.add(txtngaydv);
		txtngaydv.setColumns(10);
		
		txtsldv = new JTextField();
		txtsldv.setEditable(false);
		txtsldv.setBounds(358, 81, 153, 20);
		panel_1.add(txtsldv);
		txtsldv.setColumns(10);
		
		txttiendv = new JTextField();
		txttiendv.setEditable(false);
		txttiendv.setBounds(358, 127, 153, 20);
		panel_1.add(txttiendv);
		txttiendv.setColumns(10);
		
		JLabel txtNewLabel_9 = new JLabel("Sl d\u1ECBch v\u1EE5:");
		txtNewLabel_9.setBounds(252, 84, 96, 14);
		panel_1.add(txtNewLabel_9);
		
		JLabel txtNewLabel_10 = new JLabel("T\u1ED5ng ti\u1EC1n dv:");
		txtNewLabel_10.setBounds(253, 130, 95, 14);
		panel_1.add(txtNewLabel_10);
		
		JButton btnNewButton_1 = new JButton("Xem thống kê dịch vụ:");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(70, 130, 180));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		XemHoaDon(arg0);
			}
		});
		btnNewButton_1.setBounds(317, 158, 167, 33);
		panel_1.add(btnNewButton_1);
		
		JLabel txtNewLabel_7 = new JLabel("T\u1ED5ng s\u1ED1 ti\u1EC1n thanh to\u00E1n");
		txtNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtNewLabel_7.setBounds(286, 252, 229, 33);
		panel_1.add(txtNewLabel_7);
		
		lblngaytt = new JLabel("");
		lblngaytt.setBounds(368, 242, 143, 14);
		panel_1.add(lblngaytt);
		
		JButton btnTraphong = new JButton("Xu\u1EA5t bi\u00EAn lai/ Tr\u1EA3 ph\u00F2ng");
		btnTraphong.setForeground(new Color(255, 255, 255));
        btnTraphong.setBackground(new Color(70, 130, 180));
		btnTraphong.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		XuatBienLai(arg0);
		}
		});
		btnTraphong.setBounds(307, 344, 177, 33);
		panel_1.add(btnTraphong);
		
		JLabel txtNewLabel_13 = new JLabel("Tổng $ phòng:");
		txtNewLabel_13.setBounds(13, 358, 81, 14);
		panel_1.add(txtNewLabel_13);
		
		txttongtien = new JTextField();
		txttongtien.setEditable(false);
		txttongtien.setBounds(104, 357, 139, 20);
		panel_1.add(txttongtien);
		txttongtien.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ng\u01B0\u1EDDi ti\u1EBFp nh\u1EADn:");
		lblNewLabel.setBounds(253, 213, 113, 14);
		panel_1.add(lblNewLabel);
		
		txtnhanvien = new JTextField();
		txtnhanvien.setEditable(false);
		txtnhanvien.setBounds(371, 211, 140, 20);
		panel_1.add(txtnhanvien);
		txtnhanvien.setColumns(10);
		
		lbltientt = new JLabel("");
		lbltientt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbltientt.setBounds(343, 296, 139, 33);
		panel_1.add(lbltientt);
		
		JLabel lblNewLabel_2 = new JLabel("số giờ:");
		lblNewLabel_2.setBounds(144, 319, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		txttonggio = new JTextField();
		txttonggio.setEditable(false);
		txttonggio.setBounds(187, 316, 56, 20);
		panel_1.add(txttonggio);
		txttonggio.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("  Giờ đến:");
		lblNewLabel_1.setBounds(133, 228, 57, 14);
		panel_1.add(lblNewLabel_1);
		
		txtgioden = new JTextField();
		txtgioden.setEditable(false);
		txtgioden.setBounds(187, 225, 56, 20);
		panel_1.add(txtgioden);
		txtgioden.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("  Giờ Ht:");
		lblNewLabel_3.setBounds(133, 275, 57, 14);
		panel_1.add(lblNewLabel_3);
		
		txtgioht = new JTextField();
		txtgioht.setEditable(false);
		txtgioht.setBounds(187, 272, 56, 20);
		panel_1.add(txtgioht);
		txtgioht.setColumns(10);
		
		JButton btnNewButton = new JButton("Xem th\u1ED1ng k\u00EA:");
		btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtsokhach.setText(bll.demKhachTheoPhong(idP));
				
				txtngayht.setText(bll.ngay);
				txtgiaphong.setText(bll.getGiaPhong(idP));
				txtngayden.setText(bll.getNDP(idP));
				bll=new BienLaiBll();
				txtgioden.setText(bll.getGDP(idP));
				DichVuBll dv=new DichVuBll();
				txtngaydv.setText(dv.getDDV(idP));
				HeThongBll ht=new HeThongBll();
				
				txtnhanvien.setText(ht.getNameUser());
				txttenphong.setText(tblphong.getModel().getValueAt(tblphong.getSelectedRow(),1).toString());
				txtloaiphong.setText(tblphong.getModel().getValueAt(tblphong.getSelectedRow(),2).toString());
				
				txttiendv.setText(bll.ThanhToanPhong(idP));
				dv=new DichVuBll();
				txtsldv.setText(dv.demSLDV(idP));
				lblngaytt.setText(bll.ngay);
				txtgioht.setText(bll.gio);
				
				String songay=bll.demNgay(txtngayden.getText(),txtgioden.getText(),txtngayht.getText(),txtgioht.getText());
				txttongngay.setText(songay);
				bll=new BienLaiBll();
				String sogio=bll.demGio(txtngayden.getText(),txtgioden.getText(),txtngayht.getText(),txtgioht.getText());
			    if(Integer.parseInt(songay)<=1)
			    	{
			    	txttonggio.setText(sogio);
			    	tien=1*Float.parseFloat(txtgiaphong.getText().toString())*30/100;
			    	}
			    else tien=Float.parseFloat(songay)*Float.parseFloat(txtgiaphong.getText().toString());
			    txttongtien.setText(tien+" nghìn đồng");
			    bll=new BienLaiBll();
			    float thanhtoan=tien+Integer.parseInt(bll.TienThanhToan(idP));
			    lbltientt.setText(thanhtoan+" nghìn đồng");
			}
		});
		btnNewButton.setBounds(249, 50, 147, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("THANH TOÁN - TRẢ PHÒNG");
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(10, 11, 294, 35);
		contentPane.add(lblNewLabel_4);
		
		JButton btnRf = new JButton("Refresh");
		btnRf.setForeground(new Color(255, 255, 255));
        btnRf.setBackground(new Color(70, 130, 180));
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRf.setBounds(685, 50, 89, 23);
		contentPane.add(btnRf);
	}
	protected void XuatBienLai(ActionEvent arg0) {
if(bll.demPhong(1).equals("0")) JOptionPane.showMessageDialog(null,"Không có phòng!");
else if(JOptionPane.showConfirmDialog(null, "Bạn có muốn trả phòng "+tblphong.getModel().getValueAt(tblphong.getSelectedRow(),1).toString()+" ","Kiểm tra lại",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
	txttenphong.setText("");
txtloaiphong.setText("");
txtgiaphong.setText("");
txtsokhach.setText("");
txtngayden.setText("");
txtngayht.setText("");
txttongngay.setText("");
txtngaydv.setText("");
txtsldv.setText("");
txttiendv.setText("");
txttongtien.setText("");
txtnhanvien.setText("");
lblngaytt.setText("");
txttonggio.setText("");
lbltientt.setText("");
txtgioden.setText("");
txtgioht.setText("");	

boolean a,b,c,d,e,f;
//xóa khách hàng theo phòng
f=bll.XoaKhach_TraPhong(idP);
//update phòng được chọn tinhtrang từ 1 thành 0
a=bll.capNhatPh(0,idP);
//xóa hóa đơn dv theo phòng được chọn
HoaDonBll hd=new HoaDonBll();
b=hd.xoaHdon(idP);
//xóa biên lai theo phòng được chọn
c=bll.xoaBlTraPhong(idP);
//xóa khách hàng theo phòng được chọn
KnpBll knp=new KnpBll();
//xóa khách nhạn phòng theo phòng được chọn
d=knp.xoaKnpTraPhong(idP);
//xóa hợp đồng thuê phòng theo phòng
e=bll.xoaHdTraPhong(idP);
if(a&&b&&c&&d&&e&&f) JOptionPane.showMessageDialog(null,"Đã in biên lai, tất cả dữ liệu đã xóa!");
tblphong.setModel(bll.getPhong1(1));
	}
	protected void XemHoaDon(ActionEvent arg0) {
		bll.luuId(idP,"*");
		DSDichVuPhongGui dv=new DSDichVuPhongGui();
		dv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dv.setVisible(true);
		dv.setLocationRelativeTo(null);	
	}
	protected void Open() {
		bll=new BienLaiBll();
		tblphong.setModel(bll.getPhong1(1));
	//	tblphong.setModel(adapterMd.loadPhong("1"));	
	}
}
