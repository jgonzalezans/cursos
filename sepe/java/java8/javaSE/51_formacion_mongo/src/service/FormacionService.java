package service;

import java.util.ArrayList;
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

import model.Curso;
import utilities.BaseDatos;

public class FormacionService {
	public List<Curso> cursosPrecioMax(double precio) {
		ArrayList<Curso> cursos = new ArrayList<>();
		try (MongoClient client = BaseDatos.getConnection();) {
			// conexión con la base de datos
			MongoDatabase db = client.getDatabase("formacion");
			MongoCollection<Document> col = db.getCollection("cursos");
			BasicDBObject filtro = new BasicDBObject("precio", new BasicDBObject("$lt", precio));
			FindIterable<Document> it = col.find(filtro);
			MongoCursor<Document> cursor = it.iterator();
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				cursos.add(new Curso(doc.get("nombre"), (Integer) doc.get("duracion"), (Double) doc.get("precio"),
						(String[]) doc.get("asignaturas"), (String) doc.get("horario")));
			}
			return cursos;
		}
	}

	public void nuevoCurso(Curso curso) {
		try (MongoClient client = BaseDatos.getConnection();) {
			// conexión con la base de datos
			MongoDatabase db = client.getDatabase("formacion");
			MongoCollection<Document> col = db.getCollection("cursos");
			Map<String, Object> tabla = new HashMap<>();
			if (curso.getNombre() != null)
				tabla.put("nombre", curso.getNombre());
			if (curso.getDuracion() != 0)
				tabla.put("duracion", curso.getDuracion());
			if (curso.getPrecio() != 0)
				tabla.put("precio", curso.getPrecio());
			if (curso.getAsignaturas() != null)
				tabla.put("asignaturas", curso.getAsignaturas());
			if (curso.getHorario() != null)
				tabla.put("horario", curso.getHorario());
			col.insertOne(new Document(tabla));

		}
	}
}
