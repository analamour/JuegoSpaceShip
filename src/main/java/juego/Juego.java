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
	URL direccionSonidoNave, direccionSonidoChoque;
	AudioClip sonidoChoque, sonidoNave;

	Personaje personaje = new Personaje(this);
	Asteroide2 asteroide2 = new Asteroide2(this);
	Asteroide asteroide = new Asteroide(this);
	AsteroideDiagonalAbajo asteroideDiagonalAbajo = new AsteroideDiagonalAbajo(this);
	AsteroideDiagonalArriba asteroideDiagonalArriba = new AsteroideDiagonalArriba(this);
	Fondo fondo = new Fondo(this);

	public static boolean juegoFinalizado = false;
	public static boolean pierdeIntentoVida = false;
	public static int intentosVidas = 3;
	public static int nivel = 1;
	public static int puntos = 0;


	public Juego() {
		direccionSonidoChoque = this.getClass().getResource("/sonido/SonidoChoque.wav");
		sonidoChoque = Applet.newAudioClip(direccionSonidoChoque);

		direccionSonidoNave = this.getClass().getResource("/sonido/FondoMusica.wav");
		sonidoNave = Applet.newAudioClip(direccionSonidoNave);

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				sonidoNave.play();
				personaje.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				sonidoNave.play();
			}
		});
		setFocusable(true);
	}

	public void mover() {
		
		personaje.mover();

		asteroideDiagonalArriba.mover();
		asteroide2.mover();	
		fondo.mover();
		if (Juego.puntos >= 50)
			asteroide.mover();
		if (Juego.puntos >= 10)
			asteroideDiagonalAbajo.mover();

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
		asteroide2.paint(g);
		asteroideDiagonalArriba.paint(g);
		mover();
		if (Juego.puntos >= 50)
			asteroide.paint(g);
		if (Juego.puntos >= 10)
			asteroideDiagonalAbajo.paint(g);

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
}
