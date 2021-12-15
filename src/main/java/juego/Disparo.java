package juego;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;



public class Disparo extends MiObjeto {

	private int vidaQuita;

	public Disparo(int coordX, int coordY, int tipoDisparo, ArrayList <Image> imgs) {
		super(coordX, coordY, imgs);
		if (tipoDisparo==2) {
			
			this.vidaQuita = 3;
		} else {
			this.vidaQuita = 1;
		}
		this.setnImg(0);
	}

	public int getVidaQuita() {
		return vidaQuita;
	}
}
