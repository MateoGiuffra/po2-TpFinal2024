package ar.edu.unq.po2.tpfinal.compra;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.sem.PuntoDeVenta;

public class CompraPuntual extends Compra{
	private int cantidadHoras;
	
	public CompraPuntual(LocalDate fecha, LocalTime hora, PuntoDeVenta punto, int cantidadHoras) {
		super(fecha, hora, punto);
		this.cantidadHoras = cantidadHoras; 
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

}
