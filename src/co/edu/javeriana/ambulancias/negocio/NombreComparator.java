/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.Comparator;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class NombreComparator implements Comparator<String> {

	public int compare(String nombre1, String nombre2) {
		return nombre1.compareTo(nombre2);
	}
}
