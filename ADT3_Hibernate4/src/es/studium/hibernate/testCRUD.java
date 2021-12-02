package es.studium.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testCRUD {

		private static SessionFactory getSessionFactory() {
			SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Dogs.class).configure().buildSessionFactory();
			return sessionFactory;
		}
		public static void create(Dogs d) {
			Session sessionObj = getSessionFactory().openSession();
			Transaction transObj = sessionObj.beginTransaction();
			sessionObj.save(d);
			transObj.commit();
			sessionObj.close();
		}
		public static List<Dogs> readDogs() {
			/*Dogs es el nombre de la clase POJO*/
			// String c = "FROM Dogs";
			/*También odemos expresar así la consulta*/
			String c = "FROM " + Dogs.class.getName();
			Session sessionObj = getSessionFactory().openSession();
			List<Dogs> results = sessionObj.createQuery(c).list();
			Iterator<Dogs> iterator = results.iterator();
			while (iterator.hasNext()) {
			Dogs M2 = iterator.next();
			System.out.println(
			M2.getRaza() + " - " + M2.getColor() + " - " +
			M2.getTamano() + " - " + M2.getEdad());
			}
			sessionObj.close();
			return results;
			}
		public static void updateDogs(Dogs d) {
			Session sessionObj = getSessionFactory().openSession();
			Transaction transObj = sessionObj.beginTransaction();
			Dogs d1 = (Dogs) sessionObj.load(Dogs.class, d.getId());
			/* Modificamos todos los atributos */
			
			transObj.commit();
			sessionObj.close();
			System.out.println("Actualizado correctamente");
			}
		public static void deleteDogs(Dogs perro) {
			Session sessionObj = getSessionFactory().openSession();
			Transaction transObj = sessionObj.beginTransaction();
			Dogs d1 = (Dogs) sessionObj.load(Dogs.class,perro.getId());
			sessionObj.delete(d1);
			transObj.commit();
			sessionObj.close();
			System.out.println("Eliminado correctamente");
			}

}
