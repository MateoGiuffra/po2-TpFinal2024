package ar.edu.unq.po2.tpfinal;

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
