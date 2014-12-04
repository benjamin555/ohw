package cn.sp.ofs.excel.action;

import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.sp.ofs.security.entity.User;
import cn.sp.ofs.security.service.UserService;
import cn.sp.ofs.security.utils.SecurityUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
* @author 陈嘉镇
* @version 创建时间：2014-10-29 下午4:38:58
* @email benjaminchen555@gmail.com
*/
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.Exception", result = "exception") })
@Results({ @Result(name = "exception", location = "/common/error.jsp"),@Result(name = SignupAction.R_DONE, location = "signup-done.action", type = "redirect") })
public class SignupAction extends  ActionSupport implements ModelDriven<User>{

	public static final String R_DONE = "rDone";
	private User model;
	@Autowired
	private UserService service;
	@Override
	public User getModel() {
		if (model==null) {
			model = new User();
		}
		return model;
	}
	
	public String save() throws Exception {
		SecurityUtils.encodePassword(model);
		service.save(model);
		
		return R_DONE;
	}

	public void setModel(User model) {
		this.model = model;
	}
	

}
