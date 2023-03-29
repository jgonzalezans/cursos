package principal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class TestMongo {

	public static void main(String[] args) {
		String servidor="localhost";
		int puerto=27017;
		//conexión con MongoDB
		MongoClient client=new MongoClient(servidor,puerto);
		//conexión con la base de datos
		MongoDatabase db=client.getDatabase("academia");
		//referencia a la colección
		MongoCollection<Document> alumnos=db.getCollection("alumnos");
		//creamos un nuevo alumno y lo añadimos a la colección
		Map<String,Object> tabla=new HashMap<>();
		tabla.put("nombre", "alumno eclipse");
		tabla.put("edad", 36);
		tabla.put("dni", "e4444");
		tabla.put("cursos", List.of("Python","JavaScript"));
		alumnos.insertOne(new Document(tabla));
		System.out.println("Alumno añadido!");
		//buscar alumnos mayores de 30
		//filtro   {"edad":{"$gt":30}}
		BasicDBObject filtro=new BasicDBObject("edad", new BasicDBObject("$gt", 30));
		FindIterable<Document> it=alumnos.find(filtro);
		MongoCursor<Document> cursor=it.iterator();
		while(cursor.hasNext()) {
			Document doc=cursor.next();
			System.out.println("Nombre: "+doc.get("nombre")+" Cursos: "+doc.get("cursos"));
		}
		
		
	}

}
