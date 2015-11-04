package main;

import java.awt.Color;
import java.awt.Graphics;

public class Ladrillo extends Dibujable {
	@SuppressWarnings("unused")
	private double x;
	@SuppressWarnings("unused")
	private double y;
	@SuppressWarnings("unused")
	private double ancho;
	@SuppressWarnings("unused")
	private double alto;


	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(500, 300, 400, 100);
	}
}
