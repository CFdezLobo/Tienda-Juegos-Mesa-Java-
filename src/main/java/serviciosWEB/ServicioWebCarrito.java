package serviciosWEB;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import modelo.Usuario;
import servicios.ServicioCarrito;

@Controller
@RequestMapping("ServicioWebCarrito/")
public class ServicioWebCarrito {
	
	@Autowired
	private ServicioCarrito servicioCarrito;
	
	@RequestMapping("agregaJuego")
	public ResponseEntity<String> agregaJuego(String idProducto, String cantidad, HttpServletRequest request) throws Exception{
		String respuesta = "Agregar el producto de id: " + idProducto +  " cantidad: " + cantidad +
				" al carrito del usuario " + ((Usuario) request.getSession().getAttribute("usuario")).getNombre();
		
		servicioCarrito.agregarProducto(
				((Usuario)request.getSession().getAttribute("usuario")), 
				Integer.parseInt(idProducto), 				
				Integer.parseInt(cantidad));
		
		if(Integer.parseInt(cantidad) < 1) {
			cantidad = "1";
			throw new Exception("Cantidad de producto inferior a 1");
		}
		
		respuesta = "Producto agregado al carrito correctamente";
		
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
	
	@RequestMapping("obtenerProductosCarrito")
	public ResponseEntity<String> obtenerProductosCarrito(HttpServletRequest request){
		String respuesta = "";
		respuesta = new Gson().toJson(servicioCarrito.obtenerProductosCarrito(((Usuario)request.getSession().getAttribute("usuario"))));
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
	
	@RequestMapping("borrarJuego")
	public ResponseEntity<String> borrarJuego(String idProducto, HttpServletRequest request) throws Exception{
		String respuesta = "Borrar el producto de id: " + idProducto +
				" del carrito del usuario " + ((Usuario) request.getSession().getAttribute("usuario")).getNombre();
		
		servicioCarrito.borrarProducto(
				((Usuario)request.getSession().getAttribute("usuario")), 
				Integer.parseInt(idProducto));
		
		respuesta = "Producto borrado del carrito correctamente";
		
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
	
	@RequestMapping("modificarCantidadProductoCarrito")
	public ResponseEntity<String> modificarCantidadProductoCarritoegaJuego(String idProducto, String cantidad, HttpServletRequest request){
		String respuesta = "Modificar el producto de id: " + idProducto +  " a la nueva cantidad de: " + cantidad +
				" al carrito del usuario " + ((Usuario) request.getSession().getAttribute("usuario")).getNombre();
		System.out.println(respuesta);
		servicioCarrito.modificarCantidadProductoCarrito(
				((Usuario)request.getSession().getAttribute("usuario")), 
				Integer.parseInt(idProducto), 				
				Integer.parseInt(cantidad));
		
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
	
}
