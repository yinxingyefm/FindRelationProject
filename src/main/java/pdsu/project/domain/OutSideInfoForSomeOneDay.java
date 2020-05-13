package pdsu.project.domain;

/**
 * @author ljk
 */
public class OutSideInfoForSomeOneDay {
    private  Integer id;

    private String outDoor;

    private  String name;

    private String className;

    private  String  address;

    private  String dormitoryNum;

    private  String tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOutDoor() {
        return outDoor;
    }

    public void setOutDoor(String outDoor) {
        this.outDoor = outDoor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDormitoryNum() {
        return dormitoryNum;
    }

    public void setDormitoryNum(String dormitoryNum) {
        this.dormitoryNum = dormitoryNum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "OutSideInfoForSomeOneDay{" +
                "id='" + id + '\'' +
                ", outDoor='" + outDoor + '\'' +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", address='" + address + '\'' +
                ", dormitoryNum='" + dormitoryNum + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
