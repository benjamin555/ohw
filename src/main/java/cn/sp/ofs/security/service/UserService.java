package cn.sp.ofs.security.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.Page;

import cn.sp.ofs.security.dao.UserDao;
import cn.sp.ofs.security.entity.User;
import cn.sp.service.IBaseService;

/**
* @author 陈嘉镇
* @version 创建时间：2014-10-29 下午4:51:39
* @email benjaminchen555@gmail.com
*/
@Transactional
@Service
public class UserService  implements IBaseService<User,Long> {
	@Autowired
	private UserDao dao;

	@Override
	public User getById(Long id) {
		return dao.get(id);
	}

	@Override
	public void save(User entityObject) {
		dao.save(entityObject);
	}

	@Override
	public void delete(User entityObject) {
		dao.delete(entityObject);
	}

	@Override
	public void deleteById(Long id) {
		dao.delete(id);
	}

	@Override
	public List<User> getAll() {
		return dao.getAll();
	}

	public User getByUsername(String username) {
		return dao.findUniqueBy("userName", username);
	}

	@Override
	public Page<User> getPage(int start, int size, Map<String, String> searchMap) {
		// TODO Auto-generated method stub
		return null;
	}


}
