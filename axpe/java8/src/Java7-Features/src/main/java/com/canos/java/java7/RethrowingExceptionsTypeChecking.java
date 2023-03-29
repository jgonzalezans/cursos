package com.canos.java.java7;


public class RethrowingExceptionsTypeChecking {

	static class FirstException extends Exception {}
	static class SecondException extends Exception {}

	public static void main(String[] args) {

		try {
			rethrowException("First");
		} catch (Exception e) {
			log(e.getClass());
			e.printStackTrace();
			log("");
		}

		try {
			rethrowExceptionJavaSE7("Second");
		} catch (FirstException e) {
            log(e.getClass());
            e.printStackTrace();
        } catch (SecondException e) {
            log(e.getClass());
            e.printStackTrace();
        }


        try {
			rethrowExceptionJavaSE7_bis("First");
		} catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Codigo anterior a Java SE 7.
	 * 
	 * Queremos relanzar una excepción. Hay un método en el que pueden ocurrir dos
	 * excepciones. FirstException y SecondException.
	 * 
	 * A la hora de declarar el throws, debemos poner Exception, ya que previamente
	 * desconocemos qué tipo de excepción va a relanzar.
	 *
	 */
	public static void rethrowException(String exceptionName) throws Exception {
		try {
			if (exceptionName.equals("First")) {
				throw new FirstException();
			} else {
				throw new SecondException();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Código a partir de Java SE 7
	 * El compilador de Java SE 7 determinará el tipo de la excepción aunque el catch sea de tipo Exception.
	 * No perderemos el tipo de la excepción.
	 */
	public static void rethrowExceptionJavaSE7(String exceptionName) throws FirstException, SecondException {
		try {
			if (exceptionName.equals("First")) {
				throw new FirstException();
			} else {
				throw new SecondException();
			}
		} catch (Exception e) {
			// en Java 6 esto no se permite
			throw e;
		}
	}
	
	/**
	 * Sigue enviando FirstException porque por inferencia lo obtiene
	 */
	public static void rethrowExceptionJavaSE7_bis(String exceptionName) throws Exception {
		try {
			if (exceptionName.equals("First")) {
				throw new FirstException();
			} 
			else if(exceptionName.equals("Second")){
				throw new SecondException();
			}
			else 
				throw new Exception();
		} catch (Exception e) {
			throw e;
		}
	}

	private static void log(Object o) {
		System.out.println(o.toString());
	}
}
