package ar.edu.unq.po2.tpfinal.app.estadoEstacionamiento;
import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.app.AppUsuario;
import ar.edu.unq.po2.tpfinal.app.Celular;
import ar.edu.unq.po2.tpfinal.sem.SEM;

public abstract class EstadoEstacionamiento {
    
    public abstract String iniciarEstacionamiento(AppUsuario app, SEM sem, Celular celular, String patente, LocalTime horaActual);
    
    
    public abstract String finalizarEstacionamiento(SEM sem, Celular celular, AppUsuario usuario);
    
  
    public void ahoraEstasCaminando(AppUsuario app, Celular celular) {
    	//no hacen nada por default	
    }
    
    public void ahoraEstasManejando(AppUsuario app, Celular celular) {
    	//no hacen nada por default	
    }
    
}
