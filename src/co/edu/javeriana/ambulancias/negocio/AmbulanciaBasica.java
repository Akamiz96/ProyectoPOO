/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class AmbulanciaBasica extends AmbulanciaMedicalizada {

	/**
	 * @param codigo
	 * @param placa
	 * @param medico
	 */
	public AmbulanciaBasica(int codigo, String placa, String medico) {
		super(codigo, placa, medico);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s", super.toString());
	}

	public String toStringC() {
		return String.format("%s", super.toStringC());
	}

	/**
	 *
	 */
	public long calcularTarifa(){
		return (long)(TARIFA_BASE * 1.20);
	}
}
