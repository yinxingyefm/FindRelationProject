package pdsu.project.dao;

import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface ViewAllSchoolAreaInformationDao {
    /***
     * 根据城市id查询城市姓名
     * @param CityId
     * @return
     */
  public  String CityNameByCityId(Integer CityId);

    /**
     * 查询下边是否含有下一级城市信息
     * @param CityId
     * @return
     */
  public List<Integer> CityIdHasChildNum(Integer CityId);

    /***
     * 根据城市id查询老师所在那个地方的数量
     * @param cityId
     * @return
     */
 public   Integer selectTeacherNumByCityId(@Param("cityId") Integer cityId, @Param("now") LocalDate now);

    /***
     * 根据城市id查询学生所在那个地方的数量
     * @param cityId
     * @return
     */
  public   Integer selectStudentNumByCityId(@Param("cityId") Integer cityId, @Param("now") LocalDate now);

    /***
     * 根据城市id查询老师和学生在那个城市的数量
     * @param cityId
     * @return
     */
  public   Integer selectStudentNumAndTeacherNumNumByCityId(@Param("cityId") Integer cityId, @Param("now") LocalDate now);


}