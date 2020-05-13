package pdsu.project.dao;

import java.util.List;
import pdsu.project.domain.GoserverInformation;

public interface GoserverInformationMapper {
    int deleteByPrimaryKey(Integer goserverId);

    int insert(GoserverInformation record);

    GoserverInformation selectByPrimaryKey(Integer goserverId);

    List<GoserverInformation> selectAll();

    int updateByPrimaryKey(GoserverInformation record);
}