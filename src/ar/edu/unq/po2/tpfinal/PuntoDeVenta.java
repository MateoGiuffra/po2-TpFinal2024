package ar.edu.unq.po2.tpfinal;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

public class PuntoDeVenta {
	private SEM sem;
	
	
	
	public void iniciarEstacionamiento(String patente, int cantidadHoras) {
		Compra compra =  new CompraPuntual(0, LocalDate.now(), LocalTime.now(),cantidadHoras );
		LocalTime horas = LocalTime.now().plus(Duration.ofHours(cantidadHoras)); 
		EstacionamientoCompraPuntual estacionamientocp = new EstacionamientoCompraPuntual(patente, LocalTime.now(), horas,cantidadHoras); 
		estacionamientocp.setHoraFin(horas);
		sem.addEstacionamiento(estacionamientocp);
		sem.addCompra(compra);
	}
	
	public void cargarCelular(Celular celular, double monto) {
		RecargaDeCelular recarga = new RecargaDeCelular(0, LocalDate.now(), LocalTime.now(), celular, monto);
		celular.cargarCredito(monto);
		sem.addCompra(recarga);
	}
	
}
