/**
 *
 */
package co.edu.javeriana.ambulancias.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class EmpresaAmbulancias implements Serializable, IServiciosAmbulancias {
	/**
	 * nombre: Indica el nombre de la empresa de ambulancias
	 */
	private String nombre;
	/**
	 * servicios: Indica la LISTA de servicios que se contienen en el sistema
	 */
	private List<Servicio> servicios;
	/**
	 * ambulancias: Indica el map de ambulancias que se contienen en el sistema
	 * Llave: Codigo de la ambulancia (Integer) Valor: Objeto de tipo Ambulancia
	 */
	private Map<Integer, Ambulancia> ambulancias;
	/**
	 * lasIPS: Indica el map de IPS que se contienen en el sistema Llave: String
	 * Valor: Objeto de tipo IPS
	 */
	private Map<String, IPS> lasIPS;

	/**
	 * Constructor de la clase EmpresaAmbulancias. Se asigna el nombre a la
	 * variables de instancia y se instancian los arreglos
	 *
	 * @param nombre:
	 *            Indica el nombre de la empresa
	 */
	public EmpresaAmbulancias(String nombre) {
		super();
		this.nombre = nombre;
		this.servicios = new ArrayList<Servicio>();
		this.ambulancias = new Hashtable<Integer, Ambulancia>();
		this.lasIPS = new Hashtable<String, IPS>();
	}

	/**
	 * @return the nombre: Indica el nombre de la empresa de ambulancias
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set: Indica el nombre de la empresa de
	 *            ambulancias
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the servicios: Indica la LISTA de servicios que se contienen en
	 *         el sistema
	 */
	public List<Servicio> getServicios() {
		return servicios;
	}

	/**
	 * @param servicios
	 *            the servicios to set: Indica la LISTA de servicios que se
	 *            contienen en el sistema
	 */
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	/**
	 * @return the ambulancias: Indica la LISTA de ambulancias que se contienen
	 *         en el sistema
	 */
	public Map<Integer, Ambulancia> getAmbulancias() {
		return ambulancias;
	}

	/**
	 * @param ambulancias
	 *            the ambulancias to set: Indica la LISTA de ambulancias que se
	 *            contienen en el sistema
	 */
	public void setAmbulancias(Map<Integer, Ambulancia> ambulancias) {
		this.ambulancias = ambulancias;
	}

	/**
	 * @return the lasIPS: Indica el map de IPS que se contienen en el sistema
	 *         Llave: String Valor: Objeto de tipo IPS
	 */
	public Map<String, IPS> getLasIPS() {
		return lasIPS;
	}

	/**
	 * @param lasIPS
	 *            the lasIPS to set: Indica el map de IPS que se contienen en el
	 *            sistema Llave: String Valor: Objeto de tipo IPS
	 */
	public void setLasIPS(Map<String, IPS> lasIPS) {
		this.lasIPS = lasIPS;
	}

	/**
	 * Metodo para agregar una nueva IPS en el sistema.
	 *
	 * @see IPS
	 *
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
	 */
	public void agregarIPS(String nombre, String tipoAtencion, String tipoDireccion, int calle, int carrera,
			int numero) {
		IPS ips = new IPS(nombre, tipoAtencion, tipoDireccion, calle, carrera, numero);
		lasIPS.put(nombre, ips);
	}

	/**
	 * Metodo para agregar una nueva ambulancia en el sistema
	 *
	 * @param codigo:
	 *            Indica el codigo de la nueva ambulancia
	 * @param placa:
	 *            Indica la placa de la nueva ambulancia
	 * @param tipoDotacion:
	 *            Indica el equipamiento de la nueva ambulancia
	 */
	public void agregarAmbulancia(String tipoAmbulancia, int codigo, String placa, String medicoEnfermero,
			String tipoUCI) {
		Ambulancia ambulancia = null;
		if (tipoAmbulancia.equals("BASICA"))
			ambulancia = new AmbulanciaBasica(codigo, placa, medicoEnfermero);
		else if (tipoAmbulancia.equals("NOMEDICALIZADA"))
			ambulancia = new AmbulanciaNoMedicalizada(codigo, placa, medicoEnfermero);
		else if (tipoAmbulancia.equals("UCI"))
			ambulancia = new AmbulanciaUCI(codigo, placa, medicoEnfermero, tipoUCI);
		ambulancias.put(codigo, ambulancia);
	}

	/**
	 * Metodo para actualizar la posicion de una ambulancia dentro del sistema.
	 * Se busca la ambulancia dado un codigo y se asigna la calle y carrera Se
	 * utiliza la hora actual del sistema como hora en la que se registra la
	 * posicion
	 *
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
	 * Metodo para adicionar un nuevo servicio al sistema
	 *
	 * @see Servicio
	 * @param nombre:
	 *            Indica el nombre de la IPS
	 * @param tipoAtencion:
	 *            Indica el tipo de especializacion de la IPS
	 * @param tipoDireccion:
	 *            Indica si se encuentra sobre la carrera o sobre la calle
	 * @param telefono:
	 *            Indica el telefono desde el cual se realizo el servicio
	 * @param calle:
	 *            Indica la calle en la cual se encuentra
	 * @param carrera:
	 *            Indica la carrera en la cual se encuentra
	 * @param numero:
	 *            Indica el bloque en la cuadra donde se encuentra
	 * @return long: Codigo del servicio registrado
	 */
	public long registrarServicio(String nombre, String tipoAtencion, String telefono, String tipoDireccion, int calle,
			int carrera, int numero) {
		Servicio servicio = new Servicio(nombre, Long.parseLong(telefono), tipoAtencion, tipoDireccion, calle, carrera,
				numero);
		this.servicios.add(servicio);
		return servicio.getCodigo();
	}

	/**
	 * Metodo para asignar un servicio a una IPS y a una Ambulancia Se busca el
	 * servicio en la lista de servicios del sistema. Se crea una lista con las
	 * ambulancias disponibles de la cual se calcula la mas cercana al servicio
	 * encontrado. Tambien se calcula la IPS mas cercana y se asignan al
	 * servicio
	 *
	 * @see Ambulancia
	 * @see IPS
	 *
	 * @param codigo:
	 *            Representa el codigo unico dado al servicio dentro del sistema
	 * @return String: "Asignado" si fue una asignacion exitosa
	 * @return String: "No Existe el servicio" si NO fue una asignacion exitosa
	 */
	public String asignarServicio(long codigo) {
		Servicio servicio = this.buscarServicio(codigo);
		if (servicio != null) {
			List<Ambulancia> ambDisponibles = this.construirAmbulanciasDisponiblesServicio(servicio);
			if (!ambDisponibles.isEmpty()) {
				Ambulancia ambulancia = calcularAmbulanciaMasCercana(ambDisponibles, servicio.getDireccion().getCalle(),
						servicio.getDireccion().getCarrera());
				IPS ips;
				if (!servicio.getTipoServicio().equals("DOMICILIO")) {
					ips = calcularIPSMasCercano(this.lasIPS, servicio.getDireccion().getCalle(),
							servicio.getDireccion().getCarrera());
				} else
					ips = null;
				if (ips != null && !servicio.getTipoServicio().equals("DOMICILIO")) {
					asignarEstadoAmbulanciaIPS(servicio, ambulancia, ips);
					return "Asignado";
				} else if (servicio.getTipoServicio().equals("DOMICILIO")) {
					asignarEstadoAmbulanciaIPS(servicio, ambulancia, ips);
					return "Asignado";
				} else {
					return "No se han registrado IPS";
				}
			}
			return "Todas las ambulancias estan ocupadas";
		}
		return "No Existe el servicio";
	}

	/**
	 * Metodo para la asignacion de atributos de relacion entre Servicio,
	 * Ambulancia e IPS
	 *
	 * @see Servicio
	 * @see Ambulancia
	 *
	 * @param servicio:
	 *            Indica el servicio a asignar
	 * @param ambulancia:
	 *            Indica la ambulancia a la cual se le va a asignar el servicio
	 * @param ips:
	 *            Indica la IPS a la cual se le va a asignar el servicio
	 */
	private void asignarEstadoAmbulanciaIPS(Servicio servicio, Ambulancia ambulancia, IPS ips) {
		servicio.setAmbulancia(ambulancia);
		ambulancia.agregarServicioAmbulancia(servicio);
		servicio.setIps(ips);
		if (ips != null)
			ips.agregarServicioIPS(servicio);
		servicio.setEstado("ASIGNADO");

	}

	/**
	 * Metodo para cambiar el estado de un servicio a FINALIZADO
	 *
	 * @param codigo:
	 *            Representa el codigo unico dado al servicio dentro del sistema
	 * @return Boolean: Retorna si el servicio fue finalizado con exito
	 */
	public boolean finalizarServicio(int codigo) {
		boolean finalizado = false;
		Servicio servicio = this.buscarServicio(codigo);
		if (servicio != null) {
			servicio.setEstado("FINALIZADO");
			servicio.getAmbulancia().setEnServicio(false);
			finalizado = true;
		}
		return finalizado;
	}

	/**
	 * Metodo Privado para realizar la busqueda de una ambulancia en el sistema
	 * dado un codigo
	 *
	 * @param codigo:
	 *            Representa el codigo unico dado a la ambulancia dentro del
	 *            sistema
	 * @return Ambulancia: Retorna la ambulancia a la cual corresponde el codigo
	 *         dado (NULL en el caso de que no se encuentre dicha ambulancia)
	 */
	private Ambulancia buscarAmbulancia(int codigo) {
		if (this.ambulancias.containsKey(codigo))
			return this.ambulancias.get(codigo);
		else
			return null;
	}

	/**
	 * Metodo Privado para realizar la busqueda de un servicio en el sistema
	 * dado un codigo
	 *
	 * @param codigo:
	 *            Representa el codigo unico dado al servicio dentro del sistema
	 * @return Servicio: Retorna el servicio al cual corresponde el codigo dado
	 */
	private Servicio buscarServicio(long codigo) {
		for (Servicio servicio : this.servicios) {
			if (servicio.getCodigo() == codigo) {
				return servicio;
			}
		}
		return null;
	}

	/**
	 * Metodo privado para la creacion de una sublista de ambulancias
	 * disponibles en el sistema
	 *
	 * @param servicio:
	 *            Indica el servicio al cual se le realizara una subLISTA de
	 *            disponibilidad
	 * @return List: Se retorna la subLISTA de disponibilidad de ambulancias
	 */
	private List<Ambulancia> construirAmbulanciasDisponiblesServicio(Servicio servicio) {
		List<Ambulancia> ambulanciasDisponibles = new ArrayList<Ambulancia>();
		Set<Integer> llaves = this.ambulancias.keySet();
		for (Integer llave : llaves) {
			if (!this.ambulancias.get(llave).getEnServicio() && this.ambulancias.get(llave).getHoraPosicion() != null) {
				if (servicio.getTipoServicio().equals("EMERGENCIA")
						&& this.ambulancias.get(llave) instanceof AmbulanciaUCI) {
					ambulanciasDisponibles.add(this.ambulancias.get(llave));
				}
				if (servicio.getTipoServicio().equals("URGENCIA")) {
					ambulanciasDisponibles.add(this.ambulancias.get(llave));
				}
				if (servicio.getTipoServicio().equals("DOMICILIO")
						&& this.ambulancias.get(llave) instanceof AmbulanciaNoMedicalizada) {
					ambulanciasDisponibles.add(this.ambulancias.get(llave));
				}
			}
		}
		return ambulanciasDisponibles;
	}

	/**
	 * Metodo privado para calcular la ambulancia mas cercana a una calle y a
	 * una carrera dada Se realiza para una lista de ambulancias
	 *
	 * @param listaAmbulancia:
	 *            Indica la LISTA de ambulancias
	 * @param calle:
	 *            Indica la calle sobre la cual se calculara la cercania
	 * @param carrera:
	 *            Indica la carrera sobre la cual se calculara la cercania
	 * @return Ambulancia: Se retorna la instancia de la Ambulancia mas cercana
	 */
	private Ambulancia calcularAmbulanciaMasCercana(List<Ambulancia> listaAmbulancia, int calle, int carrera) {
		long minimo = -1;
		Ambulancia ambCercana = null;
		for (Ambulancia ambulancia : listaAmbulancia) {
			long distancia = this.calcularDistancia(ambulancia.getPosicionCalle(), ambulancia.getPosicionCarrera(),
					calle, carrera);
			if (minimo == -1) {
				minimo = distancia;
				ambCercana = ambulancia;
			} else if (distancia < minimo) {
				minimo = distancia;
				ambCercana = ambulancia;
			}
		}
		return ambCercana;
	}

	/**
	 * Metodo privado para calcular la IPS mas cercana a una calle y carrera
	 * dada Se realiza para un map de IPS
	 *
	 * @param calle:
	 *            Indica la calle sobre la cual se calculara la cercania
	 * @param carrera:
	 *            Indica la carrera sobre la cual se calculara la cercania
	 * @param mapIPS:
	 *            Indica el map de IPS del sistema para calcular la mas cercana
	 * @return IPS: Retorna la IPS mas cercana a la calle y a la carrera dadas
	 */
	private IPS calcularIPSMasCercano(Map<String, IPS> mapIPS, int calle, int carrera) {
		long minimo = -1;
		IPS ipsCercana = null;
		Set<String> llaves = mapIPS.keySet();
		for (String llave : llaves) {
			if (mapIPS.containsKey(llave)) {
				long distancia = this.calcularDistancia(mapIPS.get(llave).getDireccion().getCalle(),
						mapIPS.get(llave).getDireccion().getCarrera(), calle, carrera);
				if (minimo == -1) {
					minimo = distancia;
					ipsCercana = mapIPS.get(llave);
				} else if (distancia < minimo) {
					minimo = distancia;
					ipsCercana = mapIPS.get(llave);
				}
			}
		}
		return ipsCercana;
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
