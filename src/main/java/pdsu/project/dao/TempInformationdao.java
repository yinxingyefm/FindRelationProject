package pdsu.project.dao;

import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface TempInformationdao {

//   查询当天早上正常学生或者老师的数量
     Integer selectNumInMorNormal(@Param("type") Integer type, @Param("now") LocalDate now, @Param("temp") float temp);
//      查询当天早上不正常学生或者老师的数量
     Integer selectNumInMorUnNomal(@Param("type") Integer type, @Param("now") LocalDate now, @Param("temp") float temp);
//   查询当天早上学生或者老师的录入体温的总人数

     //   查询当天中午正常学生或者老师的数量
     Integer selectNumInLunNormal(@Param("type") Integer type, @Param("now") LocalDate now, @Param("temp") float temp);
     //      查询当天中午不正常学生或者老师的数量
     Integer selectNumInLunUnNomal(@Param("type") Integer type, @Param("now") LocalDate now, @Param("temp") float temp);

     //   查询当天中午正常学生或者老师的数量
     Integer selectNumInEveNormal(@Param("type") Integer type, @Param("now") LocalDate now, @Param("temp") float temp);
     //      查询当天中午不正常学生或者老师的数量
     Integer selectNumInEveUnNomal(@Param("type") Integer type, @Param("now") LocalDate now, @Param("temp") float temp);

     //所有统计的
     //
     Integer  selectAllCountByStu(Integer type);






}