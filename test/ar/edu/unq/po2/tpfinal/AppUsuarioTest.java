package ar.edu.unq.po2.tpfinal;
import static org.mockito.Mockito.*;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;

public class AppUsuarioTest {
	private String patente;
	private SEM sem;
	private Celular cel;
	private EstrategiaModo modo;
	private EstadoEstacionamiento estado;
	
	@BeforeEach
	public void setUp() {
		LocalTime horaActual= LocalTime.of(9, 0, 0);
		sem= mock (SEM.class);
		AppUsuario app;
		cel= new Celular();
		app= new AppUsuario(patente, sem, cel, estado, modo);
		app.setHoraActual(horaActual);

		when(sem.inicioEstacionamiento(cel, patente, app.getHoraActual())).thenReturn("Su estacionamiento es valido desde las "+ app.getHoraActual() +"hs. Hasta las 12:00hs.");
		when(sem.tieneSaldoSuficiente(cel)).thenReturn(true);
	}
}
