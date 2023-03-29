package principal;

import java.util.stream.Stream;

public class Loteria {

	public static void main(String[] args) {
		Stream.generate(()->(int)(Math.random()*49+1))
		.distinct()
		.limit(6)
		.sorted()
		.forEach(n->System.out.println(n));
		
	}

}
