package controladores.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.JuegoMesa;
import modelo.Usuario;
import servicios.ServicioCarrito;
import servicios.ServicioProvincias;
import servicios.ServicioUsuarios;

@Controller
@RequestMapping("/admin/")
public class UsuariosControllerAdmin {
	
	// Autowired asigna automaticamente una bean del mismo tipo indicado del contenedor de spring
	// Autowired, en este caso pide la bean cuya clase implemente ServicioUsuarios, dicha bean es la que hemos cargado
	// en beans.xml
	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	@Autowired
	private ServicioProvincias servicioProvincias;

	@RequestMapping("gestionarUsuarios")
	public String gestionarUsuarios(Model model) {
		model.addAttribute("usuarios",servicioUsuarios.obtenerUsuarios());		
		return "admin/gestionarUsuarios";
	}
	
	@RequestMapping("borrarUsuario")
	public String borrarUsuario(String idBorrar, Model model) {
		servicioUsuarios.borrarUsuario(Integer.parseInt(idBorrar));
		return gestionarUsuarios(model);
	}
	
	@RequestMapping("nuevoUsuario")
	public String nuevoUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("provincias", servicioProvincias.obtenerProvinciasParaDesplegable());
		return "admin/formRegistroUsuario";
	}
	
	@RequestMapping("guardarNuevoUsuario")
	public String guardarNuevoUsuario(Usuario usuario, Model model) {
		servicioUsuarios.registrarUsuario(usuario);
		return gestionarUsuarios(model);		
	}
	
	@RequestMapping("editarUsuario")
	public String editarUsuario(String idEditar, Model model) {
		Usuario usuario = servicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(idEditar));
		Map<String, String> mapProvincias = servicioProvincias.obtenerProvinciasParaDesplegable();
		usuario.setIdProvincia(usuario.getProvincia().getId());
		model.addAttribute("usuario", usuario);
		model.addAttribute("provincias", mapProvincias);
		return "admin/formEditarUsuario";
	}
	
	@RequestMapping("actualizarUsuario")
	public String actualizarUsuario(Usuario usuario, Model model) {
		servicioUsuarios.guardarCambiosUsuario(usuario);
		return gestionarUsuarios(model);
	}
	
}





