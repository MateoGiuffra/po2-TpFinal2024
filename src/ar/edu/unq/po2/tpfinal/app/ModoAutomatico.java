package ar.edu.unq.po2.tpfinal.app;

public class ModoAutomatico implements EstrategiaModo{

	@Override
	public String alertaFinEstacionamiento(AppUsuario app) {
		app.finEstacionamiento();
		return "Se ha finalizado el estacionamiento.";
	}

	@Override
	public String alertaInicioEstacionamiento(AppUsuario app) {
		app.inicioEstacionamiento();
		return "Se ha iniciado estacionamiento.";
	}

}
