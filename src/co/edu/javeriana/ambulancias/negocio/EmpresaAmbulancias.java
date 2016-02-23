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
	/**
	*@attribute servicios: Indica la LISTA de servicios que se contienen en el sistema
	*/
	private Servicio[] servicios;
	/**
	*@attribute ambulancias: Indica la LISTA de ambulancias que se contienen en el sistema
	*/
	private Ambulancia[] ambulancias;
	/**
	*@attribute lasIPS: Indica la LISTA de IPS que se contienen en el sistema
	*/
	private IPS[] lasIPS;
	/**
	*@param
	*/
	public void agregarIPS(String nombre, String tipoAtencion, String tipoDireccion, int calle, int carrera, int numero, int indice){
		IPS ips = new IPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero);
		lasIPS[indice] = ips;
	}
	public void arregloIPS(int numIPS){
		lasIPS = new IPS[numeroIPS];
	}
	public void arregloAmbulancia(int numeroAmbulancia){
		ambulancias = new Ambulancia[numAmbulancia];
	}
	/**
	*@param
	*/
	public void agregarAmbulancia (int codigo, String placa, String tipoDotacion, int indice) {
		Ambulancia ambulancia = new Ambulancia(codigo, placa, tipoDotacion);
		ambulancias[indice] = ambulancia;
	}
	/**
	*@param
	*/
	public boolean registrarPosicionAmbulancia(int date, int , int ){

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
	*@param calleInicio: Indica el numero de la calle donde se inicia el recorrido
	*@param carreraInicio: Indica el numero de la carrera donde se inicia el recorrido
	*@param calleFin: Indica el numero de la calle donde se termina el recorrido
	*@param carreraFin: Indica el numero de la carrera donde se termina el recorrido
	*/
	private long calcularDistancia(int calleInicio, int carreraInicio, int calleFin, int carreraFin){
			long distancia = ((calleInicio-calleFin) + (carreraInicio-carreraFin));
			return distancia < 0 ? distancia*-1 : distancia;
	}

}
