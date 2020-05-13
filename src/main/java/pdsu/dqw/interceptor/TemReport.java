package pdsu.dqw.interceptor;

import com.alibaba.fastjson.JSONObject;

public class TemReport {
	private String name;
	private String  num;
	private float tempture;
	private int temSection;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public float getTempture() {
		return tempture;
	}
	public void setTempture(float tempture) {
		this.tempture = tempture;
	}
	public int getTemSection() {
		return temSection;
	}
	public void setTemSection(int temSection) {
		this.temSection = temSection;
	}
	@Override
	public String toString() {
		return "TemReport [name=" + name + ", num=" + num + ", tempture=" + tempture + ", temSection=" + temSection
				+ "]";
	}
	public static void main(String[] args) {
		TemReport temReport=new TemReport();
		temReport.setName("杨文静");
		temReport.setNum("171530340");
		temReport.setTempture((float) 36.6);
		temReport.setTemSection(0);
		System.out.println(JSONObject.toJSON(temReport).toString());
		
	}

}
