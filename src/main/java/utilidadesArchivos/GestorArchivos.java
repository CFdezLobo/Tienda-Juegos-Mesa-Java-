package utilidadesArchivos;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import modelo.JuegoMesa;
import modelo.Usuario;

public class GestorArchivos {
	
	public static boolean borrarImagenesJuego(String idJuego, String rutaReal) {
		File f1 = new File(rutaReal + "/subidas/juegos" + idJuego + "-1.jpg");
		File f2 = new File(rutaReal + "/subidas/juegos" + idJuego + "-2.jpg");
		File f3 = new File(rutaReal + "/subidas/juegos" + idJuego + "-3.jpg");
		File f4 = new File(rutaReal + "/subidas/juegos" + idJuego + "-4.jpg");
		
		if(f1.delete() && f2.delete() && f3.delete() && f4.delete()) {
			System.out.println("Archivos borrados correctamente");
			return true;
		}else {
			System.out.println("No se pudieron borrar los archivo");
			return false;
		}
	}
	
	public static void guardarImagenesJuego(JuegoMesa juego, String rutaReal) {
		String nombreArchivo = "";
		String rutaSubidas = rutaReal + "/subidas/juegos";
		
		// Si rutaSubidas no existe, crearla
		File fileRutaSubidas = new File(rutaSubidas);
		
		if(! fileRutaSubidas.exists()) {
			fileRutaSubidas.mkdirs();
		}
		
		// si existe el archivo subido 
		if(juego.getPortada().getSize() > 0) {
			try {
				nombreArchivo = juego.getId() + "-1.jpg";
				juego.getPortada().transferTo(new File(rutaSubidas, nombreArchivo));
				System.out.println("Archivo movido a: " + rutaSubidas);
			} catch (IllegalStateException | IOException e) {
				System.out.println("No puede mover el archivo a la ruta de subidas");
				e.printStackTrace();
			}
		}else {
			System.out.println("Se subió un juego sin portada, no hay problema, de momento la imagen es opcional");
		}
		
		if(juego.getContraportada().getSize() > 0) {
			try {
				nombreArchivo = juego.getId() + "-2.jpg";
				juego.getContraportada().transferTo(new File(rutaSubidas, nombreArchivo));
				System.out.println("Archivo movido a: " + rutaSubidas);
			} catch (IllegalStateException | IOException e) {
				System.out.println("No puede mover el archivo a la ruta de subidas");
				e.printStackTrace();
			}
		}else {
			System.out.println("Se subió un juego sin contraportada, no hay problema, de momento la imagen es opcional");
		}
		
		if(juego.getJuegoDesplegado1().getSize() > 0) {
			try {
				nombreArchivo = juego.getId() + "-2.jpg";
				juego.getJuegoDesplegado1().transferTo(new File(rutaSubidas, nombreArchivo));
				System.out.println("Archivo movido a: " + rutaSubidas);
			} catch (IllegalStateException | IOException e) {
				System.out.println("No puede mover el archivo a la ruta de subidas");
				e.printStackTrace();
			}
		}else {
			System.out.println("Se subió un juego sin imagen desplegada 1, no hay problema, de momento la imagen es opcional");
		}
		
		if(juego.getJuegoDesplegado2().getSize() > 0) {
			try {
				nombreArchivo = juego.getId() + "-2.jpg";
				juego.getJuegoDesplegado2().transferTo(new File(rutaSubidas, nombreArchivo));
				System.out.println("Archivo movido a: " + rutaSubidas);
			} catch (IllegalStateException | IOException e) {
				System.out.println("No puede mover el archivo a la ruta de subidas");
				e.printStackTrace();
			}
		}else {
			System.out.println("Se subió un juego sin imagen desplegada 2, no hay problema, de momento la imagen es opcional");
		}	
		
	}

	public static void guardarFotoUsuario(Usuario u, CommonsMultipartFile foto, String rutaRealDelProyecto) {
		String nombreArchivo = u.getId() + ".jpg";
		String rutaSubidas = rutaRealDelProyecto + "/subidas/usuarios";

		File fileRutaSubidas = new File(rutaSubidas);
		if( ! fileRutaSubidas.exists() ) {
			fileRutaSubidas.mkdirs();
		}
		if(foto.getSize() > 0) {
			try {
				foto.transferTo(new File(rutaSubidas,nombreArchivo));
				System.out.println("archivo movido a: " + rutaSubidas);
			} catch (IllegalStateException | IOException e) {
				System.out.println("no pude mover el archivo a la ruta de subidas");
				e.printStackTrace();
			}
		}else {
			System.out.println("No se ha subido foto del usuario");
		}
		
	}
	
	public static boolean borrarImagenesUsuario(String idUsuario, String rutaReal) {
		File f1 = new File(rutaReal + "/subidas/usuarios" + idUsuario + ".jpg");
		
		if(f1.delete()) {
			System.out.println("Archivos borrados correctamente");
			return true;
		}else {
			System.out.println("No se pudieron borrar los archivo");
			return false;
		}
	}
}
