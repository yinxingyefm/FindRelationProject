package pdsu.project.service;

import pdsu.project.domain.AllSchoolNumInArea;

import java.util.List;
import java.util.Map;

/**
 * @author ljk
 */
public interface ViewAllSchoolAreaInformationService {

    /***
     * 统计我校师生在各个地区的人数
     *当天全校师生在分布情况(地图) 通过报备信息获得的最新地址信息
     *cityId  城市id
     *  @return  当天全校师生在分布情况(地图) 通过报备信息获得的最新地址信息
     */
    public List<AllSchoolNumInArea> StudentAndTeacherAreaInformation(Integer cityId);

//    统计师生在各个地区一星期的人数变化

    public Map<String,Object> StudentAndTeacherAreaInformationForWeek(Integer cityId);


   //统计师生在各个地区一星期的人数变化  集合
    public List<Map<String,Object>> StudentAndTeacherAreaInformationForWeekAll(Integer cityId);





}
