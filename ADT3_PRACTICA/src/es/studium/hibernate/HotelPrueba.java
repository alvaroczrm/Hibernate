package es.studium.hibernate;

import java.util.Scanner;

import javax.persistence.Column;

public class HotelPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Seleccione una opción");
		System.out.println("1. Crear usuario");
		System.out.println("2. Leer usuario");
		System.out.println("3. Actualizar usuario");
		System.out.println("4. Borrar usuario");
		int opcion = sc.nextInt();
		sc.nextLine();
		
		switch (opcion) {
		case 1:{
			System.out.println("Creación de cliente");
			System.out.println("Introduce el nombre");
			 String nC= sc.nextLine(); //nombre
			System.out.println("Introduce el apellido");
			 String aC= sc.nextLine(); //apellido
			System.out.println("Introduce el email");
			 String eC= sc.nextLine();//email
			System.out.println("Introduce el DNI");
			 String dC= sc.nextLine();//dni
			System.out.println("Introduce la clave");
			 String cC= sc.nextLine();//clave
			 Clientes c1 = new Clientes(nC, aC, eC, dC, cC);
			 try {
				 System.out.println("Cliente creado "+nC+" "+aC+" "+eC+" "+dC+" "+cC);
				 HotelManager.createClientes(c1);
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			break;
		}
		case 2:{
		System.out.println("Introduce el ID");
		int id = sc.nextInt();
		HotelManager.readClientes(id);
			break;
		}
		case 3:{
		System.out.println("Introduce un id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("introduce el apellido");
		String ap = sc.nextLine();
		HotelManager.updateClientes(id, ap);
			break;
		}
		case 4:{
			System.out.println("Introduce un id");
			int id = sc.nextInt();
			HotelManager.deleteCliente(id);
			break;
		}
		}
	}

}
