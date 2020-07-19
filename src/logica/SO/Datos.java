package logica.SO;

import logica.Cola;

public class Datos {
	SO so;
	public Datos(SO so) {
		this.so = so;
	}
	/**
	 * Se obtienen los datos formateados para ser representados por la grafica,
	 *  mas especificamente los datos de la rejilla
	 * @return El arreglo de arreglos que contiene los datos de la rejilla
	 */
	public String[][] getDatos(){
		Cola finalizados = so.getColaFinalizados();

		String datos[][] = new String[finalizados.getTamano()][7];
		int i;
		for(i = 0 ; i<finalizados.getTamano() ; i++) {
			datos[i][0] = finalizados.getElemento(i).getNombre();
			datos[i][1] = String.valueOf(finalizados.getElemento(i).getT_llegada());
			datos[i][2] = String.valueOf(finalizados.getElemento(i).getT_rafaga());
			datos[i][3] = String.valueOf(finalizados.getElemento(i).getT_comienzo());
			datos[i][4] = String.valueOf(finalizados.getElemento(i).getT_final());
			datos[i][5] = String.valueOf(finalizados.getElemento(i).getT_retorno());
			datos[i][6] = String.valueOf(finalizados.getElemento(i).getT_espera());
		}
		return datos;
	}
	/**
	 * Se formatean los datos para que la tabla pueda interpretarlos
	 * @return El arreglo de arreglos que interpretara la tabla
	 */
	public String[][] getDatosTabla() {
		Cola finalizados = so.getColaFinalizados();
		Cola listos = so.getColaListos();
		
		String datos[][] = new String[finalizados.getTamano()+listos.getTamano()][8];
		int i;
		for(i = 0 ; i<finalizados.getTamano() ; i++) {
			datos[i][0] = finalizados.getElemento(i).getNombre();
			datos[i][1] = String.valueOf(finalizados.getElemento(i).getPrioridad());
			datos[i][2] = String.valueOf(finalizados.getElemento(i).getT_llegada());
			datos[i][3] = String.valueOf(finalizados.getElemento(i).getT_rafaga());
			datos[i][4] = String.valueOf(finalizados.getElemento(i).getT_comienzo());
			datos[i][5] = String.valueOf(finalizados.getElemento(i).getT_final());
			datos[i][6] = String.valueOf(finalizados.getElemento(i).getT_retorno());
			datos[i][7] = String.valueOf(finalizados.getElemento(i).getT_espera());

		}
		for(; i<listos.getTamano() ; i++) {
			datos[i][0] = listos.getElemento(i).getNombre();
			datos[i][1] = String.valueOf(listos.getElemento(i).getPrioridad());
			datos[i][2] = String.valueOf(listos.getElemento(i).getT_llegada());
			datos[i][3] = String.valueOf(listos.getElemento(i).getT_rafaga());
			datos[i][4] = String.valueOf(listos.getElemento(i).getT_comienzo());
			datos[i][5] = String.valueOf(listos.getElemento(i).getT_final());
			datos[i][6] = String.valueOf(listos.getElemento(i).getT_retorno());
			datos[i][7] = String.valueOf(listos.getElemento(i).getT_espera());

		}
		return datos;
		
	}
	
}
