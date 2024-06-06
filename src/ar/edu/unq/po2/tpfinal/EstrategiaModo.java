package ar.edu.unq.po2.tpfinal;

public enum EstrategiaModo {
	Manual{

		@Override
		public String alertaFinEstacionamiento(AppUsuario app) {
			return "No se ha finalizado el estacionamiento.";
			
		}

		@Override
		public String alertaInicioEstacionamiento(AppUsuario app) {
			return "No se ha inicado el estacionamiento.";
		}

	
	}, Automatico{

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


	};
	public abstract String alertaFinEstacionamiento(AppUsuario app);
	public abstract String alertaInicioEstacionamiento(AppUsuario app);
}
