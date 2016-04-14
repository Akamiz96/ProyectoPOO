/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import co.edu.javeriana.ambulancias.presentacion.Utils;

/**
 * @author Pablo Ariza y Alejandro Castro
 */
/**
 *
 * Representacion de una Ambulancia
 *
 */
public abstract class Ambulancia implements Serializable {
	/**
	 * codigo: Representa el codigo unico dado a la ambulancia dentro del
	 * sistema
	 */
	protected int codigo;
	/**
	 * placa: Representa la placa de la ambulancia (Identificacion de la
	 * ambulancia hacia entidades gubernamentales)
	 */
	protected String placa;
	/**
	 * horaPosicion: Representa la ultima vez que dicha Ambulancia registro su
	 * posicion
	 */
	protected GregorianCalendar horaPosicion;
	/**
	 * posicionCalle: Representa la calle en la cual se encuentra la Ambulancia
	 * la ultima vez que registro su posicion
	 */
	protected int posicionCalle;
	/**
	 * posicionCarrera: Representa la carrera en la cual se encuentra la
	 * Ambulancia la ultima vez que registro su posicion
	 */
	protected int posicionCarrera;
	/**
	 * servicios: Representa la lista de servicios que posee la ambulancia
	 */
	protected List<Servicio> servicios;
	/**
	 * enServicio: Indica si la ambulancia esta en servicio (true) o no (false)
	 */
	protected boolean enServicio;
	/**
	 * TARIFA_BASE: Indica la tarifa base de las ambulancias del sistema para
	 * esta entrega se asigna el valor 80000
	 */
	protected static long TARIFA_BASE = 80000;

	/**
	 * 
	 */
	public abstract long calcularTarifa();

	/**
	 * @param codigo:
	 *            Representa el codigo unico dado a la ambulancia dentro del
	 *            sistema
	 * @param placa:
	 *            Representa la placa de la ambulancia (Identificacion de la
	 *            ambulancia hacia entidades gubernamentales)
	 * @param tipoDotacion:
	 *            Representa la dotacion llevada dentro de la ambulancia para
	 *            atender servicios (MEDICALIZADA/ALTA_UCI)
	 */
	public Ambulancia(int codigo, String placa) {
		this.placa = placa;
		this.codigo = codigo;
		this.servicios = new ArrayList<Servicio>();
		this.horaPosicion = null;
		this.enServicio = false;
	}

	/**
	 * @return the codigo: Representa el codigo unico dado a la ambulancia
	 *         dentro del sistema
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set: Representa el codigo unico dado a la
	 *            ambulancia dentro del sistema
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the placa: Representa la placa de la ambulancia (Identificacion
	 *         de la ambulancia hacia entidades gubernamentales)
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa
	 *            the placa to set: Representa la placa de la ambulancia
	 *            (Identificacion de la ambulancia hacia entidades
	 *            gubernamentales)
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @return the horaPosicion: Representa la ultima vez que dicha Ambulancia
	 *         registro su posicion
	 */
	public GregorianCalendar getHoraPosicion() {
		return horaPosicion;
	}

	/**
	 * @param horaPosicion
	 *            the horaPosicion to set: Representa la ultima vez que dicha
	 *            Ambulancia registro su posicion
	 */
	public void setHoraPosicion(GregorianCalendar horaPosicion) {
		this.horaPosicion = horaPosicion;
	}

	/**
	 * @return the posicionCalle: Representa la calle en la cual se encuentra la
	 *         Ambulancia la ultima vez que registro su posicion
	 */
	public int getPosicionCalle() {
		return posicionCalle;
	}

	/**
	 * @param posicionCalle
	 *            the posicionCalle to set: Representa la calle en la cual se
	 *            encuentra la Ambulancia la ultima vez que registro su posicion
	 */
	public void setPosicionCalle(int posicionCalle) {
		this.posicionCalle = posicionCalle;
	}

	/**
	 * @return the posicionCarrera: Representa la carrera en la cual se
	 *         encuentra la Ambulancia la ultima vez que registro su posicion
	 */
	public int getPosicionCarrera() {
		return posicionCarrera;
	}

	/**
	 * @param posicionCarrera
	 *            the posicionCarrera to set: Representa la carrera en la cual
	 *            se encuentra la Ambulancia la ultima vez que registro su
	 *            posicion
	 */
	public void setPosicionCarrera(int posicionCarrera) {
		this.posicionCarrera = posicionCarrera;
	}

	/**
	 * @return the servicios
	 */
	public List<Servicio> getServicios() {
		return servicios;
	}

	/**
	 * @param servicios
	 *            the servicios to set
	 */
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	/**
	 * @return the enServicio
	 */
	public boolean getEnServicio() {
		return enServicio;
	}

	/**
	 * @param enServicio
	 *            the enServicio to set
	 */
	public void setEnServicio(boolean enServicio) {
		this.enServicio = enServicio;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	/**
	 * ToString para reporte de ambulancias
	 * codigo-placa-tipoDotacion-horaPosicion-posicionCalle-posicionCarrera-
	 * getCodigo(Servicio) Si aun no hay un servicio asignado se deja vacio ese
	 * espacio
	 * 
	 * @return String con el formato mencionado anteriormente
	 */
	@Override
	public String toString() {
		if (enServicio) {
			Servicio servicio = buscarServicio("ASIGNADO");
			if (servicio != null)
				return String.format("%-6s %-6s %-12s %-13s %-15s %-7d", this.codigo, this.placa,
						Utils.convertirFechaHoraString(this.horaPosicion), this.posicionCalle, this.posicionCarrera,
						servicio.getCodigo());
		} else {
			if (this.horaPosicion != null) {
				return String.format("%-6s %-6s %-12s %-13s %-15s        ", this.codigo, this.placa,
						Utils.convertirFechaHoraString(this.horaPosicion), this.posicionCalle, this.posicionCarrera);
			} else
				return String.format("%-6s %-6s \t\t\t\t\t\t\t", this.codigo, this.placa);
		}
		return "error";
	}

	/**
	 * ToString usado para reporte de ambulancia
	 * codigo-placa-tipoDeDotacion-horaPosicion-posicionCalle-posicionCarrera
	 * 
	 * @return String con el orden determinado anteriormente
	 */
	public String toStringC() {
		return String.format("%-6s %-8s %-12s %-13s  %-16s", this.codigo, this.placa,
				Utils.convertirFechaHoraString(this.horaPosicion), this.posicionCalle, this.posicionCarrera);
	}

	/**
	 * Metodo que agrega un servicio dado a la ambulancia Tambien realiza el
	 * cambio de estado a la ambulancia de false a true en el atributo
	 * enServicio.
	 * 
	 * @param servicio:
	 *            Indica el servicio a ser agregado a la lista de servicios.
	 */
	public void agregarServicioAmbulancia(Servicio servicio) {
		this.servicios.add(servicio);
		this.enServicio = true;
	}

	/**
	 * Metodo Privado para realizar la busqueda de un servicio en el sistema
	 * dado un codigo
	 *
	 * @param estado:
	 *            Representa el codigo unico dado al servicio dentro del sistema
	 * @return Servicio: Retorna el servicio al cual corresponde el codigo dado
	 */
	protected Servicio buscarServicio(String estado) {
		for (Servicio servicio : this.servicios) {
			if (servicio.getEstado().equals(estado)) {
				return servicio;
			}
		}
		return null;
	}
}
