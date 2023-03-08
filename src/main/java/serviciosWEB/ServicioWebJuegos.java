package serviciosWEB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import datos.serviciosWEB.RespuestaJuegos;
import servicios.ServicioJuegos;

@Controller
@RequestMapping("ServicioWebJuegos/")
public class ServicioWebJuegos {

	@Autowired
	private ServicioJuegos servicioJuegos;
	
	@RequestMapping("obtenerJuegos")
	public ResponseEntity<String> obtenerJuegos(@RequestParam(defaultValue = "") String nombre, @RequestParam(defaultValue = "0") String comienzo){
		RespuestaJuegos r1 = new RespuestaJuegos();
		r1.setJuegos(servicioJuegos.obtenerJuegos(nombre, Integer.parseInt(comienzo)));
		r1.setTotal(servicioJuegos.obtenerTotalDeJuegos(nombre));
		String respuesta = new Gson().toJson(r1);
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
		
	}
	
	@RequestMapping("obtenerJuegoPorId")
	public ResponseEntity<String> obtenerJuegoPorId(String id){
		String json = new Gson().toJson(servicioJuegos.obtenerJuegoPorId(Integer.parseInt(id)));
		return new ResponseEntity<String>(json,HttpStatus.OK);
	}
}
