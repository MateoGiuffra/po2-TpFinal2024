package ar.edu.unq.po2.tpfinal.app;

import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.sem.SEM;

public class NoEstaEstacionado extends EstadoEstacionamiento {
	@Override
	public String iniciarEstacionamiento(AppUsuario appUsuario, SEM sem, Celular cel, String patente, LocalTime horaActual) {
		String alerta = "";
		if (sem.tieneSaldoSuficiente(cel)) {
			appUsuario.setEstadoEstacionamiento(new EstaEstacionado());
			alerta = sem.inicioEstacionamiento(cel, patente, horaActual);
		} else {
			alerta = "Saldo insuficiente. Estacionamiento no permitido.";
		}
		return alerta;
	}

	@Override
	public String finalizarEstacionamiento(SEM sem, Celular cel,AppUsuario usuario) {
		return sem.finEstacionamiento(cel,usuario);
	}

	@Override
	public void ahoraEstasCaminando(AppUsuario app, Celular celular) {
		celular.alerta(app.getModo().alertaInicioEstacionamiento(app));
		
	}

	@Override
	public void ahoraEstasManejando(AppUsuario app, Celular celular) {
		// no hace nada
		
	}
}
