package presentacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import model.Pedido;
import service.PedidosService;

public class MenuPedidos {
	static PedidosService service=new PedidosService();
	static DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		//sacar menú, evaluar la opción, procesarla y si es distinto de salir, volver
		//a scar el menú
		do {
			mostrarMenu();
			opcion=sc.nextInt();
			switch(opcion) {
				case 1:
					agregarPedido();
					break;				
				case 2:
					mostrarPedidos();
					break;
					
			}
		}while(opcion!=3);

	}
	static void mostrarMenu() {
		System.out.println("1. Añadir pedido");
		System.out.println("2. Mostrar pedidos");
		System.out.println("3. Salir");
	}
	
	static void agregarPedido() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce producto: ");
		String producto=sc.nextLine();
		System.out.println("Introduce unidades: ");
		int unidades=Integer.parseInt(sc.nextLine());
		System.out.println("Introduce fecha del pedido (dd/MM/yyyy): ");
		try {
			LocalDate fecha=LocalDate.parse(sc.nextLine(),format);
			System.out.println("Introduce tienda: ");
			String tienda=sc.nextLine();
			if(service.altaPedido(new Pedido(0,producto,unidades,fecha,tienda))) {
				System.out.println("Pedido realizado");
			}else {
				System.out.println("Error en el alta de pedido");
			}
		}
		catch(DateTimeParseException ex) {
			System.out.println("Fecha incorrecta, el pedido no se ha añadido");
		}
	}

	static void mostrarPedidos() {
		List<Pedido> pedidos=service.pedidos();
		pedidos.forEach(p->{
			System.out.print("Producto: "+p.getProducto());
			System.out.print("  Unidades: "+p.getUnidades());
			System.out.print("  Fecha: "+p.getFecha().format(format));
			System.out.println();
		});
	}
}
