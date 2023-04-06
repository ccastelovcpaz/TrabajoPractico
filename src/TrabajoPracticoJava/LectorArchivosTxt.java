package TrabajoPracticoJava;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LectorArchivosTxt {

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
					ResultadoEquipoEnum pronostico = getPronostico(lineaCSV[2],lineaCSV[3],lineaCSV[4]);
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

	private static ResultadoEquipoEnum  getPronostico(String gana, String empata, String pierde) {
		if (gana.toUpperCase().equals("X")) {
			return ResultadoEquipoEnum.GANA;
		}
		if (empata.toUpperCase().equals("X")) {
			return ResultadoEquipoEnum.EMPATA;
		}
		if (pierde.toUpperCase().equals("X")) {
			return ResultadoEquipoEnum.PIERDE;
		}
		return null;
	}

}
