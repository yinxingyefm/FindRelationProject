package pdsu.project.dao;

import java.util.List;
import pdsu.project.domain.DormitoryInformation;

public interface DormitoryInformationMapper {
    int deleteByPrimaryKey(Integer dormitoryId);

    int insert(DormitoryInformation record);

    DormitoryInformation selectByPrimaryKey(Integer dormitoryId);

    List<DormitoryInformation> selectAll();

    int updateByPrimaryKey(DormitoryInformation record);
}