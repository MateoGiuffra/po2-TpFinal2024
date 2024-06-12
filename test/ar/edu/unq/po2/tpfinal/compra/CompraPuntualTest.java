package ar.edu.unq.po2.tpfinal.compra;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompraPuntualTest {
	private CompraPuntual compra;
	
	@BeforeEach
	public void setUp() {
		compra = new CompraPuntual (LocalDate.now(), LocalTime.now(), 2);
	}
	
	@Test
	public void testSetterYGetter() {
		compra.setCantidadHoras(4);
		assertEquals(4, compra.getCantidadHoras());
	}
}
