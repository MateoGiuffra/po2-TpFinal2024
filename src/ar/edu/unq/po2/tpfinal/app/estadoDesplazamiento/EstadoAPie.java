package ar.edu.unq.po2.tpfinal.app.estadoDesplazamiento;

import ar.edu.unq.po2.tpfinal.app.AppUsuario;

public class EstadoAPie extends EstadoDesplazamiento{

	@Override
	public void manejando(AppUsuario app) {
		app.setEstadoMovimiento(new EstadoManejando());
		app.ahoraEstasManejando();
	}

	@Override
	public void caminando(AppUsuario app) {
		// no hace nada
	}
	
}
