package cn.sp.ofs.security;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class AccessManagerExtend implements AccessDecisionManager {
	private Logger log = LoggerFactory.getLogger(getClass());
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
		log.debug("decide");
		if ((configAttributes != null) && (!configAttributes.isEmpty())) {
			boolean _hasAuthorization = false;
			Iterator<ConfigAttribute> ite = configAttributes.iterator();
			while (ite.hasNext()) {
				ConfigAttribute ca = ite.next();
				String needRole = ((SecurityConfig) ca).getAttribute();
				for (GrantedAuthority ga : authentication.getAuthorities()) {
					// 判断需要的角色是否存在
					// 添加URL的数据权限判断加载这里
					if (needRole.equals(ga.getAuthority())) {
						_hasAuthorization = true;
					}
				}
			}
			if (!_hasAuthorization) {
				throw new AccessDeniedException("no right");
			}
		}
	}

	public boolean supports(ConfigAttribute arg0) {
		return true;
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}
}
