package org.manuel.Registro_paso_a_paso.Controller;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.manuel.Registro_paso_a_paso.Model.Colecciones;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/**
 * @author alumno
 *
 */
@Controller
@RequestMapping("/registro")
public class Controlador {

	/**

	 * @param model 
	 * @param sesionHttp 
	 * @return mAV
	 */
	@GetMapping("DatosPersonales")
	public ModelAndView recibirDatosPersonales(
			Model model,
			HttpSession sesionHttp) {
		ModelAndView mAV = new ModelAndView();
		String nombre = (String) sesionHttp.getAttribute("nombre");  
		String apellidos = (String) sesionHttp.getAttribute("apellidos");  
		String fechaNacimiento = (String) sesionHttp.getAttribute("fechaNacimiento");  
		String generoSeleccionado = (String) sesionHttp.getAttribute("generoSeleccionado");  
		String casado = (String) sesionHttp.getAttribute("casado");  
		String hijos = (String) sesionHttp.getAttribute("hijos");  
		String paises = (String) sesionHttp.getAttribute("paises");  

		
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("apellidos", apellidos);
		model.addAttribute("fechaNacimiento", fechaNacimiento);
		model.addAttribute("generoSeleccionado",  generoSeleccionado);
		model.addAttribute("casado",  casado);
		model.addAttribute("hijos",  hijos);
		model.addAttribute("paises",  paises);
		mAV.addObject("listaGenerosOrdenada", Colecciones.listaGenerosOrdenada);
		mAV.addObject("listaPaisesOrdenada", Colecciones.listaPaisesOrdenada);
		mAV.addObject("datosFragment", Colecciones.datosFragment);
		mAV.addObject("paso", "DatosPersonales");
		mAV.setViewName("DatosPersonales");
		return mAV;
	}

	/**
	 * @param solicitudHttp
	 * @param respuestaHttp 
	 * @return mAV
	 */
	@PostMapping("DatosPersonales")
	public ModelAndView enviarDatosPersonales(
				HttpServletRequest solicitudHttp,
				HttpServletResponse respuestaHttp) {
		
		ModelAndView mAV = new ModelAndView();
		HttpSession session = solicitudHttp.getSession();
		String nombre = solicitudHttp.getParameter("nombre");  
		String apellidos = solicitudHttp.getParameter("apellidos"); 
		String  fechaNacimiento = solicitudHttp.getParameter("fechaNacimiento"); 
		String  generoSeleccionado = solicitudHttp.getParameter("generoSeleccionado"); 
		String  casado = solicitudHttp.getParameter("casado"); 
		String  hijos = solicitudHttp.getParameter("hijos"); 
		String  paises = solicitudHttp.getParameter("paises"); 

		
		
		session.setAttribute("nombre", nombre);
		session.setAttribute("apellidos", apellidos);
		session.setAttribute("fechaNacimiento", fechaNacimiento);
		session.setAttribute("generoSeleccionado", generoSeleccionado);
		session.setAttribute("casado", casado);
		session.setAttribute("hijos", hijos);
		session.setAttribute("paises", paises);
		
		mAV.addObject("listaGenerosOrdenada", Colecciones.listaGenerosOrdenada);
		mAV.addObject("listaPaisesOrdenada", Colecciones.listaPaisesOrdenada);
		mAV.addObject("datosFragment", Colecciones.datosFragment);
		mAV.addObject("paso", "DatosPersonales");
		mAV.setViewName("redirect:DatosProfesionales");
		return mAV;
	}

	/**
	 * @param model 
	 * @param sesionHttp 
	 * @return mAV
	 */
	@GetMapping("DatosProfesionales")
	public ModelAndView recibirDatosProfesionales(
			Model model,
			HttpSession sesionHttp) {
		ModelAndView mAV = new ModelAndView();
		String departamento= (String) sesionHttp.getAttribute("departamento");
		String salario= (String) sesionHttp.getAttribute("salario");  
		String comentarios = (String) sesionHttp.getAttribute("comentarios");  
		model.addAttribute("departamento",  departamento);
		model.addAttribute("salario", salario);
		model.addAttribute("comentarios", comentarios);
		mAV.addObject("listaDepartamentos", Colecciones.listaDepartamentos);
		mAV.addObject("datosFragment", Colecciones.datosFragment);
		mAV.addObject("paso", "DatosProfesionales");
		mAV.setViewName("DatosProfesionales");
		return mAV;
	}

	/**

	 * @param solicitudHttp
	 * @param respuestaHttp 
	 * @return mAV
	 */
	@PostMapping("DatosProfesionales")
	public ModelAndView enviarDatosProfesionales(
			HttpServletRequest solicitudHttp,
			HttpServletResponse respuestaHttp) {
		
		
		ModelAndView mAV = new ModelAndView();
		HttpSession session = solicitudHttp.getSession();
		String departamento = solicitudHttp.getParameter("departamento");  
		String salario = solicitudHttp.getParameter("salario");  
		String comentarios = solicitudHttp.getParameter("comentarios"); 
		session.setAttribute("departamento", departamento);
		session.setAttribute("salario",  salario);
		session.setAttribute("comentarios", comentarios);
		mAV.addObject("datosFragment", Colecciones.datosFragment);
		mAV.addObject("paso", "DatosProfesionales");
		mAV.setViewName("redirect:DatosBancarios");
		return mAV;
	}

	/**
	 * @param model 
	 * @param sesionHttp
	 * @return mAV
	 */
	@GetMapping("DatosBancarios")
	public ModelAndView recibirDatosBancarios(
			Model model,
			HttpSession sesionHttp) {
		ModelAndView mAV = new ModelAndView();
		

		String cuentaCorriente = (String) sesionHttp.getAttribute("cuentaCorriente"); 
		model.addAttribute("cuentaCorriente", cuentaCorriente);
		mAV.addObject("datosFragment", Colecciones.datosFragment);
		mAV.addObject("paso", "DatosBancarios");
		mAV.setViewName("DatosBancarios");
		return mAV;
	}

	/**
	 * @param solicitudHttp
	 * @param respuestaHttp 
	 * @return mAV
	 */
	@PostMapping("DatosBancarios")
	public ModelAndView enviarDatosBancarios(
			HttpServletRequest solicitudHttp,
			HttpServletResponse respuestaHttp) {
		ModelAndView mAV = new ModelAndView();
		HttpSession session = solicitudHttp.getSession();
		String cuentaCorriente = solicitudHttp.getParameter("cuentaCorriente"); 
		session.setAttribute("cuentaCorriente", cuentaCorriente);
		mAV.addObject("datosFragment", Colecciones.datosFragment);
		mAV.addObject("paso", "DatosBancarios");
		mAV.setViewName("redirect:Resumen");
		return mAV;
	}

	/**
	 * @param model 
	 * @param sesionHttp
	 * @return mAV
	 */
	@GetMapping("Resumen")
	public ModelAndView recibirResumen(
			Model model,
			HttpSession sesionHttp) {
		ModelAndView mAV = new ModelAndView();
		String nombre = (String) sesionHttp.getAttribute("nombre");  
		String apellidos = (String) sesionHttp.getAttribute("apellidos");  
		String fechaNacimiento = (String) sesionHttp.getAttribute("fechaNacimiento"); 
		String generoSeleccionado = (String) sesionHttp.getAttribute("generoSeleccionado");  
		String casado = (String) sesionHttp.getAttribute("casado");  
		String hijos = (String) sesionHttp.getAttribute("hijos");  
		String paises = (String) sesionHttp.getAttribute("paises");  
		String departamento= (String) sesionHttp.getAttribute("departamento");  
		String salario= (String) sesionHttp.getAttribute("salario");  
		String comentarios = (String) sesionHttp.getAttribute("comentarios");  
		String cuentaCorriente = (String) sesionHttp.getAttribute("cuentaCorriente");  
		String fecha = "";
		String[] parts = fechaNacimiento.split("-");
		String anio = parts[0];
		String mes = parts[1];
		String dia = parts[2]; 
		fecha = dia+"/"+mes+"/"+anio;
		
		
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("apellidos", apellidos);
		model.addAttribute("fechaNacimiento", fecha);
		model.addAttribute("generoSeleccionado",  generoSeleccionado);
		model.addAttribute("casado",  casado);
		model.addAttribute("hijos",  hijos);
		model.addAttribute("paises",  paises);
		model.addAttribute("departamento", departamento);
		model.addAttribute("salario", salario);
		model.addAttribute("comentarios", comentarios);
		model.addAttribute("cuentaCorriente", cuentaCorriente);
		mAV.addObject("datosFragment", Colecciones.datosFragment);
		mAV.addObject("paso", "Resumen");
		mAV.setViewName("Resumen");
		return mAV;
	}

	/**
	 * @param solicitudHttp
	 * @param respuestaHttp 
	 * @return mAV
	 */
	@PostMapping("Resumen")
	public ModelAndView enviarResumen(
			HttpServletRequest solicitudHttp,
			HttpServletResponse respuestaHttp) {
		
		ModelAndView mAV = new ModelAndView();
	
		HttpSession session = solicitudHttp.getSession();
		String nombre = solicitudHttp.getParameter("nombre");  
		String apellidos = solicitudHttp.getParameter("apellidos"); 
		String  fechaNacimiento = solicitudHttp.getParameter("fechaNacimiento"); 
		String  generoSeleccionado = solicitudHttp.getParameter("generoSeleccionado"); 
		String  casado = solicitudHttp.getParameter("casado"); 
		String  hijos = solicitudHttp.getParameter("hijos"); 
		String  paises = solicitudHttp.getParameter("paises"); 
		String departamento = solicitudHttp.getParameter("departamento");  
		String salario = solicitudHttp.getParameter("salario");  
		String comentarios = solicitudHttp.getParameter("comentarios"); 
		String cuentaCorriente = solicitudHttp.getParameter("cuentaCorriente"); 
		
		
		session.setAttribute("nombre", nombre);
		session.setAttribute("apellidos", apellidos);
		session.setAttribute("fechaNacimiento", fechaNacimiento);
		session.setAttribute("generoSeleccionado", generoSeleccionado);
		session.setAttribute("casado", casado);
		session.setAttribute("hijos", hijos);
		session.setAttribute("paises", paises);
		session.setAttribute("departamento", departamento);
		session.setAttribute("salario",  salario);
		session.setAttribute("comentarios", comentarios);
		session.setAttribute("cuentaCorriente", cuentaCorriente);
		mAV.addObject("datosFragment", Colecciones.datosFragment);
		mAV.addObject("paso", "Resumen");
		mAV.setViewName("redirect:DatosPersonales");
		return mAV;
	}
}