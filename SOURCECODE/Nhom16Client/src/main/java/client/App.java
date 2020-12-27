package client;
import java.rmi.Naming;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import daos.HoaDonDAO;
import daos.MonAnUongDAO;
import daos.NhanVienDAO;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.MonAnUong;
import entities.NhanVien;
import entities.TaiKhoan;
import impls.MonAnUongDAOImpl;


public class App {
	public static void main(String[] args) {
		try {

			SecurityManager securityManager = System.getSecurityManager();
			if (securityManager == null) {
				System.setProperty("java.security.policy", "mypolicy\\policy.policy");
				System.setSecurityManager(new SecurityManager());
			}

			MonAnUongDAO monanDAO = (MonAnUongDAO) Naming.lookup("rmi://localhost:17676/monanRemote");
			HoaDonDAO hoadonDAO = (HoaDonDAO) Naming.lookup("rmi://localhost:17676/hoadonRemote");
			NhanVienDAO nhanvienDAO = (NhanVienDAO) Naming.lookup("rmi://localhost:17676/nhanvienRemote");
			
			
			NhanVien nv1 = new NhanVien("NV001", "Nguyễn Văn Anh", true,"ĐANG LÀM VIỆC","42343243242", "NV", "0534342423");
			NhanVien nv2= new NhanVien("NV002", "Đỗ Thanh Sang", true, "ĐANG LÀM VIỆC", "64456645634", "QL", "0903542342");
			NhanVien nv3= new NhanVien("NV003", "Đoàn Kim Định", true, "ĐANG LÀM VIỆC", "64564564234", "NV", "0523542342");
				
			nv1.setTaiKhoan(new TaiKhoan("nguyenvananh", "12345"));
			nv2.setTaiKhoan(new TaiKhoan("dothanhsang", "12345"));
			nv3.setTaiKhoan(new TaiKhoan("doankimdinh", "12345"));
		
			nhanvienDAO.addNhanVien(nv1);
			nhanvienDAO.addNhanVien(nv2);
			nhanvienDAO.addNhanVien(nv3);
			
			MonAnUong monan = new MonAnUong("M000", "Thức uống", "Trà Sữa Thái", 27000, "ĐANG KINH DOANH");
		    monanDAO.addMonAnUong(monan);
			

		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
}