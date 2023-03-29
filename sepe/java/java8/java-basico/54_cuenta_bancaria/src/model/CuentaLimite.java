package model;

/**
 * Crear una subclase de Cuenta que incluya un nuevo atributo limite, que
 * servir� para definir el l�mite m�ximo de dinero que se podr� extraer. Tambi�n
 * incluir� un nuevo m�todo, llamado ajustarLimite (), que establecer�
 * autom�ticamente como l�mite la mitad del saldo existente
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
	 * Ajusta el l�mite a la mitad del saldo existente
	 */
	public void ajustarLimite() {
		limite = getSaldo() / 2;
	}

	@Override
	public void extraer(double cantidad) {
		if (cantidad <= limite) {
			super.extraer(cantidad);
		} else {
			System.err.println("La cantidad a extraer excede el l�mite permitido");
		}
	}

}
