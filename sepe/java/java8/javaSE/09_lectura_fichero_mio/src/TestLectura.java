import java.io.FileReader;

public class TestLectura {

	public static void main(String[] args) {

		String ruta = "testLectura.txt";
		try (FileReader fr = new FileReader(ruta)){
			
		} catch (Exception e) {
		}
	}

}
