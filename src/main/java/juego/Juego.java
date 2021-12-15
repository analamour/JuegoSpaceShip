package juego;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JPanel;


public class Juego extends JPanel {
	private static final long serialVersionUID = 1L;
	URL direccionSonidoSalto, direccionSonidoChoque;
	AudioClip sonidoChoque, sonidoSalto;

	Personaje personaje = new Personaje(this);
<<<<<<< HEAD
	Asteroide2 enemigo = new Asteroide2(this);
	Asteroide asteroide = new Asteroide(this);
=======
	Enemigo enemigo = new Enemigo(this);
	AsteroideDiagonalAbajo asteroideDiagonalAbajo = new AsteroideDiagonalAbajo(this);
>>>>>>> 838314b19da03a92b1d7a1126649b8e784314fe0
	Fondo fondo = new Fondo(this);

	public static boolean juegoFinalizado = false;
	public static boolean pierdeIntentoVida = false;
	public static int intentosVidas = 3;
	public static int nivel = 1;
	public static int puntos = 0;
	private ArrayList<Image> auxImgsAsteroide = new ArrayList<Image>();
	


	public Juego() {
		direccionSonidoChoque = this.getClass().getResource("/sonido/SonidoChoque.wav");
		sonidoChoque = Applet.newAudioClip(direccionSonidoChoque);

		direccionSonidoSalto = this.getClass().getResource("/sonido/FondoMusica.wav");
		sonidoSalto = Applet.newAudioClip(direccionSonidoSalto);

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
					sonidoSalto.play();
					personaje.keyPressed(e);
				}

			@Override
			public void keyReleased(KeyEvent e) {
					sonidoSalto.play();
			}
		});
		setFocusable(true);
	}
	
	public void mover() {
		enemigo.mover();
		personaje.mover();
		asteroideDiagonalAbajo.mover();
		fondo.mover();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		dibujar(g2D);
		dibujarPuntaje(g2D);
	}

	public void dibujar(Graphics2D g) {
		fondo.paint(g);
		personaje.paint(g);
		enemigo.paint(g);
		asteroideDiagonalAbajo.paint(g);
		mover();
	}

	public void dibujarPuntaje(Graphics2D g) {
		Graphics2D g1 = g, g2D = g;
		Font score = new Font("Tahoma", Font.BOLD, 30);
		g.setFont(score);
		g.setColor(Color.WHITE);
		g1.drawString("Puntos: " + puntos, 1100, 30);
		g1.drawString("Intentos: " + intentosVidas, 20, 30);
		g1.drawString("Nivel: " + nivel, 570, 30);

		if (juegoFinalizado) {
			g2D.setColor(Color.BLACK);
			g2D.drawString("Gracias", ((float) getBounds().getCenterX() / 2) + 210, 70);
		}
	}

	public void finJuego() {
		juegoFinalizado = true;
		sonidoChoque.play();
	}

	public void pierdeIntentoVida() {
		sonidoChoque.play();
		pierdeIntentoVida = true;
	}

	

	public ArrayList<Image> getAuxImgsAsteroide(){return auxImgsAsteroide;}
	public void setAuxImgsAsteroide(ArrayList<Image> auxImgsAsteroide){this.auxImgsAsteroide = auxImgsAsteroide;}
}
