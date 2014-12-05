package cn.sp.ofs.excel.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.Page;

import cn.sp.ofs.excel.entity.Qstatement;
import cn.sp.persistent.BaseEntityDao;
import cn.sp.persistent.HqlUtil;

/**
* @author 陈嘉镇
* @version 创建时间：2014-10-29 下午5:02:10
* @email benjaminchen555@gmail.com
*/
@Repository
public class QstatementDao extends BaseEntityDao<Qstatement, Long> {

	@Override
	public Page<Qstatement> findPage(int start, int size, Map<String, String> searchMap) {
		Page<Qstatement> page = new Page<Qstatement>();
		page.setPageSize(size);
		page.setStart(start);
		Map<String, Object> values = new HashMap<String, Object>();
		String append = HqlUtil.buildHqlAppend(searchMap, values);
		String hql = "select m from Qstatement m  where m.isUse='Y' ";
		hql += append;
		logger.info(hql);
		return findPage(page, hql, values);
	}

	public Page<Qstatement> findShared(int start, int size, long sharedUserId, Map<String, String> searchMap) {
		Page<Qstatement> page = new Page<Qstatement>();
		page.setPageSize(size);
		page.setStart(start);
		Map<String, Object> values = new HashMap<String, Object>();
		String append = HqlUtil.buildHqlAppend(searchMap, values);
		String hql = "select m from Qstatement m join m.sharedUsers s where m.isUse='Y' and :sharedUserId = s.id  ";
		hql += append;
		values.put("sharedUserId", sharedUserId);
		logger.info(hql);
		return findPage(page, hql, values);
	}


}
