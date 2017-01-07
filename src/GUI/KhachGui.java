package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import BLL.KhachBll;
import BLL.KnpBll;
import BLL.PhongBll;
import DTO.KNP;
import DTO.KhachHang;

import java.awt.Color;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class KhachGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtCmnd;
	private JTextField txtQuoctich;
	private JTextField txtTuoi;
	private JTextField txtLienlac;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel txtlienlac;
	private JTable tblKh;
	private JTable tblPd;
	private JComboBox<String> cmbGioitinh;
	private String chonGioitinh="1";
	private String chonPhong="";
	private String idKh="";
	private JLabel lblNewLabel_5;
	private JComboBox<String> cmbQuoctich;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTable tblTimKh;
	private JScrollPane scrollPane_2;
	private JComboBox<String> cmbPhong;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblKhNam;
	private JLabel lblTongKh;
	private JLabel lblKhNu;
	private JLabel lblNewLabel_10;

	KhachBll kh=new KhachBll();
	KnpBll knp=new KnpBll();
	PhongBll ph=new PhongBll();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachGui frame = new KhachGui();
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
	public KhachGui() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
        Open();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 552);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		panel.setBounds(249, 54, 542, 253);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tblKh = new JTable();
		tblKh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				idKh=tblKh.getModel().getValueAt(tblKh.getSelectedRow(),0).toString();
				txtTen.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),1).toString());
				txtCmnd.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),2).toString());
				txtQuoctich.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),3).toString());
				if(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),4).toString().equals("1")) chonGioitinh="1";
				else chonGioitinh="0";
				txtTuoi.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),5).toString());
				txtLienlac.setText(tblKh.getModel().getValueAt(tblKh.getSelectedRow(),6).toString());
			}
		});
		scrollPane.setViewportView(tblKh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		panel_1.setBounds(10, 54, 229, 462);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtTen = new JTextField();
		txtTen.setBounds(90, 24, 129, 20);
		panel_1.add(txtTen);
		txtTen.setColumns(10);
		
		txtCmnd = new JTextField();
		txtCmnd.setBounds(90, 55, 129, 20);
		panel_1.add(txtCmnd);
		txtCmnd.setColumns(10);
		
		txtQuoctich = new JTextField();
		txtQuoctich.setBounds(90, 86, 129, 20);
		panel_1.add(txtQuoctich);
		txtQuoctich.setColumns(10);
		
		txtTuoi = new JTextField();
		txtTuoi.setBounds(90, 148, 129, 20);
		panel_1.add(txtTuoi);
		txtTuoi.setColumns(10);
		
		txtLienlac = new JTextField();
		txtLienlac.setBounds(90, 179, 129, 20);
		panel_1.add(txtLienlac);
		txtLienlac.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch ph\u00F2ng \u0111\u1EB7t:", TitledBorder.LEADING, TitledBorder.TOP, null,new Color(0, 102, 255)));
		panel_2.setBounds(10, 245, 209, 178);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1);
		
		tblPd = new JTable();
		tblPd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		chonPhong=tblPd.getModel().getValueAt(tblPd.getSelectedRow(),0).toString();
		txtCmnd.setText(chonPhong);
			}
		});
		scrollPane_1.setViewportView(tblPd);
		
		JButton btnSua = new JButton("Sữa");
		btnSua.setIcon(new ImageIcon(KhachGui.class.getResource("/ICONS/Available Updates-25.png")));
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.setBackground(new Color(70, 130, 180));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		SuaKh(e);
			}
		});
		btnSua.setBounds(10, 210, 98, 23);
		panel_1.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(KhachGui.class.getResource("/ICONS/Delete Row-25.png")));
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(70, 130, 180));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		XoaKh(e);
			}
		});
		btnXoa.setBounds(121, 210, 98, 23);
		panel_1.add(btnXoa);
		
		lblNewLabel = new JLabel("Tên KH");
		lblNewLabel.setBounds(10, 27, 70, 14);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("CMND KH\r\n");
		lblNewLabel_1.setBounds(10, 58, 89, 14);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Quốc Tịch KH");
		lblNewLabel_2.setBounds(10, 89, 89, 14);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Giới Tính KH");
		lblNewLabel_3.setBounds(10, 120, 89, 14);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Tuổi KH");
		lblNewLabel_4.setBounds(10, 151, 89, 14);
		panel_1.add(lblNewLabel_4);
		
		txtlienlac = new JLabel("Liên Lạc KH");
		txtlienlac.setBounds(10, 182, 89, 14);
		panel_1.add(txtlienlac);
		
		JButton btnThemKh = new JButton("Thêm Kh vào Phòng");
		btnThemKh.setIcon(new ImageIcon(KhachGui.class.getResource("/ICONS/Add User Group Man Man-25.png")));
		btnThemKh.setForeground(new Color(255, 255, 255));
		btnThemKh.setBackground(new Color(70, 130, 180));
		btnThemKh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		ThemKh(e);
			}
		});
		btnThemKh.setBounds(20, 428, 188, 23);
		panel_1.add(btnThemKh);
		
		cmbGioitinh = new JComboBox<String>();
		cmbGioitinh.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
		if(cmbGioitinh.getSelectedIndex()==0) chonGioitinh="1";
		else if(cmbGioitinh.getSelectedIndex()==1) chonGioitinh="0";
			}
		});
		cmbGioitinh.setModel(new DefaultComboBoxModel<String>(new String[] {"Nam", "Nữ"}));
		cmbGioitinh.setBounds(90, 117, 129, 20);
		panel_1.add(cmbGioitinh);
		
		lblNewLabel_5 = new JLabel("Tìm khách theo quốc tịch:");
		lblNewLabel_5.setIcon(new ImageIcon(KhachGui.class.getResource("/ICONS/Search-15.png")));
		lblNewLabel_5.setForeground(new Color(0, 102, 255));
		lblNewLabel_5.setBounds(280, 321, 165, 14);
		contentPane.add(lblNewLabel_5);
		
		cmbQuoctich = new JComboBox<String>();
		cmbQuoctich.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
	    TimQt(e);
			}
		});
		cmbQuoctich.setBounds(450, 318, 158, 20);
		contentPane.add(cmbQuoctich);
		
		panel_3 = new JPanel();
		panel_3.setBounds(249, 343, 359, 173);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		scrollPane_2 = new JScrollPane();
		panel_3.add(scrollPane_2);
		
		tblTimKh = new JTable();
		scrollPane_2.setViewportView(tblTimKh);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Th\u1ED1ng k\u00EA:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(618, 318, 172, 196);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Tổng số Kh:");
		lblNewLabel_7.setBounds(6, 17, 80, 57);
		panel_4.add(lblNewLabel_7);
		
		lblTongKh = new JLabel("loading...");
		lblTongKh.setBounds(97, 15, 69, 57);
		lblTongKh.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblTongKh);
		
		lblNewLabel_9 = new JLabel("Tổng Kh nam:");
		lblNewLabel_9.setBounds(6, 74, 80, 57);
		panel_4.add(lblNewLabel_9);
		
		lblKhNam = new JLabel("loading...");
		lblKhNam.setBounds(97, 74, 69, 57);
		lblKhNam.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblKhNam);
		
		lblNewLabel_8 = new JLabel("Tổng Kh nữ:");
		lblNewLabel_8.setBounds(6, 131, 80, 57);
		panel_4.add(lblNewLabel_8);
		
		lblKhNu = new JLabel("loading...");
		lblKhNu.setBounds(97, 131, 69, 57);
		lblKhNu.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblKhNu);
		
		cmbPhong = new JComboBox<String>();
		cmbPhong.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		TimKh(e);
			}
		});
		cmbPhong.setBounds(412, 29, 148, 20);
		contentPane.add(cmbPhong);
		
		lblNewLabel_6 = new JLabel("Tìm khách theo phòng:");
		lblNewLabel_6.setIcon(new ImageIcon(KhachGui.class.getResource("/ICONS/Search-15.png")));
		lblNewLabel_6.setForeground(new Color(0, 102, 255));
		lblNewLabel_6.setBounds(251, 32, 151, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_10 = new JLabel("Thống Kê Khách Hàng");
		lblNewLabel_10.setIcon(new ImageIcon(KhachGui.class.getResource("/ICONS/Myspace-48.png")));
		lblNewLabel_10.setForeground(new Color(0, 0, 128));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setBounds(10, 11, 237, 35);
		contentPane.add(lblNewLabel_10);
		
		JButton btnRf = new JButton("refresh");
		btnRf.setForeground(new Color(255, 255, 255));
		btnRf.setBackground(new Color(70, 130, 180));
		btnRf.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		Open();
		}
		});
		btnRf.setBounds(702, 25, 89, 23);
		contentPane.add(btnRf);
	}

protected void TimKh(ItemEvent e) {
if(cmbPhong.getSelectedIndex()==0) tblKh.setModel(kh.getTimKhach(0,""));
else tblKh.setModel(kh.getTimKhach(1,cmbPhong.getSelectedItem().toString()));		
}

protected void TimQt(ItemEvent e) {
tblTimKh.setModel(kh.getQuocTich(cmbQuoctich.getSelectedItem().toString()));
}

protected void ThemKh(ActionEvent e) {
if(chonPhong.equals("")) JOptionPane.showMessageDialog(null, "Chưa chọn phòng!");
else
{	
KhachHang k=new KhachHang("",txtTen.getText(),txtCmnd.getText(),txtQuoctich.getText(),chonGioitinh,txtTuoi.getText(),txtTuoi.getText(),"0");
KNP kn=new KNP();
kn.setMaPh(chonPhong);
if(kh.themKh(k)&&knp.themKnp(kn)&&kh.luuKh()) JOptionPane.showMessageDialog(null, "Đã thêm");
else JOptionPane.showMessageDialog(null, "lỗi!");
Open();
} }

protected void XoaKh(ActionEvent e) {
if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa!","Kiểm tra lại",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
{
if(idKh.equals("")) JOptionPane.showMessageDialog(null, "Chưa chọn KH!");
else 
{
KhachHang k=new KhachHang();
k.setMaKh(idKh);
if(kh.xoaKh(k)) JOptionPane.showMessageDialog(null, "Đã xóa!");
else JOptionPane.showMessageDialog(null, "Lỗi!!!");
Open();
} }	}

protected void SuaKh(ActionEvent e) {
KhachHang k=new KhachHang(idKh,txtTen.getText(),txtCmnd.getText(),txtQuoctich.getText(),chonGioitinh,txtTuoi.getText(),txtLienlac.getText(),"1");
if(kh.suaKh(k)) JOptionPane.showMessageDialog(null, "Đã sửa.");
else JOptionPane.showMessageDialog(null, "Lỗi!!!");
Open();	
}

protected void Open() {
tblKh.setModel(kh.getTimKhach(0,""));
tblPd.setModel(ph.getPhong1(1));
	    
cmbQuoctich.setModel(kh.getQtichCmb());
cmbPhong.setModel(ph.getPhongCmb());
	 
lblTongKh.setText(kh.demKhach(4));
lblKhNam.setText(kh.demKhach(3));
lblKhNu.setText(kh.demKhach(2));

txtTen.setText("");
txtCmnd.setText("");
txtQuoctich.setText("");
txtTuoi.setText("");
txtLienlac.setText("");

chonGioitinh="1";
chonPhong="";
} }
