package pdsu.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdsu.project.dao.*;
import pdsu.project.domain.*;
import pdsu.project.service.ExcelService;
import pdsu.project.utils.ConstantInfo;
import pdsu.project.utils.ExcelDomain;
import pdsu.project.utils.Utils;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author ljk
 */

@Service
@Transactional
public class ExclelServiceIml  implements ExcelService {

    /***
     *    学生信息
     */
    @Autowired
    private StudentInformationMapper studentInformationMapper;

    /***
     * 院系
     */
    @Autowired
    DepartmentInformationMapper departmentInformationMapper;

    /***
     * 宿舍信息
     */
    @Autowired
    private DormitoryInformationMapper dormitoryInformationMapper;

    //班级信息
    @Autowired
    private ClassInformationMapper classInformationMapper;

    //年级信息
    @Autowired
    private GradeInformationMapper gradeInformationMapper;

    //地区信息
    @Autowired
    private  AreaDataMapper areaDataMapper;

    //用户信息
    @Autowired
   private UserInformationMapper userInformationMapper;

    ///报备信息
    @Autowired
    private  ReportInformationMapper reportInformationMapper;

    //外出信息
    @Autowired
    private OutInformationMapper outInformationMapper;


    @Autowired
    TemptureInformationMapper temptureInformationMapper;

   //导入Excel
    @Override
    public Boolean Excel(ExcelDomain excelDomain) {
        Boolean flag=false;
        System.out.println(excelDomain);
        String Num = excelDomain.getNum();
        StudentInformation studentInfor = studentInformationMapper.selectByNum(Num);
        if (studentInfor==null){
            StudentInformation studentInformation = new StudentInformation();
            //设置姓名
            studentInformation.setStudentName(excelDomain.getName());
            //手机号
            studentInformation.setStudentPhone(excelDomain.getMyPhone());
            //紧急联系人姓名
            studentInformation.setStudentContactName(excelDomain.getParaentName());
            //设置紧急联系人电话号
            studentInformation.setStudentContactPhone(excelDomain.getParaentPhone());
            //户籍所在地
            String localHome = excelDomain.getLocalHome();
            System.out.println(localHome);
            try {
                List<String> stringList = Utils.Areea(localHome);
                Integer andArea = areaDataMapper.selectByCityAndArea(stringList.get(1), stringList.get(2));
                studentInformation.setStudentCensusAddress(andArea);
            } catch (Exception e) {
                return  flag;
            }
            //常住地址
            String myOffenHome = excelDomain.getMyOffenHome();
            try {
                List<String> areea = Utils.Areea(myOffenHome);
                System.out.println(areea+"pp");
                Integer byCityAndArea = areaDataMapper.selectByCityAndArea(areea.get(1), areea.get(2));
                studentInformation.setStudentPermanentAddress(byCityAndArea);
            } catch (Exception e) {
                return  flag;
            }
            //详细地址
            studentInformation.setStudentDetailPeraddress(excelDomain.getMyOffenHomeDeatil());
            //设置密码
            studentInformation.setStudentPassword("123456");
            //设置宿舍
            try {
                String excelDomainDor = excelDomain.getDor();
                Integer dor= Utils.DorNum(excelDomainDor);
                DormitoryInformation dormitoryInformation = new DormitoryInformation();
                dormitoryInformation.setDormitoryId(dor);
                dormitoryInformation.setDormitoryName(excelDomainDor);
                DormitoryInformation dormitoryInformation1 = dormitoryInformationMapper.selectByPrimaryKey(dor);
                if (dormitoryInformation1==null){
                    dormitoryInformationMapper.insert(dormitoryInformation);
                }
                studentInformation.setStudentDormitory(dor);
            } catch (Exception e) {
                return flag;
            }
            //设置学号
            studentInformation.setStudentNumber(excelDomain.getNum());
            //设置性别
            String sex = excelDomain.getSex();
            if (ConstantInfo.man.equals(sex)){
                studentInformation.setStudentSex(1);
            }else {
                studentInformation.setStudentSex(0);
            }
            //设置年级
            String num= excelDomain.getNum();
            String grade = Utils.Grade(num);
            System.out.println(num);
            Integer gradeId = null;
            //根据学号切割划分年级
            switch (grade){
                case "16": gradeId=gradeInformationMapper.selectByGradeName(ConstantInfo.grade1) ;
                case "17": gradeId= gradeInformationMapper.selectByGradeName(ConstantInfo.grade2) ;
                case "18": gradeId= gradeInformationMapper.selectByGradeName(ConstantInfo.grade3) ;
                case "19": gradeId= gradeInformationMapper.selectByGradeName(ConstantInfo.grade4) ;
            }
            studentInformation.setGradeId(gradeId);
            //设置班级
            String className = excelDomain.getClassName();
            //查询数据库是否有班级信息
            Integer classNum = classInformationMapper.selectByClassName1(className);
            System.out.println(classNum);
            ClassInformation classInformation=null;
            if (classNum==null){
                //没有就插入信息
                classInformation=   new ClassInformation();
                classInformation.setClassName(className);
                //返回插入班级Id
                classInformationMapper.insert(classInformation);
                studentInformation.setClassId(classInformation.getId());
            }else {
                studentInformation.setClassId(classNum);
            }
            //院系名字
            String deptName = excelDomain.getDeptName();
            DepartmentInformation departmentInformation = null;
            Integer byDeptNameId = departmentInformationMapper.selectByDeptName(deptName);
            if (byDeptNameId==null){
                //院系信息
                departmentInformation = new DepartmentInformation();
                departmentInformation.setDepartmentName(deptName);
                departmentInformationMapper.insert(departmentInformation);
                //设置院系id
                studentInformation.setStudentDepartment(departmentInformation.getDepartmentId());
            }else {
                studentInformation.setStudentDepartment(byDeptNameId);
            }
            //学生id
            studentInformationMapper.insert(studentInformation);
            UserInformation userInformation = new UserInformation();
            //用户
            userInformation.setRoleId(2);
            userInformation.setStudentId(studentInformation.getId());

            userInformation.setDescb("学生");
            userInformationMapper.insert(userInformation);
            System.out.println(studentInformation);
            System.out.println(userInformation);
            //下边为隔离报备信息
            //组装报备信息
            ReportInformation reportInformation = new ReportInformation();
            //上报日期
            String reportTime = excelDomain.getReportTime();
            Date date = Utils.StringAsDate(reportTime);
            reportInformation.setReportTime(date);
            //上报温度
            System.out.println(excelDomain.getTemp()+"上报温度");
            String temp=  excelDomain.getTemp();
            String replace = temp.replace(" ", "");
            if (replace.length()>4){
                replace = replace.substring(0, 4);
            }
            try {
                reportInformation.setTemperature(Double.parseDouble(replace));
            } catch (NumberFormatException e) {
                return flag;
            }
            //健康状况
            reportInformation.setHealth(excelDomain.getHealthy());
            //现在所在的详细地址
            reportInformation.setNowDetailaddress(excelDomain.getNowDetailArea());
//            设置现在所在地址//省市县
            String nowArea = excelDomain.getNowArea();
            System.out.println(nowArea+"ppppppddddd");
            List<String> now = Utils.Areea(nowArea);
            //查询当前地址的id
            try {
                Integer nowId = areaDataMapper.selectByCityAndArea(now.get(1), now.get(2).trim());
                if (nowId!=null){
                    //当前地址的id
                    reportInformation.setNowAddress(nowId);
                }
            } catch (Exception e) {
                return  flag;
            }
//
            String isOut = excelDomain.getIsOut();
            if (ConstantInfo.outDoorN.equals(isOut))
            {
                //没有外出
                reportInformation.setOut(1);
            }else {
                //外出了
                reportInformation.setOut(0);
            }
            //本人是否隔离((0是1否))
            String isolation = excelDomain.getIsolation();
            if (ConstantInfo.isolationN.equals(isolation)){
                reportInformation.setIsolation(1);
            }else {
                reportInformation.setIsolation(0);
            }
            /***
             * 是否有就诊住院(0是1否)
             */
            String isHospital = excelDomain.getIsHospital();
            if (ConstantInfo.isisHospital.equals(isHospital)){
                reportInformation.setInpatient(0);
            }else {
                reportInformation.setInpatient(1);
            }
            //是否到过重点地区
            String isBadCase = excelDomain.getIsBadCase();
            //本人是否到过（经过）疫情重点区 (0未到过/1到过)
            if (ConstantInfo.isBadCase.equals(isBadCase)){
                reportInformation.setServerlyArea(1);
            }else {
                reportInformation.setServerlyArea(0);
            }
            //居家人员是否到过疫情地区
            //共同居住的家庭成员是否到过（经过）疫情重点区(0未到过,1到过
            String familyIsGoToBadRrea = excelDomain.getFamilyIsGoToBadRrea();
            if (ConstantInfo.familyIsGoToBadRrea.equals(familyIsGoToBadRrea)){
                reportInformation.setFamilySeverelyArea(1);
            }else {
                reportInformation.setFamilySeverelyArea(0);
            }
            //学生是否返校(0没有/1有)
            String backSchool = excelDomain.getBackSchool();
            if (ConstantInfo.backSchool.equals(backSchool)){
                reportInformation.setStudentBackschool(1);
            }else {
                reportInformation.setStudentBackschool(0);
            }
            //所居住的小区或村庄是否有确诊或疑似新冠肺炎病例(0有/1没有)
            String isBadPerson = excelDomain.getIsBadPerson();
            if (ConstantInfo.isBadPerson.equals(isBadPerson)){
                reportInformation.setAreaDisease(0);
            }else {
                reportInformation.setAreaDisease(1);
            }
            //设置学号
            reportInformation.setNumber(studentInformation.getStudentNumber());
            //设置类型
            reportInformation.setType(ConstantInfo.student_type);
            //其它事项说明
            reportInformation.setOthers(excelDomain.getOther());
            //本人是否确诊为病例或疑似病例(0不是,1是)
            String badCase = excelDomain.getBadCase();
            if (ConstantInfo.badCase.equals(badCase)){
                reportInformation.setIfDermine(1);
            }else {
                reportInformation.setIfDermine(0);
            }
            reportInformation.setTeacherPds(0);
            reportInformationMapper.insert(reportInformation);
            //外出的地点
            if(ConstantInfo.outDoorY.equals(excelDomain.getIsOut())){
                OutInformation outInformation = new OutInformation();
                outInformation.setReportId(reportInformation.getReportId());
                //设置外出方式
                outInformation.setVehicle(excelDomain.getTraffic());
                String outTime = excelDomain.getOutTime();
                System.out.println(outTime+"外出时间");
                if (outTime!=null && outTime!=" " && !outTime.equals("否")){
                    Date date1 = Utils.StringAsDate1(outTime);
                    outInformation.setOutTime(date1);
                }
                //外出时间
                String backTime = excelDomain.getBackTime();
                Date date2 = Utils.StringAsDate1(backTime);
                outInformation.setBackTime(date2);
                String outArea = excelDomain.getOutArea();
                List<String> areea = Utils.Areea(outArea);
                Integer integer = areaDataMapper.selectByCityAndArea(areea.get(0), areea.get(1).trim());
                outInformation.setOutArea(integer);
                outInformationMapper.insert(outInformation);
                System.out.println("外出地点"+outArea);
            }
        }else {

            ReportInformation reportInformation1 = reportInformationMapper.selectByNumAndToday(studentInfor.getStudentNumber(), LocalDate.now());
            if (reportInformation1==null){
                //下边为隔离报备信息
                //组装报备信息
                ReportInformation reportInformation = new ReportInformation();
                //上报日期
                String reportTime = excelDomain.getReportTime();
                Date date = Utils.StringAsDate(reportTime);
                reportInformation.setReportTime(date);
                Integer integer1=   reportInformationMapper.selesctByTime(date,studentInfor.getStudentNumber());
                if (integer1==1){
                    flag=true;
                    return  flag;
                }
                //上报温度
                System.out.println(excelDomain.getTemp()+"上报温度");
                String temp=  excelDomain.getTemp();
                String replace = temp.replace(" ", "");
                if (replace.length()>4){
                    replace = replace.substring(0, 4);
                }
                try {
                    reportInformation.setTemperature(Double.parseDouble(replace));
                } catch (NumberFormatException e) {
                    return flag;
                }
                //健康状况
                reportInformation.setHealth(excelDomain.getHealthy());
                //现在所在的详细地址
                reportInformation.setNowDetailaddress(excelDomain.getNowDetailArea());
//            设置现在所在地址//省市县
                String nowArea = excelDomain.getNowArea();
                System.out.println(nowArea+"ppppppddddd");
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
//
                String isOut = excelDomain.getIsOut();
                if (ConstantInfo.outDoorN.equals(isOut))
                {
                    //没有外出
                    reportInformation.setOut(1);
                }else {
                    //外出了
                    reportInformation.setOut(0);
                }
                //本人是否隔离((0是1否))
                String isolation = excelDomain.getIsolation();
                if (ConstantInfo.isolationN.equals(isolation)){
                    reportInformation.setIsolation(1);
                }else {
                    reportInformation.setIsolation(0);
                }
                /***
                 * 是否有就诊住院(0是1否)
                 */
                String isHospital = excelDomain.getIsHospital();
                if (ConstantInfo.isisHospital.equals(isHospital)){
                    reportInformation.setInpatient(0);
                }else {
                    reportInformation.setInpatient(1);
                }
                //是否到过重点地区
                String isBadCase = excelDomain.getIsBadCase();
                //本人是否到过（经过）疫情重点区 (0未到过/1到过)
                if (ConstantInfo.isBadCase.equals(isBadCase)){
                    reportInformation.setServerlyArea(1);
                }else {
                    reportInformation.setServerlyArea(0);
                }
                //居家人员是否到过疫情地区
                //共同居住的家庭成员是否到过（经过）疫情重点区(0未到过,1到过
                String familyIsGoToBadRrea = excelDomain.getFamilyIsGoToBadRrea();
                if (ConstantInfo.familyIsGoToBadRrea.equals(familyIsGoToBadRrea)){
                    reportInformation.setFamilySeverelyArea(1);
                }else {
                    reportInformation.setFamilySeverelyArea(0);
                }
                //学生是否返校(0没有/1有)
                String backSchool = excelDomain.getBackSchool();
                if (ConstantInfo.backSchool.equals(backSchool)){
                    reportInformation.setStudentBackschool(1);
                }else {
                    reportInformation.setStudentBackschool(0);
                }
                //所居住的小区或村庄是否有确诊或疑似新冠肺炎病例(0有/1没有)
                String isBadPerson = excelDomain.getIsBadPerson();
                if (ConstantInfo.isBadPerson.equals(isBadCase)){
                    reportInformation.setAreaDisease(0);
                }else {
                    reportInformation.setAreaDisease(1);
                }
                //设置学号
                reportInformation.setNumber(studentInfor.getStudentNumber());
                //设置类型
                reportInformation.setType(ConstantInfo.student_type);
                //其它事项说明
                reportInformation.setOthers(excelDomain.getOther());
                //本人是否确诊为病例或疑似病例(0不是,1是)
                String badCase = excelDomain.getBadCase();
                if (ConstantInfo.badCase.equals(badCase)){
                    reportInformation.setIfDermine(1);
                }else {
                    reportInformation.setIfDermine(0);
                }

                reportInformationMapper.insert(reportInformation);

                //外出的地点
                if(ConstantInfo.outDoorY.equals(excelDomain.getIsOut())){
                    OutInformation outInformation = new OutInformation();
                    outInformation.setReportId(reportInformation.getReportId());
                    //设置外出方式
                    outInformation.setVehicle(excelDomain.getTraffic());
                    String outTime = excelDomain.getOutTime();
                    System.out.println(outTime+"外出时间");
                    if (outTime!=null && outTime!=" " && !outTime.equals("否")){
                        Date date1 = Utils.StringAsDate1(outTime);
                        outInformation.setOutTime(date1);
                    }
                    //外出时间
                    String backTime = excelDomain.getBackTime();
                    Date date2 = Utils.StringAsDate1(backTime);
                    outInformation.setBackTime(date2);
                    String outArea = excelDomain.getOutArea();
                    List<String> areea = Utils.Areea(outArea);
                    Integer integer = areaDataMapper.selectByCityAndArea(areea.get(0), areea.get(1).trim());
                    outInformation.setOutArea(integer);
                    outInformationMapper.insert(outInformation);
                    System.out.println("外出地点"+outArea);
                }

                flag=true;
                System.out.println(reportInformation);
            }
        }
        return flag;
    }
}
