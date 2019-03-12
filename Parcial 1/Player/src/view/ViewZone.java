package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ControllerChat;

public class ViewZone extends JFrame {
	
	private JLabel izq;
	private JLabel der;
	private JLabel card1;
	private JLabel card2;
	private JLabel card3;
	private JLabel card4;
	private JLabel card5; 
	private JLabel my1card;
	private JLabel my2card;
	private JButton deal;
	private JButton notdeal;
	
	private ControllerChat controller;
	
	public ViewZone() {
		super("Holden TEXAX");
		setLayout(new GridLayout(7,1));
		setSize(500,500);
		izq = new JLabel("");
		der = new JLabel("");
		card1 = new JLabel("");
		card2 = new JLabel("");
		card3 = new JLabel("");
		card4 = new JLabel("");
		card5 = new JLabel("");
		my1card = new JLabel("");
		my2card = new JLabel("");
		deal = new JButton("SEGUIR");
		notdeal = new JButton("RETIRARSE");
		
		
		
		controller = new ControllerChat(this);
	}

	public void setIzq(JLabel izq) {
		this.izq = izq;
	}

	public void setDer(JLabel der) {
		this.der = der;
	}

	public void setCard1(JLabel card1) {
		this.card1 = card1;
	}

	public void setCard2(JLabel card2) {
		this.card2 = card2;
	}

	public void setCard3(JLabel card3) {
		this.card3 = card3;
	}

	public void setCard4(JLabel card4) {
		this.card4 = card4;
	}

	public void setCard5(JLabel card5) {
		this.card5 = card5;
	}

	public void setMy1card(JLabel my1card) {
		this.my1card = my1card;
	}

	public void setMy2card(JLabel my2card) {
		this.my2card = my2card;
	}

	public void setDeal(JButton deal) {
		this.deal = deal;
	}

	public void setNotdeal(JButton notdeal) {
		this.notdeal = notdeal;
	}

	public void setController(ControllerChat controller) {
		this.controller = controller;
	}
}