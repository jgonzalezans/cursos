package test;

import model.CuentaMovimientos;

public class CuentaMovimientosTest {

	public static void main(String[] args) {

		CuentaMovimientos cuentaMovimientos = new CuentaMovimientos(500, 2500);

		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		cuentaMovimientos.ingresar(100);
		

		cuentaMovimientos.extraer(230);

		cuentaMovimientos.verMovimientos();
	}

}
