package pdsu.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdsu.project.dao.*;
import pdsu.project.domain.*;
import pdsu.project.service.TescherExcelService;
import pdsu.project.utils.ConstantInfo;
import pdsu.project.utils.Utils;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author ljk
 */


@Service
@Transactional
public class TescherExcelServiceImpl implements TescherExcelService {

    @Autowired
    private TeacherInformationMapper teacherInformationMapper;

    @Autowired
    DepartmentInformationMapper departmentInformationMapper;
    //用户信息
    @Autowired
    private UserInformationMapper userInformationMapper;

    ///报备信息
    @Autowired
    private ReportInformationMapper reportInformationMapper;
    //外出信息
    @Autowired
    private OutInformationMapper outInformationMapper;


    //隔离信息
    @Autowired
    private IsolationInformationMapper isolationInformationMapper;


    @Autowired
    private  AreaDataMapper areaDataMapper;

    @Override
    public Boolean TeacherExcel(ExcelTeacherDomain excelTeacherDomain)
    {
        boolean flag=false;
        try {
            TeacherInformation teacherInformation = teacherInformationMapper.selectByTeacherNum(excelTeacherDomain.getNum());
            if (teacherInformation==null){
                TeacherInformation teacherInfor = new TeacherInformation();
                //姓名
                teacherInfor.setTeacherName(excelTeacherDomain.getName());
                //手机号
                teacherInfor.setTeacherPhone(excelTeacherDomain.getMyPhone());
                //设置紧急联系人姓名
                teacherInfor.setTeacherContactName(excelTeacherDomain.getParaentName());
                //  设置紧急联系人电话号
                teacherInfor.setTeacherContactPhone(excelTeacherDomain.getParaentPhone());
                //常住地
                String myOffenHome = excelTeacherDomain.getMyOffenHome();
                List<String> areea = Utils.Areea(myOffenHome);
                System.out.println(areea+"pp");
                Integer byCityAndArea = areaDataMapper.selectByCityAndArea(areea.get(1), areea.get(2));
                //常住地
                teacherInfor.setTeacherPermanentAddress(byCityAndArea);
                //常住地
                teacherInfor.setTeacherDetailPeraddress(excelTeacherDomain.getMyOffenHomeDeatil());
                //密码
                teacherInfor.setTeacherPassword("123456");
                //设置学号
                teacherInfor.setTeacherNumber(excelTeacherDomain.getNum());
                //设置性别
                if (ConstantInfo.man.equals(excelTeacherDomain.getSex())){
                    teacherInfor.setTeacherSex(1);
                }else {
                    teacherInfor.setTeacherSex(0);
                }
                String deptName = excelTeacherDomain.getDeptName();
                Integer integer = departmentInformationMapper.selectByDeptName(deptName);
                if (integer==null ){
                    //插入院系信息
                    DepartmentInformation departmentInformation = new DepartmentInformation();
                    departmentInformation.setDepartmentName(deptName);
                    int insert = departmentInformationMapper.insert(departmentInformation);
                    //插入院系id
                    System.out.println(departmentInformation.getDepartmentId()+"看看");
                    teacherInfor.setDepartmentId(departmentInformation.getDepartmentId());
                }else {
                    teacherInfor.setDepartmentId(integer);
                }
                teacherInformationMapper.insert(teacherInfor);
                //用户信息
                UserInformation userInformation = new UserInformation();
                //普通用户
                userInformation.setRoleId(2);
                userInformation.setTeacherId(teacherInfor.getId());
                userInformation.setDescb("老师");
                userInformationMapper.insert(userInformation);
                //组装报备信息
                ReportInformation reportInformation = new ReportInformation();
                //上报日期
                String reportTime =excelTeacherDomain.getReportTime();
                Date date = Utils.StringAsDate(reportTime);
                reportInformation.setReportTime(date);
                //上报温度
                System.out.println(excelTeacherDomain.getTemp()+"上报温度");
                String temp= excelTeacherDomain.getTemp();
                String replace = temp.replace(" ", "");
                if (replace.length()>4){
                    replace = replace.substring(0, 4);
                }
                try {
                    reportInformation.setTemperature(Double.parseDouble(replace));
                } catch (NumberFormatException e) {
                    return flag;
                }
                reportInformation.setHealth(excelTeacherDomain.getHealthy());
                //现在所在的详细地址
                reportInformation.setNowDetailaddress(excelTeacherDomain.getNowDetailArea());
                //设置现在所在地址//省市县
                String nowArea = excelTeacherDomain.getNowArea();
                List<String> now = Utils.Areea(nowArea);
                //查询当前地址的id
                try {
                    Integer nowId = areaDataMapper.selectByCityAndArea(now.get(1), now.get(2));
                    if (nowId!=null){
                        //当前地址的id
                        reportInformation.setNowAddress(nowId);
                    }
                } catch (Exception e) {
                    return  flag;
                }
                String isOut = excelTeacherDomain.getIsOut();
                if (ConstantInfo.outDoorN.equals(isOut))
                {
                    //没有外出
                    reportInformation.setOut(1);
                }else {
                    //外出了
                    reportInformation.setOut(0);
                }
                //本人是否隔离((0是1否))
                String isolation = excelTeacherDomain.getIsolation();
                if (ConstantInfo.isolationN.equals(isolation)){
                    reportInformation.setIsolation(1);
                }else {
                    reportInformation.setIsolation(0);
                }
                /***
                 * 是否有就诊住院(0是1否)
                 */
                String isHospital = excelTeacherDomain.getIsHospital();
                if (ConstantInfo.isisHospital.equals(isHospital)){
                    reportInformation.setInpatient(0);
                }else {
                    reportInformation.setInpatient(1);
                }
                //是否到过重点地区
                String isBadCase = excelTeacherDomain.getIsBadCase();
                //本人是否到过（经过）疫情重点区 (0未到过/1到过)
                if (ConstantInfo.isBadCase.equals(isBadCase)){
                    reportInformation.setServerlyArea(1);
                }else {
                    reportInformation.setServerlyArea(0);
                }

                //居家人员是否到过疫情地区
                //共同居住的家庭成员是否到过（经过）疫情重点区(0未到过,1到过
                String familyIsGoToBadRrea = excelTeacherDomain.getFamilyIsGoToBadRrea();
                if (ConstantInfo.familyIsGoToBadRrea.equals(familyIsGoToBadRrea)){
                    reportInformation.setFamilySeverelyArea(1);
                }else {
                    reportInformation.setFamilySeverelyArea(0);
                }
                //所居住的小区或村庄是否有确诊或疑似新冠肺炎病例(0有/1没有)
                String isBadPerson = excelTeacherDomain.getIsBadPerson();
                if (ConstantInfo.isBadPerson.equals(isBadPerson)){
                    reportInformation.setAreaDisease(0);
                }else {
                    reportInformation.setAreaDisease(1);
                }
                //设置学号
                reportInformation.setNumber(teacherInfor.getTeacherNumber());
                //设置类型
                reportInformation.setType(ConstantInfo.teacher_type);
                //其它事项说明
                reportInformation.setOthers(excelTeacherDomain.getOther());
                //本人是否确诊为病例或疑似病例(0不是,1是)
                String badCase = excelTeacherDomain.getBadCase();
                if (ConstantInfo.badCase.equals(badCase)){
                    reportInformation.setIfDermine(1);
                }else {
                    reportInformation.setIfDermine(0);
                }
                if (excelTeacherDomain.getIsPing().equals("是"))
                {
                    reportInformation.setTeacherPds(0);
                }else {
                    reportInformation.setTeacherPds(1);
                }
                reportInformationMapper.insert(reportInformation);
                // 外出信息
                //外出的地点
                if(ConstantInfo.outDoorY.equals(excelTeacherDomain.getIsOut())){
                    OutInformation outInformation = new OutInformation();
                    outInformation.setReportId(reportInformation.getReportId());
                    //设置外出方式
                    outInformation.setVehicle(excelTeacherDomain.getTraffic());
                    String outTime = excelTeacherDomain.getOutTime();
                    System.out.println(outTime+"外出时间");
                    if (outTime!=null && outTime!=" " && !outTime.equals("否")){
                        Date date1 = Utils.StringAsDate1(outTime);
                        outInformation.setOutTime(date1);
                    }
                    //外出时间
                    String backTime = excelTeacherDomain.getBackTime();
                    Date date2 = Utils.StringAsDate1(backTime);
                    outInformation.setBackTime(date2);
                    String outArea = excelTeacherDomain.getOutArea();
                    List<String> areea1 = Utils.Areea(outArea);
                    Integer integer1 = areaDataMapper.selectByCityAndArea(areea1.get(0), areea1.get(1).trim());
                    outInformation.setOutArea(integer1);
                    outInformationMapper.insert(outInformation);
                    System.out.println("外出地点"+outArea);
                }


//                //是否隔离
                if (ConstantInfo.isolationY.equals(excelTeacherDomain.getIsolation()))
                {
                    IsolationInformation isolationInformation = new IsolationInformation();
                    //设置上报id
                    isolationInformation.setReportId(reportInformation.getReportId());
                    //设置是否在家隔离
                    if (ConstantInfo.isolationY.equals(excelTeacherDomain.getInHomeIsolation())){
                        isolationInformation.setIsolationHome(1);
                    }else {
                        isolationInformation.setIsolationHome(0);
                    }
                    //是否强制隔离
                    if (ConstantInfo.isolationY.equals(excelTeacherDomain.getMandatoryIsolation())){
                        //是否医疗机构强制隔离(0不是/1是)
                        isolationInformation.setIsolationHospital(1);
                    }{
                    isolationInformation.setIsolationHospital(0);
                }
                    //隔离开始时间
                    String isolationBeginTime = excelTeacherDomain.getIsolationBeginTime();
                    Date begin = Utils.StringAsDate(isolationBeginTime);
                    isolationInformation.setIsolationStart(begin);
                    //隔离结束时间
                    String isolationEndTime = excelTeacherDomain.getIsolationEndTime();
                    Date end = Utils.StringAsDate(isolationEndTime);
                    isolationInformation.setIsolationEnd(end);
                    //插入信息
                    isolationInformationMapper.insert(isolationInformation);
                }


                flag=true;
                System.out.println(reportInformation);

            }else {
                ReportInformation reportInformation1 = reportInformationMapper.selectByNumAndToday(teacherInformation.getTeacherNumber(), LocalDate.now());
                if (reportInformation1==null){
                    ReportInformation reportInformation = new ReportInformation();
                    //上报日期
                    String reportTime =excelTeacherDomain.getReportTime();
                    Date date = Utils.StringAsDate(reportTime);
                    reportInformation.setReportTime(date);
                    //上报温度
                    System.out.println(excelTeacherDomain.getTemp()+"上报温度");
                    String temp= excelTeacherDomain.getTemp();
                    String replace = temp.replace(" ", "");
                    if (replace.length()>4){
                        replace = replace.substring(0, 4);
                    }
                    try {
                        reportInformation.setTemperature(Double.parseDouble(replace));
                    } catch (NumberFormatException e) {
                        return flag;
                    }
                    reportInformation.setHealth(excelTeacherDomain.getHealthy());
                    //现在所在的详细地址
                    reportInformation.setNowDetailaddress(excelTeacherDomain.getNowDetailArea());
                    //设置现在所在地址//省市县
                    String nowArea = excelTeacherDomain.getNowArea();
                    List<String> now = Utils.Areea(nowArea);
                    //查询当前地址的id
                    try {
                        Integer nowId = areaDataMapper.selectByCityAndArea(now.get(1), now.get(2));
                        if (nowId!=null){
                            //当前地址的id
                            reportInformation.setNowAddress(nowId);
                        }
                    } catch (Exception e) {
                        return  flag;
                    }
                    String isOut = excelTeacherDomain.getIsOut();
                    if (ConstantInfo.outDoorN.equals(isOut))
                    {
                        //没有外出
                        reportInformation.setOut(1);
                    }else {
                        //外出了
                        reportInformation.setOut(0);
                    }
                    //本人是否隔离((0是1否))
                    String isolation = excelTeacherDomain.getIsolation();
                    if (ConstantInfo.isolationN.equals(isolation)){
                        reportInformation.setIsolation(1);
                    }else {
                        reportInformation.setIsolation(0);
                    }
                    /***
                     * 是否有就诊住院(0是1否)
                     */
                    String isHospital = excelTeacherDomain.getIsHospital();
                    if (ConstantInfo.isisHospital.equals(isHospital)){
                        reportInformation.setInpatient(0);
                    }else {
                        reportInformation.setInpatient(1);
                    }
                    //是否到过重点地区
                    String isBadCase = excelTeacherDomain.getIsBadCase();
                    //本人是否到过（经过）疫情重点区 (0未到过/1到过)
                    if (ConstantInfo.isBadCase.equals(isBadCase)){
                        reportInformation.setServerlyArea(1);
                    }else {
                        reportInformation.setServerlyArea(0);
                    }

                    //居家人员是否到过疫情地区
                    //共同居住的家庭成员是否到过（经过）疫情重点区(0未到过,1到过
                    String familyIsGoToBadRrea = excelTeacherDomain.getFamilyIsGoToBadRrea();
                    if (ConstantInfo.familyIsGoToBadRrea.equals(familyIsGoToBadRrea)){
                        reportInformation.setFamilySeverelyArea(1);
                    }else {
                        reportInformation.setFamilySeverelyArea(0);
                    }
                    //所居住的小区或村庄是否有确诊或疑似新冠肺炎病例(0有/1没有)
                    String isBadPerson = excelTeacherDomain.getIsBadPerson();
                    if (ConstantInfo.isBadPerson.equals(isBadPerson)){
                        reportInformation.setAreaDisease(0);
                    }else {
                        reportInformation.setAreaDisease(1);
                    }
                    //设置学号
                    reportInformation.setNumber(teacherInformation.getTeacherNumber());
                    //设置类型
                    reportInformation.setType(ConstantInfo.teacher_type);
                    //其它事项说明
                    reportInformation.setOthers(excelTeacherDomain.getOther());
                    //本人是否确诊为病例或疑似病例(0不是,1是)
                    String badCase = excelTeacherDomain.getBadCase();
                    if (ConstantInfo.badCase.equals(badCase)){
                        reportInformation.setIfDermine(1);
                    }else {
                        reportInformation.setIfDermine(0);
                    }
                    if (excelTeacherDomain.getIsPing().equals("是"))
                    {
                        reportInformation.setTeacherPds(0);
                    }else {
                        reportInformation.setTeacherPds(1);
                    }
                    reportInformationMapper.insert(reportInformation);
                    // 外出信息
                    //外出的地点
                    if(ConstantInfo.outDoorY.equals(excelTeacherDomain.getIsOut())){
                        OutInformation outInformation = new OutInformation();
                        outInformation.setReportId(reportInformation.getReportId());
                        //设置外出方式
                        outInformation.setVehicle(excelTeacherDomain.getTraffic());
                        String outTime = excelTeacherDomain.getOutTime();
                        System.out.println(outTime+"外出时间");
                        if (outTime!=null && outTime!=" " && !outTime.equals("否")){
                            Date date1 = Utils.StringAsDate1(outTime);
                            outInformation.setOutTime(date1);
                        }
                        //外出时间
                        String backTime = excelTeacherDomain.getBackTime();
                        Date date2 = Utils.StringAsDate1(backTime);
                        outInformation.setBackTime(date2);
                        String outArea = excelTeacherDomain.getOutArea();
                        List<String> areea1 = Utils.Areea(outArea);
                        Integer integer1 = areaDataMapper.selectByCityAndArea(areea1.get(0), areea1.get(1).trim());
                        outInformation.setOutArea(integer1);
                        outInformationMapper.insert(outInformation);
                        System.out.println("外出地点"+outArea);
                    }
                    if (ConstantInfo.isolationY.equals(excelTeacherDomain.getIsolation()))
                    {
                        IsolationInformation isolationInformation = new IsolationInformation();
                        //设置上报id
                        isolationInformation.setReportId(reportInformation.getReportId());
                        //设置是否在家隔离
                        if (ConstantInfo.isolationY.equals(excelTeacherDomain.getInHomeIsolation())){
                            isolationInformation.setIsolationHome(1);
                        }else {
                            isolationInformation.setIsolationHome(0);
                        }
                        //是否强制隔离
                        if (ConstantInfo.isolationY.equals(excelTeacherDomain.getMandatoryIsolation())){
                            //是否医疗机构强制隔离(0不是/1是)
                            isolationInformation.setIsolationHospital(1);
                        }{
                        isolationInformation.setIsolationHospital(0);
                    }
                        //是否隔离

                        //隔离开始时间
                        String isolationBeginTime = excelTeacherDomain.getIsolationBeginTime();
                        Date begin = Utils.StringAsDate(isolationBeginTime);
                        isolationInformation.setIsolationStart(begin);
                        //隔离结束时间
                        String isolationEndTime = excelTeacherDomain.getIsolationEndTime();
                        Date end = Utils.StringAsDate(isolationEndTime);
                        isolationInformation.setIsolationEnd(end);
                        //插入信息
                        isolationInformationMapper.insert(isolationInformation);
                        flag=true;

                }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
