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
	private String ip;
	private int port;
	
	public ControllerConexion(ViewConexion view) {
		this.view=view;
		InitView();
	}
	
	private void InitView() {
		view.getBtnConectar().addActionListener(this);
		connection = TCPConnection.getInstance(0);
		connection.addConnectionEvent(this);
		ip="127.0.0.1";
		port = 5000;
				
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(view.getBtnConectar())) {
			connection.connect(ip, port);
		}
	}

	@Override
	public void onConnection() {
		view.setVisible(false);
		
		ViewZone chat = new ViewZone();
		chat.setVisible(true);
	}

	@Override
	public void onMessage(String msj) {
		
	}
}
