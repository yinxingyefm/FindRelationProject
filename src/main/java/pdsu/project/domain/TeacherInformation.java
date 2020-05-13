package pdsu.project.domain;

import java.io.Serializable;

public class TeacherInformation  implements Serializable {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private  Integer id;

    private String teacherNumber;

    private String teacherName;

    private String teacherPhone;

    private String teacherContactPhone;

    private Integer teacherPermanentAddress;

    private String teacherDetailPeraddress;

    private String teacherContactName;

    private Integer teacherSex;

    private String teacherPassword;

    private Integer departmentId;

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber == null ? null : teacherNumber.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone == null ? null : teacherPhone.trim();
    }

    public String getTeacherContactPhone() {
        return teacherContactPhone;
    }

    public void setTeacherContactPhone(String teacherContactPhone) {
        this.teacherContactPhone = teacherContactPhone == null ? null : teacherContactPhone.trim();
    }

    public Integer getTeacherPermanentAddress() {
        return teacherPermanentAddress;
    }

    public void setTeacherPermanentAddress(Integer teacherPermanentAddress) {
        this.teacherPermanentAddress = teacherPermanentAddress;
    }

    public String getTeacherDetailPeraddress() {
        return teacherDetailPeraddress;
    }

    public void setTeacherDetailPeraddress(String teacherDetailPeraddress) {
        this.teacherDetailPeraddress = teacherDetailPeraddress == null ? null : teacherDetailPeraddress.trim();
    }

    public String getTeacherContactName() {
        return teacherContactName;
    }

    public void setTeacherContactName(String teacherContactName) {
        this.teacherContactName = teacherContactName == null ? null : teacherContactName.trim();
    }

    public Integer getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(Integer teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword == null ? null : teacherPassword.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }


    @Override
    public String toString() {
        return "TeacherInformation{" +
                "id=" + id +
                ", teacherNumber='" + teacherNumber + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                ", teacherContactPhone='" + teacherContactPhone + '\'' +
                ", teacherPermanentAddress=" + teacherPermanentAddress +
                ", teacherDetailPeraddress='" + teacherDetailPeraddress + '\'' +
                ", teacherContactName='" + teacherContactName + '\'' +
                ", teacherSex=" + teacherSex +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}