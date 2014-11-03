package cn.sp.ofs.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.transaction.annotation.Transactional;

import cn.sp.ofs.excel.service.UserService;

@Transactional
public class MetadataSourceExtend implements FilterInvocationSecurityMetadataSource {

	private UserService userService = null;

	public MetadataSourceExtend() {
	}

	public MetadataSourceExtend(UserService userService) {
		this.userService = userService;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}



	public Collection<ConfigAttribute> getAttributes(Object filter) throws IllegalArgumentException {
		return Collections.emptyList();
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}
}
