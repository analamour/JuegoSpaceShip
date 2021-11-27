package Juego;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Municiones extends ElementoBasico {
	public Municiones(int posicionX, int posicionY, double velocidadX, double velocidadY, int ancho, int largo,
			Color color) {
		super(posicionX, posicionY, velocidadX, velocidadY, ancho, largo, color);
	}

	public abstract void disiparse(Graphics graphics);



	public void dibujarse(Graphics graphics) {
		graphics.setColor(getColor());
		graphics.fillOval(getPosicionX(), getPosicionY(), getAncho(), getLargo());
	}
}