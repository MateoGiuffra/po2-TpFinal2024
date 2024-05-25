package ar.edu.unq.po2.tpfinal;
import java.util.Stack;

public class Celular {
	
	private double credito;
	private int numero;
	private AppUsuario app;
	private Stack <String> alertas;
	
	public double getCredito() {
		return this.credito;
	}

	public void alerta(String alerta) {
		alertas.push(alerta);
	}

	public void debitarCredito(double costoEstacionamiento) {
		this.credito =- costoEstacionamiento;
	}

	public void cargarCredito(double monto) {
		   this.credito += monto;
		
	}
	
	

}
