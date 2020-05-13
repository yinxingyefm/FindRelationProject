package pdsu.dqw.interceptor;

import com.alibaba.fastjson.JSONObject;

public class Password {
	private String oldPassword;
	private String Newpassword;
	private String num;
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewpassword() {
		return Newpassword;
	}
	public void setNewpassword(String newpassword) {
		Newpassword = newpassword;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Password [oldPassword=" + oldPassword + ", Newpassword=" + Newpassword + ", num=" + num + "]";
	}
	public static void main(String[] args) {
		Password ps=new Password();
		ps.setNum("181530316");
		ps.setOldPassword("123");
		ps.setNewpassword("123456");
		System.out.println(JSONObject.toJSON(ps).toString());
	}
	

}
