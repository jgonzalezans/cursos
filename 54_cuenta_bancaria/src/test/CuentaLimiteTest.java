package test;

import model.CuentaLimite;

public class CuentaLimiteTest {

	public static void main(String[] args) {

		CuentaLimite cuentaLimite = new CuentaLimite(500,582.25);
		
		System.out.println(cuentaLimite.getSaldo()+"  "+cuentaLimite.getLimite());
		
		cuentaLimite.ajustarLimite();
		
		System.out.println(cuentaLimite.getSaldo()+"  "+cuentaLimite.getLimite());
		
		cuentaLimite.extraer(10);
		
		cuentaLimite.extraer(100000);
	}

}
