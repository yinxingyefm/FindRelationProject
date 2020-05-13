package pdsu.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pdsu.project.domain.TeacherInformation;

public interface TeacherInformationMapper {
    int deleteByPrimaryKey(String teacherNumber);

    int insert(TeacherInformation record);

    TeacherInformation selectByPrimaryKey(@Param("teacherNum") String teacherNum, @Param("password") String password);

    List<TeacherInformation> selectAll();

    //分页
    List<TeacherInformation> selectAllByPag(@Param("page") Integer page, @Param("pageSize") Integer pageSize);


    int updateByPrimaryKey(TeacherInformation record);

    TeacherInformation selectByTeacherNum(@Param("teacherNum") String teacherNum) throws Exception;

    TeacherInformation selectById(Integer id);

    String selecrByDepartId(Integer dept);

    //根据工号查询手机号
    public String  SelectTelphoneByTeacherNum(String teacherNum);

    List<String> selectAllTeacherNumByDeptId(Integer dept);

    //查询所有的工号
    List<String> selectAllTeacherNum();

    //通过年假id查询年级等级
    String selecrByGradeId(Integer gradeId);

    Integer count();

}