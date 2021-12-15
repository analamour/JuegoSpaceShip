package juego;

import java.awt.Image;
import java.util.ArrayList;



public class Asteroide extends MiObjeto {

	public Asteroide(int coordX, int coordY, ArrayList<Image> imgs) {
		super(coordX, coordY, imgs);
		this.setnImg(0);
	}
}
