package pdsu.project.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import pdsu.project.domain.TemptureInformation;

public interface TemptureInformationMapper {

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("temptureNum") Integer temptureNum);

    int insert(TemptureInformation record);

    TemptureInformation selectByPrimaryKey(@Param("id") Integer id, @Param("temptureNum") Integer temptureNum);

     List<TemptureInformation> selectAll(@Param("localDate") LocalDate localDate, @Param("type") Integer type);

    int updateByPrimaryKey(TemptureInformation record);

    //根据时间查询温度异常学号的
    Integer count(@Param("localdate") LocalDate localDate, @Param("type") Integer type, @Param("temp") Float temp, @Param("num") String num);

    //查询正常的
    Integer countNormal(@Param("localdate") LocalDate localDate, @Param("type") Integer type, @Param("temp") Float temp, @Param("num") String num);

    //根据时间查询所有的人数统计体温的人数
    Integer countNnll(@Param("localdate") LocalDate localDate, @Param("type") Integer type);

    //查询正常的
    Integer countNormalAll(@Param("localdate") LocalDate localDate, @Param("type") Integer type, @Param("temp") Float temp);


    TemptureInformation selectByNum(@Param("localDate") LocalDate localDate, @Param("num") String num);
  //查询已经统计的
   Integer selectCount(@Param("localDate") LocalDate localDate, @Param("num") String num);

   ;


    //根据时间查询这天所有的数据
    Integer countNnllByNum(@Param("localdate") LocalDate localDate, @Param("type") Integer type, @Param("temp") Float temp, @Param("list") String list);

    //查询不正常的
    Integer countNormalAllByNum(@Param("localdate") LocalDate localDate, @Param("type") Integer type, @Param("temp") Float temp, @Param("list") String list);

    //早上未录入
    List<TemptureInformation> slectAllUnRecord(@Param("localdate") LocalDate localDate, @Param("type") Integer type, @Param("list") ArrayList<Integer> list);

    //中午未录入
    List<TemptureInformation> slectAllUnRecordLun(@Param("localdate") LocalDate localDate, @Param("type") Integer type, @Param("list") ArrayList<Integer> list);
    //中午未录入
    List<TemptureInformation> slectAllUnRecordEve(@Param("localdate") LocalDate localDate, @Param("type") Integer type, @Param("list") ArrayList<Integer> list);

    List<TemptureInformation> slectAllRecord1(@Param("localdate") LocalDate localDate, @Param("type") Integer type);

    ///插叙上报信息
    TemptureInformation selectByNum1(@Param("temptureNum") Integer temptureNum, @Param("localDate") LocalDate localDate);







}