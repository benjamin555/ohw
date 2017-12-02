package cn.sp.ofs.excel.action;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import mockit.NonStrictExpectations;

import org.apache.struts2.ServletActionContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.util.Assert;

import cn.sp.ofs.excel.utils.DBConnectionPool;
import cn.sp.ofs.security.SpringSecurityUtils;
import cn.sp.ofs.security.entity.User;
import cn.sp.test.BaseTest;

/**
* @author 陈嘉镇
* @version 创建时间：2014-12-4 上午10:58:40
* @email benjaminchen555@gmail.com
*/
public class OfshelpActionTest extends BaseTest {

	@Autowired
	private OfshelpAction action;

	private static File[] dataExcels;
	private static String data1FileName = "src/test/resources/data1.xls";
	private static String data2FileName = "src/test/resources/data2.xls";
	static {
		dataExcels = new File[2];
		dataExcels[0] = new File(data1FileName);
		dataExcels[1] = new File(data2FileName);
	}
	@Before
	public void init() {
		Connection c = DBConnectionPool.getConnection();
		Statement statement;
		try {
			statement = c.createStatement();
			String sql = "DROP ALL OBJECTS";
			statement.execute(sql);
			c.commit();
		} catch (SQLException e) {
			getLogger().error("error.",e);
		}
	}

	@Test
	public void testExecute() throws Exception {
		action.setDataExcels(dataExcels);
		String[] dataExcelsContentType = new String[] { "application/vnd.ms-excel", "application/vnd.ms-excel","application/vnd.ms-excel", "application/vnd.ms-excel" };
		action.setDataExcelsContentType(dataExcelsContentType);
		String skipRowStr = "2,2,2,2";
		action.setSkipRowStr(skipRowStr);
		
		String sql = "select distinct t1.*,t2.c2 as ssdfas,t2.c5,t2.c6,t2.c7,t4.* from t1 join t2 on t2.c1 =t1.c1 join t4 on t1.c1=t4.c1 order by t1.c1";
		action.setSql(sql);
		
		new NonStrictExpectations(ServletActionContext.class) {
			{
				ServletActionContext.getResponse(); 
				MockHttpServletResponse response = new MockHttpServletResponse();
				response.setOutputStreamAccessAllowed(true);
				result = response;
			}
		};
		
		String ret = action.execute();

		Assert.isTrue(ret==null);
		
		adminLogin();
		
		ret = action.execute();

		Assert.isTrue(ret==null);

	}
	
	
	public void adminLogin() {
		new NonStrictExpectations(SpringSecurityUtils.class) {
			{
				SpringSecurityUtils.getCurrentUser();//也可以使用参数匹配：ClassMocked.getDouble(anyDouble);  
				User admin = new User();
				admin.setId(1l);
				admin.setUserName("haha");
				result = admin;
			}
		};
	}
	
	
	@Test
	public void testLuncenSearch() throws Exception {
		action.setKeyword("博雅");
		action.search();
		List<String>row = action.getRow();
		boolean r = (row.get(0).indexOf("博雅"))>0;
		Assert.isTrue(r);
		
	}


}
