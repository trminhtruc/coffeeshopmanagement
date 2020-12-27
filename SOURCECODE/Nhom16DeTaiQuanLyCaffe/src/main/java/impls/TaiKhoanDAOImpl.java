package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import daos.TaiKhoanDAO;
import entities.TaiKhoan;

public class TaiKhoanDAOImpl extends UnicastRemoteObject implements TaiKhoanDAO {
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public TaiKhoanDAOImpl() throws RemoteException {
		em = DAO_EntityManager.getInstance().getEntityManager();
	}

	/**
	 * 
	 */

	@Override
	public TaiKhoan findId(String id) throws RemoteException {
		return em.find(TaiKhoan.class, id);
	}

	@Override
	public List<TaiKhoan> listTaiKhoan() throws RemoteException {
		Query query = em.createNamedQuery("find-all-tk", TaiKhoan.class);
		return query.getResultList();
	}

	@Override
	public boolean addTaiKhoan(TaiKhoan taikhoan) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.persist(taikhoan);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return true;
	}

	@Override
	public boolean deleteTaiKhoanId(String id) throws RemoteException {
		try {
			em.getTransaction().begin();
			TaiKhoan tk = findId(id);
			em.remove(tk);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return true;
	}

	@Override
	public boolean updateTaiKhoan(TaiKhoan taikhoan, String matKhau) throws RemoteException {
		try {
			em.getTransaction().begin();
			taikhoan.setMatKhau(matKhau);
			em.merge(taikhoan);
			em.getTransaction().commit();
		

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return true;
	}

}
