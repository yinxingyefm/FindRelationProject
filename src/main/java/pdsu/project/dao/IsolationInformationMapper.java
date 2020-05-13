package pdsu.project.dao;

import java.util.List;
import pdsu.project.domain.IsolationInformation;

public interface IsolationInformationMapper {
    int deleteByPrimaryKey(Integer isolationId);

    int insert(IsolationInformation record);

    IsolationInformation selectByPrimaryKey(Integer isolationId);

    List<IsolationInformation> selectAll();

    int updateByPrimaryKey(IsolationInformation record);
}