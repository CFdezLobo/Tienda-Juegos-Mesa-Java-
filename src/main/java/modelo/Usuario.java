package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	private String nombre;
	private String apellidos;
	private String dni;
	
	@Column(unique = true)
	private String email;
	
	private String pass;
	private int edad;
	private String telefono;
	
	@ManyToOne(targetEntity = Provincia.class, fetch = FetchType.EAGER)
	private Provincia provincia;
	
	@Transient
	private int idProvincia;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Carrito carrito;
	
	@Id
	@GeneratedValue
	private int id;
		
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int id, String nombre, String apellidos, String dni, String email, String pass, int edad,
			String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.pass = pass;
		this.edad = edad;
		this.telefono = telefono;
	}

	public Usuario(String nombre, String apellidos, String dni, String email, String pass, int edad, String telefono,
			Provincia provincia) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.pass = pass;
		this.edad = edad;
		this.telefono = telefono;
		this.provincia = provincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
