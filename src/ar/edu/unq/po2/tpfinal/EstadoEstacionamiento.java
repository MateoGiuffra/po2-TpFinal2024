package ar.edu.unq.po2.tpfinal;
import java.time.LocalTime;

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
	        
	}, EstaEstacionado {
		
		@Override
		public String iniciarEstacionamiento(AppUsuario appUsuario, SEM sem, Celular cel, String patente, LocalTime horaActual) {
			return "Ya estas estacionado!!";
		}
		
		@Override
		public String finalizarEstacionamiento(SEM sem, Celular cel, AppUsuario usuario) {
			return sem.finEstacionamiento(cel,usuario);
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

	};
	
	public abstract String iniciarEstacionamiento(AppUsuario app, SEM sem, Celular celular, String patente, LocalTime horaActual);

    protected abstract String finalizarEstacionamiento(SEM sem, Celular celular,AppUsuario usuario);
}
