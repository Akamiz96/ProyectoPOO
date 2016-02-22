/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class Direccion {
	/**
	* Se considera una ciudad rectangular con calles y carreras numeradas desde 1.
	* No se consideran diagonales, ni transversales, ni indicaciones adicionales como Este, Sur, etc.
	*/
	/**
	*@attribute tipoDIreccion: Indica si se encuentra sobre la carrera o sobre la calle
	*/
	private String tipoDireccion;
	/**
	*@attribute calle: Indica la calle en la cual se encuentra
	*/
	private int calle;
	/**
	*@attribute carrera: Indica la carrera en la cual se encuentra
	*/
	private int carrera;
	/**
	*@attribute numero: Indica el bloque en la cuadra donde se encuentra
	*/
	private int numero;
	/**
	 * @param tipoDireccion
	 * @param calle
	 * @param carrera
	 * @param numero
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
	 * @param tipoDireccion the tipoDireccion to set
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
	 * @param calle the calle to set
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
	 * @param carrera the carrera to set
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
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
