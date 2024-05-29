package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;
import java.time.LocalTime;

public class Inspector {
	private ZonaSEM zona;
	private SEM sem;
	
	public boolean estaVigente(String patente) {
		return zona.estaVigente(patente);
	}
	
	public void altaDeInfraccion(String patente) {
		if (!this.estaVigente(patente)) {
			Infraccion infraccion = new Infraccion (patente, LocalDate.now(), LocalTime.now(), this, zona);
			sem.addInfraccion(infraccion);
		}
	}
}
