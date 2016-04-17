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
	 * enfermero: Indica el nombre del enfermero que se encuentra en la
	 * ambulancia
	 */
	private String enfermero;

	/**
	 * @param codigo:
	 *            Indica la identificacion unica de la ambulancia dentro del
	 *            sistema
	 * @param placa:
	 *            Indica la identificacion unica de la ambulancia en el distrito
	 * @param enfermero:
	 *            Indica el nombre del enfermero que va en la ambulancia
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
	 * @param enfermero
	 *            the enfermero to set
	 */
	public void setEnfermero(String enfermero) {
		this.enfermero = enfermero;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	/**
	 * Metodo que formatea el toString de la superClase y le adiciona el nombre
	 * del enfermero que va en la ambulancia
	 * codigo-placa-tipoDotacion-horaPosicion-posicionCalle-posicionCarrera-
	 * getCodigo(Servicio) Si aun no hay un servicio asignado se deja vacio ese
	 * espacio-enfermero
	 */
	public String toString() {
		return String.format("%s %-20s", super.toString(), enfermero);
	}

	/**
	 * Metodo que formatea el toStringC de la superClase y le adiciona el nombre
	 * del enfermero que va en la ambulancia
	 * codigo-placa-tipoDeDotacion-horaPosicion-posicionCalle-posicionCarrera-
	 * enfermero
	 */
	public String toStringC() {
		return String.format("%s %-20s", super.toStringC(), enfermero);
	}

	/**
	 * Metodo implementado de la superClase La tarifa es la indicada en
	 * TARIFA_BASE
	 */
	public long calcularTarifa() {
		return TARIFA_BASE;
	}
}
