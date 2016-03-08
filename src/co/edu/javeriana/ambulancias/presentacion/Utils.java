/**
 *
 */
package co.edu.javeriana.ambulancias.presentacion;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 * @author Pablo Ariza y Alejandro Castro
 *
 */
public class Utils {
	/**
	 * Convierte una fecha String en una instancia de la clase GregorianCalendar
	 *
	 * @param fecha
	 *            Estilo YYYY-MM-DD
	 * @return fecha Instancia de GregorianCalendar
	 * @see GregorianCalendar
	 */
	public static GregorianCalendar convertirStringFecha(String fecha) {
		StringTokenizer tokens = new StringTokenizer(fecha, "-");
		String aux = tokens.nextToken();
		int anio, mes, dia;
		anio = Integer.parseInt(aux);
		aux = tokens.nextToken();
		mes = Integer.parseInt(aux) - 1;
		aux = tokens.nextToken();
		dia = Integer.parseInt(aux);
		GregorianCalendar fechaG = new GregorianCalendar(anio, mes, dia);
		return fechaG;
	}

	/**
	 * Convierte una fecha GregorianCalendar en un String
	 *
	 * @param fecha
	 *            de tipo GregorianCalendar
	 * @return String "AAAA-MM-DD"
	 * @see GregorianCalendar
	 */
	public static String convertirFechaString(GregorianCalendar fecha) {
		int dia = fecha.get(Calendar.DATE);
		int mes = fecha.get(Calendar.MONTH) + 1;
		int anio = fecha.get(Calendar.YEAR);
		return anio + "-" + mes + "-" + dia;
	}

	/**
	 * @param fecha
	 * @return String "HH:MM"
	 */
	public static String convertirFechaHoraString(GregorianCalendar fecha) {
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int min = fecha.get(Calendar.MINUTE);
		if(min<10)
			return hora + ":0" + min;
		else
			return hora + ":" + min;
	}
}
