/**
 *
 */
package co.edu.javeriana.ambulancias.persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class ManejoArchivos {
	// Porque se retorna EmpresaAmbulancias?????
	public static EmpresaAmbulancias cargarLasIPS(EmpresaAmbulancias empresaAmbulancia) {
		Scanner input = new Scanner(System.in);
		String nombreArchivo = input.next();
		File inFile = new File("./" + nombreArchivo + ".txt");
		String linea;
		try {
			input = new Scanner(inFile);
			int numIPS = tamArreglo(inFile);
			empresaAmbulancia.arregloIPS(numIPS);
			linea = input.nextLine(); // #nombre--
										// tipoAtencion--tipoDireccion(CALLE o
										// CARRERA)---calle---carrera--numero
			int indice = 0;
			while (!linea.equals("0")) {
				linea = input.nextLine().trim(); // vienen datos de una IPS
				linea = procesarIPS(empresaAmbulancia, input, linea, indice);
				indice++;
			} // fin de todas las IPS
		} catch (FileNotFoundException e) {
			System.out.println("Error en la ruta del archivo.\n Error: e.message()");
		} catch (IOException e) {
			System.out.println("Error leyendo del archivo.\n Error: e.message()");
		} catch (Exception e) {
			System.out.println("excepcion inesperada:" + e.getMessage());
		} finally {
			input.close();
			return empresaAmbulancia;
		}
	}

	/**
	 * @param inFile
	 * @throws FileNotFoundException
	 */
	private static int tamArreglo(File inFile) throws FileNotFoundException {
		Scanner indice = new Scanner(inFile);
		int numIPS = 0;
		String linea1 = indice.nextLine();
		while (!linea1.equals("0")) {
			linea1 = indice.nextLine();
			numIPS++;
		}
		numIPS--;
		return numIPS;
	}

	private static String procesarIPS(EmpresaAmbulancias empresaAmbulancia, Scanner input, String linea, int indice) {
		// TODO Auto-generated method stub
		StringTokenizer tokens = new StringTokenizer(linea, "*");
		empresaAmbulancia.agregarIPS(tokens.nextToken().trim(), tokens.nextToken().trim(), tokens.nextToken().trim(),
				Integer.parseInt(tokens.nextToken().trim()), Integer.parseInt(tokens.nextToken().trim()),
				Integer.parseInt(tokens.nextToken().trim()), indice);
		linea = input.nextLine();
		return linea;
	}

	public static EmpresaAmbulancias cargarLasAmbulancias(EmpresaAmbulancias empresaAmbulancia) {
		Scanner input = new Scanner(System.in);
		String nombreArchivo = input.next();
		File inFile = new File("./" + nombreArchivo + ".txt");
		String linea;
		try {
			input = new Scanner(inFile);
			int numAmbulancia = tamArreglo(inFile);
			empresaAmbulancia.arregloAmbulancia(numAmbulancia);
			linea = input.nextLine(); // #nombre--
										// tipoAtencion--tipoDireccion(CALLE o
										// CARRERA)---calle---carrera--numero
			int indice = 0;
			while (!linea.equals("0")) {
				linea = input.nextLine().trim(); // vienen datos de una IPS
				linea = procesarAmbulancias(empresaAmbulancia, input, linea, indice);
				indice++;
			}
		} // fin de todas las IPS
		catch (FileNotFoundException e) {
			System.out.println("Error en la ruta del archivo.\n Error: e.message()");
		} catch (IOException e) {
			System.out.println("Error leyendo del archivo.\n Error: e.message()");
		} catch (Exception e) {
			System.out.println("excepcion inesperada:" + e.getMessage());
		} finally {
			input.close();
			return empresaAmbulancia;
		}
	}

	private static String procesarAmbulancias(EmpresaAmbulancias empresaAmbulancia, Scanner input, String linea,
			int indice) {
		// TODO Auto-generated method stub
		StringTokenizer tokens = new StringTokenizer(linea, "*");
		empresaAmbulancia.agregarAmbulancia(Integer.parseInt(tokens.nextToken().trim()), tokens.nextToken().trim(),
				tokens.nextToken().trim(), indice);
		linea = input.nextLine();
		return linea;
	}
}
