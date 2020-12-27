package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import daos.HoaDonDAO;
import daos.MonAnUongDAO;
import daos.NhanVienDAO;
import entities.MonAnUong;
import entities.NhanVien;
import impls.NhanVienDAOImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GUI_DoiMatKhau extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPassHienTai;
	private JPasswordField txtPassMoi;
	private JPasswordField txtPassXacNhan;
	private String passCu;
	private NhanVien nv;
	private String mkTam;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GUI_DoiMatKhau frame = new GUI_DoiMatKhau();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	}

	/**
	 * Create the frame.
	 */
	public GUI_DoiMatKhau() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 275);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMa = new JLabel("MẬT KHẨU HIỆN TẠI");
		lblMa.setBounds(12, 32, 152, 16);
		contentPane.add(lblMa);

		JLabel lblNewLabel = new JLabel("MẬT KHẨU MỚI");
		lblNewLabel.setBounds(12, 79, 101, 16);
		contentPane.add(lblNewLabel);

		txtPassHienTai = new JPasswordField();
		txtPassHienTai.setBounds(176, 29, 184, 22);
		contentPane.add(txtPassHienTai);

		txtPassMoi = new JPasswordField();
		txtPassMoi.setBounds(176, 76, 184, 22);
		contentPane.add(txtPassMoi);

		txtPassXacNhan = new JPasswordField();
		txtPassXacNhan.setBounds(176, 127, 184, 22);
		contentPane.add(txtPassXacNhan);

		JLabel lblNewLabel_1 = new JLabel("XÁC NHẬN MẬT KHẨU MỚI");
		lblNewLabel_1.setBounds(12, 130, 152, 16);
		contentPane.add(lblNewLabel_1);

		JButton btnDoiMatKhau = new JButton("ĐỔI MẬT KHẨU");
		btnDoiMatKhau.setForeground(Color.WHITE);
		btnDoiMatKhau.setBackground(new Color(0, 102, 204));
		btnDoiMatKhau.setBounds(44, 190, 141, 25);
		contentPane.add(btnDoiMatKhau);

		JButton btnHuy = new JButton("HỦY");
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setBackground(new Color(153, 153, 153));
		btnHuy.setBounds(215, 190, 97, 25);
		contentPane.add(btnHuy);

		JLabel lblMauKhauHienTai = new JLabel("");
		lblMauKhauHienTai.setBounds(186, 49, 174, 16);
		contentPane.add(lblMauKhauHienTai);

		JLabel lblXacNhan = new JLabel("");
		lblXacNhan.setBounds(186, 148, 174, 16);
		contentPane.add(lblXacNhan);

		btnDoiMatKhau.addActionListener(new ActionListener() {

			int tam = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!txtPassHienTai.getText().trim().equals(passCu)) {
					lblMauKhauHienTai.setText("Sai mật khẩu hiện tại");
					tam = 0;
				} else {
					lblMauKhauHienTai.setText("");
					tam = 1;
				}

				if (!txtPassMoi.getText().trim().equals(txtPassXacNhan.getText().trim())) {
					lblXacNhan.setText("Xác nhận không khớp");
					tam = 0;
				} else {
					lblXacNhan.setText("");
					tam = 1;
				}
				if (tam == 0)
					JOptionPane.showMessageDialog(null, "THAY ĐỔI KHÔNG THÀNH CÔNG", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				else {
//					SecurityManager securityManager = System.getSecurityManager();
//					if (securityManager == null) {
//						System.setProperty("java.security.policy", "mypolicy\\policy.policy");
//						System.setSecurityManager(new SecurityManager());
//					}

				
					try {
						NhanVienDAO nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:17676/nhanvienRemote");
						nhanvienDAO.updatePassWord(nhanvienDAO.findId(nv.getMaNhanVien()),txtPassXacNhan.getText() );
//						GUI_NhanVien guinv = new GUI_NhanVien();
//						guinv.setMatKhau(txtPassXacNhan.getText());
						
						setVisible(false);
						System.exit(0);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "CẬP NHẬT MẬT KHẨU THÀNH CÔNG", "SUSSUCESS",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}

	public void setThongTinMatKhau(String matkhau) {
		// TODO Auto-generated method stub
		System.out.println("mau khau " + matkhau);
		this.passCu = matkhau;
	}
	public void setThongTinNhanVien(NhanVien nv) {
		this.nv = nv;
	}

}
