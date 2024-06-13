package ar.edu.unq.po2.tpfinal.estacionamiento;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.app.Celular;
import ar.edu.unq.po2.tpfinal.sem.estacionamiento.EstacionamientoPorApp;

public class EstacionamientoPorAppTest {
	private Celular celular;
	private double precioxHora;
	private String patente;
	private LocalTime horaFin;
	private LocalTime horaInicio;
	private EstacionamientoPorApp estacionamiento;
	
	@BeforeEach
	public void setUp() {
		celular = mock(Celular.class);
		precioxHora = 70;
		patente = "ABC123";
		horaFin = LocalTime.of(18,0);
		horaInicio = LocalTime.of(15,0);
		estacionamiento = new EstacionamientoPorApp(patente, horaFin, horaInicio, celular, precioxHora);
	}
	
	@Test
	public void testTerminarEstacionamiento() {
		estacionamiento.terminarEstacionamiento();
		assertEquals(LocalTime.of(20, 0), estacionamiento.getHoraFin());
		verify(celular).debitarCredito(estacionamiento.getCostoEstacionamiento(precioxHora));
	}
	
	@Test
	public void testEstaVigente() {
		assertEquals(3, estacionamiento.duracion());
	}
	
	@Test
	public void testGetters() {
		assertEquals(horaFin, estacionamiento.getHoraFin());
		assertEquals(horaInicio, estacionamiento.getHoraInicio());
		assertEquals(patente, estacionamiento.getPatente());
	}
}
