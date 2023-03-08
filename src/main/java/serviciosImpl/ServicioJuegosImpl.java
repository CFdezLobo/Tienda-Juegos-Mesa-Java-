package serviciosImpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantes.Paginacion;
import constantesSQL.ConstantesSQL;
import modelo.Categoria;
import modelo.JuegoMesa;
import modelo.Usuario;
import servicios.ServicioJuegos;

@Service
@Transactional
public class ServicioJuegosImpl implements ServicioJuegos{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registrarJuego(JuegoMesa juego) {
		Categoria c = (Categoria) sessionFactory.getCurrentSession().get(Categoria.class, juego.getIdCategoria());
		juego.setCategoria(c);	
		sessionFactory.getCurrentSession().save(juego);
		
	}
	
	@Override
	public int obtenerTotalDeJuegos(String nombre) {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(ConstantesSQL.OBTENER_TOTAL_JUEGOS);
		query.setParameter("nombre", "%"+nombre+"%");
		return Integer.parseInt(query.list().get(0).toString());	
	}

	@Override
	public List<JuegoMesa> obtenerJuegos(String nombre, int comienzo) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(JuegoMesa.class);
		c.add(Restrictions.eq("alta",true));
		c.add(Restrictions.like("nombre", "%"+nombre+"%"));
		c.addOrder(Order.desc("id"));
		c.setFirstResult(comienzo);
		c.setMaxResults(Paginacion.RESULTADO_POR_PAGINA);
		return c.list();
	}

	@Override
	public void borrarJuegoMesa(int id) {
		JuegoMesa juego = (JuegoMesa)sessionFactory.getCurrentSession().get(JuegoMesa.class, id);
		juego.setAlta(false);
		sessionFactory.getCurrentSession().update(juego);		
	}

	@Override
	public void guardarCambiosJuego(JuegoMesa juego) {
		Categoria c = (Categoria)sessionFactory.getCurrentSession().get(Categoria.class,juego.getIdCategoria());
		juego.setCategoria(c);
//		juego.setAlta(true);
		sessionFactory.getCurrentSession().merge(juego);	
	}

	@Override
	public JuegoMesa obtenerJuegoPorId(int idJuego) {
		return (JuegoMesa) sessionFactory.getCurrentSession().get(JuegoMesa.class, idJuego);
	}

	@Override
	public int obtenerTotalDeJuegosAdmin(String nombre) {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(ConstantesSQL.OBTENER_TOTAL_JUEGOS_ADMIN);
		query.setParameter("nombre", "%"+nombre+"%");
		return Integer.parseInt(query.list().get(0).toString());
	}

	@Override
	public List<JuegoMesa> obtenerJuegosAdmin(String nombre, int comienzo) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(JuegoMesa.class);
		c.add(Restrictions.like("nombre", "%"+nombre+"%"));
		c.addOrder(Order.desc("id"));
		c.setFirstResult(comienzo);
		c.setMaxResults(Paginacion.RESULTADO_POR_PAGINA);
		return c.list();
	}
	
	
}
