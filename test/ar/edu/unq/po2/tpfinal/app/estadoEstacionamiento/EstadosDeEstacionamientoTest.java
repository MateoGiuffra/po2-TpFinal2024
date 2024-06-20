package ar.edu.unq.po2.tpfinal.app.estadoEstacionamiento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.app.AppUsuario;
import ar.edu.unq.po2.tpfinal.app.Celular;
import ar.edu.unq.po2.tpfinal.app.modos.EstrategiaModo;
import ar.edu.unq.po2.tpfinal.app.modos.ModoAutomatico;
import ar.edu.unq.po2.tpfinal.sem.SEM;

class EstadosDeEstacionamientoTest {
	
	private EstrategiaModo modo;
	private AppUsuario app;
	private String patente; 
	private EstadoEstacionamiento estado;
	private SEM sem; 
	private Celular cel; 

	@BeforeEach
	public void setUp() {
		modo = new ModoAutomatico();
        LocalTime horaActual = LocalTime.of(9, 0);
        patente = "ABC123";
        estado = new EstaEstacionado(); 
        sem = mock(SEM.class);
        cel = mock(Celular.class);
        app = new AppUsuario(patente, sem, cel, estado, modo);
        app.setHoraActual(horaActual);
	}
	
	@Test
	void testSetYGettersDeNoEstaEstacionado() {
		estado = new NoEstaEstacionado();
		app.setEstadoEstacionamiento(estado);
		assertEquals(estado, app.getEstado());
	}
	@Test
	void testSetYGettersDeEstaEstacionado() {
		app.setEstadoEstacionamiento(estado);
		assertEquals(estado, app.getEstado());
	}
	@Test
	void testSetYGettersDeNoEstaEnZona() {
		estado = new NoEstaEnZona();
		app.setEstadoEstacionamiento(estado);
		assertEquals(estado, app.getEstado());
	}

}
