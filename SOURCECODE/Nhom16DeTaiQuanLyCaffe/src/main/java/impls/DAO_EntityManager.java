package impls;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DAO_EntityManager {
	private static DAO_EntityManager instance = null;
	private EntityManager entityManager;
	
	private DAO_EntityManager() {
		entityManager = Persistence.createEntityManagerFactory("Nhom16DeTaiQuanLyCaffe").createEntityManager();
	}
	public synchronized static DAO_EntityManager getInstance() {
		if(instance ==null) {
			instance = new DAO_EntityManager();
		}
		return instance;
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
