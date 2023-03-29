package com.canos.java.java7;

public class StringSwitch {

	public static void main(String... args) {
		
		/**
		 * Un switch previo a Java SE 7
		 */
		Integer type = 6;		
		switch(type) {
			case 5: 
				log("ACIERTO");
				break;
			default:
				log("NO ACIERTO");
				break;
		}


		/**
		 * Un Switch donde el objeto a comparar es un String
		 */
		String typeString = "5";
		switch(typeString) {
			case "5": 
				log("ACIERTO");
				break;
			default:
				log("NO ACIERTO");
				break;
		}


        /**
         * En versiones anteriores a Java 7, Switch con enum
         */
        DayOfWeek dia = DayOfWeek.FRIDAY;
        switch(dia) {
            case FRIDAY:
                break;
            case THURSDAY:
            default:
                break;
        }

		
	}
	
	private static void log(Object o) {
		System.out.println(o.toString());
	}
}
