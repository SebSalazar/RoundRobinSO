package logica.SO;

import logica.Proceso;

public class GestionBloqueados {
	SO so;

	public GestionBloqueados(SO so) {
		this.so = so;
	}
	/**
	 * 
	 * Front para bloquear el siguiente proceso
	 * 
	 */
	public void bloquearSiguiente() {
		bloquear(so.gestionProcesos().getSiguienteProceso());
	}
	
	/**
	 * Bloquear un proceso es especifico
	 * @param siguienteProceso la ubicacion del proceso en la cola de listos
	 */
	private void bloquear(int siguienteProceso) {
		Proceso bloqueado = so.getColaListos().getElemento(siguienteProceso);
		int totalRafaga = bloqueado.getT_rafaga();

		/*Se divide el proceso en 2*/
		
		/*Se modifica el original*/
		so.getColaListos().getElemento(siguienteProceso).setT_rafaga(totalRafaga - totalRafaga/2);
		
		/*Se crea su otra mitad*/
		Proceso mitad2 = new Proceso(bloqueado.getNombre(),bloqueado.getT_rafaga(),bloqueado.getPrioridad());
		mitad2.setT_rafaga(totalRafaga/2);
		mitad2.setT_llegada(bloqueado.getT_llegada());
		/*Se ejecuta el original a medias*/
		//ejecutarProceso(siguienteProceso);
		
		/*Se agrega la otra mitad a la cola de bloqueados*/
		this.insertarBloqueado(mitad2);
		
		
	}
	/**
	 * Agregar un proceso a la cola de bloqueados
	 * @param proceso
	 */
	private void insertarBloqueado(Proceso proceso) {
		so.getColaBloqueados().agregarProceso(proceso);
	}
	/**
	 * Sacar el proceso de la cola de bloqueados y ingresarlo a la cola de listos
	 */
	public void desbloquear() {
		Proceso desbloquear = so.getColaBloqueados().desencolarProceso();
		so.gestionProcesos().insertarProceso(desbloquear);
		
	}
}
