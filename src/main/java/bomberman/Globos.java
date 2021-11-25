package bomberman;

import java.awt.Color;
import java.awt.Graphics;

public class Globos extends juegoObjects {

	Globos(int X, int Y) {
		super.posicionX = X;
		super.posicionY = Y;
	}

	Globos() {

	}

	public void setX(int posX) {
		super.posicionX = posX;
	}

	public void setY(int posY) {
		super.posicionY = posY;
	}

	public int getX() {
		return (posicionX / 25);
	}

	public int getY() {
		return (posicionY / 25);
	}

	public void paintElements(Graphics g) {
//dibujo el globo
		g.setColor(Color.orange);
		g.fillOval(posicionX, posicionY, 10, 15);
		g.setColor(Color.blue);
		g.fillOval(posicionX + 2, posicionY + 2, 6, 6);
	}


}
