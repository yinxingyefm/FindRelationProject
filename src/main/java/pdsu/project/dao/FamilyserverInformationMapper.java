package pdsu.project.dao;

import java.util.List;
import pdsu.project.domain.FamilyserverInformation;

public interface FamilyserverInformationMapper {
    int deleteByPrimaryKey(Integer famserverId);

    int insert(FamilyserverInformation record);

    FamilyserverInformation selectByPrimaryKey(Integer famserverId);

    List<FamilyserverInformation> selectAll();

    int updateByPrimaryKey(FamilyserverInformation record);
}