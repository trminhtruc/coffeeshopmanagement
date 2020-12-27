package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import entities.HoaDon;
import entities.MonAnUong;

public class GUI_QLAnUong extends JPanel {
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDonGia;
	private JTable table;
	private JTextField txtTimKiem;
	private static DefaultTableModel model;
	// private int row;
	MonAnUongDAO monanDAO;
	HoaDonDAO hoadonDAO;
	NhanVienDAO nhanvienDAO;

	/**
	 * Create the panel.
	 */
	public GUI_QLAnUong() {

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

		setBackground(UIManager.getColor("ChesckBox.light"));
		setSize(1142, 705);
		setLayout(null);

		Border raisedBevel = BorderFactory.createRaisedBevelBorder();
		Border loweredBevel = BorderFactory.createLoweredBevelBorder();
		Border compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
		Border blueBorder = BorderFactory.createLineBorder(Color.BLUE);
		Border matterBorder = new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBox.light"));
		panel.setBounds(0, 0, 1142, 200);
		add(panel);
		panel.setLayout(null);
		Border titleBorder = BorderFactory.createTitledBorder(blueBorder, "Thông Tin Đồ Ăn, Thức Uống");
		panel.setBorder(titleBorder);

		JLabel lblMaAnUong = new JLabel("Mã Món Ăn Uống:");
		lblMaAnUong.setFont(new Font("Verdana", Font.BOLD, 12));
		lblMaAnUong.setBounds(24, 43, 148, 22);
		panel.add(lblMaAnUong);

		txtMa = new JTextField();
		txtMa.setFont(new Font("Verdana", Font.BOLD, 12));
		txtMa.setBackground(UIManager.getColor("CheckBox.light"));
		txtMa.setBounds(213, 46, 216, 20);
		panel.add(txtMa);
		txtMa.setColumns(10);
		txtMa.setBorder(matterBorder);
		txtMa.setEditable(false);

		JLabel lblTen = new JLabel("Tên Món Ăn Uống:");
		lblTen.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTen.setBounds(564, 43, 172, 22);
		panel.add(lblTen);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Verdana", Font.BOLD, 12));
		txtTen.setColumns(10);
		txtTen.setBackground(UIManager.getColor("CheckBox.light"));
		txtTen.setBounds(746, 46, 329, 20);
		panel.add(txtTen);
		txtTen.setBorder(matterBorder);
		txtTen.setEditable(false);

		JLabel lblDonGia = new JLabel("Đơn Giá:");
		lblDonGia.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDonGia.setBounds(24, 127, 106, 22);
		panel.add(lblDonGia);

		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Verdana", Font.BOLD, 12));
		txtDonGia.setColumns(10);
		txtDonGia.setBackground(UIManager.getColor("CheckBox.light"));
		txtDonGia.setBounds(213, 129, 216, 20);
		panel.add(txtDonGia);
		txtDonGia.setBorder(matterBorder);
		txtDonGia.setEditable(false);

		JLabel lblLoai = new JLabel("Loại:");
		lblLoai.setFont(new Font("Verdana", Font.BOLD, 12));
		lblLoai.setBounds(564, 127, 50, 22);
		panel.add(lblLoai);

		JComboBox cbbLoai = new JComboBox();
		cbbLoai.setFont(new Font("Verdana", Font.BOLD, 12));
		cbbLoai.setBackground(UIManager.getColor("CheckBox.light"));
		cbbLoai.setBounds(624, 129, 158, 20);
		panel.add(cbbLoai);
		cbbLoai.addItem("THỨC UỐNG");
		cbbLoai.addItem("ĐỒ ĂN");

		JLabel lblTrangThai = new JLabel("Trạng Thái:");
		lblTrangThai.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTrangThai.setBounds(831, 127, 95, 22);
		panel.add(lblTrangThai);

		JComboBox cbbTrangThai = new JComboBox();
		cbbTrangThai.setFont(new Font("Verdana", Font.BOLD, 12));
		cbbTrangThai.setBackground(UIManager.getColor("CheckBox.light"));
		cbbTrangThai.setBounds(917, 129, 158, 20);
		panel.add(cbbTrangThai);
		cbbTrangThai.addItem("ĐANG KINH DOANH");
		cbbTrangThai.addItem("NGỪNG KINH DOANH");
	//	cbbTrangThai.addItem("HẾT HÀNG");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("CheckBox.light"));
		panel_1.setBounds(0, 202, 1142, 118);
		add(panel_1);
		setVisible(true);
		Border titleBorder1 = BorderFactory.createTitledBorder(blueBorder, "Chức Năng");
		panel_1.setBorder(titleBorder1);
		panel_1.setLayout(null);

		JLabel lblTimKiem = new JLabel("Tìm Kiếm: ");
		lblTimKiem.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTimKiem.setBounds(836, 44, 80, 29);
		panel_1.add(lblTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Verdana", Font.BOLD, 12));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBackground(UIManager.getColor("CheckBox.light"));
		txtTimKiem.setBounds(922, 49, 154, 20);
		panel_1.add(txtTimKiem);
		txtTimKiem.setBorder(matterBorder);

		JButton btnThem = new JButton("Thêm Đồ Ăn Thức Uống");
		btnThem.setFont(new Font("Verdana", Font.BOLD, 12));
		btnThem.setBounds(24, 40, 164, 37);
		panel_1.add(btnThem);
		btnThem.setBorder(raisedBevel);

		JButton btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCapNhat.setBounds(235, 40, 139, 37);
		panel_1.add(btnCapNhat);
		btnCapNhat.setBorder(raisedBevel);
		btnCapNhat.setEnabled(false);

		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Verdana", Font.BOLD, 12));
		btnXoaTrang.setBounds(611, 40, 139, 37);
		panel_1.add(btnXoaTrang);
		btnXoaTrang.setBorder(raisedBevel);
		btnXoaTrang.setEnabled(false);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Verdana", Font.BOLD, 12));
		btnHuy.setEnabled(false);
		btnHuy.setBounds(417, 40, 139, 37);
		panel_1.add(btnHuy);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 331, 1142, 374);
		add(scrollPane);

		table = new JTable();
		table.setBackground(UIManager.getColor("CheckBox.light"));
		// table.setFont(new Font("Verdana", Font.BOLD, 12));
		table.setModel(model = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã Món Ăn Thức Uống", "Tên Món Ăn, Thức Uống", "Đơn Giá", "Loại", "Trạng Thái" }));
		scrollPane.setViewportView(table);
		scrollPane.setBorder(compound);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (table.getSelectedRow() == -1) {
					return;
				}
				btnCapNhat.setEnabled(true);
				btnXoaTrang.setEnabled(true);
				int row = table.getSelectedRow();
				txtMa.setText(model.getValueAt(row, 0).toString());
				txtTen.setText(model.getValueAt(row, 1).toString());
				txtDonGia.setText(model.getValueAt(row, 2).toString());
				// System.out.println(model.getValueAt(row, 2).toString());
				cbbLoai.setSelectedItem(model.getValueAt(row, 3).toString().toUpperCase());
				cbbTrangThai.setSelectedItem(model.getValueAt(row, 4).toString().toUpperCase());
				btnThem.setEnabled(false);
				cbbLoai.setEditable(false);
				cbbTrangThai.setEditable(false);
			}
		});

//		

//		
		btnXoaTrang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// cbbTrangThai.RemoveItem ();
				txtMa.setText("");
				txtTen.setText("");
				txtDonGia.setText("");
				cbbLoai.setSelectedIndex(-1);
				cbbTrangThai.setSelectedIndex(-1);
				txtTen.requestFocus();
				btnXoaTrang.setEnabled(false);
				btnThem.setEnabled(true);
				btnCapNhat.setEnabled(false);
			
			}
		});

		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (btnThem.getText().equals("Thêm Đồ Ăn Thức Uống")) {
					btnThem.setText("Lưu");
					txtMa.setText("");
					txtTen.setText("");
					txtDonGia.setText("");
					cbbLoai.setSelectedIndex(-1);
					cbbTrangThai.setSelectedIndex(-1);
					txtTen.setEditable(true);
					txtDonGia.setEditable(true);
					txtTen.requestFocus();
					btnHuy.setEnabled(true);
				} else {
					if(txtDonGia.getText().trim().equals("")||txtTen.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP ĐẦY ĐỦ THÔNG TIN");
						return;
					}
					btnHuy.setEnabled(false);
					MonAnUong monanuong = new MonAnUong();
					String ma = autoMaAnUong();
					monanuong.setMaMonAnUong(ma);
					monanuong.setTen(txtTen.getText());
					monanuong.setDonGia(Double.parseDouble(txtDonGia.getText()));
					monanuong.setLoai(cbbLoai.getSelectedItem().toString());
					monanuong.setTrangThai(cbbTrangThai.getSelectedItem().toString());
					model.addRow(new Object[] { monanuong.getMaMonAnUong(), monanuong.getTen(), monanuong.getDonGia(),
							monanuong.getLoai(), monanuong.getTrangThai() });
					txtTen.setEditable(false);
					txtDonGia.setEditable(false);
					btnThem.setText("Thêm Đồ Ăn Thức Uống");
					/// btnThem.setEnabled(false);
					cbbLoai.setSelectedIndex(-1);
					cbbTrangThai.setSelectedIndex(-1);
					try {
						monanDAO.addMonAnUong(monanuong);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					txtDonGia.setText("");
					txtMa.setText("");
					txtTen.setText("");
					// txtTimKiem.setText("");
				}
			}
		});

		btnCapNhat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnCapNhat.getText().toUpperCase().equals("CẬP NHẬT")) {
					btnCapNhat.setText("Lưu");
					txtDonGia.setEditable(true);
					txtTen.setEditable(true);
					btnHuy.setEnabled(true);
				} else {
					try {
						if(txtDonGia.getText().trim().equals("")||txtTen.getText().trim().equals("")) {
							JOptionPane.showMessageDialog(null, "VUI LÒNG NHẬP ĐẦY ĐỦ THÔNG TIN");
							return;
						}
						btnCapNhat.setText("Cập Nhật");
						txtDonGia.setEditable(false);
						txtTen.setEditable(false);
						btnHuy.setEnabled(false);
						
						monanDAO.updateMonAnUongTen(monanDAO.findId(txtMa.getText()), txtTen.getText().toString());
						monanDAO.updateMonAnUongDonGia(monanDAO.findId(txtMa.getText()),
								Double.parseDouble(txtDonGia.getText()));
						monanDAO.updateTrangThai(monanDAO.findId(txtMa.getText()),
								cbbTrangThai.getSelectedItem().toString());
						DefaultTableModel dm = (DefaultTableModel) table.getModel();
						dm.setRowCount(0);
						updateDuLieu();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnCapNhat.setText("Cập Nhật");
				btnHuy.setEnabled(false);
				txtDonGia.setEditable(false);
				txtTen.setEditable(false);
				btnThem.setText("Thêm Đồ Ăn Thức Uống");
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
					List<MonAnUong> monanList = monanDAO.listMonAnUong();
					for (MonAnUong anuong : monanList) {
						if (anuong.getTen().toUpperCase().contains(txtTimKiem.getText().toUpperCase())) {
							model.addRow(new Object[] { anuong.getMaMonAnUong(), anuong.getTen(), anuong.getDonGia(),
									anuong.getLoai(), anuong.getTrangThai() });
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
		updateDuLieu();
	}

	public void updateDuLieu() {
		try {
			monanDAO = (MonAnUongDAO) Naming.lookup("rmi://localhost:17676/monanRemote");
			List<MonAnUong> listmonan = monanDAO.listMonAnUong();
			for (MonAnUong anuong : listmonan) {
				model.addRow(new Object[] { anuong.getMaMonAnUong(), anuong.getTen(), anuong.getDonGia(),
						anuong.getLoai(), anuong.getTrangThai() });
			}
			System.out.println("da vao");
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

	public String autoMaAnUong() {
		String ma = "M";
		try {
			List<MonAnUong> list = monanDAO.listMonAnUong();
			int so = 0;
			if (list == null)
				return "M000";
			for (MonAnUong monan : list) {
//				String so2 = monan.getMaMonAnUong().substring(1, 4);
//				so = Integer.parseInt(so2) + 1;
				if (monan.getMaMonAnUong().length() == 4) {
					so = Integer.parseInt(monan.getMaMonAnUong().substring(1, 4));
					System.out.println(monan.getMaMonAnUong().substring(1, 4));
					so = so + 1;
				}
			} // M001
			if (so >= 0 && so < 10) {
				ma = ma + "00" + String.valueOf(so);
			}
			if (so >= 10 && so < 100) {
				ma = ma + "0" + String.valueOf(so);
			}
			if (so >= 100 && so < 1000) {
				ma = ma + String.valueOf(so);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ma;
	}
}
