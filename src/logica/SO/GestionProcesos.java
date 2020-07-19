package logica.SO;

import logica.Cola;
import logica.Proceso;

public class GestionProcesos {

    SO so;
    int cont;
    public GestionProcesos(SO so) {
        this.so = so;
    }

    /**
     * Insertar un proceso en el cual se establece su nuevo estado y se agrega
     * su tiempo de llegada
     *
     * @param El proceso a ingresar
     */
    public void insertarProceso(Proceso proceso) {
        proceso.setEstado("LISTO");
        if (proceso.getT_llegada() == -1) {
            proceso.setT_llegada(so.getTiempoActual());
            System.out.println("TIEMPO: " + proceso.getT_llegada());
        }
        so.getColaListos().agregarProceso(proceso);
    }

    /**
     * Se obtiene el siguiente proceso de la lista deacuerdo a la prioridad del
     * proceso
     *
     * @return La ubicacion del proceso en la lista
     */
    public int getSiguienteProceso() {
        Cola listos = so.getColaListos();
        int idProceso = -1;
        int actualRafaga = 9999999;
        Proceso actual;
        actual = listos.getElemento(0);
        idProceso = 0;
        for (int i = 0; i < listos.getTamano(); i++) {
            actual = listos.getElemento(i);
            if (actual.getT_llegada() < actualRafaga) {
                actualRafaga = listos.getElemento(i).getT_llegada();
                idProceso = i;
            }
        }
        return idProceso;
    }

    /**
     * Front para ejecutar un proceso
     */
    public void ejecutarProceso() {
        ejecutarProceso(getSiguienteProceso());
    }

    /**
     * Se ejecuta un proceso, se saca de la cola de listos y se pasa a la cola
     * de finalizados
     *
     * @param La ubicacion del proceso en la cola
     */
    private void ejecutarProceso(int elementoCola) {
        Proceso proceso = so.getColaListos().desencolarProceso(elementoCola);
        
        /*Ejecucion*/
        if(proceso.getT_rafaga() >4){
            insertarProceso(new Proceso(proceso.getNombre()+""+(cont+1), proceso.getT_rafaga()-4, 2));
            proceso.setT_rafaga(4);
        }
        proceso.setEstado("FINALIZADO");
        proceso.setT_comienzo(so.getTiempoActual());
        so.aumentarTiempoActual(proceso.getT_rafaga());
        proceso.setT_final(so.getTiempoActual());

        /*Retorno y espera*/
        proceso.setT_retorno(proceso.getT_final() - proceso.getT_llegada());
        proceso.setT_espera(proceso.getT_final() - proceso.getT_llegada() - proceso.getT_rafaga());
        System.out.print("Ejecutando " + proceso.getNombre() + " ");

        /*Se agrega a la cola de finalizados*/
        so.getColaFinalizados().agregarProceso(proceso);
    }

    /**
     * Se obtiene la cantidad total de procesos del SO
     *
     * @return Se retorna la cantidad total de finalizados y listos
     */
    public int getCantidadProcesos() {
        Cola listos = so.getColaListos();
        Cola finalizados = so.getColaFinalizados();
        return finalizados.getTamano() + listos.getTamano();
    }
}
