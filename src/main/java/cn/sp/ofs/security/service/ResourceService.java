package cn.sp.ofs.security.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.Page;

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
		return dao.getById(id);
	}

	@Override
	public void save(Resource entityObject) {
		dao.save(entityObject);
	}

	@Override
	public void delete(Resource entityObject) {
		dao.delete(entityObject);
		
	}

	@Override
	public void deleteById(Long id) {
		dao.delete(id);
		
	}

	@Override
	public List<Resource> getAll() {
		List<Resource> all = dao.getAll();
		return all;
	}

	@Override
	public Page<Resource> getPage(int start, int size, Map<String, String> searchMap) {
		// TODO Auto-generated method stub
		return null;
	}



}
