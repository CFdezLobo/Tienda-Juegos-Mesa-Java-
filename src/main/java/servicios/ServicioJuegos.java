package servicios;

import java.util.List;
import modelo.JuegoMesa;

public interface ServicioJuegos {

	
	void registrarJuego(JuegoMesa juego);
	
	int obtenerTotalDeJuegos(String nombre);
	
	int obtenerTotalDeJuegosAdmin(String nombre);
	
	List<JuegoMesa> obtenerJuegos(String nombre, int comienzo);
	
	List<JuegoMesa> obtenerJuegosAdmin(String nombre, int comienzo);
	
	void borrarJuegoMesa(int id);
	
	void guardarCambiosJuego(JuegoMesa juego);

	JuegoMesa obtenerJuegoPorId(int idJuego);
	
}
