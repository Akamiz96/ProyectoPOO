/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class Servicio implements Serializable{
	/**
	*@attribute consecutivo: Representa el consecutivo de los servicios dentro del sistema
	*/
	private static long consecutivo;
	/**
	*@attribute codigo: Representa el c�digo �nico dado al servicio dentro del sistema
	*/
	private static long codigo;
	/**
	*@attribute horaSolicitud: Representa la hora en la cual se hizo el pedido de dicho servicio
	*/
	private GregorianCalendar horaSolicitud;
	/**
	*@attribute paciente: Representa el nombre del paciente para el cual es dicho servicio
	*/
	private String paciente;
	/**
	*@attribute telefono: Representa el telefono del cual se realiz� el pedido de dicho servicio
	*/
	private long telefono;
	/**
	*@attribute tipoServicio: Representa el tipo de servicio requerido (URGENCIA/EMERGENCIA)
	*/
	private String tipoServicio;
	/**
	*@attribute estado: Indica si el servicio esta: No_ASIGNADO, ASIGNADO o FINALIZADO
	*/
	private String estado;
	/**
	*@attribute direccion: Instancia de la clase Direccion que indica la direccion del servicio
	*/
	private Direccion direccion;
	/**
	*@attribute ips: Instancia de la clase IPS que indica la ips asignada al servicio
	*/
	private IPS ips;
	/**
	*@param
	*/
	public void asignarDireccion(String tipoDireccion, int calle, int carrera, int numero){
		this.direccion = new Direccion( tipoDireccion, calle, carrera, numero);
	}
}
