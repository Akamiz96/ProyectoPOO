/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class AmbulanciaUCI extends AmbulanciaMedicalizada {

	/**
	 * 
	 */
	private String tipoUCI;
	/**
	 * @param codigo
	 * @param placa
	 * @param tipoDotacion
	 */
	public AmbulanciaUCI(int codigo, String placa, String medico, String tipoUCI) {
		super(codigo, placa, medico);
		this.tipoUCI = tipoUCI;
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	public long calcularTarifa(){
		return 0;
	}
}
