/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.Comparator;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class CodigoComparator implements Comparator<Ambulancia>{

	public int compare(Ambulancia ambulancia1, Ambulancia ambulancia2){
		return ambulancia1.getCodigo()-ambulancia2.getCodigo();
	}
}
