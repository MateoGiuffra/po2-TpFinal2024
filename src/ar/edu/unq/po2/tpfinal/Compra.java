package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Compra {
	private int nroDeCompra;
	private LocalDate fecha;
	private LocalTime hora;
	
	public Compra(int nroDeCompra, LocalDate fecha, LocalTime hora) {
		super();
		this.nroDeCompra = nroDeCompra;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	
}
