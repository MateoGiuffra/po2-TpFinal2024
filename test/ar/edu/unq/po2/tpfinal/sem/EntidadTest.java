package ar.edu.unq.po2.tpfinal.sem;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.po2.tpfinal.sem.Entidad;
import ar.edu.unq.po2.tpfinal.sem.SEM;
import ar.edu.unq.po2.tpfinal.sem.estacionamiento.Estacionamiento;

public class EntidadTest {
    private EntidadImpl entidad; 
    private SEM sem; 
    private List<Entidad> entidades; 
    private Estacionamiento estacionamiento; 
    List<Estacionamiento> estacionamientos;
    
    
    @Before
    public void setUp() {
        
        estacionamientos = new ArrayList(); 
        estacionamiento = mock(Estacionamiento.class);
        //estacionamientos.add(estacionamiento);
        
        entidad = spy(EntidadImpl.class); 
        entidades = new ArrayList();
        
        sem =  new SEM(0, null, null, null, estacionamientos, entidades, null, null); 
  
    }
    
    @Test 
    public void testNotifyEntidades() {
    	sem.setHoraActual(LocalTime.of(21, 0)); //pasada la hora de cierre se puede finalizar los estacionamientos. 
    	sem.addEstacionamiento(estacionamiento);
        sem.suscribirEntidad(entidad);
        sem.finalizarTodosLosEstacionamientos();
        verify(entidad).notificarFinEstacionamiento(estacionamiento);
    }
    @Test 
    public void testNoNotificarEntidades() {
    	sem.setHoraActual(LocalTime.of(19, 0)); //como la hora esta dentro de la franja horaria, no  
    	sem.addEstacionamiento(estacionamiento);	// deberia de llamar a entidad y pasarle el estacionamiento. 
        sem.suscribirEntidad(entidad);
        sem.finalizarTodosLosEstacionamientos();
        verifyNoInteractions(entidad); //las entidades no son llamadas
    }
    
    
}

class EntidadImpl implements Entidad {
    @Override
    public void notificarFinEstacionamiento(Estacionamiento estacionamiento) {
        // tuve que hacer la implementacion porque no me dejaba hacer un mock de una interfaz 
    }
}
