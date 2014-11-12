package cn.sp.ofs.security;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import cn.sp.ofs.excel.entity.Role;
import cn.sp.ofs.excel.entity.User;
import cn.sp.ofs.excel.service.UserService;

/**
 * 实现SpringSecurity的UserDetailsService接口,实现获取用户Detail信息的回调函数.
 * 
 * @author calvin
 */
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

	private Logger log = LoggerFactory.getLogger(UserDetailsService.class);
	@Autowired
	private UserService userService ;

	@Override
	public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException {
		User u = userService.getByUsername(username);
		log.info("user:{}",u);
		UserDetailsExtend userdetails = new UserDetailsExtend();
		userdetails.setUsername(u.getUserName());
		userdetails.setPassword(u.getPassword());
		userdetails.setAccountNonExpired(true);
		userdetails.setAccountNonLocked(true);
		userdetails.setCredentialsNonExpired(true);
		userdetails.setEnabled(true);
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		Set<Role> rs = u.getRoles();
		for (Role role : rs) {
			GrantedAuthority g = new SimpleGrantedAuthority(role.getId()+"");
			authorities.add(g );
		}
		userdetails.setAuthorities(authorities );
		
		return userdetails;
	}
}
