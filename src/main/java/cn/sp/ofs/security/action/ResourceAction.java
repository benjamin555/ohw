/*
 *
 *
 * 程序生成时间：[Wed Nov 19 11:38:01 CST 2014] 生成
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
import org.springframework.stereotype.Controller;

import cn.sp.action.CrudActionSupport;
import cn.sp.ofs.security.MetadataSourceExtend;
import cn.sp.ofs.security.entity.Resource;
import cn.sp.ofs.security.service.ResourceService;
/**
 * 功能:本类为用户的Action
 *
 * @author  benjaminchen555@gmail.com
 * @date    [Wed Nov 19 11:38:01 CST 2014]
 *
 */
@SuppressWarnings("serial")
@Controller
@Namespace(value="/security")
@Scope("prototype")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.Exception", result = "exception") })
@Results({ @Result(name = "exception", location = "/common/error.jsp")
	,@Result(name = ResourceAction.R_LIST, location = "resource!list.action", type = "redirect")
 })
public class ResourceAction extends CrudActionSupport<Resource> {
	public static final String R_LIST = "rList";
	
    private Resource model;
	
	private List<Resource> models;
	
	private Long[] ids;
	
	
	@Autowired
	private ResourceService service;
	
	@Autowired
	private MetadataSourceExtend metadataSourceExtend;


	@Override
	public Resource getModel() {
		if (model==null) {
			model = new Resource();
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
			Resource d = service.getById(model.getId());
			d.setName(model.getName());
			d.setUrl(model.getUrl());
			d.setRoles(model.getRoles());
			service.save(d);
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
	
	/**
	 * 重新加载系统资源
	 * @return
	 */
	public String reloadSysResouces() {
		metadataSourceExtend.loadResourceDefine();
		return R_LIST;
	}


	@Override
	protected void prepareModel() throws Exception {
		
	}


	public List<Resource> getModels() {
		return models;
	}


	public void setModels(List<Resource> models) {
		this.models = models;
	}
	
	public Long[] getIds() {
		return ids;
	}


	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	
}