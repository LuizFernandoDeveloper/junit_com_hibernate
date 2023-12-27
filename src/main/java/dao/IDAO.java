package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;

public interface IDAO<Dao, IdType> {
	
	default EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
		return entityManagerFactory.createEntityManager();
	}
	
	default Dao Register(Dao dao) {
		
		EntityManager entityManager = getEntityManager();
		
		try {
			
			if (dao != null) { // Verifique se o dao não é nulo
				
				entityManager.getTransaction().begin();
				entityManager.persist(dao);
				entityManager.getTransaction().commit();
				
			} else {
				// Lide com o cenário em que dao é nulo
				System.out.println("Tentativa de persistir um dao nulo.");
				
			}
			
		} finally {
			
			end(entityManager);
			
		}
		
		return dao;
	}

	default Dao findById(IdType id) {
		
		EntityManager entityManager = getEntityManager();
		Dao dao = null;

		try {

			entityManager.getTransaction().begin();
			dao = entityManager.find(getEntityClass(), id);
			entityManager.getTransaction().commit();

		} finally {

			end(entityManager);

		}

		return dao;
	}

	default void excluir(Dao dao) {
		
		EntityManager entityManager = getEntityManager();
		
		try {

			entityManager.getTransaction().begin();
			dao = entityManager.merge(dao);
			entityManager.remove(dao);
			entityManager.getTransaction().commit();

		} finally {

			end(entityManager);

		}

	}

	default Dao update(Dao dao) {
		
		EntityManager entityManager = getEntityManager();
		
		try {
			
			entityManager.getTransaction().begin();
			dao = entityManager.merge(dao);
			entityManager.getTransaction().commit();

		} finally {

			end(entityManager);

		}

		return dao;
	}

	default List<Dao> findAll() {
		
		EntityManager entityManager = getEntityManager();
		
		List<Dao> list = new ArrayList<>();
		
	    Class<Dao> entityClass = getEntityClass();

		try {
			
			entityManager.getTransaction().begin();
			list = entityManager.createQuery("SELECT c FROM "+ entityClass.getSimpleName() +" c", getEntityClass()).getResultList();
			entityManager.getTransaction().commit();
			
		} finally {

			end(entityManager);
			
		}

		return list;
	}

	Class<Dao> getEntityClass();

	@After
	default void end(EntityManager entityManager) {
		
		if (entityManager != null && entityManager.isOpen()) {
			
			entityManager.close();
			
		}
	}

}
