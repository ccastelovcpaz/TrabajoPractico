package TrabajoPracticoJava;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class puntosTest {

	@Test
	void test() {
		String rutaArchivoResultados="Resultados.txt";
		String rutaArchivoPronosticos="Pronosticos.txt";
		ArrayList<Partido> partidos = LectorArchivos.leerResultadosYCargarPartidosYEquipos(rutaArchivoResultados);
		ArrayList<Pronostico> pronosticos = LectorArchivos.leerYCargarPronosticos(rutaArchivoPronosticos,partidos);
		assertEquals(1,Principal.calcularPuntos(pronosticos));
	}

}
