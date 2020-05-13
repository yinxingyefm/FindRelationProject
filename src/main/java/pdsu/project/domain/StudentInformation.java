package pdsu.project.domain;

import java.io.Serializable;

public class StudentInformation  implements Serializable {

    //自增id
    private  Integer id;

    private  Integer gradeId;

    //学号
    private String studentNumber;

    //学生姓名
    private String studentName;

    //宿舍号
    private Integer studentDormitory;

    //性别
    private Integer studentSex;

    //班级id
    private Integer  classId;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    //手机号
    private String studentPhone;

    //联系电话
    private String studentContactPhone;

    //家庭常住地址
    private Integer studentPermanentAddress;

     //家庭详细地址
    private String studentDetailPeraddress;

    //
    private Integer studentCensusAddress;

    private String studentContactName;

    private Integer studentDepartment;

    private String studentPassword;

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public Integer getStudentDormitory() {
        return studentDormitory;
    }

    public void setStudentDormitory(Integer studentDormitory) {
        this.studentDormitory = studentDormitory;
    }

    public Integer getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(Integer studentSex) {
        this.studentSex = studentSex;
    }



    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone == null ? null : studentPhone.trim();
    }

    public String getStudentContactPhone() {
        return studentContactPhone;
    }

    public void setStudentContactPhone(String studentContactPhone) {
        this.studentContactPhone = studentContactPhone == null ? null : studentContactPhone.trim();
    }

    public Integer getStudentPermanentAddress() {
        return studentPermanentAddress;
    }

    public void setStudentPermanentAddress(Integer studentPermanentAddress) {
        this.studentPermanentAddress = studentPermanentAddress;
    }

    public String getStudentDetailPeraddress() {
        return studentDetailPeraddress;
    }

    public void setStudentDetailPeraddress(String studentDetailPeraddress) {
        this.studentDetailPeraddress = studentDetailPeraddress == null ? null : studentDetailPeraddress.trim();
    }

    public Integer getStudentCensusAddress() {
        return studentCensusAddress;
    }

    public void setStudentCensusAddress(Integer studentCensusAddress) {
        this.studentCensusAddress = studentCensusAddress;
    }

    public String getStudentContactName() {
        return studentContactName;
    }

    public void setStudentContactName(String studentContactName) {
        this.studentContactName = studentContactName == null ? null : studentContactName.trim();
    }

    public Integer getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(Integer studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword == null ? null : studentPassword.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentInformation{" +
                "id=" + id +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentDormitory=" + studentDormitory +
                ", studentSex=" + studentSex +
                ", classId=" + classId +
                ", studentPhone='" + studentPhone + '\'' +
                ", studentContactPhone='" + studentContactPhone + '\'' +
                ", studentPermanentAddress=" + studentPermanentAddress +
                ", studentDetailPeraddress='" + studentDetailPeraddress + '\'' +
                ", studentCensusAddress=" + studentCensusAddress +
                ", studentContactName='" + studentContactName + '\'' +
                ", studentDepartment=" + studentDepartment +
                ", studentPassword='" + studentPassword + '\'' +
                '}';
    }
}