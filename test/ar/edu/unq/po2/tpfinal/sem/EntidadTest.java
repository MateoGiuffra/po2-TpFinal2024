package ar.edu.unq.po2.tpfinal.sem;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpfinal.app.Celular;
import ar.edu.unq.po2.tpfinal.compra.Compra;
import ar.edu.unq.po2.tpfinal.sem.estacionamiento.Estacionamiento;

public class EntidadTest {
    private EntidadImpl entidad; 
    private SEM sem; 
    private List<Entidad> entidades; 
    private Estacionamiento estacionamiento; 
    List<Estacionamiento> estacionamientos;
    private Celular cel;
    private String patente;
    private PuntoDeVenta punto; 
    private List<Compra>  compras; 
    
    @Before
    public void setUp() {
        
        estacionamientos = new ArrayList(); 
        estacionamiento = mock(Estacionamiento.class);
        //estacionamientos.add(estacionamiento);
        compras =  new ArrayList(); 
        
        entidad = spy(EntidadImpl.class); 
        entidades = new ArrayList();
        
        cel = mock (Celular.class);
        patente = "ABC123";
        
        sem =  new SEM(0, null, null, compras, estacionamientos, entidades, null, null); 
        punto = new PuntoDeVenta(sem);
  
    }
    
    @Test 
    public void testNotifyEntidadesFin() {
    	sem.setHoraActual(LocalTime.of(21, 0)); //pasada la hora de cierre se puede finalizar los estacionamientos. 
    	sem.addEstacionamiento(estacionamiento);
        sem.suscribirEntidad(entidad);
        sem.finalizarTodosLosEstacionamientos();
        verify(entidad).notificarFinEstacionamiento(estacionamiento);
    }
    
    @Test 
    public void testNoNotificarEntidadesFin() {
    	sem.setHoraActual(LocalTime.of(19, 0)); //como la hora esta dentro de la franja horaria, no  
    	sem.addEstacionamiento(estacionamiento);	// deberia de llamar a entidad y pasarle el estacionamiento. 
        sem.suscribirEntidad(entidad);
        sem.finalizarTodosLosEstacionamientos();
        verifyNoInteractions(entidad); //las entidades no son llamadas
    }
    
    @Test 
    public void testNotifyEntidadesInicio() {
    	sem.setHoraActual(LocalTime.of(15, 0)); 
        sem.suscribirEntidad(entidad);
        sem.inicioEstacionamiento(cel, patente, LocalTime.of(15,0));
        verify(entidad).notificarInicioEstacionamiento(any(Estacionamiento.class));
    } 
    
    @Test 
    public void testNotifyEntidadesCompraNueva() {
    	sem.setHoraActual(LocalTime.of(15, 0)); 
        sem.suscribirEntidad(entidad);
        punto.cargarCelular(cel,300);
        verify(entidad).notificarCompraNueva(any(Compra.class));
    } 
}

class EntidadImpl implements Entidad {
    @Override
    public void notificarFinEstacionamiento(Estacionamiento estacionamiento) {
        // tuve que hacer la implementacion porque no me dejaba hacer un mock de una interfaz 
    }

	@Override
	public void notificarInicioEstacionamiento(Estacionamiento estacionamiento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificarCompraNueva(Compra compra) {
		// TODO Auto-generated method stub
		
	}
}
