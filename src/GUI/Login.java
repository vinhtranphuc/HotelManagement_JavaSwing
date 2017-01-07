package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BLL.UserBll;
import javax.swing.ImageIcon;
public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txttk;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblpass;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JPasswordField pfMk;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
		    
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 342);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 11, 465, 291);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txttk = new JTextField();
		txttk.setBounds(158, 90, 219, 20);
		panel.add(txttk);
		txttk.setColumns(10);
		
		lblNewLabel = new JLabel("Tài khoản:");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setBounds(78, 93, 70, 14);
		panel.add(lblNewLabel);
		
		lblpass = new JLabel("Mật khẩu:");
		lblpass.setForeground(new Color(0, 0, 153));
		lblpass.setBounds(78, 124, 70, 14);
		panel.add(lblpass);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setBounds(78, 152, 139, 23);
		panel.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/ICONS/Lock-30.png")));
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(158, 53, 136, 30);
		panel.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("Đóng!");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(70, 130, 180));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(78, 186, 299, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Làm mới");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(70, 130, 180));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		txttk.setText("");pfMk.setText("");
			}
		});
		btnNewButton_2.setBounds(230, 152, 147, 23);
		panel.add(btnNewButton_2);
		
		pfMk = new JPasswordField();
		pfMk.setBounds(158, 121, 219, 20);
		panel.add(pfMk);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			UserBll bll=new UserBll();
			if(txttk.getText().equals("")||String.valueOf(pfMk.getPassword()).equals("")) JOptionPane.showMessageDialog(null,"Nhập đầy đủ!!!");
			else if(bll.demTaiKhoan(txttk.getText(),String.valueOf(pfMk.getPassword())).equals("0"))
			JOptionPane.showMessageDialog(null,"Nhập sai tài khoản hoặc mật khẩu");
			else
			{
				String tk=txttk.getText();
				String mk=String.valueOf(pfMk.getPassword());
				String matk=bll.getId(tk,mk);
				System.out.println(matk);
				bll.luuId("*",matk);
				Main main=new Main();
				main.setVisible(true);
		    	main.setLocationRelativeTo(null);
		    	dispose();
			}
			}
		});
	}
}
