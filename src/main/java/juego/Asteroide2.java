package juego;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Area;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Asteroide2 {


	Juego miJuego;
	Area cuerpo;
	int anchoEnemigo = 70;
	int altoEnemigo = 90;
	static int inicialX = 1300;
    static int inicialY = (int) Math.floor(Math.random()*(580-30+1)+30);
	static int auxiliarX = -4;
	public Asteroide2(Juego miJuego) {
		this.miJuego = miJuego;
	}

	
	public void mover() {
		if (inicialX <= -100) {
			Juego.puntos++;
			inicialX = 1300;
			inicialY = (int) Math.floor(Math.random()*(580-30+1)+15);
            // Si el numero de puntos es divisible por 5 se aumenta velocidad asteroides
			if (Juego.puntos % 5 == 0) {
				auxiliarX += -3;
				// imprimo por pantalla nivel y velocidad
//				System.out.println(Juego.nivel);
//				System.out.println("Este es AuxiliarX" + auxiliarX);
				// Seteo velocidad maxima del asteroide en menos 30
				if (auxiliarX <= -30 ) {
					auxiliarX = -30;
				}	
				if (Juego.puntos % 2 == 0) {
					auxiliarX += -2;
					Juego.nivel++;
					if (auxiliarX <= -10 ) {
						auxiliarX = -10;
					}
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
		g.drawImage(asteroid.getImage(), inicialX, inicialY, anchoEnemigo, altoEnemigo, null);
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

//	public void DibujarColision() {
//		for (int i=1; i<=7; i++){
//			Image image  = t.getImage(getClass().getResource("/imagenes/explosion/explosion-0"+i+".png"));
//			auxImgsExplosion.add(image);
//			
//		}
//	}

	public int getCoordX() {
		// TODO Auto-generated method stub
		return 0;
	}
}