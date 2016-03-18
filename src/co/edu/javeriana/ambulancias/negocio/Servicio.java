/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;
import java.util.GregorianCalendar;

import co.edu.javeriana.ambulancias.presentacion.Utils;

/**
 * @author Pablo Ariza y Alejandro Castro
 * 
 */
public class Servicio implements Serializable {
	/**
	 * consecutivo: Representa el consecutivo de los servicios dentro del
	 * sistema
	 */
	private static long consecutivo = 1;
	/**
	 * codigo: Representa el codigo unico dado al servicio dentro del sistema
	 */
	private long codigo;
	/**
	 * horaSolicitud: Representa la hora en la cual se hizo el pedido de dicho
	 * servicio
	 */
	private GregorianCalendar horaSolicitud;
	/**
	 * paciente: Representa el nombre del paciente para el cual es dicho
	 * servicio
	 */
	private String paciente;
	/**
	 * telefono: Representa el telefono del cual se realizo el pedido de dicho
	 * servicio
	 */
	private long telefono;
	/**
	 * tipoServicio: Representa el tipo de servicio requerido
	 * (URGENCIA/EMERGENCIA)
	 */
	private String tipoServicio;
	/**
	 * estado: Indica si el servicio esta: No_ASIGNADO, ASIGNADO o FINALIZADO
	 */
	private String estado;
	/**
	 * direccion: Instancia de la clase Direccion que indica la direccion del
	 * servicio
	 */
	private Direccion direccion;
	/**
	 * ips: Instancia de la clase IPS que indica la ips asignada al servicio
	 */
	private IPS ips;
	/**
	 * ambulancia: Instancia de la clase Ambulancia que indica la ambulancia
	 * asignada al servicio
	 */
	private Ambulancia ambulancia;

	/**
	 * @param codigo:
	 *            Representa el codigo del servicio dentro del sistema
	 * @param paciente:
	 *            Representa el nombre del paciente
	 * @param telefono:
	 *            Representa el telefono del cual fue realizado el servicio
	 * @param tipoServicio:
	 *            Representa el tipo de servicio requerido
	 * @param tipoDireccion:
	 *            Indica si se encuentra sobre la carrera o sobre la calle
	 * @param calle:
	 *            Indica la calle en la cual se encuentra
	 * @param carrera:
	 *            Indica la carrera en la cual se encuentra
	 * @param numero:
	 *            Indica el bloque en la cuadra donde se encuentra
	 */
	public Servicio(String paciente, long telefono, String tipoServicio, String tipoDireccion, int calle, int carrera,
			int numero) {
		super();
		this.codigo = Servicio.consecutivo++;
		this.paciente = paciente;
		this.telefono = telefono;
		this.tipoServicio = tipoServicio;
		this.estado = "NO_ASIGNADO";
		this.horaSolicitud = new GregorianCalendar();
		this.asignarDireccion(tipoDireccion, calle, carrera, numero);
		this.ips = null;
		this.ambulancia = null;
	}

	/**
	 * @return the horaSolicitud: Representa la hora en la cual se hizo el
	 *         pedido de dicho servicio
	 */
	public GregorianCalendar getHoraSolicitud() {
		return horaSolicitud;
	}

	/**
	 * @param horaSolicitud
	 *            the horaSolicitud to set: Representa la hora en la cual se
	 *            hizo el pedido de dicho servicio
	 */
	public void setHoraSolicitud(GregorianCalendar horaSolicitud) {
		this.horaSolicitud = horaSolicitud;
	}

	/**
	 * @return the paciente: Representa el nombre del paciente para el cual es
	 *         dicho servicio
	 */
	public String getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente
	 *            the paciente to set: Representa el nombre del paciente para el
	 *            cual es dicho servicio
	 */
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	/**
	 * @return the telefono: Representa el telefono del cual se realizo el
	 *         pedido de dicho servicio
	 */
	public long getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set: Representa el telefono del cual se
	 *            realizo el pedido de dicho servicio
	 */
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the tipoServicio: Representa el tipo de servicio requerido
	 *         (URGENCIA/EMERGENCIA)
	 */
	public String getTipoServicio() {
		return tipoServicio;
	}

	/**
	 * @param tipoServicio
	 *            the tipoServicio to set: Representa el tipo de servicio
	 *            requerido (URGENCIA/EMERGENCIA)
	 */
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	/**
	 * @return the estado: Indica si el servicio esta: No_ASIGNADO, ASIGNADO o
	 *         FINALIZADO
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set: Indica si el servicio esta: No_ASIGNADO,
	 *            ASIGNADO o FINALIZADO
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the direccion: Instancia de la clase Direccion que indica la
	 *         direccion del servicio
	 * @see Servicio
	 */
	public Direccion getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set: Instancia de la clase Direccion que
	 *            indica la direccion del servicio
	 * @see Servicio
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the ips: Instancia de la clase IPS que indica la ips asignada al
	 *         servicio
	 * @see IPS
	 */
	public IPS getIps() {
		return ips;
	}

	/**
	 * @param ips
	 *            the ips to set: Instancia de la clase IPS que indica la ips
	 *            asignada al servicio
	 * @see IPS
	 */
	public void setIps(IPS ips) {
		this.ips = ips;
	}

	/**
	 * @return the consecutivo: Representa el consecutivo de los servicios
	 *         dentro del sistema
	 */
	public static long getConsecutivo() {
		return consecutivo;
	}

	/**
	 * @return the codigo: Representa el codigo unico dado al servicio dentro
	 *         del sistema
	 */
	public long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set: Representa el codigo unico dado al servicio
	 *            dentro del sistema
	 */
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the ambulancia: Instancia de la clase Ambulancia que indica la
	 *         ambulancia asignada al servicio
	 * @see Ambulancia
	 */
	public Ambulancia getAmbulancia() {
		return ambulancia;
	}

	/**
	 * @param ambulancia
	 *            the ambulancia to set: Instancia de la clase Ambulancia que
	 *            indica la ambulancia asignada al servicio
	 * @see Ambulancia
	 */
	public void setAmbulancia(Ambulancia ambulancia) {
		this.ambulancia = ambulancia;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	/**
	 * ToString para el reporte del Servicio
	 * codigo-horaSolicitud-paciente-tipoServicio-telefono-Direccion Si esta
	 * asignado se adiciona el estado
	 * 
	 * @see Direccion#toString()
	 * @return String con el formato anteriormente mencionado
	 */
	public String toString() {
		if (this.estado.equals("NO_ASIGNADO"))
			return String.format("%-6s %-14s %-12s     %-12s %-9s %-16s", this.codigo,
					Utils.convertirFechaString(this.horaSolicitud), this.paciente, this.tipoServicio, this.telefono,
					this.direccion.toString());
		else
			return String.format("%-6s %-14s %-12s     %-12s %-9s %-16s %s", this.codigo,
					Utils.convertirFechaString(this.horaSolicitud), this.paciente, this.tipoServicio, this.telefono,
					this.direccion.toString(), this.estado);

	}

	/**
	 * ToStringB para reporte de Servicio
	 * codigo-horaSolicitud-paciente-tipoServicio-telefono-Direccion-estado-
	 * codigoAmbulancia
	 * 
	 * @see Direccion#toString()
	 * @return String con el formato anteriormente mencionado
	 */
	public String toStringB() {
		return String.format("%-6s %-14s %-12s %-10s %-8s %-18s %-10s %d", this.codigo,
				Utils.convertirFechaString(this.horaSolicitud), this.paciente, this.tipoServicio, this.telefono,
				this.direccion.toString(), this.estado, this.ambulancia.getCodigo());
	}

	/**
	 * ToStringC para reporte de Servicio
	 * codigo-paciente-codigoAmbulancia-nombreIPS
	 * 
	 * @return String con el formato anteriormente mencionado
	 */
	public String toStringC() {
		return String.format("%-6s %-12s %d %-15s", this.codigo, this.paciente, this.ambulancia.getCodigo(),
				this.ips.getNombre());
	}

	/**
	 * Metodo para asignar una direccion a un Servicio
	 * 
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
