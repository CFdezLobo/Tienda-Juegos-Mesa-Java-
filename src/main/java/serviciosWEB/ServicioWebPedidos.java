package serviciosWEB;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import datos.serviciosWEB.ResumenPedido;
import modelo.Usuario;
import servicios.ServicioPedidos;

@Controller
@RequestMapping("ServicioWebPedidos/")
public class ServicioWebPedidos {

	@Autowired
	private ServicioPedidos servicioPedidos;
	
	@RequestMapping("paso1")
	public ResponseEntity<String> paso1(String nombre, String apellidos, String direccion, String provincia, String cp, HttpServletRequest request){
		String respuesta = "";
		servicioPedidos.procesarPaso1(nombre, apellidos, direccion, provincia, cp, (Usuario)request.getSession().getAttribute("usuario"));
		respuesta = "ok";
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}
	
	@RequestMapping("paso2")
	public ResponseEntity<String> paso2(String titular, String numero, HttpServletRequest request){
		String respuesta = "";
		Usuario u = (Usuario)request.getSession().getAttribute("usuario");
		servicioPedidos.procesarPaso2(titular, numero, u);
		respuesta = "ok";
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}
	
	@RequestMapping("paso3")
	public ResponseEntity<String> paso3(String observaciones, HttpServletRequest request){
		String respuesta = "";
		Usuario u = (Usuario)request.getSession().getAttribute("usuario");
		servicioPedidos.procesarPaso3(observaciones, u);
		ResumenPedido resumen = servicioPedidos.obtenerResumenDelPedido(u);
		respuesta = "ok:" + new Gson().toJson(resumen);
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}
	
	@RequestMapping("confirmarPedido")
	public ResponseEntity<String> confirmarPedido(HttpServletRequest request){
		String respuesta = "";
		servicioPedidos.confirmarPedido((Usuario)request.getSession().getAttribute("usuario"));
		respuesta = "Pedido completado, puedes seguir comprando";
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}
	
}
