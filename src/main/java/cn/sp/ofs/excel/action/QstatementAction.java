package cn.sp.ofs.excel.action;

import java.sql.Clob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springside.modules.orm.Page;

import cn.sp.action.CrudActionSupport;
import cn.sp.ofs.excel.entity.Qstatement;
import cn.sp.ofs.excel.service.QstatementService;
import cn.sp.ofs.security.SpringSecurityUtils;
import cn.sp.ofs.security.entity.User;
import cn.sp.ofs.security.service.UserService;
import cn.sp.web.utils.JsonUtils;

/**
* @author 陈嘉镇
* @version 创建时间：2014-10-29 下午4:38:58
* @email benjaminchen555@gmail.com
*/
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.Exception", result = "exception") })
@Results({ @Result(name = "exception", location = "/common/error.jsp")
,@Result(name = "json", location = "/common/json.jsp")
,@Result(name = QstatementAction.R_LIST, location = "qstatement!list.action", type = "redirect")
})
public class QstatementAction extends CrudActionSupport<Qstatement>{
	
	public static final String R_LIST = "rList";

	public static final String JSON = "json";

	public static final String LIST = "list";
	
	private long[] ids;

	private String jsonStr;

	private Qstatement qstatement;
	
	/**
	 * 被分享用户名
	 */
	private String sharedUserName ;
	
	private List<Qstatement> qstatements;
	
	/**
	 * 分享的
	 */
	private List<Qstatement> sharedList;
	
	private String sql;
	
	
	@Autowired
	private QstatementService service;
	@Autowired
	private UserService userService;
	
	public String save() throws Exception {
		Clob clob = Hibernate.createClob(sql);
		qstatement.setContent(clob);
		if (qstatement.getId()!=null) {
			Qstatement d = service.getById(qstatement.getId());
			d.setDescription(qstatement.getDescription());
			d.setContent(qstatement.getContent());
			d.setSkipRowStr(qstatement.getSkipRowStr());
			service.save(d);
			
		}else {
			service.save(qstatement);
		}
		
		return R_LIST;
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
		User currentUser = SpringSecurityUtils.getCurrentUser();
		long loginId = currentUser.getId();
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("flt_m_and_eqS_creator", loginId+"");
		Page<Qstatement> page = service.getPage(0, 25, searchMap );
		qstatements = page.getResult();
		
		Map<String, String> searchMap2 = new HashMap<String, String>();
		Page<Qstatement> page2 = service.getShared(0, 25,loginId, searchMap2 );
		sharedList = page2.getResult();
		
		jsonStr = JsonUtils.getSuccessMsg();
		
		
		return LIST;
	}
	
	public String forImport() throws Exception {
		qstatement = service.getById(qstatement.getId());
		return "forImport";
	}
	

	@Override
	public String input() throws Exception {
		qstatement = service.getById(qstatement.getId());
		return INPUT;
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

	public List<Qstatement> getSharedList() {
		return sharedList;
	}

	public void setSharedList(List<Qstatement> sharedList) {
		this.sharedList = sharedList;
	}

	public String share() {
		User u = userService.getByUsername(sharedUserName);
		if (u==null) {
			jsonStr = JsonUtils.getErrorMsg("系统中不存在该用户");
		}else {
			long sharedUserId=u.getId();
			service.shareTo(ids,sharedUserId );
			jsonStr=JsonUtils.getSuccessMsg();
		}
		return JSON;
	}

	

	public String getSharedUserName() {
		return sharedUserName;
	}

	public void setSharedUserName(String sharedUserName) {
		this.sharedUserName = sharedUserName;
	}

	public long[] getIds() {
		return ids;
	}

	public void setIds(long[] ids) {
		this.ids = ids;
	}

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

}
