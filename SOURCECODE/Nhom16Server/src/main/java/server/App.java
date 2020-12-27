package server;

/**
 * Hello world!
 *
 */

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import daos.ChiTietHoaDonDAO;
import daos.HoaDonDAO;
import daos.MonAnUongDAO;
import daos.NhanVienDAO;
import daos.TaiKhoanDAO;
import impls.ChiTietHoaDonDAOImpl;
import impls.HoaDonDAOImpl;
import impls.MonAnUongDAOImpl;
import impls.NhanVienDAOImpl;
import impls.TaiKhoanDAOImpl;

public class App {
	public static void main(String[] args) {
		try {

			SecurityManager securityManager = System.getSecurityManager();
			if (securityManager == null) {
				System.setProperty("java.security.policy", "mypolicy\\policy.policy");
				System.setSecurityManager(new SecurityManager());
			}

			MonAnUongDAO monanDAO = new MonAnUongDAOImpl();
			HoaDonDAO hoaDonDAO = new HoaDonDAOImpl();
			NhanVienDAO nhanvienDAO = new NhanVienDAOImpl();
		

			LocateRegistry.createRegistry(17676);
			Naming.rebind("rmi://localhost:17676/monanRemote", monanDAO);
			Naming.rebind("rmi://localhost:17676/hoadonRemote",hoaDonDAO );
			Naming.rebind("rmi://localhost:17676/nhanvienRemote", nhanvienDAO);
	
			System.out.println("Server is ready ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}