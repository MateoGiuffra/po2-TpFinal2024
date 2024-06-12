package ar.edu.unq.po2.tpfinal.compra;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompraPuntual extends Compra{
	private int cantidadHoras;
	
	public CompraPuntual(LocalDate fecha, LocalTime hora, int cantidadHoras) {
		super(fecha, hora);
		this.cantidadHoras = cantidadHoras;
		// TODO Auto-generated constructor stub
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

}
