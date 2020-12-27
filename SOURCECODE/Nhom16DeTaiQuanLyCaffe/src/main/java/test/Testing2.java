package test;

import java.awt.peer.SystemTrayPeer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import daos.ChiTietHoaDonDAO;
import daos.HoaDonDAO;
import daos.MonAnUongDAO;
import daos.NhanVienDAO;
import daos.TaiKhoanDAO;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.MonAnUong;
import entities.NhanVien;
import entities.TaiKhoan;
import impls.ChiTietHoaDonDAOImpl;
import impls.HoaDonDAOImpl;
import impls.MonAnUongDAOImpl;
import impls.NhanVienDAOImpl;
import impls.TaiKhoanDAOImpl;

public class Testing2 {
	public static void main(String[] args) {
		try {
//			MonAnUongDAO monan = new MonAnUongDAOImpl();
//		//	monan.addMonAnUong(new MonAnUong("23", "cafffe", 1234, 6));
//		//	System.out.println(monan.findId("23").getMaMonAnUong());
//			boolean listma =  monan.updateMonAnUongDonGia(monan.findId("23"), 99);
//			System.out.println(monan.findId("23").getSoLuong());
//			monan.deleteMonAnUong("23");
			HoaDonDAO hoadon = new HoaDonDAOImpl();
			HoaDon hd = new HoaDon("hd12", LocalDate.now(), "chua thanh toan");
			// MonAnUong monanuong = new MonAnUong("mon1","thuc uong", "che", 34, 534);
			// MonAnUong monaniong2 = new MonAnUong("mon3","mon an", "che2", 344, 34);
			List<ChiTietHoaDon> listanuong = new ArrayList<ChiTietHoaDon>();

			ChiTietHoaDon ct1 = new ChiTietHoaDon(4);
			ChiTietHoaDon ct2 = new ChiTietHoaDon(66);
			ct1.setMaAnUong(new MonAnUongDAOImpl().findId("mon1"));
			ct1.setSoluong(3);
			ct2.setMaAnUong(new MonAnUongDAOImpl().findId("mon3"));
			listanuong.add(ct1);
			listanuong.add(ct2);
			hd.setCthd(listanuong);
			ChiTietHoaDonDAO cthoadon = new ChiTietHoaDonDAOImpl();

			// hd.setNhanVien(new NhanVienDAOImpl().findId("nv001"));
			MonAnUongDAO mo = new MonAnUongDAOImpl();
			// mo.updateMonAnUongDonGia(mo.findId("M005"), 9999999);
			HoaDonDAO hh8 = new HoaDonDAOImpl();
			
			List<HoaDon> hd3 = hoadon.listHoaDon();
			for (HoaDon chiTietHoaDon : hd3) {
				System.out.println(chiTietHoaDon.getMaHoaDon());
				System.out.println(chiTietHoaDon.getCthd().get(0).getSoluong());
			}
			
			List<ChiTietHoaDon> cthoadon3 = hd3.get(0).getCthd();
			for (ChiTietHoaDon hoaDon23 : cthoadon3) {
				System.out.println(hoaDon23.getSoluong());
				System.out.println(hoaDon23.getMaAnUong());
			}
			// cthoadon.addChiTiet(ct1);
			// cthoadon.addChiTiet(ct2);
			// hoadon.addHoaDon(hd);

			// cthoadon.addChiTiet(ct1);
			// cthoadon.addChiTiet(ct2);

			TaiKhoanDAO taikhoan = new TaiKhoanDAOImpl();
			TaiKhoan tk1 = new TaiKhoan("doankimdinh2", "12349");
			NhanVienDAO nhanvien = new NhanVienDAOImpl();
			// NhanVien nv1 = new NhanVien("nv002", "Đoàn kim định", "123", "QL");
			// nv1.setTaiKhoan(tk1);

			// NhanVien nv2 = new NhanVien("nv004", "nguyenthianh", "04234234", "NV");
			// nv2.setTaiKhoan(new TaiKhoan("nguyenthianh", "12345"));

			// nhanvien.addNhanVien(nv2);
			// taikhoan.addTaiKhoan(tk1);
			// nhanvien.addNhanVien(nv1);
			// taikhoan.updateTaiKhoan(new TaiKhoanDAOImpl().findId("doankimdinh"),
			// "99999");
//			ChiTietHoaDon ct = cthoadon.findAll2();
//			System.out.println(ct.getSoluong());
//			List<NhanVien> nvl = nhanvien.listNhanVien();
//			nvl.forEach(x->{
//				System.out.println(x.getMaNhanVien());
//			});
//			List<MonAnUong> listmon = new MonAnUongDAOImpl().listHoaDon();
//			listmon.forEach(x->{
//				System.out.println(x.getMaMonAnUong());
//			});
			NhanVienDAO nvdao = new NhanVienDAOImpl();
			NhanVien nv = new NhanVien("NV002", "ĐỖ THANH SANG", false, "ĐANG LÀM VIỆC", "434234232", "QL",
					"07567567123");
			nv.setTaiKhoan(new TaiKhoan("dothanhsang", "12345"));
			// nvdao.addNhanVien(nv);
			// nvdao.updatePassWord(nvdao.findId("NV001"), "323");
			// HoaDon listhoadon = hoadon.findChiTiet("4");
			// System.out.println(listhoadon);
			// List<HoaDon> listhoadon2 = hoadon.listHoaDon();
//			for (HoaDon hoaDon2 : listhoadon2) {
//				//System.out.println(hoaDon2.getTinhTrang());
//			}
//			for (HoaDon chiTietHoaDon : listhoadon) {
//				System.out.println(chiTietHoaDon.getCthd().get(0).getSoluong());
//			//	System.out.println(chiTietHoaDon.getMaAnUong().getTen());
//			}
			// System.out.println(listhoadon.get(0).getCthd().get(0).getSoluong()+"so
			// luong");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
