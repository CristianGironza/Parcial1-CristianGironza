package launcher;

import java.util.Scanner;

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
		
		Scanner s = new Scanner(System.in);
		while(true) {
			String line = s.nextLine();
			manager.sendBroadcast(line);
			
		}
	}

	@Override
	public void onConnection() {
		if(manager.getClient()==3) {
			System.out.println("listos para Jugar");
		}
	}

	@Override
	public void onMessage(String uuid, String msj) {
		if(msj.equals("myid")) {
			manager.getConnectionById(uuid).sendMessage(uuid);
			
		}else if(msj.contains("::")){
			String[] data = msj.split("::");
			manager.sendDirectMessage(uuid, data[0], data[1]);
		}else {
			System.out.println(uuid +":"+msj);
		}
	}
}
