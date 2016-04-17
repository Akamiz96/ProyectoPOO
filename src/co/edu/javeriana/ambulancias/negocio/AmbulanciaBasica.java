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
	 * @see AmbulanciaMedicalizada Se invoca constructor de la superClase
	 *      AmbulanciaMedicalizada.
	 * @param codigo:
	 *            Indica el codigo de la Ambulancia dentro del sistema
	 * @param placa:
	 *            Indica la identificacion unica de la Ambulancia hacia el
	 *            distrito
	 * @param medico:
	 *            Indica el nombre del medico que esta en la Ambulancia
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
	/**
	 * Metodo que realiza el formateo del toString de la superClase
	 * 
	 * @see AmbulanciaMedicalizada#toString
	 */
	public String toString() {
		return String.format("%s", super.toString());
	}

	/**
	 * Metodo que realiza el formateo del toStringC de la superClase
	 * 
	 * @see AmbulanciaMedicalizada#toStringC
	 */
	public String toStringC() {
		return String.format("%s", super.toStringC());
	}

	/**
	 * Metodo implementado de la superClase Metodo para calcular la tarifa de la
	 * Ambulancia Basica (20%)
	 */
	public long calcularTarifa() {
		return (long) (TARIFA_BASE * 1.20);
	}
}
