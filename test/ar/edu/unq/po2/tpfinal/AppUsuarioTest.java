package ar.edu.unq.po2.tpfinal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppUsuarioTest {
    private String patente;
    private SEM sem;
    private Celular cel;
    private EstrategiaModo modo;
    private EstadoEstacionamiento estado;
    private AppUsuario app;

    @BeforeEach
    public void setUp() {
        LocalTime horaActual= LocalTime.of(9, 0);
        estado= spy(EstadoEstacionamiento.NoEstaEstacionado);
        sem= mock (SEM.class);
        app= new AppUsuario(patente, sem, cel, estado, modo);
        cel= new Celular(200, 1133334444, app);
        app.setHoraActual(horaActual);

        when(sem.tieneSaldoSuficiente(cel)).thenReturn(true);
    }

    @Test 
    public void testConsultarSaldo() {
        assertEquals(app.consultarSaldo(), 200);
    }

    @Test
    public void testInicioEstacionamiento() {
        app.inicioEstacionamiento();
        verify(estado).iniciarEstacionamiento(app, sem, cel, patente, app.getHoraActual());
        verify(cel).alerta(estado.iniciarEstacionamiento(app, sem, cel, patente, app.getHoraActual()));
    }
}