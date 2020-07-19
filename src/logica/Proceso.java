package logica;

public class Proceso {
	String nombre;
	String estado;
	int t_llegada;
	int t_rafaga;
	int t_comienzo;
	int t_final;
	int t_retorno;
	int t_espera;
	int prioridad;
	
	/**
	 * Contructor de un proceso
	 * @param nombre
	 * @param tiempo de rafaga
	 */
	public Proceso (String nombre, int t_rafaga, int prioridad) {
		this.nombre = nombre;
		this.estado = "ESPERA";
		this.t_rafaga = t_rafaga;
		this.prioridad = prioridad;
		
		this.t_llegada = -1;
		this.t_comienzo = -1;
		this.t_final = -1;
		this.t_retorno = -1;
		this.t_espera = -1;
	}
	
	/*************************************************/
	/***********GETTERS y SETTERS ********************/
	/************************************************/
	
	public void setEstado(String estado) {
		this.estado=estado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEstado() {
		return estado;
	}

	public int getT_llegada() {
		return t_llegada;
	}

	public int getT_rafaga() {
		return t_rafaga;
	}

	public int getT_comienzo() {
		return t_comienzo;
	}

	public int getT_final() {
		return t_final;
	}

	public int getT_retorno() {
		return t_retorno;
	}

	public int getT_espera() {
		return t_espera;
	}
	public void setT_comienzo(int t_comienzo) {
		this.t_comienzo = t_comienzo;
	}
	public void setT_final(int t_final) {
		this.t_final = t_final;
	}
	public void setT_retorno(int t_retorno) {
		this.t_retorno = t_retorno;
	}
	public void setT_espera(int t_espera) {
		this.t_espera = t_espera;
	}
	public void setT_llegada(int t_llegada) {
		this.t_llegada = t_llegada;
	}
	public void setT_rafaga(int t_rafaga) {
		this.t_rafaga = t_rafaga;
	}
	public int getPrioridad() {
		return this.prioridad;
	}
	
}
