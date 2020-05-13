package pdsu.project.domain;

/**
 * @author ljk
 */

//分级录入信息
public class RecordInfo {

    //学号
  private  String num;

  //姓名
  private String name;
  //院系/班级
  private  String emplorye;

  //电话号
  private String phone;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmplorye() {
        return emplorye;
    }

    public void setEmplorye(String emplorye) {
        this.emplorye = emplorye;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "RecordInfo{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", emplorye='" + emplorye + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
