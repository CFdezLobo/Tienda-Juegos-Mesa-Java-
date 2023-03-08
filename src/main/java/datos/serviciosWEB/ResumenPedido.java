package datos.serviciosWEB;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;

public class ResumenPedido {
	
	private List<Map<String,Object>> juegos;
	
	//paso 1
	private String nombre;
	private String apellidos;
	private String direccion;
	private String provincia;
	private String cp;
	
	//paso 2
	private String titularTarjeta;
	private String numeroTarjeta;
	
	//paso 3
	private String observaciones;
	
	private double precioTotal;
	
	private int nProductos;
	
	
	public List<Map<String, Object>> getJuegos() {
		return juegos;
	}
	public void setJuegos(List<Map<String, Object>> juegos) {
		this.juegos = juegos;
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
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public int getnProductos() {
		return nProductos;
	}
	public void setnProductos(int nProductos) {
		this.nProductos = nProductos;
	}
	
	
}
