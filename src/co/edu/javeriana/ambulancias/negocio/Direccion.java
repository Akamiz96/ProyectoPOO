/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
 /**
	* Se considera una ciudad rectangular con calles y carreras numeradas desde
	* 1. No se consideran diagonales, ni transversales, ni indicaciones
	* adicionales como Este, Sur, etc.
	*/
public class Direccion implements Serializable {
	/**
	 * tipoDireccion: Indica si se encuentra sobre la carrera o sobre
	 *            la calle
	 */
	private String tipoDireccion;
	/**
	 * calle: Indica la calle en la cual se encuentra
	 */
	private int calle;
	/**
	 * carrera: Indica la carrera en la cual se encuentra
	 */
	private int carrera;
	/**
	 * numero: Indica el bloque en la cuadra donde se encuentra
	 */
	private int numero;

	/**
	 * @param tipoDireccion:
	 *            Indica si se encuentra sobre la carrera o sobre la calle
	 * @param calle:
	 *            Indica la calle en la cual se encuentra
	 * @param carrera:
	 *            Indica la carrera en la cual se encuentra
	 * @param numero:
	 *            Indica el bloque en la cuadra donde se encuentra
	 */
	public Direccion(String tipoDireccion, int calle, int carrera, int numero) {
		super();
		this.tipoDireccion = tipoDireccion;
		this.calle = calle;
		this.carrera = carrera;
		this.numero = numero;
	}

	/**
	 * @return the tipoDireccion: Indica si se encuentra sobre la carrera o sobre
	 *            la calle
	 */
	public String getTipoDireccion() {
		return tipoDireccion;
	}

	/**
	 * @param tipoDireccion
	 *            the tipoDireccion to set: Indica si se encuentra sobre la carrera o sobre
	 *            la calle
	 */
	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	/**
	 * @return the calle: Indica la calle en la cual se encuentra
	 */
	public int getCalle() {
		return calle;
	}

	/**
	 * @param calle
	 *            the calle to set: Indica la calle en la cual se encuentra
	 */
	public void setCalle(int calle) {
		this.calle = calle;
	}

	/**
	 * @return the carrera: Indica la carrera en la cual se encuentra
	 */
	public int getCarrera() {
		return carrera;
	}

	/**
	 * @param carrera
	 *            the carrera to set: Indica la carrera en la cual se encuentra
	 */
	public void setCarrera(int carrera) {
		this.carrera = carrera;
	}

	/**
	 * @return the numero: Indica el bloque en la cuadra donde se encuentra
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set: Indica el bloque en la cuadra donde se encuentra
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	/**
	 * ToString para reporte del servicio
	 * tipoDireccion-calle/carrera-#-calle/carrera-numero
	 * @return String con el formato mencionado anteriormente
	 */
	@Override
	public String toString() {
		if (this.tipoDireccion.equals("calle") || this.tipoDireccion.equals("CALLE")|| this.tipoDireccion.equals("Calle"))
			return String.format("%s %s#%s-%s", this.tipoDireccion, this.calle, this.carrera, this.numero);
		else
			return String.format("%s %s#%s-%s", this.tipoDireccion, this.carrera, this.calle, this.numero);
	}

}
