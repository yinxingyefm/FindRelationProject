package pdsu.project.dao;

import java.util.List;
import pdsu.project.domain.LogInformation;

public interface LogInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogInformation record);

    LogInformation selectByPrimaryKey(Integer id);

    List<LogInformation> selectAll();

    int updateByPrimaryKey(LogInformation record);
}