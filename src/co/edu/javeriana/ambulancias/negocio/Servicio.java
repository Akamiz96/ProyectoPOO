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
public class Servicio implements Serializable {
	/**
	 * @attribute consecutivo: Representa el consecutivo de los servicios dentro
	 *            del sistema
	 */
	private static long consecutivo;
	/**
	 * @attribute codigo: Representa el codigo unico dado al servicio dentro
	 *            del sistema
	 */
	private long codigo;
	/**
	 * @attribute horaSolicitud: Representa la hora en la cual se hizo el pedido
	 *            de dicho servicio
	 */
	private GregorianCalendar horaSolicitud;
	/**
	 * @attribute paciente: Representa el nombre del paciente para el cual es
	 *            dicho servicio
	 */
	private String paciente;
	/**
	*@attribute telefono: Representa el telefono del cual se realizo el pedido de dicho servicio
	*/
	private long telefono;
	/**
	 * @attribute tipoServicio: Representa el tipo de servicio requerido
	 *            (URGENCIA/EMERGENCIA)
	 */
	private String tipoServicio;
	/**
	 * @attribute estado: Indica si el servicio esta: No_ASIGNADO, ASIGNADO o
	 *            FINALIZADO
	 */
	private String estado;
	/**
	 * @attribute direccion: Instancia de la clase Direccion que indica la
	 *            direccion del servicio
	 */
	private Direccion direccion;
	/**
	 * @attribute ips: Instancia de la clase IPS que indica la ips asignada al
	 *            servicio
	 */
	private IPS ips;
	/**
	 * @attribute ambulancia
	 */
	private Ambulancia ambulancia; 
	/**
	* @param codigo:
	* @param paciente:
	* @param telefono:
	* @param tipoServicio:
	* @param tipoDireccion:
	* @param calle:
	* @param carrera:
	* @param numero:
	*/
	public Servicio(long codigo, String paciente, long telefono, String tipoServicio, String tipoDireccion, int calle, int carrera, int numero) {
		super();
		this.codigo = codigo;
		this.paciente = paciente;
		this.telefono = telefono;
		this.tipoServicio = tipoServicio;
		this.estado = "NO_ASIGNADO";
		this.horaSolicitud = new GregorianCalendar();
		this.asignarDireccion(tipoDireccion, calle, carrera, numero);
		this.ips = null;
		this.ambulancia = null
	}

	/**
	 * @return the horaSolicitud
	 */
	public GregorianCalendar getHoraSolicitud() {
		return horaSolicitud;
	}

	/**
	 * @param horaSolicitud
	 *            the horaSolicitud to set
	 */
	public void setHoraSolicitud(GregorianCalendar horaSolicitud) {
		this.horaSolicitud = horaSolicitud;
	}

	/**
	 * @return the paciente
	 */
	public String getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente
	 *            the paciente to set
	 */
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	/**
	 * @return the telefono
	 */
	public long getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the tipoServicio
	 */
	public String getTipoServicio() {
		return tipoServicio;
	}

	/**
	 * @param tipoServicio
	 *            the tipoServicio to set
	 */
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the ips
	 */
	public IPS getIps() {
		return ips;
	}

	/**
	 * @param ips
	 *            the ips to set
	 */
	public void setIps(IPS ips) {
		this.ips = ips;
	}

	/**
	 * @return the consecutivo
	 */
	public static long getConsecutivo() {
		return consecutivo;
	}

	/**
	 * @return the codigo
	 */
	public long getCodigo() {
		return codigo;
	}
	/**
	*@param codigo the codigo to set
	*/
	public void setCodigo(long codigo){
		this.codigo = codigo;
	}
	/**
	 * @param tipoDireccion:
	 *            Indica si la direccion es sobre la carrera o sobre la calle
	 * @param calle:
	 *            Indica el numero de la calle de la direccion
	 * @param carrera:
	 *            Indica el numero de la carrera de la direccion
	 * @param numero:
	 *            Indica el bloque en la cuadra donde se encuentra
	 */
	public void asignarDireccion(String tipoDireccion, int calle, int carrera, int numero) {
		this.direccion = new Direccion(tipoDireccion, calle, carrera, numero);
	}
}
