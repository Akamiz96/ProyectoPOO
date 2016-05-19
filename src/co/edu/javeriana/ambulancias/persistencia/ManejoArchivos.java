/**
 *
 */
package co.edu.javeriana.ambulancias.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.negocio.IServiciosAmbulancias;

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
	 * @throws PersistenceException
	 */
	public static void cargarLasIPS(IServiciosAmbulancias empresaAmbulancias, String pathArchivo, String nombreArchivo)
			throws PersistenceException {
		Scanner input = new Scanner(System.in);
		File inFile = new File(pathArchivo + "/" + nombreArchivo);
		String linea;
		try {
			input = new Scanner(inFile);
			linea = input.nextLine(); // #nombre--
										// tipoAtencion--tipoDireccion(CALLE o
										// CARRERA)---calle---carrera--numero
			while (!linea.equals("0")) {
				linea = input.nextLine().trim(); // vienen datos de una IPS
				if (!linea.equals("0"))
					linea = procesarIPS(empresaAmbulancias, input, linea);
			} // fin de todas las IPS
			input.close();
		} catch (FileNotFoundException e) {
			throw new PersistenceException("Error en la ruta del archivo.\n Error: " + e.getMessage());
		} catch (IOException e) {
			throw new PersistenceException("Error leyendo del archivo.\n Error: " + e.getMessage());
		} catch (Exception e) {
			throw new PersistenceException("Excepcion inesperada:" + e.getMessage());
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
	 * @throws PersistenceException 
	 * @see EmpresaAmbulancias#agregarIPS
	 */
	private static String procesarIPS(IServiciosAmbulancias empresaAmbulancias, Scanner input, String linea) throws PersistenceException {
		StringTokenizer tokens = new StringTokenizer(linea, "*");
		String nombre = tokens.nextToken().trim();
		String tipoAtencion = tokens.nextToken().trim();
		String tipoDireccion = tokens.nextToken().trim();
		int calle = Integer.parseInt(tokens.nextToken().trim());
		int carrera = Integer.parseInt(tokens.nextToken().trim());
		int numero = Integer.parseInt(tokens.nextToken().trim());
		empresaAmbulancias.agregarIPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero);
		return linea;
	}

	/**
	 * Metodo Estatico para cargar las ambulancias a memoria a partir de un
	 * nombre de archivo de texto dado
	 * 
	 * @param empresaAmbulancia:
	 *            Indica el objeto de empresa ambulancia para el cual se le
	 *            adicionara las IPS
	 * @throws PersistenceException
	 */
	public static void cargarLasAmbulancias(IServiciosAmbulancias empresaAmbulancias, String pathArchivo,
			String nombreArchivo) throws PersistenceException {
		Scanner input = new Scanner(System.in);
		File inFile = new File(pathArchivo + "/" + nombreArchivo);
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
					linea = procesarAmbulancias(empresaAmbulancias, input, linea);
			}
			input.close();
		} // fin de todas las IPS
		catch (FileNotFoundException e) {
			throw new PersistenceException("Error en la ruta del archivo.\n Error: " + e.getMessage());
		} catch (IOException e) {
			throw new PersistenceException("Error leyendo del archivo.\n Error:" + e.getMessage());
		} catch (Exception e) {
			throw new PersistenceException("excepcion inesperada:" + e.getMessage());
		}
	}

	/**
	 * Metodo Privado Estatico para procesar una ambulancia e invocar metodo
	 * agregarIPS de la clase empresaAmbulancia
	 * @throws PersistenceException 
	 * 
	 * @see EmpresaAmbulancias#agregarAmbulancia
	 */
	private static String procesarAmbulancias(IServiciosAmbulancias empresaAmbulancias, Scanner input, String linea) throws PersistenceException {
		StringTokenizer tokens = new StringTokenizer(linea, "*");
		String tipoAmbulancia = tokens.nextToken().trim();
		int codigo = Integer.parseInt(tokens.nextToken().trim());
		String placa = tokens.nextToken().trim();
		String medicoEnfermero = tokens.nextToken().trim();
		String tipoUCI = null;
		if (tipoAmbulancia.equals("UCI")) {
			tipoUCI = tokens.nextToken().trim();
		}
		empresaAmbulancias.agregarAmbulancia(tipoAmbulancia, codigo, placa, medicoEnfermero, tipoUCI);
		return linea;
	}

	public static void guardarDatos(IServiciosAmbulancias empresaAmbulancias, String pathArchivo, String nombreArchivo)
			throws PersistenceException {
		File outFile = new File(pathArchivo + "/" + nombreArchivo);
		FileOutputStream outStream = null;
		ObjectOutputStream dataOutStream = null;
		try {
			outStream = new FileOutputStream(outFile);
			dataOutStream = new ObjectOutputStream(outStream);
			dataOutStream.writeObject(empresaAmbulancias);
			dataOutStream.close();
			outStream.close();
		} catch (FileNotFoundException e) {
			throw new PersistenceException("Error en la ruta del archivo.\n Error: " + e.getMessage());
		} catch (IOException e) {
			throw new PersistenceException("Error leyendo del archivo.\n Error: " + e.getMessage());
		} catch (Exception e) {
			throw new PersistenceException("Excepcion inesperada:" + e.getMessage());
		}
	}

	public static IServiciosAmbulancias cargarDatos(String pathArchivo, String nombreArchivo) throws PersistenceException {
		File inFile = new File(pathArchivo + "/" + nombreArchivo);
		FileInputStream inStream = null;
		ObjectInputStream dataInStream = null;
		IServiciosAmbulancias empresaAmbulancia = null;
		try {
			inStream = new FileInputStream(inFile);
			dataInStream = new ObjectInputStream(inStream);
			empresaAmbulancia = (IServiciosAmbulancias) dataInStream.readObject();
			dataInStream.close();
			inStream.close();
		} catch (FileNotFoundException e) {
			throw new PersistenceException("El archivo no existe " + e.getMessage());
		} catch (Exception e) {
			throw new PersistenceException("Ocurrio un error leyendo el archivo " + e.getMessage());
		}
		return empresaAmbulancia;
	}
}
