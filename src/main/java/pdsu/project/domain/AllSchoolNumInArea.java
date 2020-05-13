package pdsu.project.domain;

import java.io.Serializable;

/**
 * @author ljk
 */
public class AllSchoolNumInArea implements Serializable {

    //城市id
    Integer  id;

    //城市名
    private String name;

    //师生在北京的全部数量
    private Integer value;

    //学生在北京的数量
    private Integer student;

    //老师在北京的数量
    private Integer teacher;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "AllSchoolNumInArea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", student=" + student +
                ", teacher=" + teacher +
                '}';
    }
}
