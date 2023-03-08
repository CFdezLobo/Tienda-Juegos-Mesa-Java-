package controladores.admin;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import constantes.Paginacion;
import modelo.JuegoMesa;
import servicios.ServicioCategorias;
import servicios.ServicioJuegos;
import utilidadesArchivos.GestorArchivos;

@Controller
@RequestMapping("/admin/")
public class JuegosControllerAdmin {
	
	@Autowired
	private ServicioJuegos servicioJuegos;
	
	@Autowired
	private ServicioCategorias servicioCategorias;
	
	@RequestMapping("gestionarJuegos")
	public String gestionarJuegos(Model model, @RequestParam(defaultValue = "") String nombre, @RequestParam(defaultValue = "0") String comienzo) {
		int comienzoInt = Integer.parseInt(comienzo);
		model.addAttribute("juegos", servicioJuegos.obtenerJuegosAdmin(nombre, comienzoInt));	
		model.addAttribute("nombre", nombre);
		model.addAttribute("siguiente", comienzoInt + Paginacion.RESULTADO_POR_PAGINA);
		model.addAttribute("anterior", comienzoInt - Paginacion.RESULTADO_POR_PAGINA);
		model.addAttribute("total", servicioJuegos.obtenerTotalDeJuegosAdmin(nombre));
		return "admin/gestionarJuegos";

	}
	
	@RequestMapping("borrarJuego")
	public String borrarUsuario(String idBorrar, Model model, HttpServletRequest request) {
		servicioJuegos.borrarJuegoMesa(Integer.parseInt(idBorrar));
		String rutaRealDelProyecto = request.getServletContext().getRealPath("");
		GestorArchivos.borrarImagenesJuego(idBorrar, rutaRealDelProyecto);
		return gestionarJuegos(model,"","0");
	}
	
	@RequestMapping("nuevoJuego")
	public String nuevoJuego(Model model) {
		JuegoMesa juego = new JuegoMesa();
		juego.setAlta(true);
		model.addAttribute("juego", juego);
		model.addAttribute("categorias" , servicioCategorias.obtenerCategoriasParaDesplegable());
		return "admin/formRegistroJuego";
	}
	
	@RequestMapping("guardarNuevoJuego")
	public String guardarNuevoJuego(@ModelAttribute("juego") @Valid JuegoMesa juego, BindingResult br, Model model, HttpServletRequest request) {	
		if( ! br.hasErrors()) {
			if(juego.getPortada().getSize() != 0) {
				juego.setFechaImagenPortada(new Date());
			}
			if(juego.getContraportada().getSize() != 0) {
				juego.setFechaImagenContraPortada(new Date());
			}
			if(juego.getJuegoDesplegado1().getSize() != 0) {
				juego.setFechaImagenjuegoDesplegado1(new Date());
			}
			if(juego.getJuegoDesplegado2().getSize() != 0) {
				juego.setFechaImagenjuegoDesplegado2(new Date());
			}
			servicioJuegos.registrarJuego(juego);
			String rutaRealDelProyecto = request.getServletContext().getRealPath("");
			GestorArchivos.guardarImagenesJuego(juego, rutaRealDelProyecto);
			return gestionarJuegos(model,"","0");	
		}else {
			model.addAttribute("juego", juego);
			model.addAttribute("categorias", servicioCategorias.obtenerCategoriasParaDesplegable());
			return "admin/formRegistroJuego";
		}
	}
	
	@RequestMapping("editarJuego")
	public String editarJuego(String idEditar, Model model) {
		JuegoMesa juego = servicioJuegos.obtenerJuegoPorId(Integer.parseInt(idEditar));
		Map<String, String> mapCategorias = servicioCategorias.obtenerCategoriasParaDesplegable();
		juego.setIdCategoria(juego.getCategoria().getId());
		model.addAttribute("juego", juego);
		model.addAttribute("categorias", mapCategorias);
		return "admin/formEditarJuego";
	}
	
	@RequestMapping("actualizarJuego")
	public String actualizarJuego(JuegoMesa juego, Model model, HttpServletRequest request) {
		if(juego.getPortada().getSize() != 0) {
			juego.setFechaImagenPortada(new Date());
		}
		if(juego.getContraportada().getSize() != 0) {
			juego.setFechaImagenContraPortada(new Date());
		}
		if(juego.getJuegoDesplegado1().getSize() != 0) {
			juego.setFechaImagenjuegoDesplegado1(new Date());
		}
		if(juego.getJuegoDesplegado2().getSize() != 0) {
			juego.setFechaImagenjuegoDesplegado2(new Date());
		}
		servicioJuegos.guardarCambiosJuego(juego);
		String rutaRealDelProyecto = request.getServletContext().getRealPath("");
		GestorArchivos.guardarImagenesJuego(juego, rutaRealDelProyecto);
		return gestionarJuegos(model,"","0");
	}
}
