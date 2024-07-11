package ar.edu.unq.po2.tpfinal.sem;

import ar.edu.unq.po2.tpfinal.compra.Compra;
import ar.edu.unq.po2.tpfinal.sem.estacionamiento.Estacionamiento;

public interface Entidad {

	public void notificarFinEstacionamiento(Estacionamiento estacionamiento);

	public void notificarInicioEstacionamiento(Estacionamiento estacionamiento);

	public void notificarCompraNueva(Compra compra);

}
