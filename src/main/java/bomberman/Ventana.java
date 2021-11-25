package bomberman;

import javax.swing.JFrame;

public class Ventana extends JFrame {

	public Ventana () {
		super("bomberman");
		setSize (600,60);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//para evitar que cambien de tamaño el usuario
		this.setResizable(false);
	}
}
