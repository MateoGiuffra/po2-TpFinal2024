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

}
