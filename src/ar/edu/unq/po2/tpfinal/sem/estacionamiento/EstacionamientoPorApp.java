package ar.edu.unq.po2.tpfinal.sem.estacionamiento;

import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.app.Celular;

public class EstacionamientoPorApp extends Estacionamiento{
	private Celular celular;
	private double precioxHora;
	
	public EstacionamientoPorApp(String patente, LocalTime horaFin, LocalTime horaInicio, Celular celular,double precioxHora) {
		super(patente, horaFin, horaInicio);
		this.celular = celular;
		this.precioxHora = precioxHora;
	}

	@Override
	public void terminarEstacionamiento() {
		this.setHoraFin(LocalTime.of(20, 0));
		this.celular.debitarCredito(this.getCostoEstacionamiento(precioxHora));
	}

	
	
}
