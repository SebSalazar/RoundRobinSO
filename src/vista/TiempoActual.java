package vista;

import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.SO.SO;

public class TiempoActual {
	JLabel tiempoActual;
	
	JPanel panel;
	SO so;
	public TiempoActual(SO so) {
		this.so = so;
		panel = new JPanel();
		tiempoActual = new JLabel("Tiempo sin inicializar");
		panel.add(tiempoActual);
	}
	public void actualizarTiempoActual() {
		int tiempo = so.getTiempoActual();
		tiempoActual.setText("Tiempo actual: "+String.valueOf(tiempo));
	}
	public JPanel getPanel() {
		return panel;
		
	}
}
