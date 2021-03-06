package com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TCPconnection {
	
	private static TCPconnection instance = null;
	
	private TCPconnection() {
		if(listeners == null) listeners = new ArrayList<>();
		connections = new ArrayList<Connection>();
		cartas = new ArrayList<String>();
		turno =0;
	}
	
	public synchronized static TCPconnection getInstance() {
		if(instance == null) {
			instance = new TCPconnection();
		}
		return instance;
	}
	
	//Global
	
	private ServerSocket server;
	public List<Connection> getConnections() {
		return connections;
	}

	private List<Connection> connections;
	private List<ConnectionEvent> listeners;
	private List<String> cartas;
	private int turno;
	
	
	//Metodo del servidor
	public void waitForConnection(int port) {
		try {
			server = new ServerSocket(port);
			while(true) {
				Socket socket = server.accept();
				Connection connection = new Connection(socket);
				connection.defineListeners(listeners);
				connection.init(getClient()+1);
				connections.add(connection);
				for(int i=0 ; i<listeners.size() ; i++) listeners.get(i).onConnection();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Hacer la clase sea observable
	public interface ConnectionEvent{
		void onConnection();
		void onMessage(int player,String msj);
	}
	
	
	public void addConnectionEvent(ConnectionEvent listener) {
		listeners.add(listener);
	}

	public int getClient() {
		return connections.size();
	}

	public void sendBroadcast(String line) {
		for(int i=0; i<getClient();i++) {
			connections.get(i).sendMessage(line);
		}
	}


	public void sendDirectMessage(int player, String mensaje) {
		connections.get(player).sendMessage(mensaje);
	}
	
	public String GenerateCard() {
		String[] tipo = {"T","C","P","D"};
		Random r = new Random();
		boolean repetida = true;
		String numero ="";
		while(repetida) {
			numero =""+(r.nextInt(13)+1);
			if(numero.equals("11")) {
				numero = "J";
			}
			if(numero.equals("12")) {
				numero = "Q";
			}
			if(numero.equals("13")) {
				numero = "k";
			}
			
			numero=numero+(tipo[r.nextInt(4)]);
			if(!cartas.contains(numero)) {
				repetida = false;
			}
		}
		cartas.add(numero);
		return numero;
	}
	
	public void Start() {
		for(int i=0;i<3;i++) {
			sendBroadcast("p"+GenerateCard());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0;i<getClient();i++) {
			sendDirectMessage(i, "m"+GenerateCard());
			sendDirectMessage(i, "m"+GenerateCard());
		}
		
		for(int i=0;i<getClient();i++) {
			try {
				if(i==0) {
					sendDirectMessage(i,""+connections.get(1).getJug());
					sendDirectMessage(i,""+connections.get(2).getJug());
				}else if(i==1) {
					sendDirectMessage(i,""+connections.get(0).getJug());
					sendDirectMessage(i,""+connections.get(2).getJug());
				}else if(i==2) {
					sendDirectMessage(i,""+connections.get(0).getJug());
					sendDirectMessage(i,""+connections.get(1).getJug());
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
				
		
	}
		sendBroadcast("Turno"+turno);
		turno++;
	}
}