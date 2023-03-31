package TrabajoPracticoJava;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		String rutaArchivoResultados="Resultados.txt";
		String rutaArchivoPronosticos="Pronosticos.txt";
		
		ArrayList<Partido> partidos = LectorArchivos.leerResultadosYCargarPartidosYEquipos(rutaArchivoResultados);
		ArrayList<Pronostico> pronosticos = LectorArchivos.leerYCargarPronosticos(rutaArchivoPronosticos,partidos);
		
		Listados.listarEquipos(partidos);
		Listados.listarPartidos(partidos);
		Listados.listarPronosticos(pronosticos);
		System.out.println("Total de puntos obtenidos: "+calcularPuntos(pronosticos));
	}

	public static int calcularPuntos(ArrayList<Pronostico> pronosticos) {
		int puntos = 0;
		for (int i=0; i<pronosticos.size();i++) {
			puntos+= pronosticos.get(i).getPuntos();
//			System.out.println(pronosticos.get(i).getPartido().getIdPartido()+": "+puntos);
		}
		return puntos;
	}

}

