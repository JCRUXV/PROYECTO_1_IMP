package clases;

public class proyecto 
{
	String nombre;
	String descripcion;
	String fechaInicio;
	String fechaFin;
	Participante ParticipanteJefe;
	
	
	
	public Participante getParticipanteJefe(){
		return ParticipanteJefe;
	}
	 
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public String getFechaFin() {
		return fechaFin;
	}



	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public void setParticipanteJefe(Participante ParticipanteJefe) {
		this.ParticipanteJefe  =  ParticipanteJefe;
	}



	public proyecto(String nombre, String descripcion, String fechaInicio, String fechaFin, Participante ParticipanteJefe) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.ParticipanteJefe = ParticipanteJefe;
	}




	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
