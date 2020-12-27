package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.transaction.Transactional.TxType;

import daos.HoaDonDAO;
import daos.MonAnUongDAO;
import daos.NhanVienDAO;
import entities.NhanVien;
import impls.NhanVienDAOImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class GUI_DANGNHAP extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JPasswordField txtMatKhau;
	JButton btnNewButton;
	MonAnUongDAO monanDAO;
	HoaDonDAO hoadonDAO;
	NhanVienDAO nhanvienDAO;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecurityManager securityManager = System.getSecurityManager();
					if (securityManager == null) {
						System.setProperty("java.security.policy", "mypolicy\\policy.policy");
						System.setSecurityManager(new SecurityManager());
					}

					GUI_DANGNHAP frame = new GUI_DANGNHAP();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_DANGNHAP() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\WordspaceEE\\Nhom16Client\\src\\main\\java\\img\\cafe-icon-2.jpg"));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("TÊN TÀI KHOẢN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(232, 26, 111, 16);
		contentPane.add(lblNewLabel);

		JLabel lblMtKhu = new JLabel("MẬT KHẨU");
		lblMtKhu.setForeground(Color.WHITE);
		lblMtKhu.setBounds(232, 68, 83, 16);
		contentPane.add(lblMtKhu);

		txtTen = new JTextField();
		txtTen.setBounds(370, 23, 198, 22);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(370, 65, 198, 22);
		contentPane.add(txtMatKhau);
		txtMatKhau.setColumns(10);

		btnNewButton = new JButton("ĐĂNG NHẬP");
		btnNewButton.setBounds(450, 117, 120, 25);
		contentPane.add(btnNewButton);

//		txtTen.setText("nguyenvananh");
//		txtMatKhau.setText("12345");

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src\\main\\java\\img\\dangnhap.jpg"));
		lblNewLabel_1.setBounds(0, 0, 601, 342);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton.setBackground(new Color(0, 102, 204));
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					monanDAO = (MonAnUongDAO) Naming.lookup("rmi://localhost:17676/monanRemote");
					hoadonDAO = (HoaDonDAO) Naming.lookup("rmi://localhost:17676/hoadonRemote");
					nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:17676/nhanvienRemote");
					List<NhanVien> nhanvien = nhanvienDAO.listNhanVien();
					int tam = 0;
					for (NhanVien nhanVien2 : nhanvien) {
						if (nhanVien2.getTaiKhoan().getTenTaiKhoan().equals(txtTen.getText())
								&& nhanVien2.getTaiKhoan().getMatKhau().equals(txtMatKhau.getText())&&nhanVien2.getTrangThai().toUpperCase().equals("ĐANG LÀM VIỆC")) {
							tam = 0;
							if (nhanVien2.getChucVu().equals("NV")) {
								try {
									tam = 1;
									System.out.println("doan k3im7dinh");
									setVisible(false);
									GUI_MainNV guinv = new GUI_MainNV();
									guinv.setThongTinNv(nhanVien2);
									guinv.setThongTinMonAn(monanDAO.listMonAnUong());

								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							if (nhanVien2.getChucVu().equals("QL")) {
								try {
									tam = 1;
									System.out.println("doan kimd4inh");
									setVisible(false);
									GUI_MainQL guinv = new GUI_MainQL();
									guinv.setThongTinNv(nhanVien2);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
					if (tam == 0)
						JOptionPane.showMessageDialog(null, "THÔNG TIN TÊN TÀI KHOẢN HOẶC MẬT KHẨU SAI", "WARNING",
								JOptionPane.WARNING_MESSAGE);

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

}
