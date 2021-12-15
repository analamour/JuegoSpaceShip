package juego;

	import java.io.ByteArrayInputStream;
	import java.io.InputStream;
	import java.nio.file.Files;
	import java.nio.file.Paths;
	import java.util.HashMap;
	import java.util.Map;
	import javax.sound.sampled.AudioInputStream;
	import javax.sound.sampled.AudioSystem;
	import javax.sound.sampled.Clip;
	import javax.sound.sampled.DataLine;

	// Clase para manejar cargar y tocar sonidos
	public class Audio {

	    private Map<String, byte[]> audio;
	    
	    public Audio() {
	        this.audio = new HashMap<String, byte[]>();
	    }

	    // agrega un sonido al mapa de sonidos
	    public void agregarAudio(String nombre, String archivo) {
	        try {
	            byte[] fileContent = Files.readAllBytes(Paths.get(Audio.class.getClassLoader().getResource(archivo).toURI()));
	            audio.put(nombre, fileContent);
	        } catch (Exception e) {
	            throw new RuntimeException("No se pudo encontrar el archivo de sonido: " + archivo);
	        }
	    }
	    // toca un sonido del mapa de sonidos
	    public void tocarSonido(String sonido) {
	        try {
	            byte[] audioEnBytes = audio.get(sonido);
	            InputStream myInputStream = new ByteArrayInputStream(audioEnBytes);
	            AudioInputStream ais = AudioSystem.getAudioInputStream(myInputStream);
	            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
	            Clip clip = (Clip) AudioSystem.getLine(info);
	            clip.open(ais);
	            clip.loop(-1);
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	}

