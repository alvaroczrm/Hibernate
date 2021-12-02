package es.studium.hibernate;

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
				System.out.println ("El perro " + perro1.getRaza()+" de tamaño " + perro1.getTamano()+" se ha añadido correctamente a tu base de datos");
	}
}
