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
		this.setEnfermero(enfermero);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the enfermero
	 */
	public String getEnfermero() {
		return enfermero;
	}

	/**
	 * @param enfermero the enfermero to set
	 */
	public void setEnfermero(String enfermero) {
		this.enfermero = enfermero;
	}

	/**
	 * 
	 */
	public long calcularTarifa(){
		return TARIFA_BASE;
	}
}
