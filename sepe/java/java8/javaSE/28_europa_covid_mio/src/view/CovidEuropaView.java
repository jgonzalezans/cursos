package view;

import service.CovidEuropaService;

public class CovidEuropaView {

	public static void main(String[] args) {
		CovidEuropaService service=new CovidEuropaService();
		System.out.println("-------Poblaci�n de todos los continentes:-------");
		System.out.println(service.nombresPaises());
	}

}
