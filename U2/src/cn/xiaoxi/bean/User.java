package cn.xiaoxi.bean;

public class User {
	
	private  int  id;
	private String loginName;
	private String userName;
	private String password;
	private String identityCode;
	private String email;
	private String mobile;
	private  int  sex;
	private  int type;
	
	/**
	 * @param id
	 * @param loginName
	 * @param userName
	 * @param password
	 * @param identityCode
	 * @param email
	 * @param mobile
	 * @param sex
	 * @param type
	 */
	public User(){
		
	}
	
	public User(int id, String loginName, String userName, String password,
			String identityCode, String email, String mobile, int sex, int type) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.userName = userName;
		this.password = password;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;
		this.sex = sex;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
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

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
