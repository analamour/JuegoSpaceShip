package juego;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

public class Explosion {
	private ArrayList<Image> auxImgsExplosion = new ArrayList<Image>();
	public Explosion () {
	for (int i=1; i<=7; i++){
		Image image = getImage(getClass().getResource("explosion/explosion-0"+i+".png"));
		auxImgsExplosion.add(image);
	}
}
	private Image getImage(URL resource) {
		// TODO Auto-generated method stub
		return null;
	}
}
