package clases;

public class Participante 
{
	String nombre;
	String correo;
	String contrase�a;
	String userName ;

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Participante(String nombre, String correo, String contrase�a, String userName) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrase�a = contrase�a;
		this.userName = userName;
	}



	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
