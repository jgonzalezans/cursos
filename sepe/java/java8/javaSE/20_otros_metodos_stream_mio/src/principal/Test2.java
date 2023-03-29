package principal;

import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		
		List<Integer[]> nums=List.of(new Integer[]{4,1,9,10},
				new Integer[] {8,2},
				new Integer[] {3,11,23,9,1});

				//muestra la suma de todos los elementos de la lista
		
		System.out.println(
	nums.stream()
	.map(l->List.of(l).stream().mapToInt(s->s).sum()).
	mapToInt(m->m)
	.sum());
	

		
	}

}
