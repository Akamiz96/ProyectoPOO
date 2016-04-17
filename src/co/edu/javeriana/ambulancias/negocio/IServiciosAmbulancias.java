/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo Ariza y Alejandro Castro Inferfaz de servicios para el sistema
 */
public interface IServiciosAmbulancias {
	/**
	 * Metodo para agregar IPS al sistema.
	 * 
	 * @param nombre:
	 *            Indica el nombre de la IPS a agregar
	 * @param tipoAtencion:
	 *            Indica el tipo de atencion mas determinante de la IPS a
	 *            agregar
	 * @param tipoDireccion:
	 *            Indica si la IPS se encuentra sobre la CALLE o la CARRERA
	 * @param calle:
	 *            Indica el numero de la calle de la IPS
	 * @param carrera:
	 *            Indica el numero de la carrera de la IPS
	 * @param numero:
	 *            Indica el numero sobre el cual esta ubicada la IPS
	 */
	void agregarIPS(String nombre, String tipoAtencion, String tipoDireccion, int calle, int carrera, int numero);

	/**
	 * Metodo para agregar Ambulancia al sistema.
	 * 
	 * @param tipoAmbulancia:
	 *            Indica el tipo de la ambulancia a agregar
	 * @param codigo:
	 *            Indica el codigo unico de identificacion de la ambulancia
	 * @param placa:
	 *            Indica la placa de la ambulancia a agregar
	 * @param medicoEnfermero:
	 *            Indica el nombre del medico o enfermero que va en la
	 *            ambulancia
	 * @param tipoUCI:
	 *            Indica el tipo UCI (Si lo tiene de la ambulancia a agregar
	 */
	void agregarAmbulancia(String tipoAmbulancia, int codigo, String placa, String medicoEnfermero, String tipoUCI);

	/**
	 * Metodo para registrar la posicion de una ambulancia existente dentro del
	 * sistema.
	 * 
	 * @param codigo:
	 *            Indica el codigo unico de la ambulancia dentro del sistema
	 * @param calle:
	 *            Indica la calle en la cual que se encuentra la ambulancia
	 * @param carrera:
	 *            Indica la carrera en la cual que se encuentra la ambulancia
	 * @return boolean: Indica si se pudo o no se pudo registrar la posicion de
	 *         la ambulancia
	 */
	boolean registrarPosicionAmbulancia(int codigo, int calle, int carrera);

	/**
	 * Metodo para registrar un servicio dentro del sistema.
	 * 
	 * @param nombre:
	 *            Indica el nombre de la persona que pide el servicio
	 * @param tipoAtencion:
	 *            Indica el tipo de atencion requerido
	 * @param telefono:
	 *            Indica el telefono del servicio
	 * @param tipoDireccion:
	 *            Indica Si el servicio se encuentra sobre la CALLE o la CARRERA
	 * @param calle:
	 *            Indica el numero de la calle donde se encuentra el servicio
	 * @param carrera:
	 *            Indica el numero de la carrera donde se encuentra el servicio
	 * @param numero:
	 *            Indica el numero de la cuadra donde se encuentra el servicio
	 * @return long: Indica el codigo del servicio recien ingresado
	 */
	long registrarServicio(String nombre, String tipoAtencion, String telefono, String tipoDireccion, int calle,
			int carrera, int numero);

	/**
	 * Metodo para asignar un servicio a una ambulancia y a una IPS. Excepto
	 * para los servicios de tipo DOMICILIO a los cuales se les asigna
	 * unicamente ambulancia
	 * 
	 * @param codigo:
	 *            Indica el codigo del servicio a asignar
	 * @return String: "Asignado" si fue una asignacion exitosa
	 * @return String: "No Existe el servicio" si NO fue una asignacion exitosa
	 */
	String asignarServicio(long codigo);

	/**
	 * Metodo para finalizar un servicio existente dentro del sistema
	 * 
	 * @param codigo:
	 *            Indica el codigo del servicio a finalizar
	 * @return boolean: Indica si se pudo o no se pudo finalizar el servicio
	 */
	boolean finalizarServicio(int codigo);

	/**
	 * Metodo para obtener la lista de servicios del sistema
	 * 
	 * @return List<Servicio>: Retorna la lista de servicios de la empresa
	 */
	List<Servicio> getServicios();

	/**
	 * Metodo para obtener el map de las ambulancias del sistema
	 * 
	 * @return Map<Integer, Ambulancia>: Retorna el map de las ambulancias de la
	 *         empresa
	 */
	Map<Integer, Ambulancia> getAmbulancias();

	/**
	 * Metodo para obtener el map de las IPS del sistema
	 * 
	 * @return Map<String, IPS>: Retorna el map de las IPS de la empresa
	 */
	Map<String, IPS> getLasIPS();
}
