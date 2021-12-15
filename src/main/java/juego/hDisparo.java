package juego;

import java.util.ArrayList;



public class hDisparo extends Thread {
	private Juego mp;
	private ArrayList<Disparo> disparos = new ArrayList<Disparo>();

	public hDisparo(Juego juego) {
		super();
		this.mp = juego;
	}

	@Override
	public void run(){
		int t = 50; //velocidad de refresco (para avance y giro) del disparo 
		while(true){
			super.run();
			// mover disparos:
			for (int i=0; i<disparos.size(); i++) {
				Disparo disparoActual = disparos.get(i);
				disparoActual.setCoordX(disparoActual.getCoordX() + 25); //velocidad del disparo
				disparoActual.setnImg(disparoActual.getnImg()+1);
				if (disparoActual.getnImg() == disparos.get(i).getImgs().size()){
					disparoActual.setnImg(0);
				}
			}
			// borrar disparos:
			for (int i=0; i<disparos.size(); i++) {
				Disparo disparoActual = disparos.get(i);
				if (disparoActual.getCoordX()>1000) {//si posición del disparo fuera de la pantalla
					disparos.remove(i);
				}
			}

			mp.repaint();

			try {
				Thread.sleep(t); 
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}	
	}

	public ArrayList<Disparo> getDisparosAmigo() {
		return disparos;
	}

	public void setDisparosAmigo1(ArrayList<Disparo> disparos) {
		this.disparos = disparos;
	}
}
