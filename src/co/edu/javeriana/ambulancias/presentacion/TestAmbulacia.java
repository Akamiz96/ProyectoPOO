/**
 *
 */
package co.edu.javeriana.ambulancias.presentacion;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import co.edu.javeriana.ambulancias.negocio.Ambulancia;
import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
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
					break;
				case 11:
					// Pacientes atendidos
					break;
				}
			}
		} while (opcion != 12);

		input.close();
	}
	// Metodo auxiliar para cada opcion del menu.

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
			for (String ipsNombre : ipsNombres) {
				System.out.println("\nIPS: nombre                 tipoAtencion           direccion");
				System.out.printf("   %s\n", ips.get(ipsNombre).toString());
				System.out.println("\n   SERVICIOS:");
				System.out.println(
						"   codigo horaSolicitud  paciente   tipoServicio telefono direccion          estado ambul.");
				System.out.println(
						"   --------------------------------------------------------------------------------------");
				if (!ips.get(ipsNombre).getServicios().isEmpty()) {
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
				System.out.println(
						"codigo horaSolicitud  paciente         tipoServicio telefono  direccion        estado");
				System.out.println(
						"--------------------------------------------------------------------------------------");
				if (servicio.getEstado().equals("NO_ASIGNADO"))
					System.out.printf("%s %s\n", servicio.toString(), servicio.getEstado());
				else
					System.out.printf("%s\n", servicio.toString());
				if (servicio.getIps() != null) {
					System.out.println("\tIPS asignada:");
					System.out.println("\tnombre                 tipoAtencion           direccion");
					System.out.println(
							"\t--------------------------------------------------------------------------------");
					System.out.printf("\t%s\n", servicio.getIps().toString());
					System.out.println("\tAmbulancia asignada:");
					System.out.println("\tcodigo placa    tipoDotacion   horaPosicion posicionCalle posicionCarrera");
					System.out.println(
							"\t------------------------------------------------------------------------------");
					System.out.printf("\t%s\n", servicio.getAmbulancia().toStringC());
				} else
					System.out.println("\nAl servicio no se le han asignado la IPS y la Ambulancias");
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
			System.out.println(empresaAmbulancias.asignarServicio(input.nextLong()));
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
			System.out.println("codigo placa    tipoDotacion   horaPosicion posicionCalle posicionCarrera servicio");
			System.out.println("-----------------------------------------------------------------------------------");
			for (Integer llave : llaves) {
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
		System.out.println("--REGISTRAR SERVICIO indique: paciente tipoServicio(URGENCIA o EMERGENCIA)");
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
		long codigoServicio = empresaAmbulancias.registrarServicio(paciente, tipoServicio, telefono, tipoDireccion,
				calle, carrera, numero);
		System.out.printf("El nuevo Servicio tiene codigo %d\n", codigoServicio);
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
