package ar.edu.unq.po2.tpfinal.app;
import java.time.LocalTime;

import ar.edu.unq.po2.tpfinal.sem.SEM;

public abstract class EstadoEstacionamiento {
    // Método abstracto
    public abstract String iniciarEstacionamiento(AppUsuario app, SEM sem, Celular celular, String patente, LocalTime horaActual);
    
    // Método abstracto
    public abstract String finalizarEstacionamiento(SEM sem, Celular celular, AppUsuario usuario);
    
  
    public void ahoraEstasCaminando(AppUsuario app, Celular celular) {
    	
    }
    
    public void ahoraEstasManejando(AppUsuario app, Celular celular) {
    	
    }
    
}
