package ar.edu.unq.po2.tpfinal.compra;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.app.Celular;
import ar.edu.unq.po2.tpfinal.sem.PuntoDeVenta;

public class RecargaDeCelular extends Compra{
	private Celular celular;
	private double monto;
	
	public RecargaDeCelular(LocalDate fecha, LocalTime hora, PuntoDeVenta punto, Celular celular, double monto) {
		super(fecha, hora,punto);
		this.celular = celular;
		this.monto = monto;
	}

	public Celular getCelular() {
		return this.celular;
	}
 
	public double getMonto() {
		return this.monto;
	}
}
