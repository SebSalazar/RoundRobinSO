package logica.SO;

public class Depuracion {
	SO so;
	public Depuracion (SO so) {
		this.so = so;
	}
	
	/**
	 * Imprimir el tiempo actual
	 */
	private void imprimirTiempo() {
		System.out.print("Tiempo: "+so.getTiempoActual()+"\n");
	}
	/**
	 * Imprimir la cola de finalizados
	 */
	private void imprimirFinalizados() {
		so.getColaFinalizados().imprimir();
	}
	/**
	 * Imprimir la cola de listos
	 * 
	 */
	private void imprimirListos() {
		so.getColaListos().imprimir();
	}
}
