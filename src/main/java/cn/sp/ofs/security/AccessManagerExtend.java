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

	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		log.info("decide");

		if ((configAttributes != null) && (!configAttributes.isEmpty())) {
			boolean _hasAuthorization = hasAuth(authentication, configAttributes);
			if (!_hasAuthorization) {
				throw new AccessDeniedException("权限不足!");
			}
		}
	}

	/**
	 * 是否拥有权限
	 * @param authentication
	 * @param configAttributes
	 * @return
	 */
	protected boolean hasAuth(Authentication authentication, Collection<ConfigAttribute> configAttributes) {
		boolean _hasAuthorization = false;
		//请求所需要的角色集合
		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		while (ite.hasNext()) {
			if (_hasAuthorization) {
				break;
			}
			ConfigAttribute ca = ite.next();
			String needRole = ((SecurityConfig) ca).getAttribute();
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				// 判断需要的角色是否存在
				// 添加URL的数据权限判断加载这里
				if (needRole.equals(ga.getAuthority())) {
					_hasAuthorization = true;
					break;
				}
			}

		}
		return _hasAuthorization;
	}

	public boolean supports(ConfigAttribute arg0) {
		return true;
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}
}
