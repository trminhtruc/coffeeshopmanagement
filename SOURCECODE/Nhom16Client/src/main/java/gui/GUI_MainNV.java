package gui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import entities.MonAnUong;
import entities.NhanVien;

import javax.swing.JTextField;

public class GUI_MainNV extends JFrame implements ActionListener, MouseListener{
	private JTextField txtXinChao;
	private NhanVien nv;
	private List<MonAnUong> monanuong;
	/**
	 * Launch the application.
	 */
	
	private void setIconApp() throws IOException{
		Image i = ImageIO.read(getClass().getResource("/img/cafe-icon-2.jpg"));
		setIconImage(i);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		//		GUI_MainNV frame = new GUI_MainNV();
					
					//frame.add(new GUI_NhanVien());
					//frame.add(new GUI_NhanVien());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_MainNV() throws ClassNotFoundException{
		try {
			setIconApp();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		System.out.println("vao");
		getContentPane().setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 420);
		getContentPane().setLayout(null);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setResizable(true);
		setTitle("Chương Trình Quản Lý Bán Café");
		setSize(1380, 753);
		
		JButton btnXemThongTin = new JButton("Xem th\u00F4ng tin");
		btnXemThongTin.setFont(new Font("Verdana", Font.BOLD, 14));
		btnXemThongTin.setBackground(SystemColor.activeCaption);
		btnXemThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnXemThongTin.setBounds(10, 165, 172, 44);
		getContentPane().add(btnXemThongTin);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setFont(new Font("Verdana", Font.BOLD, 14));
		btnOrder.setBackground(SystemColor.activeCaption);
		btnOrder.setBounds(10, 263, 172, 39);
		getContentPane().add(btnOrder);
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Đoàn Kim Định - 1706......\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(122, 214, 208, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblTrnMinhTrc = new JLabel("Trần Minh Trúc - 17067021");
		lblTrnMinhTrc.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblTrnMinhTrc.setBounds(122, 269, 208, 28);
		panel.add(lblTrnMinhTrc);
		
		JLabel lblChuNhtng = new JLabel("Châu Nhật Đăng - 1706....");
		lblChuNhtng.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblChuNhtng.setBounds(122, 316, 208, 28);
		panel.add(lblChuNhtng);
		
		
		
		JButton btnLogOut = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnLogOut.setFont(new Font("Verdana", Font.BOLD, 14));
		btnLogOut.setBackground(SystemColor.activeCaption);
		btnLogOut.setBounds(10, 633, 172, 33);
		getContentPane().add(btnLogOut);
		
		Border raisedBevel = BorderFactory.createRaisedBevelBorder();
		btnXemThongTin.setBorder(raisedBevel);
		btnOrder.setBorder(raisedBevel);
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
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		panel.setVisible(false);
//		panel.removeAll();
//		panel.add(new GUI_NhanVien());
//		panel.setVisible(true);
		
		btnXemThongTin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				panel.removeAll();
				
				
				GUI_NhanVien nvgui;
				panel.add(nvgui = new GUI_NhanVien());
				nvgui.setThongtin(nv);
				
				panel.setVisible(true);
			}
		});
		
		btnOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				panel.removeAll();
				
				GUI_DatMon guidatmon;
				panel.add(guidatmon = new GUI_DatMon());
				guidatmon.setThongTinMonAnUong(monanuong,nv);
				
				panel.setVisible(true);
			}
		});
		btnLogOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
	//	if(obj == btn)
	}
	public void setThongTinNv(NhanVien nv) {
		this.nv = nv;
		txtXinChao.setText(nv.getTenNhanVien());
	}
	public void setThongTinMonAn(List<MonAnUong> monanuong) {
		this.monanuong = monanuong;
	}
}
