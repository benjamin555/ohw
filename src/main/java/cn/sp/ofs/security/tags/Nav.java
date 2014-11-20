package cn.sp.ofs.security.tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sp.ofs.security.SpringSecurityUtils;


/**
* @author 陈嘉镇
* @version 创建时间：2014-11-19 下午3:21:29
* @email benjaminchen555@gmail.com
*/
public class Nav extends TagSupport  {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public int doEndTag() throws JspException {
		if(SpringSecurityUtils.isAllowed(getUrl())){
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			String contextPath = request.getContextPath();
			 // 获取页面输出流，并输出字符串
			String html = "<li ><a href='%s'>%s</a></li>";
			html = String.format(html, contextPath+getUrl(),getValue());
			logger.debug("html:{}",html);
	        try {
				pageContext.getOut().write(html);
			} catch (IOException e) {
				logger.error("error.",e);
			} 
		}
		return EVAL_PAGE;
	}

	
	private String url;
	private String value;
 


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
	

}
