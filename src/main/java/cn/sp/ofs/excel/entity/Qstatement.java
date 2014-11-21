package cn.sp.ofs.excel.entity;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.Hibernate;

import cn.sp.persistent.BaseEntity;

/**
* @author 陈嘉镇
* @version 创建时间：2014-10-29 下午4:29:09
* @email benjaminchen555@gmail.com
*/
@Entity
public class Qstatement extends BaseEntity<Long> {

	private String description;

	private java.sql.Clob content;

	private String skipRowStr;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public java.sql.Clob getContent() {
		return content;
	}

	public void setContent(java.sql.Clob content) {
		this.content = content;
	}

	public String getSkipRowStr() {
		return skipRowStr;
	}

	public void setSkipRowStr(String skipRowStr) {
		this.skipRowStr = skipRowStr;
	}

	private String getClob(Clob c) {
		Reader reader;
		StringBuffer sb = new StringBuffer();
		try {
			reader = c.getCharacterStream();
			BufferedReader br = new BufferedReader(reader);
			String temp = null;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	@Transient
	public String getContent2String() {
		if (getContent()==null) {
			return "";
		}
		return getClob(getContent());
	}

	@Transient
	public void setContent(String string) {
		Clob clob = Hibernate.createClob(string);
		setContent(clob);
	}

}
