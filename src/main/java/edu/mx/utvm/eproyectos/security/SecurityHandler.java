package edu.mx.utvm.eproyectos.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SecurityHandler  implements AuthenticationSuccessHandler, AuthenticationFailureHandler{
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
						
		if (authentication != null && authentication.isAuthenticated()) {
			String userName = authentication.getName();
			log.debug("Nombre de usuario: " + userName);
			Collection<GrantedAuthority> authorities = authentication.getAuthorities();
			for(GrantedAuthority authority : authorities){
				String rol = authority.getAuthority();
				if(rol.equals("ADMINISTRADOR")){
					response.sendRedirect("resolver/evaluacion/all");
				}else if(rol.equals("EVALUADOR")){
					response.sendRedirect("resolver/evaluador/proyectos");
				}else if(rol.equals("MANAGER")){
					response.sendRedirect("resolver/manager/all");
				}
			}
		}else{
			response.sendRedirect("resolver/login");
		}
		
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authenticationException)
			throws IOException, ServletException {
		request.getSession().invalidate();
		response.getOutputStream().print(authenticationException.getMessage());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.sendRedirect("resolver/login");
	}
}
