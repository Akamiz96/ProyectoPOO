/**
 * 
 */
package co.edu.javeriana.ambulancias.presentacion;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 * @author Pablo
 *
 */
public class Utils {
	/**
	 * @param fecha Estilo YYYY-MM-DD
	 * @return fechaG Instancia de GregorianCalendar 
	 */
	public static GregorianCalendar convertirStringFecha (String fecha)
	{
		StringTokenizer tokens = new StringTokenizer(fecha,"-");
		String aux = tokens.nextToken();
		int anio, mes, dia;
		anio = Integer.parseInt(aux);
		aux = tokens.nextToken();
		mes = Integer.parseInt(aux)-1;
		aux = tokens.nextToken();
		dia = Integer.parseInt(aux);
		GregorianCalendar fechaG = new GregorianCalendar(anio, mes, dia);
		return fechaG;
	}
	/**
	 * @param fecha de tipo GregorianCalendar 
	 * @return String "AAAA-MM-DD"
	 */
	public static String convertirFechaString (GregorianCalendar fecha)
	{
		int dia = fecha.get(Calendar.DATE);
		int mes = fecha.get(Calendar.MONTH)+1;
		int anio = fecha.get(Calendar.YEAR);
		return anio+"-"+mes+"-"+dia;
	}
}
