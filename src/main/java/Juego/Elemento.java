package Juego;

import java.awt.Color;

public interface Elemento extends Dibujable {

    public int getPosicionX();

    public int getPosicionY();

    public int getAncho();

    public int getLargo();

    public double getVelocidadX();

    public double getVelocidadY();

    public Color getColor();

    public void moverse();

    public boolean hayColision(Elemento elemento);
}