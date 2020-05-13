package pdsu.project.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdsu.project.dao.*;
import pdsu.project.domain.*;
import pdsu.project.service.AreaService;
import pdsu.project.service.TempTempForToDayService;
import pdsu.project.utils.ConstantInfo;
import pdsu.project.utils.DateUtils;
import pdsu.project.utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ljk
 */

@Service
@Transactional
public class TempTempForToDayServiceImpl implements TempTempForToDayService {

    //注入温度接口
    @Autowired
    private TemptureInformationMapper temptureInformationMapper;


    public TempTempForToDay selectAWeekforRole(String role) throws Exception {
//        //不正常的数据
        Integer countUnnormal=0;
        //正常的数据
        Integer countNormal=0;
        //初始化一周的数据
        TempTempForToDay tempTempForToDay = new TempTempForToDay();
        //不正常
        ArrayList<Integer> unNormal = new ArrayList<>();
        //正常的数量
        ArrayList<Integer> normal = new ArrayList<>();
        //获取一周的时间
        List<LocalDate> dates = DateUtils.returnWeekDate();
                if (ConstantInfo.role_teacher.equals(role)){
                    //查询所有的老师信息
//                      List<String> allTeacherNum = teacherInformationMapper.selectAllTeacherNum();
                    //查询一个星期的信息
                    for (LocalDate l:dates) {
                        //所有的数量
                        countUnnormal = temptureInformationMapper.countNnll(l, ConstantInfo.teacher_type);
                        //正常的数量
                        countNormal = temptureInformationMapper.countNormalAll(l, ConstantInfo.teacher_type, ConstantInfo.highest_temp);
                        //所有的减去正常的
                        countUnnormal=countUnnormal-countNormal;
                        unNormal.add(countUnnormal);
//                     //添加到集合中
                        normal.add(countNormal);
                    }
                }else {
                    for (LocalDate l:dates) {
                        //查询所有的数量
                        countUnnormal = temptureInformationMapper.countNnll(l, ConstantInfo.student_type );
                        System.out.println("不正常的数据"+countUnnormal+"日期为"+l);
                        //正常体温数量
                        countNormal = temptureInformationMapper.countNormalAll(l, ConstantInfo.student_type, ConstantInfo.highest_temp);
                        System.out.println("正常的数据"+countNormal+"日期为"+l);
                        //所有减去正常的,就是不正常的
                        countUnnormal=countUnnormal-countNormal;
                        //添加到集合中
                        unNormal.add(countUnnormal);
                        //添加到集合中
                        normal.add(countNormal);
                    }
                }
        tempTempForToDay.setUnnormal(unNormal);
        tempTempForToDay.setNormal(normal);
        tempTempForToDay.setTime(DateUtils.returnWeekDateAsString(dates));
        return  tempTempForToDay;
    }
}
