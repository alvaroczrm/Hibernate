package es.studium.hibernate;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Actualizamos la base de datos y volvemos a leer los registros*/
		Dogs p2 = new Dogs( 4, "Pastor Alem�n",4, 5, "Marr�n" );
		testCRUD.updateDogs(p2);
		testCRUD.readDogs();

	}

}
