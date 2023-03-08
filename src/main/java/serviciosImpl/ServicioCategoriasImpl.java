package serviciosImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantesSQL.ConstantesSQL;
import modelo.Categoria;
import modelo.JuegoMesa;
import modelo.Pedido;
import modelo.Usuario;
import servicios.ServicioCategorias;

@Service
@Transactional
public class ServicioCategoriasImpl implements ServicioCategorias{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Categoria> obtenerCategorias() {
		List<Categoria> categorias = sessionFactory.getCurrentSession().createQuery("from Categoria").list();
		return categorias;
	}
	
	@Override
	public void registrarCategoria(Categoria c) {
		sessionFactory.getCurrentSession().save(c);
	}

	@Override
	public void borrarCategoria(int id) {
		Categoria c = (Categoria)sessionFactory.getCurrentSession().get(Categoria.class, id);
		sessionFactory.getCurrentSession().delete(c);
		
	}

	@Override
	public void guardarCambiosCategoria(Categoria c) {
		sessionFactory.getCurrentSession().merge(c);		
	}
	
	@Override
	public Categoria obtenerCategoriaPorId(int idCategoria) {
		return (Categoria) sessionFactory.getCurrentSession().get(Categoria.class, idCategoria);
	}

	@Override
	public Map<String, String> obtenerCategoriasParaDesplegable() {
		//Para lanzar sql a través de Hibernate:
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(ConstantesSQL.SQL_OBTENER_CATEGORIAS_PARA_DESPLEGABLE);
		// Para indicar que la consulta me devuelva elementos de tipo Map, debo indicar lo siguiente:
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
				
		List<Map<String, Object>> resultado = query.list();
				
		// Debemos transformar de nuevo lo que nos da hibernate:
		Map<String, String> valoresDesplegable = new HashMap<>(); 
		for (Map<String, Object> map : resultado) {
			System.out.println("Obtenido: " + map.get("id") + " nombre: " + map.get("nombre"));
			valoresDesplegable.put(map.get("id").toString(), map.get("nombre").toString());
		}
				
	return valoresDesplegable;
	}
	
	
}
