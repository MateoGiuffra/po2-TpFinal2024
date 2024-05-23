package ar.edu.unq.po2.tpfinal;
import java.time.LocalTime;
import java.util.List;

public class SEM {
	
	private double precioXHora;
	private List <Infraccion> infracciones;
	private List <ZonaSEM> zonas;
	private List <Compra> compras;
	private List <Estacionamiento> estacionamientos;
	private List <Entidad> entidades;
	private List <AppUsuario> usuarios;
	//private HashMap<Celular, String> celularesEstacionados;
	private LocalTime horaActual;
	
	public String inicioEstacionamiento(Celular cel, String patente, LocalTime horaActual) {
			
		String msg = "No se puede estacionar en este horario.";
		if (this.esHorarioValido(horaActual)){
			LocalTime horaFin = this.calcularHoraFinEstacionamiento(cel);
			Estacionamiento estacionamientoNuevo = new Estacionamiento(patente, horaFin, horaActual);
			estacionamientos.add(estacionamientoNuevo);
			msg = "Hora de Inicio del Estacionamiento:" + String.valueOf(horaActual) + "Hora maxima de Fin del Estacionamiento:" + String.valueOf(horaFin);
		}
		return msg;
	}
	
	public String finEstacionamiento(Celular cel, AppUsuario usuario) {
		String patente = usuario.getPatente();
		Estacionamiento estacionamiento = this.estacionamientos.stream().filter(e -> e.getPatente() == patente).findFirst().get();
		estacionamientos.remove(estacionamiento);
		estacionamiento.setHoraFin(horaActual);
		this.debitarCredito(cel,this.precioXHora,estacionamiento);
		String msg = this.enviarMensaje(estacionamiento, cel);
		this.notificarEntidadesFinDeEstacionamiento(estacionamiento);
		return msg;
		
	}
	
	private LocalTime calcularHoraFinEstacionamiento(Celular cel) {
		
		int maximoDeHorasPagables = (int) Math.round (cel.getCredito() / this.precioXHora);
		LocalTime horaFINAL;
		LocalTime horaFin = this.horaActual.plusHours(maximoDeHorasPagables);
		LocalTime horaFinSEM = LocalTime.of(20, 0);
		if (horaFin.isBefore(horaFinSEM)) {
			horaFINAL = horaFin;
		}else {
			horaFINAL = horaFinSEM;
		}
		
		return horaFINAL;
		
	}
			
	
	private String enviarMensaje(Estacionamiento estacionamiento, Celular cel) {
		
		return  "Hora de Inicio del Estacionamiento:" + String.valueOf(estacionamiento.getHoraInicio()) + ". " + 
				"Hora Fin del Estacionamiento:" + String.valueOf(estacionamiento.getHoraFin()) +		  ". " + 
				"Duracion del Estacionamiento:" + String.valueOf(estacionamiento.duracion())   + 		  ". " + 
				"El costo fue de:" + String.valueOf(estacionamiento.getCostoEstacionamiento(this.precioXHora));
	}

	private void notificarEntidadesFinDeEstacionamiento(Estacionamiento estacionamiento) {
		this.entidades.forEach(e -> e.notificarFinEstacionamiento(estacionamiento));
	}

	private void debitarCredito(Celular cel, double precioXHora2, Estacionamiento estacionamiento) {
		cel.debitarCredito(estacionamiento.getCostoEstacionamiento(precioXHora2));
		
	}

	public void finalizarEstacionamientosPermitidos(){
		
	}
	
	public void notificarFinalizacion(){
		
	}
	
	public void addZona(ZonaSEM zona) {
		zonas.add(zona);
	}
	
	public void addInfraccion(Infraccion infraccion) {
		infracciones.add(infraccion);
	}
	
	public void addCompra(Compra compra) {
		compras.add(compra);
	}
	
	public void addEstacionamiento(Estacionamiento estacionamiento) {
		estacionamientos.add(estacionamiento);
	}
	
	public void suscribirEntidad(Entidad entidad) {
		entidades.add(entidad);
	}
	
	public void desuscribirEntidad(Entidad entidad) {
		entidades.remove(entidad);
	}
	
	public boolean tieneSaldoSuficiente(Celular cel) {
		return cel.getCredito() >= precioXHora;
	}

	public boolean esHorarioValido(LocalTime horaActual) {
		return false;
	}
	
}
