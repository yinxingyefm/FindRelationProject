package pdsu.dqw.interceptor;

public class Ps {
	private String num;
	private String password;
	@Override
	public String toString() {
		return "Ps [num=" + num + ", password=" + password + "]";
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Ps() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ps(String num, String password) {
		super();
		this.num = num;
		this.password = password;
	}
	

}
