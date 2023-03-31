package TrabajoPracticoJava;

import java.util.ArrayList;

public class Listados {

	public static void listarPronosticos(ArrayList<Pronostico> pronosticos) {
		System.out.println("- Pronósticos:");
		for (int i=0; i<pronosticos.size();i++) {
			System.out.println("        - Pronóstico"+(i+1)+":");
			System.out.println("                - id: ");
			System.out.println("                - Partido: "+pronosticos.get(i).getPartido().getIdPartido()+" ("
															+pronosticos.get(i).getPartido().getEquipo1().getNombreEquipo()+" - "
															+pronosticos.get(i).getPartido().getEquipo2().getNombreEquipo()+")");
			System.out.println("                - Equipo: "+pronosticos.get(i).getEquipo().getNombreEquipo());
			System.out.println("                - Resultado: "+pronosticos.get(i).getPronostico());
			System.out.print("\n");
//			System.out.println("Pronóstico"+(i+1)+": "+pronosticos.get(i).toString());
		}
//		System.out.print("\n");
	}

	public static void listarPartidos(ArrayList<Partido> partidos) {
		System.out.println("- Partidos:");
		for (int i=0; i<partidos.size();i++) {
			System.out.println("        - Partido"+(i+1)+":");
			System.out.println("                - id: "+partidos.get(i).getIdPartido());
			System.out.println("                - Equipo1: "+partidos.get(i).getEquipo1().getNombreEquipo()+"(id:"+partidos.get(i).getEquipo1().getIdEquipo()+")");
			System.out.println("                - Equipo2: "+partidos.get(i).getEquipo2().getNombreEquipo()+"(id:"+partidos.get(i).getEquipo2().getIdEquipo()+")");
			System.out.println("                - Goles equipo 1: "+partidos.get(i).getGolesEquipo1());
			System.out.println("                - Goles equipo 2: "+partidos.get(i).getGolesEquipo2());
			System.out.print("\n");
//			System.out.println("Partido"+(i+1)+": "+partidos.get(i).toString());
		}
//		System.out.print("\n");
	}

	public static void listarEquipos(ArrayList<Partido> partidos) {
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
//			System.out.println("Equipo"+contadorEquipos+": "+partidos.get(i).getEquipo1().toString());
//			System.out.println("Equipo"+(contadorEquipos+1)+": "+partidos.get(i).getEquipo2().toString());
			contadorEquipos+=2;
		}
		System.out.print("\n");
	}

}
