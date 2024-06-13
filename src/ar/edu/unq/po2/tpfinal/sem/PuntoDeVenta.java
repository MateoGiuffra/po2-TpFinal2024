package ar.edu.unq.po2.tpfinal.sem;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.app.Celular;
import ar.edu.unq.po2.tpfinal.compra.Compra;
import ar.edu.unq.po2.tpfinal.compra.CompraPuntual;
import ar.edu.unq.po2.tpfinal.compra.RecargaDeCelular;
import ar.edu.unq.po2.tpfinal.sem.estacionamiento.EstacionamientoCompraPuntual;

public class PuntoDeVenta {
	private SEM sem;
	
	
	public PuntoDeVenta(SEM sem) {
		super();
		this.sem = sem;
	} 

	public void iniciarEstacionamiento(String patente, int cantidadHoras) {
		Compra compra =  new CompraPuntual(LocalDate.now(), LocalTime.now(), cantidadHoras);
		LocalTime horaFin = this.getHoraFin(cantidadHoras); 
		EstacionamientoCompraPuntual estacionamientocp = new EstacionamientoCompraPuntual(patente, LocalTime.now(), horaFin, cantidadHoras); 
		estacionamientocp.setHoraFin(horaFin);
		compra.sumarCompra();
		sem.addEstacionamiento(estacionamientocp);
		sem.addCompra(compra);
	}
	
	private LocalTime getHoraFin(int cantidadHoras) {
		LocalTime horaFin = LocalTime.now().plus(Duration.ofHours(cantidadHoras));
		LocalTime maxHoraFin = LocalTime.of(20, 0);	
		return horaFin.isBefore(maxHoraFin) ? horaFin : maxHoraFin;
	}

	public void cargarCelular(Celular celular, double monto) {
		RecargaDeCelular recarga = new RecargaDeCelular(LocalDate.now(), LocalTime.now(), celular, monto);
		celular.cargarCredito(monto);
		recarga.sumarCompra();
		sem.addCompra(recarga);
	}
	
}
