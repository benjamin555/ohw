package cn.sp.ofs.security.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import cn.sp.persistent.BaseEntity;

/**
* @author 陈嘉镇
* @version 创建时间：2014-11-3 下午5:51:03
* @email benjaminchen555@gmail.com
*/
@Entity
public class Role extends BaseEntity<Long>{
	private String name;
	
	@ManyToMany
	@JoinTable(name = "role_resource", joinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "resource_id", referencedColumnName = "id") })
	private List<Resource> resources;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
	

}
