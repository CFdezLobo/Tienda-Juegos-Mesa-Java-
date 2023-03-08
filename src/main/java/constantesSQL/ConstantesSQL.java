package constantesSQL;

public class ConstantesSQL {
	
	public final static String SQL_OBTENER_CATEGORIAS_PARA_DESPLEGABLE = "SELECT id,nombre FROM categorias ORDER BY nombre ASC;";
	
	public static final String SQL_OBTENER_PROVINCIAS_PARA_DESPLEGABLE = "SELECT id,nombre FROM provincias ORDER BY id asc;";
	
	public static final String SQL_OBTENER_PRODUCTOS_CARRITO = "SELECT juegos.id AS juego_id, juegos.nombre, juegos.precio, juegos.nJugadores, juegos.duracion, "
			+ "juegos.dificultad, juegos.idioma, categorias.nombre AS categoria, productocarrito.cantidad "
			+ "FROM juegos, categorias, productocarrito "
			+ "WHERE productocarrito.juegoMesa_id = juegos.id "
			+ "AND productocarrito.carrito_id = :carrito_id "
			+ "AND juegos.categoria_id = categorias.id "
			+ "ORDER BY productocarrito.id ASC;";

	public static final String BORRAR_PRODUCTOS_CARRITO = "DELETE FROM productocarrito WHERE carrito_id = :carrito_id ;";

	public static final String OBTENER_TOTAL_JUEGOS = "SELECT COUNT(id) FROM juegos WHERE nombre LIKE :nombre and alta = 1;";

	public static final String OBTENER_TOTAL_JUEGOS_ADMIN = "SELECT COUNT(id) FROM juegos WHERE nombre LIKE :nombre ;";

	
}
