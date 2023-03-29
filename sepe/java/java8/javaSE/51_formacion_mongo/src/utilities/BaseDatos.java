package utilities;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class BaseDatos {
	public static MongoClient getConnection() {
		String servidor="localhost";
		int puerto=27017;
		//conexión con MongoDB
		MongoClient client=new MongoClient(servidor,puerto);
		
		return client;
		
	}
}
