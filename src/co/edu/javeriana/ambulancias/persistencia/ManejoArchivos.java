/**
 *
 */
package co.edu.javeriana.ambulancias.persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import co.edu.javeriana.ambulancias.negocio.Ambulancia;
import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.negocio.IPS;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class ManejoArchivos {
	// Porque se retorna EmpresaAmbulancias?????
	public static void cargarLasIPS(EmpresaAmbulancias empresaAmbulancia) {
		Scanner input = new Scanner(System.in);
		String nombreArchivo = input.next();
		File inFile = new File("./" + nombreArchivo + ".txt");
		String linea;
		try {
			input = new Scanner(inFile);
			linea = input.nextLine(); // #nombre--
										// tipoAtencion--tipoDireccion(CALLE o
										// CARRERA)---calle---carrera--numero
			while (!linea.equals("0")) {
				linea = input.nextLine().trim(); // vienen datos de una IPS
				linea = procesarIPS(empresaAmbulancia, input, linea);
			} // fin de todas las IPS
		} catch (FileNotFoundException e) {
			System.out.println("Error en la ruta del archivo.\n Error: e.message()");
		} catch (IOException e) {
			System.out.println("Error leyendo del archivo.\n Error: e.message()");
		} catch (Exception e) {
			System.out.println("excepcion inesperada:" + e.getMessage());
		} finally {
			input.close();
			((ArrayList<IPS>) empresaAmbulancia.getLasIPS()).trimToSize();// recorta
																			// la
																			// capacidad
																			// del
																			// objeto
																			// List
																			// al
																			// numero
																			// actual
																			// de
																			// elementos
		}
	}

	private static String procesarIPS(EmpresaAmbulancias empresaAmbulancia, Scanner input, String linea) {
		// TODO Auto-generated method stub
		StringTokenizer tokens = new StringTokenizer(linea, "*");
		empresaAmbulancia.agregarIPS(tokens.nextToken().trim(), tokens.nextToken().trim(), tokens.nextToken().trim(),
				Integer.parseInt(tokens.nextToken().trim()), Integer.parseInt(tokens.nextToken().trim()),
				Integer.parseInt(tokens.nextToken().trim()));
		linea = input.nextLine();
		return linea;
	}

	public static void cargarLasAmbulancias(EmpresaAmbulancias empresaAmbulancia) {
		Scanner input = new Scanner(System.in);
		String nombreArchivo = input.next();
		File inFile = new File("./" + nombreArchivo + ".txt");
		String linea;
		try {
			input = new Scanner(inFile);
			linea = input.nextLine(); // #nombre--
										// tipoAtencion--tipoDireccion(CALLE o
										// CARRERA)---calle---carrera--numero
			while (!linea.equals("0")) {
				linea = input.nextLine().trim(); // vienen datos de una IPS
				linea = procesarAmbulancias(empresaAmbulancia, input, linea);
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
			((ArrayList<Ambulancia>) empresaAmbulancia.getAmbulancias()).trimToSize();// recorta
																						// la
																						// capacidad
																						// del
																						// objeto
																						// List
																						// al
																						// numero
																						// actual
																						// de
																						// elementos
		}
	}

	private static String procesarAmbulancias(EmpresaAmbulancias empresaAmbulancia, Scanner input, String linea) {
		// TODO Auto-generated method stub
		StringTokenizer tokens = new StringTokenizer(linea, "*");
		empresaAmbulancia.agregarAmbulancia(Integer.parseInt(tokens.nextToken().trim()), tokens.nextToken().trim(),
				tokens.nextToken().trim());
		linea = input.nextLine();
		return linea;
	}
}
