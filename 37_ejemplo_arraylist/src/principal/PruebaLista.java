package principal;

import java.util.ArrayList;

public class PruebaLista {

	public static void main(String[] args) {
		ArrayList<Integer> lista=new ArrayList<>();
		lista.add(300);
		lista.add(120);
		lista.add(44);
		lista.add(1, 500);
		
		for(int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i));
		}
		for(int n:lista) {
			System.out.println(n);
		}
		/*Integer num=7;
		num=num*num;
		System.out.println(num);*/
		
		
	}

}
