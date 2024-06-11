package ar.edu.unq.po2.tpfinal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.app.AppUsuario;
import ar.edu.unq.po2.tpfinal.app.Celular;
import ar.edu.unq.po2.tpfinal.app.EstadoEstacionamiento;
import ar.edu.unq.po2.tpfinal.app.EstrategiaModo;
import ar.edu.unq.po2.tpfinal.sem.SEM;

public class AppUsuarioTest {
    private String patente;
    private SEM sem;
    private Celular cel;
    private EstrategiaModo modo;
    private EstadoEstacionamiento estado;
    private AppUsuario app;

    @BeforeEach
    public void setUp() {
        LocalTime horaActual = LocalTime.of(9, 0);
        patente = "ABC123";
        estado = spy(EstadoEstacionamiento.NoEstaEstacionado); 
        sem = mock(SEM.class);
        cel = mock(Celular.class); 
        app = new AppUsuario(patente, sem, cel, estado, modo);
        app.setHoraActual(horaActual);

        when(sem.tieneSaldoSuficiente(cel)).thenReturn(true);
        when(cel.getCredito()).thenReturn((double) 200); 
    }

    @Test 
    public void testConsultarSaldo() {
        assertEquals(200, app.consultarSaldo()); 
    }

    @Test
    public void testInicioEstacionamiento() {
        app.inicioEstacionamiento();
        verify(estado).iniciarEstacionamiento(app, sem, cel, patente, app.getHoraActual());
        verify(cel).alerta(estado.iniciarEstacionamiento(app, sem, cel, patente, app.getHoraActual()));
    }
}
