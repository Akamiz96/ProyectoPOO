/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class IPS implements Serializable {
	/**
	 * nombre: Representa el nombre de la IPS
	 */
	private String nombre;
	/**
	 * tipoAtencion: Texto que representa el tipo de atencion especializado de
	 * la entidad
	 */
	private String tipoAtencion;
	/**
	 * direccion: Instancia de la clase Direccion que indica la direccion de la
	 * IPS
	 */
	private Direccion direccion;
	/**
	 * servicios: Indica la lista de servicios asociados a una IPS
	 */
	private List<Servicio> servicios;

	/**
	 * @param nombre:Indica
	 *            el nombre IPS
	 * @param tipoAtencion:
	 *            Indica la especialidad del centro de salud
	 * @param tipoDireccion:
	 *            Indica si se encuentra sobre la carrera o sobre la calle
	 * @param calle:
	 *            Indica la calle en la cual se encuentra
	 * @param carrera:
	 *            Indica la carrera en la cual se encuentra
	 * @param numero:
	 *            Indica el bloque en la cuadra donde se encuentra
	 */
	public IPS(String nombre, String tipoAtencion, String tipoDireccion, int calle, int carrera, int numero) {
		this.nombre = nombre;
		this.tipoAtencion = tipoAtencion;
		asignarDireccion(tipoDireccion, calle, carrera, numero);
		this.servicios = new ArrayList<Servicio>();
	}

	/**
	 * @return the nombre: Representa el nombre de la IPS
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set: Representa el nombre de la IPS
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the tipoAtencion: Texto que representa el tipo de atencion
	 *         especializado de la entidad
	 */
	public String getTipoAtencion() {
		return tipoAtencion;
	}

	/**
	 * @param tipoAtencion
	 *            the tipoAtencion to set: Texto que representa el tipo de
	 *            atencion especializado de la entidad
	 */
	public void setTipoAtencion(String tipoAtencion) {
		this.tipoAtencion = tipoAtencion;
	}

	/**
	 * @return the direccion: Instancia de la clase Direccion que indica la
	 *         direccion de la IPS
	 * @see Direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set: Instancia de la clase Direccion que
	 *            indica la direccion de la IPS
	 * @see Direccion
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the servicios: Indica la lista de servicios asociados a una IPS
	 * @see Servicio
	 */
	public List<Servicio> getServicios() {
		return servicios;
	}

	/**
	 * @param servicios
	 *            the servicios to set: Indica la lista de servicios asociados a
	 *            una IPS
	 * @see Servicio
	 */
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	/**
	 * ToString para reporte de IPS nombre-tipoAtencion-direccion
	 * 
	 * @see Servicio#toString()
	 * @return String con el formato anteriormente mencionado
	 */
	@Override
	public String toString() {
		return String.format("%-22s %-22s %-22s", nombre, tipoAtencion, direccion);
	}

	/**
	 * Metodo para asignar la direccion a una IPS
	 * 
	 * @param tipoDireccion:
	 *            Indica si la direccion es CARRERA/CALLE
	 * @param calle:
	 *            Indica el numero de calle de la direccion
	 * @param carrera:
	 *            Indica el numero de carrera de la direccion
	 * @param numero:
	 *            Indica el bloque de la cuadra en donde es la direccion
	 */
	public void asignarDireccion(String tipoDireccion, int calle, int carrera, int numero) {
		this.direccion = new Direccion(tipoDireccion, calle, carrera, numero);
	}

	/**
	 * Metodo para agregar un servicio dado a la lista de servicios de una IPS
	 * 
	 * @param servicio:
	 *            Indica el servicio a agregar en la lista de IPS
	 */
	public void agregarServicioIPS(Servicio servicio) {
		this.servicios.add(servicio);
	}

}
