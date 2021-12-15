package juego;

import java.awt.Image;
import java.util.ArrayList;



	import java.awt.Graphics2D;
	import java.awt.Rectangle;
	import java.awt.geom.Area;
	import java.util.ArrayList;

	import javax.swing.ImageIcon;


	public class Asteroide  {

		Juego miJuego;
		Area cuerpo;
		int anchoAsteroide = 80;
		int altoAsteroide = 80;
		static int inicialX = 1300;
		static int inicialY = (int) Math.floor(Math.random()*(580-30+1)+30);
		static int auxiliarX = -6;
		public Asteroide(Juego miJuego) {
			this.miJuego = miJuego;
		}
		
//		public Asteroide(int coordX, int coordY, ArrayList<Image> imgs) {
//			super(coordX, coordY, imgs);
//			this.setnImg(0);
//		}

		public void mover() {
			if (inicialX <= -100) {
				Juego.puntos++;
				inicialX = 1300;
				inicialY = (int) Math.floor(Math.random()*(580-30+1)+30);
				if (Juego.puntos == 3 | Juego.puntos == 6 | Juego.puntos == 9 | Juego.puntos == 12) {
					auxiliarX += -1;
					Juego.nivel++;
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
			ImageIcon entrenador = new ImageIcon(this.getClass().getResource("/imagenes/Asteroide2.png"));
			g.drawImage(entrenador.getImage(), inicialX, inicialY, anchoAsteroide, altoAsteroide, null);
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


