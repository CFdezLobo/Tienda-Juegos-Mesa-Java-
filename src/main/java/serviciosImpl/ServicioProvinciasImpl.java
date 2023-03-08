package serviciosImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantesSQL.ConstantesSQL;
import servicios.ServicioProvincias;

@Service
@Transactional
public class ServicioProvinciasImpl implements ServicioProvincias{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Map<String, String> obtenerProvinciasParaDesplegable() {
		//Para lanzar sql a través de Hibernate:
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(ConstantesSQL.SQL_OBTENER_PROVINCIAS_PARA_DESPLEGABLE);
		// Para indicar que la consulta me devuelva elementos de tipo Map, debo indicar lo siguiente:
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
						
		List<Map<String, Object>> resultado = query.list();
						
		// Debemos transformar de nuevo lo que nos da hibernate:
		Map<String, String> valoresDesplegable = new LinkedHashMap<>(); 
		for (Map<String, Object> map : resultado) {
			System.out.println("Obtenido: " + map.get("id") + " nombre: " + map.get("nombre"));
			valoresDesplegable.put(map.get("id").toString(), map.get("nombre").toString());
		}
		return valoresDesplegable;
	}

}
