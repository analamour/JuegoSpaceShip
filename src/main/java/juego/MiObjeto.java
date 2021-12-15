package juego;

import java.awt.Image;
import java.util.ArrayList;



public class MiObjeto {
	
	private int coordX;
	private int coordY;
	private ArrayList <Image> imgs;
	private int nImg;

	public MiObjeto(int coordX, int coordY, ArrayList<Image> imgs) {
//		super();
		this.coordX = coordX;
		this.coordY = coordY;
		this.imgs = imgs;
		this.nImg = 0;
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public ArrayList<Image> getImgs() {
		return imgs;
	}

	public void setImgs(ArrayList<Image> imgs) {
		this.imgs = imgs;
	}

	public int getnImg() {
		return nImg;
	}

	public void setnImg(int nImg) {
		this.nImg = nImg;
	}

}
