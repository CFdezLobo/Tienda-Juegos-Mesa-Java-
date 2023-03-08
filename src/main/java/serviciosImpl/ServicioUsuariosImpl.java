package serviciosImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Carrito;
import modelo.ProductoCarrito;
import modelo.Provincia;
import modelo.Usuario;
import servicios.ServicioUsuarios;

@Service
@Transactional
public class ServicioUsuariosImpl implements ServicioUsuarios{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registrarUsuario(Usuario usuario) {
		Provincia p = (Provincia)sessionFactory.getCurrentSession().get(Provincia.class, usuario.getIdProvincia());
		usuario.setProvincia(p);
		sessionFactory.getCurrentSession().save(usuario);
		
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		return c.list();
	}

	@Override
	public void borrarUsuario(int id) {
		Usuario u = (Usuario) sessionFactory.getCurrentSession().get(Usuario.class, id);
		Carrito c = u.getCarrito();
		
		if(c != null) {
			List<ProductoCarrito> pc = c.getProductosCarrito();
			if(pc.size() > 0) {
				for (ProductoCarrito pc_en_carrito: c.getProductosCarrito()) {
					// Si tiene productos en el carrito elimino cada producto
					sessionFactory.getCurrentSession().delete(pc_en_carrito);
				}
			}
			// Elimino el carrito
			sessionFactory.getCurrentSession().delete(c);
		}
		// Elimino el usuario
		sessionFactory.getCurrentSession().delete(u);
	}

	@Override
	public Usuario obtenerUsuarioPorId(int idUsuario) {
		return (Usuario) sessionFactory.getCurrentSession().get(Usuario.class, idUsuario);
	}
	
	@Override
	public Usuario obtenerUsuarioPorEmail(String email) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		c.add(Restrictions.eq("email", email));
		Usuario u = null;
		if(c.uniqueResult()!=null) {
			u = (Usuario)c.uniqueResult();
		}
		return u;
	}

	@Override
	public void guardarCambiosUsuario(Usuario u) {
		Provincia p = (Provincia)sessionFactory.getCurrentSession().get(Provincia.class, u.getIdProvincia());
		u.setProvincia(p);
		sessionFactory.getCurrentSession().merge(u);
	}
	
	@Override
	public Usuario obtenerUsuarioPorEmailYPass(String email, String pass) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		c.add(Restrictions.eq("email", email));
		c.add(Restrictions.eq("pass", pass));
		Usuario u = null;
		if(c.uniqueResult() != null) {
			u = (Usuario)c.uniqueResult();			
		}
		return u;
	}
	
}
