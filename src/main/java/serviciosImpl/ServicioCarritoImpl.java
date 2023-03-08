package serviciosImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantesSQL.ConstantesSQL;
import modelo.Carrito;
import modelo.JuegoMesa;
import modelo.ProductoCarrito;
import modelo.Usuario;
import servicios.ServicioCarrito;

@Service
@Transactional
public class ServicioCarritoImpl implements ServicioCarrito{
	
	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public void agregarProducto(Usuario u, int idProducto, int cantidad) {
		Usuario uBaseDeDatos = (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, u.getId()); 
		Carrito c = uBaseDeDatos.getCarrito();
				
		if(c == null) {
			c = new Carrito();
			c.setUsario(uBaseDeDatos);
			uBaseDeDatos.setCarrito(c);
			sessionFactory.getCurrentSession().save(c);
		}
		// Una vez obtenido o creado el carrito, vamos a ver si el producto que se quiere agregar ya existe en el carrito
		boolean producto_en_carrito = false;
				
		for (ProductoCarrito pc_en_carrito: c.getProductosCarrito()) {
			if(pc_en_carrito.getJuegoMesa().getId() == idProducto) {
				producto_en_carrito = true;
				pc_en_carrito.setCantidad(pc_en_carrito.getCantidad() + cantidad);
				sessionFactory.getCurrentSession().merge(pc_en_carrito);
			}
		}
		// Si el producto no esta en el carrito
		if(!producto_en_carrito) {
			ProductoCarrito pc = new ProductoCarrito();
			pc.setCarrito(c);
			pc.setCantidad(cantidad);
			pc.setJuegoMesa((JuegoMesa)sessionFactory.getCurrentSession().get(JuegoMesa.class, idProducto));
			sessionFactory.getCurrentSession().save(pc);
		}		
	}
	
	@Override
	public void borrarProducto(Usuario u, int idProducto) {
		Usuario uBaseDeDatos = (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, u.getId()); 
		Carrito c = uBaseDeDatos.getCarrito();
		
		boolean producto_en_carrito = false;
		
		for (ProductoCarrito pc_en_carrito: c.getProductosCarrito()) {
			if(pc_en_carrito.getJuegoMesa().getId() == idProducto) {
				producto_en_carrito = true;
				sessionFactory.getCurrentSession().delete(pc_en_carrito);
			}
		}
		
	} 

	@Override
	public List<Map<String,Object>> obtenerProductosCarrito(Usuario u) {
		Usuario uBaseDatos = (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, u.getId());
		Carrito c = uBaseDatos.getCarrito();
		List<Map<String,Object>> res = null;
		if(c != null) {
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(ConstantesSQL.SQL_OBTENER_PRODUCTOS_CARRITO);
			query.setParameter("carrito_id", c.getId());
			query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			res = query.list();
		}
		return res;
	}
	
	@Override
	public double obtenerPrecioTotalPedido(Usuario u) {
		double precioTotal = 0;
		Usuario uBaseDatos = (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, u.getId());
		Carrito c = uBaseDatos.getCarrito();
		
		for (ProductoCarrito productoCarrito: c.getProductosCarrito()) {
			precioTotal = precioTotal + ( productoCarrito.getJuegoMesa().getPrecio() * productoCarrito.getCantidad() );
		}
		return precioTotal;
	}

	@Override
	public void modificarCantidadProductoCarrito(Usuario u, int idProducto, int cantidad) {
		Usuario uBaseDatos = (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, u.getId());
		Carrito c = uBaseDatos.getCarrito();
		
		for (ProductoCarrito pc: c.getProductosCarrito()) {
			if(pc.getJuegoMesa().getId() == idProducto) {
				pc.setCantidad(cantidad);
			}
		}
	}

}
