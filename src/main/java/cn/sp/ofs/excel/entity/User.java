package cn.sp.ofs.excel.entity;

import javax.persistence.Entity;

import cn.sp.persistent.BaseEntity;

/**
* @author 陈嘉镇
* @version 创建时间：2014-10-31 下午2:44:24
* @email benjaminchen555@gmail.com
*/
@Entity
public class User extends BaseEntity<Long>{
	
	private String userName;
	
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
