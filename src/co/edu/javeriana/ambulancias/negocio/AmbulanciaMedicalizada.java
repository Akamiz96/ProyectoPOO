/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class AmbulanciaMedicalizada extends Ambulancia {

	/**
	 * 
	 */
	protected String medico;
	/**
	 * @param codigo
	 * @param placa
	 * @param tipoDotacion
	 */
	public AmbulanciaMedicalizada(int codigo, String placa, String medico) {
		super(codigo, placa);
		this.medico = medico;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	public long calcularTarifa(){
		return 0;
	}
}
