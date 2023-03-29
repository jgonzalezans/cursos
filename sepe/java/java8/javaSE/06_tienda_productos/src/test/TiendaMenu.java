package test;

import java.util.List;
import java.util.stream.Collectors;

import model.Producto;

public class TiendaMenu {

	public static void main(String[] args) {

		List<Producto> productos=List.of(new Producto("pan",1.5,10,"alimentaci�n"),
				new Producto("vino",5.3,5,"alimentaci�n"),
				new Producto("servilletas",1.9,18,"hogar"),
				new Producto("detergente",4.5,20,"hogar"),
				new Producto("pantalla",60.7,3,"inform�tica"),
				new Producto("cerveza",3.2,30,"alimentaci�n"),
				new Producto("bicicleta",150,4,"deportes"));
		
		
		String seccion = "hogar";
		
		//total de productos de la secci�n indicada
		
		System.out.println(
				"Total de productos de la secci�n "+seccion+": "+ 
				productos.stream()
				.filter(p->p.getSeccion().equals(seccion))
				.count());

		//precio medio de los productos de la secci�n indicada
		
		System.out.println(
				"Precio medio de los productos de la secci�n "+seccion+": "+
				productos.stream()
				.filter(p->p.getSeccion().equals(seccion))
				.mapToDouble(e->e.getPrecio())
				.average()
				.orElse(0)
				);

		//precio del producto m�s caro
		
		System.out.println(
				"Precio del producto m�s caro: "+
				productos.stream()
				.mapToDouble(p->p.getPrecio())
				.max()
				.orElse(0)
				);
		
		//si existe el producto indicado como parametro
		String nombre = "vino";
				productos.stream()
				.anyMatch(p->p.getNombre().equals(nombre));
				

		//nombre del producto m�s caro
		System.out.println(
		"Nombre del producto m�s caro: "+
		productos.stream()
		.max((a,b)->a.getPrecio()>b.getPrecio()?1:-1)
		.get()
		.getNombre()
		);
		
     		//devuelva el producto cuyo nombre se recibe como par�metro, si no existe que devuelva null
			
		    String nombreProducto = "nombre";
			
			 productos.stream()
			.filter(p->p.getNombre().equals(nombreProducto))
			.findFirst()
			.orElse(null);
			
			
		
		//lista de productos de la secci�n recibida como par�metro
			 
			productos.stream()
					.filter(p->p.getSeccion().equals(seccion))
					.collect(Collectors.toList());
					
		//lista de nombres de productos cuyo stock sea mayor que el pasado por parametro
			
			Integer stock = 0;
			
			System.out.println(
			productos.stream()
			.filter(p->p.getStock()>=stock)
			.map(p->p.getNombre())
			.collect(Collectors.toList()));
		
	}

}
