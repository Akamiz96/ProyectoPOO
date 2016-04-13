/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.Comparator;

/**
 * @author Pablo Ariza y Alejandro Castro 
 *
 */
public class HoraSolicitudComparator implements Comparator<Servicio>{
	
	public int compare(Servicio servicio1, Servicio servicio2){
		return servicio1.getHoraSolicitud().compareTo(servicio2.getHoraSolicitud());
	}
}
