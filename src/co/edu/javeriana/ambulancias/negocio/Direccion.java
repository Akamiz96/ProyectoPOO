/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class Direccion implements Serializable {
	/**
	 * Se considera una ciudad rectangular con calles y carreras numeradas desde
	 * 1. No se consideran diagonales, ni transversales, ni indicaciones
	 * adicionales como Este, Sur, etc.
	 */
	/**
	 * @attribute tipoDIreccion: Indica si se encuentra sobre la carrera o sobre
	 *            la calle
	 */
	private String tipoDireccion;
	/**
	 * @attribute calle: Indica la calle en la cual se encuentra
	 */
	private int calle;
	/**
	 * @attribute carrera: Indica la carrera en la cual se encuentra
	 */
	private int carrera;
	/**
	 * @attribute numero: Indica el bloque en la cuadra donde se encuentra
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
	 * @return the tipoDireccion
	 */
	public String getTipoDireccion() {
		return tipoDireccion;
	}

	/**
	 * @param tipoDireccion
	 *            the tipoDireccion to set
	 */
	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	/**
	 * @return the calle
	 */
	public int getCalle() {
		return calle;
	}

	/**
	 * @param calle
	 *            the calle to set
	 */
	public void setCalle(int calle) {
		this.calle = calle;
	}

	/**
	 * @return the carrera
	 */
	public int getCarrera() {
		return carrera;
	}

	/**
	 * @param carrera
	 *            the carrera to set
	 */
	public void setCarrera(int carrera) {
		this.carrera = carrera;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (this.tipoDireccion.equals("calle") || this.tipoDireccion.equals("CALLE")|| this.tipoDireccion.equals("Calle"))
			return String.format("%s %s#%s-%s", this.tipoDireccion, this.calle, this.carrera, this.numero);
		else
			return String.format("%s %s#%s-%s", this.tipoDireccion, this.carrera, this.calle, this.numero);
	}

}
