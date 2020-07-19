package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import logica.Proceso;
import logica.SO.SO;

public class Grafica extends JFrame implements ActionListener {

    /* Logica */
    SO so = new SO();

    /* Elementos generales */
    Titulo titulo = new Titulo();
    Rejilla rejilla = new Rejilla(so);
    Tabla tabla = new Tabla();
    Botones botones = new Botones(this);
    TiempoActual tiempoActual = new TiempoActual(so);
    Colas colas = new Colas(so);

    public Grafica() {
        this.setLayout(new GridBagLayout());
        this.setSize(1200, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.cargarElementos();
        this.setVisible(true);
    }

    public void cargarElementos() {
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0; // El área de texto empieza en la columna cero.
        c.gridy = 0; // El área de texto empieza en la fila cero
        c.gridwidth = 7; // El área de texto ocupa dos columnas.
        c.gridheight = 1; // El área de texto ocupa 2 filas.
        this.add(titulo.getPanel(), c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 3;
        c.gridwidth = 7;
        this.add(rejilla.getPanel(), c);
        c.gridx = 0;
        c.gridy = 4;
        c.gridheight = 1;
        c.gridwidth = 7;
        this.add(colas.getPanel(), c);
        /*c.gridx = 0;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 7;
		this.add(tiempoActual.getPanel(),c);*/
        c.gridx = 0;
        c.gridy = 6;
        c.gridheight = 3;
        c.gridwidth = 7;
        this.add(tabla.getPanel(), c);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 9;
        c.gridheight = 1;
        c.gridwidth = 7;
        this.add(botones.getPanel(), c);

    }

    public void actualizarGrafica() {
        rejilla.actualizarDimensiones();
        tabla.repintarTabla(so.datos().getDatosTabla());
        colas.actualizarColas();
        tiempoActual.actualizarTiempoActual();
        this.getContentPane().validate();
        this.getContentPane().repaint();

    }

    public void nuevoProceso(String nombre, int rafaga) {
        so.gestionProcesos().insertarProceso(new Proceso(getRandomNombre(), getRandomRafaga(), getRandomPrioridad()));
        //so.insertarProceso(new Proceso(nombre, getRandomRafaga()));
        actualizarGrafica();
    }

    public void siguienteIteracion() {
        so.gestionProcesos().ejecutarProceso();
        actualizarGrafica();
    }

    public void bloquearSiguiente() {
        so.gestionBloqueados().bloquearSiguiente();
    }

    private String getRandomNombre() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 2) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    private int getRandomRafaga() {
        Random rand = new Random(); //instance of random class
        int upperbound = 10;
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound);
        return int_random + 1;
    }

    private int getRandomPrioridad() {
        Random rand = new Random(); //instance of random class
        int upperbound = 3;
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound);
        return int_random + 1;
    }

    private void desbloquear() {
        so.gestionBloqueados().desbloquear();
        actualizarGrafica();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botones.getBtnAgregar()) {
            nuevoProceso("a", 2);
        } else if (e.getSource() == botones.getBtnSiguiente()) {
            siguienteIteracion();
        } else if (e.getSource() == botones.getBtnBloquear()) {
            this.bloquearSiguiente();
            JOptionPane.showMessageDialog(null, "El siguiente proceso sera bloqueado");
        } else if (e.getSource() == botones.getBtnDesbloquear()) {
            this.desbloquear();
        }

    }

}
