/*
 *
 *
 * 程序生成时间：[Mon Nov 17 10:54:51 CST 2014] 生成
 */
package cn.sp.ofs.security.action;
//导入java类
import java.util.List;

import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;

import cn.sp.action.CrudActionSupport;
import cn.sp.ofs.security.entity.User;
import cn.sp.ofs.security.service.UserService;
/**
 * 功能:本类为用户的Action
 *
 * @author  benjaminchen555@gmail.com
 * @date    [Mon Nov 17 10:54:51 CST 2014]
 *
 */
@SuppressWarnings("serial")
@Controller
@Namespace(value="/security")
@Scope("prototype")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.Exception", result = "exception") })
@Results({ @Result(name = "exception", location = "/common/error.jsp")
	,@Result(name = UserAction.R_LIST, location = "user!list.action", type = "redirect")
 })
public class UserAction extends CrudActionSupport<User> {
	public static final String R_LIST = "rList";
	
    private User model;
	
	private List<User> models;
	
	private Long[] ids;
	
	
	@Autowired
	private UserService service;


	@Override
	public User getModel() {
		if (model==null) {
			model = new User();
		}
		return model;
	}


	@Override
	public String list() throws Exception {
		models = service.getAll();
		return SUCCESS;
	}


	@Override
	public String input() throws Exception {
		if (model.getId()!=null) {
			model = service.getById(model.getId());
		}
		return INPUT;
	}


	@Override
	public String save() throws Exception {
		String pwd = getEncodePwd();
		model.setPassword(pwd);
		if (model.getId()!=null) {
			User d = service.getById(model.getId());
			d.setUserName(model.getUserName());
			d.setRoles(model.getRoles());
			d.setPassword(model.getPassword());
			service.save(d);
		}else {
			service.save(model);
		}
		return R_LIST;
	}


	protected String getEncodePwd() {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String pwd = encoder.encodePassword(model.getPassword(), model.getUserName());
		return pwd;
	}


	@Override
	public String delete() throws Exception {
		for (Long id : ids) {
			service.deleteById(id);
		}
		return R_LIST;
	}


	@Override
	protected void prepareModel() throws Exception {
		
	}


	public List<User> getModels() {
		return models;
	}


	public void setModels(List<User> models) {
		this.models = models;
	}
	
	public Long[] getIds() {
		return ids;
	}


	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	
}