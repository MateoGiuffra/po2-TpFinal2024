package ar.edu.unq.po2.tpfinal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.inspector.Infraccion;
import ar.edu.unq.po2.tpfinal.inspector.Inspector;
import ar.edu.unq.po2.tpfinal.sem.SEM;
import ar.edu.unq.po2.tpfinal.sem.ZonaSEM;

class InspectorTest {
	
    private SEM sem;
    private ZonaSEM zona;
    private String patente;
    private String patente2;
    private Inspector inspector; 
    private Infraccion infraccion;
    
    
    @BeforeEach
    public void setUp() {
        patente = "ABC123";
        patente2 = "CBA321" ;
        
        sem = mock(SEM.class);
        zona = spy(new ZonaSEM(sem, inspector, null)); 
        
        inspector = new Inspector(zona, sem);
    }

	 
	@Test
	void testEstaVigenteEstacionamiento() {
		inspector.estaVigente(patente);
		verify(zona).estaVigente(patente);
	}
	
	@Test
	void testAltaDeInfraccion() {
		inspector.altaDeInfraccion(patente2);
		verify(sem).addInfraccion(any(Infraccion.class));
	}
	
}
