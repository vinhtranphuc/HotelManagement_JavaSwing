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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import BLL.HeThongBll;
import BLL.NhanVienBll;
import DTO.User;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class UserGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtten;
	private JTextField txttaikhoan;
	private JTextField txtmatkhau;
	private JTable table;
	private String chonuser="";
	private JComboBox<String> comboBox;
	private String tennv;
	HeThongBll bll=new HeThongBll();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGui frame = new UserGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public UserGui() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
		Open();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 340);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch ng\u01B0\u1EDDi d\u00F9ng:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 378, 291);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		ChonUser(arg0);
			}
		});
		scrollPane.setViewportView(table);
		
		txtten = new JTextField();
		txtten.setBounds(465, 119, 199, 20);
		getContentPane().add(txtten);
		txtten.setColumns(10);
		
		txttaikhoan = new JTextField();
		txttaikhoan.setBounds(465, 150, 199, 20);
		getContentPane().add(txttaikhoan);
		txttaikhoan.setColumns(10);
		
		txtmatkhau = new JTextField();
		txtmatkhau.setBounds(465, 181, 199, 20);
		getContentPane().add(txtmatkhau);
		txtmatkhau.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tên tk:");
		lblNewLabel.setBounds(398, 150, 57, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u:");
		lblNewLabel_1.setBounds(398, 184, 57, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("H\u1ECD t\u00EAn:");
		lblNewLabel_2.setBounds(398, 119, 57, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Add/Remove User");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(465, 50, 148, 27);
		getContentPane().add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(456, 212, 175, 43);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnthem = new JButton("Add");
		btnthem.setForeground(new Color(255, 255, 255));
		btnthem.setBackground(new Color(70, 130, 180));
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		ThemUser(arg0);
			}
		});
		panel_1.add(btnthem);
		
		JButton btnxoa = new JButton("Remove");
		btnxoa.setForeground(new Color(255, 255, 255));
		btnxoa.setBackground(new Color(70, 130, 180));
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	if(chonuser.equals("")) 
		{
		JOptionPane.showMessageDialog(null,"Chưa chọn User");
		return;
		}
		;
	if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa "+table.getModel().getValueAt(table.getSelectedRow(),1).toString()+"","Kiểm tra lại",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
	{
	User us=new User();
	us.setMaUser(chonuser);
	if(bll.xoaUser(us)) JOptionPane.showMessageDialog(null,"Đã xóa");
	Open();
	}
			}
		});
		panel_1.add(btnxoa);
		
		comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
		if(comboBox.getSelectedIndex()==0) txtten.setText("");
		else if (event.getStateChange() == ItemEvent.SELECTED) {
			          Object item = event.getItem();
			          tennv=item.toString();
			          txtten.setText(tennv);
		}
			}
		});
		comboBox.setBounds(465, 88, 199, 20);
		getContentPane().add(comboBox);
	}

	protected void ChonUser(MouseEvent arg0) {
	chonuser=table.getModel().getValueAt(table.getSelectedRow(),0).toString();		
	}

	protected void ThemUser(ActionEvent arg0) {
		User us=new User();
		NhanVienBll nv=new NhanVienBll();
		us.setMaUser("");
		us.setTkUser(txttaikhoan.getText());
		us.setMkUser(txtmatkhau.getText());
		us.setTenUser(txtten.getText());
		us.setTinhTrang("0");
		if(!tennv.equals("")) us.setMaNv(nv.getIdNv(tennv));
		else us.setMaNv("*");
		bll.themUser(us);
		Open();
	}

	protected void Open() {
		bll=new HeThongBll();
		table.setModel(bll.getTvien());	
		
		NhanVienBll nv=new NhanVienBll();
		comboBox.setModel(nv.getNv());
	}
}
