package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;
import java.time.LocalTime;

public class RecargaDeCelular extends Compra{
	private Celular celular;
	private double monto;
	
	public RecargaDeCelular(LocalDate fecha, LocalTime hora, Celular celular, double monto) {
		super(fecha, hora);
		this.celular = celular;
		this.monto = monto;
		// TODO Auto-generated constructor stub
	}

	
	
}
