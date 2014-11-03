package cn.sp.ofs.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class TokenAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String targetUrl = (String) request.getAttribute("redirectUrl");

		if (response.isCommitted()) {
			return;
		}
		if (StringUtils.isEmpty(targetUrl)) {
			targetUrl = (String) request
					.getParameter("spring-security-redirect");
			if (StringUtils.isEmpty(targetUrl)) {
				targetUrl = "/portal/index.action";
			}
		}
		response.sendRedirect(request.getContextPath() + targetUrl);
	}
}
