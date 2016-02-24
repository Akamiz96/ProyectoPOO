/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class IPS implements Serializable{
	/**
	*@attribute nombre: Representa el nombre de la IPS
	*/
	private String nombre;
	/**
	*@attribute tipoAtencion: Texto que representa el tipo de atenci�n especializado de la entidad
	*/
	private String tipoAtencion;
	/**
	*@attribute direccion: Instancia de la clase Direccion que indica la direccion de la IPS
	*/
	private Direccion direccion;
	private Servicio servicios;
	/**
	*@param nombre indica el nombre IPS
	*@param tipoAtencion
	*@param tipoDireccion
	*@param calle
	*@param carrera
	*@param numero
	*/
	public IPS(String nombre, String tipoAtencion, String tipoDireccion, int calle, int carrera, int numero) {
		this.nombre = nombre;
		this.tipoAtencion = tipoAtencion;
		asignarDireccion(tipoDireccion, calle, carrera, numero);
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the tipoAtencion
	 */
	public String getTipoAtencion() {
		return tipoAtencion;
	}
	/**
	 * @param tipoAtencion the tipoAtencion to set
	 */
	public void setTipoAtencion(String tipoAtencion) {
		this.tipoAtencion = tipoAtencion;
	}
	/**
	 * @return the direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public void asignarDireccion(String tipoDireccion, int calle, int carrera, int numero){
		this.direccion = new Direccion(tipoDireccion, calle, carrera, numero);
	}
}
