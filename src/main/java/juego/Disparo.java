package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import javax.swing.ImageIcon;

public class Disparo {
	Juego miJuego;
	Area cuerpo;
	int anchoDisparo = 70;
	int altoDisparo = 70;
	static int inicialX = 1300;
	static int inicialY = (int) Math.floor(Math.random() * (580 - 30 + 1) + 30);
	static int auxiliarX = -4;
	boolean disparo = false;

	public Disparo(Juego miJuego) {
		this.miJuego = miJuego;
	}

	public void mover() {
		if (inicialX <= -100) {
			Juego.puntos++;
			inicialX = 1300;
			inicialY = (int) Math.floor(Math.random() * (580 - 30 + 1) + 30);
			// Si el numero de puntos es divisible por 5 se aumenta velocidad asteroides
			if (Juego.puntos % 5 == 0) {
				auxiliarX += -3;
				// imprimo por pantalla nivel y velocidad
				System.out.println(Juego.nivel);
				System.out.println("Este es AuxiliarX" + auxiliarX);
				// Seteo velocidad maxima del asteroide en menos 30
				if (auxiliarX <= -30) {
					auxiliarX = -30;
				}
			}
		} else {
			if (colision()) {

				if (Juego.intentosVidas == 0) {
					miJuego.finJuego();
				} else {
					miJuego.pierdeIntentoVida();
				}
			} else {
				inicialX += auxiliarX;
			}
		}
	}

	public void paint(Graphics2D g) {
		ImageIcon asteroid = new ImageIcon(this.getClass().getResource("/imagenes/Asteroide1.png"));
		g.drawImage(asteroid.getImage(), inicialX, inicialY, anchoDisparo, altoDisparo, null);
	}

	public Area getBounds() {
		Rectangle cuerpoEnemigo = new Rectangle(inicialX + 12, inicialY + 16, 50, 53);
		cuerpo = new Area(cuerpoEnemigo);
		return cuerpo;
	}

	public boolean colision() {
		Area areaInt = new Area(miJuego.personaje.getBounds());
		areaInt.intersect(getBounds());
		return !areaInt.isEmpty();
	}

	public int getCoordX() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			auxiliarX = 10;
			inicialX += auxiliarX;
			disparo = true;
		}
	}
}