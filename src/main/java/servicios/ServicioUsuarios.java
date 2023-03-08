package servicios;

import java.util.List;

import modelo.Usuario;

public interface ServicioUsuarios {

	void registrarUsuario(Usuario usuario);
	
	List<Usuario> obtenerUsuarios();

	void borrarUsuario(int id);
	
	void guardarCambiosUsuario(Usuario u);

	Usuario obtenerUsuarioPorId(int idUsuario);
	
	Usuario obtenerUsuarioPorEmail(String email);
	
	Usuario obtenerUsuarioPorEmailYPass(String email, String pass);

}
