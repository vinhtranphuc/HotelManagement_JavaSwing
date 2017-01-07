package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import BLL.HeThongBll;
import DTO.TinNhan;

public class HeThongGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTentk;
	private JTextField txtQuyen;
	private JTextField txtInput;
	private JTextArea txtOutput;
	private JPasswordField pfMkm;
	private JPasswordField pfXacnhan;
	private JPasswordField pfMkcu;
	HeThongBll bll=new HeThongBll();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeThongGui frame = new HeThongGui();
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
	public HeThongGui() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
		Open();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 348);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng tin t\u00E0i kho\u1EA3n:", TitledBorder.LEADING, TitledBorder.TOP, null,new Color(0, 102, 255)));
		panel_2.setBounds(10, 11, 273, 121);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn user:");
		lblNewLabel.setBounds(10, 24, 68, 14);
		panel_2.add(lblNewLabel);
		
		txtTentk = new JTextField();
		txtTentk.setEditable(false);
		txtTentk.setBounds(100, 21, 151, 20);
		panel_2.add(txtTentk);
		txtTentk.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Quy\u1EC1n user:");
		lblNewLabel_1.setBounds(10, 59, 68, 14);
		panel_2.add(lblNewLabel_1);
		
		txtQuyen = new JTextField();
		txtQuyen.setEditable(false);
		txtQuyen.setBounds(100, 56, 151, 20);
		panel_2.add(txtQuyen);
		txtQuyen.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Thông tin User:");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(70, 130, 180));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		InfoUser(e);
			}
		});
		btnNewButton_1.setBounds(81, 87, 129, 23);
		panel_2.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(null, "Đổi mật khẩu:", TitledBorder.LEADING, TitledBorder.TOP, null,new Color(0, 102, 255)));
		panel.setBounds(10, 138, 273, 172);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Đổi mật khẩu!");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		DoiMk(e);
			}
		});
		btnNewButton.setBounds(76, 132, 129, 29);
		panel.add(btnNewButton);
		
		pfMkm = new JPasswordField();
		pfMkm.setBounds(99, 67, 148, 23);
		panel.add(pfMkm);
		
		pfXacnhan = new JPasswordField();
		pfXacnhan.setBounds(99, 101, 148, 20);
		panel.add(pfXacnhan);
		
		pfMkcu = new JPasswordField();
		pfMkcu.setBounds(99, 31, 148, 20);
		panel.add(pfMkcu);
		
		JLabel lblNewLabel_4 = new JLabel("Mk cũ:");
		lblNewLabel_4.setBounds(11, 34, 78, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mk mới:");
		lblNewLabel_5.setBounds(11, 73, 78, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Xác nhân:");
		lblNewLabel_6.setBounds(11, 104, 69, 14);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new TitledBorder(null, "Tin nhắn:", TitledBorder.LEADING, TitledBorder.TOP, null,new Color(0, 102, 255)));
		panel_1.setBounds(293, 13, 519, 297);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtInput = new JTextField();
		txtInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		XuLyTn(e);
			}
		});
		txtInput.setBounds(10, 21, 391, 26);
		panel_1.add(txtInput);
		txtInput.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 499, 228);
		panel_1.add(scrollPane);
		
		txtOutput = new JTextArea();
		txtOutput.setEditable(false);
		scrollPane.setViewportView(txtOutput);
		
		JButton btnXoaTn = new JButton("Xóa TN");
		btnXoaTn.setForeground(new Color(255, 255, 255));
		btnXoaTn.setBackground(new Color(70, 130, 180));
		btnXoaTn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
		XoaTn(ae);
			}
		});
		btnXoaTn.setBounds(411, 23, 98, 23);
		panel_1.add(btnXoaTn);
	}

	protected void XoaTn(ActionEvent ae) {
		String quyen=bll.quyenUser();
		if(!quyen.equals("1")) JOptionPane.showMessageDialog(null,"Bạn không được sử dụng chức năng này!");
		else
		{
		if(bll.xoaTn())
			{
			JOptionPane.showMessageDialog(null,"Đã xóa!");;
			Open();
			}
		}
	}

	protected void XuLyTn(ActionEvent e) {
		String text = txtInput.getText()+"\n";
		TinNhan tn=new TinNhan();
		tn.setMaTn("");
		tn.setNoiDung(text);
		tn.setUser(bll.quyenUser());
		tn.setNgayTn(bll.ngay);
		bll=new HeThongBll();
		bll.themTn(tn);
		String ten="Bạn: ";
		txtOutput.append(ten+text);
        txtOutput.selectAll();
        txtInput.setText("");
	}

	protected void DoiMk(ActionEvent e) {	
		String mkc=bll.getPass();
		  if(!String.valueOf(pfMkcu.getPassword()).equals(mkc)) JOptionPane.showMessageDialog(null, "Nhập sai mật khẩu cũ!");
		  else if(String.valueOf(pfMkm.getPassword()).equals("")||String.valueOf(pfXacnhan.getPassword()).equals(""))
			  JOptionPane.showMessageDialog(null,"Nhập đầy đủ, nhập lại!");
		  else if(!String.valueOf(pfMkm.getPassword()).equals(String.valueOf(pfXacnhan.getPassword())))
		  {
			  JOptionPane.showMessageDialog(null, "Xác nhận sai!");
			  pfMkm.setText("");
			  pfXacnhan.setText("");
		  }
		  else
		  {
		if(bll.DoiMk(String.valueOf(pfMkm.getPassword()))) JOptionPane.showMessageDialog(null, "Đã đổi mật khẩu!");;
		  }
				
	}

	protected void InfoUser(ActionEvent e) {
		String quyen=bll.quyenUser();
		if(!quyen.equals("1")) JOptionPane.showMessageDialog(null,"Bạn không được sử dụng chức năng này!");
		else
		{
		UserGui user=new UserGui();
		user.setVisible(true);
		user.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		user.setLocationRelativeTo(null);
		}			
	}

	protected void Open() {
		bll=new HeThongBll();
		txtOutput.setText("");
		txtOutput.append(bll.getTinNhan());
        txtOutput.selectAll();
        txtTentk.setText(bll.getNameUser());
        String quyen=bll.quyenUser();
        if(quyen.equals("1"))
        	{
        	txtQuyen.setText("Quản trị viên");
        	}
        else txtQuyen.setText("Thành viên");
	}
}
