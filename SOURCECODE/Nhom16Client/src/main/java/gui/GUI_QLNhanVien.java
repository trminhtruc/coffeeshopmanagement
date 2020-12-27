package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import daos.HoaDonDAO;
import daos.MonAnUongDAO;
import daos.NhanVienDAO;
import daos.TaiKhoanDAO;
import entities.NhanVien;
import entities.TaiKhoan;

public class GUI_QLNhanVien extends JPanel {
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtTaiKhoan;
	private JTextField txtCmnd;
	private JTextField txtSDT;
	private JPasswordField passMK;
	private JTextField txtTimKiem;
	private JComboBox<String> cbbTrangThai;
	private JComboBox<String> cbbChucVu;
	private JCheckBox cbGioiTinh;
	private JTable table;
	private DefaultTableModel model;
	NhanVienDAO nhanvienDAO;
	TaiKhoanDAO taikhoanDAO;
	MonAnUongDAO monanDAO;
	HoaDonDAO hoadonDAO;

	/**
	 * Create the panel.
	 */
	public GUI_QLNhanVien() {

		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "mypolicy\\policy.policy");
			System.setSecurityManager(new SecurityManager());
		}

		try {
			monanDAO = (MonAnUongDAO) Naming.lookup("rmi://localhost:17676/monanRemote");
			hoadonDAO = (HoaDonDAO) Naming.lookup("rmi://localhost:17676/hoadonRemote");
			nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:17676/nhanvienRemote");
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

		setBackground(UIManager.getColor("CheckBox.light"));
		setSize(1142, 705);
		setLayout(null);

		Border raisedBevel = BorderFactory.createRaisedBevelBorder();
		Border loweredBevel = BorderFactory.createLoweredBevelBorder();
		Border compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
		Border blueBorder = BorderFactory.createLineBorder(Color.BLUE);
		Border matterBorder = new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBox.light"));
		panel.setBounds(0, 0, 1142, 231);
		add(panel);
		panel.setLayout(null);
		Border titleBorder = BorderFactory.createTitledBorder(blueBorder, "Thông Tin Nhân Viên");
		panel.setBorder(titleBorder);

		JLabel lblMaNV = new JLabel("Mã Nhân Viên:");
		lblMaNV.setFont(new Font("Verdana", Font.BOLD, 12));
		lblMaNV.setBounds(24, 43, 106, 22);
		panel.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Verdana", Font.BOLD, 12));
		txtMaNV.setBackground(UIManager.getColor("CheckBox.light"));
		txtMaNV.setBounds(157, 46, 174, 20);
		panel.add(txtMaNV);
		txtMaNV.setColumns(10);
		txtMaNV.setBorder(matterBorder);
		txtMaNV.setEditable(false);

		JLabel lblTenNV = new JLabel("Tên Nhân Viên:");
		lblTenNV.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTenNV.setBounds(388, 43, 106, 22);
		panel.add(lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Verdana", Font.BOLD, 12));
		txtTenNV.setColumns(10);
		txtTenNV.setBackground(UIManager.getColor("CheckBox.light"));
		txtTenNV.setBounds(514, 46, 182, 20);
		panel.add(txtTenNV);
		txtTenNV.setBorder(matterBorder);
		txtTenNV.setEditable(false);

		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setFont(new Font("Verdana", Font.BOLD, 12));
		lblGioiTinh.setBounds(763, 43, 82, 22);
		panel.add(lblGioiTinh);

		cbGioiTinh = new JCheckBox("Nam");
		cbGioiTinh.setBackground(UIManager.getColor("CheckBox.light"));
		cbGioiTinh.setFont(new Font("Verdana", Font.BOLD, 12));
		cbGioiTinh.setBounds(872, 43, 74, 23);
		panel.add(cbGioiTinh);
		cbGioiTinh.setEnabled(false);

		JLabel lblTaiKhoan = new JLabel("Tài Khoản:");
		lblTaiKhoan.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTaiKhoan.setBounds(764, 106, 87, 22);
		panel.add(lblTaiKhoan);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Verdana", Font.BOLD, 12));
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBackground(UIManager.getColor("CheckBox.light"));
		txtTaiKhoan.setBounds(873, 109, 167, 20);
		panel.add(txtTaiKhoan);
		txtTaiKhoan.setBorder(matterBorder);
		txtTaiKhoan.setEditable(false);

		JLabel lblCmnd = new JLabel("Chứng Minh ND:");
		lblCmnd.setFont(new Font("Verdana", Font.BOLD, 12));
		lblCmnd.setBounds(25, 107, 106, 22);
		panel.add(lblCmnd);

		txtCmnd = new JTextField();
		txtCmnd.setFont(new Font("Verdana", Font.BOLD, 12));
		txtCmnd.setColumns(10);
		txtCmnd.setBackground(UIManager.getColor("CheckBox.light"));
		txtCmnd.setBounds(158, 109, 174, 20);
		panel.add(txtCmnd);
		txtCmnd.setBorder(matterBorder);
		txtCmnd.setEditable(false);

		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSDT.setBounds(389, 107, 106, 22);
		panel.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Verdana", Font.BOLD, 12));
		txtSDT.setColumns(10);
		txtSDT.setBackground(UIManager.getColor("CheckBox.light"));
		txtSDT.setBounds(515, 110, 182, 20);
		panel.add(txtSDT);
		txtSDT.setBorder(matterBorder);
		txtSDT.setEditable(false);

		JLabel lblChucVu = new JLabel("Chức Vụ: ");
		lblChucVu.setFont(new Font("Verdana", Font.BOLD, 12));
		lblChucVu.setBounds(25, 176, 82, 22);
		panel.add(lblChucVu);

		cbbChucVu = new JComboBox();
		cbbChucVu.setFont(new Font("Verdana", Font.BOLD, 12));
		cbbChucVu.setBackground(UIManager.getColor("CheckBox.light"));
		cbbChucVu.setBounds(158, 179, 174, 20);
		panel.add(cbbChucVu);
		cbbChucVu.setBorder(matterBorder);
		cbbChucVu.addItem("QL");
		cbbChucVu.addItem("NV");
		cbbChucVu.setEnabled(false);

		JLabel lblMatKhau = new JLabel("Mật Khẩu:");
		lblMatKhau.setFont(new Font("Verdana", Font.BOLD, 12));
		lblMatKhau.setBounds(764, 180, 87, 22);
		panel.add(lblMatKhau);

		passMK = new JPasswordField();
		passMK.setFont(new Font("Verdana", Font.BOLD, 12));
		passMK.setBackground(UIManager.getColor("CheckBox.light"));
		passMK.setBounds(873, 178, 167, 20);
		panel.add(passMK);
		passMK.setEditable(false);
		passMK.setBorder(matterBorder);

		JButton btnResetPass = new JButton("");
		btnResetPass.setBounds(1072, 176, 28, 29);
		panel.add(btnResetPass);
	//	try {
	//		Image change = ImageIO.read(getClass().getResource("/img/icon-reset.png"));
	//		btnResetPass.setIcon(new ImageIcon(change));
	//	} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		btnResetPass.setBorder(raisedBevel);
		btnResetPass.setEnabled(false);

		JLabel lblTrangThai = new JLabel("Trạng Thái:");
		lblTrangThai.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTrangThai.setBounds(389, 176, 106, 22);
		panel.add(lblTrangThai);

		cbbTrangThai = new JComboBox();
		cbbTrangThai.setFont(new Font("Verdana", Font.BOLD, 12));
		cbbTrangThai.setBackground(UIManager.getColor("CheckBox.light"));
		cbbTrangThai.setBounds(515, 178, 182, 20);
		panel.add(cbbTrangThai);
		cbbTrangThai.setBorder(matterBorder);
		cbbTrangThai.addItem("ĐANG LÀM VIỆC");
		cbbTrangThai.addItem("NGHỈ VIỆC");
		cbbTrangThai.setEnabled(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("CheckBox.light"));
		panel_1.setBounds(0, 242, 1142, 107);
		add(panel_1);
		setVisible(true);
		Border titleBorder1 = BorderFactory.createTitledBorder(blueBorder, "Chức Năng");
		panel_1.setBorder(titleBorder1);
		panel_1.setLayout(null);

		JLabel lblTimKiem = new JLabel("Tìm Kiếm: ");
		lblTimKiem.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTimKiem.setBounds(763, 48, 80, 29);
		panel_1.add(lblTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Verdana", Font.BOLD, 12));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBackground(UIManager.getColor("CheckBox.light"));
		txtTimKiem.setBounds(878, 53, 171, 20);
		panel_1.add(txtTimKiem);
		txtTimKiem.setBorder(matterBorder);

		JButton btnThemNV = new JButton("Thêm Nhân Viên");
		btnThemNV.setFont(new Font("Verdana", Font.BOLD, 12));
		btnThemNV.setBounds(24, 40, 139, 37);
		panel_1.add(btnThemNV);
		btnThemNV.setBorder(raisedBevel);

		JButton btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCapNhat.setBounds(200, 40, 139, 37);
		panel_1.add(btnCapNhat);
		btnCapNhat.setBorder(raisedBevel);
		btnCapNhat.setEnabled(false);

		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Verdana", Font.BOLD, 12));
		btnXoaTrang.setBounds(562, 40, 139, 37);
		panel_1.add(btnXoaTrang);
		btnXoaTrang.setBorder(raisedBevel);
		btnXoaTrang.setEnabled(false);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Verdana", Font.BOLD, 12));
		btnHuy.setBounds(378, 40, 139, 37);
		panel_1.add(btnHuy);
		btnHuy.setBorder(raisedBevel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 360, 1142, 345);
		add(scrollPane);

		table = new JTable();
		table.setBackground(UIManager.getColor("CheckBox.light"));
		table.setFont(new Font("Verdana", Font.PLAIN, 12));
		table.setModel(model = new DefaultTableModel(new Object[][] {}, new String[] { "Mã Nhân Viên", "Tên Nhân Viên",
				"Chứng Minh Nhân Dân", "Số Điện Thọai", "Giới Tính", "Chức Vụ", "Tài Khoản", "Trạng Thái" }));
		scrollPane.setViewportView(table);
		scrollPane.setBorder(compound);

		updateDuLieu();
		getYear();

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if (row == -1) {
					return;
				}
				btnXoaTrang.setEnabled(true);
				btnCapNhat.setEnabled(true);
				btnThemNV.setEnabled(false);
				btnHuy.setEnabled(false);
				fillForm(row);

				try {
					String ma = model.getValueAt(row, 0).toString();
					NhanVien nv = nhanvienDAO.findId(ma);
					passMK.setText(nv.getTaiKhoan().getMatKhau());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		btnResetPass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				passMK.setText("12345");
			}
		});

		btnThemNV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnHuy.setEnabled(true);

				if (btnThemNV.getText().equals("Thêm Nhân Viên")) {
					btnThemNV.setText("Lưu");
					txtTenNV.setEditable(true);
					txtCmnd.setEditable(true);
					txtSDT.setEditable(true);
					txtTaiKhoan.setEditable(true);
					cbGioiTinh.setEnabled(true);
					cbbChucVu.setEnabled(true);
					cbbTrangThai.setEnabled(true);
					btnResetPass.setEnabled(true);
				} else {
					NhanVien nv = new NhanVien();
					String ma = autoMaNV();
					nv.setMaNhanVien(ma);
					nv.setTenNhanVien(txtTenNV.getText());
					nv.setCmnd(txtCmnd.getText());
					nv.setSdt(txtSDT.getText());
					nv.setGioiTinh(cbGioiTinh.isSelected());
					nv.setChucVu(cbbChucVu.getSelectedItem().toString());
					nv.setTrangThai(cbbTrangThai.getSelectedItem().toString());
					TaiKhoan tk = new TaiKhoan();
					tk.setTenTaiKhoan(txtTaiKhoan.getText());
					tk.setMatKhau(passMK.getText());
					nv.setTaiKhoan(tk);
					model.addRow(new Object[] { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getCmnd(), nv.getSdt(),
							nv.isGioiTinh() ? "Nữ" : "Nam", nv.getChucVu(), nv.getTaiKhoan().getTenTaiKhoan(),
							nv.getTrangThai() });
					try {
						nhanvienDAO.addNhanVien(nv);
					//	taikhoanDAO.addTaiKhoan(tk);
						JOptionPane.showMessageDialog(null, "Thêm Nhân viên thành công");
						btnThemNV.setText("Thêm Nhân Viên");
						btnThemNV.setEnabled(true);
						txtTenNV.setEditable(false);
						txtCmnd.setEditable(false);
						txtSDT.setEditable(false);
						txtTaiKhoan.setEditable(false);
						cbGioiTinh.setEnabled(false);
						cbbChucVu.setEnabled(false);
						cbbTrangThai.setEnabled(false);
						btnResetPass.setEnabled(false);
						clearTextField();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Không thêm được nhân viên");
					}
					
				}
			}
		});

		btnCapNhat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnHuy.setEnabled(true);
				if (btnCapNhat.getText().equals("Cập Nhật")) {
					btnCapNhat.setText("Lưu");
					txtMaNV.setEditable(true);
					txtTenNV.setEditable(true);
					txtCmnd.setEditable(true);
					txtSDT.setEditable(true);
					cbGioiTinh.setEnabled(true);
					cbbChucVu.setEnabled(true);
					cbbTrangThai.setEnabled(true);
					btnResetPass.setEnabled(true);
				} else {
					try {
						nhanvienDAO.updateTenNhanVien(nhanvienDAO.findId(txtMaNV.getText()), txtTenNV.getText());
						nhanvienDAO.updateCMNDNhanVien(nhanvienDAO.findId(txtMaNV.getText()), txtCmnd.getText());
						nhanvienDAO.updateSDT(nhanvienDAO.findId(txtMaNV.getText()), txtSDT.getText());
						nhanvienDAO.updateTrangThai(nhanvienDAO.findId(txtMaNV.getText()),
								cbbTrangThai.getSelectedItem().toString());
						nhanvienDAO.updateChucVu(nhanvienDAO.findId(txtMaNV.getText()), cbbChucVu.getSelectedItem().toString());
//						taikhoanDAO.updateTaiKhoan(taikhoanDAO.findId(arg0), passMK.getText());
						nhanvienDAO.updatePassWord(nhanvienDAO.findId(txtMaNV.getText()), passMK.getText());
						DefaultTableModel dm = (DefaultTableModel) table.getModel();
						dm.setRowCount(0);
						updateDuLieu();
						btnCapNhat.setText("Cập Nhật");
						txtMaNV.setEditable(false);
						txtTenNV.setEditable(false);
						txtCmnd.setEditable(false);
						txtSDT.setEditable(false);
						cbGioiTinh.setEnabled(false);
						cbbChucVu.setEnabled(false);
						cbbTrangThai.setEnabled(false);
						btnResetPass.setEnabled(false);

					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});

		btnXoaTrang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearTextField();
				btnXoaTrang.setEnabled(false);
				btnCapNhat.setEnabled(false);
				btnThemNV.setEnabled(true);
				txtMaNV.setEditable(false);
				txtTenNV.setEditable(false);
				txtCmnd.setEditable(false);
				txtSDT.setEditable(false);
				txtTaiKhoan.setEditable(false);
				cbGioiTinh.setEnabled(false);
				cbbChucVu.setEnabled(false);
				cbbTrangThai.setEnabled(false);
			}
		});

		txtTimKiem.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				try {
					DefaultTableModel dm = (DefaultTableModel) table.getModel();
					dm.setRowCount(0);
					List<NhanVien> list = nhanvienDAO.listNhanVien();
					for (NhanVien nv : list) {
						if (nv.getTenNhanVien().toUpperCase().contains(txtTimKiem.getText().toUpperCase())) {
							model.addRow(new Object[] { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getCmnd(),
									nv.getSdt(), nv.isGioiTinh() ? "Nữ" : "Nam", nv.getChucVu(),
									nv.getTaiKhoan().getTenTaiKhoan(), nv.getTrangThai() });
						}
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		btnHuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnCapNhat.setText("Cập Nhật");
				btnThemNV.setText("Thêm Nhân Viên");
				btnHuy.setEnabled(false);
				btnResetPass.setEnabled(false);
				txtMaNV.setEditable(false);
				txtTenNV.setEditable(false);
				txtCmnd.setEditable(false);
				txtSDT.setEditable(false);
				cbGioiTinh.setEnabled(false);
				cbbChucVu.setEnabled(false);
				cbbTrangThai.setEnabled(false);
			}
		});
	}

	public void updateDuLieu() {
		try {
			nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:17676/nhanvienRemote");
			List<NhanVien> listNV = nhanvienDAO.listNhanVien();
			for (NhanVien nv : listNV) {
				model.addRow(new Object[] { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getCmnd(), nv.getSdt(),
						nv.isGioiTinh() ? "Nữ" : "Nam", nv.getChucVu(), nv.getTaiKhoan().getTenTaiKhoan(),
						nv.getTrangThai() });
				// System.out.println("trucdz");
			}

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

	public void fillForm(int row) {
		if (row != -1) {
			txtMaNV.setText(model.getValueAt(row, 0).toString());
			txtTenNV.setText(model.getValueAt(row, 1).toString());
			txtCmnd.setText(model.getValueAt(row, 2).toString());
			txtSDT.setText(model.getValueAt(row, 3).toString());
			cbGioiTinh.setSelected(model.getValueAt(row, 4).toString().equals("Nam"));
			cbbChucVu.setSelectedItem(model.getValueAt(row, 5));
			txtTaiKhoan.setText(model.getValueAt(row, 6).toString());
			cbbTrangThai.setSelectedItem(model.getValueAt(row, 7));

		}
	}

	public void clearTextField() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtCmnd.setText("");
		txtSDT.setText("");
		txtTaiKhoan.setText("");
		passMK.setText("");
		cbGioiTinh.setSelected(false);
		cbbTrangThai.setSelectedIndex(-1);
		cbbChucVu.setSelectedIndex(-1);
	}

	public String autoMaNV() {
		String ma = "NV";
		try {
			List<NhanVien> list = nhanvienDAO.listNhanVien();
			int so = 0;
			if(list == null) {
				return "NV000";
			}
			for(NhanVien nv : list) {
				if(nv.getMaNhanVien().length() == 5) {
					so = Integer.parseInt(nv.getMaNhanVien().substring(2, 5));
					so = so + 1;
				}
			}
			if(so >= 0 && so < 10) {
				ma = ma + "00" + so;
			}
			if(so >= 10 && so < 100) {
				ma = ma + "0" + so;
			}
			if(so >= 100 & so < 1000) {
				ma = ma + so;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ma;
	}

	public void getYear() {
		LocalDate date = LocalDate.now();
		System.out.println(date.getYear());
	}
}
