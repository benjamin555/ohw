package cn.sp.ofs.security.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import cn.sp.ofs.security.entity.User;

/**
* @author 陈嘉镇
* @version 创建时间：2014-12-3 下午2:56:18
* @email benjaminchen555@gmail.com
*/
public class SecurityUtils {
	static Md5PasswordEncoder encoder = new Md5PasswordEncoder();
	public  static void encodePassword(User u) {
		String pwd = encoder.encodePassword(u.getPassword(), u.getUserName());
		u.setPassword(pwd);
	}
}
