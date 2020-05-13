package pdsu.project.dao;

import java.util.List;
import pdsu.project.domain.ClassInformation;

public interface ClassInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassInformation record);

    ClassInformation selectByPrimaryKey(Integer id);
    //根据班级名查询班级信息
    ClassInformation selectByClassName(String className);

    List<ClassInformation> selectAll(List<Integer> list);

    int updateByPrimaryKey(ClassInformation record);

    //根据班级名字查询班级id
    Integer selectByClassName1(String className);
}