package juego;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Inicializador {
	public static int reiniciaJuego = -1;
	public static Audio audio;

	public static void main(String[] args) {

		cargarSonidos();
		audio.tocarSonido("Stage7");
		JOptionPane.showMessageDialog(null, "Comenzar a Jugar");
		System.setProperty("sun.java2d.opengl", "true");
		JFrame ventana = new JFrame("SpaceShip");
		Juego miJuego = new Juego();
		ventana.add(miJuego);
		ventana.setSize(1300, 700);
		ventana.setVisible(true);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			if (Juego.juegoFinalizado) {
				reiniciaJuego = JOptionPane.showConfirmDialog(null,
						"             GAME OVER  \n           ¿Volver a jugar?", null, JOptionPane.YES_NO_OPTION);
				if (reiniciaJuego == 0) {
					reiniciaValores();
				} else if (reiniciaJuego == 1) {
					System.exit(0);
				}
			} else {
				miJuego.repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (Juego.pierdeIntentoVida == true) {
					JOptionPane.showMessageDialog(null, "Te quedan: " + Juego.intentosVidas + " intentos");
					Juego.pierdeIntentoVida = false;
					Juego.intentosVidas--;
					Personaje.inicialY = 270;
//					Disparo.inicialY = 200;
					Asteroide2.inicialY = (int) Math.floor(Math.random() * (30 - 580 + 1) + 30);
					Asteroide2.inicialX = (int) Math.floor(Math.random() * (30 - 580 + 1) + 30);
					AsteroideDiagonalAbajo.inicialX = 1300;
					AsteroideDiagonalAbajo.inicialY = (int) Math.floor(Math.random() * (30 - 580 + 1) + 30);
					AsteroideDiagonalArriba.inicialX = 1300;
					AsteroideDiagonalArriba.inicialY = (int) Math.floor(Math.random() * (30 - 580 + 1) + 30);

				}
			}
		}
	}

	public static void reiniciaValores() {
		Juego.juegoFinalizado = false;
		Asteroide2.auxiliarX = -4;
		Juego.puntos = 0;
		Juego.intentosVidas = 3;
		Juego.nivel = 1;
		reiniciaJuego = -1;
		Asteroide2.inicialX = 1300;
//		Disparo.inicialY = 0;
	}

	public static void cargarSonidos() {
		try {
			audio = new Audio();
			audio.agregarAudio("Stage1", "sonido/8bits/8bit Stage1 Loop.wav");
			audio.agregarAudio("Stage2", "sonido/8bits/8bit Stage7 Loop.wav");
			audio.agregarAudio("Stage3", "sonido/8bits/8bit Stage4 Loop.wav");
			audio.agregarAudio("Stage7", "sonido/8bits/8bit Stage7 Loop.wav");
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
	}

}
