package launcher;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.TCPconnection;
import com.TCPconnection.ConnectionEvent;

public class Main implements ConnectionEvent {
	
	private TCPconnection manager;
	
	public static void main(String[] args) {
		Main m = new Main();
		m.execute();

	}
	
	public void execute() {
		manager = TCPconnection.getInstance();
		manager.addConnectionEvent(this);
		
		new Thread(()->manager.waitForConnection(5000)).start();
		
	}

	@Override
	public void onConnection() {
		if(manager.getClient()==3) {
			JOptionPane.showMessageDialog(null, "SALA LLENA");
		}
	}

	@Override
	public void onMessage(int player, String msj) {
		
	}
}
