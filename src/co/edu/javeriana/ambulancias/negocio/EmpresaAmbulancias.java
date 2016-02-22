/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

/**
 * @author Pablo Ariza y Alejandro Castro 
 *
 */
public class EmpresaAmbulancias {
	/**
	*@attribute nombre: Indica el nombre de la empresa de ambulancias
	*/
	private String nombre;
	private Servicio[] servicios;
	private Ambulancia[] ambulancias;
	private IPS[] lasIPS;
	/**
	*@param
	*/
	public void agregarIPS(String nombre, String tipoAtencion, String tipoDireccion, int calle, int carrera, int numero, int indice){
		IPS ips = new IPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero);
		lasIPS[indice] = ips;
	}
	public void arregloIPS(int numeroIPS){
		lasIPS = new IPS[numeroIPS];
	}
	/**
	*@param
	*/
	public void agregarAmbulancia (int, String, String) {

	}
	/**
	*@param
	*/
	public boolean registrarPosicionAmbulancia(int, date, int, int){

	}
	/**
	*@param
	*/
	public int registrarServicio(String, String, String, int, int, int){

	}
	/**
	*@param
	*/
	public String asignarServicio(int){

	}
	/**
	*@param
	*/
	public boolean finalizarServicio(int){

	}
	/**
	*@param
	*/
	private Ambulancia buscarAmbulancia(int){

	}
	/**
	*@param
	*/
	private Servicio buscarServicio(int){

	}
	/**
	*@param
	*/
	private List<Ambulancia> construirAmbulanciasDisponiblesServicio(Servicio){

	}
	/**
	*@param
	*/
	private Ambulancia calcularAmbulanciaMasCercana(List<Ambulancia>){

	}
	/**
	*@param
	*/
	private IPS calcularIPSMasCercano(int, int){

	}
	/**
	*@param
	*/
	private long calcularDistancia(int, int, int, int){

	}

}
