package vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import logica.SO.SO;

public class Rejilla {

    JPanel panel;

    int tiempo;
    int numProcesos;

    SO so;

    JLabel gridBtn[][];

    /**
     * Constructor de la rejilla, a partir del so, obtiene el numero de procesos
     * y el tiempo de simulacion
     *
     * @param so El sistema operativo
     */
    public Rejilla(SO so) {

        this.so = so;
        panel = new JPanel();

        numProcesos = so.gestionProcesos().getCantidadProcesos();
        tiempo = so.getTiempoMaximo();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        actualizarDimensiones(4);

    }

    /**
     * Se actualizan las dimensiones de la rejilla, luego se llena de los datos
     */
    public void actualizarDimensiones() {
        panel.removeAll();

        numProcesos = so.gestionProcesos().getCantidadProcesos();
        tiempo = so.getTiempoMaximo();

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        gridBtn = new JLabel[numProcesos + 1][tiempo];

        for (int i = 0; i < numProcesos; i++) {

            JPanel aux = new JPanel();
            aux.setLayout(new GridLayout(1, tiempo));
            for (int j = 0; j < tiempo; j++) {

                gridBtn[i][j] = new JLabel(" ");
                gridBtn[i][j].setBackground(Color.WHITE);
                gridBtn[i][j].setBorder(border);
                gridBtn[i][j].setOpaque(true);
                aux.add(gridBtn[i][j]);
            }
            panel.add(aux);
        }
        actualizarDatos();
        for (int i = 0; i < tiempo; i++) {
            //gridBtn[numProcesos][i].setText(String.valueOf(i));
        }
        panel.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(0, 0, 0)), "Simulacion"));

    }

    /**
     * Se actualizan las dimensiones de la rejilla, luego se llena de los datos
     */
    public void actualizarDimensiones(int numProcesos) {
        panel.removeAll();

        tiempo = so.getTiempoMaximo();

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        gridBtn = new JLabel[numProcesos + 1][tiempo];

        for (int i = 0; i < numProcesos; i++) {

            JPanel aux = new JPanel();
            aux.setLayout(new GridLayout(1, tiempo));
            for (int j = 0; j < tiempo; j++) {

                gridBtn[i][j] = new JLabel(" ");
                gridBtn[i][j].setBackground(Color.WHITE);
                gridBtn[i][j].setBorder(border);
                gridBtn[i][j].setOpaque(true);
                aux.add(gridBtn[i][j]);
            }
            panel.add(aux);
        }
        actualizarDatos();
        for (int i = 0; i < tiempo; i++) {
            //gridBtn[numProcesos][i].setText(String.valueOf(i));
        }
        panel.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(0, 0, 0)), "Representacion"));

    }

    /**
     * Se obtienen los datos del SO y se representan
     */
    public void actualizarDatos() {
        String[][] datos = so.datos().getDatos();
        int cotaSup;
        int cotaInf;
        int cotaInfEspera;
        int cotaSupEspera;
        for (int i = 0; i < datos.length; i++) {
            gridBtn[i][0].setText(datos[i][0]);
            cotaInf = Integer.parseInt(datos[i][3]) + 1;
            cotaSup = Integer.parseInt(datos[i][4]);

            cotaInfEspera = Integer.parseInt(datos[i][1]) + 1;
            cotaSupEspera = Integer.parseInt(datos[i][3]);
            for (int k = cotaInfEspera; k <= cotaSupEspera; k++) {
                if (k != 0) {
                    gridBtn[i][k].setBackground(Color.cyan);
                }
            }
            for (int k = cotaInf; k <= cotaSup; k++) {
                gridBtn[i][k].setText(String.valueOf(k));

                if (k != 0) {
                    gridBtn[i][k].setBackground(Color.YELLOW);
                }
            }
            /*for(int k = 0 ;k<tiempo;k++) {
				gridBtn[i][k].setText(String.valueOf(k));
			}*/
        }
    }

    /**
     * Se limpia la rejilla y se ponen todos los espacios en blanco
     */
    public void limpiarRejilla() {
        for (int i = 0; i < numProcesos; i++) {
            for (int j = 0; j < tiempo; j++) {
                gridBtn[i][j].setBackground(Color.WHITE);
            }
        }
    }

    /**
     * ********************************************
     */
    /**
     * ********************GETTERS*****************
     */
    /**
     * ********************************************
     */
    public JPanel getPanel() {
        return panel;
    }

    public int getNumeroProcesos() {
        return numProcesos;
    }

    public int getTiempo() {
        return tiempo;
    }
}
