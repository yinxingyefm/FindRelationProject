package pdsu.project.dao;

import java.util.List;
import pdsu.project.domain.BackschoolInformation;

public interface BackschoolInformationMapper {
    int deleteByPrimaryKey(Integer backschoolId);

    int insert(BackschoolInformation record);

    BackschoolInformation selectByPrimaryKey(Integer backschoolId);

    List<BackschoolInformation> selectAll();

    int updateByPrimaryKey(BackschoolInformation record);
}