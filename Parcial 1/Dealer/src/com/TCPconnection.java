package com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class TCPconnection {
	
	private static TCPconnection instance = null;
	
	private TCPconnection() {
		if(listeners == null) listeners = new ArrayList<>();
		connections = new HashMap<String, Connection>();
	}
	
	public synchronized static TCPconnection getInstance() {
		if(instance == null) {
			instance = new TCPconnection();
		}
		return instance;
	}
	
	//Global
	
	private ServerSocket server;
	private HashMap<String, Connection> connections;
	private List<ConnectionEvent> listeners;
	
	
	//Metodo del servidor
	public void waitForConnection(int port) {
		try {
			server = new ServerSocket(port);
			
			while(true) {
				System.out.println("Esperando cliente");
				Socket socket = server.accept();
				System.out.println("Cliente conectado!");
				Connection connection = new Connection(socket);
				connection.defineListeners(listeners);
				connection.init();
				connections.put(connection.getUuid(), connection);
				
				for(int i=0 ; i<listeners.size() ; i++) listeners.get(i).onConnection();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Hacer la clase sea observable
	public interface ConnectionEvent{
		void onConnection();
		void onMessage(String uuid,String msj);
	}
	
	
	public void addConnectionEvent(ConnectionEvent listener) {
		listeners.add(listener);
	}

	public int getClient() {
		return connections.size();
	}

	public void sendBroadcast(String line) {
		for(String key :connections.keySet()) {
		connections.get(key).sendMessage(line);
		}
	}

	public Connection getConnectionById(String uuid) {
		return connections.get(uuid);
	}

	public void sendDirectMessage(String remitente, String destinatario, String mensaje) {
		getConnectionById(destinatario).sendMessage(remitente+":"+mensaje);
	}
}