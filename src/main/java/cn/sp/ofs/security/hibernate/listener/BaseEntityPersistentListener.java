package cn.sp.ofs.security.hibernate.listener;

import org.hibernate.event.PreInsertEvent;
import org.hibernate.event.PreInsertEventListener;
import org.hibernate.event.PreUpdateEvent;
import org.hibernate.event.PreUpdateEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sp.ofs.security.SpringSecurityUtils;
import cn.sp.persistent.BaseEntity;

/**
* @author 陈嘉镇
* @version 创建时间：2014-11-20 下午3:46:33
* @email benjaminchen555@gmail.com
*/
@SuppressWarnings({ "rawtypes", "serial" })
public class BaseEntityPersistentListener implements PreInsertEventListener, PreUpdateEventListener {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean onPreInsert(PreInsertEvent event) {
		// 过滤，只对BaseDomain的子对象记录修改历史
		if (event.getEntity() instanceof BaseEntity) {
			logger.info("onPreInsert Object is {}", event.getEntity().getClass().getName());
			// 获取对象
			BaseEntity entity = (BaseEntity) event.getEntity();
			
			try {
				String currentUser = SpringSecurityUtils.getCurrentUserId();
				entity.setCreator(currentUser);
			} catch (Exception e) {
				logger.error("error.",e);
			}
			
		}
		return false;
	}

	@Override
	public boolean onPreUpdate(PreUpdateEvent event) {
		// 过滤，只对BaseDomain的子对象记录修改历史
		if (event.getEntity() instanceof BaseEntity) {
			logger.info("onPreUpdate Object is {}", event.getEntity().getClass().getName());
			// 获取对象
			BaseEntity entity = (BaseEntity) event.getEntity();
			try {
				String currentUser = SpringSecurityUtils.getCurrentUserId();
				entity.setUpdater(currentUser);
			} catch (Exception e) {
				logger.error("error.",e);
			}
		}
		return false;
	}

}
