package net.canos.java8.lambdas;

/**
 * Agradecimientos a la wikipedia
 * https://en.wikipedia.org/wiki/Anonymous_function#Java
 * 
 * @author David Canós
 * Twitter @Canos
 */
public class Lambda_003_Calculadora {
	
	/*
	 * Estudiemos la interfaz primero
	 */
	@FunctionalInterface
    interface IntegerMath {
        int operation(int a, int b);
    }
	
	
	public static void main(String... args) {
		/*
		 * Definimos las operaciones
		 */
        IntegerMath addition = new IntegerMath() {
        	public int operation(int a, int b) {
        		return a + b;	
        	}
        };
        IntegerMath subtraction = (a, b) -> a - b;
        IntegerMath multi = (a, b) -> a * b;
        IntegerMath division = (a, b) -> a / b;
        
        /* 
         * Aplicamos las operaciones. Estilo orientado a objetos.
         */
        System.out.println("40 + 2 = " + addition.operation(40, 2));
        System.out.println("20 - 10 = " + subtraction.operation(20, 10)); 
        
        /*
         * En un estilo mucho más funcional y mucho menos orientado a objetos.
         */
        System.out.println("40 + 2 = " + apply(40, 2, addition));
        System.out.println("20 - 10 = " + apply(20, 10, subtraction)); 
        System.out.println("20 * 10 = " + apply(20, 10, multi)); 
    }

    private static int apply(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }


}