package Juego;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Inicializador {
	public static void main(String[] args) {

        int anchoVentana = 800;
        int largoVentana = 600;
        int tiempoDeEsperaEntreActualizaciones = 5;
        int enemigosPorLinea = 10;
        int filasDeEnemigos = 6;
        int vidas = 3;

        System.setProperty("sun.java2d.opengl", "true");
        JFrame ventana = new JFrame("Juego Espacial");
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        Juego juego = new Juego(anchoVentana, largoVentana, tiempoDeEsperaEntreActualizaciones, enemigosPorLinea,
                filasDeEnemigos, vidas);
        ventana.add(juego);
        ventana.addKeyListener(juego);
        ventana.pack();
        // Crear un thread y pasarle como parametro al juego que implementa la interfaz
        // "Runnable"
        Thread thread = new Thread(juego);
        thread.start();
    }
}
