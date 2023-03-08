package controladores.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Categoria;
import modelo.JuegoMesa;
import modelo.Usuario;
import servicios.ServicioCategorias;

@Controller
@RequestMapping("/admin/")
public class CategoriasControllerAdmin {
	
	@Autowired
	private ServicioCategorias servicioCategorias;
	
	@RequestMapping("gestionarCategorias")
	public String gestionarCategorias(Model model) {	
		model.addAttribute("categorias", servicioCategorias.obtenerCategorias());	
		return "admin/gestionarCategorias";
	}
	
	@RequestMapping("borrarCategoria")
	public String borrarCategoria(String idBorrar, Model model) {
		servicioCategorias.borrarCategoria(Integer.parseInt(idBorrar));
		return gestionarCategorias(model);
	}
	
	@RequestMapping("nuevaCategoria")
	public String nuevaCategoria(Model model) {
		Categoria categoria = new Categoria();
		model.addAttribute("categoria", categoria);
		return "admin/formRegistroCategoria";
	}
	
	@RequestMapping("guardarNuevaCategoria")
	public String guardarNuevaCategoria(Categoria c, Model model) {
		servicioCategorias.registrarCategoria(c);;
		return gestionarCategorias(model);		
	}
	
	@RequestMapping("editarCategoria")
	public String editarUsuario(String idEditar, Model model) {
		Categoria c = servicioCategorias.obtenerCategoriaPorId(Integer.parseInt(idEditar));
		model.addAttribute("categoria", c);
		return "admin/formEditarCategoria";
	}
	
	@RequestMapping("actualizarCategoria")
	public String actualizarCategoria(Categoria c, Model model) {
		servicioCategorias.guardarCambiosCategoria(c);
		return gestionarCategorias(model);
	}

}
