package com.consistent.cuervo.miinformacion.portlet;

import com.consistent.cuervo.miinformacion.constants.portletInformacionPortletKeys;
import com.consistent.cuervo.miinformacion.portlet.models.Trabajador;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author bernardohernandez
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + portletInformacionPortletKeys.portletInformacion,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class portletInformacionPortlet extends MVCPortlet {
	
private static Log log = LogFactoryUtil.getLog(portletInformacionPortlet.class.getName());
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		try {
			User user = PortalUtil.getUser(renderRequest);
			ThemeDisplay themeDisplay =(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY); 
			Trabajador trabajador = new Trabajador(user, themeDisplay);
			if(trabajador.getUser() != null) {
			log.info("<--- Logeado --->");
			renderRequest.setAttribute("trabajador", trabajador);
			renderRequest.setAttribute("grafica", trabajador.getGraficaRemuneracion());
			}else {
			log.info("<---No logeado --->");
			Trabajador trabajadorSinConexion = new Trabajador();
			renderRequest.setAttribute("trabajador", trabajadorSinConexion);
			}
			super.render(renderRequest, renderResponse);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("PortalException"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			log.error("Exception"+e.getMessage());
			// TODO: handle exception
		}//Obtiene el usuario en sesion
	}
}