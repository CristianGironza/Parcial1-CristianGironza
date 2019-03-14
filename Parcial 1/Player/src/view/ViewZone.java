package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.ControllerPlay;

public class ViewZone extends JFrame {
	private PanelTable pt;
	private MyPanel mp;
	private ControllerPlay controller;
	
	public ViewZone() {
		super("Holden TEXAX");
		setLayout(new BorderLayout());
		setSize(1500,200);
		pt=new PanelTable();
		add(pt,BorderLayout.CENTER);
		mp = new MyPanel();
		add(mp,BorderLayout.SOUTH);
		controller = new ControllerPlay(this);
	}

	public PanelTable getPt() {
		return pt;
	}

	public MyPanel getMp() {
		return mp;
	}
}