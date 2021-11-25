package juego;

import javax.swing.JFrame;
import javax.swing.WindowConstants;



public class ArrancarJuego {

	public static void main(String[] args) {

        // Propiedades del Juego
        int anchoVentana = 800;
        int largoVentana = 600;
        int tiempoDeEsperaEntreActualizaciones = 3;
        int enemigosPorLinea = 10;
        int filasDeEnemigos = 6;
        int vidas = 3;

        // Activar aceleracion de graficos en 2 dimensiones
        System.setProperty("sun.java2d.opengl", "true");

        // Crear un objeto de tipo JFrame que es la ventana donde va estar el juego
        JFrame ventana = new JFrame("Mi Juego");

        // Cerrar la aplicacion cuando el usuario hace click en la 'X'
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Abrir la ventana en el centro de la pantalla
        ventana.setLocationRelativeTo(null);

        // Mostrar la ventana
        ventana.setVisible(true);

        // Crear un "Jpanel" llamado Juego y agregarlo a la ventana
        Juego juego = new Juego(anchoVentana, largoVentana, tiempoDeEsperaEntreActualizaciones, enemigosPorLinea,
                filasDeEnemigos, vidas);

        // Agregar a la ventana el JComponent (Juego hereda de JComponent)
        ventana.add(juego);

        // Enviar los eventos recibidos de movimientos del teclado al juego (esto es
        // porque la clase Juego implementa: MouseMotionListener)
        ventana.addKeyListener(juego);

        // Achicar la ventana lo maximo posible para que entren los componentes
        ventana.pack();

        // Crear un thread y pasarle como parametro al juego que implementa la interfaz
        // "Runnable"
        Thread thread = new Thread(juego);

        // Arrancar el juego
        thread.start();
    }
}