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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BLL.DichVuBll;
import DTO.DichVu;
import DTO.HoaDon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class DichVuGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenKh;
	private JTable tblDv;
	private JTable tblDvDat;
	private JTable tblTt;
	private JTextField txtTenDv;
	private JTextField txtGiaDv;
	private JComboBox<String> cmbNhanvien;
	private JLabel lblTime;
	private JLabel lblNv;
	private JLabel lblSldv;
	private JLabel lblTongtien;
	private String chonDichvu;
	private String chonDvvD;
	private JTextField txtDcKh;
	private JSpinner spinner;
	
	DichVuBll bll=new DichVuBll();
	DichVu dv=new DichVu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DichVuGui frame = new DichVuGui();
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
	public DichVuGui() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
		Open();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 613);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nh\u1EADp d\u1ECBch v\u1EE5:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		panel.setBounds(10, 459, 232, 116);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn Dv:");
		lblNewLabel.setBounds(10, 24, 90, 28);
		panel.add(lblNewLabel);
		
		txtTenDv = new JTextField();
		txtTenDv.setBounds(110, 24, 112, 28);
		panel.add(txtTenDv);
		txtTenDv.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Giá Dv x 1000đ");
		lblNewLabel_1.setBounds(10, 70, 90, 30);
		panel.add(lblNewLabel_1);
		
		txtGiaDv = new JTextField();
		txtGiaDv.setBounds(110, 71, 112, 28);
		panel.add(txtGiaDv);
		txtGiaDv.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch d\u1ECBch v\u1EE5 v\u1EEBa \u0111\u1EB7t:", TitledBorder.LEADING, TitledBorder.TOP, null,new Color(0, 102, 255)));
		panel_2.setBounds(351, 46, 458, 139);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2);
		
		tblDvDat = new JTable();
		tblDvDat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		chonDvvD=tblDvDat.getModel().getValueAt(tblDvDat.getSelectedRow(),0).toString();
			}
		});
		scrollPane_2.setViewportView(tblDvDat);
		
		JButton btnThemDv = new JButton("Th\u00EAm Dv");
		btnThemDv.setForeground(new Color(255, 255, 255));
		btnThemDv.setBackground(new Color(70, 130, 180));
		btnThemDv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		ThemDv(e);
			}}
		);
		btnThemDv.setBounds(20, 425, 97, 23);
		contentPane.add(btnThemDv);
		
		JButton btnXoaDv = new JButton("X\u00F3a Dv");
		btnXoaDv.setForeground(new Color(255, 255, 255));
		btnXoaDv.setBackground(new Color(70, 130, 180));
		btnXoaDv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		XoaDv(e);
			}
		});
		btnXoaDv.setBounds(129, 425, 100, 23);
		contentPane.add(btnXoaDv);
		
		JList<String> list_1 = new JList<String>();
		list_1.setBounds(369, 221, 1, 1);
		contentPane.add(list_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch d\u1ECBch v\u1EE5:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		panel_1.setBounds(10, 46, 232, 368);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		tblDv = new JTable();
		tblDv.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tblDv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		chonDv(arg0);
			}
		});
		scrollPane.setViewportView(tblDv);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setBorder(new LineBorder(Color.BLUE));
		panel_3.setBounds(268, 228, 541, 301);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("H\u00D3A \u0110\u01A0N D\u1ECACH V\u1EE4");
		label.setBounds(193, 11, 141, 23);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(label);
		
		JLabel lblngb = new JLabel("Ông/bà:");
		lblngb.setBounds(46, 60, 54, 14);
		panel_3.add(lblngb);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(46, 85, 452, 148);
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_4.add(scrollPane_3);
		
		tblTt = new JTable();
		scrollPane_3.setViewportView(tblTt);
		
		JLabel newLabel = new JLabel("Tổng tiền:");
		newLabel.setBounds(303, 269, 74, 23);
		panel_3.add(newLabel);
		
		lblTongtien = new JLabel("100");
		lblTongtien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongtien.setBounds(387, 267, 144, 23);
		panel_3.add(lblTongtien);
		
		JLabel label_5 = new JLabel("Kh\u00E1ch s\u1EA1n VINH TR\u1EA6N");
		label_5.setBounds(209, 32, 131, 14);
		panel_3.add(label_5);
		
		txtTenKh = new JTextField();
		txtTenKh.setBounds(110, 57, 165, 20);
		panel_3.add(txtTenKh);
		txtTenKh.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Th\u1EDDi gian TT:");
		lblNewLabel_2.setBounds(10, 244, 83, 14);
		panel_3.add(lblNewLabel_2);
		
		lblTime = new JLabel("");
		lblTime.setBounds(110, 244, 190, 14);
		panel_3.add(lblTime);
		
		JLabel lblNewLabel_3 = new JLabel("Số lượng dv:");
		lblNewLabel_3.setBounds(303, 244, 74, 14);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Địa chỉ:");
		lblNewLabel_4.setBounds(292, 60, 48, 14);
		panel_3.add(lblNewLabel_4);
		
		txtDcKh = new JTextField();
		txtDcKh.setBounds(350, 57, 148, 20);
		panel_3.add(txtDcKh);
		txtDcKh.setColumns(10);
		
		lblSldv = new JLabel("New label");
		lblSldv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSldv.setBounds(387, 242, 111, 14);
		panel_3.add(lblSldv);
		
		JLabel lblNewLabel_6 = new JLabel("Người lập phiếu:");
		lblNewLabel_6.setBounds(10, 273, 109, 14);
		panel_3.add(lblNewLabel_6);
		
		cmbNhanvien = new JComboBox<String>();
		cmbNhanvien.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(cmbNhanvien.getSelectedIndex()==0) lblNv.setText("");
				else lblNv.setText(cmbNhanvien.getSelectedItem().toString());		
			}
		});
		cmbNhanvien.setBounds(110, 270, 141, 20);
		panel_3.add(cmbNhanvien);
		
		lblNv = new JLabel("");
		lblNv.setBounds(39, 281, 153, 14);
		panel_3.add(lblNv);
		
		JButton btnXemHd = new JButton("Xem hóa đơn:");
		btnXemHd.setBorder(null);
		btnXemHd.setForeground(new Color(255, 255, 255));
		btnXemHd.setBackground(new Color(70, 130, 180));
		btnXemHd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		xemHd(e);
			}
		});
		btnXemHd.setBounds(478, 196, 128, 23);
		contentPane.add(btnXemHd);
		
		JButton btnDatDv = new JButton("\u0110\u1EB7t Dv >>");
		btnDatDv.setForeground(new Color(255, 255, 255));
        btnDatDv.setBackground(new Color(70, 130, 180));
		btnDatDv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		datDv(e);
			}
		});
		btnDatDv.setBounds(252, 106, 89, 23);
		contentPane.add(btnDatDv);
		
		JButton btnXuat = new JButton("Xuất HĐ/thanh toán");
		btnXuat.setBorder(null);
		btnXuat.setForeground(new Color(255, 255, 255));
		btnXuat.setBackground(new Color(70, 130, 180));
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		xuatHd(e);
			}
		});
		btnXuat.setBounds(369, 540, 164, 35);
		contentPane.add(btnXuat);
		
		JButton btnNewButton = new JButton("<< H\u1EE7y dv");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		huyDv(e);
			}
		});
		btnNewButton.setBounds(252, 140, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnthanhtoansau = new JButton("Thanh toán sau");
		btnthanhtoansau.setBorder(null);
		btnthanhtoansau.setForeground(new Color(255, 255, 255));
		btnthanhtoansau.setBackground(new Color(70, 130, 180));
		btnthanhtoansau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		thanhtoansau(arg0);
			}
		});
		btnthanhtoansau.setBounds(553, 540, 164, 35);
		contentPane.add(btnthanhtoansau);
		
		JLabel lblNewLabel_5 = new JLabel("Dịch Vụ");
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 11, 294, 35);
		contentPane.add(lblNewLabel_5);
		
		JButton btnRs = new JButton("Reset");
		btnRs.setBorder(null);
		btnRs.setForeground(new Color(255, 255, 255));
        btnRs.setBackground(new Color(70, 130, 180));
		btnRs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRs.setBounds(712, 12, 97, 23);
		contentPane.add(btnRs);
		
		spinner = new JSpinner();
		spinner.setBorder(null);
		spinner.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinner.setBounds(293, 75, 48, 20);
		contentPane.add(spinner);
		
		JLabel lblNewLabel_7 = new JLabel("SL:");
		lblNewLabel_7.setBounds(252, 78, 37, 14);
		contentPane.add(lblNewLabel_7);
	}
	protected void thanhtoansau(ActionEvent arg0) {
		bll=new DichVuBll();
        tblDvDat.setModel(bll.getHoaDon());
        
        SelectRoom sr=new SelectRoom();
        sr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sr.setVisible(true);
        sr.setLocationRelativeTo(null);
		
	}
	protected void xuatHd(ActionEvent e) {    
		if(txtTenKh.getText().equals("")) 
		{
if(JOptionPane.showConfirmDialog(null, "Chưa nhập tên kh, bạn có muốn in k","Kiểm tra lại",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
			 lblSldv.setText("");
	         lblTongtien.setText("");
	         lblTime.setText("");
	         bll.xoaHdon();
	         bll=new DichVuBll();
	         tblDvDat.setModel(bll.getHoaDon());
	         tblTt.setModel(bll.getThanhToanDv());
	         JOptionPane.showMessageDialog(null, "Đã in!");
			}
		}
		else
		{
            {
	         lblTime.setText("");
	         lblSldv.setText("");
	         lblTongtien.setText("");
	         bll.xoaHdon();
	         tblDvDat.setModel(bll.getHoaDon());
	         tblTt.setModel(bll.getThanhToanDv());
	         JOptionPane.showMessageDialog(null, "Đã in!");
            }
		}
			
	}
	protected void datDv(ActionEvent e) {
		HoaDon hd=new HoaDon();
		hd.setMaDv(chonDichvu);
		hd.setGioHdon(bll.gio);
		hd.setNgayHdon(bll.ngay);
		hd.setTinhTrang("0");
		int value = (Integer) spinner.getValue();
		for(int i=1;i<=value;i++)
		{
		if(!bll.themHdon(hd)) JOptionPane.showMessageDialog(null,"Lỗi!");
		tblDvDat.setModel(bll.getHoaDon());
		}
	}
	protected void xemHd(ActionEvent e) {
		bll=new DichVuBll();
		tblTt.setModel(bll.getThanhToanDv());
		lblTime.setText(bll.gio+" "+bll.ngay);
		lblSldv.setText(bll.demHoaDon());
		lblTongtien.setText(bll.demTienDv());
	}
	protected void huyDv(ActionEvent e) {
		bll=new DichVuBll();
		bll.xoaHdon(chonDvvD);
		tblDvDat.setModel(bll.getHoaDon());
	}
	protected void chonDv(MouseEvent arg0) {
	chonDichvu=tblDv.getModel().getValueAt(tblDv.getSelectedRow(),0).toString();	
	}
	protected void XoaDv(ActionEvent e) {
	int dialogButton = JOptionPane.YES_NO_OPTION;
      JOptionPane.showConfirmDialog (null, "Kiểm tra lại các mặt hàng chưa thanh toán trc khi xóa!","Cẩn thận!",dialogButton);
       if(dialogButton == JOptionPane.YES_OPTION){
    dv=new DichVu();
    dv.setMaDv(chonDichvu);
	Open();
	}
	}
	protected void ThemDv(ActionEvent e) {
	dv=new DichVu();
	dv.setTenDv(txtTenDv.getText());
	dv.setGiaDv(txtGiaDv.getText());
	if(!bll.themDv(dv)) JOptionPane.showMessageDialog(null,"Giá dịch vụ phải nhập số - x 1000đ");
	
	tblDv.setModel(bll.getDv());
	}
	protected void Open() {
		bll=new DichVuBll();
		tblDv.setModel(bll.getDv());
		tblDvDat.setModel(bll.getHoaDon());
	   cmbNhanvien.setModel(bll.getNv());     		
	}
}
