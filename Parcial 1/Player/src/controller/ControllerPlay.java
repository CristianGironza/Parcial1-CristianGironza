package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import comunication.TCPConnection;
import comunication.TCPConnection.ConnectionEvent;
import view.ViewZone;

public class ControllerPlay implements ActionListener, ConnectionEvent {
	
	private ViewZone view;
	TCPConnection connection;
	public ControllerPlay(ViewZone v) {
		view = v;
		initView();
	}

	public void initView() {
		view.getMp().getDeal().addActionListener(this);
		view.getMp().getNotdeal().addActionListener(this);
		connection = TCPConnection.getInstance();
		connection.addConnectionEvent(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(view.getMp().getDeal())) {
			
		}else if(e.getSource().equals(view.getMp().getNotdeal())) {
			
		}
//		if(e.getSource().equals(view.getBtnEnviar())) {
//			Mensaje msj = new Mensaje(view.getTfEntrada().getText());
//			connection.sendMessage(msj.toString());
//			view.getTaMensajes().append(view.getTfEntrada().getText()+"\n");
//			view.getTfEntrada().setText("");
//		}
	}

	@Override
	public void onConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String msj) {
//		System.out.println(">>ControllerChat"+msj);
//		Mensaje recibido = Mensaje.fromJson(msj.trim());
//		view.getTaMensajes().append(recibido.getMensaje()+":"+recibido.getFecha()+"\n");
	}
}
