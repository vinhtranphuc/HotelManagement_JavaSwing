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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import BLL.HopDongBll;
import BLL.PhongBll;
import BLL.HeThongBll;
import DTO.Phong;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
public class PhongGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtGia;
	private JTextField txtNote;
	private JTable tblPhong;
	private JLabel lblTongPhong;
	private JLabel lblPhongTrong;
	private JLabel lblPhongDat;
	private JLabel lblPhongDon;
	private JLabel lblPhongDoi;
	private JLabel lblPhongBa;
	private JLabel lblPhongVip;
	private JLabel lblRoomLock;
	private JComboBox<String> cmbLp;
	private JComboBox<String> comboBox;
    private String chonloaiphong;
    private String id; 
    private JCheckBox ckbBaotri;
    HopDongBll hdong=new HopDongBll();
    PhongBll phong=new PhongBll();
    HeThongBll user=new HeThongBll();
    private JTextField search;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhongGui frame = new PhongGui();
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
	public PhongGui() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
		Open();
			}
		});
		setBounds(100, 100, 763, 523);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Qu\u1EA3n l\u00FD ph\u00F2ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		panel_1.setBounds(153, 53, 594, 430);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Danh s\u00E1ch ph\u00F2ng:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		panel_2.setBounds(10, 130, 574, 289);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		
		tblPhong = new JTable();
		tblPhong.setBorder(null);
		tblPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		idPhong(e);
			}
		});
		scrollPane.setViewportView(tblPhong);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(PhongGui.class.getResource("/ICONS/Available Updates-25.png")));
		btnSua.setBorder(null);
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.setBackground(new Color(70, 130, 180));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		SuaPh(e);
			}
		});
		btnSua.setBounds(10, 96, 146, 23);
		panel_1.add(btnSua);
		
		txtTen = new JTextField();
		txtTen.setBorder(null);
		txtTen.setBounds(87, 26, 174, 20);
		panel_1.add(txtTen);
		txtTen.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn Ph\u00F2ng");
		lblNewLabel.setBounds(10, 29, 67, 14);
		panel_1.add(lblNewLabel);
		
		cmbLp = new JComboBox<String>();
		cmbLp.setBorder(null);
		cmbLp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
	    ChonLPhong(e);
			}
		});
		cmbLp.setModel(new DefaultComboBoxModel<String>(new String[] {"--selected--", "phòng đơn", "phòng đôi", "phòng ba", "phòng Vip"}));
		cmbLp.setBounds(410, 26, 174, 20);
		panel_1.add(cmbLp);
		
		JLabel lblNewLabel_2 = new JLabel("Lo\u1EA1i ph\u00F2ng");
		lblNewLabel_2.setBounds(301, 29, 99, 14);
		panel_1.add(lblNewLabel_2);
		
		txtNote = new JTextField();
		txtNote.setBorder(null);
		txtNote.setBounds(87, 57, 174, 20);
		panel_1.add(txtNote);
		txtNote.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ch\u00FA th\u00EDch");
		lblNewLabel_4.setBounds(10, 60, 67, 14);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T\u00ECm ki\u1EBFm ph\u00F2ng:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel.setBounds(273, 88, 311, 47);
		panel.setBackground(new Color(70, 130, 180));
		panel_1.add(panel);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(6, 16, 108, 24);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		TimPhong(e);
			}
		});
		panel.setLayout(null);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"   Loại phòng:", "Phòng trống", "Phòng đã đặt", "Phòng đơn", "Phòng đôi", "Phòng ba", "Phòng vip", "Phòng bị khóa"}));
		
		search = new JTextField();
		search.setBounds(128, 16, 108, 24);
		search.setUI(new HintTextFieldUI("  Nhập tên phòng:", true));
		panel.add(search);
		search.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(PhongGui.class.getResource("/ICONS/Search-15.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		TimPhong(e);
			}
		});
		btnNewButton.setBounds(246, 17, 55, 23);
		panel.add(btnNewButton);
		
		txtGia = new JTextField();
		txtGia.setBorder(null);
		txtGia.setBounds(410, 57, 174, 20);
		panel_1.add(txtGia);
		txtGia.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Giá Phòng*1000đ");
		lblNewLabel_1.setBounds(301, 60, 99, 14);
		panel_1.add(lblNewLabel_1);
		
		ckbBaotri = new JCheckBox("Khóa phòng");
		ckbBaotri.setForeground(Color.WHITE);
		ckbBaotri.setBackground(new Color(70, 130, 180));
		ckbBaotri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		KhoaPhong(arg0);
			}
		});
		ckbBaotri.setBounds(162, 96, 99, 23);
		panel_1.add(ckbBaotri);
		
		JLabel lblNewLabel_3 = new JLabel("Hệ Thống Phòng");
		lblNewLabel_3.setIcon(new ImageIcon(PhongGui.class.getResource("/ICONS/Structural-50.png")));
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 7, 220, 39);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Th\u1ED1ng k\u00EA ph\u00F2ng:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 102, 255)));
		panel_3.setBounds(10, 52, 133, 431);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Tổng phòng:");
		lblNewLabel_5.setForeground(new Color(70, 130, 180));
		lblNewLabel_5.setBounds(6, 18, 82, 52);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_3.add(lblNewLabel_5);
		
		lblTongPhong = new JLabel("");
		lblTongPhong.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTongPhong.setBounds(88, 18, 37, 52);
		panel_3.add(lblTongPhong);
		
		JLabel lblNewLabel_12 = new JLabel("Phòng trống:\r\n");
		lblNewLabel_12.setForeground(new Color(70, 130, 180));
		lblNewLabel_12.setBounds(6, 71, 82, 52);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_12);
		
		lblPhongTrong = new JLabel("");
		lblPhongTrong.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPhongTrong.setBounds(88, 71, 37, 52);
		panel_3.add(lblPhongTrong);
		
		JLabel lblNewLabel_17 = new JLabel("Phòng đã đặt:");
		lblNewLabel_17.setForeground(new Color(70, 130, 180));
		lblNewLabel_17.setBounds(6, 123, 82, 52);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_17);
		
		lblPhongDat = new JLabel("");
		lblPhongDat.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPhongDat.setBounds(88, 123, 37, 52);
		panel_3.add(lblPhongDat);
		
		JLabel lblNewLabel_15 = new JLabel("Phòng đơn:");
		lblNewLabel_15.setForeground(new Color(70, 130, 180));
		lblNewLabel_15.setBounds(6, 175, 82, 52);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_15);
		
		lblPhongDon = new JLabel("");
		lblPhongDon.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPhongDon.setBounds(88, 175, 37, 52);
		panel_3.add(lblPhongDon);
		
		JLabel lblNewLabel_14 = new JLabel("Phòng đôi:");
		lblNewLabel_14.setForeground(new Color(70, 130, 180));
		lblNewLabel_14.setBounds(6, 227, 82, 52);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_14);
		
		lblPhongDoi = new JLabel("");
		lblPhongDoi.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPhongDoi.setBounds(88, 227, 37, 52);
		panel_3.add(lblPhongDoi);
		
		JLabel lblNewLabel_10 = new JLabel("Phòng 3:");
		lblNewLabel_10.setForeground(new Color(70, 130, 180));
		lblNewLabel_10.setBounds(6, 279, 82, 52);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_10);
		
		lblPhongBa = new JLabel("");
		lblPhongBa.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPhongBa.setBounds(88, 279, 37, 52);
		panel_3.add(lblPhongBa);
		
		JLabel lblNewLabel_7 = new JLabel("Phòng Vip:\r\n");
		lblNewLabel_7.setForeground(new Color(70, 130, 180));
		lblNewLabel_7.setBounds(6, 331, 82, 52);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_7);
		
		lblPhongVip = new JLabel("");
		lblPhongVip.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPhongVip.setBounds(88, 331, 37, 52);
		panel_3.add(lblPhongVip);
		
		JLabel lblNewLabel_8 = new JLabel("Phòng khóa:");
		lblNewLabel_8.setForeground(new Color(70, 130, 180));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(6, 379, 82, 52);
		panel_3.add(lblNewLabel_8);
		
		lblRoomLock = new JLabel("");
		lblRoomLock.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRoomLock.setBounds(88, 379, 37, 52);
		panel_3.add(lblRoomLock);
		
		JButton btnRf = new JButton("Refresh");
		btnRf.setForeground(new Color(255, 255, 255));
		btnRf.setBackground(new Color(70, 130, 180));
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		Open();
			}
		});
		btnRf.setBounds(658, 19, 89, 23);
		contentPane.add(btnRf);
	}
	
	protected void TimPhong(ActionEvent e) {
	tblPhong.setModel(phong.getPhong(search.getText()));
	}
	protected void KhoaPhong(MouseEvent arg0) {
	if(id.equals("")&&ckbBaotri.isSelected()) 
	{
	JOptionPane.showMessageDialog(null,"Chưa chọn phòng!");
	return;
	}
	if(phong.getStt(id).equals("1"))JOptionPane.showMessageDialog(null,"Phòng đang được đặt, không thể khóa!");
	else if(phong.getStt(id).equals("0"))
		{
	if((JOptionPane.showConfirmDialog(null,"Bạn có muốn khóa phòng này?!","Khóa phòng!",
	JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION))
	if(phong.capNhatPh(2,id)) 
		{
		JOptionPane.showMessageDialog(null,"Đã khóa phòng "+hdong.getTenPhong(id));
		}
	}
	else if(phong.getStt(id).equals("2"))
		{
	if((JOptionPane.showConfirmDialog(null,"Bạn có muốn mở khóa phòng này?!","Mở khóa phòng!",
	JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION))
		if(phong.capNhatPh(0,id)) 
		{
		HopDongBll hdong=new HopDongBll();
		JOptionPane.showMessageDialog(null,"Đã mở khóa phòng "+hdong.getTenPhong(id));
		}
	}
	Open();
	}
	protected void ChonLPhong(ItemEvent e) {
		if(cmbLp.getSelectedItem().toString().equals("phòng đơn")) chonloaiphong="1";
		else if(cmbLp.getSelectedItem().toString().equals("phòng đôi")) chonloaiphong="2";
		else if(cmbLp.getSelectedItem().toString().equals("phòng ba")) chonloaiphong="3";
		else if(cmbLp.getSelectedItem().toString().equals("phòng Vip")) chonloaiphong="4";	
	}
	protected void TimPhong(ItemEvent e) {
		//load tất cả
		if(comboBox.getSelectedIndex()==0)
			tblPhong.setModel(phong.timPhong(7));
		//load phong tình trạng =0
		else if(comboBox.getSelectedIndex()==1)
			tblPhong.setModel(phong.timPhong(0));
		//load phòng tìnhtrang=1
		else if(comboBox.getSelectedIndex()==2)
			tblPhong.setModel(phong.timPhong(1));
		//load phòng loại phòng = phòng đơn
		else if(comboBox.getSelectedIndex()==3)
			tblPhong.setModel(phong.timPhong(2));
		//load phòng loại phòng = phòng đôi
		else if(comboBox.getSelectedIndex()==4)
			tblPhong.setModel(phong.timPhong(3));
		//load phòng loại phòng = phòng ba
		else if(comboBox.getSelectedIndex()==5)
			tblPhong.setModel(phong.timPhong(4));
		//load phòng loai phòng = phòng vip
		else if(comboBox.getSelectedIndex()==6)
			tblPhong.setModel(phong.timPhong(5));
		else if(comboBox.getSelectedIndex()==7) 
			tblPhong.setModel(phong.timPhong(6));
	}
	protected void idPhong(MouseEvent e) {
	id=tblPhong.getModel().getValueAt(tblPhong.getSelectedRow(),0).toString();
	ckbBaotri.setSelected(false);
	if(phong.getStt(id).equals("2")) ckbBaotri.setSelected(true);
	
	txtTen.setText(tblPhong.getModel().getValueAt(tblPhong.getSelectedRow(),1).toString());
	txtGia.setText(tblPhong.getModel().getValueAt(tblPhong.getSelectedRow(),3).toString());
	txtNote.setText(tblPhong.getModel().getValueAt(tblPhong.getSelectedRow(),5).toString());
	
	//cmb loại phòng
	for(int i=0;i<=5;i++)
	{
	if(tblPhong.getModel().getValueAt(tblPhong.getSelectedRow(),2).toString().equals(cmbLp.getItemAt(i))) 
	cmbLp.setSelectedIndex(i);
	}
	}
	
	protected void SuaPh(ActionEvent e) {
	String quyen=user.quyenUser();
	if(!quyen.equals("1")) 
	{
	JOptionPane.showMessageDialog(null,"Bạn không được sử dụng chức năng này!");
	return;
	}
	if(id.equals(""))
		{
		JOptionPane.showMessageDialog(null,"Chưa chọn phòng!");
		return;
		}
	if(phong.getStt(id).equals("1"))
	if((JOptionPane.showConfirmDialog(null,"Phòng đang có khách thuê, bạn có muốn sửa!","Sửa phòng?",
	JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)) return;
	Sua();
	}
	protected void Sua()
	{
		if(chonloaiphong.equals("")) 
		{
			JOptionPane.showMessageDialog(null,"Chưa chọn loại phòng!");
			return;
		}
	if((JOptionPane.showConfirmDialog(null,"Bạn có muốn sửa phòng "+hdong.getTenPhong(id),"Sửa phòng?",
	JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)) return;
		if(txtTen.getText().toString().equals("")||chonloaiphong.equals("--selected--")||txtGia.getText().toString().equals(""))
		{
		JOptionPane.showMessageDialog(null,"Kiểm tra lại!");
		 }
		else 
		  {
		Phong pdto=new Phong();
		pdto.setMaPh(this.id);
		pdto.setTenPh(txtTen.getText());
		pdto.setLoaiPh(chonloaiphong);
		pdto.setGiaPh(txtGia.getText());
		pdto.setChuThich(txtNote.getText());
		pdto.setTinhTrang(phong.getStt(id));
		if(phong.suaPh(pdto)) JOptionPane.showMessageDialog(null,"Đã sửa");;
		  }
		Open();
	}
	protected void Open() {
		
		tblPhong.setModel(phong.timPhong(7));
		lblTongPhong.setText(phong.demPhong(7));
		lblPhongTrong.setText(phong.demPhong(0));
		lblPhongDat.setText(phong.demPhong(1));
		lblPhongDon.setText(phong.demPhong(2));
		lblPhongDoi.setText(phong.demPhong(3));
		lblPhongBa.setText(phong.demPhong(4));
		lblPhongVip.setText(phong.demPhong(5));
		lblRoomLock.setText(phong.demPhong(6));
		
		chonloaiphong="";
		id="";
		ckbBaotri.setSelected(false);
		cmbLp.setSelectedIndex(0);
	
	}
}
