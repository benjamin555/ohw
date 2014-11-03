package cn.sp.ofs.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class DoLogoutSuccessHandler implements LogoutSuccessHandler {

	private String logoutSucessUrl;

	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication paramAuthentication) throws IOException, ServletException {

		response.sendRedirect(request.getContextPath() + logoutSucessUrl);
	}

	/**
	 * @return the logoutSucessUrl
	 */
	public String getLogoutSucessUrl() {
		return logoutSucessUrl;
	}

	/**
	 * @param logoutSucessUrl
	 *            the logoutSucessUrl to set
	 */
	public void setLogoutSucessUrl(String logoutSucessUrl) {
		this.logoutSucessUrl = logoutSucessUrl;
	}
}
