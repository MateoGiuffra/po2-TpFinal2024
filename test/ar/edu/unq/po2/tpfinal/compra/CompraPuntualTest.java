package ar.edu.unq.po2.tpfinal.compra;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.sem.PuntoDeVenta;

public class CompraPuntualTest {
	private CompraPuntual compra;
	private PuntoDeVenta punto; 
	@BeforeEach
	public void setUp() {
		punto = mock(PuntoDeVenta.class) ;
		compra = new CompraPuntual (LocalDate.now(), LocalTime.now(),punto, 2);
	}
	
	@Test
	public void testSetterYGetter() {
		compra.setCantidadHoras(4);
		assertEquals(4, compra.getCantidadHoras());
	}
}
