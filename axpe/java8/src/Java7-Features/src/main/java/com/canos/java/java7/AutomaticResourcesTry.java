package com.canos.java.java7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AutomaticResourcesTry {

	public static void main(String... args) throws FileNotFoundException {
		
		/**
		 * Gestión no automática de recursos.
		 */
		String path = "src/main/resources/file.txt";
		String firstLine;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
	        firstLine = br.readLine();
	        log(firstLine);
	    } catch (FileNotFoundException e1) {
	    	log("File not found "+e1.getMessage());
	    } catch (IOException e) {
	    	log("IOException "+e.getMessage());
		} finally {
	        if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
			    	log("IOException cerrando recurso "+e.getMessage());
				}
	        }
	    }
	    
		
		/**
		 * Gestión automática de recursos con Java 7
		 */
		try (BufferedReader br2 = new BufferedReader(new FileReader(path))){			
	        firstLine = br2.readLine();
	        log(firstLine);
	    } catch (FileNotFoundException e1) {
	    	log("File not found "+e1.getMessage());
	    } catch (IOException e) {
	    	log("IOException "+e.getMessage());
		} 
		
		
	}
	
	private static void log(Object o) {
		System.out.println(o.toString());
	}
}
