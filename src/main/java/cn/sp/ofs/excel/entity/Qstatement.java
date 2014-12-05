package cn.sp.ofs.excel.entity;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.Hibernate;

import cn.sp.ofs.security.entity.User;
import cn.sp.persistent.BaseEntity;

/**
* @author 陈嘉镇
* @version 创建时间：2014-10-29 下午4:29:09
* @email benjaminchen555@gmail.com
*/
@Entity
public class Qstatement extends BaseEntity<Long> {

	private String description;

	private java.sql.Clob content;

	private String skipRowStr;

	@ManyToMany
	@JoinTable(name = "qstatement_user", joinColumns = { @JoinColumn(name = "q_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "u_id", referencedColumnName = "id") })
	private List<User> sharedUsers;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public java.sql.Clob getContent() {
		return content;
	}

	public void setContent(java.sql.Clob content) {
		this.content = content;
	}

	public String getSkipRowStr() {
		return skipRowStr;
	}

	public void setSkipRowStr(String skipRowStr) {
		this.skipRowStr = skipRowStr;
	}

	private String getClob(Clob c) {
		Reader reader;
		StringBuffer sb = new StringBuffer();
		try {
			reader = c.getCharacterStream();
			BufferedReader br = new BufferedReader(reader);
			String temp = null;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	@Transient
	public String getContent2String() {
		if (getContent() == null) {
			return "";
		}
		return getClob(getContent());
	}

	@Transient
	public void setContent(String string) {
		Clob clob = Hibernate.createClob(string);
		setContent(clob);
	}

	public void shareTo(long sharedUserId) {
		if (sharedUsers == null) {
			sharedUsers = new ArrayList<User>();
		}

		//判断userid是否已经存在，存在的不进行更新
		if (!isExists(sharedUserId)) {
			User e = new User();
			e.setId(sharedUserId);
			sharedUsers.add(e);
		}
	}

	/**
	 * 判断userid是否已经存在分享中
	 * @param sharedUserId
	 * @return
	 */
	private boolean isExists(long sharedUserId) {
		if (sharedUsers != null && !sharedUsers.isEmpty()) {
			for (User u : sharedUsers) {
				if (sharedUserId == u.getId()) {
					return true;
				}
			}
		}
		return false;
	}

	public List<User> getSharedUsers() {
		return sharedUsers;
	}

	public void setSharedUsers(List<User> sharedUsers) {
		this.sharedUsers = sharedUsers;
	}

}
