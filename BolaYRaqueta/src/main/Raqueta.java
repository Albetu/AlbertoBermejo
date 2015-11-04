package main;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Raqueta extends Dibujable{

	private double x;
	private double y;	
	private Image img;
	
	public Raqueta(){
	
		try {
			img = ImageIO.read(new File("images.png"));
			img = img.getScaledInstance(300, 50, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}
	@Override
	public void dibujar(Graphics g){
	g.drawImage(img, (int)x, (int)y, null);
	}
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}
