package Juego;

import java.awt.Color;
import java.awt.Graphics;


public class Asteroides extends ElementoBasico {

    public Asteroides(int posicionX, int posicionY, int velocidadX, int velocidadY, int ancho, int largo, Color color) {
        super(posicionX, posicionY, velocidadX, velocidadY, ancho, largo, color);
    }

    public void dibujarse(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillOval(getPosicionX(), getPosicionY(), getAncho(), getLargo());
    }

    public void destruirse(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(getPosicionX(), getPosicionY(), getAncho(), getLargo());
    }

}

