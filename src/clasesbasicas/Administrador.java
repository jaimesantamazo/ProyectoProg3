package clasesbasicas;

public class Administrador extends Usuario{
	private String contraseña;
	
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String constraseña) {
		this.contraseña = constraseña;
	}
	public Administrador(String constraseña) {
		super();
		this.contraseña = contraseña;
	}
	public Administrador() {}
	
	

}
