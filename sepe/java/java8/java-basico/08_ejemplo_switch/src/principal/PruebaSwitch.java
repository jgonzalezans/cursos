package principal;

public class PruebaSwitch {

	public static void main(String[] args) {
		int x = 5;
		
		switch (x*2) {
		case 5:
			System.out.println("Cerca");
			break;
		case 10 :
			System.out.println("Acierto");
			break;
		case 15 : 
			System.out.println("Lejos");
			break;

		default:
			break;
		}

	}

}
