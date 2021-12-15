package juego;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;



public class hAsteroides extends Thread {
//	private Juego mp;
//	private ArrayList<Asteroide> asteroides = new ArrayList<Asteroide>();
//	public hAsteroides(Juego juego) {
//		super();
//		this.mp = juego;
//	}
//	
//	@Override
//	public void run(){
//		int t = 50; //velocidad de refresco (para avance y giro) 
//		int temporizadorAsteroides = 0;
//		while(true){
//			super.run();
//			temporizadorAsteroides++;
//			if (temporizadorAsteroides==20) { //cada 20*t = 1000 ms
//				// crear asteroide nuevo
//				Asteroide nuevoAsteroide = new Asteroide(1000, (int)(Math.random()*700), mp.getAuxImgsAsteroide());
//				this.asteroides.add(nuevoAsteroide); //aparecerán de forma aleatoria por la parte derecha de la pantalla.;
//				temporizadorAsteroides= 0;
//			}
//			// mover asteroides
//			for (int i=0; i<asteroides.size(); i++) {
//				Asteroide asteroideActual = asteroides.get(i);
//				asteroideActual.setCoordX(asteroideActual.getCoordX() - 20); //velocidad del asteroide
//				if (asteroideActual.getImgs().size()==7) { //si imgsasteroide=auxImgsExplosion
//					asteroideActual.setnImg(asteroideActual.getnImg()+1);
//					if (asteroideActual.getnImg()==6) { //si ha acabado la animación de explosión,
//						asteroides.remove(asteroides.indexOf(asteroideActual)); //borrar asteroideActual
//					}
//				} else { //si no está explotando
//					//Los asteroides irán girando.
//					asteroideActual.setnImg(asteroideActual.getnImg()+1);
//					if (asteroideActual.getnImg() == 8) {
//						asteroideActual.setnImg(0);
//					}
//					if (asteroideActual.getCoordX()<0) {//si posición asteroide fuera de la pantalla
//						asteroides.remove(i); //borrar asteroideActual
//					}
//				}
//			}
//
//			mp.repaint();
//
//			try {
//				Thread.sleep(t);
//			} catch (InterruptedException e) {
//				System.out.println(e);
//			}
//		}
//	}
//	
//	
//	public void dibujarAsteroide() {
//		ImageIcon personaje = new ImageIcon(this.getClass().getResource("/imagenes/Asteroide2.png"));
//		
//	}
//
//	public ArrayList<Asteroide> getAsteroides() {
//		return asteroides;
//	}
//	public void setAsteroides(ArrayList<Asteroide> asteroides) {
//		this.asteroides = asteroides;
//	}
//	
}

