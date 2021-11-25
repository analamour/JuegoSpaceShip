package bomberman;

public interface Interface {
	//movimiento de los personajes
	int moverAbajo = 1;
	int moverArriba = 2;
	int moverIzquierda = 3;
	int moverDerecha = 4;

	
	void moverElemento(int iEstado);
}
