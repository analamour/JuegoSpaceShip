package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import javax.swing.ImageIcon;

public class AsteroideDiagonalAbajo {

	Juego miJuego;
	Area cuerpo;
	int anchoAsteroide = 100;
	int altoAsteroide = 80;
	static int inicialX = 200;
	static int inicialY = (int) Math.floor(Math.random() * (580 - 30 + 1) + 30);
	static int auxiliarX = -6;
	int auxiliarY = 0;

	public AsteroideDiagonalAbajo(Juego miJuego) {
		this.miJuego = miJuego;
	}

	public void mover() {
		if (inicialX <= -100) {
			Juego.puntos++;
			inicialX = 1300;
			// Instancio asteroide en un numero aleatorio entre 30 y 580 de Y
			inicialY = (int) Math.floor(Math.random() * (580 - 10 + 1) + 30);

			// Si el numero de puntos es divisible por 7 sube nivel y aumenta velocidad
			if (Juego.puntos % 7 == 0) {
				auxiliarX += -2;
				Juego.nivel++;
				if (auxiliarX <= -20) {
					auxiliarX = -20;
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
				inicialY += 3;
				// Movimiento DIagonal Abajo del Asteroide
				int aleatorioAlto = (int) Math.floor(Math.random() * (400 - 300 + 1) + 300);
				int aleatorioBajo = (int) Math.floor(Math.random() * (150 - 30 + 1) + 30);
				if (inicialY <= aleatorioAlto)
					inicialY += 1;
				if (inicialY >= aleatorioBajo)
					inicialY -= 3;
			}
		}
	}

	public void paint(Graphics2D g) {
		ImageIcon asteroid = new ImageIcon(this.getClass().getResource("/imagenes/Asteroide2.png"));
		g.drawImage(asteroid.getImage(), inicialX, inicialY, anchoAsteroide, altoAsteroide, null);
	}

	public Area getBounds() {
		Rectangle cuerpoAsteroide = new Rectangle(inicialX + 12, inicialY + 16, 50, 53);
		cuerpo = new Area(cuerpoAsteroide);

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
}
