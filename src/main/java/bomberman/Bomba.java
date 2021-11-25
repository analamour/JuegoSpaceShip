package bomberman;
import java.awt.Color;
import java.awt.Graphics;


public class Bomba extends juegoObjects {
	
	Bomba (int X, int Y) {
		super.posicionX = X;
		super.posicionY = Y;
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
	
	//dibujo la bomba
	@override
	public void paintElements(Graphics g) {
		g.setColor(Color.black);
		g.fillOval(posicionX, posicionY, 12, 12);
	}
}
