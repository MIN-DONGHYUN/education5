package com.jpa.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_member")
public class Member { // public class Member implements Serializable

	@Id
	@Column(name="userid", nullable = false, length = 50)
	private String userId; // userId 는 user_id 로 인식되므로 name 속성이 필요 
	
	@Column(name="username", nullable = false, length = 30)
	private String userName; // userName 는 user_name 로 인식되므로 name 속성이 필요 
	
	@Column(name="userpwd", nullable = false, length = 50)
	private String userPwd;  // userPwd 는 user_pwd 로 인식되므로 name 속성이 필요 
	
	@Column(nullable = false, columnDefinition = "DATE DEFAULT SYSDATE", insertable = false, updatable = false)
	private String reg_date; // insertable = false 로 설정하면 이 필드는 DB에 insert 되지 않는다.
	                         // updatable = false 로 해주면 update 문이 수행될때 이 컬럼의 값은 변경하지 않겠다는 말이다. 
	
/*	
	@PrePersist // INSERT 전에 호출한다. 
	public void prePersist() {
		this.reg_date = this.reg_date == null ? 
				new java.sql.Date(new java.util.Date().getTime()).toString() : 
				this.reg_date;
	}
*/
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
}
