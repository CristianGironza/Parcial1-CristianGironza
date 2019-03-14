package com;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.UUID;

import com.TCPconnection.ConnectionEvent;

public class Connection {

	public Receptor getReceptor() {
		return receptor;
	}

	public Emisor getEmisor() {
		return emisor;
	}

	public Socket getSocket() {
		return socket;
	}

	public List<ConnectionEvent> getListeners() {
		return listeners;
	}

	public Connection(Socket socket2) {
		socket = socket2;
	}
	
	private Receptor receptor;
	private Emisor emisor;
	private Socket socket;
	private List<ConnectionEvent> listeners;
	private int jug;
	
	public int getJug() {
		return jug;
	}

	public void defineListeners(List<ConnectionEvent> listeners) {
		this.listeners = listeners;
	}
	
	public void init(int j) {
		try {
			receptor = new Receptor(socket.getInputStream());
			receptor.defineListeners(listeners);
			receptor.start();
			emisor = new Emisor(socket.getOutputStream());
			jug = j;
		}catch (Exception e) {
			
		}
	}
	
	public void sendMessage(String msj) {
		emisor.enviarMensaje(msj);
	}
	
	public void closeConnection() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
