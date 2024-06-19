package ar.edu.unq.po2.tpfinal.inspector;

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
		this.sem.altaDeInfraccion(patente, this, this.zona);
	}

	public ZonaSEM getZona() {
		return this.zona;
	}  
}
