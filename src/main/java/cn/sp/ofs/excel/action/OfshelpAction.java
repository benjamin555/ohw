package cn.sp.ofs.excel.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.sp.ofs.excel.Helper;
import cn.sp.ofs.excel.utils.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

/**
* @author 陈嘉镇
* @version 创建时间：2014-7-4 下午2:02:14
* @email benjaminchen555@gmail.com
*/
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.Exception", result = "exception") })
@Results({ @Result(name = "exception", location = "/common/error.jsp") })
public class OfshelpAction extends ActionSupport{
	
	private static int userNum = 0;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private File[] dataExcels;
	
	private String[] dataExcelsContentType;
	private String[] dataExcelsFileName;
	
	private String sql;
	
	/**
	 * 逗号分隔的跳过行数
	 */
	private String skipRowStr;
	
	private boolean debug;
	


	@Override
	public String execute() throws Exception {
		logger.info("dataExcels:{}",dataExcels.toString());
		//检查导入的文件是否为excel,application/vnd.ms-excel
		doCheck();
		
		Helper helper = new Helper();
		skipRowStr = StringUtils.replaceCNSign(skipRowStr);
		String[] ss = skipRowStr.split(",");
		int[] skipRows=new int[ss.length];
		for (int i = 0; i < skipRows.length; i++) {
			skipRows[i]= Integer.parseInt(ss[i]);
		}
		
		helper.setDebug(debug);
		Workbook w =  helper.query(sql, dataExcels, skipRows);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Content-disposition", "attachment; filename=export" + System.currentTimeMillis() + ".xls");
		response.setHeader("Content-Type", "application/vnd.ms-excel");
		OutputStream os = new BufferedOutputStream(response.getOutputStream());
		w.write(os);
		os.flush();
		os.close();
		return null;
	}


	private synchronized String genUserId() {
		userNum++;
		return "u"+userNum;
	}


	private void doCheck() {
		List<String> errorExcelNames =new ArrayList<String>();
		for (int i = 0; i < dataExcelsContentType.length; i++) {
			if (!"application/vnd.ms-excel".equals(dataExcelsContentType[i])&&!"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equals(dataExcelsContentType[i])) {
				errorExcelNames.add(dataExcelsFileName[i]);
			}
		}
		if (errorExcelNames.size()>0) {
			String msg="存在非excel文件：{0}";
			msg = StringUtils.formatMsg(msg, org.apache.commons.lang3.StringUtils.join(errorExcelNames));
			logger.error("msg:{}",msg);
			throw new RuntimeException(msg);
		}
		
	}


	public Logger getLogger() {
		return logger;
	}


	public void setLogger(Logger logger) {
		this.logger = logger;
	}


	public File[] getDataExcels() {
		return dataExcels;
	}


	public void setDataExcels(File[] dataExcels) {
		this.dataExcels = dataExcels;
	}


	public String[] getDataExcelsContentType() {
		return dataExcelsContentType;
	}


	public void setDataExcelsContentType(String[] dataExcelsContentType) {
		this.dataExcelsContentType = dataExcelsContentType;
	}


	public String[] getDataExcelsFileName() {
		return dataExcelsFileName;
	}


	public void setDataExcelsFileName(String[] dataExcelsFileName) {
		this.dataExcelsFileName = dataExcelsFileName;
	}


	public String getSql() {
		return sql;
	}


	public void setSql(String sql) {
		this.sql = sql;
	}


	public String getSkipRowStr() {
		return skipRowStr;
	}


	public void setSkipRowStr(String skipRowStr) {
		this.skipRowStr = skipRowStr;
	}

	public String demo() throws Exception{
		return "demo"; 
	}


	public boolean isDebug() {
		return debug;
	}


	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
	

}
