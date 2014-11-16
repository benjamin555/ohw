package cn.sp.ofs.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cn.sp.ofs.excel.dao.UserDao;
 
public class SignedUsernameTimeAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {
	private UserDao userDao ;


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				request.getParameter(SPRING_SECURITY_FORM_USERNAME_KEY),
				request.getParameter(SPRING_SECURITY_FORM_PASSWORD_KEY));
		return this.getAuthenticationManager().authenticate(authRequest);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
