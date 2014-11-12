package cn.sp.ofs.excel.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cn.sp.ofs.excel.entity.Role;
import cn.sp.ofs.excel.entity.User;
import cn.sp.test.BaseTest;

/**
* @author 陈嘉镇
* @version 创建时间：2014-11-3 下午4:05:23
* @email benjaminchen555@gmail.com
*/
@ContextConfiguration(locations = { "classpath:test_applicationContext.xml" })
@TransactionConfiguration(defaultRollback=false)
public class UserServiceTest extends BaseTest{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Test
	public void testSave() throws Exception {
		User entityObject = new User();
		entityObject.setUserName("haha");
		entityObject.setPassword("haha");
		userService.save(entityObject );
	}
	
	@Test
	public void testChangePassword() throws Exception {
		String username = "haha";
		User u = userService.getByUsername(username);
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String pwd = encoder.encodePassword("haha", username);
		u.setPassword(pwd);
		userService.save(u );
	}
	
	@Test
	public void testAssignRole() throws Exception {
		String username = "haha";
		User u = userService.getByUsername(username);
		Role r = roleService.getById(1l);
		u.addRole(r);
	}

}
