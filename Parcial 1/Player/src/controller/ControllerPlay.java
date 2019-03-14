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
		if(connection.isTurno()) {
			if(e.getSource().equals(view.getMp().getDeal())) {
				
			}else if(e.getSource().equals(view.getMp().getNotdeal())) {
				
			}
		}
	}

	@Override
	public void onConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String msj) {
		String[] re = new String[2];
		if(msj.contains("p")) {
			re = msj.split("p");
			if(view.getPt().getCard1().getText().equals("")) {
				view.getPt().getCard1().setText(re[1]);
			}else if(view.getPt().getCard2().getText().equals("")) {
				view.getPt().getCard2().setText(re[1]);
			}else if(view.getPt().getCard3().getText().equals("")) {
				view.getPt().getCard3().setText(re[1]);
			}else if(view.getPt().getCard4().getText().equals("")) {
				view.getPt().getCard4().setText(re[1]);
			}else if(view.getPt().getCard5().getText().equals("")) {
				view.getPt().getCard5().setText(re[1]);
			}
		}else if(msj.contains("m")) {
			re = msj.split("m");
			if(view.getMp().getMy1card().getText().equals("")) {
				view.getMp().getMy1card().setText(re[1]);
			}else if(view.getMp().getMy2card().getText().equals("")) {
				view.getMp().getMy2card().setText(re[1]);
			}
		}else if(msj.contains("Turno")) {
			
		}else {
			if(view.getPt().getIzq().getText().equals("")) {
				view.getPt().getIzq().setText(msj);
			}else {
				view.getPt().getDer().setText(msj);
			}
		}
	}
}
