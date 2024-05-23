package ar.edu.unq.po2.tpfinal;

import java.time.LocalTime;

public class Estacionamiento {
		
	private String patente;
	private LocalTime horaFin;
	private LocalTime horaInicio;
	
	public Estacionamiento(String patente, LocalTime horaFin, LocalTime horaInicio) {
		
		this.patente = patente;
		this.horaFin = horaFin;
		this.horaInicio = horaInicio;
	}
	
	public String getPatente() {
		return this.patente;
	}
	
	public boolean estaVigente() {
		return horaFin.getHour() > horaInicio.getHour();
	}
	public int duracion() {
		return horaFin.getHour() - horaInicio.getHour();
	}

	public void setHoraFin(LocalTime horaActual) {
		// TODO Auto-generated method stub
		
	}

	public LocalTime getHoraInicio() {
		// TODO Auto-generated method stub
		return this.horaInicio;
	}
	public LocalTime getHoraFin() {
		// TODO Auto-generated method stub
		return this.horaFin;
	}

	public double getCostoEstacionamiento(double precioPorHora) {
		// TODO Auto-generated method stub
		return this.duracion() * precioPorHora;
	}
	
}
