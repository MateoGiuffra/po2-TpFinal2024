package ar.edu.unq.po2.tpfinal.sem;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.app.Celular;
import ar.edu.unq.po2.tpfinal.compra.Compra;

public class PuntoDeVentaTest {
    private SEM sem;
	private PuntoDeVenta punto;
	private Celular cel;

	@BeforeEach
    public void setUp() {
        sem = mock(SEM.class);
        punto = new PuntoDeVenta(sem);
        cel = mock(Celular.class);
    }
	
	@Test
	public void testGetHoraFin() {
		punto.cargarCelular(cel, 100);
		verify(cel).cargarCredito(100);
	}
}
