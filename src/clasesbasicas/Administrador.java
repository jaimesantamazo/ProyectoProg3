package clasesbasicas;

public class Administrador extends Usuario{
	private String contrase�a;
	
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String constrase�a) {
		this.contrase�a = constrase�a;
	}
	public Administrador(String constrase�a) {
		super();
		this.contrase�a = contrase�a;
	}
	public Administrador() {}
	
	

}
