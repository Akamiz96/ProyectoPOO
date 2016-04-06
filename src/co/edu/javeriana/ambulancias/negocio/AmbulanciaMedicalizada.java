/**
 * 
 */
package co.edu.javeriana.ambulancias.negocio;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public abstract class AmbulanciaMedicalizada extends Ambulancia {

	/**
	 * 
	 */
	protected String medico;
	/**
	 * @param codigo
	 * @param placa
	 * @param medico
	 */
	public AmbulanciaMedicalizada(int codigo, String placa, String medico) {
		super(codigo, placa);
		this.medico = medico;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the medico
	 */
	public String getMedico() {
		return medico;
	}

	/**
	 * @param medico the medico to set
	 */
	public void setMedico(String medico) {
		this.medico = medico;
	}

	/**
	 * 
	 */
	public long calcularTarifa(){
		return 0;
	}
}
