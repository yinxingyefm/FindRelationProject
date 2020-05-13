package pdsu.project.dao;

import java.util.List;
import pdsu.project.domain.HealthInformation;

public interface HealthInformationMapper {
    int deleteByPrimaryKey(Integer healthId);

    int insert(HealthInformation record);

    HealthInformation selectByPrimaryKey(Integer healthId);

    List<HealthInformation> selectAll();

    int updateByPrimaryKey(HealthInformation record);
}