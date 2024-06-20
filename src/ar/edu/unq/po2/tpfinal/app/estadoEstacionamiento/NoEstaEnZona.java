package ar.edu.unq.po2.tpfinal.app.estadoEstacionamiento;

import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.app.AppUsuario;
import ar.edu.unq.po2.tpfinal.app.Celular;
import ar.edu.unq.po2.tpfinal.sem.SEM;

public class NoEstaEnZona extends EstadoEstacionamiento {
    @Override
    public String iniciarEstacionamiento(AppUsuario appUsuario, SEM sem, Celular cel, String patente, LocalTime horaActual) {
        return "No podes iniciar estacionamiento sin estar en una zona.";
    }

    @Override
    public String finalizarEstacionamiento(SEM sem, Celular cel, AppUsuario usuario) {
        return "No hay un estacionamiento iniciado.";
    }

}
