package modelo;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	
	@ManyToOne(optional = false)
	private Usuario usuario;
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
	private List<ProductoPedido> productosPedido = new ArrayList<ProductoPedido>();
	
	// se piden en el paso 1:
	private String nombre;
	
	private String apellidos;
	
	private String direccion;
	
	private String provincia;
	
	private String cp;
	
	
	// se piden en el paso 2:
	
	private String titularTarjeta;
	
	private String numeroTarjeta;
	
	// se piden en el paso 3:
	@Column(length = 2000)
	private String observaciones;
	
	// La siguiente variable indica la situacion en la que se encuentra el pedido
	
	private String estado;
	
	private double precioTotal;
	
	@Id
	@GeneratedValue
	private int id;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ProductoPedido> getProductosPedido() {
		return productosPedido;
	}

	public void setProductosPedido(List<ProductoPedido> productosPedido) {
		this.productosPedido = productosPedido;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}	

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getTitularTarjeta() {
		return titularTarjeta;
	}

	public void setTitularTarjeta(String titularTarjeta) {
		this.titularTarjeta = titularTarjeta;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
