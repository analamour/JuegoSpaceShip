package bomberman;
import java.awt.Graphics;

public class CBomberman extends juegoObjects implements Interface{
	
	private int direccion;
	private boolean isOpen = true;
	
	
	CBomberman (int x, int y, int direc) {
		super.posicionX = x;
		super.posicionY = y;
		direccion = direc;
	}
	
	CBomberman () {
		super.posicionX = 0;
		super.posicionY = 0;
	}
	
	public void setDireccion (int direc) {
		direccion = direc;
		
	}
	
	
	@override
	public void paintElements (Graphics g) {
		
	}
	
	@override
	public void moverElemento (int iEstado) {
		
	}
	

}
