package com.canos.java.java7;

import java.io.Closeable;
import java.io.FileNotFoundException;

/**
 * Gracias a https://stackoverflow.com/a/37206580/878015
 */
public class SupressedExceptions {

	public static void main(String... args) throws FileNotFoundException {

		/**
		 * El ejercicio consiste en comentar el finally y luego el catch 
		 * para comprender lo que es una suppressed exception
		 */
		try (IOManip ioManip = new IOManip()) {
			throw new RuntimeException("from try!");
		} 
		catch (Exception e) {
			throw new RuntimeException("from catch!");
		} finally {
			throw new RuntimeException("from finally!");
		}

	}

	/*
	 * Para poder utilizar los recursos Automaticamente cerrados, se debe implementar Autocloseable
	 */
	private static class IOManip implements Closeable {
		@Override
		public void close() {
			throw new RuntimeException("from IOManip.close");
		}
	}
}
