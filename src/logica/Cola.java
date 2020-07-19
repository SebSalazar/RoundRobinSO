package logica;

import java.util.ArrayList;
import java.util.List;

public class Cola {
	List<Proceso> cola = new ArrayList<Proceso>();

	public void agregarProceso(Proceso a) {
		cola.add(a);
	}

	public Proceso desencolarProceso() {
		Proceso salida = cola.get(0);
		cola.remove(0);
		return salida;

	}

	public Proceso desencolarProceso(int i) {
		Proceso salida = cola.get(i);
		cola.remove(i);
		return salida;

	}

	public void imprimir() {
		for (int i = 0; i < cola.size(); i++) {
			System.out.print("\nNombre: " + cola.get(i).getNombre() + "\n" + "Estado: " + cola.get(i).getEstado() + "\n"
					+ " lleg: " + cola.get(i).getT_llegada() + " " 
					+ " Rafafa" + cola.get(i).getT_rafaga()+" "
					+ " comienzo: " + cola.get(i).getT_comienzo()
					+ " final: " + cola.get(i).getT_final() 
					+ " Retorno: " + cola.get(i).getT_retorno() 
					+ " Espera: "+ cola.get(i).getT_espera()+ "\n");
		}
		System.out.println("\n");
	}

	public int getTamano() {
		return cola.size();
	}

	public Proceso getElemento(int i) {
		return cola.get(i);
	}

}
