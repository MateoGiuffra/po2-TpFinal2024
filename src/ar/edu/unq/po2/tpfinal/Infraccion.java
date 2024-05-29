package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;
import java.time.LocalTime;

public class Infraccion {
	
	private String patente;
	private LocalDate fecha;
	private LocalTime hora;
	private Inspector inspector;
	private ZonaSEM zona;

	public Infraccion(String patente, LocalDate fecha, LocalTime hora, Inspector inspector, ZonaSEM zona) {
		this.patente = patente;
		this.fecha = fecha;
		this.hora = hora;
		this.inspector = inspector;
		this.zona = zona;
	}

}
