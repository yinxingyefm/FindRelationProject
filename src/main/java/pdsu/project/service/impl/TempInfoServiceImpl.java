package pdsu.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdsu.project.dao.*;
import pdsu.project.domain.*;
import pdsu.project.service.TempInfoService;
import pdsu.project.utils.ConstantInfo;
import pdsu.project.utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ljk
 * 统计师生今日温度
 */
@Service
@Transactional
public class TempInfoServiceImpl implements TempInfoService {

    //注入院系接口
    @Autowired
    private DepartmentInformationMapper departmentInformationMapper;

    //注入年级接口
    @Autowired
    private  GradeInformationMapper gradeInformationMapper;



//    注入温度统计接口
    @Autowired
    private TempInformationdao tempInformationdao;

    @Autowired
    private  TemptureInformationMapper temptureInformationMapper;

    //用户信息接口
    @Autowired
    private UserInformationMapper userInformationMapper;

    //权限信息表
    @Autowired
    private PermissionInformationMapper permissionInformationMapper;

    //学生信息接口
    @Autowired
    private StudentInformationMapper studentInformationMapper;

    //老师接口
    @Autowired
    private TeacherInformationMapper teacherInformationMapper;

    //班级接口
    @Autowired
    private ClassInformationMapper classInformationMapper;

    //7
    @Override
    public List<TempInformation> tempForOneDayForRole(String role) {
        ArrayList<TempInformation> tempInformations = new ArrayList<>();
        TempInformation tempInformationForMor;
        TempInformation tempInformationForLun;
        TempInformation tempInformationForEve;
        if (ConstantInfo.role_teacher.equals(role))
      {
          tempInformationForMor=new TempInformation();
          //查询早上正常的老师数量
          Integer inMorNormalNum = tempInformationdao.selectNumInMorNormal(ConstantInfo.teacher_type,
                  LocalDate.now(), ConstantInfo.highest_temp);

          System.out.println(inMorNormalNum+"....早上老师的数量");

          //查询早上不正常的老师体温的人数
           Integer morUnNomalNum = tempInformationdao.selectNumInMorUnNomal(ConstantInfo.teacher_type,
                   LocalDate.now(), ConstantInfo.highest_temp);
          System.out.println(morUnNomalNum+"早上不正常数量");
          //设置早上时间
           tempInformationForMor.setTime(ConstantInfo.moring);
           //设置正常人数
           tempInformationForMor.setNormal(inMorNormalNum);
           //设置不正常人数
           tempInformationForMor.setUnnormal(morUnNomalNum);
           //设置所有数量
           tempInformationForMor.setAll(inMorNormalNum+morUnNomalNum);

//         实例化中午测量实体
           tempInformationForLun=new TempInformation();
          //查询中午正常的数量
          Integer lunNomalNum = tempInformationdao.selectNumInLunNormal(ConstantInfo.teacher_type,
                  LocalDate.now(), ConstantInfo.highest_temp);

          System.out.println(lunNomalNum+"中午正常的数量");

          //查询中午不正常的数量
          Integer lunUnNomalNum = tempInformationdao.selectNumInLunUnNomal(ConstantInfo.teacher_type,
                  LocalDate.now(), ConstantInfo.highest_temp);

          System.out.println(lunUnNomalNum+"中午不正常数量");

//         组装信息
          tempInformationForLun.setTime(ConstantInfo.lunch);
          //注入中午正常信息
          tempInformationForLun.setNormal(lunNomalNum);
          //注入中午不正常信息
          tempInformationForLun.setUnnormal(lunUnNomalNum);
          //注入中午所有体温信息的人数
          tempInformationForLun.setAll(lunNomalNum+lunUnNomalNum);

          //查询晚上正常的老师数量
          Integer numInEveNormal = tempInformationdao.selectNumInEveNormal(ConstantInfo.teacher_type,
                  LocalDate.now(), ConstantInfo.highest_temp);

          System.out.println(numInEveNormal+"晚上正常的老师数量");

          //查询晚上不正常老师数量
          Integer  numInEveUnNormal= tempInformationdao.selectNumInEveUnNomal(ConstantInfo.teacher_type,
                  LocalDate.now(),ConstantInfo.highest_temp);

          System.out.println(numInEveUnNormal+"晚上老师不正常的数量");

          tempInformationForEve=new TempInformation();
          //设置晚上时间
          tempInformationForEve.setTime(ConstantInfo.eveing);
          //设置晚上不正常的数量
          tempInformationForEve.setUnnormal(numInEveUnNormal);

          //设置晚上正常的数量
          tempInformationForEve.setNormal(numInEveNormal);
          //设置晚上所有的统计体温老师的人数
          tempInformationForEve.setAll(numInEveNormal+numInEveUnNormal);
      }else {
            tempInformationForMor=new TempInformation();
            //查询早上正常的学生数量
            Integer inMorNormalNum = tempInformationdao.selectNumInMorNormal(ConstantInfo.student_type,
                    LocalDate.now(), ConstantInfo.highest_temp);
            //查询早上不正常的学生体温的人数
            Integer morUnNomalNum = tempInformationdao.selectNumInMorUnNomal(ConstantInfo.student_type,
                    LocalDate.now(), ConstantInfo.highest_temp);
            //设置早上时间
            tempInformationForMor.setTime(ConstantInfo.moring);
            //设置正常学生人数
            tempInformationForMor.setNormal(inMorNormalNum);
            //设置不正常人数
            tempInformationForMor.setUnnormal(morUnNomalNum);
            //设置所学生有数量
            tempInformationForMor.setAll(inMorNormalNum+morUnNomalNum);

//         实例化中午测量实体
            tempInformationForLun=new TempInformation();
            //查询中午正常的数量
            Integer lunNomalNum = tempInformationdao.selectNumInLunNormal(ConstantInfo.student_type,
                    LocalDate.now(), ConstantInfo.highest_temp);
            //查询中午不正常的数量
            Integer lunUnNomalNum = tempInformationdao.selectNumInLunUnNomal(ConstantInfo.student_type,
                    LocalDate.now(), ConstantInfo.highest_temp);
//         组装信息
            tempInformationForLun.setTime(ConstantInfo.lunch);
            //注入中午正常信息
            tempInformationForLun.setNormal(lunNomalNum);
            //注入中午不正常信息
            tempInformationForLun.setUnnormal(lunUnNomalNum);
            //注入中午所有体温信息的人数
            tempInformationForLun.setAll(lunNomalNum+lunUnNomalNum);

            //查询晚上正常的学生数量
            Integer numInEveNormal = tempInformationdao.selectNumInEveNormal(ConstantInfo.student_type,
                    LocalDate.now(), ConstantInfo.highest_temp);
            //查询晚上不正常老师数量
            Integer  numInEveUnNormal= tempInformationdao.selectNumInEveUnNomal(ConstantInfo.student_type,
                    LocalDate.now(),ConstantInfo.highest_temp);
            tempInformationForEve=new TempInformation();
            //设置晚上时间
            tempInformationForEve.setTime(ConstantInfo.eveing);
            //设置晚上不正常的数量
            tempInformationForEve.setUnnormal(numInEveUnNormal);
            //设置晚上正常的数量
            tempInformationForEve.setNormal(numInEveNormal);
            //设置晚上所有的统计体温学生的人数
            tempInformationForEve.setAll(numInEveNormal+numInEveUnNormal);
        }
//        把一天三次信息注入到集合数据中心
        tempInformations.add(tempInformationForMor);
        tempInformations.add(tempInformationForLun);
        tempInformations.add(tempInformationForEve);
        return tempInformations;
    }


    //记录已经录入信息
    @Override
    public ArrayList<RecordedInformation> RecordedInformation( String role) throws Exception {
        //声明一个集合
        ArrayList<RecordedInformation> recordedInformations = new ArrayList<>();
        //声明一个日期类
        //初始化数字

        //已录数量
       Integer noCount=0;
       Integer unCount=0;
        //未录数量
//        Long unCount= Long.valueOf(0);
        if(ConstantInfo.role_teacher.equals(role)){
            List<String> list = teacherInformationMapper.selectAllTeacherNum();
            String s = Utils.lisTAsString(list);
            noCount = tempInformationdao.selectAllCountByStu(ConstantInfo.teacher_type);
            unCount=list.size()-noCount;
        }else {
            List<String> list = studentInformationMapper.allStudentNum();
            noCount = tempInformationdao.selectAllCountByStu(1);
            System.out.println(noCount+"ppppppp");
            unCount=list.size()-noCount;
        }
        //正常录入信息
        RecordedInformation normal = new RecordedInformation();
        //不正常录入信息
        RecordedInformation unrecordedInformation=new RecordedInformation();
        normal.setValue(noCount);
        normal.setName("已录");
        recordedInformations.add(normal);
        unrecordedInformation.setName("未录");
        unrecordedInformation.setValue(unCount);
        recordedInformations.add(unrecordedInformation);
        return recordedInformations;
    }

    @Override
    public ArrayList<RecordedInformation> UnRecordedInformation( String role,Integer dept) {
        //定义一个集合
        ArrayList<RecordedInformation> recordedInformations=new ArrayList<>();
        RecordedInformation recordedInformation;
                //查询所有的院系Id
//                List<Integer> allDeptId = departmentInformationMapper.selectAllDeptId();
//                for (Integer i:allDeptId){
                    //一条记录
                    recordedInformation= new RecordedInformation();
                    if (ConstantInfo.role_teacher.equals(role)){
                          //根据院系id获取所有的老师信息
                          List<String> list = teacherInformationMapper.selectAllTeacherNumByDeptId(dept);
                          //已录人数
                          Integer allCount = tempInformationdao.selectAllCountByStu(ConstantInfo.teacher_type);
                         Integer un =list.size()-allCount;
                          DepartmentInformation departmentInformation = departmentInformationMapper.selectByPrimaryKey(dept);
                          recordedInformation.setName(departmentInformation.getDepartmentName());
                          recordedInformation.setValue(un);
                          recordedInformations.add(recordedInformation);
                      }else {
                        List<String> studentNumByDeptId = studentInformationMapper.selectAllStudentNumByDeptId(dept);
                        Integer count = tempInformationdao.selectAllCountByStu(1);
                        //所有的数量减去正常的
                        Integer un=studentNumByDeptId.size()-count;
                        DepartmentInformation departmentInformation = departmentInformationMapper.selectByPrimaryKey(dept);
                        recordedInformation.setName(departmentInformation.getDepartmentName());
                        //设置未录取的数量
                        recordedInformation.setValue(un);
                        //添加到集合中
                        recordedInformations.add(recordedInformation);
                    }
//                }
        return  recordedInformations;
    }



}
