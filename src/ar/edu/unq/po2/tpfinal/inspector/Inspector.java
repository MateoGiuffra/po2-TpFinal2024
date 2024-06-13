package ar.edu.unq.po2.tpfinal.inspector;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.sem.SEM;
import ar.edu.unq.po2.tpfinal.sem.ZonaSEM;

public class Inspector {
	private ZonaSEM zona;
	private SEM sem;
	
	public Inspector(ZonaSEM zona, SEM sem) {
		this.zona = zona;  
		this.sem = sem; 
	}
	
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
