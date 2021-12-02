package es.studium.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Dogs perro1 = new Dogs();
		perro1.setRaza("Samoyedo");
		perro1.setTamano("Grande");
		perro1.setEdad(2);
		perro1.setColor("Blanco");
		session.save(perro1);
		tx.commit();
		System.out.println("El perro " + perro1.getRaza() + " de tamaño " + perro1.getTamano()
				+ " se ha añadido correctamente a tu base de datos");
	}

	public static List<Dogs> readDogs() {
		/* Dogs es el nombre de la clase POJO */
		// String c = "FROM Dogs";
		/* También odemos expresar así la consulta */
		String c = "FROM " + Dogs.class.getName();
		Session sessionObj = getSessionFactory().openSession();
		List<Dogs> results = sessionObj.createQuery(c).list();
		Iterator<Dogs> perrossiterator = results.iterator();
		while (perrossiterator.hasNext()) {
			Dogs a2 = perrossiterator.next();
			System.out.println(a2.getId() + " - " + a2.getRaza() + " - " + a2.getColor() + " - " + a2.getEdad() + " - "
					+ a2.getTamano());
		}
		sessionObj.close();
		return results;
	}
}
