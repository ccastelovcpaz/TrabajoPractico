package TrabajoPracticoJava;

public class Pronostico {
	
	private Partido partido;
	private Equipo equipo;
//	private String pronostico;
	private ResultadoEquipoEnum pronostico;
	
	public Pronostico(Partido partido, Equipo equipo, ResultadoEquipoEnum pronostico) {
		this.partido = partido;
		this.equipo = equipo;
		this.pronostico = pronostico;
	}
	
	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public ResultadoEquipoEnum getPronostico() {
		return pronostico;
	}

	public void setPronostico(ResultadoEquipoEnum pronostico) {
		this.pronostico = pronostico;
	}
	
	@Override
	public String toString() {
		return "[partido=" + partido + ", equipo=" + equipo + ", pronostico=" + pronostico + "]";
	}

	public int getPuntos() {
		int puntos = 0;
		ResultadoEquipoEnum resultadoRealParaEquipo = partido.resultado(this.equipo.getIdEquipo());
		if (resultadoRealParaEquipo == this.pronostico) {
			puntos++;
		}
		return puntos;
	}
}
