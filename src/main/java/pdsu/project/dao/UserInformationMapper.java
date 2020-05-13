package pdsu.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pdsu.project.domain.UserInformation;

public interface UserInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInformation record);

    //根据主键查询角色
    UserInformation selectByPrimaryKey(@Param("id") Integer id);

    //通过学生查询
    UserInformation selectStudentByKey(@Param("id") Integer id);

    //通过老师查询
    UserInformation selectTeacherByKey(@Param("id") Integer id);

    List<UserInformation> selectAll();

    int updateByPrimaryKey(UserInformation record);

   //根据描述名字查询院系负责人
    UserInformation selectIfo(String departmentName);
}