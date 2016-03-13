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
	/**
	* Metodo Estatico para cargar las IPS a memoria a partir de un nombre de archivo de texto dado
	*/
	public static void cargarLasIPS(EmpresaAmbulancias empresaAmbulancia) {
		Scanner input = new Scanner(System.in);
		System.out.println("Ingrese el nombre del Archivo: ");
		String nombreArchivo = input.next();
		File inFile = new File("./" + nombreArchivo);
		String linea;
		try {
			input = new Scanner(inFile);
			linea = input.nextLine(); // #nombre--
										// tipoAtencion--tipoDireccion(CALLE o
										// CARRERA)---calle---carrera--numero
			while (!linea.equals("0")) {
				linea = input.nextLine().trim(); // vienen datos de una IPS
				if (!linea.equals("0"))
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
		}
	}
	/**
	* Metodo Privado Estatico para procesar una IPS e invocar metodo agregarIPS de la clase empresaAmbulancia
	* @see EmpresaAmbulancias#agregarIPS
	*/
	private static String procesarIPS(EmpresaAmbulancias empresaAmbulancia, Scanner input, String linea) {
		// TODO Auto-generated method stub
		StringTokenizer tokens = new StringTokenizer(linea, "*");
		empresaAmbulancia.agregarIPS(tokens.nextToken().trim(), tokens.nextToken().trim(), tokens.nextToken().trim(),
				Integer.parseInt(tokens.nextToken().trim()), Integer.parseInt(tokens.nextToken().trim()),
				Integer.parseInt(tokens.nextToken().trim()));
		return linea;
	}
	/**
	* Metodo Estatico para cargar las ambulancias a memoria a partir de un nombre de archivo de texto dado
	*/
	public static void cargarLasAmbulancias(EmpresaAmbulancias empresaAmbulancia) {
		Scanner input = new Scanner(System.in);
		System.out.println("Insgrese el nombre del Archivo: ");
		String nombreArchivo = input.next();
		File inFile = new File("./" + nombreArchivo);
		String linea;
		try {
			input = new Scanner(inFile);
			linea = input.nextLine(); // #nombre--
										// tipoAtencion--tipoDireccion(CALLE o
										// CARRERA)---calle---carrera--numero
			while (!linea.equals("0")) {
				linea = input.nextLine().trim(); // vienen datos de una IPS
				if (!linea.equals("0"))
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
		}
	}
	/**
 	* Metodo Privado Estatico para procesar una ambulancia e invocar metodo agregarIPS de la clase empresaAmbulancia
 	* @see EmpresaAmbulancias#agregarAmbulancia
 	*/
	private static String procesarAmbulancias(EmpresaAmbulancias empresaAmbulancia, Scanner input, String linea) {
		// TODO Auto-generated method stub
		StringTokenizer tokens = new StringTokenizer(linea, "*");
		empresaAmbulancia.agregarAmbulancia(Integer.parseInt(tokens.nextToken().trim()), tokens.nextToken().trim(),
				tokens.nextToken().trim());
		return linea;
	}
}
