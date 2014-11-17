package cn.sp.ofs.security.action;

import java.util.List;

import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.sp.action.CrudActionSupport;
import cn.sp.ofs.security.entity.Role;
import cn.sp.ofs.security.service.RoleService;

/**
* @author 陈嘉镇
* @version 创建时间：2014-10-29 下午4:38:58
* @email benjaminchen555@gmail.com
*/
@SuppressWarnings("serial")
@Controller
@Namespace(value="/security")
@Scope("prototype")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.Exception", result = "exception") })
@Results({ @Result(name = "exception", location = "/common/error.jsp") 
	,@Result(name = RoleAction.R_LIST, location = "role!list.action", type = "redirect")
})
public class RoleAction extends CrudActionSupport<Role>{
	
	public static final String R_LIST = "rList";

	private Role model;
	
	private List<Role> models;
	
	private Long[] ids;
	
	
	@Autowired
	private RoleService service;


	@Override
	public Role getModel() {
		if (model==null) {
			model = new Role();
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
		if (model.getId()!=null) {
			Role dRole = service.getById(model.getId());
			dRole.setName(model.getName());
			service.save(dRole);
		}else {
			service.save(model);
		}
		
		return R_LIST;
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
		// TODO Auto-generated method stub
		
	}


	public List<Role> getModels() {
		return models;
	}


	public void setModels(List<Role> models) {
		this.models = models;
	}


	public Long[] getIds() {
		return ids;
	}


	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	
	
	

}
