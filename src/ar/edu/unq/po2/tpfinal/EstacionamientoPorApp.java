package ar.edu.unq.po2.tpfinal;

import java.time.LocalTime;

public class EstacionamientoPorApp extends Estacionamiento{
	private Celular celular;
	private double precioxHora;
	
	public EstacionamientoPorApp(String patente, LocalTime horaFin, LocalTime horaInicio, Celular celular,double precioxHora) {
		super(patente, horaFin, horaInicio);
		this.celular = celular;
		this.precioxHora = precioxHora;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void terminarEstacionamiento() {
		this.setHoraFin(LocalTime.of(20, 0));
		this.celular.debitarCredito(this.getCostoEstacionamiento(precioxHora));
	}

	
	
}
