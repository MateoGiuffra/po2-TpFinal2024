package ar.edu.unq.po2.tpfinal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.app.AppUsuario;
import ar.edu.unq.po2.tpfinal.app.Celular;
import ar.edu.unq.po2.tpfinal.app.EstadoEstacionamiento;
import ar.edu.unq.po2.tpfinal.app.EstrategiaModo;
import ar.edu.unq.po2.tpfinal.app.estadoDesplazamiento.EstadoAPie;
import ar.edu.unq.po2.tpfinal.app.estadoDesplazamiento.EstadoDesplazamiento;
import ar.edu.unq.po2.tpfinal.app.estadoDesplazamiento.EstadoManejando;
import ar.edu.unq.po2.tpfinal.sem.SEM;

class EstadoAPieYManejandoTest {
	
	private EstadoDesplazamiento estadoDesplazamiento; 
	private AppUsuario app; 
	private String patente;
	private SEM sem;
	private Celular cel;
	private EstrategiaModo modo;
	private EstadoEstacionamiento estado;
	    
	
	@BeforeEach
	public void setUp() {
	   LocalTime horaActual = LocalTime.of(9, 0);
	   patente = "ABC123";
	   estado = (EstadoEstacionamiento.NoEstaEstacionado); 
	   modo = (EstrategiaModo.Automatico); 
	   sem = mock(SEM.class);
	   cel = mock(Celular.class); 
	   app = spy(new AppUsuario(patente, sem, cel, estado, modo));
	}
	 
	@Test
	void testDePieAManejar() {
		estadoDesplazamiento = new EstadoAPie();
		estadoDesplazamiento.manejando(app);
		verify(app).ahoraEstasManejando();
	}
	
	@Test
	void testDeManejarAPie() {
		estadoDesplazamiento = new EstadoManejando();
		estadoDesplazamiento.caminando(app);
		verify(app).ahoraEstasCaminando();
	}
	

}
