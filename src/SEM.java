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
	
	public String inicioEstacionamiento(Celular cel, String patente, LocalTime horaActual) {
		return null;
	}
	
	public String finEstacionamiento(Celular cel) {
		return null;
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
