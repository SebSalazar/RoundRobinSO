package vista;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import logica.SO.SO;

public class Colas {
	JLabel listos;
	JLabel finalizados;
	JLabel bloqueados;
	
	JPanel panel;
	SO so;
	public Colas(SO so) {
		this.so=so;
		listos = new JLabel("Listos: Programa no iniciado");
		finalizados = new JLabel("Finalizados: Programa no iniciado");
		bloqueados = new JLabel ("Bloqueados: Programa no iniciado");
		
		panel= new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(244,70,17)),"Colas"));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(listos);
		panel.add(finalizados);
		panel.add(bloqueados);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	public void actualizarColas() {
		listos.setText(so.getColaListosFormateada());
		finalizados.setText(so.getColaFinalizadosFormateada());
		bloqueados.setText(so.getColaBloqueadosFormateada());
		
		panel.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(57,255,20),3),"Colas"));

	}
}
