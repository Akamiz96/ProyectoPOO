/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class AmbulanciaNoMedicalizada extends Ambulancia {

	/**
	 * 
	 */
	private String enfermero;
	/**
	 * @param codigo
	 * @param placa
	 * @param tipoDotacion
	 */
	public AmbulanciaNoMedicalizada(int codigo, String placa, String enfermero) {
		super(codigo, placa);
		this.enfermero = enfermero;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	public long calcularTarifa(){
		return 0;
	}
}
