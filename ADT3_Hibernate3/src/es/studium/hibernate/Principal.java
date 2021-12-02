package es.studium.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Principal {
	private static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new
		Configuration().configure().buildSessionFactory();
		return sessionFactory;
		}
	public static void create(Movies m) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(m);
		transObj.commit();
		sessionObj.close();
	}
	public static void create(Personas p) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(p);
		transObj.commit();
		sessionObj.close();
	}
	public static List<Movies> readMovies() {
		/*Dogs es el nombre de la clase POJO*/
		// String c = "FROM Dogs";
		/*También odemos expresar así la consulta*/
		String c = "FROM " + Movies.class.getName();
		Session sessionObj = getSessionFactory().openSession();
		List<Movies> results = sessionObj.createQuery(c).list();
		Iterator<Movies> iterator = results.iterator();
		while (iterator.hasNext()) {
		Movies M2 = iterator.next();
		System.out.println(
		M2.getTitulo() + " - " + M2.getDuracion() + " - " +
		M2.getDuracion() + " - " + M2.getIdPelicula());
		}
		sessionObj.close();
		return results;
		}
	public static List<Personas> readPersonas() {
		/*Dogs es el nombre de la clase POJO*/
		// String c = "FROM Dogs";
		/*También odemos expresar así la consulta*/
		String c = "FROM " + Personas.class.getName();
		Session sessionObj = getSessionFactory().openSession();
		List<Personas> results = sessionObj.createQuery(c).list();
		Iterator<Personas> iterator = results.iterator();
		while (iterator.hasNext()) {
		Personas P2 = iterator.next();
		System.out.println(
		P2.getIdPersona() + " - " + P2.getNombre() + " - " +
		P2.getFechaNacimiento() + " - " + P2.getMovieses());
		}
		sessionObj.close();
		return results;
		}
	public static void updateMovies(Movies m1) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Movies m2 = (Movies) sessionObj.load(Movies.class, m2.getIdPelicula());
		/* Modificamos todos los atributos */
		
		transObj.commit();
		sessionObj.close();
		System.out.println("Actualizado correctamente");
		}
	public static void updatePersonas(Personas p1) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Personas p2 = (Personas) sessionObj.load(Personas.class, p2.getIdPersona());
		/* Modificamos todos los atributos */
		
		transObj.commit();
		sessionObj.close();
		System.out.println("Actualizado correctamente");
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movies M2 = new Movies ("Juanillo", "Marbella City", 2021, 140);
	}

}
