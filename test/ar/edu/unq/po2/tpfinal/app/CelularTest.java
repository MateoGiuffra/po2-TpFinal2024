package ar.edu.unq.po2.tpfinal.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CelularTest {
	private AppUsuario app;
	private double credito;
	private int numero;
	private Celular cel;

	@BeforeEach
    public void setUp() {
		numero = 1125262728;
        app = mock(AppUsuario.class);
        credito = 200.00;
        cel = new Celular(credito, numero, app);
    }
	
	@Test
	public void testSetYGetCredito() {
		cel.cargarCredito(100);
		assertEquals(300, cel.getCredito());
	}
	
	@Test
	public void testDebitarCredito() {
		cel.debitarCredito(80.00);
		assertEquals(120, cel.getCredito());
	}
	
	@Test
	public void testConstructor() {
		Celular celular = new Celular(100, 1133445566, app);
		assertEquals(100, celular.getCredito());
		assertEquals(1133445566, celular.getNumero());
	}
}
