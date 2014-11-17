package cn.sp.ofs.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cn.sp.ofs.security.entity.Role;
import cn.sp.ofs.security.entity.User;

@SuppressWarnings("serial")
public class UserDetailsExtend extends User implements UserDetails {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private Set<GrantedAuthority> authorities;

	public UserDetailsExtend(User u) {
		try {
			BeanUtils.copyProperties(this, u);
		} catch (Exception e) {
			logger.error("error.",e);
		} 
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		if (authorities==null) {
			 authorities = new HashSet<GrantedAuthority>();
			Set<Role> rs = getRoles();
			for (Role role : rs) {
				GrantedAuthority g = new SimpleGrantedAuthority(role.getId() + "");
				authorities.add(g);
			}
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
