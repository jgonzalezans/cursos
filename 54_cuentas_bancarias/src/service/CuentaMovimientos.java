package service;

import java.util.ArrayList;
import java.util.List;

import model.Movimiento;

public class CuentaMovimientos extends CuentaLimite{
	//en la lista guardamos los movimientos que se producen
	private ArrayList<Movimiento> movimientos=new ArrayList<Movimiento>(); 
	public CuentaMovimientos(double saldo, double limite) {
		super(saldo,limite);
	}
	/*public List<Movimiento> getMovimientos(){
		return movimientos;
	}*/
	//cuando se ingrese o se extraiga, hay que registrar el movimiento
	@Override
	public void extraer(double cantidad) {		
		super.extraer(cantidad);
		Movimiento mov=new Movimiento("extracción",cantidad);
		movimientos.add(mov);
	}
	@Override
	public void ingresar(double cantidad) {
		super.ingresar(cantidad);
		movimientos.add(new Movimiento("ingreso",cantidad));
	}
	
	public IteradorMovimientos iterador() {
		return new IteradorMovimientosImpl();
	}
    class IteradorMovimientosImpl implements IteradorMovimientos{
		int puntero=-1;
		@Override
		public Movimiento siguiente() {
			return movimientos.get(++puntero);
		}

		@Override
		public boolean hayMasElementos() {
			return puntero<(movimientos.size()-1);
		}
		
	}
}
