package logica.SO;

import logica.Cola;

public class SO {

    final int TIEMPOMAXIMO = 40;
    //Tiempo en el cual se encuentra el programa
    int tiempoActual = 0;

    //Colas empleadas por el programa
    Cola listos = new Cola();
    Cola finalizados = new Cola();
    Cola bloqueados = new Cola();

    /*Componentes del so*/
    Depuracion depuracion = new Depuracion(this);
    Datos datos = new Datos(this);
    GestionProcesos gestionProcesos = new GestionProcesos(this);
    GestionBloqueados gestionBloqueados = new GestionBloqueados(this);

    /**
     * Se obtiene el tiempo maximo que tendra la simulacion
     *
     * @return tiempo de simulacion
     */
    public int getTiempoMaximo() {
        return TIEMPOMAXIMO;
    }

    /**
     * *******************************************************
     */
    /**
     * *******************************************************
     */
    /**
     * ************************GETTERS************************
     */
    /**
     * *******************************************************
     */
    /**
     * Obtener el tiempo actual del SO
     *
     * @return tiempo actual de la simulacion
     */
    public int getTiempoActual() {
        return tiempoActual;
    }

    /**
     * Obtencion de la cola de listos formateada en un String
     *
     * @return String que contiene la cola
     */
    public String getColaListosFormateada() {
        String salida = "";
        salida += "Listos: ";
        for (int i = 0; i < listos.getTamano(); i++) {

            salida += listos.getElemento(i).getNombre();
//            salida += "(P:";
//            salida += listos.getElemento(i).getPrioridad();
            salida += "(R:";
            salida += listos.getElemento(i).getT_rafaga();
            salida += ")";
            salida += " , ";
        }
        return salida;
    }

    /**
     * Obtencion de la cola de finalizados formateada en un String
     *
     * @return String que contiene la cola
     */
    public String getColaFinalizadosFormateada() {
        String salida = "";
        salida += "Finalizados: ";
        for (int i = 0; i < finalizados.getTamano(); i++) {
            salida += finalizados.getElemento(i).getNombre();
//            salida += "(P:";
//            salida += finalizados.getElemento(i).getPrioridad();
            salida += "(R:";
            salida += finalizados.getElemento(i).getT_rafaga();
            salida += ")";
            salida += " , ";

        }
        return salida;
    }

    /**
     * Obtencion de la cola de bloqueados formateada en un String
     *
     * @return String que contiene la cola
     */
    public String getColaBloqueadosFormateada() {
        String salida = "";
        salida += "Bloqueados: ";
        for (int i = 0; i < bloqueados.getTamano(); i++) {
            salida += bloqueados.getElemento(i).getNombre();
//            salida += "(P:";
//            salida += bloqueados.getElemento(i).getPrioridad();
            salida += "(R:";
            salida += bloqueados.getElemento(i).getT_rafaga();
            salida += ")";
            salida += " , ";

        }
        return salida;
    }

    public Cola getColaListos() {
        return listos;
    }

    public Cola getColaFinalizados() {
        return finalizados;
    }

    public Cola getColaBloqueados() {
        return bloqueados;
    }

    public Datos datos() {
        return datos;
    }

    public Depuracion depuracion() {
        return depuracion;
    }

    public GestionProcesos gestionProcesos() {
        return gestionProcesos;
    }

    public GestionBloqueados gestionBloqueados() {
        return gestionBloqueados;
    }

    public void aumentarTiempoActual(int tiempoActual) {
        this.tiempoActual += tiempoActual;
    }

}
