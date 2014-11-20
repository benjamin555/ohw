package cn.sp.ofs.security.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sp.ofs.security.SpringSecurityUtils;


/**
* @author 陈嘉镇
* @version 创建时间：2014-11-19 下午3:21:29
* @email benjaminchen555@gmail.com
*/
public class Button extends SimpleTagSupport  {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private String id;
	private String url;
	private String value;
	private String clazz;
 
	@Override
	public void doTag() throws JspException, IOException {
		if(SpringSecurityUtils.isAllowed(getUrl())){
			 // 获取页面输出流，并输出字符串
			String html = "<button id='%s' url='%s'  class='%s' >%s</button>";
			html = String.format(html, getId(),getUrl(),getClazz(),getValue());
			logger.debug("html:{}",html);
	        getJspContext().getOut().write(html); 
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5180003446840248031L;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
	

}
