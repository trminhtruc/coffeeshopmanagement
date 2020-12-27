package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import entities.NhanVien;

public class GUI_MainQL extends JFrame {

	private JPanel contentPane;
	private JTextField txtXinChao;
	private NhanVien nv;
	
	private void setIconApp() throws IOException{
		Image i = ImageIO.read(getClass().getResource("/img/cafe-icon-2.jpg"));
		setIconImage(i);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_MainQL frame = new GUI_MainQL();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_MainQL() {
		try {
			setIconApp();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		getContentPane().setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 420);
		getContentPane().setLayout(null);
	//	setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setResizable(true);
		setTitle("Chương Trình Quản Lý Bán Café");
		//setSize(1280, 680);
		setSize(1380, 753);
		
		JButton btnQLNV = new JButton("Quản Lý Nhân Viên");
		btnQLNV.setFont(new Font("Verdana", Font.BOLD, 12));
		btnQLNV.setBackground(SystemColor.activeCaption);
		btnQLNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnQLNV.setBounds(10, 165, 203, 44);
		getContentPane().add(btnQLNV);
		
		JButton btnQLAnUong = new JButton("Quản Lý Món Ăn, Thức Uống");
		btnQLAnUong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnQLAnUong.setFont(new Font("Verdana", Font.BOLD, 12));
		btnQLAnUong.setBackground(SystemColor.activeCaption);
		btnQLAnUong.setBounds(10, 290, 203, 53);
		getContentPane().add(btnQLAnUong);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(223, 0, 1139, 705);
		//panel.setSize(800,500);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ BÁN CAFÉ");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNewLabel.setBounds(122, 42, 321, 87);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhóm 16:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(57, 160, 73, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Đoàn Kim Định - 17064051\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(122, 214, 208, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblTrnMinhTrc = new JLabel("Trần Minh Trúc - 17067021");
		lblTrnMinhTrc.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblTrnMinhTrc.setBounds(122, 269, 208, 28);
		panel.add(lblTrnMinhTrc);
		
		JLabel lblChuNhtng = new JLabel("Châu Nhật Đăng - 17061341");
		lblChuNhtng.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblChuNhtng.setBounds(122, 316, 208, 28);
		panel.add(lblChuNhtng);
		
		
		
		JButton btnLogOut = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnLogOut.setFont(new Font("Verdana", Font.BOLD, 14));
		btnLogOut.setBackground(SystemColor.activeCaption);
		btnLogOut.setBounds(10, 633, 203, 33);
		getContentPane().add(btnLogOut);
		
		Border raisedBevel = BorderFactory.createRaisedBevelBorder();
		btnQLNV.setBorder(raisedBevel);
		btnQLAnUong.setBorder(raisedBevel);
		btnLogOut.setBorder(raisedBevel);
		
		JLabel lblXinChao = new JLabel("Xin Chào:");
		lblXinChao.setFont(new Font("Verdana", Font.BOLD, 12));
		lblXinChao.setBounds(10, 61, 73, 14);
		getContentPane().add(lblXinChao);
		
		txtXinChao = new JTextField();
		txtXinChao.setBackground(Color.GRAY);
		txtXinChao.setFont(new Font("Verdana", Font.BOLD, 12));
		txtXinChao.setBounds(10, 91, 172, 27);
		getContentPane().add(txtXinChao);
		txtXinChao.setColumns(10);
		Border matterBorder = new MatteBorder(0,0,0,0,Color.DARK_GRAY);
		txtXinChao.setBorder(matterBorder);
		txtXinChao.setEditable(false);
		
		JButton btnQLHoaDon = new JButton("Quản Lý Hóa Đơn");
		btnQLHoaDon.setFont(new Font("Verdana", Font.BOLD, 12));
		btnQLHoaDon.setBackground(SystemColor.activeCaption);
		btnQLHoaDon.setBounds(10, 417, 203, 44);
		getContentPane().add(btnQLHoaDon);
		btnQLHoaDon.setBorder(raisedBevel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnQLNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				panel.removeAll();
				panel.add(new GUI_QLNhanVien());
				panel.setVisible(true);
			}
		});
		
		btnQLAnUong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				panel.removeAll();
				panel.add(new GUI_QLAnUong());
				panel.setVisible(true);
			}
		});
		btnQLHoaDon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				panel.removeAll();
				panel.add(new GUI_QLHoaDon());
				panel.setVisible(true);
			}
		});
		btnLogOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}
	public void setThongTinNv(NhanVien nv) {
		this.nv = nv;
		txtXinChao.setText(nv.getTenNhanVien());
	}
	
}
