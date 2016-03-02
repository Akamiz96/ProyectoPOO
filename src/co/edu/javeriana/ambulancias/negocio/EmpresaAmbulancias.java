/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class EmpresaAmbulancias implements Serializable {
	/**
	 * @attribute nombre: Indica el nombre de la empresa de ambulancias
	 */
	private String nombre;
	/**
	 * @attribute servicios: Indica la LISTA de servicios que se contienen en el
	 *            sistema
	 */
	private List<Servicio> servicios;
	/**
	 * @attribute ambulancias: Indica la LISTA de ambulancias que se contienen
	 *            en el sistema
	 */
	private List<Ambulancia> ambulancias;
	/**
	 * @attribute lasIPS: Indica la LISTA de IPS que se contienen en el sistema
	 */
	private List<IPS> lasIPS;

	/**
	 * @param nombre
	 */
	public EmpresaAmbulancias(String nombre) {
		super();
		this.nombre = nombre;
		this.servicios = new ArrayList<Servicio>();
		this.ambulancias = new ArrayList<Ambulancia>();
		this.lasIPS = new ArrayList<IPS>();
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the servicios
	 */
	public List<Servicio> getServicios() {
		return servicios;
	}

	/**
	 * @param servicios
	 *            the servicios to set
	 */
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	/**
	 * @return the ambulancias
	 */
	public List<Ambulancia> getAmbulancias() {
		return ambulancias;
	}

	/**
	 * @param ambulancias
	 *            the ambulancias to set
	 */
	public void setAmbulancias(List<Ambulancia> ambulancias) {
		this.ambulancias = ambulancias;
	}

	/**
	 * @return the lasIPS
	 */
	public List<IPS> getLasIPS() {
		return lasIPS;
	}

	/**
	 * @param lasIPS
	 *            the lasIPS to set
	 */
	public void setLasIPS(List<IPS> lasIPS) {
		this.lasIPS = lasIPS;
	}

	/**
	 * @param nombre:
	 *            Indica el nombre de la nueva IPS
	 * @param tipoAtencion:
	 *            Indica la atencion que presta la nueva IPS
	 * @param tipoDireccion:
	 *            Indica si la nueva IPS esta ubicada en una carrera o en una
	 *            calle
	 * @param calle:
	 *            Indica el numero de la calle de la nueva IPS
	 * @param carrera:
	 *            Indica el numero de la carrera de la nueva IPS
	 * @param numero:
	 *            Indica la posicion de la nueva IPS en la calle o en la carrera
	 * @param indice:
	 *            Indica la posicion de la nueva IPS en el arreglo de
	 *            empresaAmbulancia
	 */
	public void agregarIPS(String nombre, String tipoAtencion, String tipoDireccion, int calle, int carrera,
			int numero) {
		IPS ips = new IPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero);
		lasIPS.add(ips);
	}

	/**
	 * @param codigo:
	 *            Indica el codigo de la nueva ambulancia
	 * @param placa:
	 *            Indica la placa de la nueva ambulancia
	 * @param tipoDotacion:
	 *            Indica el equipamiento de la nueva ambulancia
	 * @param indice:
	 *            Indica la posicion de la nueva ambulancia en el arreglo de
	 *            EmpresaAmbulancia
	 */
	public void agregarAmbulancia(int codigo, String placa, String tipoDotacion) {
		Ambulancia ambulancia = new Ambulancia(codigo, placa, tipoDotacion);
		ambulancias.add(ambulancia);
	}

	/**
	 * @param codigo:
	 *            Indica la ambulancia a la que se le registrara la posicion
	 * @param calle:
	 *            Indica la calle en la que se encuentra la ambulancia
	 * @param carrera:
	 *            Indica la carrera en la que se encuentra la ambulancia
	 * @return encontro: Indica si se a registrado la posicion actual de la
	 *         ambulancia
	 */
	public boolean registrarPosicionAmbulancia(int codigo, int calle, int carrera) {
		boolean encontro = false;
		Ambulancia ambulancia = this.buscarAmbulancia(codigo);
		if (ambulancia != null) {
			ambulancia.setHoraPosicion(new GregorianCalendar());
			ambulancia.setPosicionCalle(calle);
			ambulancia.setPosicionCarrera(carrera);
			encontro = true;
		}
		return encontro;
	}

	/**
	 * @param nombre:
	 *            Indica el nombre de la IPS
	 * @param tipoAtencion:
	 *            Indica el tipo de especializacion de la IPS
	 * @param tipoDireccion:
	 *            Indica si se encuentra sobre la carrera o sobre la calle
	 * @param calle:
	 *            Indica la calle en la cual se encuentra
	 * @param carrera:
	 *            Indica la carrera en la cual se encuentra
	 * @param numero:
	 *            Indica el bloque en la cuadra donde se encuentra
	 */
	public long registrarServicio(String nombre, String tipoAtencion, String telefono, String tipoDireccion, int calle,
			int carrera, int numero) {
		Servicio servicio = new Servicio(nombre, Long.parseLong(telefono), tipoAtencion, tipoDireccion, calle, carrera,
				numero);
		this.servicios.add(servicio);
		return servicio.getCodigo();
	}

	/**
	 * @param codigo:
	 *            Representa el codigo unico dado al servicio dentro del sistema
	 * @return String:
	 */
	public String asignarServicio(int codigo) {

	}

	/**
	 * @param codigo:
	 *            Representa el codigo unico dado al servicio dentro del sistema
	 * @return Boolean: Retorna si el servicio fue finalizado con exito
	 */
	public boolean finalizarServicio(int codigo) {

	}

	/**
	 * @param codigo:
	 *            Representa el codigo unico dado a la ambulancia dentro del
	 *            sistema
	 * @return Ambulancia: Retorna la ambulancia a la cual corresponde el codigo
	 *         dado (NULL en el caso de que no se encuentre dicha ambulancia)
	 */
	private Ambulancia buscarAmbulancia(int codigo) {
		for (Ambulancia ambulancia : this.ambulancias) {
			if (ambulancia.getCodigo() == codigo) {
				return ambulancia;
			}
		}
		return null;
	}

	/**
	 * @param codigo:
	 *            Representa el codigo unico dado al servicio dentro del sistema
	 * @return Servicio: Retorna el servicio al cual corresponde el codigo dado
	 */
	private Servicio buscarServicio(int codigo) {
		for (Servicio servicio : this.servicios){
			if (servicio.getCodigo() == codigo){
				return servicio
			}
		}
		retun null
	}

	/**
	 * @param servicio:
	 *            Indica el servicio al cual se le realizara una subLISTA de
	 *            disponibilidad
	 * @return List<Ambulancia>: Se retorna la subLISTA de disponibilidad
	 */
	private List<Ambulancia> construirAmbulanciasDisponiblesServicio(Servicio servicio) {

	}

	/**
	 * @param listaAmbulancia:
	 *            Indica la LISTA de ambulancias
	 * @param calle:
	 *            Indica la calle sobre la cual se calculara la cercania
	 * @param carrera:
	 *            Indica la carrera sobre la cual se calculara la cercania
	 * @return Ambulancia: Se retorna la instancia de la Ambulancia mas cercana
	 */
	private Ambulancia calcularAmbulanciaMasCercana(List<Ambulancia> listaAmbulancia, int calle, int carrera) {

	}

	/**
	 * @param calle:
	 *            Indica la calle sobre la cual se calculara la cercania
	 * @param carrera:
	 *            Indica la carrera sobre la cual se calculara la cercania
	 * @return IPS: Retorna la IPS mas cercana a la calle y a la carrera dadas
	 */
	private IPS calcularIPSMasCercano(int calle, int carrera) {

	}

	/**
	 * Calculo a partir de la geometria de Manhattan; en donde la distancia mas
	 * cercana entre dos puntos no es la linea recta sino la distancia en
	 * cuadrados
	 *
	 * @param calleInicio:
	 *            Indica el numero de la calle donde se inicia el recorrido
	 * @param carreraInicio:
	 *            Indica el numero de la carrera donde se inicia el recorrido
	 * @param calleFin:
	 *            Indica el numero de la calle donde se termina el recorrido
	 * @param carreraFin:
	 *            Indica el numero de la carrera donde se termina el recorrido
	 * @return long: Retorna la distancia a partir de los parametros dados
	 */
	private long calcularDistancia(int calleInicio, int carreraInicio, int calleFin, int carreraFin) {
		long distancia = ((calleInicio - calleFin) + (carreraInicio - carreraFin));
		return distancia < 0 ? distancia * -1 : distancia;
	}

}
