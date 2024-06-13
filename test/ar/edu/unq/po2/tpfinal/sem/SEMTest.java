package ar.edu.unq.po2.tpfinal.sem;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.app.AppUsuario;
import ar.edu.unq.po2.tpfinal.app.Celular;
import ar.edu.unq.po2.tpfinal.compra.Compra;
import ar.edu.unq.po2.tpfinal.inspector.Infraccion;
import ar.edu.unq.po2.tpfinal.sem.estacionamiento.Estacionamiento;
import ar.edu.unq.po2.tpfinal.sem.estacionamiento.EstacionamientoCompraPuntual;
import ar.edu.unq.po2.tpfinal.sem.estacionamiento.EstacionamientoPorApp;

class SEMTest {

	private SEM sem;
	private List<Infraccion> infracciones; 
	private List<ZonaSEM> zonas; 
	private List<Compra> compras; 
	private List<Estacionamiento> estacionamientos;
	private List<Entidad> entidades;
	private List<AppUsuario> usuarios;
	private LocalTime horaActual; 
	private Celular celular; 
	private AppUsuario app; 
	private Estacionamiento estacionamiento;
	private EstacionamientoPorApp estacionamientoMock;
	private EntidadImpl entidad; 
	@BeforeEach
	public void setUp() {
		estacionamientos = new ArrayList(); 
		infracciones = new ArrayList(); 
		entidades = new ArrayList(); 
		usuarios = new ArrayList(); 
		compras = new ArrayList(); 
		zonas = new ArrayList(); 
		horaActual = LocalTime.of(21, 0);
		sem = new SEM(70, infracciones, zonas,compras, estacionamientos, entidades, usuarios, horaActual);
		celular = mock(Celular.class);
		app = mock(AppUsuario.class);
		when(app.getPatente()).thenReturn("ABC123");
		estacionamiento = new EstacionamientoCompraPuntual("ABC123", LocalTime.of(21, 0),LocalTime.of(15, 0), 6);
		entidad = mock(EntidadImpl.class);
		estacionamientoMock = mock(EstacionamientoPorApp.class);
		when(celular.getCredito()).thenReturn((double) 140);
	}
	
	@Test
	void testInicioEstacionamiento() {
		horaActual = LocalTime.of(19, 0); 
		String mensaje = sem.inicioEstacionamiento(celular, "ABC123", horaActual); 
		
		assertFalse(sem.getEstacionamientos().isEmpty());
		assertEquals("Hora de Inicio del Estacionamiento:" + String.valueOf(horaActual) + "Hora maxima de Fin del Estacionamiento:" + String.valueOf(sem.calcularHoraFinEstacionamiento(celular)), mensaje);
	}
	
	@Test
	void testNoInicioEstacionamiento() {
		String mensaje = sem.inicioEstacionamiento(celular, "ABC123", horaActual); 
		assertEquals("No se puede estacionar en este horario.", mensaje);
	}
	
	@Test
	void testFinEstacionamiento() {
		sem.addEstacionamiento(estacionamiento);
		String mensaje = sem.finEstacionamiento(celular, app);
		
		verify(app).getPatente();	 
		
		assertTrue(sem.getEstacionamientos().isEmpty()); // se borro el estacionamiento
				
	    assertEquals("Hora de Inicio del Estacionamiento:" + String.valueOf(estacionamiento.getHoraInicio()) + ". " + 
					"Hora Fin del Estacionamiento:" + String.valueOf(estacionamiento.getHoraFin()) +		  ". " + 
					"Duracion del Estacionamiento:" + String.valueOf(estacionamiento.duracion())   + 		  ". " + 
					"El costo fue de:" + String.valueOf(estacionamiento.getCostoEstacionamiento(70)), mensaje);
	}
	
	@Test
	void testCalcularHoraFinEstacionamiento() {
		horaActual = LocalTime.of(19, 0);
		assertEquals(LocalTime.of(20,0), sem.calcularHoraFinEstacionamiento(celular));
	}
	
    @Test
    public void testNoFinalizarEstacionamientosAntesDeLas20() {
        sem.setHoraActual(LocalTime.of(19, 0)); // Set antes de 20:00
        sem.addEstacionamiento(estacionamientoMock);

        sem.finalizarTodosLosEstacionamientos();

        verify(estacionamientoMock, never()).terminarEstacionamiento();
        verify(entidad, never()).notificarFinEstacionamiento(any(Estacionamiento.class));
        assertFalse(estacionamientos.isEmpty());
    }
    
    @Test
    public void testFinalizarEstacionamientosALas20() {
    	
        sem.setHoraActual(LocalTime.of(21, 0)); 
        sem.addEstacionamiento(estacionamientoMock);
        sem.finalizarTodosLosEstacionamientos();
        verify(estacionamientoMock).terminarEstacionamiento();
        assertTrue(estacionamientos.isEmpty());
    }
    
    @Test
    public void testAgregarZona() {
    	ZonaSEM zona = mock(ZonaSEM.class);
    	sem.addZona(zona);
    	assertFalse(zonas.isEmpty());
    }
    
    @Test
    public void testAgregarInfraccion() {
    	Infraccion infraccion = mock(Infraccion.class);
    	sem.addInfraccion(infraccion);
    	assertFalse(infracciones.isEmpty());
    }
    
    @Test
    public void testAgregarCompra() {
    	Compra compra = mock(Compra.class);
    	sem.addCompra(compra);
    	assertFalse(compras.isEmpty());
    }
    
    @Test
    public void testSuscribirYDesuscribirEntidad() {
    	Entidad entidad = mock(Entidad.class);
    	sem.suscribirEntidad(entidad);
    	assertFalse(entidades.isEmpty());
    	sem.desuscribirEntidad(entidad);
    	assertTrue(entidades.isEmpty());
    }
    
    @Test
    public void testTieneSaldoSuficiente() {
    	assertTrue(sem.tieneSaldoSuficiente(celular));
    }
    
    @Test
    public void testGetterYSetterHoraActual() {
    	sem.setHoraActual(LocalTime.of(15, 0));
    	assertEquals(LocalTime.of(15, 0), sem.getHoraActual());
    }
    
    @Test
    public void testEsHoraValida() {
    	assertTrue(sem.esHorarioValido(LocalTime.of(18, 0)));
    }
    
    @Test
    public void testEstaVigente() {
    	estacionamientos.add(estacionamiento);
    	assertTrue(sem.estaVigente("ABC123"));
    }
}



