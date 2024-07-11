package ar.edu.unq.po2.tpfinal.compra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.app.Celular;
import ar.edu.unq.po2.tpfinal.sem.PuntoDeVenta;

public class RecargaDeCelularTest {
	private RecargaDeCelular recarga;
	private Celular cel;
	private PuntoDeVenta punto; 
	
	@BeforeEach
	public void setUp() {
		punto = mock(PuntoDeVenta.class) ;
		cel = mock (Celular.class);
		recarga = new RecargaDeCelular(LocalDate.now(), LocalTime.now(),punto, cel, 200);
	}
	
	@Test
	public void testGetters() {
		assertEquals(200, recarga.getMonto());
		assertEquals(cel, recarga.getCelular());
	}
}
