package net.canos.java8.lambdas;

/**
 * 
 * @author David Canós
 * Twitter @Canos
 */
public class Lambda_007_DefaultMethodsAdvanced {
	
	public static void main(String... args) {
		// Defino la operación resta
        IntegerMath subtraction = (a, b) -> a - b;
        
        /*
        // Llamada "normal"
        System.out.println("20 - 10 = " + apply(20, 10, subtraction));
        
        // swap() modifica la lambda, antes de ser enviada a apply
        System.out.println("10 - 20 = " + apply(20, 10, subtraction.swap()));  
        */
        
        // swap() llamado concatenando operaciones
        System.out.println(subtraction.swap().operation(20, 10)); 
        System.out.println(subtraction.swap(20, 10));    
    }

    private static int apply(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

	@FunctionalInterface
    interface IntegerMath {
        int operation(int a, int b);

        default IntegerMath swap() {
          return (a, b) -> operation(b, a);
        }
        
        default int swap(int a, int b) {
        	return operation(b, a);
        }
    }
    
}