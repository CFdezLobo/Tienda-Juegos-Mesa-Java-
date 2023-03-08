package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Carrito {

	@OneToOne
	private Usuario usario;
	
	@OneToMany(mappedBy = "carrito")
	private List<ProductoCarrito> productosCarrito = new ArrayList<ProductoCarrito>();
	
	@Id
	@GeneratedValue
	private int id;

	public Usuario getUsario() {
		return usario;
	}

	public void setUsario(Usuario usario) {
		this.usario = usario;
	}

	public List<ProductoCarrito> getProductosCarrito() {
		return productosCarrito;
	}

	public void setProductosCarrito(List<ProductoCarrito> productosCarrito) {
		this.productosCarrito = productosCarrito;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
