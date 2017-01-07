package GUI;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import BLL.HoaDonBll;
import BLL.PhongBll;

public class SelectRoom extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String idp="";
	PhongBll bll=new PhongBll();
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectRoom frame = new SelectRoom();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public SelectRoom() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			bll=new PhongBll();
			table.setModel(bll.getPhong1(1));
			//table.setModel(adapterMd.loadPhong("1"));
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 245, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(null, "Ch\u1ECDn ph\u00F2ng thanh to\u00E1n sau:", TitledBorder.LEADING, TitledBorder.TOP, null,new Color(0, 102, 255)));
		panel.setBounds(0, 0, 239, 357);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HoaDonBll hd=new HoaDonBll();
				if(hd.demHoaDon().equals("0")) JOptionPane.showMessageDialog(null,"Không có dịch vụ được đặt!");
				else if(JOptionPane.showConfirmDialog(null, "Bạn có muốn chuyển hóa đơn vào phòng "+table.getModel().getValueAt(table.getSelectedRow(),1).toString()+"","Kiểm tra lại",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				{
				idp=table.getModel().getValueAt(table.getSelectedRow(),0).toString();	
				hd.xulyHoaDon(idp);
				JOptionPane.showMessageDialog(null,"Đã chuyển hóa đơn vào phòng "+table.getModel().getValueAt(table.getSelectedRow(),1).toString()+"");
				}				
			}
		});
		scrollPane.setViewportView(table);
		
		
	}

}
