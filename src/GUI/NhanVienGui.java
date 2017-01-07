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
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import BLL.NhanVienBll;
import DTO.NhanVien;
import javax.swing.border.LineBorder;

public class NhanVienGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenNv;
	private JTextField txtLuong;
	private JTextField txtNamsinh;
	private JLabel lblTongNv;
	private JLabel lblTogNam;
	private JLabel lblTogNu;
	private JTable tblNv;
	private JTextField txtChuthich;
	private JComboBox<String> cmbGioitinh;
	private JComboBox<String> cmbChucVu;
	String IdNv="";
	String chonGioitinh=new String();
	NhanVienBll bl=new NhanVienBll();
	NhanVien nv=new NhanVien();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienGui frame = new NhanVienGui();
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
	public NhanVienGui() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
		Open();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 456);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch Nv:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		panel.setBounds(260, 45, 549, 373);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tblNv = new JTable();
		tblNv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		ClickNv(arg0);
			}
		});
		scrollPane.setViewportView(tblNv);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Th\u1ED1ng k\u00EA NV:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		panel_1.setBounds(10, 284, 240, 134);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("T\u1ED5ng Nv:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(41, 18, 94, 39);
		panel_1.add(lblNewLabel_7);
		
		lblTongNv = new JLabel("loading...");
		lblTongNv.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTongNv.setBounds(145, 16, 85, 39);
		panel_1.add(lblTongNv);
		
		JLabel lblNewLabel_10 = new JLabel("T\u1ED5ng nam:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(41, 57, 94, 39);
		panel_1.add(lblNewLabel_10);
		
		lblTogNam = new JLabel("loading...");
		lblTogNam.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTogNam.setBounds(145, 55, 85, 39);
		panel_1.add(lblTogNam);
		
		JLabel lblNewLabel_6 = new JLabel("T\u1ED5ng n\u1EEF:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(41, 96, 94, 39);
		panel_1.add(lblNewLabel_6);
		
		lblTogNu = new JLabel("loading...");
		lblTogNu.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTogNu.setBounds(145, 94, 85, 39);
		panel_1.add(lblTogNu);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Th\u00F4ng tin nh\u00E2n vi\u00EAn:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		panel_2.setBounds(10, 11, 240, 262);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn NV");
		lblNewLabel.setBounds(10, 36, 65, 14);
		panel_2.add(lblNewLabel);
		
		txtTenNv = new JTextField();
		txtTenNv.setBounds(85, 33, 146, 20);
		panel_2.add(txtTenNv);
		txtTenNv.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ch\u1EE9c v\u1EE5");
		lblNewLabel_1.setBounds(10, 67, 65, 14);
		panel_2.add(lblNewLabel_1);
		
		txtLuong = new JTextField();
		txtLuong.setBounds(85, 95, 146, 20);
		panel_2.add(txtLuong);
		txtLuong.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("L\u01B0\u01A1ng");
		lblNewLabel_2.setBounds(10, 98, 65, 14);
		panel_2.add(lblNewLabel_2);
		
		txtNamsinh = new JTextField();
		txtNamsinh.setBounds(85, 126, 146, 20);
		panel_2.add(txtNamsinh);
		txtNamsinh.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("N\u0103m sinh");
		lblNewLabel_3.setBounds(10, 129, 65, 14);
		panel_2.add(lblNewLabel_3);
		
		cmbGioitinh = new JComboBox<String>();
		cmbGioitinh.setBounds(85, 157, 145, 20);
		panel_2.add(cmbGioitinh);
		cmbGioitinh.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
		Sex(arg0);
			}
		});
		cmbGioitinh.setModel(new DefaultComboBoxModel<String>(new String[] {"--Chọn--", "Nam", "Nữ"}));
		
		JLabel lblNewLabel_4 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_4.setBounds(10, 160, 65, 14);
		panel_2.add(lblNewLabel_4);
		
		txtChuthich = new JTextField();
		txtChuthich.setBounds(85, 188, 146, 20);
		panel_2.add(txtChuthich);
		txtChuthich.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Ch\u00FA th\u00EDch");
		lblNewLabel_5.setBounds(10, 191, 65, 14);
		panel_2.add(lblNewLabel_5);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.setBorder(new LineBorder(Color.WHITE));
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(70, 130, 180));
		btnXoa.setBounds(85, 219, 70, 23);
		panel_2.add(btnXoa);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setBorder(new LineBorder(Color.WHITE));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(70, 130, 180));
		btnThem.setBounds(10, 219, 70, 23);
		panel_2.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBorder(new LineBorder(Color.WHITE));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
		SuaNv(ae);
			}
		});
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(70, 130, 180));
		btnSua.setBounds(161, 219, 70, 23);
		panel_2.add(btnSua);
		
		cmbChucVu = new JComboBox<String>();
		cmbChucVu.setModel(new DefaultComboBoxModel<String>(new String[] {"--chức vụ--", "Lễ tân", "Kế toán", "Sales", "Bảo vệ", "Buồng phòng", "Tài xế"}));
		cmbChucVu.setBounds(85, 64, 145, 20);
		panel_2.add(cmbChucVu);
		
		JLabel lblNewLabel_8 = new JLabel("Quản Lý Nhân Viên");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setForeground(new Color(0, 0, 128));
		lblNewLabel_8.setBounds(260, 11, 178, 35);
		contentPane.add(lblNewLabel_8);
		
		JButton btnRs = new JButton("Reset");
		btnRs.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnRs.setForeground(new Color(255, 255, 255));
		btnRs.setBackground(new Color(70, 130, 180));
		btnRs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		Open();
			}
		});
		btnRs.setBounds(720, 19, 89, 23);
		contentPane.add(btnRs);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		ThemNv(e);
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		Xoa(e);
			}
		});
	}
  protected void SuaNv(ActionEvent ae) {
	 nv=new NhanVien();
	 nv.setMaNv(IdNv);
	 nv.setTenNv(txtTenNv.getText());
	 nv.setChucVu(cmbChucVu.getSelectedItem().toString());
	 nv.setLuong(txtLuong.getText());
	 nv.setNamSinh(txtNamsinh.getText());
	 nv.setGioiTinh(chonGioitinh);
	 nv.setChuThich(txtChuthich.getText());
	 if(bl.suaNv(nv)) JOptionPane.showMessageDialog(null, "Đã sửa");
	 
	 Open();
	}
  
	protected void Xoa(ActionEvent e) {
		if(IdNv.equals(""))
		{
  JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên");
		}
		else 
		{
	nv.setMaNv(IdNv);
	if(bl.xoaNv(nv)) JOptionPane.showMessageDialog(null, "Đã xóa"); 
	Open();
		}
	}
	protected void ThemNv(ActionEvent e) {
	if(txtTenNv.getText().equals("")) JOptionPane.showMessageDialog(null, "Kiểm tra lại tên");
	else if(chonGioitinh.equals("1")||chonGioitinh.equals("0")) 
	{
	nv=new NhanVien("",txtTenNv.getText(),cmbChucVu.getSelectedItem().toString(),txtLuong.getText(),txtNamsinh.getText(),chonGioitinh,txtChuthich.getText());
	if(bl.themNv(nv)) JOptionPane.showMessageDialog(null, "Đã thêm!"); 
	Open();		
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Chưa chọn giới tính");
		}
			
	}
	protected void Sex(ItemEvent arg0) {
		if(cmbGioitinh.getSelectedIndex()==0) chonGioitinh="chưa rõ";
		else if(cmbGioitinh.getSelectedIndex()==1) chonGioitinh="1";
		else if(cmbGioitinh.getSelectedIndex()==2) chonGioitinh="0";
	
	}
	protected void ClickNv(MouseEvent arg0) {
		IdNv=tblNv.getModel().getValueAt(tblNv.getSelectedRow(),0).toString();
		txtTenNv.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),1).toString());
		//chức vụ
		for(int i=0;i<=6;i++)
		{
		if(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),2).toString().equals(cmbChucVu.getItemAt(i))) 
		cmbChucVu.setSelectedIndex(i);
		}
		//giới tính 
		for(int i=0;i<=2;i++)
		{
		if(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),5).toString().equals(cmbGioitinh.getItemAt(i))) 
		cmbGioitinh.setSelectedIndex(i);
		}
		txtLuong.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),3).toString());
		txtNamsinh.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),4).toString());
		txtChuthich.setText(tblNv.getModel().getValueAt(tblNv.getSelectedRow(),6).toString());
		
	}
	protected void Open() {
		bl=new NhanVienBll();
		tblNv.setModel(bl.getNhanVien());
		
	    lblTongNv.setText(bl.demNvien(2));
	    lblTogNam.setText(bl.demNvien(1));
	    lblTogNu.setText(bl.demNvien(0));
	    
	    txtTenNv.setText("");
	    cmbChucVu.setSelectedIndex(0);
	    cmbGioitinh.setSelectedIndex(0);
	    txtLuong.setText("");
	    txtNamsinh.setText("");
	    txtChuthich.setText("");
		//tblNv.setModel(bl);
//		nv=new ModelHotel();
//		tblNv.setModel(nv.loadAllNv());
//		
//	    lblTongNv.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNv));
//	    lblTogNam.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNvNam));
//	    lblTogNu.setText(adapterCtr.demDong("tb_nhanvien",adapterCtr.demNvNu));
	}
}
