package by.epam.hw13.regexpr02.bean;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

	private static final long serialVersionUID = -1306062716466974913L;

	private int userId;
	private String nickName;
	private String email;
	private String phoneNumber;

	public User() {
		super();
	}
	
	public User(String nickName, String email, String phoneNumber) {
		super();		
		this.nickName = nickName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public User(int userId, String nickName, String email, String phoneNumber) {
		super();
		this.userId = userId;
		this.nickName = nickName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, nickName, phoneNumber, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(nickName, other.nickName)
				&& Objects.equals(phoneNumber, other.phoneNumber) && userId == other.userId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", nickName=" + nickName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ "]";
	}

}
