package Juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

// Implemento KeyListener para poder leer en los metodos keyPressed y keyReleased los codigos de tecla que apreto el usuario
// Implemento Runnable para crear un Thread que ejecute en paralelo con mi programa
public class Juego extends JPanel implements KeyListener, Runnable {

	private final static int PANTALLA_INICIO = 1;
	private final static int PANTALLA_JUEGO = 2;
	private final static int PANTALLA_PERDEDOR = 3;
	private final static int PANTALLA_GANADOR = 4;
	private static final long serialVersionUID = 1L;
	private int anchoJuego;
	private int largoJuego;
	private int tiempoDeEsperaEntreActualizaciones;
	private ElementoBasico marciano;
	private ElementoBasico asteroide;
	private List<Asteroides> asteroides;
	private ElementoBasico municiones;
	private Puntaje puntaje;
	private Vidas vidas;
	private Sonidos sonidos;
	private int pantallaActual;
	private int enemigosPorLinea;
	private int filasDeEnemigos;
	private int cantidadVidas;
	private PantallaImagen portada;
	private PantallaImagen pantallaGanador;
	private PantallaImagen pantallaEsperar;
	private PantallaPerdedor pantallaPerdedor;

	public Juego(int anchoJuego, int largoJuego, int tiempoDeEsperaEntreActualizaciones, int enemigosPorLinea,
			int filasDeEnemigos, int vidas) {
		this.pantallaActual = PANTALLA_INICIO;
		this.anchoJuego = anchoJuego;
		this.largoJuego = largoJuego;
		this.asteroide = crearAsteroide();
		this.marciano = new Marciano(30, largoJuego - 20, 0, 0, 80, 20, Color.green);
		this.vidas = new Vidas(10, 45, new Font("Arial", 8, 20), Color.blue, vidas);
		this.tiempoDeEsperaEntreActualizaciones = tiempoDeEsperaEntreActualizaciones;
		this.enemigosPorLinea = enemigosPorLinea;
		this.filasDeEnemigos = filasDeEnemigos;
		this.cantidadVidas = vidas;
		this.portada = new PantallaImagen(anchoJuego, largoJuego, "file:///C:/Users/anala/Desktop/JUEGO/src/main/resources/imagenes/14943312633726.jpg");
		//this.pantallaGanador = new PantallaImagen(anchoJuego, largoJuego, "file:///C:/Users/anala/Desktop/JUEGO/src/main/resources/imagenes/14943312633726.jpg");
		//this.pantallaEsperar = new PantallaImagen(anchoJuego, largoJuego, "file:///C:/Users/anala/Desktop/JUEGO/src/main/resources/imagenes/14943312633726.jpg");
		//cargarSonidos();
		// this.sonidos.repetirSonido("background");
		inicializarJuego();
	}

	private void inicializarJuego() {
		this.asteroides.clear();
		this.pantallaPerdedor = null;
		this.vidas = new Vidas(10, 45, new Font("Arial", 8, 20), Color.blue, cantidadVidas);
		this.puntaje = new Puntaje(10, 20, new Font("Arial", 8, 20), Color.blue);
		//agregarAsteroide(enemigosPorLinea, filasDeEnemigos);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(anchoJuego, largoJuego);
	}

	/*
	 * Actualizar la actualizacion y el dibujado del juego de esta forma no es
	 * recomendable dado que tendra distintas velocidades en distinto hardware. Se
	 * hizo asi por simplicidad para facilitar el aprendizaje dado que lo
	 * recomendado es separar la parte de dibujado de la de actualizacion y usar
	 * interpolation
	 */
	@Override
	public void run() {
		while (true) {
			if (pantallaActual == PANTALLA_JUEGO) {
				actualizarJuego();
			}
			dibujarJuego();
			esperar(tiempoDeEsperaEntreActualizaciones);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		if (pantallaActual == PANTALLA_INICIO) {
			inicializarJuego();
			pantallaActual = PANTALLA_JUEGO;
		}

		if (pantallaActual == PANTALLA_PERDEDOR || pantallaActual == PANTALLA_GANADOR) {
			pantallaActual = PANTALLA_INICIO;
		}

		if (pantallaActual == PANTALLA_JUEGO) {

			// si mantengo apretada la tecla de la derecha se asigna velocidad 1 a la paleta
			if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				marciano.setVelocidadX(1);
			}

			// si mantengo apretada la tecla de la izquierda se asigna velocidad -1 a la
			// paleta
			if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				marciano.setVelocidadX(-1);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// si suelto la tecla 39 o la 37 se asigna velocidad 0 a la paleta
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT || arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			marciano.setVelocidadX(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	// Este metodo se llama cuando se hace un this.repaint() automaticamente
	// Aca se dibujan a todos los elementos, para ello cada elemento implementa el
	// metodo dibujarse
	protected void paintComponent(Graphics g) {
		this.limpiarPantalla(g);
		if (pantallaActual == PANTALLA_INICIO) {
			dibujarInicioJuego(g);
		}
		if (pantallaActual == PANTALLA_PERDEDOR) {
			if (this.pantallaPerdedor == null) {
				this.pantallaPerdedor = new PantallaPerdedor(anchoJuego, largoJuego, "imagen/sdad.png",
						this.puntaje.getPuntaje());
			}
			pantallaPerdedor.dibujarse(g);
		}
		if (pantallaActual == PANTALLA_GANADOR) {
			pantallaGanador.dibujarse(g);
		}
		if (pantallaActual == PANTALLA_JUEGO) {
			marciano.dibujarse(g);
			puntaje.dibujarse(g);
			vidas.dibujarse(g);
			municiones.dibujarse(g);
			dibujarAsteroides(g);
		}
	}

	// En este metodo se actualiza el estado de todos los elementos del juego
	private void actualizarJuego() {
		verificarEstadoAmbiente();
		municiones.moverse();
		marciano.moverse();
		moverAsteroides();
	}

	private void dibujarJuego() {
		this.repaint();
	}

	public void agregarAsteroide(Asteroides asteroide) {
		this.asteroides.add(asteroide);
	}

	private ElementoBasico crearAsteroide() {
		return new Asteroides(anchoJuego / 2, largoJuego - 50, 1, -1, 15, 15, Color.blue);
	}

	// En ese metodo se cargan los sonidos que estan es src/main/resources
	/*private void cargarSonidos() {
		try {
			sonidos = new Sonidos();
			sonidos.agregarSonido("toc", "sonidos/toc.wav");
			sonidos.agregarSonido("tic", "sonidos/tic.wav");
			sonidos.agregarSonido("muerte", "sonidos/muerte.wav");
			sonidos.agregarSonido("background", "sonidos/background.wav");
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
	}*/

	private void dibujarInicioJuego(Graphics g) {
		portada.dibujarse(g);
	}

	// se hace una iteracion de todos los enemigos cargados en la lista de enemigos
	// y se le dice a cada uno que ejecute el metodo moverse().
	// moverse() actualiza la posicionX y posicionY del elemento en base a la
	// direccion/velocidad que tenia para X e Y
	private void moverAsteroides() {
		 for (Asteroides asteroide : asteroides) {
			 asteroide.moverse();
		 }
	}

	// Se hace una iteracion en la lista de enemigos y se ejecuta el metodo
	// dibujarse()
	private void dibujarAsteroides(Graphics g) {
		for (Asteroides asteroide : asteroides) {
		asteroide.dibujarse(g);
		}
	}

	// En este metodo verifico las colisiones, los rebotes de la pelota contra las
	// paredes, la colision entre enemigos y el fin de juego
	private void verificarEstadoAmbiente() {
		verificarReboteEntreAsteroides();
		verificarReboteEntreAsteroidesEnParedesLaterales();
		verificarColisionEntreMunicionYAsteroide();
		verificarReboteAsteroideContraParedLateral();
		verificarReboteAsteroideContraLaParedSuperior();
		verificarSiAsteroideTocaMarciano();
		verificarFinDeJuego();
	}

	// Se iteran todos los enemigos y se verifica para cada enemigo si hay colision
	// con cada enemigo. Si hay colision se ejecuta el metodo rebotarEnEjeX() del
	// enemigo esto hace que el enemigo cambie de direccion en el eje X
	private void verificarReboteEntreAsteroides() {
		for (Asteroides enemigo1 : asteroides) {
			for (Asteroides enemigo2 : asteroides) {
				if (enemigo1 != enemigo2 && enemigo1.hayColision(enemigo2)) {
					enemigo1.rebotarEnEjeX();
				}
			}
		}
	}

	// se verifica si hay colision de cada enemigo contra las paredes laterales, si
	// hay colision se cambia la direccion del enemigo en el eje X
	private void verificarReboteEntreAsteroidesEnParedesLaterales() {
		for (Asteroides enemigo : asteroides) {
			if (enemigo.getPosicionX() <= 0 || enemigo.getPosicionX() + enemigo.getAncho() >= anchoJuego) {
				enemigo.rebotarEnEjeX();
			}
		}
	}

	// se verifica si la pelota colisiona con cada uno de los enemigos. Si hay
	// colision se hace rebotar la pelota en el ejeY, se suma un punto y se toca el
	// sonido toc
	private void verificarColisionEntreMunicionYAsteroide() {
		Iterator<Asteroides> iterador = asteroides.iterator();
		while (iterador.hasNext()) {
			Asteroides enemigo = iterador.next();
			if (enemigo.hayColision(municiones)) {
				iterador.remove();
				// pelota.rebotarEnEjeY();
				puntaje.sumarPunto();
				sonidos.tocarSonido("tic");
			}
		}
	}

	// Se verifica si la cantidad de enemigos es 0 o si la cantidad de vidas es 0
	// para parar el juego
	private void verificarFinDeJuego() {

		if (vidas.getVidas() == 0) {
			pantallaActual = PANTALLA_PERDEDOR;
		}

		if (asteroides.size() == 0) {
			pantallaActual = PANTALLA_GANADOR;
		}
	}

	// Se verifica si la pelota toca el piso, si es asi se pierde una vida, se crea
	// una nueva pelota, se toca el sonido muerte y se muestra la pantalla perdiste
	// y se esperan 5 segundos
	private void verificarSiAsteroideTocaMarciano() {
        if (asteroide.getPosicionY() == asteroide.getPosicionX()/*== (marciano.getPosicionY() && marciano.getPosicionX())*/) {
            vidas.perderVida();
            asteroide = crearAsteroide();
            sonidos.tocarSonido("muerte");
            pantallaEsperar.dibujarse(this.getGraphics());
            esperar(5000);
        }
    }

	// se verifica si la pelota colisiona contra la pared lateral, si es asi, se
	// hace rebotar la pelota en el eje X
	private void verificarReboteAsteroideContraParedLateral() {
		if (asteroide.getPosicionX() <= 0 || asteroide.getPosicionX() + asteroide.getAncho() >= anchoJuego) {
			asteroide.rebotarEnEjeX();
			sonidos.tocarSonido("toc");
		}
	}

	// se verifica si la pelota colisiona contra la pared superior, si es asi se
	// hace rebotar la pelota en el eje Y
	private void verificarReboteAsteroideContraLaParedSuperior() {
		if (asteroide.getPosicionY() <= 0) {
			asteroide.rebotarEnEjeY();
			// AGREGAR SONIDO sonidos.tocarSonido("toc");
		}
	}

	// metodo para limpiar la pantalla
	private void limpiarPantalla(Graphics graphics) {
		graphics.setColor(Color.cyan);
		graphics.fillRect(0, 0, anchoJuego, largoJuego);
	}

	// metodo para esperar una cantidad de milisegundos
	private void esperar(int milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
	}

	/*private void agregarAsteroides(int asterioidesPorJuego, int posicion) {
		for (int x = 1; x < asteroidesPorJuego; x++) {
			for (int y = 1; y < pisicion; y++) {
				Color color = new Color(new Random().nextInt(255), new Random().nextInt(255),
						new Random().nextInt(255));
				agregarAsteroide(new Asteroides());
			}

		}
	}*/
}

