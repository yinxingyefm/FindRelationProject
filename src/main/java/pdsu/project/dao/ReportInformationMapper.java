package pdsu.project.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import pdsu.project.domain.ReportInformation;

public interface ReportInformationMapper {
    int deleteByPrimaryKey(Integer reportId);

    int insert(ReportInformation record);

//    查询所有报备信息
    List<ReportInformation> selectAll(@Param("number") String number, @Param("type") Integer type);

    List<ReportInformation> selectAllByTime(@Param("localDate") LocalDate localDate, @Param("type") Integer type);

    int updateByPrimaryKey(ReportInformation record);


    ReportInformation selectByNum(String num);


    Integer selesctByTime(@Param("date") Date date, @Param("studentNumber") String studentNumber);

    ReportInformation selectByNumAndToday(@Param("studentNumber") String studentNumber, @Param("now") LocalDate now);
}