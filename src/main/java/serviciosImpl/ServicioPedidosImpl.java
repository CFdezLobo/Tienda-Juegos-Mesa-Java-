package serviciosImpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import constantes.EstadosPedido;
import constantesSQL.ConstantesSQL;
import datos.serviciosWEB.ResumenPedido;
import modelo.Carrito;
import modelo.Pedido;
import modelo.ProductoCarrito;
import modelo.ProductoPedido;
import modelo.Usuario;
import servicios.ServicioCarrito;
import servicios.ServicioPedidos;

@Controller
@Transactional
public class ServicioPedidosImpl implements ServicioPedidos{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ServicioCarrito servicioCarrito;

	@Override
	public void procesarPaso1(String nombre, String apellidos, String direccion, String provincia, String cp, Usuario usuario) {
		Pedido p = obtenerPedidoActual(usuario);
		p.setUsuario(usuario);
		p.setNombre(nombre);
		p.setApellidos(apellidos);
		p.setDireccion(direccion);
		p.setProvincia(provincia);
		p.setCp(cp);
		sessionFactory.getCurrentSession().save(p);
		
	}
	
	@Override
	public void procesarPaso2(String titular, String numero, Usuario usuario) {
		Pedido p = obtenerPedidoActual(usuario);
		p.setTitularTarjeta(titular);
		p.setNumeroTarjeta(numero);
		sessionFactory.getCurrentSession().update(p);
		
	}
	
	@Override
	public void procesarPaso3(String observaciones, Usuario usuario) {
		Pedido p = obtenerPedidoActual(usuario);
		p.setObservaciones(observaciones);
		p.setPrecioTotal(servicioCarrito.obtenerPrecioTotalPedido(usuario));
		sessionFactory.getCurrentSession().update(p);
	}
	
	@Override
	public ResumenPedido obtenerResumenDelPedido(Usuario usuario) {
		ResumenPedido resumen = new ResumenPedido();
		Pedido p = obtenerPedidoActual(usuario);
		resumen.setNombre(p.getNombre());
		resumen.setApellidos(p.getApellidos());
		resumen.setDireccion(p.getDireccion());
		resumen.setProvincia(p.getProvincia());
		resumen.setCp(p.getCp());
		resumen.setTitularTarjeta(p.getTitularTarjeta());
		resumen.setNumeroTarjeta(p.getNumeroTarjeta());
		resumen.setObservaciones(p.getObservaciones());
		resumen.setPrecioTotal(servicioCarrito.obtenerPrecioTotalPedido(usuario));
		resumen.setJuegos(servicioCarrito.obtenerProductosCarrito(usuario));	
		resumen.setnProductos(servicioCarrito.obtenerProductosCarrito(usuario).size());
		return resumen;
	}
	
	@Override
	public void confirmarPedido(Usuario usuario) {
		Pedido p = obtenerPedidoActual(usuario);
		Usuario uBaseDatos = (Usuario) sessionFactory.getCurrentSession().get(Usuario.class, usuario.getId());
		Carrito c = uBaseDatos.getCarrito();
		if(c != null) {
			for(ProductoCarrito pc : c.getProductosCarrito()) {
				ProductoPedido pp = new ProductoPedido();
				pp.setCantidad(pc.getCantidad());
				pp.setJuego(pc.getJuegoMesa());
				p.getProductosPedido().add(pp);
				pp.setPedido(p);
				sessionFactory.getCurrentSession().save(pp);
			}
		}
		// borrar los productos del carrito
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(ConstantesSQL.BORRAR_PRODUCTOS_CARRITO);
		query.setParameter("carrito_id", c.getId());
		query.executeUpdate();
		// finalizamos pedido
		p.setEstado(EstadosPedido.COMPLETADO);
		sessionFactory.getCurrentSession().update(p);
		
	}
	
	private Pedido obtenerPedidoActual(Usuario usuario) {
		Usuario uBaseDatos = (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, usuario.getId());
		
		Object pedidoEnProceso = 
				sessionFactory.getCurrentSession().createCriteria(Pedido.class)
				.add(Restrictions.eq("estado", EstadosPedido.EN_PROCESO))
				.add(Restrictions.eq("usuario.id", usuario.getId())).uniqueResult();
		
		Pedido p = null;
		if(pedidoEnProceso == null) {
			p = new Pedido();
			p.setEstado(EstadosPedido.EN_PROCESO);
			p.setUsuario(uBaseDatos);
		}else {
			p = (Pedido) pedidoEnProceso;
		}
		return p;
	}

	@Override
	public List<Pedido> obtenerPedidos() {
		List<Pedido> pedidos = sessionFactory.getCurrentSession().createQuery("from Pedido").list();
		return pedidos;
	}

	@Override
	public Pedido obtenerPedidoPorId(int idPedido) {
		return (Pedido)sessionFactory.getCurrentSession().get(Pedido.class, idPedido);
	}

	@Override
	public void actualizarEstadoPedido(int idPedido, String estado) {
		Pedido p = obtenerPedidoPorId(idPedido);
		p.setEstado(estado);
		sessionFactory.getCurrentSession().update(p);
		
	}

	@Override
	public double obtenerPrecioTotalPedido(int idPedido) {
		double precioTotal = 0;
		Pedido p = obtenerPedidoPorId(idPedido);
		
		for (ProductoPedido productoPedido : p.getProductosPedido()) {
			precioTotal = precioTotal + ( productoPedido.getJuego().getPrecio() * productoPedido.getCantidad() );
		}
		return precioTotal;
	}
	
	

}
