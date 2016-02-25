/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;
import java.util.GregorianCalendar;

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

}
