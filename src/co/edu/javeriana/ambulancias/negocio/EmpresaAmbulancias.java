/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

import java.util.GregorianCalendar;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class EmpresaAmbulancias implements Serializable{
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
	*@param nombre: Indica el nombre de la nueva IPS
	*@param tipoAtencion: Indica la atencion que presta  la nueva IPS
	*@param tipoDireccion: Indica si la nueva IPS esta ubicada en una carrera o en una calle
	*@param calle: Indica el numero de la calle de la nueva IPS
	*@param carrera: Indica el numero de la carrera de la nueva IPS
	*@param numero: Indica la posicion de la nueva IPS en la calle o en la carrera
	*@param indice: Indica la posicion de la nueva IPS en el arreglo de empresaAmbulancia
	*/
	public void agregarIPS(String nombre, String tipoAtencion, String tipoDireccion, int calle, int carrera, int numero, int indice){
		IPS ips = new IPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero);
		lasIPS[indice] = ips;
	}
	/**
	*@param numIPS: Indica el tamaño del arreglo "lasIPS"
	*/
	public void arregloIPS(int numIPS){
		lasIPS = new IPS[numIPS];
	}
	/**
	*@param numAmbulancia: Indica el tamaño del arreglo "ambulancias"
	*/
	public void arregloAmbulancia(int numAmbulancia){
		ambulancias = new Ambulancia[numAmbulancia];
	}
	/**
	*@param codigo: Indica el  codigo de la nueva ambulancia
	*@param placa: Indica la placa de la nueva ambulancia
	*@param tipoDotacion: Indica el equipamiento de la nueva ambulancia
	*@param indice: Indica la posicion de la nueva ambulancia en el arreglo de EmpresaAmbulancia
	*/
	public void agregarAmbulancia (int codigo, String placa, String tipoDotacion, int indice) {
		Ambulancia ambulancia = new Ambulancia(codigo, placa, tipoDotacion);
		ambulancias[indice] = ambulancia;
	}
	/**
	*@param codigo: Indica la ambulancia a la que se le registrara la posicion
	*@param	calle: Indica la calle en la que se encuentra la ambulancia
	*@param	carrera: Indica la carrera en la que se encuentra la ambulancia
	*@return encontro: Indica si se a registrado la posicion actual de la ambulancia
	*/
	public boolean registrarPosicionAmbulancia(int codigo, int calle, int carrera){
		boolean encontro = false;
		for(int i = 0 ; (i < this.ambulancias.length) && !encontro ; i++){
			if(ambulancias[i].getCodigo() == codigo){
				ambulancias[i].setHoraPosicion(new GregorianCalendar());
				ambulancias[i].setPosicionCalle(calle);
				ambulancias[i].setPosicionCarrera(carrera);
				encontro = true;
			}
		}
		return encontro;
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
