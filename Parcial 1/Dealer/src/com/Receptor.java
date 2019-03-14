package com;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.TCPconnection.ConnectionEvent;

public class Receptor extends Thread{
	private InputStream input;
	private boolean isAlive = true;
	private List<ConnectionEvent> listeners;
	
	public Receptor(InputStream input) {
		this.input = input;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			while( isAlive ) {
				String line = reader.readLine();
				if(line ==  null) {
					input.close();
				}
			
				for(int i=0 ; i<listeners.size() ; i++) listeners.get(i).onMessage(-1,line);
			}
		}catch(IOException ex) {
			
		}
	}

	public void defineListeners(List<ConnectionEvent> listeners2) {
		this.listeners = listeners2;
	}

}