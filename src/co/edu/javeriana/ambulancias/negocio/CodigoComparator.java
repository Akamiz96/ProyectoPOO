/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.Comparator;

/**
 * @author Usuario
 *
 */
public class CodigoComparator implements Comparator<Integer> {

	public int compare(Integer ambulancia1, Integer ambulancia2) {
		return ambulancia1 - ambulancia2;
	}
}
