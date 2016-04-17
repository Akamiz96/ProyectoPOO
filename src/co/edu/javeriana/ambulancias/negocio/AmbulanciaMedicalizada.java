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
	 * medico: Indica el nombre del medico que esta en la Ambulancia
	 */
	protected String medico;

	/**
	 * @param codigo:
	 *            Indica el codigo unico de la Ambulancia dentro del sistema
	 * @param placa:
	 *            Indica la identificacion unica de la Ambulancia dentro del
	 *            distrito
	 * @param medico:
	 *            Indica el nombre del medico que se encuentra dentro de la
	 *            Ambulancia
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
	/**
	 * Metodo que realiza el formateo del toString de la superClase y adiciona
	 * el nombre del medico que encuentra en la ambulancia
	 * codigo-placa-tipoDotacion-horaPosicion-posicionCalle-posicionCarrera-
	 * getCodigo(Servicio) Si aun no hay un servicio asignado se deja vacio ese
	 * espacio-medico
	 */
	public String toString() {
		return String.format("%s %-20s", super.toString(), medico);
	}

	/**
	 * Metodo que realiza el formateo del toStringC de la superClase y adiciona
	 * el nombre del medico que se encuentra en la ambulancia
	 * codigo-placa-tipoDeDotacion-horaPosicion-posicionCalle-posicionCarrera-
	 * medico
	 */
	public String toStringC() {
		return String.format("%s %-20s", super.toStringC(), medico);
	}

	/**
	 * Metodo abstracto que sera implementado por las subclases Metodo para
	 * calcular el valor de la tarifa de la ambulancia.
	 */
	public abstract long calcularTarifa();
}
