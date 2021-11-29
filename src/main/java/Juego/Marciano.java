package Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

public class Marciano extends ElementoBasico {
	private BufferedImage img;

	public Marciano(int posicionX, int posicionY, double velocidadX, double velocidadY, int ancho, int largo,
			Color color) {
		super(posicionX, posicionY, velocidadX, velocidadY, ancho, largo, color);
		String path = Paths.get(Marciano.getResource().getPath()).toString();
		try {
			this.img = ImageIO.read(new File(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static File getResource() {
		return new File("/home/hp/eclipse-workspace/JuegoSpacefrog/src/main/resourcess/imagenes/NAVE.png.png");
	}

	public void dibujar(Graphics graphics) {
		try {
			graphics.drawImage(img, (int) getPosicionX(), (int) getPosicionY(), this.getAncho(), this.getLargo(), null);
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
	}

	@Override
	public void dibujarse(Graphics graphics) {
		graphics.setColor(getColor());
		graphics.fillRect(getPosicionX(), getPosicionY(), getAncho(), getLargo());
	}

}

/*
 * public class Marciano extends ElementoBasico { public Marciano (int
 * posicionX, int posicionY, double velocidadX, double velocidadY, int ancho,
 * int largo, Color color) { super(posicionX, posicionY, velocidadX, velocidadY,
 * ancho, largo, color); }
 * 
 * public void dibujarse(Graphics graphics) { graphics.setColor(getColor());
 * graphics.fillRect(getPosicionX(), getPosicionY(), getAncho(), getLargo()); }
 * 
 * }
 */