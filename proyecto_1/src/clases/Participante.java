package clases;

public class Participante 
{
	String nombre;
	String correo;
	String contraseña;
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


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Participante(String nombre, String correo, String contraseña, String userName) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contraseña = contraseña;
		this.userName = userName;
	}



	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
