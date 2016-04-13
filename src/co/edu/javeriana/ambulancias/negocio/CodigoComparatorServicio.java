/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.Comparator;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class CodigoComparatorServicio implements Comparator<Servicio> {

	public int compare(Servicio servicio1, Servicio servicio2) {
		return (int) (servicio1.getCodigo() - servicio2.getCodigo());
	}
}
