package es.studium.hibernate;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Actualizamos la base de datos y volvemos a leer los registros*/
		Dogs p2 = new Dogs( 4, "Pastor Alemán",4, 5, "Marrón" );
		testCRUD.updateDogs(p2);
		testCRUD.readDogs();

	}

}
