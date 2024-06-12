package ar.edu.unq.po2.tpfinal.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstrategiaModoTest {
	private EstrategiaModo automatico;
	private EstrategiaModo manual;
	private AppUsuario app;
	
	@BeforeEach
	public void setUp() {
		automatico = EstrategiaModo.Automatico;
		manual = EstrategiaModo.Manual;
		app = mock (AppUsuario.class);
	}
	
	@Test
	public void testAlertaFinEstacionamiento() {
		assertEquals("No se ha finalizado el estacionamiento.", manual.alertaFinEstacionamiento(app));
		
		automatico.alertaFinEstacionamiento(app);
		verify(app).finEstacionamiento();
		assertEquals("Se ha finalizado el estacionamiento.", automatico.alertaFinEstacionamiento(app));
	}
	
	@Test
	public void testAlertaInicioEstacionamiento() {
		assertEquals("No se ha inicado el estacionamiento.", manual.alertaInicioEstacionamiento(app));
		
		automatico.alertaInicioEstacionamiento(app);
		verify(app).inicioEstacionamiento();
		assertEquals("Se ha iniciado estacionamiento.", automatico.alertaInicioEstacionamiento(app));
		
	}
}
