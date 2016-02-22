/**
 *
 */
package co.edu.javeriana.ambulancias.presentacion;

import java.util.Scanner;

import co.edu.javeriana.ambulancias.negocio.EmpresaAmbulancias;
import co.edu.javeriana.ambulancias.persistencia.ManejoArchivos;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class TestAmbulacia {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		EmpresaAmbulancias empresaAmbulancias;
		Scanner input = new Scanner(System.in);
		System.out.println("Escriba el nombre del archivo: ");
		do {
			opcion = menuSistema();
			if (opcion > 5)
				System.out
						.println("Opcion invalida. Ingrese una opcion valida.");
			else {
				switch (opcion) {
				case 1:
					empresaAmbulancias = ManejoArchivos.cargarLasIPS(empresaAmbulancias);
					break;
				case 2:

					break;
				case 3:

					break;
				case 4:

					break;
				}
			}
		} while (opcion != 5);

		input.close();
	}

	/**
	 * �nico punto del sistema donde se pueden solicitar e imprimir informaci�n.
	 * Declara e instancia una variable de tipo EmpresaAmbulancias y maneja un
	 * men� para ofrecer al usuario los servicios del sistema.
	 */
	// M�todo auxiliar para cada opci�n del men�.

	/**
	 * Men� de las funcionalidades del sistema
	 */
	public static int menuSistema() {
		int opcion;
		Scanner input = new Scanner(System.in);
		System.out.println("opcion 1 : ingresar la IPS al sistema.");
		System.out.println("opcion 2: ingresar las ambulancias al sistema");
		System.out
				.println("opcion 3: registrar la posicion actual de una ambulancia");
		System.out.println("opcion 4: registrar un servicio");
		System.out.println("opcion 5: reporte de ambulancias");
		System.out
				.println("opcion 6: asignar a un servicio una ambulancia y una IPS");
		System.out.println("opcion 7: finalizar un servicio");
		System.out
				.println("opcion 8: reporte de servicios con IPS y ambulancias asignados");
		System.out
				.println("opcion 9: reporte de las IPS con servicios asociados");
		System.out.println("opcion 10: terminar");
		opcion = input.nextInt();
		return opcion;
	}
}
