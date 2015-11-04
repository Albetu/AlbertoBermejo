package main;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Ventana extends JFrame{

	public Ventana(){
		Panel miPanel = new Panel();
		setContentPane(miPanel);
		miPanel.setFocusable(true);
		miPanel.requestFocus();
	}
	
}
