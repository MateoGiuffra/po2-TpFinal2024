package ar.edu.unq.po2.tpfinal.app;

import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.sem.SEM;

public class EstaEstacionado extends EstadoEstacionamiento{
	@Override
	public String iniciarEstacionamiento(AppUsuario appUsuario, SEM sem, Celular cel, String patente, LocalTime horaActual) {
		return "No se puede iniciar estacionanamiemto porque ya estas estacionado.";
	}
	
	@Override
	public String finalizarEstacionamiento(SEM sem, Celular cel, AppUsuario usuario) {
		return sem.finEstacionamiento(cel,usuario);
	}

	@Override
	public void ahoraEstasCaminando(AppUsuario app, Celular celular) {
		// no hace nada
		
	}

	@Override
	public void ahoraEstasManejando(AppUsuario app, Celular celular) {
		celular.alerta(app.getModo().alertaFinEstacionamiento(app));
	}
	
}
