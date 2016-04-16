/**
 *
 */
package co.edu.javeriana.ambulancias.presentacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import co.edu.javeriana.ambulancias.negocio.AmbulanciaBasica;
import co.edu.javeriana.ambulancias.negocio.AmbulanciaNoMedicalizada;
import co.edu.javeriana.ambulancias.negocio.AmbulanciaUCI;
import co.edu.javeriana.ambulancias.negocio.CodigoComparator;
import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.negocio.HoraSolicitudComparator;
import co.edu.javeriana.ambulancias.negocio.IPS;
import co.edu.javeriana.ambulancias.negocio.Servicio;
import co.edu.javeriana.ambulancias.persistencia.ManejoArchivos;

/**
 * @author Pablo Ariza y Alejandro Castro
 */
/**
 * Unico punto del sistema donde se pueden solicitar e imprimir informacion.
 * Declara e instancia una variable de tipo EmpresaAmbulancias y maneja un menu
 * para ofrecer al usuario los servicios del sistema.
 */
public class TestAmbulacia {

	/**
	 * @param args:
	 *            Indica los argumentos de inicio del programa
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		EmpresaAmbulancias empresaAmbulancias = new EmpresaAmbulancias("AAA");
		Scanner input = new Scanner(System.in);
		do {
			opcion = menuSistema();
			if (opcion > 12 || opcion < 0)
				System.out.println("Opcion invalida. Ingrese una opcion valida.");
			else {
				switch (opcion) {
				case 1:
					// ingresar la IPS al sistema
					ingresarIpsAlsistema(empresaAmbulancias);
					break;
				case 2:
					// ingresar las ambulancias al sistema
					ingresarAmbulanciasAlSistema(empresaAmbulancias);
					break;
				case 3:
					// registrar la posicion actual de una ambulancia
					registrarPosicionAmbulancia(empresaAmbulancias, input);
					break;
				case 4:
					// registrar un servicio
					registrarServicio(empresaAmbulancias, input);
					break;
				case 5:
					// reporte de ambulancias
					reporteAmbulancias(empresaAmbulancias, input);
					break;
				case 6:
					// asignar a un servicio una ambulancia y una IPS
					asignarServicio(empresaAmbulancias, input);
					break;
				case 7:
					// finalizar un servicio
					finalizarServicio(empresaAmbulancias, input);
					break;
				case 8:
					// reporte de servicios con IPS y ambulancias asignados.
					reporteServiciosIpsAmbulancia(empresaAmbulancias, input);
					break;
				case 9:
					// Reporte IPS con servicios asociados
					reporteIpsServicios(empresaAmbulancias, input);
					break;
				case 10:
					// Estadisticas de las ambulancias disponibles
					estadisticasAmbulanciasDisponibles(empresaAmbulancias);
					break;
				case 11:
					// Pacientes atendidos
					pacientesAtendidos(empresaAmbulancias, input);
					break;
				}
			}
		} while (opcion != 12);

		input.close();
	}

	/**
	 * Opcion 11 del Sistema: reporte de Pacientes atendidos ordenado por
	 * horaSolicitud
	 *
	 * @param empresaAmbulancias:
	 *            Indica el objeto de tipo EmpresaAmbulancia que significa el
	 *            sistema
	 */
	private static void pacientesAtendidos(EmpresaAmbulancias empresaAmbulancias, Scanner input) {
		if (!empresaAmbulancias.getServicios().isEmpty()) {
			Collections.sort(empresaAmbulancias.getServicios(), new HoraSolicitudComparator());
			System.out.printf("\n%-13s %-18s %-12s %-8s %-15s %-10s  %-10s\n", "horaSolicitud", "Paciente",
					"tipoServicio", "telefono", "direccion", "Estado", "Medico/Enfermero");
			System.out.println(
					"------------------------------------------------------------------------------------------------");
			for (Servicio servicio : empresaAmbulancias.getServicios()) {
				System.out.printf("%s\n", servicio.toStringD());
			}
			System.out.printf("\nPresione enter para continuar.");
			input.nextLine();
			System.out.println();
		} else {
			System.out.println("No existen Servicios registrados.");
			System.out.printf("Presione enter para continuar.");
			input.nextLine();
			System.out.println();
		}
	}
	// Metodo auxiliar para cada opcion del menu.

	/**
	 * Opcion 10 del Sistema: Estadisticas de las ambulancias Disponibles Se
	 * contabiliza cuantas ambulancias de cada tipo hay y se imprime un informe
	 *
	 * @param empresaAmbulancias:
	 *            Indica el objeto de tipo EmpresaAmbulancia que significa el
	 *            sistema
	 */
	private static void estadisticasAmbulanciasDisponibles(EmpresaAmbulancias empresaAmbulancias) {
		int ambulanciasBasicas = 0;
		int ambulanciasUCI = 0;
		int ambulanciasNoMedicalizadas = 0;
		Set<Integer> llaves = empresaAmbulancias.getAmbulancias().keySet();
		for (Integer llave : llaves) {
			if (!empresaAmbulancias.getAmbulancias().get(llave).getEnServicio()) {
				if (empresaAmbulancias.getAmbulancias().get(llave) instanceof AmbulanciaBasica)
					ambulanciasBasicas++;
				if (empresaAmbulancias.getAmbulancias().get(llave) instanceof AmbulanciaNoMedicalizada)
					ambulanciasNoMedicalizadas++;
				if (empresaAmbulancias.getAmbulancias().get(llave) instanceof AmbulanciaUCI)
					ambulanciasUCI++;
			}
		}
		System.out.println("\n---Estadisticas de las ambulancias disponibles");
		System.out.printf("Cantidad de ambulancias basicas: %d\n", ambulanciasBasicas);
		System.out.printf("Cantidad de ambulancias no medicalizadaas: %d\n", ambulanciasNoMedicalizadas);
		System.out.printf("Cantidad de ambulancias UCI: %d\n\n", ambulanciasUCI);
	}

	/**
	 * Opcion 9 del Sistema: Reporte de las IPS con los servicios asociados
	 *
	 * @param empresaAmbulancias:
	 *            Representa el objeto de tipo EmpresaAmbulancias que representa
	 *            el sistema
	 * @param input:
	 *            Scanner para leer datos
	 */
	private static void reporteIpsServicios(EmpresaAmbulancias empresaAmbulancias, Scanner input) {
		System.out.printf("--REPORTE DE LAS IPS CON SERVICIOS ASOCIADOS");
		Map<String, IPS> ips = empresaAmbulancias.getLasIPS();
		if (!ips.isEmpty()) {
			Set<String> ipsNombres = empresaAmbulancias.getLasIPS().keySet();
			List<String> listIps = new ArrayList<String>(ipsNombres);
			Collections.sort(listIps);
			for (String ipsNombre : listIps) {
				System.out.println("\nIPS: nombre                 tipoAtencion           direccion");
				System.out.printf("   %s\n", ips.get(ipsNombre).toString());
				System.out.println("\n   SERVICIOS:");
				System.out.println(
						"   codigo horaSolicitud  paciente   tipoServicio telefono direccion          estado ambul.");
				System.out.println(
						"   --------------------------------------------------------------------------------------------");
				if (!ips.get(ipsNombre).getServicios().isEmpty()) {
					List<Servicio> listServicio = ips.get(ipsNombre).getServicios();
					Collections.sort(listServicio, new HoraSolicitudComparator());
					for (Servicio servicio : ips.get(ipsNombre).getServicios()) {
						System.out.printf("   %s\n", servicio.toStringB());
					}
				} else
					System.out.println("   Sin servicios asignado");

			}
		} else
			System.out.println("\n\nNo hay IPS registrada");
		System.out.printf("Presione enter para continuar.");
		input.nextLine();
		System.out.println();
	}

	/**
	 * Opcion 8 del Sistema: Reporte de Servicios con la IPS y la Ambulancia
	 * asociada
	 *
	 * @param empresaAmbulancias:
	 *            Representa el objeto de tipo EmpresaAmbulancias que representa
	 *            el sistema
	 * @param input:
	 *            Scanner para leer datos
	 */
	private static void reporteServiciosIpsAmbulancia(EmpresaAmbulancias empresaAmbulancias, Scanner input) {
		System.out.println("--REPORTE DE SERVICIOS CON IPS Y AMBULANCIAS ASOCIADAS");
		if (!empresaAmbulancias.getServicios().isEmpty()) {
			for (Servicio servicio : empresaAmbulancias.getServicios()) {
				System.out.println("\nSERVICIO:");
				System.out.printf("%-6s %-14s %-18s %-12s %-9s %-16s %-10s %-10s\n", "codigo", "horaSolicitud",
						"paciente", "tipoServicio", "telefono", "direccion", "estado", "valor");
				System.out.println(
						"------------------------------------------------------------------------------------------------------");
				if (servicio.getEstado().equals("NO_ASIGNADO"))
					System.out.printf("%s\n", servicio.toString());
				else
					System.out.printf("%s %-10d\n", servicio.toString(), servicio.getAmbulancia().calcularTarifa());
				if (!servicio.getTipoServicio().equals("DOMICILIO"))
					if (servicio.getIps() != null) {
						System.out.println("\n\tIPS asignada:");
						System.out.println("\tnombre                 tipoAtencion           direccion");
						System.out.println(
								"\t--------------------------------------------------------------------------------");
						System.out.printf("\t%s\n", servicio.getIps().toString());
						System.out.println("\n\tAmbulancia asignada:");
						System.out.printf("\t%-6s %-8s %-12s %-13s %-16s  %-20s %-16s\n", "codigo", "placa",
								"horaPosicion", "posicionCalle", "posicionCarrera", "medico/enfermero", "tipoUCI");
						System.out.println(
								"\t-----------------------------------------------------------------------------------------------");
						System.out.printf("\t%s\n", servicio.getAmbulancia().toStringC());
					} else
						System.out.println("\nAl servicio no se le han asignado la IPS y la Ambulancias");
				else {
					if (servicio.getAmbulancia() != null) {
						System.out.println("\n\tAmbulancia asignada:");
						System.out.printf("\t%-6s %-8s %-12s %-13s %-16s  %-20s %-16s\n", "codigo", "placa",
								"horaPosicion", "posicionCalle", "posicionCarrera", "medico/enfermero", "tipoUCI");
						System.out.println(
								"\t------------------------------------------------------------------------------");
						System.out.printf("\t%s\n", servicio.getAmbulancia().toStringC());
					}
				}
			}
		} else
			System.out.println("\nNo se han registrado servicio\n");
		System.out.printf("Presione enter para continuar.");
		input.nextLine();
		System.out.println();
	}

	/**
	 * Opcion 7 del Sistema: Funcionalidad para finalizar un servicio
	 *
	 * @param empresaAmbulancias:
	 *            Representa el objeto de tipo EmpresaAmbulancias que representa
	 *            el sistema
	 * @param input:
	 *            Scanner para leer datos
	 */
	private static void finalizarServicio(EmpresaAmbulancias empresaAmbulancias, Scanner input) {
		System.out.println("--FINALIZAR UN SERVICIO");
		if (!empresaAmbulancias.getServicios().isEmpty()) {
			// TOSTRING PARA ENCABEZADO
			System.out.println("Codigo    Paciente           Ambulancia         IPS");
			System.out.println("----------------------------------------------------------------------------");
			// Impresion de los pacientes asignados del sistema
			for (Servicio servicio : empresaAmbulancias.getServicios()) {
				if (servicio.getEstado().equals("ASIGNADO")) {
					System.out.printf("%s\n", servicio.toStringC());
				}
			}
			System.out.println("--cual es el codigo del servicio que desea finalizar ? :");
			// leer codigo del Servicio
			int codigoAFinalizar = input.nextInt();
			// Finalizar Servicio
			if (empresaAmbulancias.finalizarServicio(codigoAFinalizar)) {
				System.out.println("Exito al finalizar el servicio: " + codigoAFinalizar);
			} else {
				System.out.println("Fallo al finalizar el servicio: " + codigoAFinalizar);
			}
		} else
			System.out.println("\nNo se han registrado servicio");
		input.nextLine();
		System.out.println();
	}

	/**
	 * Opcion 6 del Sistema: Funcionalidad para que se asigne la ambulancia e
	 * IPS mas cercana al servicio
	 *
	 * @param empresaAmbulancias:
	 *            Representa el objeto de tipo EmpresaAmbulancias que representa
	 *            el sistema
	 * @param input:
	 *            Scanner para leer datos
	 */
	private static void asignarServicio(EmpresaAmbulancias empresaAmbulancias, Scanner input) {
		System.out.println("--ASIGNAR UN SERVICIO A UNA AMBULANCIA Y A UNA IPS");
		if (!empresaAmbulancias.getServicios().isEmpty()) {
			System.out.println("codigo horaSolicitud  paciente     tipoServicio telefono direccion ");
			System.out.println("----------------------------------------------------------------------------");
			for (Servicio servicio : empresaAmbulancias.getServicios()) {
				if (servicio.getEstado().equals("NO_ASIGNADO")) {
					System.out.printf("%s\n", servicio.toString());
				}
			}
			System.out.println("--cual es el codigo del servicio que desea asignar ? :");
			long servicio = input.nextLong();
			if (!empresaAmbulancias.getServicios().get((int) servicio - 1).getEstado().equals("FINALIZADO"))
				System.out.println(empresaAmbulancias.asignarServicio(servicio));
			else
				System.out.println("El servicio ya fue asignado");
		} else
			System.out.println("\nNo se han registrado servicio");
		System.out.println();
	}

	/**
	 * Opcion 5 del Sistema: Reporte de Ambulancias
	 *
	 * @param empresaAmbulancias:
	 *            Representa el objeto de tipo EmpresaAmbulancias que representa
	 *            el sistema
	 * @param input:
	 *            Scanner para leer datos
	 */
	private static void reporteAmbulancias(EmpresaAmbulancias empresaAmbulancias, Scanner input) {
		System.out.println("--REPORTE DE LAS AMBULANCIAS DEL SISTEMA\n");
		if (!empresaAmbulancias.getAmbulancias().isEmpty()) {
			Set<Integer> llaves = empresaAmbulancias.getAmbulancias().keySet();
			List<Integer> orLlaves = new ArrayList<Integer>(llaves);
			Collections.sort(orLlaves, new CodigoComparator());
			System.out.printf("%-6s %-6s %-12s %-13s %-15s %-6s  %-20s %-16s\n", "codigo", "placa", "horaPosicion",
					"posicionCalle", "posicionCarrera", "codigo", "medico/enfermero", "tipoUCI");
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------");
			for (Integer llave : orLlaves) {
				System.out.printf("%s\n", empresaAmbulancias.getAmbulancias().get(llave).toString());
			}
		} else {
			System.out.println("No se han registrado las ambulancias");
		}
		System.out.printf("Presione enter para continuar.");
		input.nextLine();
		System.out.println();
	}

	/**
	 * Opcion 4 del Sistema: Funcionalidad para registrar un servicio al sistema
	 *
	 * @param empresaAmbulancias:
	 *            Representa el objeto de tipo EmpresaAmbulancias que representa
	 *            el sistema
	 * @param input:
	 *            Scanner para leer datos
	 */
	private static void registrarServicio(EmpresaAmbulancias empresaAmbulancias, Scanner input) {
		int calle;
		int carrera;
		long codigoServicio;
		System.out.println("--REGISTRAR SERVICIO indique: paciente tipoServicio(URGENCIA, EMERGENCIA o DOMICILIO)");
		System.out.println("            telefono  tipoDireccion(CALLE o CARRERA)  calle  carrera  numero");
		String paciente = input.nextLine();
		if (paciente.equals(""))
			paciente = input.nextLine();
		String tipoServicio = input.next();
		String telefono = input.next();
		String tipoDireccion = input.next();
		calle = input.nextInt();
		carrera = input.nextInt();
		int numero = input.nextInt();
		if ((tipoServicio.equals("URGENCIA") || tipoServicio.equals("EMERGENCIA") || tipoServicio.equals("DOMICILIO"))
				&& (tipoDireccion.equals("CALLE") || tipoDireccion.equals("CARRERA"))) {
			codigoServicio = empresaAmbulancias.registrarServicio(paciente, tipoServicio, telefono, tipoDireccion,
					calle, carrera, numero);
			System.out.printf("El nuevo Servicio tiene codigo %d\n", codigoServicio);
		} else
			System.out.println("Fallo en el registro del servicio");
		input.nextLine();
		System.out.println();
	}

	/**
	 * Opcion 3 del Sistema: Funcionalidad para registrar la posicion de una
	 * ambulancia en el sistema
	 *
	 * @param empresaAmbulancias:
	 *            Representa el objeto de tipo EmpresaAmbulancias que representa
	 *            el sistema
	 * @param input:
	 *            Scanner para leer datos
	 */
	private static void registrarPosicionAmbulancia(EmpresaAmbulancias empresaAmbulancias, Scanner input) {
		int calle;
		int carrera;
		int codigo;
		if (!empresaAmbulancias.getAmbulancias().isEmpty()) {
			System.out.println("--REGISTRAR POSICION DE AMBULANCIA indique: codigo calle carrera");
			codigo = input.nextInt();
			calle = input.nextInt();
			carrera = input.nextInt();
			if (empresaAmbulancias.registrarPosicionAmbulancia(codigo, calle, carrera))
				System.out.println("Exito en el registro de la posicion.");
			else
				System.out.println("Fallo en el registro de la posicion.");
			System.out.println();
		} else
			System.out.println("No hay ambulancias registrada\n");
	}

	/**
	 * Funcion 2 del Sistema: Funcionalidad para cargar las Ambulancias al
	 * sistema
	 *
	 * @param empresaAmbulancias:
	 *            Representa el objeto de tipo EmpresaAmbulancias que representa
	 *            el sistema
	 */
	private static void ingresarAmbulanciasAlSistema(EmpresaAmbulancias empresaAmbulancias) {
		ManejoArchivos.cargarLasAmbulancias(empresaAmbulancias);
		System.out.println();
	}

	/**
	 * Funcion 3 del Sistema: Funcionalidad para cargar las IPS al sistema
	 *
	 * @param empresaAmbulancias:
	 *            Representa el objeto de tipo EmpresaAmbulancias que representa
	 *            el sistema
	 */
	private static void ingresarIpsAlsistema(EmpresaAmbulancias empresaAmbulancias) {
		ManejoArchivos.cargarLasIPS(empresaAmbulancias);
		System.out.println();
	}

	/**
	 * Menu de las funcionalidades del sistema y captura de la opcion deseada
	 *
	 * @return int: retorna la opcion escogida por el usuario
	 */
	public static int menuSistema() {
		int opcion;
		Scanner input = new Scanner(System.in);
		System.out.println("opcion 1: ingresar la IPS al sistema.");
		System.out.println("opcion 2: ingresar las ambulancias al sistema. ");
		System.out.println("opcion 3: registrar la posicion actual de una ambulancia. ");
		System.out.println("opcion 4: registrar un servicio. ");
		System.out.println("opcion 5: reporte de ambulancias. ");
		System.out.println("opcion 6: asignar a un servicio una ambulancia y una IPS. ");
		System.out.println("opcion 7: finalizar un servicio. ");
		System.out.println("opcion 8: reporte de servicios con IPS y ambulancias asignados. ");
		System.out.println("opcion 9: reporte de las IPS con servicios asociados. ");
		System.out.println("opcion 10: estadisticas de las ambulancias disponibles. ");
		System.out.println("opcion 11: pacientes atendidos. ");
		System.out.println("opcion 12: terminar");
		System.out.printf("Opcion:");
		opcion = input.nextInt();
		return opcion;
	}
}
