package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provincias")
public class Provincia {
	
	private String nombre;
	
	@Id
	@GeneratedValue
	private int id;

	public Provincia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Provincia(String nombre) {
		super();
		this.nombre = nombre;
		this.id = id;
	}

	public Provincia(String nombre, int id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
