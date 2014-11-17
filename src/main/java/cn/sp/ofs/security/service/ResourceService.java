package cn.sp.ofs.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sp.ofs.security.dao.ResourceDao;
import cn.sp.ofs.security.entity.Resource;
import cn.sp.service.IBaseService;

/**
* @author 陈嘉镇
* @version 创建时间：2014-10-29 下午4:51:39
* @email benjaminchen555@gmail.com
*/
@Transactional
@Service
public class ResourceService  implements IBaseService<Resource,Long> {
	@Autowired
	private ResourceDao dao;

	@Override
	public Resource getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Resource entityObject) {
		dao.save(entityObject);
	}

	@Override
	public void delete(Resource entityObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Resource> getAll() {
		// TODO Auto-generated method stub
		return null;
	}




}
