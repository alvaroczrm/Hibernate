package es.studium.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HotelManager {

	private static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Clientes.class).configure().buildSessionFactory();
		return sessionFactory;
	}
	public static void createClientes(Clientes c) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(c);
		transObj.commit();
		sessionObj.clear();
		System.out.println("Cliente " + c.getIdCliente() + " insertado correctamente");
	}
	/*consulta bd*/
	public static void readClientes(int id){
		String c = "FROM " + Clientes.class.getName()+" where id="+id;		
		Session sessionObj = getSessionFactory().openSession();
		Clientes cliente = (Clientes) sessionObj.createQuery(c).uniqueResult();
		System.out.println("Resultado de busqueda "+cliente.getNombreCliente()+","+cliente.getApellidosCliente()+","+cliente.getEmailCliente()+","+cliente.getDniCliente()+","+cliente.getClaveCliente());
	}
	public static void updateClientes(int id, String apellido) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Clientes clienteupdate = (Clientes) sessionObj.load(Clientes.class, id);
		
		clienteupdate.setApellidosCliente(apellido);
		transObj.commit();
		sessionObj.close();
		System.out.println("Actualizado correctamente");
	}
	public static void deleteCliente(int id) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Clientes hotelbd = (Clientes) sessionObj.load(Clientes.class, id);
		sessionObj.delete(hotelbd);
		transObj.commit();
		sessionObj.close();
		System.out.println("Eliminado correctamente");
	}
}
