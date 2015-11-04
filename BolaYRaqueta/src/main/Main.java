package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.setUndecorated(true);
		v.setVisible(true);
		v.setExtendedState(JFrame.MAXIMIZED_BOTH);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
