package ar.edu.unq.po2.tpfinal.app.estadoDesplazamiento;

import ar.edu.unq.po2.tpfinal.app.AppUsuario;

public class EstadoManejando extends EstadoDesplazamiento{

	
	
	@Override
	public void manejando(AppUsuario app) {
		// no hace nada
		
	}

	@Override
	public void caminando(AppUsuario app) {
		app.setEstadoMovimiento(new EstadoAPie());
		app.ahoraEstasCaminando();
	}
	
}
