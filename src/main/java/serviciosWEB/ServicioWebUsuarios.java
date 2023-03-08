package serviciosWEB;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import modelo.Provincia;
import modelo.Usuario;
import servicios.ServicioProvincias;
import servicios.ServicioUsuarios;
import utilidadesArchivos.GestorArchivos;

@Controller
@RequestMapping("ServicioWebUsuarios/")
public class ServicioWebUsuarios {
	
	@Autowired
	private ServicioUsuarios servicioUsuarios;

	
	@RequestMapping("registrarUsuario")
	public ResponseEntity<String> registrarUsuario(@RequestParam Map<String, Object> formData, 
			@RequestParam("foto") CommonsMultipartFile foto,
			HttpServletRequest request){
		
		String respuesta = "ok";	
		Gson gson = new Gson();
		JsonElement json = gson.toJsonTree(formData);
		Usuario u = gson.fromJson(json, Usuario.class);
		
		if( servicioUsuarios.obtenerUsuarioPorEmail(u.getEmail()) == null ) {
			System.out.println("Usuario a registrar: " + u.toString());
			System.out.println("asociar la provincia de id: " + u.getIdProvincia() + " al usuario: " + u.toString() + " en el impl");
			String rutaRealDelProyecto = request.getServletContext().getRealPath("");
			servicioUsuarios.registrarUsuario(u);
			GestorArchivos.guardarFotoUsuario(u, foto, rutaRealDelProyecto);
		}else {
			respuesta = "Email ya registrado";
		}
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}
	
	@RequestMapping("identificarUsuario")
	public ResponseEntity<String> identificarUsuario(String email, String pass, HttpServletRequest request){
		String respuesta = "";
		//Comprobar en BD si el conjunto email pass es correcto
		Usuario u = servicioUsuarios.obtenerUsuarioPorEmailYPass(email, pass);
		if(u != null) {
			request.getSession().setAttribute("usuario", u);
			respuesta = "ok, " + u.getNombre() + "," + u.getId();
		}else {
			respuesta = "error, Email o Contraseña incorrectos";
		}
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}
	
	@RequestMapping("logout")
	public ResponseEntity<String> logout(HttpServletRequest request){
		request.getSession().invalidate();
		return new ResponseEntity<String>("ok",HttpStatus.OK);
	}
}
