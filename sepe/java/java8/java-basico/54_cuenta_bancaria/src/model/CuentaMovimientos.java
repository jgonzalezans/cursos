package model;

import java.util.ArrayList;

/**
 * Crear una subclase de CuentaLimite (la llamamos CuentaMovimientos) que
 * incluya una funcionalidad adicional consistente en devolver los movimientos
 * realizados en la cuenta. Cada movimiento, se caracteriza por un tipo de
 * operación( "ingreso" o "extracción") y una cantidad.
 * 
 * @author joseg
 *
 */

public class CuentaMovimientos extends CuentaLimite {

	ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();

	public CuentaMovimientos(double saldo, double limite) {
		super(saldo, limite);
	}

	public ArrayList<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(ArrayList<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	@Override
	public void ingresar(double cantidad) {
		Movimiento movimiento = new Movimiento("ingreso", cantidad);
		movimientos.add(movimiento);
		super.ingresar(cantidad);
	}
	
	@Override
	public void extraer(double cantidad) {
		Movimiento movimiento = new Movimiento("extracción", cantidad);
		movimientos.add(movimiento);
		super.extraer(cantidad);
	}
	
	public void verMovimientos() {
		
		System.out.println("[Movimientos]");
		for (Movimiento movimiento : movimientos) {
			System.out.println("Tipo: "+movimiento.getTipo()+" Cantidad: "+movimiento.getCantidad());
		}
		
	}

}
