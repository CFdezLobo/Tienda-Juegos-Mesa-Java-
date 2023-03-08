package datos.serviciosWEB;

import java.util.List;

import modelo.JuegoMesa;

public class RespuestaJuegos {
	
	private int total;
	private List<JuegoMesa> juegos;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<JuegoMesa> getJuegos() {
		return juegos;
	}
	public void setJuegos(List<JuegoMesa> juegos) {
		this.juegos = juegos;
	}	
	
}
