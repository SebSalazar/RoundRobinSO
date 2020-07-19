package vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla {
	JPanel panel;
	
	JTable tabla;
	JScrollPane scroll;
	String[] columnas = {"PROCESO","PRIORIDAD","TIEMPO LLEGADA","RAFAGA","TIEMPO COMIENZO","TIEMPO FINAL","TIEMPO RETORNO","TIEMPO ESPERA"};
	DefaultTableModel modelo;
	
	public Tabla() {

		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		String[][] datos = {{},{},{}};
		tabla= new JTable(new DefaultTableModel(datos, columnas));
		scroll=new JScrollPane(tabla);
		panel.add(scroll,BorderLayout.CENTER);
	}
	public void repintarTabla(String[][] datos) {
		tabla.setModel(new DefaultTableModel(datos, columnas));

	}
	public JPanel getPanel() {
		return panel;
	}
}
