/**
 *
 */
package co.edu.javeriana.ambulancias.presentacion;

import java.util.Scanner;

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
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		EmpresaAmbulancias empresaAmbulancias = new EmpresaAmbulancias("AAA");
		Scanner input = new Scanner(System.in);
		do {
			opcion = menuSistema();
			if (opcion > 10 || opcion < 0)
				System.out.println("Opcion invalida. Ingrese una opcion valida.");
			else {
				switch (opcion) {
				case 1:
					// ingresar la IPS al sistema
					ManejoArchivos.cargarLasIPS(empresaAmbulancias);
					System.out.println();
					break;
				case 2:
					// ingresar las ambulancias al sistema
					ManejoArchivos.cargarLasAmbulancias(empresaAmbulancias);
					System.out.println();
					break;
				case 3:
					// registrar la posicion actual de una ambulancia
					System.out.println("--REGISTRAR POSICION DE AMBULANCIA indique: codigo calle carrera");
					int codigo = input.nextInt();
					int carrera = input.nextInt();
					int calle = input.nextInt();
					if (empresaAmbulancias.registrarPosicionAmbulancia(codigo, calle, carrera))
						System.out.println("Exito en el registro de la posicion.");
					else
						System.out.println("Fallo en el registro de la posicion.");
					System.out.println();
					break;
				case 4:
					// registrar un servicio
					System.out.println("--REGISTRAR SERVICIO indique: paciente tipoServicio(URGENCIA o EMERGENCIA)");
					System.out.println("            telefono  tipoDireccion(CALLE o CARRERA)  calle  carrera  numero");
					String paciente = input.next() + " " + input.next();
					String tipoServicio = input.next();
					String telefono = input.next();
					String tipoDireccion = input.next();
					calle = input.nextInt();
					carrera = input.nextInt();
					int numero = input.nextInt();
					long codigoServicio = empresaAmbulancias.registrarServicio(paciente, tipoServicio, telefono,
							tipoDireccion, calle, carrera, numero);
					System.out.printf("El nuevo Servicio tiene codigo %d\n", codigoServicio);
					input.nextLine();
					System.out.println();
					break;
				case 5:
					// reporte de ambulancias
					System.out.println("--REPORTE DE LAS AMBULANCIAS DEL SISTEMA\n");
					System.out.println(
							"codigo placa    tipoDotacion   horaPosicion posicionCalle posicionCarrera servicio");
					System.out.println(
							"-----------------------------------------------------------------------------------");
					for (Ambulancia ambulancia : empresaAmbulancias.getAmbulancias()) {
						System.out.printf("%s\n", ambulancia.toString());
					}
					input.nextLine();
					System.out.println();
					break;
				case 6:
					// asignar a un servicio una ambulancia y una IPS
					System.out.println("--ASIGNAR UN SERVICIO A UNA AMBULANCIA Y A UNA IPS");
					System.out.println("--se muestran los servicios del sistema sin asignar: ");
					System.out.println("codigo horaSolicitud  paciente     tipoServicio telefono direccion ");
					System.out.println("----------------------------------------------------------------------------");
					for (Servicio servicio : empresaAmbulancias.getServicios()) {
						if (servicio.getEstado().equals("NO_ASIGNADO")) {
							System.out.printf("%s\n", servicio.toString());
						}
					}
					System.out.println("--cual es el codigo del servicio que desea asignar ? :");
					System.out.println(empresaAmbulancias.asignarServicio(input.nextLong()));
					System.out.println();
					break;
				case 7:
					// finalizar un servicio
					System.out.println("--FINALIZAR UN SERVICIO");
					System.out.println("--se muestran los servicios del sistema asignados :");
					// TOSTRING PARA ENCABEZADO
					System.out.println("----------------------------------------------------------------------------");
					// Impresion de los pacientes asignados del sistema
					System.out.println("--cual es el codigo del servicio que desea finalizar ? :");
					// leer codigo del Servicio
					// Finalizar Servicio
					// Servicio servicioAFinalizar =
					// empresaAmbulancias.buscarServicio(codigo);
					// if(servicioAFinalizar!=null)
					// else
					input.nextLine();
					System.out.println();
					break;
				case 8:
					System.out.println("--REPORTE DE SERVICIOS CON IPS Y AMBULANCIAS ASOCIADAS");
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
							System.out.println(
									"\tcodigo placa    tipoDotacion   horaPosicion posicionCalle posicionCarrera");
							System.out.println(
									"\t------------------------------------------------------------------------------");
							System.out.printf("\t%s\n", servicio.getAmbulancia().toStringC());
						}
					}
					input.nextLine();
					System.out.println();
					break;
				case 9:
					System.out.printf("--REPORTE DE LAS IPS CON SERVICIOS ASOCIADOS");
					for (IPS ips : empresaAmbulancias.getLasIPS()) {
						System.out.println("\nIPS: nombre                 tipoAtencion           direccion");
						System.out.printf("   %s\n", ips.toString());
						if (!ips.getServicios().isEmpty()) {
							System.out.println("   SERVICIOS:");
							System.out.println(
									"   codigo horaSolicitud  paciente   tipoServicio telefono direccion          estado ambul.");
							System.out.println(
									"   --------------------------------------------------------------------------------------");
							for (Servicio servicio : ips.getServicios()) {
								System.out.printf("   %s\n", servicio.toStringB());
							}
						}
					}
					input.nextLine();
					System.out.println();
					break;
				}
			}
		} while (opcion != 10);

		input.close();
	}
	// Metodo auxiliar para cada opcion del menu.

	/**
	 * Menu de las funcionalidades del sistema y captura de la opcion deseada
	 */
	public static int menuSistema() {
		int opcion;
		Scanner input = new Scanner(System.in);
		System.out.println("opcion 1 : ingresar la IPS al sistema.");
		System.out.println("opcion 2: ingresar las ambulancias al sistema. ");
		System.out.println("opcion 3: registrar la posicion actual de una ambulancia. ");
		System.out.println("opcion 4: registrar un servicio. ");
		System.out.println("opcion 5: reporte de ambulancias. ");
		System.out.println("opcion 6: asignar a un servicio una ambulancia y una IPS. ");
		System.out.println("opcion 7: finalizar un servicio. ");
		System.out.println("opcion 8: reporte de servicios con IPS y ambulancias asignados. ");
		System.out.println("opcion 9: reporte de las IPS con servicios asociados. ");
		System.out.println("opcion 10: terminar");
		System.out.printf("Opcion:");
		opcion = input.nextInt();
		return opcion;
	}
}
