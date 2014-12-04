package cn.sp.ofs.excel;

import cn.sp.ofs.security.SpringSecurityUtils;
import cn.sp.ofs.security.entity.User;

/**
* @author 陈嘉镇
* @version 创建时间：2014-11-25 下午1:58:13
* @email benjaminchen555@gmail.com
*/
public class SpringSecurityGenTableNameStrategy extends SimpleGenTableNameStrategy implements GenTableNameStrategy {
	private String userName; 
	private int tableId;

	 public SpringSecurityGenTableNameStrategy() {
		User currentUser = SpringSecurityUtils.getCurrentUser();
		if (currentUser!=null) {
			this.userName = currentUser.getUserName();
		}
	}

	@Override
	public String genName() {
		if (userName==null) {
			return super.genName();
		}
		return userName+(++tableId);
	}

	@Override
	public String getPerFix() {
		if (userName==null) {
			return super.getPerFix();
		}
		return userName;
	}

}
