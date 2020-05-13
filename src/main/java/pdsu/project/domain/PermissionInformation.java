package pdsu.project.domain;

///权限表
public class PermissionInformation {

    private Integer id;
   //院系id
    private Integer departmentId;

//    班级id
    private Integer classId;

    //宿舍id
    private Integer dormtoryId;

//    用户id
    private Integer userId;

//    年级id
    private Integer gradeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getDormtoryId() {
        return dormtoryId;
    }

    public void setDormtoryId(Integer dormtoryId) {
        this.dormtoryId = dormtoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }


    @Override
    public String toString() {
        return "PermissionInformation{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", classId=" + classId +
                ", dormtoryId=" + dormtoryId +
                ", userId=" + userId +
                ", gradeId=" + gradeId +
                '}';
    }
}