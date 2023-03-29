package com.canos.java.java7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GenericsDiamond {

	public static void main(String... args) throws FileNotFoundException {

		/**
		 * Java 5 style
		 */
		List<String> java5List = new ArrayList();
		
		/**
		 * Java 6 style
		 */
		List<String> java6List = new ArrayList<String>();
		Map<Integer,String> java6Map = new HashMap<Integer, String>();
		
		/**
		 * Java 7 style
		 */
		List<String> java7List = new ArrayList<>();
		Map<Integer,String> java7Map = new HashMap<>();
		
	}
	
	/**
	 * java 6 style
	 */
	private static List<String> java6Method(){
		return new ArrayList<String>();
	}

	/**
	 * java7 style
	 */
	private static List<String> java7Method(){
		return new ArrayList<>();
	}
}
