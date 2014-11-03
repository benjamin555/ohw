package cn.sp.ofs.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class SignedUsernameTimeAuthenticationProvider extends
		DaoAuthenticationProvider {
	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (SignedUsernameTimeAuthenticationToken.class
				.isAssignableFrom(authentication));
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		//判断用户的密码是否正确
//		String _password = userDetails.getPassword();
//		String _credentials = authentication.getCredentials().toString();
//		if(!_credentials.equals(_password)){
//			throw new BadCredentialsException(
//					messages.getMessage(
//							"SignedUsernamePasswordAuthenticationProvider.badPassword",
//							"密码不正确"));
//		}
	}
}
