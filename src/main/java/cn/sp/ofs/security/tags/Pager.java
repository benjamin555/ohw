package cn.sp.ofs.security.tags;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sp.ofs.excel.service.FreeMarkerService;
import cn.sp.ofs.security.SpringSecurityUtils;
import cn.sp.spring.utils.ComponentFactory;


/**
* @author 陈嘉镇
* @version 创建时间：2014-11-19 下午3:21:29
* @email benjaminchen555@gmail.com
*/
public class Pager extends TagSupport  {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private String html;
	private String formId;
	
	@Override
	public int doEndTag() throws JspException {
		render();
		try {
			pageContext.getOut().write(html);
		} catch (IOException e) {
			logger.error("error.",e);
		} 
		return EVAL_PAGE;
	}

	protected void render() {
		if(SpringSecurityUtils.isAllowed(getUrl())){
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			String contextPath = request.getContextPath();
			
			int pageNo = (Integer) request.getAttribute("page.pageNo");
			String path = contextPath+url;
			Long totalPage = (Long) request.getAttribute("page.totalPages");
			render(path, pageNo, totalPage);
	        
		}
	}

	protected void render(String path, int pageNo, Long totalPage) {
		// 获取页面输出流，并输出字符串
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("url", path);
		map.put("pageNo", pageNo);
		//按钮是否禁止使用
		boolean nextDisabled = false,preDisabled = false;
		if (pageNo<=1) {
			preDisabled = true;
		}
		map.put("preDisabled", preDisabled);
		if (pageNo>=totalPage) {
			nextDisabled =true;
		}
		map.put("nextDisabled", nextDisabled);
		map.put("formId", getFormId()); 
		FreeMarkerService freeMarkerService = (FreeMarkerService) ComponentFactory.getBean("freeMarkerService");
		 html = freeMarkerService.populateTempalte("pager.ftl", map );
		logger.debug("html:{}",html);
	}

	
	private String url;
 


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtml() {
		return html;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

}
