package cn.sp.ofs.security.tags;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import cn.sp.test.BaseTest;

/**
* @author 陈嘉镇
* @version 创建时间：2014-12-8 下午6:21:42
* @email benjaminchen555@gmail.com
*/
public class PagerTest extends BaseTest{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private Pager pager = new Pager();
	
	@Test
	public void testRender()  {
		final String url = "/qstatement!list.action";
		pager.setUrl(url);
		pager.setFormId("shareForm");
		
		pager.render(url,1,2l);
		
		String html = pager.getHtml();
		logger.info("html:{}",html);
		Assert.isTrue(html.contains("class=\"previous disabled\""));
		Assert.isTrue(html.contains("class=\"next\""));
		
	}

}
