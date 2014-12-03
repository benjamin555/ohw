package cn.sp.ofs.security;

import java.util.Collection;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import cn.sp.ofs.security.entity.User;
import cn.sp.spring.utils.ComponentFactory;

/**
* @author 陈嘉镇
* @version 创建时间：2014-11-19 下午5:22:02
* @email benjaminchen555@gmail.com
*/
public final class SpringSecurityUtils {

	public static User getCurrentUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication == null) {
			return null;
		}
		return (User) authentication.getPrincipal();
	}

	public static boolean isAllowed(String url) {
		AccessManagerExtend accessManager = (AccessManagerExtend) ComponentFactory.getBean("accessManagerExtend");
		MetadataSourceExtend metadataSourceExtend = (MetadataSourceExtend) ComponentFactory.getBean("metadataSourceExtend");
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		//获取需要的角色
		Collection<ConfigAttribute> configAttributes = metadataSourceExtend.getAuths(url);
		if (configAttributes==null||configAttributes.isEmpty()) {
			return true;
		}
		return accessManager.hasAuth(authentication, configAttributes);
	}
}
