package pdsu.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pdsu.project.domain.StudentInformation;

public interface StudentInformationMapper {
    int deleteByPrimaryKey(String studentNumber);

    int insert(StudentInformation record);

    /***
     * 根据用户名查询角色信息
     * @param studentNum
     * @param password
     * @return
     */
    StudentInformation selectByPrimaryKey(@Param("studentNum") String studentNum, @Param("password") String password);




 //根据学号查询学生
    StudentInformation selectByNum(String studentNum);

    //根据班级id查询所拥有的学生
    List<StudentInformation> selectAll(@Param("classId") int classId, @Param("page") Integer page, @Param("pagesize") Integer pagesize);

    /***
     * 更新学生信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(StudentInformation record);

    //根据班级名查询班级id
//    Integer selectClassIdByClassName(String className);



    /**
     * 根据宿舍号查询学生信息
     * @param dormitoryNum
     * @return
     */
    List<StudentInformation> selectByDorNum(Integer dormitoryNum);


    //根据id查询学生信息
    StudentInformation selectById(Integer id);

  //查询所有学生信息
    List<StudentInformation> selectAllStudent();
    //根据学号查询电话名
    String telByStudentNum(String number);

    //根据院系id查询学生
    List<String> selectAllStudentNumByDeptId(Integer deptid);

    //根据院系id和班级查询学生
    List<String> selectAllStudentNumByDeptIdByGrade(@Param("deptid") Integer deptid, @Param("gradeId") Integer gradeId);


    //根据院系id和班级查询学生
    List<String> selectAllStudentNumByDeptIdByGradeAndClassId(@Param("deptid") Integer deptid, @Param("gradeId") Integer gradeId
            , @Param("classId") Integer classId);

    //根据角色id查询角色名
     String roleName(Integer id);

    //根据院系id和年级查询信息
    List<String>  selectAllStudentByDeptIdByGrade(Integer departmentId, Integer gradeId);

    //根据院系和班级id查询
    List<String> selectAllStudentNumByDeptIdByGAndClassId(@Param("deptid") Integer deptid, @Param("classId") Integer classId);

    //通过宿舍id查询
    List<String> selectAllStudentNumByDor(@Param("dor") Integer dor);

    //查询所有的学号
    List<String> allStudentNum();


    List<StudentInformation> selectAllStudentByPage(@Param("page") Integer page, @Param("pageSize") Integer pageSize);


    //查询数量
    public  Integer count();

    //根据院系Id查询所有班级
    List<Integer> selectAllClassId(Integer dept);


    Integer selectCount(Integer classId);
}