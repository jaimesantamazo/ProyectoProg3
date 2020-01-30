package clasesbasicas;
public class Entradas extends Conciertos{
	private String codigo;
	private String nombre;
	private int precio;
	private String fecha_ini;
	private String fecha_fin;
	private int cantidad;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getFecha_ini() {
		return fecha_ini;
	}
	public void setFecha_ini(String fecha_ini) {
		this.fecha_ini = fecha_ini;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Entradas(String codigo, String nombre, int precio, String fecha_ini, String fecha_fin, int cantidad) {
		super(codigo,nombre,fecha_ini, fecha_fin);
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public Entradas() {}
}