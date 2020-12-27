package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import daos.HoaDonDAO;
import entities.ChiTietHoaDon;
import entities.HoaDon;

public class HoaDonDAOImpl extends UnicastRemoteObject implements HoaDonDAO {
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public HoaDonDAOImpl() throws RemoteException {
		em = DAO_EntityManager.getInstance().getEntityManager();
	}

	/**
	 * 
	 */

	@Override
	public HoaDon findId(String id) throws RemoteException {
		return em.find(HoaDon.class, id);
	}

	@Override
	public List<HoaDon> listHoaDon() throws RemoteException {
		Query query = em.createNamedQuery("find-all-hd", HoaDon.class);
		return query.getResultList();
	}

	@Override
	public boolean addHoaDon(HoaDon hoaodon) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.persist(hoaodon);
			em.getTransaction().commit();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		return true;
	}

	@Override
	public boolean deleteHoaDon(String id) throws RemoteException {
		try {
			em.getTransaction().begin();
			HoaDon hoadon = findId(id);
			em.remove(hoadon);
			em.getTransaction().commit();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		return true;
	}

	@Override
	public boolean updateTinhTrangHoaDon(HoaDon hoadon, String tinhTrang) throws RemoteException {
		try {
			em.getTransaction().begin();
			hoadon.setTinhTrang(tinhTrang);
			em.merge(hoadon);
			em.getTransaction().commit();
		

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return true;
	}

	@Override
	public boolean updateChiTietHoaDon(HoaDon hoadon, List<ChiTietHoaDon> cthd) throws RemoteException {
		try {
			em.getTransaction().begin();
			hoadon.setCthd(cthd);
			em.merge(hoadon);
			em.getTransaction().commit();
		

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return true;
	}

	

}
