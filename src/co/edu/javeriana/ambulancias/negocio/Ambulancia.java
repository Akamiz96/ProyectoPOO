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
	*@attribute codigo: Representa el c�digo �nico dado a la ambulancia dentro del sistema
	*/
	private static int codigo;
	/**
	*@attribute placa: Representa la placa de la ambulancia (Identificaci�n de la ambulancia hacia entidades gubernamentales)
	*/
	private String placa;
	/**
	*@attribute tipoDotacion: Representa la dotaci�n llevada dentro de la ambulancia para atender servicios (MEDICALIZADA/ALTA_UCI)
	*/
	private String tipoDotacion;
	/**
	*@attribute horaPosicion: Representa la �ltima vez que dicha Ambulancia registr� su posici�n
	*/
	private GregorianCalendar horaPosicion;
	/**
	*@attribute posicionCalle: Representa la calle en la cual se encuentra la Ambulancia la �ltima vez que registr� su posici�n
	*/
	private int posicionCalle;
	/**
	*@attribute posicionCarrera: Representa la carrera en la cual se encuentra la Ambulancia la �ltima vez que registr� su posici�n
	*/
	private int posicionCarrera;
	/**
	 * @param codigo
	 * @param placa
	 * @param tipoDotacion
	 */
	public Ambulancia(int codigo, String placa, String tipoDotacion) {
		this.placa = placa;
		this.tipoDotacion = tipoDotacion;
		this.codigo = codigo;
	}
	/**
	 * @return the codigo
	 */
	public static int getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public static void setCodigo(int codigo) {
		Ambulancia.codigo = codigo;
	}
	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	/**
	 * @return the tipoDotacion
	 */
	public String getTipoDotacion() {
		return tipoDotacion;
	}
	/**
	 * @param tipoDotacion the tipoDotacion to set
	 */
	public void setTipoDotacion(String tipoDotacion) {
		this.tipoDotacion = tipoDotacion;
	}
	/**
	 * @return the horaPosicion
	 */
	public GregorianCalendar getHoraPosicion() {
		return horaPosicion;
	}
	/**
	 * @param horaPosicion the horaPosicion to set
	 */
	public void setHoraPosicion(GregorianCalendar horaPosicion) {
		this.horaPosicion = horaPosicion;
	}
	/**
	 * @return the posicionCalle
	 */
	public int getPosicionCalle() {
		return posicionCalle;
	}
	/**
	 * @param posicionCalle the posicionCalle to set
	 */
	public void setPosicionCalle(int posicionCalle) {
		this.posicionCalle = posicionCalle;
	}
	/**
	 * @return the posicionCarrera
	 */
	public int getPosicionCarrera() {
		return posicionCarrera;
	}
	/**
	 * @param posicionCarrera the posicionCarrera to set
	 */
	public void setPosicionCarrera(int posicionCarrera) {
		this.posicionCarrera = posicionCarrera;
	}

}
