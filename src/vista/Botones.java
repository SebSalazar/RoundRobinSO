package vista;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Botones {
	JPanel panel = new JPanel();
	JButton btnAgregar = new JButton("agregar proceso");
	JButton btnSiguiente = new JButton("siguiente");
	JButton btnBloquear = new JButton("bloquear el siguiente");
	JButton btnDesbloquear = new JButton("desbloquear)");
	public Botones(ActionListener listener) {
		btnAgregar.addActionListener(listener);
		btnSiguiente.addActionListener(listener);
		btnBloquear.addActionListener(listener);
		btnDesbloquear.addActionListener(listener);
		
		panel.add(btnAgregar);
		panel.add(btnSiguiente);
		panel.add(btnBloquear);
		panel.add(btnDesbloquear);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	public JButton getBtnAgregar() {
		return btnAgregar;
	}
	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}
	public JButton getBtnBloquear() {
		return btnBloquear;
	}
	public JButton getBtnDesbloquear() {
		return btnDesbloquear;
	}
}
