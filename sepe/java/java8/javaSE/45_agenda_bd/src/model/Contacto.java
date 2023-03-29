package model;

public class Contacto {
	private int idcontacto;
	private String nombre;
	private String email;
	private int numero;
	public Contacto(int idcontacto, String nombre, String email, int numero) {
		super();
		this.idcontacto = idcontacto;
		this.nombre = nombre;
		this.email = email;
		this.numero = numero;
	}
	public Contacto() {
		super();
	}
	public int getIdcontacto() {
		return idcontacto;
	}
	public void setIdcontacto(int idcontacto) {
		this.idcontacto = idcontacto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
