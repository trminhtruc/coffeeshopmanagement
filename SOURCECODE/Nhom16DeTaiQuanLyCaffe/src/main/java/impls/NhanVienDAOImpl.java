package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import daos.NhanVienDAO;
import entities.NhanVien;
import entities.TaiKhoan;

public class NhanVienDAOImpl extends UnicastRemoteObject implements NhanVienDAO {
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public NhanVienDAOImpl() throws RemoteException {
		em = DAO_EntityManager.getInstance().getEntityManager();
	}

	/**
	 * 
	 */

	@Override
	public NhanVien findId(String id) throws RemoteException {
		return em.find(NhanVien.class, id);
	}

	@Override
	public List<NhanVien> listNhanVien() throws RemoteException {
		Query query = em.createNamedQuery("find-all-nv", NhanVien.class);
		return query.getResultList();
	}

	@Override
	public boolean addNhanVien(NhanVien nhanvien) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.persist(nhanvien);
			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return true;
	}

	@Override
	public boolean deleteNhanVien(String manhanvien) throws RemoteException {

		try {
			em.getTransaction().begin();
			NhanVien nhanvien = findId(manhanvien);
			em.remove(nhanvien);
			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return true;
	}

	@Override
	public boolean updateTenNhanVien(NhanVien nhanvien, String ten) throws RemoteException {
		try {
			em.getTransaction().begin();
			nhanvien.setTenNhanVien(ten);
			em.merge(nhanvien);
			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return true;
	}

	@Override
	public boolean updateCMNDNhanVien(NhanVien nhanvien, String cmnd) throws RemoteException {
		try {
			em.getTransaction().begin();
			nhanvien.setCmnd(cmnd);
			em.merge(nhanvien);
			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return true;
	}

	@Override
	public boolean updateTrangThai(NhanVien nhanvien, String trangThai) throws RemoteException {
		try {
			em.getTransaction().begin();
			nhanvien.setTrangThai(trangThai);
			em.merge(nhanvien);
			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return true;
	}

	@Override
	public boolean updateSDT(NhanVien nhanVien, String sdt) throws RemoteException {
		try {
			em.getTransaction().begin();
			nhanVien.setSdt(sdt);
			em.merge(nhanVien);
			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return true;
	}

	@Override
	public boolean updatePassWord(NhanVien nhanvien, String matKhauMoi) throws RemoteException {
		try {
			em.getTransaction().begin();
			TaiKhoan tk = new TaiKhoan(nhanvien.getTaiKhoan().getTenTaiKhoan(), matKhauMoi);
			nhanvien.setTaiKhoan(tk);
			em.merge(nhanvien);
			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return true;
	}
	
	@Override
	public boolean updateChucVu(NhanVien nhanvien, String chucVu) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			nhanvien.setChucVu(chucVu);
			em.merge(nhanvien);
			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return true;
	}
}