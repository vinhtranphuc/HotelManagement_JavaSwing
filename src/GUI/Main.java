package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import BLL.HandlingBLL;
import BLL.HopDongBll;
import BLL.NhanVienBll;
import DTO.HopDong;
import DTO.KNP;
import DTO.KhachHang;
import javax.swing.ImageIcon;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenKh;
	private JTextField txtCmnd;
	private JTextField txtTuoi;
	private JTextField txtLienlac;
	private JTable tblKh;
	private JTable tblDSPD;
	
	private JComboBox<String> cmbQtich;
	
	private JLabel lblTongPhong;
	private JLabel lblTongPhongDat;
	private JLabel lblTongPhongTrong;
	private JLabel lblTongKhach;
	private JLabel lblTongKhachIn;
	private JLabel lblTongKhachCho;
	private JLabel lblTongNv;
	private JLabel lblNgay;
	
	private JPanel panel_3;
	private JPanel KhuA;
	private JPanel KhuB;
	
	public Main main;
	
	// tọa độ button phòng ở khu A và  khu B, mỗi khu 15 số
	int[] x={10,130,251,372,493,10,130,251,372,493,10,130,251,372,493,10,130,251,372,493,10,130,251,372,493,10,130,251,372,493};
	int[] y={11,11,11,11,11,56,56,56,56,56,101,101,101,101,101,11,11,11,11,11,56,56,56,56,56,101,101,101,101,101};
	
	private JComboBox<String> comboBox;
	String chonGioitinh="1";
	String chonPhong=new String();
	String chonNhanvien=new String();
	String chonKhachhang="";
	int demHangTbKh;
	
	HopDongBll hdong=new HopDongBll();
	NhanVienBll nvien=new NhanVienBll();
	HandlingBLL tgian=new HandlingBLL();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
		Open();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1352, 582);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 57, 901, 90);
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Thông tin khách hàng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtTenKh = new JTextField();
		txtTenKh.setBorder(null);
		txtTenKh.setBounds(76, 28, 205, 20);
		panel.add(txtTenKh);
		txtTenKh.setColumns(10);
		
		txtCmnd = new JTextField();
		txtCmnd.setBorder(null);
		txtCmnd.setBounds(76, 62, 205, 20);
		panel.add(txtCmnd);
		txtCmnd.setColumns(10);
		
		txtTuoi = new JTextField();
		txtTuoi.setBorder(null);
		txtTuoi.setBounds(686, 28, 205, 20);
		panel.add(txtTuoi);
		txtTuoi.setColumns(10);
		
		txtLienlac = new JTextField();
		txtLienlac.setBorder(null);
		txtLienlac.setBounds(686, 62, 205, 20);
		panel.add(txtLienlac);
		txtLienlac.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tên KH");
		lblNewLabel.setBounds(10, 31, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CMND/HC");
		lblNewLabel_1.setBounds(10, 65, 60, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quốc tịch");
		lblNewLabel_2.setBounds(316, 65, 60, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Tuổi");
		lblNewLabel_4.setBounds(621, 31, 52, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Liên lạc:");
		lblNewLabel_5.setBounds(621, 65, 52, 14);
		panel.add(lblNewLabel_5);
		
	    comboBox = new JComboBox<String>();
	    comboBox.setBorder(null);
	    comboBox.setBounds(377, 28, 205, 20);
	    panel.add(comboBox);
	    comboBox.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent e) {
	    ChonGioiTinh(e);
	    	}
	    });
	    comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Nam", "Nữ"}));
	    
	    JLabel lblNewLabel_3 = new JLabel("Giới tính");
	    lblNewLabel_3.setBounds(316, 31, 52, 14);
	    panel.add(lblNewLabel_3);
	    
	    cmbQtich = new JComboBox<String>();
	    cmbQtich.setModel(new DefaultComboBoxModel<String>(new String[] {"Việt Nam\t", "Tàu khựa", "Hàn xẻng"}));
	    cmbQtich.setBounds(377, 62, 205, 20);
	    panel.add(cmbQtich);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 154, 258, 48);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnThemkh = new JButton("Thêm KH");
		btnThemkh.setIcon(new ImageIcon(Main.class.getResource("/ICONS/Add User Group Man Man-25.png")));
		btnThemkh.setBounds(10, 9, 114, 30);
		btnThemkh.setForeground(new Color(255, 255, 255));
		btnThemkh.setBackground(new Color(70, 130, 180));
		panel_1.add(btnThemkh);
		
		JButton btnXoakh = new JButton("Xóa KH");
		btnXoakh.setIcon(new ImageIcon(Main.class.getResource("/ICONS/Delete Row-25.png")));
		btnXoakh.setBounds(134, 9, 114, 30);
		btnXoakh.setForeground(new Color(255, 255, 255));
		btnXoakh.setBackground(new Color(70, 130, 180));
		panel_1.add(btnXoakh);
		btnXoakh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		XoaKhach(e);
			}
		});
		btnThemkh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		ThemKhach(e);
			}
		});
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(921, 213, 418, 331);
		panel_7.setBackground(SystemColor.inactiveCaption);
		panel_7.setBorder(new TitledBorder(null, "Danh sách phòng đã đặt:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		contentPane.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		panel_7.add(scrollPane);
		
		tblDSPD = new JTable();
		tblDSPD.setBorder(null);
		scrollPane.setViewportView(tblDSPD);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 213, 258, 331);
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBorder(new TitledBorder(null, "Danh sách KH chờ:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		panel_2.add(scrollPane_1);
		
		tblKh = new JTable();
		tblKh.setBorder(null);
		tblKh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		ChonKhach(e);
			}
		});
		scrollPane_1.setViewportView(tblKh);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(939, 64, 388, 135);
		panel_4.setBackground(SystemColor.inactiveCaption);
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Thông kê thông tin khách sạn:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Tổng số phòng:");
		lblNewLabel_8.setBounds(6, 16, 188, 14);
		panel_4.add(lblNewLabel_8);
		
	    lblTongPhong = new JLabel("loading...");
	    lblTongPhong.setBounds(194, 16, 188, 14);
	    lblTongPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_4.add(lblTongPhong);
		
		JLabel lblNewLabel_10 = new JLabel("Số phòng đã đặt:");
		lblNewLabel_10.setBounds(6, 30, 188, 14);
		panel_4.add(lblNewLabel_10);
		
		lblTongPhongDat = new JLabel("loading...");
		lblTongPhongDat.setBounds(194, 30, 188, 14);
		lblTongPhongDat.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_4.add(lblTongPhongDat);
		
		JLabel lblNewLabel_11 = new JLabel("Số phòng trống");
		lblNewLabel_11.setBounds(6, 44, 188, 14);
		panel_4.add(lblNewLabel_11);
		
		lblTongPhongTrong = new JLabel("loading...");
		lblTongPhongTrong.setBounds(194, 44, 188, 14);
		lblTongPhongTrong.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_4.add(lblTongPhongTrong);
		
		JLabel lblNewLabel_13 = new JLabel("Tổng số khách hàng:");
		lblNewLabel_13.setBounds(6, 58, 188, 14);
		panel_4.add(lblNewLabel_13);
		
		lblTongKhach = new JLabel("loading...");
		lblTongKhach.setBounds(194, 58, 188, 14);
		lblTongKhach.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_4.add(lblTongKhach);
		
		JLabel lblNewLabel_18 = new JLabel("KH đã check in:");
		lblNewLabel_18.setBounds(6, 72, 188, 14);
		panel_4.add(lblNewLabel_18);
		
		lblTongKhachIn = new JLabel("loading...");
		lblTongKhachIn.setBounds(194, 72, 188, 14);
		lblTongKhachIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_4.add(lblTongKhachIn);
		
		JLabel lblNewLabel_19 = new JLabel("KH đang chờ:");
		lblNewLabel_19.setBounds(6, 86, 188, 14);
		panel_4.add(lblNewLabel_19);
		
		lblTongKhachCho = new JLabel("loading...");
		lblTongKhachCho.setBounds(194, 86, 188, 14);
		lblTongKhachCho.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_4.add(lblTongKhachCho);
		
		JLabel lblNewLabel_22 = new JLabel("Tổng số nhân viên");
		lblNewLabel_22.setBounds(6, 100, 188, 14);
		panel_4.add(lblNewLabel_22);
		
		lblTongNv = new JLabel("loading...");
		lblTongNv.setBounds(194, 100, 188, 14);
		lblTongNv.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_4.add(lblTongNv);
		
		JLabel lblNewLabel_20 = new JLabel("Ngày:");
		lblNewLabel_20.setBounds(6, 114, 188, 14);
		panel_4.add(lblNewLabel_20);
		
		lblNgay = new JLabel("........");
		lblNgay.setBounds(194, 114, 188, 14);
		lblNgay.setBackground(new Color(51, 0, 204));
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblNgay);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(461, 11, 875, 41);
		panel_8.setBorder(null);
		contentPane.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_6 = new JButton("Khách Hàng");
		btnNewButton_6.setIcon(new ImageIcon(Main.class.getResource("/ICONS/Myspace-30 (1).png")));
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_6.setBorder(new LineBorder(Color.WHITE));
		btnNewButton_6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		KhachGui kh=new KhachGui();
		kh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		kh.setVisible(true);
		kh.setLocationRelativeTo(null);
			}
		});
		btnNewButton_6.setForeground(new Color(255, 255, 255));
		btnNewButton_6.setBackground(new Color(70, 130, 180));
		panel_8.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("Phòng");
		btnNewButton_5.setIcon(new ImageIcon(Main.class.getResource("/ICONS/Heating Room Filled-30.png")));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_5.setBorder(new LineBorder(Color.WHITE));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(70, 130, 180));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PhongGui ph=new PhongGui();
				ph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ph.setVisible(true);
				ph.setLocationRelativeTo(null);
			}
		});
		panel_8.add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("Nhân Viên");
		btnNewButton_3.setIcon(new ImageIcon(Main.class.getResource("/ICONS/Manager Filled-30.png")));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBorder(new LineBorder(Color.WHITE));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienGui nv=new NhanVienGui();
				nv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				nv.setVisible(true);
				nv.setLocationRelativeTo(null);
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(70, 130, 180));
		panel_8.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Dịch Vụ");
		btnNewButton_4.setIcon(new ImageIcon(Main.class.getResource("/ICONS/Food Filled-30.png")));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setBorder(new LineBorder(Color.WHITE));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DichVuGui dv=new DichVuGui();
				dv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dv.setVisible(true);
				dv.setLocationRelativeTo(null);
			}
		});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(70, 130, 180));
		panel_8.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("Thống Kê/TP");
		btnNewButton_2.setIcon(new ImageIcon(Main.class.getResource("/ICONS/Hotel Chekc Out Filled-30.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBorder(new LineBorder(Color.WHITE));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BienLaiGui bl=new BienLaiGui();
				bl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				bl.setVisible(true);
				bl.setLocationRelativeTo(null);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(70, 130, 180));
		panel_8.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Hệ Thống");
		btnNewButton_1.setIcon(new ImageIcon(Main.class.getResource("/ICONS/User Shield Filled-30.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBorder(new LineBorder(Color.WHITE));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HeThongGui ht=new HeThongGui();
				ht.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ht.setVisible(true);
				ht.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(70, 130, 180));
		panel_8.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Đăng Xuất");
		btnNewButton.setIcon(new ImageIcon(Main.class.getResource("/ICONS/Exit Filled-30.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBorder(new LineBorder(Color.WHITE));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	 if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất!",null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	 {
		Login lg=new Login();
		lg.setVisible(true);
    	lg.setLocationRelativeTo(null);
    	dispose();
	 }	
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(70, 130, 180));
		panel_8.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Hotel Management");
		lblNewLabel_6.setIcon(new ImageIcon(Main.class.getResource("/ICONS/4 Star Hotel-40.png")));
		lblNewLabel_6.setForeground(new Color(0, 0, 128));
		lblNewLabel_6.setBounds(10, 11, 232, 35);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_6);
		
		JButton btnLammoi = new JButton("Refresh");
		btnLammoi.setIcon(new ImageIcon(Main.class.getResource("/ICONS/Refresh-30.png")));
		btnLammoi.setBorder(null);
		btnLammoi.setForeground(new Color(70, 130, 180));
		btnLammoi.setBackground(new Color(255,255,255));
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		Open();
			}
		});
		btnLammoi.setBounds(792, 158, 119, 44);
		contentPane.add(btnLammoi);
		StatusRoom();
	}
	public void StatusRoom()
	{
		panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBounds(278, 213, 633, 331);
		panel_3.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		KhuA = new JPanel();
		KhuA.setBorder(null);
		KhuA.setBounds(10, 11, 612, 149);
		panel_3.add(KhuA);
		KhuA.setLayout(null);
        
		KhuB = new JPanel();
		KhuB.setBorder(null);
		KhuB.setLayout(null);
		KhuB.setBounds(10, 171, 612, 149);
		panel_3.add(KhuB);
		KhuB.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Sơ đồ phòng (Khu A,B)");
		lblNewLabel_7.setIcon(new ImageIcon(Main.class.getResource("/ICONS/sodophong.png")));
		lblNewLabel_7.setForeground(new Color(51, 51, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7.setBounds(278, 168, 282, 44);
		contentPane.add(lblNewLabel_7);
		
		KhuA();
		KhuB();
	}
	
	public void KhuA()
	{
	for(int id=1;id<=15;id++) addRoomA(id+"");
	}
	
	public void KhuB()
	{
	for(int id=16;id<=30;id++) addRoomB(id+"");
	}
	
	public void addRoomA(final String Id)
	{   
    	KhuA.add(getRoom(Id));
    	KhuA.repaint();
    	KhuA.validate();
	}
	public void addRoomB(final String Id)
	{   
    	KhuB.add(getRoom(Id));
    	KhuB.repaint();
    	KhuB.validate();
	}
	public JButton getRoom(final String Id)
	{
		JButton button=new JButton();
		button =hdong.TTP(hdong.getTenPhong(Id));
		int id=Integer.parseInt(Id);
		int rong=111;
		int cao=38;
		button.setBounds(x[id-1],y[id-1],rong,cao);
		button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			KtraPhong(e,Id);
			}
		});
		return button;
	}
	
	protected void KtraPhong(ActionEvent e,String Id) {
	String ten=((AbstractButton) e.getSource()).getText();
	if(hdong.SttPhong(ten).equals("0")) DatPhong(Id);
	else if(hdong.SttPhong(ten).equals("2")) JOptionPane.showMessageDialog(null, "Phòng đang bảo trì!");
	else JOptionPane.showMessageDialog(null,"Phòng đang được thuê!");
	}
	
	public void ReloadKhuA()
	{  
	KhuA.removeAll();
	KhuA.repaint();
	KhuA.validate();
	KhuA();
	}
	
	public void ReloadKhuB()
	{  
	KhuB.removeAll();
	KhuB.repaint();
	KhuB.validate();
	KhuB();
	}
	
	 private void DatPhong(String Id) {
		 if(tblKh.getRowCount()==0) 
			 {
			 JOptionPane.showMessageDialog(null, "Thêm khách trước khi đặt!");
			 return;
			 }
		 if (JOptionPane.showConfirmDialog(null,"Bạn có muốn đặt phòng này!","Kiểm tra lại",
		 JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)		
		 {
		 try
		 {
		 KNP kn=new KNP();
		 kn.setMaPh(Id);

		 HopDong hd=new HopDong();
		 HandlingBLL hb=new HandlingBLL();
		 hd.setMaHd(Id);
		 hd.setMaNv(hb.getIdLuu("Id_1","Id"));
		 if(hdong.themKnp(kn)&&hdong.themHd(hd)&&hdong.luuKh()&&hdong.capNhatPh(1,Id))
		 JOptionPane.showMessageDialog(null,"Thêm hợp đồng thành công!");
		 else JOptionPane.showMessageDialog(null,"Có lỗi!"); 
		 Open();   	
		 }
		 catch(Exception ex){
		 JOptionPane.showMessageDialog(null,"Lỗi, kiểm tra lại!!!");
		       }
		    }          
		 }
	
protected void BoChon() {
chonKhachhang="";
txtTenKh.setText("");
txtCmnd.setText("");
cmbQtich.setSelectedIndex(0);
txtTuoi.setText("");
txtLienlac.setText("");
}
	
protected void ChonKhach(MouseEvent e) {
chonKhachhang=tblKh.getModel().getValueAt(tblKh.getSelectedRow(),0).toString();		
}
	
protected void ThemKhach(ActionEvent e) {
//kiểm tra điều kiện chèn vào bảng khách hàng, sau xóa textb
if(txtTenKh.getText().toString().equals("")) JOptionPane.showMessageDialog(null, "Kiểm tra lại tên");
else
{
KhachHang kh=new KhachHang("",txtTenKh.getText().toString(),txtCmnd.getText().toString(),cmbQtich.getSelectedItem().toString(),chonGioitinh,txtTuoi.getText().toString(),txtLienlac.getText().toString(),"0");
hdong.themKh(kh);
Open();
}
}

protected void ChonGioiTinh(ItemEvent e) {
if(comboBox.getSelectedIndex()==0) chonGioitinh="1";
else if(comboBox.getSelectedIndex()==1) chonGioitinh="0";
}
	
protected void XoaKhach(ActionEvent e) {
if(chonKhachhang.equals(""))
JOptionPane.showMessageDialog(null,"Chưa chọn khách hàng");
else
{
KhachHang kh=new KhachHang();
kh.setMaKh(chonKhachhang);
if(hdong.xoaKh(kh)) JOptionPane.showMessageDialog(null,"Đã xóa KH có mã: "+kh.getMaKh());
Open();
}	
}
	
protected void Open() { 
ReloadKhuA();
ReloadKhuB();

tblKh.setModel(hdong.getKhachCho());
tblDSPD.setModel(hdong.getHopDong());

lblTongPhong.setText(hdong.demPhong(7));
lblTongPhongTrong.setText(hdong.demPhong(0));
lblTongPhongDat.setText(hdong.demPhong(1));

lblTongKhach.setText(hdong.demKhach(4));
lblTongKhachIn.setText(hdong.demKhach(1));
lblTongKhachCho.setText(hdong.demKhach(0));

lblNgay.setText(hdong.ngay);
lblTongNv.setText(nvien.demNvien(2));

BoChon();
	}
}

