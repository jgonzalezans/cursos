package service;

import java.util.List;
import java.util.stream.Collectors;

import model.Producto;

public class ProductosService {
	
	List<Producto> productos=List.of(new Producto("pan",1.5,10,"alimentaci�n"),
			new Producto("vino",5.3,5,"alimentaci�n"),
			new Producto("servilletas",1.9,18,"hogar"),
			new Producto("detergente",4.5,20,"hogar"),
			new Producto("pantalla",60.7,3,"inform�tica"),
			new Producto("cerveza",3.2,30,"alimentaci�n"),
			new Producto("bicicleta",150,4,"deportes"));
	
	//total de productos de la secci�n indicada
	public int totalProductos(String seccion) {
		return productos.stream()
				.filter(p->p.getSeccion().equals(seccion))
				.mapToInt(p->p.getStock()) //genera un IntStream con los stock
				.sum();				
	}
	
	//precio medio de los productos de la secci�n indicada
	public double precioMedioSeccion(String seccion) {
		return productos.stream()
			.filter(p->p.getSeccion().equals(seccion))
			.mapToDouble(p->p.getPrecio()) //DoubleStream con los precios
			.average() //OptionalDouble
			.orElse(0.0);
	}
	
	//precio del producto m�s caro
	public double precioMasCaro() {
		return productos.stream()
				.mapToDouble(p->p.getPrecio()) //DoubleStream con los precios
				.max() //OptionalDouble
				.orElse(-1); //devolvemos -1 si no hubiera un m�ximo
	}
	
	
	//indica si existe el producto recibido como par�metro
	public boolean existeProducto(String nombre) {
		return productos.stream()
				.anyMatch(p->p.getNombre().equals(nombre));
	}
	
	
	//nombre del producto m�s caro
	public String productoMasCaro() {
		return productos.stream()
				.max((p1,p2)->p1.getPrecio()>p2.getPrecio()?1:-1) //Optional<Producto>
				.get() //Producto
				.getNombre();
	}
	
	//devuelva el producto cuyo nombre se recibe como par�metro, si no existe que devuelva null
	
	public Producto getProductoByName(String name) {
		
	 return productos.stream()
	.filter(p->p.getNombre().equals(name))
	.findFirst()
	.orElse(null);
	 
	}
	 //lista de productos de la secci�n recibida como par�metro
	 
	public List<Producto> getProductosBySeccion(String seccion) {
	 return productos.stream()
			.filter(p->p.getSeccion().equals(seccion))
			.collect(Collectors.toList());
	}
	 //lista de nombres de productos cuyo stock sea mayor que el pasado por parametro
	
	public List<String> getProductNamesByStock(Integer stock){
	return
	productos.stream()
	.filter(p->p.getStock()>=stock)
	.map(p->p.getNombre())
	.collect(Collectors.toList());
	}
}
