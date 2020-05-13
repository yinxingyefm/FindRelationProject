package pdsu.project.domain;

/**
 * @author ljk
 */

/***
 * 体温异常信息
 */
public class UnusualInformation {

    //学号
    private Integer id;
    //温度
    private String temperature;
    //姓名
    private  String name;
    //性别
    private  String sex;
   //紧急联系人姓名
    private  String emergencyName;
   //紧急联系人电话
    private  String  emergencyPhone;
   //地址
    private  String address;
     //宿舍号
    private  Integer dormitoryNum;
    //班级
    private String className;

    //是否外出
    private  String  outDoor;
   //电话
    private String tel;

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDormitoryNum() {
        return dormitoryNum;
    }

    public void setDormitoryNum(Integer dormitoryNum) {
        this.dormitoryNum = dormitoryNum;
    }

    public String getOutDoor() {
        return outDoor;
    }

    public void setOutDoor(String outDoor) {
        this.outDoor = outDoor;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "UnusualInformation{" +
                "id=" + id +
                ", temperature='" + temperature + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", emergencyName='" + emergencyName + '\'' +
                ", emergencyPhone='" + emergencyPhone + '\'' +
                ", address='" + address + '\'' +
                ", dormitoryNum=" + dormitoryNum +
                ", className='" + className + '\'' +
                ", outDoor='" + outDoor + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
