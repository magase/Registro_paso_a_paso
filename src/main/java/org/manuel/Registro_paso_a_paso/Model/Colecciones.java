package org.manuel.Registro_paso_a_paso.Model;

import java.util.LinkedHashMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author alumno
 *
 */
public class Colecciones {
	
	/**
	 * 	Creo el SortedMap listaGenerosOrdenada
	 */
	public static SortedMap<String, String> listaGenerosOrdenada = new TreeMap<>();
	/**
	 *  Creo el SortedMap listaPaisesOrdenada
	 */
	public static SortedMap<String, String> listaPaisesOrdenada = new TreeMap<>();
	/**
	 *  Creo el SortedMap listaDepartamentos
	 */
	public static SortedMap<String, String> listaDepartamentos = new TreeMap<>();
	/**
	 * Creo el LinkedHashMap datosFragmen
	 */
	public static LinkedHashMap<String, String>  datosFragment = new LinkedHashMap<>();
	static {
		// se definen las colecciones necesarias para pintar la vista
	
		listaGenerosOrdenada.put("h", "Hombre");
		listaGenerosOrdenada.put("m", "Mujer");
		listaGenerosOrdenada.put("o", "Otro");
		
		listaPaisesOrdenada.put("ES", "Española");
		listaPaisesOrdenada.put("FR", "Francesa");
		listaPaisesOrdenada.put("IT", "Italiana");
		listaPaisesOrdenada.put("PT", "Portuguesa");
		
		listaDepartamentos.put("D", "Desarrollo");
		listaDepartamentos.put("M", "Marketing");
		listaDepartamentos.put("R", "RRHH");
		
		datosFragment.put("DatosPersonales", "Number-1-icon.png");
		datosFragment.put("DatosProfesionales", "Number-2-icon.png");
		datosFragment.put("DatosBancarios", "Number-3-icon.png");
		datosFragment.put("Resumen", "checkered-flag-icon.png");
	}
}