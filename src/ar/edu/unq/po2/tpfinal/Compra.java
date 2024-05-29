package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Compra {
	protected int nroDeCompra = 0;
	private LocalDate fecha;
	private LocalTime hora;
	
	public Compra(LocalDate fecha, LocalTime hora) {
		super();
		this.fecha = fecha;
		this.hora = hora;
	}

	public void sumarCompra() {
		this.nroDeCompra++;
		
	}
	
	
}
