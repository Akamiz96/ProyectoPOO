/**
 * 
 */
package co.edu.javeriana.ambulancias.presentacion;

import java.util.Comparator;

import co.edu.javeriana.ambulancias.negocio.Ambulancia;

/**
 * @author Pablo
 *
 */
public class codigoComparator implements Comparator<Ambulancia>{

	public int compare(Ambulancia a1, Ambulancia a2){
		return a1.getCodigo()-a2.getCodigo();
	}
}
