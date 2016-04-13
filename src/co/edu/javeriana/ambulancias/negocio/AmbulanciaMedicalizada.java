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
	 * @param medico
	 *            the medico to set
	 */
	public void setMedico(String medico) {
		this.medico = medico;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s %-20s", super.toString(), medico);
	}

	public String toStringC() {
		return String.format("%s %-20s", super.toStringC(), medico);
	}

	/**
	 * 
	 */
	public abstract long calcularTarifa();
}
