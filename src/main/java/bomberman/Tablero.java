package bomberman;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Tablero implements Interface {

	public CBomberman Bomberman;
	public ArrayList<Pared> cuadritos;
	public ArrayList<Bomba> bombas;
	public ArrayList<Globos> globos;
	public boolean isBomba = false;

	private int MatrizObj[][] = { { 1, 1, 0, 0, 0, 0, 2, 2 }, { 1, 1, 0, 0, 0, 0, 2, 2 }, { 1, 1, 0, 0, 0, 0, 2, 2 } };

	public Tablero() {

		Bomberman = new CBomberman();
		cuadritos = new ArrayList<>();
		bombas = new ArrayList<>();
		globos = new ArrayList<>();

		int nPared = 0;
		int nGlobos = 0;
		int nBombas = 0;

		for (int i = 0; i < 23; i++) {
			for (int j = 0; j < 23; j++) {
				switch (MatrizObj[i][j]) {
				case 1:
					// es muro
					cuadritos.add(nPared, new Pared(j * 25, i * 25));
					nPared++;
					break;

				case 2:
					// son los globos
					globos.add(nGlobos, new Globos(j * 25, i * 25));
					nGlobos++;
					break;

				case 3:
					// es el bomberman
					Bomberman.posicionX(j * 25);
					Bomberman.posicionY(i * 25);
					Bomberman.setDireccion(moverIzquierda);
					break;

				}
			}

		}

	}

	public int sgetObject(int fila, int columna) {
		return MatrizObj[fila][columna];
	}

	public void setObject(int obj, int fila, int columna) {
		MatrizObj[fila][columna] = obj;
	}

	public void moverBomberman() {
		MatrizObj[Bomberman.posicionX][Bomberman.posicionY] = 0;
		Bomberman.moverElemento(Bomberman.getDireccion());
		MatrizObj[Bomberman.posicionX][Bomberman.posicionY] = 3; // le asigno la nueva posicion
	}

	private void moverGlobos(int posicion) {
		MatrizObj[globos.get(posicion).getY()][globos.get(posicion).getX()] = 0;
		globos.get(posicion).moverElemento(globos.get(posicion).getDireccion());
		MatrizObj[globos.get(posicion).getY()][globos.get(posicion).getX()] = 2;

	}

	private void moverAleatoriamenteGlobos(int tiempo) {
		for (int i = 0; i < globos.size(); i++) {
			switch (globos.get(i).getDireccion()) {
			case moverArriba:
				if (MatrizObj[globos.get(i).getY() - 1][globos.get(i).getX()] != 1 && tiempo < 10) {
					moverGlobos(i);
				} else {
					globos.get(i).setDireccion(this.getRandomDirection());
				}
				break;
				
			case moverAbajo:
				if (MatrizObj[globos.get(i).getY() + 1][globos.get(i).getX()] != 1 && tiempo < 10) {
					moverGlobos(i);
				} else {
					globos.get(i).setDireccion(this.getRandomDirection());
				}
				break;
				
				
			case moverIzquierda:
				if (MatrizObj[globos.get(i).getY() - 1 ][globos.get(i).getX()] != 1 && tiempo < 10) {
					moverGlobos(i);
				} else {
					globos.get(i).setDireccion(this.getRandomDirection());
				}
				break;
				
				
			case moverDerecha:
				if (MatrizObj[globos.get(i).getY() + 1 ][globos.get(i).getX()] != 1 && tiempo < 10) {
					moverGlobos(i);
				} else {
					globos.get(i).setDireccion(this.getRandomDirection());
				}
				break;
			}
		}

	}
	
	public boolean isPlaying() {
		boolean finish = false;
		for (int i = 0; i < globos.size(); i++) {
			
			//si el globo toca a bomberman termina juego
			if (globos.get(i).getX() == Bomberman.getX() &&  globos.get(i).getY() == Bomberman.getY()) {
				finish = true;
			}
			if (isBomba) {
				// si el globo toca la bomba muere el globo , elimino globo y la bomba
				if (globos.get(i).getX() == bombas.get(0).getX() && globos.get(i).getY() == bombas.get(0).getY()) {
					MatrizObj [globos.get(i).getY()][globos.get(i).getX()] = 0;
					globos.remove(i);
					bombas.remove(i);
					isBomba = false;
				}
			}
		}
		return finish;
	}

	public void setRandomDirectionGlobos() {
		for (int i = 0; i < globos.size(); i++) {
			globos.get(i).setDireccion(this.getRandomDirection());
		}
	}
	public int getRandomDirectionGlobos() {
		Random rnd = new Random();
		return (rnd.nextInt(4) + 1);
	}
	
	
	public boolean esGanador () {
		checkGlobos();
		return globos.isEmpty();
	}
	
	public void checkGlobos () {
		for (int i = 0; i < globos.size(); i++) {
			if (Bomberman.getX() == globos.get(i).getX() && Bomberman.getY() == globos.get(i).getY()) {
				globos.remove(i); //elimina el globo
			}
		}
	}
	
	
	@override
	public void moverElemento (int estado) {
		//no se utiliza
		
	}
	
	
	
	
	
}
