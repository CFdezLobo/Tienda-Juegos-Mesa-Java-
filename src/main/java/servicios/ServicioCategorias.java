package servicios;

import java.util.List;
import java.util.Map;

import modelo.Categoria;
import modelo.JuegoMesa;
import modelo.Usuario;

public interface ServicioCategorias {
	
	List<Categoria> obtenerCategorias();
	
	void registrarCategoria(Categoria c);
	
	void borrarCategoria(int id);
	
	void guardarCambiosCategoria(Categoria c);
	
	Categoria obtenerCategoriaPorId(int id);
	
	Map<String, String> obtenerCategoriasParaDesplegable();

	
}
