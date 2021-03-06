package cn.sp.ofs.excel.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.Page;

import cn.sp.ofs.excel.dao.QstatementDao;
import cn.sp.ofs.excel.entity.Qstatement;
import cn.sp.service.IBaseService;

/**
* @author 陈嘉镇
* @version 创建时间：2014-10-29 下午4:51:39
* @email benjaminchen555@gmail.com
*/
@Transactional
@Service
public class QstatementService  implements IBaseService<Qstatement,Long> {
	@Autowired
	private QstatementDao dao;

	@Override
	public Qstatement getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void save(Qstatement entityObject) {
		dao.save(entityObject);
	}

	@Override
	public void delete(Qstatement entityObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Qstatement> getAll() {
		return dao.getAll();
	}

	@Override
	public Page<Qstatement> getPage(int start, int size, Map<String, String> searchMap) {
		return dao.findPage(start, size, searchMap);
	}

	public void shareTo(Qstatement qstatement, long sharedUserId) {
		qstatement.shareTo(sharedUserId);
		dao.save(qstatement);
	}

	/**
	 * 获取分享的
	 * @param start
	 * @param size
	 * @param sharedUserId 被分享帐号id
	 * @param searchMap
	 * @return
	 */
	public Page<Qstatement> getShared(int start, int size, long sharedUserId, Map<String, String> searchMap) {
		return dao.findShared(start, size,sharedUserId, searchMap);
	}

	public void shareTo(long[] ids, long sharedUserId) {
		for (long l : ids) {
			Qstatement qstatement = getById(l);
			shareTo(qstatement, sharedUserId);
		}
	}

}
