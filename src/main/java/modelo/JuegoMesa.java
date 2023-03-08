package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "juegos")
public class JuegoMesa {
	
	@NotEmpty(message = "Nombre no puede estar vacio")
	@Size( min = 1, max = 40, message = "Nombre debe tener entre 1 y 40 caracteres")
	@Pattern(regexp = "^[a-zA-Z áéíóúÁÉÍÓÚñÑ0-9]{1,40}$", message = "Solo letras, numeros y espacios")
	private String nombre;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,###.###")
	@Min(value = 1, message = "El precio mínimo es un euro")
	@Max(value = 999, message = "El precio máximo es 999 euros")
	private double precio;
	
	private String nJugadores;
	private int duracion;
	private String dificultad;
	private String idioma;
	
	@Column(length = 9000)	
	private String descripcion;
	
	private boolean alta;
	
	@Column(nullable = true)
	private Date fechaImagenPortada;
	
	@Column(nullable = true)
	private Date fechaImagenContraPortada;
	
	@Column(nullable = true)
	private Date fechaImagenjuegoDesplegado1;
	
	@Column(nullable = true)
	private Date fechaImagenjuegoDesplegado2;
	
	@ManyToOne(targetEntity = Categoria.class, optional = false, fetch = FetchType.EAGER)
	private Categoria categoria;
	
	@Transient
	private int idCategoria;
	
	@Transient
	private MultipartFile portada;
	
	@Transient
	private MultipartFile contraportada;
	
	@Transient
	private MultipartFile juegoDesplegado1;
	
	@Transient
	private MultipartFile juegoDesplegado2;
	
	@Id
	@GeneratedValue
	private int id;
	
	public JuegoMesa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JuegoMesa(String nombre, double precio, String nJugadores, int duracion, String dificultad, String idioma, 
			String descripcion, boolean alta, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.nJugadores = nJugadores;
		this.duracion = duracion;
		this.dificultad = dificultad;
		this.idioma = idioma;
		this.descripcion = descripcion;
		this.alta = alta;
		this.categoria = categoria;
	}

	public JuegoMesa(int id, String nombre, double precio, String nJugadores, int duracion, String dificultad, String idioma) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.nJugadores = nJugadores;
		this.duracion = duracion;
		this.dificultad = dificultad;
		this.idioma = idioma;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getnJugadores() {
		return nJugadores;
	}

	public void setnJugadores(String nJugadores) {
		this.nJugadores = nJugadores;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	public Date getFechaImagenPortada() {
		return fechaImagenPortada;
	}

	public void setFechaImagenPortada(Date fechaImagenPortada) {
		this.fechaImagenPortada = fechaImagenPortada;
	}

	public Date getFechaImagenContraPortada() {
		return fechaImagenContraPortada;
	}

	public void setFechaImagenContraPortada(Date fechaImagenContraPortada) {
		this.fechaImagenContraPortada = fechaImagenContraPortada;
	}

	public Date getFechaImagenjuegoDesplegado1() {
		return fechaImagenjuegoDesplegado1;
	}

	public void setFechaImagenjuegoDesplegado1(Date fechaImagenjuegoDesplegado1) {
		this.fechaImagenjuegoDesplegado1 = fechaImagenjuegoDesplegado1;
	}

	public Date getFechaImagenjuegoDesplegado2() {
		return fechaImagenjuegoDesplegado2;
	}

	public void setFechaImagenjuegoDesplegado2(Date fechaImagenjuegoDesplegado2) {
		this.fechaImagenjuegoDesplegado2 = fechaImagenjuegoDesplegado2;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public MultipartFile getPortada() {
		return portada;
	}

	public void setPortada(MultipartFile portada) {
		this.portada = portada;
	}

	public MultipartFile getContraportada() {
		return contraportada;
	}

	public void setContraportada(MultipartFile contraportada) {
		this.contraportada = contraportada;
	}
	public MultipartFile getJuegoDesplegado1() {
		return juegoDesplegado1;
	}

	public void setJuegoDesplegado1(MultipartFile juegoDesplegado1) {
		this.juegoDesplegado1 = juegoDesplegado1;
	}

	public MultipartFile getJuegoDesplegado2() {
		return juegoDesplegado2;
	}

	public void setJuegoDesplegado2(MultipartFile juegoDesplegado2) {
		this.juegoDesplegado2 = juegoDesplegado2;
	}
	
}
