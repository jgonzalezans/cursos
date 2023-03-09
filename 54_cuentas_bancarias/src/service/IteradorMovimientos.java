package service;

import model.Movimiento;

public interface IteradorMovimientos {
	Movimiento siguiente();
	boolean hayMasElementos();
}
