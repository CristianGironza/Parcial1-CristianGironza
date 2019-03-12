package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControllerConexion;

public class ViewConexion extends JFrame {
	
	private JLabel labelIntro;
	private JTextField tfIP;
	private JTextField tfPuerto;
	private JButton btnConectar;
	private ControllerConexion control;
	
	public ViewConexion() {
		super("Conexión cliente");
		setLayout(new GridLayout(0,1));
		setSize(500,500);
		setLocationRelativeTo(null);
		labelIntro = new JLabel("Por favor ingrese la direccion IP y el puerto para conextarse con un servidor");
		tfIP = new JTextField();
		tfPuerto = new JTextField();
		btnConectar = new JButton("Conectar");
		
		add(labelIntro);
		add(tfIP);
		add(tfPuerto);
		add(btnConectar);
		
		control = new ControllerConexion(this);
		
	}


	public JLabel getLabelIntro() {
		return labelIntro;
	}


	public JTextField getTfIP() {
		return tfIP;
	}


	public JTextField getTfPuerto() {
		return tfPuerto;
	}


	public JButton getBtnConectar() {
		return btnConectar;
	}
	
	
}
