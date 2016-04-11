/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.Comparator;

/**
 * @author Alejandro Castro Martinez
 * 
 */
public class PosicionCallePosicionCarreraComparator implements Comparator<Ambulancia> {
	public int compare(Ambulancia ambulancia1, Ambulancia ambulancia2) {
		if (ambulancia1.getPosicionCalle() > ambulancia2.getPosicionCalle()) {
			return 1;
		}
		if (ambulancia1.getPosicionCalle() < ambulancia2.getPosicionCalle()) {
			return -1;
		}
		if (ambulancia1.getPosicionCalle() == ambulancia2.getPosicionCalle()
				&& ambulancia1.getPosicionCarrera() > ambulancia2.getPosicionCarrera()) {
			return 1;
		}
		if (ambulancia1.getPosicionCalle() == ambulancia2.getPosicionCalle()
				&& ambulancia1.getPosicionCarrera() < ambulancia2.getPosicionCarrera()) {
			return -1;
		}
		return 0;
	}
}
