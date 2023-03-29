package com.canos.java.java7;

import java.io.IOException;
import java.sql.SQLException;

public class MultipleCatch {

	public static void main(String[] args) throws IOException, SQLException {
		
		/**
		 * Descomentar primero
		 */
		
		/*
		 * Antes de Java SE 7 
		 	*/
		try {
            if(true)
                throw new IOException();
            else if(!false)
                throw new SQLException();
		}
		catch (IOException ex) {
		     log(ex);
		     throw ex;
		} catch (SQLException ex) {
		     log(ex);
		     throw ex;
		}
		
		/* 
		 * A partir de Java SE 7
		 * NOTA: la excepción ex es final (implicitamente final), nadie puede hacer
		 * ex = new IOException();
		 */
		try {
		    if(true)
		        throw new IOException();
		    else if(!false)
		        throw new SQLException();
		}
		catch (IOException | SQLException ex) {
		    log(ex);
		    throw ex;
		}

	}


	private static void log(Object o) {
		System.out.println(o.toString());
	}
	
}
