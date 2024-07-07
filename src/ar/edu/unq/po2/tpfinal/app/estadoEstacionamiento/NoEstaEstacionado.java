package ar.edu.unq.po2.tpfinal.app.estadoEstacionamiento;

import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.app.AppUsuario;
import ar.edu.unq.po2.tpfinal.app.Celular;
import ar.edu.unq.po2.tpfinal.sem.SEM;

public class NoEstaEstacionado extends EstadoEstacionamiento {
	@Override
	public String iniciarEstacionamiento(AppUsuario appUsuario, SEM sem, Celular cel, String patente, LocalTime horaActual) {
		String alerta = "Saldo insuficiente. Estacionamiento no permitido.";
		if (sem.tieneSaldoSuficiente(cel)) {
			appUsuario.setEstadoEstacionamiento(new EstaEstacionado());
			alerta = sem.inicioEstacionamiento(cel, patente, horaActual);
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

}
