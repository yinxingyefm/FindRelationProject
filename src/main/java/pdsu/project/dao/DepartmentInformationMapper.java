package pdsu.project.dao;

import java.util.List;
import pdsu.project.domain.DepartmentInformation;

public interface DepartmentInformationMapper {
    int deleteByPrimaryKey(Integer departmentId);

    int insert(DepartmentInformation record);

    DepartmentInformation selectByPrimaryKey(Integer departmentId);

    List<DepartmentInformation> selectAll();

    //查询所有院系id
    List<Integer> selectAllDeptId();

    int updateByPrimaryKey(DepartmentInformation record);


    //根据院系名字查询院系号
    Integer selectByDeptName(String dept);
}