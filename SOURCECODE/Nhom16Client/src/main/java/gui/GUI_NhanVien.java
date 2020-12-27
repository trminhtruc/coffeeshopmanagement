package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import entities.NhanVien;

import javax.swing.JPasswordField;

public class GUI_NhanVien extends JPanel {
	private JTextField txtTaiKhoan;
	private JTextField txtChucVu;
	private JTextField txtSDT;
	private JTextField txtCMND;
	private JTextField txtTenNV;
	private JTextField txtMaNv;
	private JPasswordField passMK;
	private JButton btnDoiMK;
	private NhanVien nv;

	/**
	 * Create the panel.
	 */
	public GUI_NhanVien() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaNV.setBounds(134, 59, 137, 30);
		add(lblMaNV);
		setSize(1142, 712);

		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenNV.setBounds(134, 138, 137, 30);
		add(lblTenNV);

		JLabel lblCmnd = new JLabel("CMND:");
		lblCmnd.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCmnd.setBounds(134, 226, 97, 30);
		add(lblCmnd);

		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSDT.setBounds(134, 329, 146, 30);
		add(lblSDT);

		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChucVu.setBounds(134, 426, 97, 30);
		add(lblChucVu);

		JLabel lblTaiKhoan = new JLabel("Tên tài khoản:");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTaiKhoan.setBounds(134, 527, 155, 30);
		add(lblTaiKhoan);

		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMatKhau.setBounds(134, 617, 97, 30);
		add(lblMatKhau);

		btnDoiMK = new JButton();
		try {
			Image change = ImageIO.read(getClass().getResource("/img/icon-change-pass.png"));
			btnDoiMK.setIcon(new ImageIcon(change));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnDoiMK.setBackground(SystemColor.activeCaption);
		btnDoiMK.setBounds(1065, 610, 42, 37);
		Border raisedBevel = BorderFactory.createRaisedBevelBorder();
		btnDoiMK.setBorder(raisedBevel);
		add(btnDoiMK);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setEditable(false);
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBackground(Color.LIGHT_GRAY);
		txtTaiKhoan.setBounds(371, 534, 664, 20);
		add(txtTaiKhoan);

		txtChucVu = new JTextField();
		txtChucVu.setEditable(false);
		txtChucVu.setColumns(10);
		txtChucVu.setBackground(Color.LIGHT_GRAY);
		txtChucVu.setBounds(371, 433, 664, 20);
		add(txtChucVu);

		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		txtSDT.setBackground(Color.LIGHT_GRAY);
		txtSDT.setBounds(371, 336, 664, 20);
		add(txtSDT);

		txtCMND = new JTextField();
		txtCMND.setEditable(false);
		txtCMND.setColumns(10);
		txtCMND.setBackground(Color.LIGHT_GRAY);
		txtCMND.setBounds(371, 233, 664, 20);
		add(txtCMND);

		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setColumns(10);
		txtTenNV.setBackground(Color.LIGHT_GRAY);
		txtTenNV.setBounds(371, 145, 664, 20);
		add(txtTenNV);

		txtMaNv = new JTextField();
		txtMaNv.setEditable(false);
		txtMaNv.setColumns(10);
		txtMaNv.setBackground(Color.LIGHT_GRAY);
		txtMaNv.setBounds(371, 66, 664, 20);
		add(txtMaNv);

		Border matterBorder = new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY);
		txtTaiKhoan.setBorder(matterBorder);
		txtTaiKhoan.setEditable(false);
		txtSDT.setBorder(matterBorder);
		txtSDT.setEditable(false);
		txtTenNV.setBorder(matterBorder);
		txtTenNV.setEditable(false);
		txtMaNv.setBorder(matterBorder);
		txtMaNv.setEditable(false);
		txtCMND.setBorder(matterBorder);
		txtCMND.setEditable(false);
		txtChucVu.setBorder(matterBorder);
		txtChucVu.setEditable(false);

		passMK = new JPasswordField();
		passMK.setBackground(Color.LIGHT_GRAY);
		passMK.setBounds(371, 624, 664, 20);
		add(passMK);
		passMK.setBorder(matterBorder);
		passMK.setEditable(false);
		setVisible(true);
		btnDoiMK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("doan kim dinh");
				GUI_DoiMatKhau doi = new GUI_DoiMatKhau();
				doi.setThongTinNhanVien(nv);
				doi.setThongTinMatKhau(passMK.getText());

				doi.setVisible(true);
				doi.setLocation(500, 200);
			
			}
		});
	}

	public void setThongtin(NhanVien nv) {
		this.nv = nv;
		txtMaNv.setText(nv.getMaNhanVien());
		txtCMND.setText(nv.getCmnd());
		txtChucVu.setText(nv.getChucVu());
		txtTaiKhoan.setText(nv.getTaiKhoan().getTenTaiKhoan());
		passMK.setText(nv.getTaiKhoan().getMatKhau());
		txtTenNV.setText(nv.getTenNhanVien());
		txtSDT.setText(nv.getSdt());
		NhanVien nv2= new NhanVien();
		nv2.setGioiTinh(true);
		nv2.isGioiTinh();
		System.out.println(txtTenNV.getText() + "doankimfff");
		System.out.println(nv.getMaNhanVien());
		System.out.println("doan kim i");
//		revalidate();
//	    repaint();

	}
}
