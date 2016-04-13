/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo
 *
 */
public interface IServiciosAmbulancias {
	void agregarIPS(String nombre, String tipoAtencion, String tipoDireccion, int calle, int carrera, int numero);

	void agregarAmbulancia(String tipoAmbulancia, int codigo, String placa, String medicoEnfermero, String tipoUCI);

	boolean registrarPosicionAmbulancia(int codigo, int calle, int carrera);

	long registrarServicio(String nombre, String tipoAtencion, String telefono, String tipoDireccion, int calle,
			int carrera, int numero);

	String asignarServicio(long codigo);

	boolean finalizarServicio(int codigo);

	List<Servicio> getServicios();

	Map<Integer, Ambulancia> getAmbulancias();
}
