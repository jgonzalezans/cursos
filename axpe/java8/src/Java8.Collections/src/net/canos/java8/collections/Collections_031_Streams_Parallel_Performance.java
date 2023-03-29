package net.canos.java8.collections;

import java.util.stream.LongStream;

	
public class Collections_031_Streams_Parallel_Performance {

	public static void main(String[] args) {

		
		Long ELEMENTS = 500_000_000l;
		
		/*
		 * PARALLEL PERFORMANCE
		 */
		long b4 = System.currentTimeMillis();
		long r = LongStream.range(0,ELEMENTS)
				.parallel()
				.unordered()
				.filter(l -> l < 500000)				
				.sum();
		System.out.println("MULTI THREAD"+r+" in "+(System.currentTimeMillis() - b4)+"ms");
		
		System.out.println("\n\n");
		long b42 = System.currentTimeMillis();
		long r2 = LongStream.range(0,ELEMENTS)
				.unordered()
				.filter(l -> l < 500000)
				.sum();
		System.out.println("MONO THREAD"+r2+" in "+(System.currentTimeMillis() - b42)+"ms");

		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	private static void log(Object o) {
		System.out.println(Thread.currentThread().getName()+" "+o);
	}

}
