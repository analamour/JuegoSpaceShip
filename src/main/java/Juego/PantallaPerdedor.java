package Juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class PantallaPerdedor extends PantallaImagen {

    private int puntos;

    public PantallaPerdedor(int ancho, int largo, String resource, int puntos) {
        super(ancho, largo, resource);
        this.puntos = puntos;
    }

    public void dibujarse(Graphics graphics) {
        super.dibujarse(graphics);
        String mensajePuntos = " punto";
        if (puntos >= 1) {
            mensajePuntos += "s";
        }
        mostrarMensaje(graphics, "Obtuviste: " + puntos + mensajePuntos);
    }

    private void mostrarMensaje(Graphics g, String mensaje) {
        g.setColor(Color.blue);
        g.setFont(new Font("Arial", 8, 30));
        g.drawString(mensaje, 10, 40);
    }

}
