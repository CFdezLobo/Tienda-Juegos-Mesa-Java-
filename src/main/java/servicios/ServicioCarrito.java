package servicios;

import java.util.List;
import java.util.Map;

import modelo.Usuario;

public interface ServicioCarrito {
	
	void agregarProducto(Usuario u, int idProducto, int cantidad);
	
	void borrarProducto(Usuario u, int idProducto);
	
	List<Map<String,Object>> obtenerProductosCarrito(Usuario u);
	
	double obtenerPrecioTotalPedido(Usuario u);
	
	void modificarCantidadProductoCarrito(Usuario u, int idProducto, int cantidad);
	

}
