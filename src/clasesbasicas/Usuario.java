package clasesbasicas;

public class Usuario {
	private String username;
	private String email;
	private String nombre;
	private String apellido_1;
	private String apellido_2;
	private String fecha_nac;
	private String contraseña;
	private String admin;
	
	public Usuario() {}
	
	public Usuario(String username, String email, String nombre, String apellido_1, String apellido_2, String fecha_nac,
			String contraseña, String admin) {
		
		this.username = username;
		this.email = email;
		this.nombre = nombre;
		this.apellido_1 = apellido_1;
		this.apellido_2 = apellido_2;
		this.fecha_nac = fecha_nac;
		this.contraseña = contraseña;
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_1() {
		return apellido_1;
	}

	public void setApellido_1(String apellido_1) {
		this.apellido_1 = apellido_1;
	}

	public String getApellido_2() {
		return apellido_2;
	}

	public void setApellido_2(String apellido_2) {
		this.apellido_2 = apellido_2;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getadmin() {
		return admin;
	}
	public void setadmin(String admin) {
		this.admin = admin;
	}
	
}
