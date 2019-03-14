package comunication;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPConnection {
	
	private static TCPConnection instance = null;
	
	private TCPConnection(int port) {
		
	}
	
	public synchronized static TCPConnection getInstance(int port) {
		if(instance == null) {
			instance = new TCPConnection(port);
		}
		return instance;
	}
	
	public synchronized static TCPConnection getInstance() {
		return instance;
	}
	
	//Global
	private Socket socket;
	private ServerSocket server;
	private Emisor emisor;
	private Receptor receptor;
	private boolean turno;
	
	public boolean isTurno() {
		return turno;
	}

	//Metodo del servidor
	public void waitForConnection(int port) {
		try {
			if(server==null) {
				server=new ServerSocket(port);
			}
			System.out.println("Esperando cliente");
			socket = server.accept();
			System.out.println("Cliente conectado!");
			if(listeners==null) {
				listeners = new ArrayList<TCPConnection.ConnectionEvent>();
			}
			receptor = new Receptor(socket.getInputStream(), listeners);
			receptor.start();
			emisor = new Emisor(socket.getOutputStream());
			
			for(int i=0; i<listeners.size();i++) {
				listeners.get(i).onConnection();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Metodo del cliente
	public void connect(String ip, int port) {
		try {
			turno = false;
			socket = new Socket(ip, port);
			if(listeners==null) {
				listeners = new ArrayList<TCPConnection.ConnectionEvent>();
			}
			receptor = new Receptor(socket.getInputStream(), listeners);
			receptor.start();
			emisor = new Emisor(socket.getOutputStream());
			
			for(int i=0; i<listeners.size();i++) {
				listeners.get(i).onConnection();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setTurno(boolean turno) {
		this.turno = turno;
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
	
	public interface ConnectionEvent{
		void onConnection();
		void onMessage(String msj);
	}
	
	private List<ConnectionEvent> listeners;
	
	public void addConnectionEvent(ConnectionEvent lis) {
		if(listeners == null) {
			listeners = new ArrayList<TCPConnection.ConnectionEvent>();
		}
		listeners.add(lis);
	}
	
}