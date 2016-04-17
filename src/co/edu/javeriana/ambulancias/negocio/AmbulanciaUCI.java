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
	 * tipoUCI: Indica el tipo de ambulancia que es (PEDIATRICA o
	 * CARDIOVASCULAR)
	 */
	private String tipoUCI;

	/**
	 * @param codigo:
	 *            Indica la identificacion unica de la ambulancia dentro del
	 *            sistema
	 * @param placa:
	 *            Indica la identificacion unica de la ambulancia para el
	 *            distrito
	 * @param medico:
	 *            Indica el nombre del medico que va en la ambulancia
	 * @param tipoUci:
	 *            Indica el tipo de ambulancia que es
	 */
	public AmbulanciaUCI(int codigo, String placa, String medico, String tipoUCI) {
		super(codigo, placa, medico);
		this.setTipoUCI(tipoUCI);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the tipoUCI
	 */
	public String getTipoUCI() {
		return tipoUCI;
	}

	/**
	 * @param tipoUCI
	 *            the tipoUCI to set
	 */
	public void setTipoUCI(String tipoUCI) {
		this.tipoUCI = tipoUCI;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Metodo que formatea el ToString de la superClase y le adiciona el tipo de
	 * ambulancia TIPOUCI
	 * codigo-placa-tipoDotacion-horaPosicion-posicionCalle-posicionCarrera-
	 * getCodigo(Servicio) Si aun no hay un servicio asignado se deja vacio ese
	 * espacio-medico-tipoUCI
	 */
	@Override
	public String toString() {
		return String.format("%s %-16s", super.toString(), tipoUCI);
	}

	/**
	 * Metodo que formatea el ToStringC de la superClase y le adiciona el tipo
	 * de ambulancia TIPOUCI
	 * codigo-placa-tipoDeDotacion-horaPosicion-posicionCalle-posicionCarrera-medico-tipoUCI
	 */
	public String toStringC() {
		return String.format("%s %-16s", super.toStringC(), this.tipoUCI);
	}

	/**
	 * Metodo para calcular la tarifa de una ambulancia UCI Cardiovascular:
	 * TARIFA_BASE * 1.50 Pediatrica: TARIFA_BASE * 1.60
	 */
	public long calcularTarifa() {
		if (this.tipoUCI.equals("CARDIOVASCULAR"))
			return (long) (TARIFA_BASE * 1.50);
		if (this.tipoUCI.equals("PEDIATRICA"))
			return (long) (TARIFA_BASE * 1.60);
		return 0;
	}
}
