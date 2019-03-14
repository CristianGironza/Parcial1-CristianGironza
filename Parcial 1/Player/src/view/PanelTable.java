package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTable extends JPanel {
	private JLabel izq;
	private JLabel der;
	private JLabel card1;
	private JLabel card2;
	private JLabel card3;
	private JLabel card4;
	private JLabel card5; 
	
	public PanelTable() {
		setLayout(new GridLayout());
		setBackground(new Color(59, 137, 23));
		izq = new JLabel();
		der = new JLabel();
		card1 = new JLabel();
		card2 = new JLabel();
		card3 = new JLabel();
		card4 = new JLabel();
		card5 = new JLabel();
		add(izq);
		add(card1);
		add(card2);
		add(card3);
		add(card4);
		add(card5);
		add(der);
	}

	public JLabel getIzq() {
		return izq;
	}

	public void setIzq(JLabel izq) {
		this.izq = izq;
	}

	public JLabel getDer() {
		return der;
	}

	public void setDer(JLabel der) {
		this.der = der;
	}

	public JLabel getCard1() {
		return card1;
	}

	public void setCard1(JLabel card1) {
		this.card1 = card1;
	}

	public JLabel getCard2() {
		return card2;
	}

	public void setCard2(JLabel card2) {
		this.card2 = card2;
	}

	public JLabel getCard3() {
		return card3;
	}

	public void setCard3(JLabel card3) {
		this.card3 = card3;
	}

	public JLabel getCard4() {
		return card4;
	}

	public void setCard4(JLabel card4) {
		this.card4 = card4;
	}

	public JLabel getCard5() {
		return card5;
	}

	public void setCard5(JLabel card5) {
		this.card5 = card5;
	}
}
