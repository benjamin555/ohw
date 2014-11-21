package cn.sp.ofs.security.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cn.sp.ofs.security.entity.Resource;
import cn.sp.ofs.security.entity.Role;
import cn.sp.ofs.test.SpringSecurityBaseTest;
/**
* @author 陈嘉镇
* @version 创建时间：2014-11-11 下午5:02:04
* @email benjaminchen555@gmail.com
*/
@ContextConfiguration(locations = { "classpath:test_applicationContext.xml" })
public class ResourceServiceTest extends SpringSecurityBaseTest{
	
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private RoleService roleService;

	@Test
	public void testResouceAssign() throws Exception {
		Resource entityObject = new Resource();
		entityObject.setName("全部功能");
		entityObject.setUrl("/**");
		resourceService.save(entityObject );
		
		Role r = roleService.getById(1l);
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(entityObject);
		r.setResources(resources );
		roleService.save(r );
	}
	
}
