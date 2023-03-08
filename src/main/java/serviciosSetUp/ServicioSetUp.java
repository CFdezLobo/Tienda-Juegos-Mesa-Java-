package serviciosSetUp;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Categoria;
import modelo.JuegoMesa;
import modelo.Provincia;
import modelo.SetUp;
import modelo.Usuario;

@Service
@Transactional
public class ServicioSetUp implements InterfazSetUp{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void setUp() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(SetUp.class);
		if(c.list().size() == 0) {
			
			ArrayList<Provincia> provincias = new ArrayList<Provincia>();
			String[] arr = {"Álava", "Albacete", "Alicante", "Almería", "Asturias", "Ávila", "Badajoz", "Baleares", "Barcelona",
					"Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón","Ceuta", "Ciudad Real", "Córdoba", "Cuenca", 
					"Girona", "Granada", "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Jaén", "A Coruña", "La Rioja", 
					"Las Palmas", "León", "Lleida", "Lugo", "Madrid", "Málaga","Melilla", "Murcia", "Navarra", "Orense", "Palencia", 
					"Pontevedra", "Salamanca", "Segovia", "Sevilla", "Soria", "Tarragona", "Tenerife", "Teruel", 
					"Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza"};
			
			for (int i = 0; i < arr.length; i++) {
				Provincia temp = new Provincia(arr[i]);
				provincias.add(temp);
				sessionFactory.getCurrentSession().save(temp);
			}
			
			sessionFactory.getCurrentSession().save(new Usuario("Carlos","Fdez. Lobo","05306897Q","carlos@gmail.com","123",35,"627400091",provincias.get(0)));
			sessionFactory.getCurrentSession().save(new Usuario("Pedro","Robles Ramirez","05306897R","pedrito@gmail.com","123",33,"627400190",provincias.get(1)));
			sessionFactory.getCurrentSession().save(new Usuario("Paquita","Salas","05306891T","paquita@gmail.com","123",33,"628412382",provincias.get(2)));
			
			Categoria familiar = new Categoria("Familiar","Juegos de reglas sencillas para compartir momentos de diversión con la familia y los amigos.");
			sessionFactory.getCurrentSession().save(familiar);
			Categoria cooperativo = new Categoria("Cooperativo","Juegos para jugar en equipo. Ser cooperativo es la clave para conseguir el objetivo y ganar la partida juntos.");
			sessionFactory.getCurrentSession().save(cooperativo);
			Categoria fiesta = new Categoria("Fiesta","Los mejores juegos de fiesta divertidos para jugar con la familia y los amigos. Juegos de fiesta para todos los públicos con los que jugar y no parar de reír.");
			sessionFactory.getCurrentSession().save(fiesta);
			
			// 100 registros de prueba para paginación.
			for (int i = 0; i < 100; i++) {
				sessionFactory.getCurrentSession().save(new JuegoMesa("Uno " + i,11.99,"2-4",15,"Fácil","Español",
						"Líbrate de todas las cartas antes que tus rivales ... pero no te olvides de avisar cuando solo te quede UNA."
						,true,familiar));
			}			
			sessionFactory.getCurrentSession().save(new JuegoMesa("Código Secreto",19.5,"2-8",15,"Media","Español", 
					"Código secreto es un divertido juego de cartas por equipos ideal para fiestas y reuniones. "
					+ "Cada grupo tendrá que descubrir antes que el otro una serie de palabras a través de otras "
					+ "que las relacionen entre si.Métete en la mente de quien tienes delante e intenta decir "
					+ "alguna palabra que se relacione con las que están encima de la mesa pero que no confunda con otras que no os corresponden."
					+ "¡Imaginación y compenetración serán las claves para ganar!",true, fiesta));
			sessionFactory.getCurrentSession().save(new JuegoMesa("Misión Cumplida",9.95,"2-4",20,"Fácil","Español", 
					"Misión Cumplida es un juego de cartas cooperativo en el que deberéis trabajar en equipo para "
					+ "cumplir el mayor número posible de retos. Juego muy divertido, familiar y para todas las edades. "
					+ "Empezad jugando al modo principiante y... seguro que llegáis pronto a superar el modo experto y "
					+ "¡locura!¿Os atrevéis a jugar y ganar a Misión Cumplida?",true, cooperativo));
			sessionFactory.getCurrentSession().save(new JuegoMesa("Virus",13.46,"2-6",15,"Fácil","Español", 
					"Virus es un juego de cartas contagioso. No podrás jugar solo una partida y querrás llevarlo a todas partes contigo."
					+ " Consigue tener un cuerpo sano y vigoroso mientras contagias con virus los órganos de los demás. "
					+ "El pique y la diversión están garantizados.",true, familiar));
			
			SetUp setUp = new SetUp();
			setUp.setCompleto(true);
			sessionFactory.getCurrentSession().save(setUp);
			
		}
	}
}
