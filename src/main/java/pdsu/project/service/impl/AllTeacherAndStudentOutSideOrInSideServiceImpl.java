package pdsu.project.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdsu.project.domain.*;
import pdsu.project.dao.*;
import pdsu.project.service.AllTeacherAndStudentOutSideOrInSideService;
import pdsu.project.service.AreaService;
import pdsu.project.utils.ConstantInfo;
import pdsu.project.utils.DateUtils;
import pdsu.project.utils.Utils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ljk
 */
@Service
@Transactional
public class AllTeacherAndStudentOutSideOrInSideServiceImpl implements AllTeacherAndStudentOutSideOrInSideService {

    //注入所有外出学生或者师生的dao接口
      @Autowired
      private AllTeacherAndStudentOutSideOrInSideDao allTeacherAndStudentOutSideOrInSideDao;

      //注入学生接口
      @Autowired
      private StudentInformationMapper studentInformationMapper;

      //注入老师接口
    @Autowired
      private TeacherInformationMapper  teacherInformationMapper;

      //报备信息接口
      @Autowired
      private ReportInformationMapper reportInformationMapper;

    //注入地区接口
    @Autowired
    private AreaService areaService;

   //注入温度接口
    @Autowired
    private TemptureInformationMapper temptureInformationMapper;


    //注入班级信息
    @Autowired
    private ClassInformationMapper classInformationMapper;

    //注入用户接口
    @Autowired
    private UserInformationMapper userInformationMapper;

    //注入权限接口
    @Autowired
    private  PermissionInformationMapper permissionInformationMapper;



    /**
     * 查询老师或者学生的外出或者统计信息
     * @param role
     * @return
     * 3
     */
    @Override
    public AllTeacherAndStudentOutSideOrInSide Information(String role) {
        //出入学生的信息
        AllTeacherAndStudentOutSideOrInSide allTeacherAndStudentOutSideOrInSide = new AllTeacherAndStudentOutSideOrInSide();
        //外出学生数量
        ArrayList<Integer> outside = new ArrayList<>();
        //在校学生数量
        ArrayList<Integer> inside = new ArrayList<>();
        //获得从今天算起往前查七天
        List<LocalDate> localDates = DateUtils.returnWeekDate();
        Integer type=null;
      if(role!=null&& ConstantInfo.role_teacher.equals(role))
      {
          //报备信息里边type为0 老师
          type=ConstantInfo.teacher_type;
      }else {
          //报备信息里边type为1 学生
          type=ConstantInfo.student_type;
      }
      for (LocalDate localDate:localDates){
          //查询一天老师或者学生的外出数量
          Integer outsideStudentOrTeacheNum = allTeacherAndStudentOutSideOrInSideDao.outsideStudentNum(localDate, type);
          //查询一天老师或者学生的在校数量
          System.out.println(outsideStudentOrTeacheNum+"外出的数量");
          Integer insideStudentOrTeacheNum = allTeacherAndStudentOutSideOrInSideDao.insideStudentNum(localDate, type);
          System.out.println(insideStudentOrTeacheNum+"在学校的数量");
          //添加到外出信息报备的集合中
          outside.add(outsideStudentOrTeacheNum);
          //添加到在校集合中
          inside.add(insideStudentOrTeacheNum);
      }
      //组装数据
        List<String> weekDateAsString = DateUtils.returnWeekDateAsString(localDates);
       allTeacherAndStudentOutSideOrInSide.setInside(inside);
       allTeacherAndStudentOutSideOrInSide.setOutside(outside);
       allTeacherAndStudentOutSideOrInSide.setTime(weekDateAsString);
        return allTeacherAndStudentOutSideOrInSide;
    }

//  16  获取xx人 每天外出地点
    @Override
    public List<OutSideInfo> AllOutsideInformation(String role, String num) {
        ArrayList<OutSideInfo> outSideInfos = new ArrayList<>();
        //判断角色
        if (ConstantInfo.role_teacher.equals(role)){
            //按照老师的查询
            //查询报备信息
            List<ReportInformation> reportInformations = reportInformationMapper.selectAll(num,ConstantInfo.teacher_type);
            System.out.println(reportInformations+".......");
            //判断报备信息是否为空
            if (reportInformations.size()!=0){
                //进行循环遍历所有的数据
                for (ReportInformation r:reportInformations) {
                    //每一次遍历实例化一个外出信息
                    OutSideInfo info= new OutSideInfo();
                    //设置温度
                    info.setTemperature(r.getTemperature()+"");
                    //设置日期
                    info.setData(DateUtils.DateAsString(r.getReportTime()));
                    //根据工号查询
                    String byTeacherNum= teacherInformationMapper.SelectTelphoneByTeacherNum(r.getNumber());
                    //设置手机号
                    //老师的信息
                    info.setTel(byTeacherNum);;
                    //设置地址
                    String address = areaService.Address(r.getReportId());
                    info.setOutAddress(address);
                    outSideInfos.add(info);
                }
            }
        }else {
            List<ReportInformation> report = reportInformationMapper.selectAll(num,ConstantInfo.student_type);
            //判断报备信息是否为空
            if (report.size()!=0) {
                //进行循环遍历所有的数据
                for (ReportInformation r1 : report) {
                    //每一次遍历实例化一个外出信息
                    OutSideInfo infoForStudent = new OutSideInfo();
                    //设置温度
                    infoForStudent.setTemperature(r1.getTemperature() + "");
                    //设置日期
                    infoForStudent.setData(DateUtils.DateAsString(r1.getReportTime()));
                    //根据工号查询
                    String byStudentNum = studentInformationMapper.telByStudentNum(r1.getNumber());
                    //设置手机号
                    //老师的信息
                    infoForStudent.setTel(byStudentNum);
                    ;
                    //设置地址
                    String address = areaService.Address(r1.getReportId());
                    infoForStudent.setOutAddress(address);
                    outSideInfos.add(infoForStudent);
                }
            }
        }
        return  outSideInfos;
    }
    //  9
    @Override
    public List<UnusualInformation> unmalForTime(String role, String time) {
        List<UnusualInformation> informations=new ArrayList<>();
        LocalDate date = DateUtils.timeAsDate(time);
        UnusualInformation unormal;
        if (ConstantInfo.role_teacher.equals(role)){
            List<TemptureInformation> temptureInformationList = temptureInformationMapper.selectAll(date, ConstantInfo.teacher_type);
            System.out.println(temptureInformationList.size()+".......");
            for (TemptureInformation t:temptureInformationList) {
                //一天做高温度
                float temp = Utils.max(t.getTemptureMor(), t.getTemptureLun(), t.getTemptureEve());
                if (temp>ConstantInfo.highest_temp){
                    unormal= new UnusualInformation();
                    // 设置温度
                    unormal.setTemperature(temp+"");
                    //查询老师信息
                    TeacherInformation teacherInformation = null;
                    try {
                        teacherInformation = teacherInformation = teacherInformationMapper.selectByTeacherNum(t.getTemptureNum() + "");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(teacherInformation!=null){
                        String deptName = teacherInformationMapper.selecrByDepartId(teacherInformation.getDepartmentId());
                        //设置院系
                        unormal.setClassName(deptName);
                        //老师没有宿舍楼号
                        unormal.setDormitoryNum(null);
                        //设置工号
                        unormal.setId(Integer.parseInt(teacherInformation.getTeacherNumber()));
                        //设置紧急联系人姓名
                        unormal.setEmergencyName(teacherInformation.getTeacherContactName());
                        //设置紧急联系人电话
                        unormal.setEmergencyPhone(teacherInformation.getTeacherContactPhone());
                        //设置地址
                        unormal.setAddress(teacherInformation.getTeacherDetailPeraddress());

                        ReportInformation reportInformation = reportInformationMapper.selectByNum(teacherInformation.getTeacherNumber());
                        if (reportInformation.getOut()==0){
                            unormal.setOutDoor(ConstantInfo.outDoorY);
                        }else {
                            unormal.setOutDoor(ConstantInfo.outDoorN);
                        }

                        if (teacherInformation.getTeacherSex()==1){
                            //男性
                            unormal.setSex(ConstantInfo.man);
                        }else {
                            //女性
                            unormal.setSex(ConstantInfo.woman);
                        }
                        informations.add(unormal);
                    }else {
                        return  null;
                    }
                }
            }
        }else {
            List<TemptureInformation> tempture = temptureInformationMapper.selectAll(date, ConstantInfo.student_type);
            for (TemptureInformation t1:tempture) {
                //一天做高温度
                float temp1 = Utils.max(t1.getTemptureMor(), t1.getTemptureLun(), t1.getTemptureEve());
                if (temp1>ConstantInfo.highest_temp){
                    unormal= new UnusualInformation();
                    // 设置温度
                    unormal.setTemperature(temp1+"");
                    //查询学生信息
                    StudentInformation studentInformation = studentInformationMapper.selectByNum(t1.getTemptureNum() + "");
                    if (studentInformation!=null){
                        String className = classInformationMapper.selectByPrimaryKey(studentInformation.getClassId()).getClassName();
                        if (className!=null){
                            //设置班级
                            unormal.setClassName(className);
                        }
                        //宿舍楼号
                        unormal.setDormitoryNum(studentInformation.getStudentDormitory());
                        //设置工号
                        unormal.setId(Integer.parseInt(studentInformation.getStudentNumber()));
                        //设置紧急联系人姓名
                        unormal.setEmergencyName(studentInformation.getStudentContactName());
                        unormal.setName(studentInformation.getStudentName());
                        //设置紧急联系人电话
                        unormal.setEmergencyPhone(studentInformation.getStudentPhone());
                        //设置地址
                        unormal.setAddress(studentInformation.getStudentDetailPeraddress());
                        //查询是否外出
                        System.out.println(studentInformation.getStudentNumber()+"pppp");
                        ReportInformation reportInformation = reportInformationMapper.selectByNum(studentInformation.getStudentNumber());
                        if (reportInformation.getOut()==0){
                            unormal.setOutDoor(ConstantInfo.outDoorY);
                        }else {
                            unormal.setOutDoor(ConstantInfo.outDoorN);
                        }

                        if (studentInformation.getStudentSex()==1){
                            //男性
                            unormal.setSex(ConstantInfo.man);
                        }else {
                            //女性
                            unormal.setSex(ConstantInfo.woman);
                        }
                        informations.add(unormal);
                    }else {
                        return null;
                    }
                }
           }
        }
        return informations;
    }

    //查询某个时间段外出情况
    @Override
    public ArrayList<OutSideInfoForSomeOneDay> forTimeAndRole(String role, String time) {
        LocalDate localDate = DateUtils.timeAsDate(time);
        ArrayList<OutSideInfoForSomeOneDay> maps = new ArrayList<>();
        if (ConstantInfo.role_teacher.equals(role)){
           List<ReportInformation> reportInformations = reportInformationMapper.selectAllByTime(localDate, ConstantInfo.teacher_type);
           if (reportInformations.size()!=0){
               for (ReportInformation r:reportInformations){
                   OutSideInfoForSomeOneDay outSideInfoForSomeOneDay = new OutSideInfoForSomeOneDay();
                   int num = Integer.parseInt(r.getNumber());
                   //设置工号
                   outSideInfoForSomeOneDay.setId(num);
                   TeacherInformation teacherInformation = null;

                   try {
                       teacherInformation = teacherInformationMapper.selectByTeacherNum(r.getNumber());
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   System.out.println(teacherInformation+"老师的信息");
                   if (teacherInformation!=null){
                       outSideInfoForSomeOneDay.setName(teacherInformation.getTeacherName());
                       //设置工号
                       outSideInfoForSomeOneDay.setName(teacherInformation.getTeacherName());
                       //老师没有班级有院系
                       String deptName = teacherInformationMapper.selecrByDepartId(teacherInformation.getDepartmentId());
                       //设置院系
                       outSideInfoForSomeOneDay.setClassName(deptName);
                       //设置详细地址
                       outSideInfoForSomeOneDay.setAddress(teacherInformation.getTeacherDetailPeraddress());
                       //联系电话
                       outSideInfoForSomeOneDay.setTel(teacherInformation.getTeacherContactPhone());
                       //老师没有宿舍号
                       outSideInfoForSomeOneDay.setDormitoryNum(null);
                       Integer out = r.getOut();
                       if (out==1){
                           //设置外出
                           outSideInfoForSomeOneDay.setOutDoor(ConstantInfo.outDoorN);
                       }else {
                           outSideInfoForSomeOneDay.setOutDoor(ConstantInfo.outDoorY);
                       }
                       maps.add(outSideInfoForSomeOneDay);
                   }

               }
               return  maps;
           }
           return null;
       }else {
            List<ReportInformation> reportInformations = reportInformationMapper.selectAllByTime(localDate, ConstantInfo.student_type);
            if (reportInformations.size()!=0){
                for (ReportInformation r:reportInformations){
                    OutSideInfoForSomeOneDay outSideInfoForSomeOneDay = new OutSideInfoForSomeOneDay();
                    int num = Integer.parseInt(r.getNumber());
                    //设置工号
                    outSideInfoForSomeOneDay.setId(num);

                    HashMap<String, Object> map = new HashMap<>();
                    StudentInformation studentInformation = studentInformationMapper.selectByNum(r.getNumber());
                    //设置班级
                    ClassInformation classInformation = classInformationMapper.selectByPrimaryKey(studentInformation.getClassId());
                    //设置班级
                    outSideInfoForSomeOneDay.setClassName(classInformation.getClassName());
                    //设置详细地址
                    outSideInfoForSomeOneDay.setAddress(studentInformation.getStudentDetailPeraddress());
                    //设置电话号
                    outSideInfoForSomeOneDay.setTel(studentInformation.getStudentPhone());
                    //老师没有宿舍号
                    outSideInfoForSomeOneDay.setDormitoryNum(studentInformation.getStudentDormitory()+"");
                    outSideInfoForSomeOneDay.setName(studentInformation.getStudentName());
                    Integer out = r.getOut();
                    if (out==1){
                        //设置外出
                        outSideInfoForSomeOneDay.setOutDoor(ConstantInfo.outDoorN);
                    }else {
                        outSideInfoForSomeOneDay.setOutDoor(ConstantInfo.outDoorY);

                    }
                    maps.add(outSideInfoForSomeOneDay);
                }
                return  maps;
                }
            }
        return maps;
    }







}
