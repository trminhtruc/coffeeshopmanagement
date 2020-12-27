package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import daos.MonAnUongDAO;
import entities.MonAnUong;

public class MonAnUongDAOImpl extends UnicastRemoteObject implements MonAnUongDAO {
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public MonAnUongDAOImpl() throws RemoteException {
		em = DAO_EntityManager.getInstance().getEntityManager();
	}

	/**
	 * 
	 */

	@Override
	public MonAnUong findAll(String Id) throws RemoteException {
		Query query = em.createNativeQuery("db.MonAnUong.find({'_id':'mon2'})", MonAnUong.class);
		List<MonAnUong> monan = query.getResultList();
		return monan.get(0);
	}

	@Override
	public MonAnUong findId(String id) throws RemoteException {
		return em.find(MonAnUong.class, id);
	}

	@Override
	public List<MonAnUong> listMonAnUong() throws RemoteException {
		Query query = em.createNamedQuery("find-all-mAn", MonAnUong.class);
		return query.getResultList();
	}

	@Override
	public boolean addMonAnUong(MonAnUong monanuong) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.persist(monanuong);
			em.getTransaction().commit();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return true;
	}

	@Override
	public boolean updateMonAnUongDonGia(MonAnUong monanuong, double dongia) throws RemoteException {
		try {
			em.getTransaction().begin();
			monanuong.setDonGia(dongia);
			em.merge(monanuong);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return true;
	}


	@Override
	public boolean updateMonAnUongTen(MonAnUong monanuong, String ten) throws RemoteException {
		try {
			em.getTransaction().begin();
			monanuong.setTen(ten);
			em.merge(monanuong);
			em.getTransaction().commit();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		return true;
	}

	@Override
	public boolean updateTrangThai(MonAnUong monanuong, String trangThai) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			monanuong.setTrangThai(trangThai);
			em.merge(monanuong);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return true;
	}

	

}
