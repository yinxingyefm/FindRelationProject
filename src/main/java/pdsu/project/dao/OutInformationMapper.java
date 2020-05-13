package pdsu.project.dao;

import java.util.List;
import pdsu.project.domain.OutInformation;

public interface OutInformationMapper {
    int deleteByPrimaryKey(Integer outId);

    int insert(OutInformation record);

    OutInformation selectByPrimaryKey(Integer outId);

    List<OutInformation> selectAll();

    int updateByPrimaryKey(OutInformation record);
}