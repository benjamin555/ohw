package cn.sp.ofs.security.hibernate.interceptor;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.sp.ofs.security.SpringSecurityUtils;
import cn.sp.persistent.BaseEntity;

/**
* @author 陈嘉镇
* @version 创建时间：2014-12-5 下午4:38:02
* @email benjaminchen555@gmail.com
*/
@SuppressWarnings({ "serial", "rawtypes" })
@Component
public class BaseEntityPersistentInterceptor extends EmptyInterceptor {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		//entity就是当前的实体对象
		//如果当前操作的TbUser，则做处理
		if (entity instanceof BaseEntity) {
			// 获取对象
			BaseEntity en = (BaseEntity) entity;

			try {
				String currentUser = SpringSecurityUtils.getCurrentUserId();

				if (en.getId() == null) {
					for (int i = 0; i < propertyNames.length; i++) {
						if ("creator".equals(propertyNames[i])) {
							state[i] = currentUser;
							return true;
						}
					}
				} else {
					for (int i = 0; i < propertyNames.length; i++) {
						if ("updater".equals(propertyNames[i])) {
							state[i] = currentUser;
							return true;
						}
					}
				}
			} catch (Exception e) {
				logger.error("error.", e);
			}
		}
		return super.onSave(entity, id, state, propertyNames, types);
	}
}
