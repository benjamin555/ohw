package cn.sp.ofs.security.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.Page;

import cn.sp.ofs.security.entity.User;
import cn.sp.persistent.BaseEntityDao;

/**
* @author 陈嘉镇
* @version 创建时间：2014-10-29 下午5:02:10
* @email benjaminchen555@gmail.com
*/
@Repository
public class UserDao extends BaseEntityDao<User, Long> {

	@Override
	public Page<User> findPage(int start, int size, Map<String, String> searchMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
