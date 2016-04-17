/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.Comparator;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class HoraSolicitudComparator implements Comparator<Servicio> {
	/**
	 * Metodo compare implementado entre Servicio comparando la horaSolicitud de
	 * cada uno
	 */
	public int compare(Servicio servicio1, Servicio servicio2) {
		return servicio1.getHoraSolicitud().compareTo(servicio2.getHoraSolicitud());
	}
}
