package principal;

/**
 * a)se cierra
 * b)termina
 * c)termina se cierra
 * d)se cierra error 
 * e)termina error
 * f)error
 * g)se produce una excepción no controlada
 * h)ninguna de las anteriores
 */

 class Cerrable implements AutoCloseable{
	public void close(){
		System.out.println("se cierra");
	}
	public static void main(String[] args) {
		try(Cerrable c=new Cerrable();){
			int x = 3/0;
			System.out.println("termina");
		}
		catch(Exception ex){
			System.out.println("error");
		}

	}

}

