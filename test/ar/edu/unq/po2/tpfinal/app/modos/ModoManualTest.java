package ar.edu.unq.po2.tpfinal.app.modos;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.app.AppUsuario;
import ar.edu.unq.po2.tpfinal.app.Celular;
import ar.edu.unq.po2.tpfinal.app.estadoEstacionamiento.EstaEstacionado;
import ar.edu.unq.po2.tpfinal.app.estadoEstacionamiento.EstadoEstacionamiento;
import ar.edu.unq.po2.tpfinal.app.estadoEstacionamiento.NoEstaEstacionado;
import ar.edu.unq.po2.tpfinal.sem.SEM;

public class ModoManualTest {
	private EstrategiaModo modo;
	private AppUsuario app;
	private String patente; 
	private EstadoEstacionamiento estado;
	private SEM sem; 
	private Celular cel; 

	@BeforeEach
	public void setUp() {
		modo = new ModoManual();
        LocalTime horaActual = LocalTime.of(9, 0);
        patente = "ABC123";
        estado = new EstaEstacionado(); 
        sem = mock(SEM.class);
        cel = spy(new Celular(20.00, 1150560434, app));
        app = spy(new AppUsuario(patente, sem, cel, estado, modo));
        app.setHoraActual(horaActual);
	}
	
	@Test
	public void testAlertaFinEstacionamientoCuandoSePasaAManejarEstandoEstacionado() {
		app.ahoraEstasManejando();
		verify(app, never()).finEstacionamiento();
		verify(cel).alerta("No se ha finalizado el estacionamiento.");
	} 
	
	@Test
	public void testAlertaFinEstacionamientoCuandoSePasaAManejarSinEstarEstacionado() {
		app.setEstadoEstacionamiento(new NoEstaEstacionado());
		app.ahoraEstasManejando();
		verifyNoInteractions(cel);
	}
	
	@Test
	public void testAlertaInicioEstacionamientoCuandoSePasaAManejarSinEstarEstacionado() {
		app.setEstadoEstacionamiento(new NoEstaEstacionado());
		app.ahoraEstasCaminando();
		verify(app, never()).inicioEstacionamiento();
		verify(cel).alerta("No se ha inicado el estacionamiento.");
	}
}