package cn.sp.ofs.excel.action;

import java.util.List;

import mockit.NonStrictExpectations;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springside.modules.orm.Page;

import cn.sp.ofs.excel.entity.Qstatement;
import cn.sp.ofs.security.SpringSecurityUtils;
import cn.sp.ofs.security.entity.User;
import cn.sp.ofs.security.service.UserService;
import cn.sp.test.BaseTest;

/**
* @author 陈嘉镇
* @version 创建时间：2014-12-4 上午10:58:40
* @email benjaminchen555@gmail.com
*/
public class QstatementActionTest extends BaseTest {

	@Autowired
	private QstatementAction action;
	@Autowired
	private UserService userService;


	public void adminLogin() {
		new NonStrictExpectations(SpringSecurityUtils.class) {
			{
				SpringSecurityUtils.getCurrentUser();//也可以使用参数匹配：ClassMocked.getDouble(anyDouble);  
				User admin = new User();
				admin.setId(3l);
				admin.setUserName("haha");
				result = admin;
			}
		};
	}
	
	
	public void login(final String userName) {
		new NonStrictExpectations(SpringSecurityUtils.class) {
			{
				SpringSecurityUtils.getCurrentUser();//也可以使用参数匹配：ClassMocked.getDouble(anyDouble);  
				User u = userService.getByUsername(userName);
				result = u;
			}
		};
	}
	
	@Test
	public void testList() throws Exception {
		adminLogin();
		Page<Qstatement> page = new Page<Qstatement>();
		page.setPageNo(1);
		page.setPageSize(5);
		action.setPage(page );
		String retString = action.list();
		Assert.notEmpty(action.getQstatements());
		Assert.isTrue(QstatementAction.LIST.equals(retString));
		
	}
	
	@Test
	public void testShare() throws Exception {
		String shareUser = "haha";
		String sharedUser = "user1";
		login(shareUser);
		final long[] ids = {1l};
		action.setIds(ids );
		
		action.setSharedUserName(sharedUser);
		Page<Qstatement> page = new Page<Qstatement>();
		page.setPageNo(1);
		page.setPageSize(5);
		action.setPage(page );
		String retString = action.share();
		Assert.isTrue(QstatementAction.JSON.equals(retString));
		
		//进行多次分享，不会造成重复
		retString = action.share();
		
		//其它用户查询分享
		login(sharedUser);
		action.list();
		List<Qstatement> list = action.getSharedList();
		Assert.notEmpty(list);
		CollectionUtils.filter(list, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				Qstatement e = (Qstatement)object;
				if (ArrayUtils.contains(ids, e.getId())) {
					return true;
				}
				return false;
			}
		});
		Assert.isTrue(list.size()==ids.length);
		
	}
	
	@Test
	public void testPage() throws Exception {
		adminLogin();
		int pageNo=2;
		Page<Qstatement> page = new Page<Qstatement>();
		page.setPageNo(pageNo);
		page.setPageSize(5);
		action.setPage(page );
		String retString = action.list();
		page= action.getPage();
		
		long totalPage = page.getTotalPages();
		long t = 0;
		if (page.getTotalCount()>0) {
			t= page.getTotalCount()/page.getPageSize()+1;
		}
		Assert.isTrue(totalPage==t);
		
		Assert.isTrue(QstatementAction.LIST.equals(retString));
		
	}
	

}
