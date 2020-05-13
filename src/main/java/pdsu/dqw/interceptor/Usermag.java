package pdsu.dqw.interceptor;

import com.alibaba.fastjson.JSONObject;

public class Usermag {
	private Integer id;
	private String num;
	private String userName;
	private String phone;
	private String role;
	private String employer;
	private String password;
	@Override
	public String toString() {
		return "Usermag [id=" + id + ", num=" + num + ", userName=" + userName + ", phone=" + phone + ", role=" + role
				+ ", employer=" + employer + ", password=" + password + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

public static void main(String[] args) {
	Usermag user=new Usermag();
	user.setNum("181530316");
	user.setEmployer("软件工程(移动互联网)18软工3班(移动互联网)");
	user.setPhone("123456");
	user.setRole("user");
	user.setPassword("123");
	user.setUserName("张航1");
	System.out.println(JSONObject.toJSON(user).toString());
}

}
