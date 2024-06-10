package ar.edu.unq.po2.tpfinal.sem.estacionamiento;

import java.time.LocalTime;

public class EstacionamientoCompraPuntual extends Estacionamiento{
	private int cantidadHoras;
	
	public EstacionamientoCompraPuntual(String patente, LocalTime horaFin, LocalTime horaInicio, int cantidadHoras) {
		super(patente, horaFin, horaInicio);
		this.cantidadHoras = cantidadHoras;
	}


}
