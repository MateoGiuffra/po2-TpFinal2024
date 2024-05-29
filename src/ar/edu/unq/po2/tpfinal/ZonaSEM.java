package ar.edu.unq.po2.tpfinal;

import java.util.List;

public class ZonaSEM {
	
	private SEM sem;
	private Inspector inspector;
	private List<PuntoDeVenta> puntosDeVenta;
	
	
	
	public ZonaSEM(SEM sem, Inspector inspector, List<PuntoDeVenta> puntosDeVenta) {
		super();
		this.sem = sem;
		this.inspector = inspector;
		this.puntosDeVenta = puntosDeVenta;
		sem.addZona(this);
	}



	public boolean estaVigente(String patente) {
		
		return sem.estaVigente(patente);
	}

}
