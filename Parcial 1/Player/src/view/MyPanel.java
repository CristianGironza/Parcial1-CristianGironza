package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	private JLabel my1card;
	private JLabel my2card;
	private JButton deal;
	private JButton notdeal;
	public MyPanel() {
		setLayout(new GridLayout());
		setBackground(new Color(59, 137, 23));
		my1card = new JLabel();
		my2card = new JLabel();
		deal = new JButton("SEGUIR");
		deal.setBackground(Color.white);
		notdeal = new JButton("QUEDARSE");
		notdeal.setBackground(Color.white);
		add(my1card);
		add(my2card);
		add(deal);
		add(notdeal);
	}
	public JLabel getMy1card() {
		return my1card;
	}
	public void setMy1card(JLabel my1card) {
		this.my1card = my1card;
	}
	public JLabel getMy2card() {
		return my2card;
	}
	public void setMy2card(JLabel my2card) {
		this.my2card = my2card;
	}
	public JButton getDeal() {
		return deal;
	}
	public void setDeal(JButton deal) {
		this.deal = deal;
	}
	public JButton getNotdeal() {
		return notdeal;
	}
	public void setNotdeal(JButton notdeal) {
		this.notdeal = notdeal;
	}
}
