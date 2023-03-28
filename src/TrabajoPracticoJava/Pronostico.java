package TrabajoPracticoJava;

public class Pronostico {
	
	private Partido partido;
	private Equipo equipo;
	private String pronostico;
	
	public Pronostico(Partido partido, Equipo equipo, String pronostico) {
		this.partido = partido;
		this.equipo = equipo;
		this.pronostico = pronostico;
	}
	
//	public Pronostico(String[] lineaCSV) {
//		this.partido=Integer.parseInt(lineaCSV[0]);
//		
//	}

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

	public String getPronostico() {
		return pronostico;
	}

	public void setPronostico(String pronostico) {
		this.pronostico = pronostico;
	}
	
	public int getPuntos() {
		int puntos = 0;
		String resultadoRealParaEquipo = partido.resultado(this.equipo.getIdEquipo());
		if (resultadoRealParaEquipo == this.pronostico) {
			puntos++;
		}
		return puntos;
	}
}
