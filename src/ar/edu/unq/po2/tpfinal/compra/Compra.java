package ar.edu.unq.po2.tpfinal.compra;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.sem.PuntoDeVenta;

public abstract class Compra {
	protected int nroDeCompra = 0;
	private LocalDate fecha;
	private LocalTime hora;
	private PuntoDeVenta puntoDeVenta; 
	
	public Compra(LocalDate fecha, LocalTime hora, PuntoDeVenta punto) {
		this.fecha = fecha;
		this.hora = hora;
		this.puntoDeVenta = punto; 
	}
 
	public void sumarCompra() {
		this.nroDeCompra++;
	}
	
	
}
