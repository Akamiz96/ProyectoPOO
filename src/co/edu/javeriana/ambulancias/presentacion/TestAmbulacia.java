/**
 *
 */
package co.edu.javeriana.ambulancias.presentacion;

import java.util.Scanner;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.negocio.IPS;
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
		//System.out.println("Escriba el nombre del archivo: ");
		do {
			opcion = menuSistema();
			if (opcion > 10)
				System.out.println("Opcion invalida. Ingrese una opcion valida.");
			else {
				switch (opcion) {
				case 1:
					// ingresar la IPS al sistema
					ManejoArchivos.cargarLasIPS(empresaAmbulancias);
					for(IPS ips : empresaAmbulancias.getLasIPS()){
						System.out.printf("%s", ips.toString());
					}
					break;
				case 2:
					// ingresar las ambulancias al sistema
					ManejoArchivos.cargarLasAmbulancias(empresaAmbulancias);
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
					break;
				case 4:
					// registrar un servicio
					System.out.println("--REGISTRAR SERVICIO indique: paciente tipoServicio(URGENCIA o EMERGENCIA)");
					System.out.println("          telefono  tipoDireccion(CALLE o CARRERA)  calle  carrera  numero");
					String paciente = input.nextLine().trim();
					String tipoServicio = input.next();
					String telefono = input.next();
					String tipoDireccion = input.next();
					calle = input.nextInt();
					carrera = input.nextInt();
					int numero = input.nextInt();
					long codigoServicio = empresaAmbulancias.registrarServicio(paciente, tipoServicio, telefono,
							tipoDireccion, calle, carrera, numero);
					System.out.printf("El nuevo Servicio tiene codigo %d", codigoServicio);
					break;
				case 5:
					// reporte de ambulancias
					break;
				case 6:
					// asignar a un servicio una ambulancia y una IPS
					break;
				case 7:
					// finalizar un servicio
					break;
				case 8:
					// reporte de servicios con IPS y ambulancias asignados
					break;
				case 9:
					// reporte de las IPS con servicios asociados
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
