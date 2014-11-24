package cn.sp.ofs.security.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.Page;

import cn.sp.ofs.security.dao.RoleDao;
import cn.sp.ofs.security.entity.Role;
import cn.sp.service.IBaseService;

/**
* @author 陈嘉镇
* @version 创建时间：2014-10-29 下午4:51:39
* @email benjaminchen555@gmail.com
*/
@Transactional
@Service
public class RoleService  implements IBaseService<Role,Long> {
	@Autowired
	private RoleDao dao;

	@Override
	public Role getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void save(Role entityObject) {
		dao.save(entityObject);
	}

	@Override
	public void delete(Role entityObject) {
		dao.delete(entityObject);
	}

	@Override
	public void deleteById(Long id) {
		dao.delete(id);
	}

	@Override
	public List<Role> getAll() {
		List<Role> all = dao.getAll();
		for (Role role : all) {
			Hibernate.initialize(role.getResources());
		}
		return all;
	}

	@Override
	public Page<Role> getPage(int start, int size, Map<String, String> searchMap) {
		// TODO Auto-generated method stub
		return null;
	}



}
