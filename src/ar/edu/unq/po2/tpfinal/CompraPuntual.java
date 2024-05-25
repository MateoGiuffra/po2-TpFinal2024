package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompraPuntual extends Compra{
	private int cantidadHoras;
	
	public CompraPuntual(int nroDeCompra, LocalDate fecha, LocalTime hora, int cantidadHoras) {
		super(nroDeCompra, fecha, hora);
		this.cantidadHoras = cantidadHoras;
		// TODO Auto-generated constructor stub
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	
}
