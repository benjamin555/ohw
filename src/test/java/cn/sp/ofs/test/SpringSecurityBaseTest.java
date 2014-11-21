package cn.sp.ofs.test;

import mockit.NonStrictExpectations;

import org.junit.Before;

import cn.sp.ofs.security.SpringSecurityUtils;
import cn.sp.ofs.security.entity.User;
import cn.sp.test.BaseTest;

/**
* @author 陈嘉镇
* @version 创建时间：2014-11-21 下午4:08:50
* @email benjaminchen555@gmail.com
*/
public abstract class SpringSecurityBaseTest extends BaseTest{
	@Before
	public void adminLogin() {
		new NonStrictExpectations(SpringSecurityUtils.class) {
			{
				SpringSecurityUtils.getCurrentUser();//也可以使用参数匹配：ClassMocked.getDouble(anyDouble);  
				User admin = new User();
				admin.setId(1l);
				result = admin;
			}
		};
	}
}
