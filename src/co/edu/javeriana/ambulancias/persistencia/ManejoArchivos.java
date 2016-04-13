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
	 * Metodo Estatico para cargar las IPS a memoria a partir de un nombre de
	 * archivo de texto dado
	 * 
	 * @param empresaAmbulancia:
	 *            Indica el objeto de empresa ambulancia para el cual se le
	 *            adicionara las IPS
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
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error en la ruta del archivo.\n Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error leyendo del archivo.\n Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("excepcion inesperada:" + e.getMessage());
		}
	}

	/**
	 * Metodo Privado Estatico para procesar una IPS e invocar metodo agregarIPS
	 * de la clase empresaAmbulancia
	 * 
	 * @param input:
	 *            Indica el Scanner a ser usado dentro de la clase
	 * @param linea:
	 *            Indica la linea de texto que es una IPS a ser procesada
	 * @param empresaAmbulancia:
	 *            Indica la empresa de ambulancias a agregar la IPS luego de su
	 *            procesamiento
	 * @return String: Retorna el resto de la linea luego de ser procesada
	 * @see EmpresaAmbulancias#agregarIPS
	 */
	private static String procesarIPS(EmpresaAmbulancias empresaAmbulancia, Scanner input, String linea) {
		// TODO Auto-generated method stub
		StringTokenizer tokens = new StringTokenizer(linea, "*");
		String nombre = tokens.nextToken().trim();
		String tipoAtencion = tokens.nextToken().trim();
		String tipoDireccion = tokens.nextToken().trim();
		int calle = Integer.parseInt(tokens.nextToken().trim());
		int carrera = Integer.parseInt(tokens.nextToken().trim());
		int numero = Integer.parseInt(tokens.nextToken().trim());
		empresaAmbulancia.agregarIPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero);
		return linea;
	}

	/**
	 * Metodo Estatico para cargar las ambulancias a memoria a partir de un
	 * nombre de archivo de texto dado
	 * 
	 * @param empresaAmbulancia:
	 *            Indica el objeto de empresa ambulancia para el cual se le
	 *            adicionara las IPS
	 */
	public static void cargarLasAmbulancias(EmpresaAmbulancias empresaAmbulancia) {
		Scanner input = new Scanner(System.in);
		System.out.println("Insgrese el nombre del Archivo: ");
		String nombreArchivo = input.next();
		File inFile = new File("./" + nombreArchivo);
		String linea;
		try {
			input = new Scanner(inFile);
			linea = input.nextLine();// #valores de tipoAmbulancia:
										// BASICA,UCI,NOMEDICALIZADA
			linea = input.nextLine();// #valores de tipoUCI: CARDIOVASCULAR o
										// PEDIATRICA
			linea = input.nextLine(); // #nombre--
										// tipoAtencion--tipoDireccion(CALLE o
										// CARRERA)---calle---carrera--numero
			while (!linea.equals("0")) {
				linea = input.nextLine().trim(); // vienen datos de una IPS
				if (!linea.equals("0"))
					linea = procesarAmbulancias(empresaAmbulancia, input, linea);
			}
			input.close();
		} // fin de todas las IPS
		catch (FileNotFoundException e) {
			System.out.println("Error en la ruta del archivo.\n Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error leyendo del archivo.\n Error:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("excepcion inesperada:" + e.getMessage());
		}
	}

	/**
	 * Metodo Privado Estatico para procesar una ambulancia e invocar metodo
	 * agregarIPS de la clase empresaAmbulancia
	 * 
	 * @see EmpresaAmbulancias#agregarAmbulancia
	 */
	private static String procesarAmbulancias(EmpresaAmbulancias empresaAmbulancia, Scanner input, String linea) {
		// TODO Auto-generated method stub
		StringTokenizer tokens = new StringTokenizer(linea, "*");
		String tipoAmbulancia = tokens.nextToken().trim();
		int codigo = Integer.parseInt(tokens.nextToken().trim());
		String placa = tokens.nextToken().trim();
		String medicoEnfermero = tokens.nextToken().trim();
		String tipoUCI = null;
		if (tipoAmbulancia.equals("UCI")) {
			tipoUCI = tokens.nextToken().trim();
		}
		empresaAmbulancia.agregarAmbulancia(tipoAmbulancia, codigo, placa, medicoEnfermero, tipoUCI);
		return linea;
	}
}
