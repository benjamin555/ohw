package cn.sp.ofs.excel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sp.ofs.excel.dao.UserDao;
import cn.sp.ofs.excel.entity.User;
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
		return null;
	}

	@Override
	public void save(User entityObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User entityObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
