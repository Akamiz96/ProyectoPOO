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
 *
 *
 */
public class Ambulancia implements Serializable {
	/**
	 * @attribute codigo: Representa el codigo unico dado a la ambulancia dentro
	 *            del sistema
	 */
	private int codigo;
	/**
	 * @attribute placa: Representa la placa de la ambulancia (Identificacion de
	 *            la ambulancia hacia entidades gubernamentales)
	 */
	private String placa;
	/**
	 * @attribute tipoDotacion: Representa la dotacion llevada dentro de la
	 *            ambulancia para atender servicios (MEDICALIZADA/ALTA_UCI)
	 */
	private String tipoDotacion;
	/**
	 * @attribute horaPosicion: Representa la ultima vez que dicha Ambulancia
	 *            registro su posicion
	 */
	private GregorianCalendar horaPosicion;
	/**
	 * @attribute posicionCalle: Representa la calle en la cual se encuentra la
	 *            Ambulancia la ultima vez que registro su posicion
	 */
	private int posicionCalle;
	/**
	 * @attribute posicionCarrera: Representa la carrera en la cual se encuentra
	 *            la Ambulancia la ultima vez que registro su posicion
	 */
	private int posicionCarrera;
	/**
	 * @attribute servicios: Representa la lista de servicios que posee la
	 *            ambulancia
	 */
	private List<Servicio> servicios;

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
	public Ambulancia(int codigo, String placa, String tipoDotacion) {
		this.placa = placa;
		this.tipoDotacion = tipoDotacion;
		this.codigo = codigo;
		this.servicios = new ArrayList<Servicio>();
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
	 * @return the tipoDotacion: Representa la dotacion llevada dentro de la
	 *         ambulancia para atender servicios (MEDICALIZADA/ALTA_UCI)
	 */
	public String getTipoDotacion() {
		return tipoDotacion;
	}

	/**
	 * @param tipoDotacion
	 *            the tipoDotacion to set: Representa la dotacion llevada dentro
	 *            de la ambulancia para atender servicios
	 *            (MEDICALIZADA/ALTA_UCI)
	 */
	public void setTipoDotacion(String tipoDotacion) {
		this.tipoDotacion = tipoDotacion;
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

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		for (Servicio servicio : this.servicios) {
			if (servicio.getEstado().equals("ASIGNADO") || servicio.getEstado().equals("Asignado")
					|| servicio.getEstado().equals("asignado"))
				return String.format("%-6s %-8s %-14s %-4s %-4s %-4s %-4d", this.codigo, this.placa, this.tipoDotacion,
						Utils.convertirFechaHoraString(this.horaPosicion), this.posicionCalle, this.posicionCarrera,
						servicio.getCodigo());
		}
		return null;
	}

	public String toString(boolean opcion) {
		return String.format("%-6s %-8s %-14s %-4s %-4s %-4s %-4d", this.codigo, this.placa, this.tipoDotacion,
				Utils.convertirFechaHoraString(this.horaPosicion), this.posicionCalle, this.posicionCarrera);
	}

	/**
	 * Metodo para determinar si una ambulancia esta disponible
	 *
	 * @return true: si la ambulancia esta disponible
	 * @return false: si la ambulancia esta asignada a un servicio
	 */
	public boolean ambulanciaDisponible() {
		for (Servicio servicio : this.servicios) {
			if (servicio.getEstado() == "ASIGNADO" || servicio.getEstado() == "asignado") {
				return false;
			}
		}
		return true;
	}
}
