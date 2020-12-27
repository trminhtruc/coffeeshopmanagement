package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import daos.HoaDonDAO;
import daos.MonAnUongDAO;
import daos.NhanVienDAO;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.MonAnUong;
import entities.NhanVien;

public class GUI_DatMon extends JPanel {
//	private JTable table;
//	private JTable table_1;
	private static DefaultTableModel modelThucUong, modelMonAn, modelHoaDon;
	private JTable tableHoaDon;
	private JTextField txtTenSanPham;
	private JTextField txtTenNV;
	private JTable tableThucUong;
	private JTable tableMonAn;
	private JTextField txtSoBan;
	private JTextField txtTongTien;
	private JTextField txtTienKhachDua;
	private JTextField txtTienThoi;
	private List<MonAnUong> monanuong;
	private JButton btnLuu;
	MonAnUongDAO monanDAO;
	HoaDonDAO hoadonDAO;
	NhanVienDAO nhanvienDAO;
	private JTextField txtMa;
	private JSpinner spinner;
	private JButton btnCapNhat;
	private NhanVien nv;
	private JButton[] btnBan;
	private Map<String, HoaDon> keyvalue = new HashMap<String, HoaDon>();

	/**
	 * Create the panel.
	 */
	public GUI_DatMon() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

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

		Border raisedBevel = BorderFactory.createRaisedBevelBorder();
		Border loweredBevel = BorderFactory.createLoweredBevelBorder();
		Border compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
		Border blueBorder = BorderFactory.createLineBorder(Color.BLUE);
		Border matterBorder = new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(329, 13, 0, 0);
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		setSize(1142, 705);
		setVisible(true);

		JPanel panelHoaDon = new JPanel();
		panelHoaDon.setBackground(Color.LIGHT_GRAY);
		// panelHoaDon.setBackground(SystemColor.textText);
		panelHoaDon.setBounds(762, 0, 380, 705);
		add(panelHoaDon);
		panelHoaDon.setLayout(null);
		Border title = BorderFactory.createTitledBorder(blueBorder, "HÓA ĐƠN");
		panelHoaDon.setBorder(title);

		JScrollPane scrollPaneHoaDon = new JScrollPane();
		scrollPaneHoaDon.setToolTipText("");
		scrollPaneHoaDon.setBounds(10, 183, 360, 341);
		panelHoaDon.add(scrollPaneHoaDon);
		scrollPaneHoaDon.setBorder(compound);

		tableHoaDon = new JTable();
		tableHoaDon.setModel(modelHoaDon = new DefaultTableModel(new Object[][] {},
				new String[] { "mã sp", "S\u1EA2N PH\u1EA8M", "S\u1ED0 L\u01AF\u1EE2NG", "ĐƠN GIÁ" }));
		tableHoaDon.getColumnModel().getColumn(0).setPreferredWidth(51);
		tableHoaDon.getColumnModel().getColumn(1).setPreferredWidth(79);
		tableHoaDon.getColumnModel().getColumn(2).setPreferredWidth(63);
		tableHoaDon.getColumnModel().getColumn(3).setPreferredWidth(84);
		tableHoaDon.setBackground(Color.WHITE);
		scrollPaneHoaDon.setViewportView(tableHoaDon);

		scrollPaneHoaDon.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneHoaDon.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JLabel lblMaDH = new JLabel("Tên ");
		lblMaDH.setForeground(Color.BLACK);
		lblMaDH.setFont(new Font("Verdana", Font.BOLD, 12));
		lblMaDH.setBounds(10, 86, 106, 25);
		panelHoaDon.add(lblMaDH);

		txtTenSanPham = new JTextField();
		txtTenSanPham.setBackground(Color.LIGHT_GRAY);
		txtTenSanPham.setBounds(126, 89, 173, 20);
		panelHoaDon.add(txtTenSanPham);
		txtTenSanPham.setColumns(10);
		txtTenSanPham.setBorder(matterBorder);

		JLabel lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setForeground(Color.BLACK);
		lblSoLuong.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSoLuong.setBounds(10, 118, 106, 25);
		panelHoaDon.add(lblSoLuong);

		txtSoBan = new JTextField();
		txtSoBan.setFont(new Font("Sylfaen", Font.BOLD, 13));
		txtSoBan.setBackground(Color.LIGHT_GRAY);
		txtSoBan.setColumns(10);
		txtSoBan.setBounds(10, 24, 106, 32);
		txtSoBan.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(64, 64, 64)));
		panelHoaDon.add(txtSoBan);
		txtSoBan.setEditable(false);

		txtTongTien = new JTextField();
		txtTongTien.setBackground(Color.LIGHT_GRAY);
		txtTongTien.setBounds(284, 535, 86, 20);
		panelHoaDon.add(txtTongTien);
		txtTongTien.setColumns(10);
		txtTongTien.setBorder(matterBorder);

		txtTienKhachDua = new JTextField();
		txtTienKhachDua.setBackground(Color.LIGHT_GRAY);
		txtTienKhachDua.setColumns(10);
		txtTienKhachDua.setBounds(284, 570, 86, 20);
		panelHoaDon.add(txtTienKhachDua);
		txtTienKhachDua.setBorder(matterBorder);

		txtTienThoi = new JTextField();
		txtTienThoi.setBackground(Color.LIGHT_GRAY);
		txtTienThoi.setColumns(10);
		txtTienThoi.setBounds(284, 608, 86, 20);
		panelHoaDon.add(txtTienThoi);
		txtTienThoi.setBorder(matterBorder);

		JLabel lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTongTien.setBounds(201, 535, 64, 20);
		panelHoaDon.add(lblTongTien);

		JLabel lblTienKhachDua = new JLabel("Tiền Khách đưa:");
		lblTienKhachDua.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTienKhachDua.setBounds(168, 573, 97, 20);
		panelHoaDon.add(lblTienKhachDua);

		JLabel lblTienThoi = new JLabel("Tiền thối lại:");
		lblTienThoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTienThoi.setBounds(189, 611, 76, 20);
		panelHoaDon.add(lblTienThoi);
//
//		JButton btnTaoHoaDon = new JButton("Tạo Hóa Đơn");
//		btnTaoHoaDon.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnTaoHoaDon.setBounds(10, 653, 116, 41);
//		panelHoaDon.add(btnTaoHoaDon);

		JButton btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThanhToan.setBounds(235, 653, 116, 41);
		panelHoaDon.add(btnThanhToan);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBackground(UIManager.getColor("CheckBox.light"));
		spinner.setForeground(UIManager.getColor("CheckBox.light"));
		spinner.setFont(new Font("Verdana", Font.BOLD, 12));
		spinner.setBounds(126, 120, 58, 20);
		panelHoaDon.add(spinner);

		btnLuu = new JButton("LƯU");
		btnLuu.setBounds(235, 153, 64, 25);
		panelHoaDon.add(btnLuu);

		JPanel panelThucUong = new JPanel();
		panelThucUong.setBounds(0, 243, 380, 462);
		add(panelThucUong);
		panelThucUong.setLayout(null);

		JScrollPane scrollPaneThucUong = new JScrollPane();
		scrollPaneThucUong.setBounds(10, 25, 360, 426);
		panelThucUong.add(scrollPaneThucUong);

		tableThucUong = new JTable();
		tableThucUong.setModel(
				modelThucUong = new DefaultTableModel(new Object[][] {}, new String[] { "mã", "tên", "đơn giá" }));

		scrollPaneThucUong.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneThucUong.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		scrollPaneThucUong.setViewportView(tableThucUong);
		scrollPaneThucUong.setBorder(compound);
//		Border blueBorder = BorderFactory.createLineBorder(Color.BLUE);
		Border titleBorder = BorderFactory.createTitledBorder(blueBorder, "THỨC UỐNG");
		panelThucUong.setBorder(titleBorder);

		JPanel panelMonAn = new JPanel();
		panelMonAn.setLayout(null);
		panelMonAn.setBounds(383, 243, 380, 462);
		add(panelMonAn);
		Border titleBorder_1 = BorderFactory.createTitledBorder(blueBorder, "MÓN ĂN");
		panelMonAn.setBorder(titleBorder_1);

		JScrollPane scrollPaneMonAn = new JScrollPane();
		scrollPaneMonAn.setBounds(10, 24, 360, 427);
		panelMonAn.add(scrollPaneMonAn);
		scrollPaneMonAn.setBorder(compound);

		tableMonAn = new JTable();
		tableMonAn.setModel(
				modelMonAn = new DefaultTableModel(new Object[][] {}, new String[] { "mã", "tên", "đơn giá" }));
		scrollPaneMonAn.setViewportView(tableMonAn);

		scrollPaneMonAn.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneMonAn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel panelSoBan = new JPanel();
		panelSoBan.setBounds(0, 0, 763, 242);
		add(panelSoBan);
		Border titleBorder_2 = BorderFactory.createTitledBorder(blueBorder, "SỐ BÀN");
		panelSoBan.setBorder(titleBorder_2);
		panelSoBan.setLayout(null);

		JLabel lblNewLabel = new JLabel("Còn Trống");
		lblNewLabel.setBounds(404, 213, 72, 16);
		panelSoBan.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Có Người");
		lblNewLabel_2.setBounds(602, 213, 56, 16);
		panelSoBan.add(lblNewLabel_2);

		JPanel jpanelTrong = new JPanel();
		jpanelTrong.setBackground(new Color(0, 204, 102));
		jpanelTrong.setForeground(Color.CYAN);
		jpanelTrong.setBounds(475, 208, 72, 21);
		panelSoBan.add(jpanelTrong);

		JPanel jpanelCoNguoi = new JPanel();
		jpanelCoNguoi.setBackground(new Color(255, 0, 102));
		jpanelCoNguoi.setBounds(667, 208, 72, 21);
		panelSoBan.add(jpanelCoNguoi);

		btnThanhToan.setEnabled(false);

		btnBan = new JButton[24];

		int soBan = 24;
		int soCot = 6;

		int startX = 10;
		int startY = 13;

		for (int i = 0; i < soBan; i++) {
			btnBan[i] = new JButton("BÀN " + i);
			btnBan[i].setFont(new Font("Stencil", Font.BOLD, 14));
			btnBan[i].setBounds(startX + (i % 8) * 92, startY + ((int) (i / 8)) * 60, 89, 54);
			btnBan[i].setBorder(raisedBevel);
			JButton a = btnBan[i];
			btnBan[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtSoBan.setText(a.getText().toString());
					// btnTaoHoaDon.setEnabled(true);
					tableMonAn.setEnabled(true);
					tableThucUong.setEnabled(true);
				}
			});
			panelSoBan.add(btnBan[i]);
		}

		tableMonAn.setEnabled(false);
		tableThucUong.setEnabled(false);
		setGiaTriKey();

		for (JButton jButton : btnBan) {
			jButton.setBackground(new Color(0, 204, 102));
			// new Color(0, 204, 102)
			// new Color(255, 0, 102)
			jButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					txtSoBan.setText(jButton.getText().toString());
					// btnTaoHoaDon.setEnabled(true);
					tableMonAn.setEnabled(true);
					tableThucUong.setEnabled(true);
					if (keyvalue.get(jButton.getText()) == null) {
						return;
					}

					DefaultTableModel dm = (DefaultTableModel) tableHoaDon.getModel();
					dm.setRowCount(0);
					HoaDon hd = keyvalue.get(jButton.getText());
					List<ChiTietHoaDon> ct = hd.getCthd();

					for (ChiTietHoaDon chiTietHoaDon : ct) {
						System.out.println((int) chiTietHoaDon.getSoluong());

						modelHoaDon.addRow(new Object[] { chiTietHoaDon.getMaAnUong().getMaMonAnUong(),
								chiTietHoaDon.getMaAnUong().getTen(), (int) chiTietHoaDon.getSoluong(),
								chiTietHoaDon.getMaAnUong().getDonGia() });

					}

					double tongtien = 0;

					// List<ChiTietHoaDon> ct = new ArrayList<ChiTietHoaDon>();
					if (tableHoaDon.getRowCount() > 0) {
						for (int i = 0; i < tableHoaDon.getRowCount(); i++) {
							tongtien = tongtien + (Double.parseDouble(modelHoaDon.getValueAt(i, 3).toString())
									* Double.parseDouble(modelHoaDon.getValueAt(i, 2).toString()));
						}
					}
					// tính tổng tiền và set chi tiết hóa đơn

					txtTongTien.setText(String.valueOf(tongtien));
					if (tongtien == 0) {
						txtTienKhachDua.setEnabled(false);
					} else {
						txtTienKhachDua.setEnabled(true);
					}
					DefaultTableModel dm1 = (DefaultTableModel) tableThucUong.getModel();
					dm1.setRowCount(0);
					DefaultTableModel dm2 = (DefaultTableModel) tableMonAn.getModel();
					dm2.setRowCount(0);
					try {
						setLaiThongTin();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
		}
		try {
			loadThongTinBan();
		} catch (RemoteException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		// btnTaoHoaDon.setEnabled(false);

		JLabel lblM = new JLabel("Mã ");
		lblM.setForeground(Color.BLACK);
		lblM.setFont(new Font("Verdana", Font.BOLD, 12));
		lblM.setBounds(10, 54, 106, 25);
		panelHoaDon.add(lblM);

		txtMa = new JTextField();
		txtMa.setColumns(10);
		txtMa.setBackground(Color.LIGHT_GRAY);
		txtMa.setBounds(126, 56, 173, 20);
		panelHoaDon.add(txtMa);
//		btnBan1.setBackground(Color.RED);
		txtMa.setBorder(matterBorder);

		btnCapNhat = new JButton("CẬP NHẬT");
		btnCapNhat.setBounds(126, 153, 97, 25);
		panelHoaDon.add(btnCapNhat);
		btnCapNhat.setEnabled(false);
		btnLuu.setEnabled(false);

		tableMonAn.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (tableMonAn.getSelectedRow() == -1) {
					return;
				}
				btnLuu.setEnabled(true);
				btnCapNhat.setEnabled(false);
				int row = tableMonAn.getSelectedRow();
				txtTenSanPham.setText(modelMonAn.getValueAt(row, 1).toString());
				txtMa.setText(modelMonAn.getValueAt(row, 0).toString());
			}
		});

		tableThucUong.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (tableThucUong.getSelectedRow() == -1) {
					return;
				}
				btnCapNhat.setEnabled(false);
				btnLuu.setEnabled(true);
				int row = tableThucUong.getSelectedRow();
				txtTenSanPham.setText(modelThucUong.getValueAt(row, 1).toString());
				txtMa.setText(modelThucUong.getValueAt(row, 0).toString());
			}
		});
		tableHoaDon.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (tableHoaDon.getSelectedRow() == -1) {
					return;
				}
				btnCapNhat.setEnabled(true);
				btnLuu.setEnabled(false);
				int row = tableHoaDon.getSelectedRow();

				txtMa.setText(modelHoaDon.getValueAt(row, 0).toString());
				txtTenSanPham.setText(modelHoaDon.getValueAt(row, 1).toString());
				spinner.setValue(Integer.parseInt(modelHoaDon.getValueAt(row, 2).toString()));

			}
		});
		btnLuu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					int tensoban;
					if (txtSoBan.getText().length() == 6) {
						tensoban = Integer.parseInt(txtSoBan.getText().substring(4, 6));
					} else {
						tensoban = Integer.parseInt(txtSoBan.getText().substring(4, 5));
					}
					btnBan[tensoban].setBackground(new Color(255, 0, 102));// set tình trạng cho bàn

					MonAnUong monan = monanDAO.findId(txtMa.getText().toString());
					modelHoaDon.addRow(new Object[] { txtMa.getText(), txtTenSanPham.getText(), spinner.getValue(),
							monan.getDonGia() });// thêm 1 row vào trong bảng hóa đơn
					double tongtien = 0;

					List<ChiTietHoaDon> ct = new ArrayList<ChiTietHoaDon>();
					if (tableHoaDon.getRowCount() > 0) {
						for (int i = 0; i < tableHoaDon.getRowCount(); i++) {
							tongtien = tongtien + (Double.parseDouble(modelHoaDon.getValueAt(i, 3).toString())
									* Double.parseDouble(modelHoaDon.getValueAt(i, 2).toString()));
							ChiTietHoaDon cthd;
							cthd = new ChiTietHoaDon(Integer.parseInt(modelHoaDon.getValueAt(i, 2).toString()));
							cthd.setMaAnUong(monanDAO.findId(modelHoaDon.getValueAt(i, 0).toString()));
							ct.add(cthd);
						}
					} // tính tổng tiền và set chi tiết hóa đơn

					txtTongTien.setText(String.valueOf(tongtien));

					DefaultTableModel dm = (DefaultTableModel) tableThucUong.getModel();
					dm.setRowCount(0);
					DefaultTableModel dm2 = (DefaultTableModel) tableMonAn.getModel();
					dm2.setRowCount(0);
					System.out.println("doa f1 " + keyvalue.get(txtSoBan.getText()).getMaHoaDon());
					for (ChiTietHoaDon jButton : ct) {
						System.out.println(jButton.getSoluong() + "fffeefffff");
						System.out.println(jButton.getMaAnUong().getMaMonAnUong() + "fefffff");
					}
					if (txtSoBan.getText() != null) {
						HoaDon hd = keyvalue.get(txtSoBan.getText());
						System.out.println("doa f2 " + keyvalue.get(txtSoBan.getText()).getMaHoaDon());
						if (keyvalue.get(txtSoBan.getText()).getMaHoaDon() == null) {

							System.out.println(nv.getMaNhanVien() + "few");
							hd.setNhanVien(nv);
							hd.setCthd(ct);
							hd.setNgayLap(LocalDate.now());
							hd.setMaHoaDon(AutoMaHD());
							hd.setTinhTrang("CHƯA THANH TOÁN");
							hd.setSoBan(txtSoBan.getText());
							// System.out.println("doa f3 "+keyvalue.get(txtSoBan.getText()).getMaHoaDon());
							hoadonDAO.addHoaDon(hd);
							// hd.setSoBan();
						} else if (hd.getMaHoaDon() != null) {

							hd.setCthd(ct);
							hoadonDAO.updateChiTietHoaDon(hd, ct);
						}
					}

					setLaiThongTin();// thiết lập lại thông tin hai bảng món ăn uống
					btnLuu.setEnabled(false);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCapNhat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tableHoaDon.getSelectedRow();
				modelHoaDon.setValueAt(spinner.getValue(), row, 2);
				double tongtien = 0;
				HoaDon hoadon = keyvalue.get(txtSoBan.getText());
				List<ChiTietHoaDon> hd = keyvalue.get(txtSoBan.getText()).getCthd();
				
				if (tableHoaDon.getRowCount() > 0) {
					for (int i = 0; i < tableHoaDon.getRowCount(); i++) {
						try {
							ChiTietHoaDon cthd2 = new ChiTietHoaDon();
							cthd2 = new ChiTietHoaDon(Integer.parseInt(modelHoaDon.getValueAt(i, 2).toString()));
							// hd.set(i, cthd2);
							cthd2.setMaAnUong(monanDAO.findId(modelHoaDon.getValueAt(i, 0).toString()));
							// System.out.println();
							System.out.println(hd.get(0).getSoluong());
							System.out.println(i + "chi so");
							hd.set(i, cthd2);
//							System.out.println(i);
						} catch (RemoteException e1) {

							e1.printStackTrace();
						}

						tongtien = tongtien + (Double.parseDouble(modelHoaDon.getValueAt(i, 3).toString())
								* Double.parseDouble(modelHoaDon.getValueAt(i, 2).toString()));
					}
				}
				try {
					hoadonDAO.updateChiTietHoaDon(hoadon, hd);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnCapNhat.setEnabled(false);
				txtTongTien.setText(String.valueOf(tongtien));
			}
		});
		txtTienKhachDua.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				double tongtien = Double.parseDouble(txtTongTien.getText());
				if (txtTienKhachDua.getText() != null && txtTienKhachDua.getText() != "") {
					System.out.println(txtTienKhachDua.getText());
					try {
						double tiennhap = Double.parseDouble(txtTienKhachDua.getText());
						txtTienThoi.setText(String.valueOf(tiennhap - tongtien));
					} catch (Exception e2) {
						// TODO: handle exception
					}

				}
				try {
					if (Double.parseDouble(txtTienThoi.getText()) < 0) {
						txtTienThoi.setText("");
						btnThanhToan.setEnabled(false);

					} else {
						btnThanhToan.setEnabled(true);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnThanhToan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					// HoaDon hoadon = new HoaDon(AutoMaHD(), LocalDate.now(), "");
					HoaDon hoadon = keyvalue.get(txtSoBan.getText());

					System.out.println(hoadon.getMaHoaDon() + "ma hoa don ne");
					hoadonDAO.updateTinhTrangHoaDon(hoadon, "ĐÃ THANH TOÁN");

					int tensoban;
					if (txtSoBan.getText().length() == 6) {
						tensoban = Integer.parseInt(txtSoBan.getText().substring(4, 6));
					} else {
						tensoban = Integer.parseInt(txtSoBan.getText().substring(4, 5));
					}

					btnBan[tensoban].setBackground(new Color(0, 204, 102));

					String tenban = "BÀN " + String.valueOf(tensoban);
					HoaDon f = keyvalue.get(tenban);
					f = null;
					keyvalue.replace(tenban, new HoaDon());
					clearThongTin();

				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtMa.setEditable(false);
		txtTenSanPham.setEditable(false);
		txtTongTien.setEditable(false);
		txtTienThoi.setEditable(false);
	}

	public void clearThongTin() {
		txtSoBan.setText("");
		txtTenSanPham.setText("");
		txtTienKhachDua.setText("");
		txtTienThoi.setText("");
		txtMa.setText("");
		txtTongTien.setText("");
		spinner.setValue(1);

		DefaultTableModel dm = (DefaultTableModel) tableHoaDon.getModel();
		dm.setRowCount(0);
	}

	public void setGiaTriKey() {
		for (int i = 0; i <= 23; i++) {
			String ban = "BÀN " + String.valueOf(i);
			keyvalue.put(ban, new HoaDon());
		}
	}

	public void setLaiThongTin() throws RemoteException {
		// this.monanuong = monanuong;
		List<MonAnUong> list = monanDAO.listMonAnUong();
		List<MonAnUong> listdemo = list;
		MonAnUong mf = null;
		System.out.println(modelHoaDon.getRowCount());
		for (int i = 0; i < modelHoaDon.getRowCount(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getMaMonAnUong().equals(modelHoaDon.getValueAt(i, 0))) {

					list.remove(list.get(j));
				}
			}
		}

		for (MonAnUong monAnUong2 : list) {
			if (monAnUong2.getTrangThai().equals("ĐANG KINH DOANH")) {
				if (monAnUong2.getLoai().toUpperCase().equals("THỨC UỐNG"))
					modelThucUong.addRow(
							new Object[] { monAnUong2.getMaMonAnUong(), monAnUong2.getTen(), monAnUong2.getDonGia() });
				else {
					modelMonAn.addRow(
							new Object[] { monAnUong2.getMaMonAnUong(), monAnUong2.getTen(), monAnUong2.getDonGia() });
				}
			}
		}
	}

	public void setThongTinMonAnUong(List<MonAnUong> monanuong, NhanVien nv) {
		// this.monanuong = monanuong;
		for (MonAnUong monAnUong2 : monanuong) {
			if (monAnUong2.getTrangThai().equals("ĐANG KINH DOANH")) {

				if (monAnUong2.getLoai().toUpperCase().equals("THỨC UỐNG")) {
					modelThucUong.addRow(
							new Object[] { monAnUong2.getMaMonAnUong(), monAnUong2.getTen(), monAnUong2.getDonGia() });
				} else {
					modelMonAn.addRow(
							new Object[] { monAnUong2.getMaMonAnUong(), monAnUong2.getTen(), monAnUong2.getDonGia() });
				}
			}
		}
		this.nv = nv;
	}

	public String AutoMaHD() {
		boolean check = true;
		// Date date = new Date();
		String maHD = "HD-";
		LocalDate localdate = LocalDate.now();
		String ngay = "";
		String thang = "";
		if (localdate.getDayOfMonth() > 0 && localdate.getDayOfMonth() < 10) {
			ngay = "0" + localdate.getDayOfMonth();
		} else
			ngay = String.valueOf(localdate.getDayOfMonth());
		if (localdate.getMonthValue() > 0 && localdate.getMonthValue() < 10) {
			thang = "0" + localdate.getMonthValue();
		} else
			thang = String.valueOf(localdate.getMonthValue());

		maHD = maHD + ngay + thang + localdate.getYear() + "-";
		System.out.println(maHD);
		try {
			List<HoaDon> listHoaDon = hoadonDAO.listHoaDon();

			String soMa = "";
			int so = 0;
			for (HoaDon hoaDon : listHoaDon) {
				System.out.println(hoaDon.getMaHoaDon().substring(3, 11) + "dona kkimd inh");

				String so2 = hoaDon.getMaHoaDon().substring(12, 15);
				// System.out.println(so2);
				so = Integer.parseInt(so2) + 1;
				if (!hoaDon.getMaHoaDon().substring(3, 11).equals(ngay + thang + localdate.getYear())) {
					so = 0;
				}
			}
			if (so >= 0 && so < 10) {
				soMa = "00" + String.valueOf(so);
			}
			if (so >= 10 && so < 100) {
				soMa = "0" + String.valueOf(so);
			}
			if (so >= 100 && so < 1000) {
				soMa = String.valueOf(so);
			}
			maHD = maHD + soMa;
			// soMa = String.valueOf(so);
			System.out.println(maHD);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maHD;
	}

	public void loadThongTinBan() throws RemoteException {
		List<HoaDon> listHoaDon = hoadonDAO.listHoaDon();

		List<HoaDon> listDaThanhToan = new ArrayList<HoaDon>();
		for (HoaDon hoaDon : listHoaDon) {
			if (hoaDon.getTinhTrang().equals("CHƯA THANH TOÁN")) {
				listDaThanhToan.add(hoaDon);
			}
		}

		for (int i = 0; i < 24; i++) {
			String tenban = "BÀN " + String.valueOf(i);
			for (HoaDon hoaDon : listDaThanhToan) {
				if (hoaDon.getSoBan().equals(tenban)) {
					HoaDon hd = keyvalue.get(tenban);
					hd.setMaHoaDon(hoaDon.getMaHoaDon());
					hd.setNhanVien(hoaDon.getNhanVien());
					hd.setNgayLap(hoaDon.getNgayLap());
					hd.setCthd(hoaDon.getCthd());
					hd.setTinhTrang(hoaDon.getTinhTrang());
					hd.setSoBan(hoaDon.getSoBan());
					btnBan[i].setBackground(new Color(255, 0, 102));
				}
			}
		}
		List<HoaDon> hoadon8 = hoadonDAO.listHoaDon();
		List<HoaDon> hoadon9 = new ArrayList<HoaDon>();
		hoadon9.add(hoadon8.get(0));
		for (HoaDon hoaDon : hoadon9) {
			HoaDon hd = new HoaDon();

			hd.setCthd(hoaDon.getCthd());
			List<ChiTietHoaDon> d = hd.getCthd();
			double d2 = d.get(0).getSoluong();

		}

	}
}
