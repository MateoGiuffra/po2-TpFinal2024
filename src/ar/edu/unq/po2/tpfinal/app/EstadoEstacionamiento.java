package ar.edu.unq.po2.tpfinal.app;
import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.sem.SEM;

public enum EstadoEstacionamiento { 
	NoEstaEnZona{
		
		@Override
		public String iniciarEstacionamiento(AppUsuario appUsuario, SEM sem, Celular cel, String patente, LocalTime horaActual) {
			return "No podes iniciar estacionamiento sin estar en una zona.";
		}
		
		@Override
		public String finalizarEstacionamiento(SEM sem, Celular cel,AppUsuario usuario) {
			return "No hay un estacionamiento iniciado.";
		}

		@Override
		public void ahoraEstasCaminando(AppUsuario app, Celular celular) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void ahoraEstasManejando(AppUsuario app, Celular celular) {
			// TODO Auto-generated method stub
			
		}
	        
	}, EstaEstacionado {
		
		@Override
		public String iniciarEstacionamiento(AppUsuario appUsuario, SEM sem, Celular cel, String patente, LocalTime horaActual) {
			return "Ya estas estacionado!!";
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

		
		
	}, NoEstaEstacionado {
		
		@Override
		public String iniciarEstacionamiento(AppUsuario appUsuario, SEM sem, Celular cel, String patente, LocalTime horaActual) {
			String alerta = "";
			if (sem.tieneSaldoSuficiente(cel)) {
				appUsuario.setEstadoEstacionamiento(EstadoEstacionamiento.EstaEstacionado);
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

	};
	
	public abstract String iniciarEstacionamiento(AppUsuario app, SEM sem, Celular celular, String patente, LocalTime horaActual);
    public abstract String finalizarEstacionamiento(SEM sem, Celular celular,AppUsuario usuario);
    public abstract void ahoraEstasCaminando(AppUsuario app, Celular celular);
    public abstract void ahoraEstasManejando(AppUsuario app, Celular celular);
}
