package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductoPedido {
	
	@ManyToOne
	private Pedido pedido;
	
	@ManyToOne
	private JuegoMesa juego;
	
	private int cantidad;
	
	@Id
	@GeneratedValue
	private int id;
	

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public JuegoMesa getJuego() {
		return juego;
	}

	public void setJuego(JuegoMesa juego) {
		this.juego = juego;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
