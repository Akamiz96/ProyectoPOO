/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.GregorianCalendar;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 *
 */
public class Ambulancia {
	/**
	*@attribute codigo: Representa el c�digo �nico dado a la ambulancia dentro del sistema
	*/
	private static int codigo;
	/**
	*@attribute placa: Representa la placa de la ambulancia (Identificaci�n de la ambulancia hacia entidades gubernamentales)
	*/
	private String placa;
	/**
	*@attribute tipoDotacion: Representa la dotaci�n llevada dentro de la ambulancia para atender servicios (MEDICALIZADA/ALTA_UCI)
	*/
	private String tipoDotacion;
	/**
	*@attribute horaPosicion: Representa la �ltima vez que dicha Ambulancia registr� su posici�n
	*/
	private GregorianCalendar horaPosicion;
	/**
	*@attribute posicionCalle: Representa la calle en la cual se encuentra la Ambulancia la �ltima vez que registr� su posici�n
	*/
	private int posicionCalle;
	/**
	*@attribute posicionCarrera: Representa la carrera en la cual se encuentra la Ambulancia la �ltima vez que registr� su posici�n
	*/
	private int posicionCarrera;
}
