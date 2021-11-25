package bomberman;

import java.awt.Color;
import java.awt.Graphics;

public class Pared extends juegoObjects {

	Pared(int X, int Y) {
		super.posicionX = X;
		super.posicionY = Y;

	}

	@override
	public void paintElements(Graphics g) {
		g.setColor(new = Color (185,122,87));
		g.fillRoundRect(posicionX, posicionY, 25, 25, 6, 6);
		g.setColor(Color.gray);
		g.drawRoundRect(posicionX, posicionY, 25, 25, 6, 6);
	}
	
}
