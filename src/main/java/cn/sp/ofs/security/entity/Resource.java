package cn.sp.ofs.security.entity;

import javax.persistence.Entity;

import cn.sp.persistent.BaseEntity;

/**
* @author 陈嘉镇
* @version 创建时间：2014-11-3 下午5:51:03
* @email benjaminchen555@gmail.com
*/
@Entity
public class Resource extends BaseEntity<Long>{
	private String name;
	
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
