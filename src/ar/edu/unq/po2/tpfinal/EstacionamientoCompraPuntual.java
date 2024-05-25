package ar.edu.unq.po2.tpfinal;

import java.time.LocalTime;

public class EstacionamientoCompraPuntual extends Estacionamiento{
	private int cantidadHoras;
	
	public EstacionamientoCompraPuntual(String patente, LocalTime horaFin, LocalTime horaInicio, int cantidadHoras) {
		super(patente, horaFin, horaInicio);
		this.cantidadHoras = cantidadHoras;
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public void terminarEstacionamiento() {
//		// TODO Auto-generated method stub
//		
//	}

}
