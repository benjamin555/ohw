package cn.sp.ofs.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import cn.sp.ofs.excel.entity.Role;
import cn.sp.ofs.excel.entity.User;

public class SpringSecurityUserContext implements UserContext {
	/**
	 * Get the {@link User} by casting the {@link Authentication}'s principal to a {@link User}.
	 */
	@Override
	public User getCurrentUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication == null) {
			return null;
		}
		return (User) authentication.getPrincipal();
	}

	/**
	 * Sets the {@link User} as the current {@link Authentication}'s principal. It uses
	 */
	@Override
	public void setCurrentUser(User user) {
		if (user == null) {
			throw new IllegalArgumentException("user cannot be null");
		}
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities = new HashSet<GrantedAuthority>();
		Set<Role> rs = user.getRoles();
		for (Role role : rs) {
			GrantedAuthority g = new SimpleGrantedAuthority(role.getId() + "");
			authorities.add(g);
		}
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,
				user.getPassword(), authorities);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}