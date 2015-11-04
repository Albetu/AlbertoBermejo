package main;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box.Filler;

@SuppressWarnings("unused")
public class Pelota extends Dibujable {

	private Raqueta raqueta;

	//POSICION
	private  double x;
	private  double y;
	//velocidad
	private  double vx = -10;
	private  double vy = -10;	
	
	private Image img;

	public Pelota (Raqueta raqueta){
		this.raqueta = raqueta;
		
		
		try {
			img = ImageIO.read(new File("happy-face.png"));
			img = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void dibujar(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
	}



	@Override
	public void mover() {
		//  if(condicion){
		//     decir hola
		//  }
		//CUANDO TOQUE LA RAQUETA REBOTE
		//LA Y DE LA PELOTA +50 TIENE QUE SER MAYOR QUE LA Y DE LA RAQUETA
		//LA X DE LA PELOTA -25 TIENE QUE SER MAYOR QUE LA X DE LA RAQUETA
		//LA X DE LA PELOTA -25 TIENE QUE SER MENOR QUE LA X DE LA RAQUETA + 300
		if (y+50>raqueta.getY()&& x - 25>raqueta.getX() && x -25<raqueta.getX()+300){
			vy = -10;	
		}
		//BORDE IZQUIERDO
		if (x<0){
			vx = vx *-1;
		}
		//BORDE DERECHO
		if (x>Panel.ANCHO -img.getWidth(null)){
			vx = vx *-1;
		}
		//ALTURA
		if (y<0){
			vy = vy *-1;
		}

		//PARTE DE ABAJO
		if (y>Panel.ALTO -25){
			vy = vy *-1;
		}
		x = x + vx;
		y = y + vy;
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
