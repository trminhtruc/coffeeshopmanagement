package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import daos.ChiTietHoaDonDAO;
import entities.ChiTietHoaDon;
import entities.MonAnUong;

public class ChiTietHoaDonDAOImpl extends UnicastRemoteObject implements ChiTietHoaDonDAO{
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	public ChiTietHoaDonDAOImpl() throws RemoteException {
		
		// TODO Auto-generated constructor stub
		em = DAO_EntityManager.getInstance().getEntityManager();
	}

	/**
	 * 
	 */
	

	@Override
	public ChiTietHoaDon findID(String Id) throws RemoteException {
		return em.find(ChiTietHoaDon.class, Id);
	}

	@Override
	public List<ChiTietHoaDon> findAll() throws RemoteException {
		List<ChiTietHoaDon> t = em.createNamedQuery("find-all-ct", ChiTietHoaDon.class).getResultList();
		return t;
	}

	@Override
	public ChiTietHoaDon findAll2() throws RemoteException {
		Query query = em.createNativeQuery("db.chitiethoadon.find({'soluongct':43})",ChiTietHoaDon.class);
		List<ChiTietHoaDon> resultlist = (List<ChiTietHoaDon>) query.getResultList();
		return resultlist.get(0);
	}

	@Override
	public boolean updateChiTiet(String mamonan, int soluong) throws RemoteException {
		try {
			String t = "db.MonAnUong.updateOne({'_id':'mon2'},{$set:{'ten':'dinh'}})";
			String t2 ="db.MonAnUong.deleteMany({'_id':'mon3'})";
			Query query = em.createNativeQuery(t2,MonAnUong.class);
		//	em.createQuery(Criteria)
		//	em.merge(query);
			
			System.out.println("so luong update"+query.getFirstResult());
			
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
		}
		return true;
	}

	@Override
	public boolean addChiTiet(ChiTietHoaDon chiTietHoaDon) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(chiTietHoaDon);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return false;
	}
	
	
	
}
