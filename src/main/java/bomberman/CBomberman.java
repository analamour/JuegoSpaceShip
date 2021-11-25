package bomberman;

import java.awt.Color;
import java.awt.Graphics;

public class CBomberman extends juegoObjects implements Interface {

	private int direccion;
	private boolean isOpen = true;

	CBomberman(int x, int y, int direc) {
		super.posicionX = x;
		super.posicionY = y;
		direccion = direc;
	}

	CBomberman() {
		super.posicionX = 0;
		super.posicionY = 0;
	}

	public void setDireccion(int direc) {
		direccion = direc;

	}

	public int getDireccion() {
		return direccion;
	}

	@override
	// dibujar el bomberman
	public void paintElements(Graphics g) {
		switch (direccion) {
		case moverAbajo:
			// cuando mira hacia abajo
			if (isOpen == true) {
				g.setColor(Color.blue);
				g.fillArc(posicionX, posicionY, 25, 25, 315, 260);
				isOpen = false;
			} else {
				g.setColor(Color.blue);
				g.fillArc(posicionX, posicionY, 25, 25, 0, 360);
				isOpen = true;
			}
			g.fillOval(posicionX + 4, posicionY + 8, 4, 4);
			g.setColor(Color.black);
			break;

		case moverArriba:
			if (isOpen == true) {
				g.setColor(Color.blue);
				g.fillArc(posicionX, posicionY, 25, 25, 135, 260);
				isOpen = false;
			} else {
				g.setColor(Color.blue);
				g.fillArc(posicionX, posicionY, 25, 25, 0, 360);
				isOpen = true;
			}
			g.fillOval(posicionX + 4, posicionY + 8, 4, 4);
			g.setColor(Color.black);
			break;

		case moverIzquierda:
			if (isOpen == true) {
				g.setColor(Color.blue);
				g.fillArc(posicionX, posicionY, 25, 25, 225, 265);
				isOpen = false;
			} else {
				g.setColor(Color.blue);
				g.fillArc(posicionX, posicionY, 25, 25, 0, 360);
				isOpen = true;
			}
			g.fillOval(posicionX + 8, posicionY + 4, 4, 4);
			g.setColor(Color.black);
			break;

		case moverDerecha:
			if (isOpen == true) {
				g.setColor(Color.blue);
				g.fillArc(posicionX, posicionY, 25, 25, 45, 265);
				isOpen = false;
			} else {
				g.setColor(Color.blue);
				g.fillArc(posicionX, posicionY, 25, 25, 0, 360);
				isOpen = true;
			}
			g.fillOval(posicionX + 8, posicionY + 4, 4, 4);
			g.setColor(Color.black);
			break;

		}

	}

	@override
	public void moverElemento(int iEstado) {

		switch (iEstado) {
		case moverAbajo:
			this.posicionX += 25;
			break;

		case moverArriba:
			this.posicionY -= 25;

			break;

		case moverIzquierda:

			this.posicionX -= 25;
			break;
		case moverDerecha:
			this.posicionY += 25;
			break;

		}
	}

	

}
