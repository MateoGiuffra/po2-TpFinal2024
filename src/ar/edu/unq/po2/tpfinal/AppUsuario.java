package ar.edu.unq.po2.tpfinal;
import java.time.LocalTime;

public class AppUsuario {
	
	private String patente;
	private SEM sem;
	private Celular cel;
	private EstadoDesplazamiento desplazamiento;
	private EstadoEstacionamiento estadoEstacionamiento;
	private EstrategiaModo modo;
	private LocalTime horaActual;
	
	public double consultarSaldo() {
		return this.cel.getCredito();
	}
	
	public void inicioEstacionamiento() {
		this.cel.alerta(this.estadoEstacionamiento.iniciarEstacionamiento(this,this.sem,this.cel,this.patente,this.horaActual));
	}
	
	public void finEstacionamiento() {
		this.cel.alerta(this.estadoEstacionamiento.finalizarEstacionamiento(this.sem,this.cel,this));
	}

//	public void alertaInicioEstacionamiento() {
//
//	}
//	
//	public void alertaFinEstacionamiento() {
//		
//	}

	protected void setEstadoEstacionamiento(EstadoEstacionamiento estado) {
		this.estadoEstacionamiento = estado; 
	}
	
	public String getPatente() {
		return this.patente;
	}
	public void ahoraEstasCaminando() {
		estadoEstacionamiento.ahoraEstasCaminando(this, this.cel);
	}
	public void ahoraEstasManejando() {
		estadoEstacionamiento.ahoraEstasManejando(this, this.cel);
	}

	public void setEstadoMovimiento(EstadoDesplazamiento estadoMovimiento) {
		this.desplazamiento = estadoMovimiento;
	}
	
	public void setModo(EstrategiaModo modo) {
		this.modo = modo;
	}
	
	public EstrategiaModo getModo() {
		return this.modo;
	}
}