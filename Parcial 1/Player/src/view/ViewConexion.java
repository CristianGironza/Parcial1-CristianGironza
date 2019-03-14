package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControllerConexion;

public class ViewConexion extends JFrame {

	private JButton btnConectar;
	private ControllerConexion control;
	
	public ViewConexion() {
		super("Conexión cliente");
		setLayout(new GridLayout(0,1));
		setSize(500,500);
		setLocationRelativeTo(null);
		btnConectar = new JButton("Conectar");
		add(btnConectar);
		
		control = new ControllerConexion(this);
		
	}

	public JButton getBtnConectar() {
		return btnConectar;
	}
	
	
}
