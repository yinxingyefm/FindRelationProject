package pdsu.project.dao;

import java.util.List;
import pdsu.project.domain.GradeInformation;

public interface GradeInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GradeInformation record);

    GradeInformation selectByPrimaryKey(Integer id);

    List<GradeInformation> selectAll();

    int updateByPrimaryKey(GradeInformation record);

    Integer selectByGradeName(String name);




}