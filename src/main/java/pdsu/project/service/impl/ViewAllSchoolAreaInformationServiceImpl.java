package pdsu.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdsu.project.dao.AreaDataMapper;
import pdsu.project.dao.ViewAllSchoolAreaInformationDao;
import pdsu.project.domain.AllSchoolNumInArea;
import pdsu.project.domain.AreaData;
import pdsu.project.domain.AreaInfoFoWeek;
import pdsu.project.service.AreaService;
import pdsu.project.service.ViewAllSchoolAreaInformationService;
import pdsu.project.utils.DateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ljk
 */

/***
 * 实现功能展示每天每个地区师生流动变化
 */
@Service
public class ViewAllSchoolAreaInformationServiceImpl implements ViewAllSchoolAreaInformationService {

    /***
     * 注入每天学校师生在各个地区流动接口
     */
    @Autowired
    private ViewAllSchoolAreaInformationDao viewAllSchoolAreaInformationDao;

    //地区信息
    @Autowired
    private AreaDataMapper areaDataMapper;

    /***
     * 传入城市id获取某个传全国/某个省/某个市名下边我校各个师生的数量信息
     * @param cityId
     * @return
     * 2
     */
    @Override
    public List<AllSchoolNumInArea> StudentAndTeacherAreaInformation(Integer cityId) {
        List<AllSchoolNumInArea> list=new ArrayList<>();
        //查询出来的所有子id
        List<Integer> cityIdHasChildNum = viewAllSchoolAreaInformationDao.CityIdHasChildNum(cityId);
        //获得当前时间
        LocalDate now = LocalDate.now();
        /***
         * 进行模糊查询,如果有下一级就进行模糊查询,
         * 即使下一级还有子节点,用模糊查询匹配所有的节点信息
         */
        if( cityIdHasChildNum.size()!=0 && cityIdHasChildNum.size()>1)
        {
            for (Integer i: cityIdHasChildNum) {
                AreaData areaData = areaDataMapper.selectByPrimaryKey(i);
                AllSchoolNumInArea allSchoolNumInArea = new AllSchoolNumInArea();
                allSchoolNumInArea.setId(areaData.getCodeId());
                allSchoolNumInArea.setName(areaData.getCityName());
                //老师的数量,
                Integer teachereNum=viewAllSchoolAreaInformationDao.selectTeacherNumByCityId(i,now);
                allSchoolNumInArea.setTeacher(teachereNum);
                //学生的数量
                Integer studentNumByCityId = viewAllSchoolAreaInformationDao.selectStudentNumByCityId(i,now);
                allSchoolNumInArea.setStudent(studentNumByCityId);
                //老师和学生在这个城市的所有数量
                Integer studentNumAndTeacherNumNumByCityId = viewAllSchoolAreaInformationDao.selectStudentNumAndTeacherNumNumByCityId(i,now);
                //所有数量
                allSchoolNumInArea.setValue(studentNumAndTeacherNumNumByCityId);
                list.add(allSchoolNumInArea);
            }
        }else {
            AreaData areaData = areaDataMapper.selectByPrimaryKey(cityId);
            //老师的数量
            Integer teachereNum=viewAllSchoolAreaInformationDao.selectTeacherNumByCityId(cityId,now);
          AllSchoolNumInArea allSchoolNumInArea=  new AllSchoolNumInArea();
           allSchoolNumInArea.setName(areaData.getCityName());
            //学生的数量
            Integer studentNumByCityId = viewAllSchoolAreaInformationDao.selectStudentNumByCityId(cityId,now);
            allSchoolNumInArea.setStudent(studentNumByCityId);
            //老师和学生在这个城市的所有数量
            Integer studentNumAndTeacherNumNumByCityId = viewAllSchoolAreaInformationDao.selectStudentNumAndTeacherNumNumByCityId(cityId,now);
            allSchoolNumInArea.setValue(studentNumAndTeacherNumNumByCityId);
        }

        return list;
    }

    //3
    @Override
    public Map<String, Object> StudentAndTeacherAreaInformationForWeek(Integer cityId) {

        //根据城市id查询城市的名字
        String nameByCityId = viewAllSchoolAreaInformationDao.CityNameByCityId(cityId);
        //分析数据展示信息
        AreaInfoFoWeek foWeek = new AreaInfoFoWeek();
        //用来存放师生数量的变化
        ArrayList<Integer> arrayList = new ArrayList<>();
        //获取当前一天起前七天的日期
        List<LocalDate> list = DateUtils.returnWeekDate();
        for (LocalDate l:list) {
            //查询一天数量的变化
            Integer studentNumAndTeacherNumNumByCityId = viewAllSchoolAreaInformationDao.selectStudentNumAndTeacherNumNumByCityId(cityId,l);
            //将这一天的数量组装到数组中
            arrayList.add(studentNumAndTeacherNumNumByCityId);
        }
        //封装组合数据
        foWeek.setName(nameByCityId);
        foWeek.setStack("总量");
        foWeek.setType("line");
        //封装一周内日期的变化数量
        foWeek.setData(arrayList);
        HashMap<String, Object> map = new HashMap<>();
        List<String> weekDateAsString = DateUtils.returnWeekDateAsString(list);
        //用map组装成对象的形式进行数据展示
        map.put("area",foWeek);
        //封装一周的日期,与上边每一天的数据
        map.put("time",weekDateAsString);
        return map;
    }

    @Override
    public List<Map<String, Object>> StudentAndTeacherAreaInformationForWeekAll(Integer cityId) {

        ArrayList<Map<String, Object>> maps = new ArrayList<>();
        //查询出来的所有子id
        List<Integer> cityIdHasChildNum = viewAllSchoolAreaInformationDao.CityIdHasChildNum(cityId);
        if( cityIdHasChildNum.size()!=0 && cityIdHasChildNum.size()>1)
        {
            for (Integer i:cityIdHasChildNum) {
                //根据城市id查询城市的名字
                String nameByCityId = viewAllSchoolAreaInformationDao.CityNameByCityId(i);
                //获取当前一天起前七天的日期
                List<LocalDate> list = DateUtils.returnWeekDate();
                //分析数据展示信息
                AreaInfoFoWeek foWeek = new AreaInfoFoWeek();
                //用来存放师生数量的变化
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (LocalDate l:list) {
                    //查询一天数量的变化
                    Integer studentNumAndTeacherNumNumByCityId = viewAllSchoolAreaInformationDao.
                            selectStudentNumAndTeacherNumNumByCityId(i,l);
                    //将这一天的数量组装到数组中
                    arrayList.add(studentNumAndTeacherNumNumByCityId);
                }
                foWeek.setName(nameByCityId);
                foWeek.setStack("总量");
                foWeek.setType("line");
                //封装一周内日期的变化数量
                foWeek.setData(arrayList);
                HashMap<String, Object> map = new HashMap<>();
                List<String> weekDateAsString = DateUtils.returnWeekDateAsString(list);
                //用map组装成对象的形式进行数据展示
                map.put("area",foWeek);
                //封装一周的日期,与上边每一天的数据
                map.put("time",weekDateAsString);
                maps.add(map);
            }
        }else {
            //根据城市id查询城市的名字
            String nameByCityId = viewAllSchoolAreaInformationDao.CityNameByCityId(cityId);
            //分析数据展示信息
            AreaInfoFoWeek foWeek = new AreaInfoFoWeek();
            //用来存放师生数量的变化
            ArrayList<Integer> arrayList = new ArrayList<>();
            //获取当前一天起前七天的日期
            List<LocalDate> list = DateUtils.returnWeekDate();
            for (LocalDate l:list) {
                //查询一天数量的变化
                Integer studentNumAndTeacherNumNumByCityId = viewAllSchoolAreaInformationDao.selectStudentNumAndTeacherNumNumByCityId(cityId,l);
                //将这一天的数量组装到数组中
                arrayList.add(studentNumAndTeacherNumNumByCityId);
            }
            //封装组合数据
            foWeek.setName(nameByCityId);
            foWeek.setStack("总量");
            foWeek.setType("line");
            //封装一周内日期的变化数量
            foWeek.setData(arrayList);
            HashMap<String, Object> map = new HashMap<>();
            List<String> weekDateAsString = DateUtils.returnWeekDateAsString(list);
            //用map组装成对象的形式进行数据展示
            map.put("area",foWeek);
            //封装一周的日期,与上边每一天的数据
            map.put("time",weekDateAsString);
            maps.add(map);
        }
        return maps;
    }
}
