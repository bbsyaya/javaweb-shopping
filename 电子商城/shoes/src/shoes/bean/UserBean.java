package shoes.bean;

import java.sql.Timestamp;

public class UserBean {
	private Integer id;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private Timestamp createDate;
	private int isadmin;
	
	public UserBean() {
		super();
	}
	
	
	

	
	public UserBean(Integer id, String userName, String password, String email, String phone, Timestamp createDate,
			int isadmin) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.createDate = createDate;
		this.isadmin = isadmin;
	}





	public int getIsadmin() {
		return isadmin;
	}





	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}





	public Timestamp getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
