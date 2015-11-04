package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel{

	public static final double ANCHO = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final double ALTO = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	private ArrayList<Dibujable> dibujables = new ArrayList<Dibujable>();

	private boolean izquierda = false;
	private boolean derecha = false;

	Raqueta raqueta = new Raqueta();
	Pelota pelota = new Pelota(raqueta);

	public Panel(){
		setBackground(Color.BLACK);


		raqueta.setX(ANCHO/2-150);
		raqueta.setY(ALTO-50);

		pelota.setX(ANCHO/2-25);
		pelota.setY(ALTO-50);

		dibujables.add(raqueta);
		dibujables.add(pelota);
		Ladrillo ladrillo = new Ladrillo();
		dibujables.add(ladrillo);


		KeyListener kl = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					izquierda = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					derecha = true;
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					izquierda = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					derecha = false;
				}
			}



		};
		addKeyListener(kl);

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {}
					actualizarPosiciones();
					repaint();

				}
			}
		});
		t.start();



	}

	@Override
	public void paint(Graphics g){
		super.paint(g);

		for(Dibujable d : dibujables){
			d.dibujar(g);
		}
	}

	public void actualizarPosiciones(){
		for(Dibujable d : dibujables){
			d.mover();
		}
		boolean noSePasaIzquierda = (raqueta.getX()>0);
		boolean noSePasaDerecha = (raqueta.getX()+300<ANCHO);

		if(izquierda && noSePasaIzquierda){
			raqueta.setX(raqueta.getX()-10);
		}
		if(derecha && noSePasaDerecha){
			raqueta.setX(raqueta.getX()+10);
		}

	}

}

