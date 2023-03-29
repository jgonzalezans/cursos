package model;

/**
 * Crear una subclase de Cuenta que incluya un nuevo atributo limite, que
 * servirá para definir el límite máximo de dinero que se podrá extraer. También
 * incluirá un nuevo método, llamado ajustarLimite (), que establecerá
 * automáticamente como límite la mitad del saldo existente
 * 
 * @author joseg
 *
 */
public class CuentaLimite extends Cuenta {

	private double limite;

	public CuentaLimite(double saldo, double limite) {
		super(saldo);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	/**
	 * Ajusta el límite a la mitad del saldo existente
	 */
	public void ajustarLimite() {
		limite = getSaldo() / 2;
	}

	@Override
	public void extraer(double cantidad) {
		if (cantidad <= limite) {
			super.extraer(cantidad);
		} else {
			System.err.println("La cantidad a extraer excede el límite permitido");
		}
	}

}
