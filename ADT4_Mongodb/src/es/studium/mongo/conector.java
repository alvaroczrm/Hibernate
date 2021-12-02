package es.studium.mongo;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

public class conector {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient conexion = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = conexion.getDatabase("ad");
		
		MongoCollection<Document> alumnos = database.getCollection("studium");
		
		/* Creamos un documento mediante new */
		Document documento = new Document("nombre", "Manolo").append("apellido", "García").append("edad", 28);
		/* Añadimos un único documento */
		alumnos.insertOne(documento);
		
		/* Insertamos varios documentos creados parseando strings */
		alumnos.insertMany(Arrays.asList(
			Document.parse("{ nombre: 'Ana', edad: 25, pagado: true, nota: 7 }"),
			Document.parse("{ nombre: 'Benito', apellido: 'Benítez', edad: 50, nota: 9.8 }"),
			Document.parse("{ nombre: 'Carmen', edad: 31, pagado: false, nota: 3 }")));
		
		conexion.close();
	}
	public static void consultar(MongoCollection<Document> alumnos) {
		/* Buscar todos los alumno */
		FindIterable<Document> buscaTodos = alumnos.find();

		/* Buscar todos los alumnos llamados "Ana" */
		FindIterable<Document> buscaAna = alumnos.find(eq("nombre", "Ana"));

		/* Buscar todos los alumnos que han suspendido (lte operador menor que) */
		FindIterable<Document> busquedaSuspendidos = alumnos.find(lte("nota", 5));

		/* Buscar todos los alumnos llamados Ana que han aprobado */
		FindIterable<Document> buscaAnaAprobados = alumnos.find(and(lte("nombre", "Ana"), gte("nota", 5)));

		/* Recorremos todos los resultados y los mostramos */
		for (Object alumno : busquedaSuspendidos) {
			System.out.println(((Document) alumno).toJson());
		}
	}
}
