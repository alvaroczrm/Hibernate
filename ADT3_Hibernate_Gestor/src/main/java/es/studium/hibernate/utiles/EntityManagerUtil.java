package es.studium.hibernate.utiles;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	public static EntityManager getEntityManager() {
		/*
		 * En la implementación de este método, creamos un objeto factoría,
		 * EntityManagerFactory, de la librería de persistencia de Java EE.
		 */
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("gestor");

		/*
		 * El objeto EntityManagerFactory lo creamos al llamar al método
		 * createEntityManagerFactory("gestor") método abstracto de la clase Persistence
		 */
		EntityManager manager = factory.createEntityManager();
		return manager;
	}

	public static void main(String[] args) {
		EntityManager manager = EntityManagerUtil.getEntityManager();
		System.out.println("EntityManager class ==> " + manager.getClass().getCanonicalName());
	}

}
