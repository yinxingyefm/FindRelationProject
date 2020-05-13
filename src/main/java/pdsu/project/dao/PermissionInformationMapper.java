package pdsu.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pdsu.project.domain.PermissionInformation;

//权限表
public interface PermissionInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermissionInformation record);

    PermissionInformation selectByPrimaryKey(Integer id);

    //通过用户id查询权限信息
    PermissionInformation selectByUserId(Integer id);

    List<PermissionInformation> selectAll(Integer userId);

    int updateByPrimaryKey(PermissionInformation record);

    //通过角色查询角色id
    Integer roleIdByRloe(String role);

    // 根据院系和年级查询班级id
    List<Integer> allClassIdByGradeAndDeptId(@Param("dept") Integer dept, @Param("gradeId") Integer gradeId);

    //根据年级/院系/班级查询宿舍号
    List<Integer> allDorIdByGradeAndDeptIdAndClassId(@Param("dept") Integer dept, @Param("gradeId") Integer gradeId, @Param("classId") Integer classId);

    //动态数据查询信息id
    List<Integer>  findAllUserId(@Param("dept") Integer dept, @Param("gradeId") Integer gradeId,
                                 @Param("classId") Integer classId, @Param("dorId") Integer dorId);

}