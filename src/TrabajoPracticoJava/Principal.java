package TrabajoPracticoJava;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		String rutaArchivoResultados="Resultados.txt";
		String rutaArchivoPronosticos="Pronosticos.txt";
		
		ArrayList<Partido> partidos = leerResultadosYCargarPartidosYEquipos(rutaArchivoResultados);
		ArrayList<Pronostico> pronosticos = leerYCargarPronosticos(rutaArchivoPronosticos,partidos);
		
		listarEquipos(partidos);
		listarPartidos(partidos);
		listarPronosticos(pronosticos);
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

	private static void listarPronosticos(ArrayList<Pronostico> pronosticos) {
		System.out.println("- Pronósticos:");
		for (int i=0; i<pronosticos.size();i++) {
			System.out.println("        - Pronóstico"+(i+1)+":");
			System.out.println("                - id: ");
			System.out.println("                - Partido: "+pronosticos.get(i).getPartido().getIdPartido()+" ("
															+pronosticos.get(i).getPartido().getEquipo1().getNombreEquipo()+" - "
															+pronosticos.get(i).getPartido().getEquipo2().getNombreEquipo()+")");
			System.out.println("                - Equipo: "+pronosticos.get(i).getEquipo().getNombreEquipo());
			System.out.println("                - Resultado: "+pronosticos.get(i).getPronostico());
			System.out.println("\n");
		}
	}

	private static void listarPartidos(ArrayList<Partido> partidos) {
		System.out.println("- Partidos:");
		for (int i=0; i<partidos.size();i++) {
			System.out.println("        - Partido"+(i+1)+":");
			System.out.println("                - id: "+partidos.get(i).getIdPartido());
			System.out.println("                - Equipo1: "+partidos.get(i).getEquipo1().getNombreEquipo()+"(id:"+partidos.get(i).getEquipo1().getIdEquipo()+")");
			System.out.println("                - Equipo2: "+partidos.get(i).getEquipo2().getNombreEquipo()+"(id:"+partidos.get(i).getEquipo2().getIdEquipo()+")");
			System.out.println("                - Goles equipo 1: "+partidos.get(i).getGolesEquipo1());
			System.out.println("                - Goles equipo 2: "+partidos.get(i).getGolesEquipo2());
			System.out.println("\n");
		}
	}

	private static void listarEquipos(ArrayList<Partido> partidos) {
		System.out.println("- Equipos:");
		int contadorEquipos = 1;
		for (int i=0; i<partidos.size();i++) {
			System.out.println("        - Equipo"+(contadorEquipos)+":");
			System.out.println("                - id: "+partidos.get(i).getEquipo1().getIdEquipo());
			System.out.println("                - Nombre: "+partidos.get(i).getEquipo1().getNombreEquipo());
			System.out.println("                - Descripción: "+partidos.get(i).getEquipo1().getDescripcionEquipo());
			System.out.println("        - Equipo"+(contadorEquipos+1)+":");
			System.out.println("                - id: "+partidos.get(i).getEquipo2().getIdEquipo());
			System.out.println("                - Nombre: "+partidos.get(i).getEquipo2().getNombreEquipo());
			System.out.println("                - Descripción: "+partidos.get(i).getEquipo2().getDescripcionEquipo());
			contadorEquipos+=2;
		}
		System.out.println("\n");
	}

	public static ArrayList<Partido> leerResultadosYCargarPartidosYEquipos(String rutaArchivo) {
		ArrayList<Partido> partidos = new ArrayList<Partido>();
		
		try {
			boolean procesarLinea = false; // este es para saltar la primer linea con encabezado
			for (String linea : Files.readAllLines(Paths.get(rutaArchivo))) {
				if (procesarLinea) {
					partidos.add(new Partido(linea.split(";")));  
//					for (int j=0;j<lineaCSV.length;j++) {
//						System.out.print(lineaCSV[j]+"-");
//					}
//					System.out.print("\n");
				} else {
					procesarLinea=true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return partidos;
	}

	public static ArrayList<Pronostico> leerYCargarPronosticos(String rutaArchivo, ArrayList<Partido> partidos) {
		String[] lineaCSV;
		ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();
		
		try {
			boolean procesarLinea = false; // este es para saltar la primer linea con encabezado
			for (String linea : Files.readAllLines(Paths.get(rutaArchivo))) {
				lineaCSV = linea.split(";");
				if (procesarLinea) {
					Partido partido = getPartidoPorId(partidos, Integer.parseInt(lineaCSV[0]));
					Equipo equipo = getEquipoPorId(partidos, Integer.parseInt(lineaCSV[1]));
					String pronostico = getPronostico(lineaCSV[2],lineaCSV[3],lineaCSV[4]);
					pronosticos.add(new Pronostico(partido, equipo, pronostico));  
//					for (int j=0;j<lineaCSV.length;j++) {
//						System.out.print(lineaCSV[j]+"-");
//					}
//					System.out.print("\n");
				} else {
					procesarLinea=true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return pronosticos;
	}

	private static Partido getPartidoPorId(ArrayList<Partido> partidos, int idPartido) {

		for (Partido p : partidos) {
			if (p.getIdPartido()==idPartido) {
				return p;
			}
		}
		return null;
	}

	private static Equipo getEquipoPorId(ArrayList<Partido> partidos, int idEquipo) {

		
		for (Partido p : partidos) {
			if (p.getEquipo1().getIdEquipo()==idEquipo) {
				return p.getEquipo1();
			}
			if (p.getEquipo2().getIdEquipo()==idEquipo) {
				return p.getEquipo2();
			}
		}
		return null;
	}

	private static String getPronostico(String gana, String empata, String pierde) {
		if (gana.toUpperCase().equals("X")) {
			return "GANA";
		}
		if (empata.toUpperCase().equals("X")) {
			return "EMPATA";
		}
		if (pierde.toUpperCase().equals("X")) {
			return "PIERDE";
		}
		return "";
	}

}

