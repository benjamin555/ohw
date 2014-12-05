package cn.sp.ofs.excel.service;

import mockit.Verifications;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import cn.sp.ofs.excel.entity.Qstatement;
import cn.sp.ofs.security.SpringSecurityUtils;
import cn.sp.ofs.test.SpringSecurityBaseTest;

/**
* @author 陈嘉镇
* @version 创建时间：2014-11-20 下午3:19:58
* @email benjaminchen555@gmail.com
*/
public class QstatementServiceTest extends SpringSecurityBaseTest {
	@Autowired
	private QstatementService service;
	
	@Test
	public void testFindSelf() throws Exception {
		

		Qstatement entityObject = new Qstatement();
		entityObject.setContent("test");
		entityObject.setDescription("test");
		entityObject.setSkipRowStr("1");
		service.save(entityObject);
		
		

	}

	

	/**
	 * 自动记录者和更新者
	 * @throws Exception
	 */
	@Test
	public void testAutoRecord() throws Exception {


		Qstatement entityObject = new Qstatement();
		entityObject.setContent("test");
		entityObject.setDescription("test");
		entityObject.setSkipRowStr("1");
		service.save(entityObject);

		Assert.isTrue("1".equals(entityObject.getCreator()));
		
		Qstatement q = service.getById(entityObject.getId());
		Assert.isTrue("1".equals(q.getCreator()));

		new Verifications() {
			{
				SpringSecurityUtils.getCurrentUser();
			}
		};
	}

}
