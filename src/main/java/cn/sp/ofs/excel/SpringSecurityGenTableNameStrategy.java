package cn.sp.ofs.excel;

import cn.sp.ofs.security.SpringSecurityUtils;

/**
* @author 陈嘉镇
* @version 创建时间：2014-11-25 下午1:58:13
* @email benjaminchen555@gmail.com
*/
public class SpringSecurityGenTableNameStrategy implements GenTableNameStrategy {
	
	private int tableId;

	@Override
	public String genName() {
		String userName = SpringSecurityUtils.getCurrentUser().getUserName();
		return userName+(++tableId);
	}

}
