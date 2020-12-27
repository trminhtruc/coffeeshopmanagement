package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.text.TabExpander;

//import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JDateChooser;

import daos.ChiTietHoaDonDAO;
import daos.HoaDonDAO;
import daos.MonAnUongDAO;
import daos.NhanVienDAO;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import java.awt.SystemColor;

public class GUI_QLHoaDon extends JPanel {
	private JTable tableHoaDon;
	private JTable tableChiTiet;
	private JTextField txtDoanhThu;
	private DefaultTableModel modelHoaDon, modelChiTiet;
	private Map<String, HoaDon> keyvalue = new HashMap<String, HoaDon>();

	HoaDonDAO hoadonDAO;
	MonAnUongDAO monanDAO;
	NhanVienDAO nhanvienDAO;
	ChiTietHoaDonDAO chitietDAO;
	private JTextField txtTongHoaDon;

	/**
	 * Create the panel.
	 */
	public GUI_QLHoaDon() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setSize(1142, 705);
	
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
		Border matterBorder = new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(0, 0, 1142, 705);
		add(panel);
		panel.setLayout(null);

		JDateChooser dateBatDau = new JDateChooser();
		dateBatDau.setBackground(UIManager.getColor("CheckBox.light"));
		dateBatDau.setBounds(612, 101, 138, 20);
		panel.add(dateBatDau);

		JDateChooser dateKetThuc = new JDateChooser();
		dateKetThuc.setBackground(UIManager.getColor("CheckBox.light"));
		dateKetThuc.setBounds(894, 101, 138, 20);
		panel.add(dateKetThuc);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(452, 27, 206, 41);
		panel.add(lblNewLabel);

		JLabel lblNgay_1 = new JLabel("Từ Ngày:");
		lblNgay_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNgay_1.setBackground(UIManager.getColor("CheckBox.light"));
		lblNgay_1.setBounds(531, 107, 73, 14);
		panel.add(lblNgay_1);

		JLabel lblNgay_2 = new JLabel("Đến Ngày:");
		lblNgay_2.setBackground(UIManager.getColor("CheckBox.light"));
		lblNgay_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNgay_2.setBounds(806, 107, 69, 14);
		panel.add(lblNgay_2);

		JScrollPane scrollPaneHoaDon = new JScrollPane();
		scrollPaneHoaDon.setBounds(10, 186, 662, 392);
		panel.add(scrollPaneHoaDon);

		tableHoaDon = new JTable();
		tableHoaDon.setModel(modelHoaDon = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã Hóa Đơn", "Tên Nhân Viên", "Ngày Lập", "Tổng Tiền (VND)" }));
//
		tableHoaDon.setFont(new Font("Verdana", Font.PLAIN, 11));
		scrollPaneHoaDon.setViewportView(tableHoaDon);
		scrollPaneHoaDon.setBorder(compound);
		scrollPaneHoaDon.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneHoaDon.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JScrollPane scrollPaneChiTiet = new JScrollPane();
		scrollPaneChiTiet.setBounds(698, 186, 434, 442);
		panel.add(scrollPaneChiTiet);

		tableChiTiet = new JTable();
		tableChiTiet.setModel(modelChiTiet = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã Hóa Đơn", "Tên Sản Phẩm", "Số Lượng", "Thành Tiền (VND)" }));
		tableChiTiet.setFont(new Font("Verdana", Font.PLAIN, 11));
		scrollPaneChiTiet.setViewportView(tableChiTiet);
		scrollPaneChiTiet.setBorder(compound);
		scrollPaneChiTiet.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneChiTiet.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JLabel lblDSHD = new JLabel("Danh Sách Hóa Đơn");
		lblDSHD.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDSHD.setBounds(23, 161, 155, 14);
		panel.add(lblDSHD);

		JLabel lblChiTietHD = new JLabel("Chi Tiết Hóa Đơn");
		lblChiTietHD.setFont(new Font("Verdana", Font.BOLD, 12));
		lblChiTietHD.setBounds(715, 161, 155, 14);
		panel.add(lblChiTietHD);

		JButton btnSearch = new JButton("");
		btnSearch.setBounds(1042, 98, 36, 26);
		panel.add(btnSearch);
		btnSearch.setBorder(raisedBevel);
		try {
			Image change = ImageIO.read(getClass().getResource("/img/icon-change-pass.png"));
			btnSearch.setIcon(new ImageIcon(change));

			JLabel lblDoanhThu = new JLabel("Tổng Doanh Thu:");
			lblDoanhThu.setFont(new Font("Verdana", Font.BOLD, 12));
			lblDoanhThu.setBounds(361, 602, 138, 26);
			panel.add(lblDoanhThu);

			txtDoanhThu = new JTextField();
			txtDoanhThu.setBackground(UIManager.getColor("CheckBox.light"));
			txtDoanhThu.setFont(new Font("Verdana", Font.BOLD, 12));
			txtDoanhThu.setBounds(509, 598, 149, 30);
			panel.add(txtDoanhThu);
			txtDoanhThu.setColumns(10);
			txtDoanhThu.setBorder(matterBorder);
			
			JLabel lblTongHoaDon = new JLabel("Tổng số hóa đơn");
			lblTongHoaDon.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblTongHoaDon.setBounds(26, 607, 121, 16);
			panel.add(lblTongHoaDon);
			
			txtTongHoaDon = new JTextField();
			txtTongHoaDon.setFont(new Font("Verdana", Font.BOLD, 12));
			txtTongHoaDon.setColumns(10);
			txtTongHoaDon.setBackground(UIManager.getColor("CheckBox.light"));
			txtTongHoaDon.setBounds(143, 598, 149, 30);
			txtTongHoaDon.setBorder(matterBorder);
			panel.add(txtTongHoaDon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		updateDuLieu();
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String date1 = ((JTextField) dateBatDau.getDateEditor().getUiComponent()).getText();
				String date2 = ((JTextField) dateKetThuc.getDateEditor().getUiComponent()).getText();
				int ngay1, ngay2, thang1, thang2, nam1, nam2;
				ngay1 = Integer.parseInt(date1.substring(0, 2));
				thang1 = Integer.parseInt(date1.substring(3, 5));
				nam1 = Integer.parseInt(date1.substring(6, 10));

				ngay2 = Integer.parseInt(date2.substring(0, 2));
				thang2 = Integer.parseInt(date2.substring(3, 5));
				nam2 = Integer.parseInt(date2.substring(6, 10));
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

				try {
					Date dateformat1 = format.parse(date1);
					Date dateformat2 = format.parse(date2);
					System.out.println(dateformat2.compareTo(dateformat1));
					if (dateformat2.compareTo(dateformat1) < 0) {
						JOptionPane.showMessageDialog(null, "NGÀY SAU PHẢI LỚN HƠN HOẶC BẰNG NGÀY TRƯỚC");
					}
					DefaultTableModel dm = (DefaultTableModel) tableHoaDon.getModel();
					dm.setRowCount(0);
					for (HoaDon element : hoadonDAO.listHoaDon()) {
						if (element.getTinhTrang().equals("ĐÃ THANH TOÁN")) {
							String string = String.valueOf(element.getNgayLap().getDayOfMonth()) + "-"
									+ String.valueOf(element.getNgayLap().getMonthValue()) + "-"
									+ String.valueOf(element.getNgayLap().getYear());
							if (format.parse(string).compareTo(dateformat1) >= 0
									&& dateformat2.compareTo(format.parse(string)) >= 0) {
								modelHoaDon.addRow(new Object[] {element.getMaHoaDon(),element.getNhanVien().getTenNhanVien(),element.getNgayLap(),element.tinhThanhTien()});
							}
						}

					}
					// System.out.println(date);
				} catch (ParseException | RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				double tongtien = 0;
				int soluonghoadon = 0;
				for (int i = 0; i < tableHoaDon.getRowCount(); i++) {
					tongtien += Double.parseDouble(String.valueOf(modelHoaDon.getValueAt(i, 3)));
					soluonghoadon+=1;
				}
				
				txtTongHoaDon.setText(String.valueOf(soluonghoadon));

				txtDoanhThu.setText(String.valueOf(tongtien) + "    VND");

			}
		});
		tableHoaDon.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (tableHoaDon.getSelectedRow() == -1) {
					return;
				}
				int row = tableHoaDon.getSelectedRow();
				String ma = modelHoaDon.getValueAt(row, 0).toString();
				try {
					HoaDon hd = hoadonDAO.findId(ma);
					String mahd = hd.getMaHoaDon();

					System.out.println(mahd);
					String ten = null;
					int soluong = 0;
					List<ChiTietHoaDon> list = hd.getCthd();
					DefaultTableModel dm = (DefaultTableModel) tableChiTiet.getModel();
					dm.setRowCount(0);
					for (ChiTietHoaDon ct : list) {
						ten = ct.getMaAnUong().getTen().toString();
						soluong = (int) ct.getSoluong();
						modelChiTiet
								.addRow(new Object[] { mahd, ten, soluong, soluong * ct.getMaAnUong().getDonGia() });
					}

				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}

	public void updateDuLieu() {
		try {
			hoadonDAO = (HoaDonDAO) Naming.lookup("rmi://localhost:17676/hoadonRemote");
			// chitietDAO = (ChiTietHoaDonDAO)
			// Naming.lookup("rmi://localhost:17676/chitietRemote");
			List<HoaDon> hoadonList = hoadonDAO.listHoaDon();
			for (HoaDon hoadon : hoadonList) {
				if (hoadon.getTinhTrang().toUpperCase().equals("ĐÃ THANH TOÁN")) {
					List<ChiTietHoaDon> list = hoadon.getCthd();
					double tongtien = 0;
					for (ChiTietHoaDon ct : list) {
						tongtien += ct.getSoluong() * ct.getMaAnUong().getDonGia();
					}
					modelHoaDon.addRow(new Object[] { hoadon.getMaHoaDon(), hoadon.getNhanVien().getTenNhanVien(),
							hoadon.getNgayLap(), tongtien });
				}
			}
			double tongtien = 0;
			int soluonghoadon = 0;
			for (int i = 0; i < tableHoaDon.getRowCount(); i++) {
				tongtien += Double.parseDouble(String.valueOf(modelHoaDon.getValueAt(i, 3)));
				soluonghoadon+=1;
			}
			
			txtTongHoaDon.setText(String.valueOf(soluonghoadon));
			txtDoanhThu.setText(String.valueOf(tongtien) + "    VND");

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
}
