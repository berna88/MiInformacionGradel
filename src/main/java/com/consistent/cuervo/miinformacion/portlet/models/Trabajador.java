package com.consistent.cuervo.miinformacion.portlet.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.consistent.cuervo.remuneracion.builder.model.Remuneracion;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;

public class Trabajador {
	private static Log log = LogFactoryUtil.getLog(Trabajador.class.getName());
	private String nombres;
	private String apellidos;
	private String idEmpleado;
	private String puesto;
	private String departamento;
	private String centroDeCostos;
	private String centroDeTrabajo;
	private String fechaDeIngreso;
	private String imagenPerfil;
	private ThemeDisplay themeDisplay;
	private User user;
	
	public String getImagenPerfil() {
		try {
			imagenPerfil = user.getPortraitURL(themeDisplay);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("method:getImagenPerfil"+e.getMessage());
			imagenPerfil = "";
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("method:getImagenPerfil"+e.getMessage());
			imagenPerfil = "";
			e.printStackTrace();
		}
		return imagenPerfil;
	}
	
	public void setImagenPerfil(String imagenPerfil) {
		this.imagenPerfil = imagenPerfil;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNombres() {
		try {
			nombres = (String) user.getExpandoBridge().getAttribute("Nombres");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Method: getNombres");
			nombres = "";
		}
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		try {
			apellidos = (String) user.getExpandoBridge().getAttribute("Apellido_Materno");
			apellidos += " "+ (String) user.getExpandoBridge().getAttribute("Apellido_Paterno");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Method: getApellidos");
			apellidos = "";
		}
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getIdEmpleado() {
		try {
			idEmpleado = (String) user.getExpandoBridge().getAttribute("No_Empleado");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Method: getIdEmpleado");
			idEmpleado = "";
		}
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getPuesto() {
		try {
			puesto = (String) user.getExpandoBridge().getAttribute("Desc_Puesto_Trabajo");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Method: getPuesto");
			puesto = "";
		}
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getDepartamento() {
		try {
			departamento = (String) user.getExpandoBridge().getAttribute("Desc_Depto");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Method: getDepartamento");
			departamento = "";
		}
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getCentroDeCostos() {
		try {
			centroDeCostos = (String) user.getExpandoBridge().getAttribute("Clave_Centro_Costos");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Method: getCentroDeCostos");
			centroDeCostos = "";
		}
		return centroDeCostos;
	}
	public void setCentroDeCostos(String centroDeCostos) {
		this.centroDeCostos = centroDeCostos;
	}
	public String getCentroDeTrabajo() {
		try {
			centroDeTrabajo = (String) user.getExpandoBridge().getAttribute("Clave_Puesto_Trabajo");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Method: getCentroDeTrabajo");
			centroDeTrabajo = "";
		}
		return centroDeTrabajo;
	}
	public void setCentroDeTrabajo(String centroDeTrabajo) {
		this.centroDeTrabajo = centroDeTrabajo;
	}
	public String getFechaDeIngreso() {
		try {
			fechaDeIngreso = (String) user.getExpandoBridge().getAttribute("Fecha_Antiguedad");
			if(!fechaDeIngreso.isEmpty() && fechaDeIngreso != null) {
				String ano = "";
				String mes = "";
				String dia = "";
				for (int i=0; i < fechaDeIngreso.length(); i++) {
					if(i<=3) {
						ano += fechaDeIngreso.charAt(i);
					}
					if (i>=4 && i<=5) {
						mes += fechaDeIngreso.charAt(i);
					}
					if (i>=6 && i<=7) {
						dia += fechaDeIngreso.charAt(i);
					}
				}
				String fechaFinal = dia+"/"+mes+"/"+ano;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "ES"));
				Date myDate = sdf.parse(fechaFinal);
				sdf.applyPattern("EEEE, MMMMM d, yyyy");
				String sMyDate = sdf.format(myDate);
				fechaDeIngreso = sMyDate.substring(0, 1).toUpperCase() + sMyDate.substring(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			fechaDeIngreso = "";
		}
		return fechaDeIngreso;
	}
	public void setFechaDeIngreso(String fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	public Trabajador(String nombres, String apellidos, String idEmpleado, String puesto, String departamento,
			String centroDeCostos, String centroDeTrabajo, String fechaDeIngreso) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.idEmpleado = idEmpleado;
		this.puesto = puesto;
		this.departamento = departamento;
		this.centroDeCostos = centroDeCostos;
		this.centroDeTrabajo = centroDeTrabajo;
		this.fechaDeIngreso = fechaDeIngreso;
		
	}
	
	public Trabajador(User user,ThemeDisplay themeDisplay) {
		this.user = user;
		this.themeDisplay = themeDisplay;
		
	}
	public Trabajador() {
		this.nombres = "";
		this.apellidos = "";
		this.idEmpleado = "";
		this.puesto = "";
		this.departamento = "";
		this.centroDeCostos = "";
		this.centroDeTrabajo = "";
		this.fechaDeIngreso = "";
		
	}
	
	public Remuneracion getGraficaRemuneracion() {	
		Remuneracion remuneracion;
		try {
			remuneracion = com.consistent.cuervo.remuneracion.builder.service.RemuneracionLocalServiceUtil.getRemuneracion(Integer.parseInt(getIdEmpleado()));
			log.debug(remuneracion.getRemuneracion_total());
			log.debug(remuneracion.getCompensacion_anual());
			log.debug(remuneracion.getCompensacion_variable_anual());
			log.debug(remuneracion.getBeneficia_anual());
			return remuneracion;
		} catch (NumberFormatException e) {
			log.error("getGraficaRemuneracion NumberFormatException"+ e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("getGraficaRemuneracion PortalException"+ e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("getGraficaRemuneracion Exception"+ e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
