package cn.sp.ofs.excel.action;

import java.sql.Clob;
import java.util.List;

import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.sp.action.CrudActionSupport;
import cn.sp.ofs.excel.entity.Qstatement;
import cn.sp.ofs.excel.service.QstatementService;

/**
* @author 陈嘉镇
* @version 创建时间：2014-10-29 下午4:38:58
* @email benjaminchen555@gmail.com
*/
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.Exception", result = "exception") })
@Results({ @Result(name = "exception", location = "/common/error.jsp") })
public class QstatementAction extends CrudActionSupport<Qstatement>{
	
	private Qstatement qstatement;
	
	private List<Qstatement> qstatements;
	
	private String sql;
	
	
	@Autowired
	private QstatementService service;
	
	public String save() throws Exception {
		Clob clob = Hibernate.createClob(sql);
		qstatement.setContent(clob);
		service.save(qstatement);
		return list();
	}

	public Qstatement getQstatement() {
		return qstatement;
	}

	public void setQstatement(Qstatement qstatement) {
		this.qstatement = qstatement;
	}

	@Override
	public Qstatement getModel() {
		if (qstatement==null) {
			qstatement = new Qstatement();
		}
		return qstatement;
	}

	@Override
	public String list() throws Exception {
		qstatements = service.getAll();
		return "list";
	}
	
	public String forImport() throws Exception {
		qstatement = service.getById(qstatement.getId());
		return "forImport";
	}
	

	@Override
	public String input() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<Qstatement> getQstatements() {
		return qstatements;
	}

	public void setQstatements(List<Qstatement> qstatements) {
		this.qstatements = qstatements;
	}

	public QstatementService getService() {
		return service;
	}

	public void setService(QstatementService service) {
		this.service = service;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	
	

}
