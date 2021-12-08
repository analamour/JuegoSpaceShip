package Juego;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;


public class Fondo {

	Juego miJuego;
	int anchoFondo = 1300;
	int altoFondo = 400;
	int xUno = 1300;
	int yUno = 0;
	int xDos = 0;
	int yDos = 0;

	public Fondo(Juego miJuego) {
		this.miJuego = miJuego;
	}

	public void mover() {
		xUno -= 2;
		xDos -= 2;
		if (xUno == 0 && xDos == -1300) {
			xUno = 1300;
			xDos = 0;
		}
	}

	public void paint(Graphics2D g) {
		ImageIcon imagenDeFondo = new ImageIcon(this.getClass().getResource("/imagenes/EspacioFondo.jpg"));
		g.drawImage(imagenDeFondo.getImage(), xUno, yUno, anchoFondo, altoFondo, null);
		g.drawImage(imagenDeFondo.getImage(), xDos, yDos, anchoFondo, altoFondo, null);
	}

}