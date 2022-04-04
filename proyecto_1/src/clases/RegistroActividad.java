package clases;

public class RegistroActividad 
{
	public int getId() {
		return Id;
	}





	public void setId(int id) {
		Id = id;
	}





	public String getTiempoC() {
		return tiempoC;
	}





	public void setTiempoC(String tiempoC) {
		this.tiempoC = tiempoC;
	}










	public RegistroActividad(int id, String titulo, String descripcion, String tipo, String fecha, String horaInicio,
			String horaFin, clases.Participante participante, String tiempoC) {
		super();
		Id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.fecha = fecha;
		HoraInicio = horaInicio;
		HoraFin = horaFin;
		Participante = participante;
		this.tiempoC = tiempoC;
	}










	int Id;
	String titulo;
	String descripcion;
	String tipo;
	String fecha;
	String HoraInicio;
	String HoraFin;
	Participante Participante;
	String tiempoC;
	
	public String getTitulo() {
		return titulo;
	}





	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}





	public String getDescripcion() {
		return descripcion;
	}





	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}





	public String getTipo() {
		return tipo;
	}





	public void setTipo(String tipo) {
		this.tipo = tipo;
	}





	public String getFecha() {
		return fecha;
	}





	public void setFecha(String fecha) {
		this.fecha = fecha;
	}





	public String getHoraInicio() {
		return HoraInicio;
	}





	public void setHoraInicio(String horaInicio) {
		HoraInicio = horaInicio;
	}





	public String getHoraFin() {
		return HoraFin;
	}





	public void setHoraFin(String horaFin) {
		HoraFin = horaFin;
	}





	public Participante getParticipante() {
		return Participante;
	}





	public void setParticipante(Participante participante) {
		Participante = participante;
	}

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
