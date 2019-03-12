package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import comunication.TCPConnection;
import comunication.TCPConnection.ConnectionEvent;
import view.ViewZone;
import view.ViewConexion;

public class ControllerConexion implements ActionListener, ConnectionEvent {
	
	private ViewConexion view;
	private TCPConnection connection;
	
	public ControllerConexion(ViewConexion view) {
		this.view=view;
		InitView();
	}
	
	private void InitView() {
		view.getBtnConectar().addActionListener(this);
		connection = TCPConnection.getInstance(0);
		connection.addConnectionEvent(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(view.getBtnConectar())) {
			String ip = view.getTfIP().getText();
			int puerto = Integer.parseInt(view.getTfPuerto().getText());
			System.out.println(ip);
			System.out.println(puerto);
			connection.connect(ip, puerto);
		}
	}

	@Override
	public void onConnection() {
		//Desplegar las siguiente ventana
		System.out.println("Conectados");
		view.setVisible(false);
		
		ViewZone chat = new ViewZone();
		chat.setVisible(true);
	}

	@Override
	public void onMessage(String msj) {
		
	}
}
