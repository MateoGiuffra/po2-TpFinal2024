package ar.edu.unq.po2.tpfinal.app;
import java.util.Stack;

public class Celular {
	
	private double credito;
	private int numero;
	private AppUsuario app;
	private Stack <String> alertas;
	
	public Celular(double credito, int numero, AppUsuario app) {
		super();
		this.credito = credito;
		this.numero = numero;
		this.app = app;
	}
	
	public double getCredito() {
		return this.credito;
	}

	public void alerta(String alerta) {
		alertas.push(alerta);
	}

	public void debitarCredito(double costoEstacionamiento) {
		this.credito -= costoEstacionamiento;
	}

	public void cargarCredito(double monto) {
		   this.credito += monto;
		
	}

	public Integer getNumero() {
		return this.numero;
	}

}
