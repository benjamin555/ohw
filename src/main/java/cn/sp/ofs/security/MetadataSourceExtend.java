package cn.sp.ofs.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;
import org.springframework.transaction.annotation.Transactional;

import cn.sp.ofs.security.entity.Resource;
import cn.sp.ofs.security.entity.Role;
import cn.sp.ofs.security.service.RoleService;

@Transactional
public class MetadataSourceExtend implements FilterInvocationSecurityMetadataSource {

	private Logger log = LoggerFactory.getLogger(getClass());

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	@Autowired
	private RoleService roleService;

	public void init() {
		loadResourceDefine();
	}

	public MetadataSourceExtend() {
		super();
	}
	public void loadResourceDefine() {
		log.info("loadResourceDefine");
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		List<Role> _roleAllList = roleService.getAll();
		if (_roleAllList!=null&&!_roleAllList.isEmpty()) {
			for (Role _role : _roleAllList) {
				String roleName = _role.getId()+"";
				List<Role> _temp = new ArrayList<Role>();
				_temp.add(_role);
				Set<String> _urlSet = recursiveRole(_temp);
				for (String _url : _urlSet) {
					Collection<ConfigAttribute> _atts = resourceMap.get(_url);
					if (null == _atts)
						_atts = new ArrayList<ConfigAttribute>();
					ConfigAttribute _att = new SecurityConfig(roleName);
					_atts.add(_att);
					resourceMap.put(_url, _atts);
				}
			}
		}
		
	}

	private Set<String> recursiveRole(List<Role> _roleList) {
		Set<String> _urlSet = new HashSet<String>(0);
		for (Role _role : _roleList) {
			List<Resource> rs = _role.getResources();
			for (Resource r : rs) {
				_urlSet.add(r.getUrl());
			}
		}
		return _urlSet;
	}


	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public Collection<ConfigAttribute> getAttributes(Object filter) throws IllegalArgumentException {
		log.info("getAttributes");
		HttpServletRequest request = ((FilterInvocation) filter).getHttpRequest();
		Iterator<String> ite = resourceMap.keySet().iterator();

		while (ite.hasNext()) {
			String urlPattern = ite.next();
			RequestMatcher urlMatcher = new AntPathRequestMatcher(urlPattern);
			if (urlMatcher.matches(request)) {
				Collection<ConfigAttribute> auths = resourceMap.get(urlPattern);
				log.debug("need auths:{}",auths);
				return auths;
			}
		}
		return Collections.emptyList();
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}
}
