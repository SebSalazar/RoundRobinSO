package vista;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Titulo {
	JPanel panel = new JPanel();
	JLabel lblTitulo = new JLabel("Procesos Round Robin");


	public Titulo() {
		lblTitulo.setFont (lblTitulo.getFont().deriveFont(35.0f));
		panel.add(lblTitulo);
	}
	public JPanel getPanel() {
		return panel;
	}
}
