package ar.edu.unq.po2.tpfinal.app;

import java.time.LocalTime;

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

    @Override
    public void ahoraEstasCaminando(AppUsuario app, Celular celular) {
        // No hace nada porque no se puede estacionar fuera de zona
    }

    @Override
    public void ahoraEstasManejando(AppUsuario app, Celular celular) {
        // No hace nada porque no se puede estacionar fuera de zona
    }
}
