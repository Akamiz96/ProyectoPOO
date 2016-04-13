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
	 * 
	 */
	private String tipoUCI;
	/**
	 * @param codigo
	 * @param placa
	 * @param medico
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
	 * @param tipoUCI the tipoUCI to set
	 */
	public void setTipoUCI(String tipoUCI) {
		this.tipoUCI = tipoUCI;
	}
	/**
	 * 
	 */
	public long calcularTarifa(){
		if(this.tipoUCI.equals("CARDIOVASCULAR"))
			return (long)(TARIFA_BASE * 1.50);
		if(this.tipoUCI.equals("PEDIATRICA"))
			return (long)(TARIFA_BASE * 1.60);
		return 0;
	}
}
