package pdsu.project.service.impl;

import org.apache.commons.lang.math.IntRange;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdsu.project.dao.*;
import pdsu.project.domain.*;
import pdsu.project.service.UpdateInfoService;
import pdsu.project.utils.ConstantInfo;
import pdsu.project.utils.DifList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ljk
 */
@Service
@Transactional
public class UpdateInfoServiceImpl implements UpdateInfoService {

    //学生
    @Autowired
    private StudentInformationMapper studentInformationMapper;

    //老师
    @Autowired
    private TeacherInformationMapper teacherInformationMapper;

    //一日三报信息
    @Autowired
    TemptureInformationMapper temptureInformationMapper;

    @Autowired
    private DepartmentInformationMapper departmentInformationMapper;

    @Autowired
    private LogInformationMapper logInformationMapper;
    
    
    @Autowired
    private ClassInformationMapper classInformationMapper;



    @Autowired
    private UserInformationMapper userInformationMapper;

    @Override
    public Boolean updateUserInfo(String num, String password) {
        Boolean flag=false;
        //查询学生信息
        StudentInformation studentInformation = studentInformationMapper.selectByNum(num);
       if (studentInformation!=null){
           studentInformation.setStudentPassword(password);
           studentInformationMapper.updateByPrimaryKey(studentInformation);
           flag=true;
           return  flag;
       }else {
           try {
               TeacherInformation teacherInformation = teacherInformationMapper.selectByTeacherNum(num);
               if (teacherInformation!=null){
                   teacherInformation.setTeacherPassword(password);
                   teacherInformationMapper.updateByPrimaryKey(teacherInformation);
                   flag=true;
                   return flag;
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
        return null;
    }

    ///返回一共的条数
    @Override
    public Integer count(Integer type) {
        Integer count=0;
        if (ConstantInfo.teacher_type.equals(type))
        {
             count=teacherInformationMapper.count();
        }else {
            count=studentInformationMapper.count();
        }
        return count;
    }

    @Override
    public ArrayList<HashMap<String, Object>> UnRecordInfo(Integer dept,Integer type) {
        ArrayList<HashMap<String, Object>> hashMaps = new ArrayList<>();
        if (ConstantInfo.teacher_type.equals(type))
        {
            List<String> list = teacherInformationMapper.selectAllTeacherNumByDeptId(dept);
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i=0;i<list.size();i++) {
                integers.add(Integer.parseInt(list.get(i)));
            }
            //查询未录入老师信息
            //早上
            ArrayList<Integer> arrayList = new ArrayList<>();
            List<TemptureInformation> temptureInformations = temptureInformationMapper.slectAllUnRecord(LocalDate.now(), ConstantInfo.teacher_type,integers);
            for (TemptureInformation temptureInformation:temptureInformations){
                 for (int i=0;i<integers.size();i++){
                     if (integers.get(i)==temptureInformation.getTemptureNum()){
                         arrayList.add(integers.get(i));
                     }
                 }
            }
            //晚上
            List<TemptureInformation> temptureInforEve = temptureInformationMapper.slectAllUnRecordEve(LocalDate.now(), ConstantInfo.teacher_type,integers);
            //中午
            List<TemptureInformation> temptureInforLun = temptureInformationMapper.slectAllUnRecordLun(LocalDate.now(), ConstantInfo.teacher_type,integers);
            temptureInformations.addAll(temptureInforEve);
            temptureInformations.addAll(temptureInforLun);
            if (temptureInformations.size()>0 && temptureInformations!=null){
                for (TemptureInformation t:temptureInformations) {
                    //存放信息
                    HashMap<String, Object> map = new HashMap<>();
                    try {
                        TeacherInformation teacherInformation = teacherInformationMapper.selectByTeacherNum(t.getTemptureNum() + "");
                        if (teacherInformation!=null){
                            //工号
                            map.put("num",teacherInformation.getTeacherNumber());
                            //姓名
                            map.put("name",teacherInformation.getTeacherName());
                          //联系方式
                            map.put("phone",teacherInformation.getTeacherPhone());
                            DepartmentInformation departmentInformation = departmentInformationMapper.selectByPrimaryKey(teacherInformation.getDepartmentId());
                           //院系
                            map.put("dept",departmentInformation.getDepartmentName());
                            String record="";
                            if (t.getTemptureEve()!=null) {
                                record =record+ "晚上";
                            }
                            if (t.getTemptureLun()!=null){
                                record =record+ ",中午";
                            }if (t.getTemptureMor()!=null){
                                record =record+ "早上,";
                            }
                            //时间段
                            map.put("time",record);

                           hashMaps.add(map);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            List<TemptureInformation> temptureInformations2 = temptureInformationMapper.slectAllRecord1(LocalDate.now(), 1);
            ArrayList<Integer> tempnum=new ArrayList<Integer>();
            for (TemptureInformation tmp : temptureInformations2) {
                tempnum.add(tmp.getTemptureNum());
            }
            System.out.println("liststu.size():"+integers.size()+"tempnum.size:"+tempnum.size());
            List<Integer> l = DifList.compare(tempnum,integers);
            for (Integer i:l) {
                HashMap<String, Object> map = new HashMap<>();
                try {
                    TeacherInformation teacherInformation = teacherInformationMapper.selectByTeacherNum(i + "");
                    if (teacherInformation!=null){
                        //工号
                        map.put("num",teacherInformation.getTeacherNumber());
                        //姓名
                        map.put("name",teacherInformation.getTeacherName());
                        //联系方式
                        map.put("phone",teacherInformation.getTeacherPhone());
                        DepartmentInformation departmentInformation = departmentInformationMapper.selectByPrimaryKey(teacherInformation.getDepartmentId());
                        //院系
                        map.put("dept",departmentInformation.getDepartmentName());

                        String record = "";
                        record = record + "早上,";
                        record = record + "中午,";
                        record = record + "晚上";
                        //时间段
                        map.put("time",record);

                        hashMaps.add(map);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }else {

            //所有学生信息
            List<String> list = studentInformationMapper.selectAllStudentNumByDeptId(dept);
            ArrayList<Integer> liststu=new ArrayList<Integer>();
            for (String string : list) {
				Integer numInteger=Integer.parseInt(string);
				liststu.add(numInteger);
			}
            List<TemptureInformation> temptureInformations = temptureInformationMapper.slectAllUnRecord(LocalDate.now(), 1,liststu);
            //全部录入数据
            List<TemptureInformation> temptureInformations2 = temptureInformationMapper.slectAllRecord1(LocalDate.now(), 1);
            ArrayList<Integer> tempnum=new ArrayList<Integer>();
            for (TemptureInformation tmp : temptureInformations2) {
				tempnum.add(tmp.getTemptureNum());
			}
            System.out.println("liststu.size():"+liststu.size()+"tempnum.size:"+tempnum.size());
            List<Integer> l = DifList.compare(tempnum,liststu);
            System.out.println("list2.size:"+l.size()+"pppp"+"list2:"+l.toString());
            for (Integer t : l) {
                //存放信息
                HashMap<String, Object> map = new HashMap<>();
                StudentInformation studentInformation = studentInformationMapper.selectByNum(t + "");
                if (studentInformation != null) {
                    map.put("num", studentInformation.getStudentNumber());
                    //姓名
                    map.put("name", studentInformation.getStudentName());
                    //联系方式
                    map.put("phone", studentInformation.getStudentName());
                    ClassInformation classInformation = classInformationMapper.selectByPrimaryKey(studentInformation.getClassId());
                    if (classInformation != null) {
                        //班级
                        map.put("dept", classInformation.getClassName());
                    }
                    //宿舍
                    map.put("dor", studentInformation.getStudentDormitory());
                    String record = "";
                    record = record + "早上,";
                    record = record + "中午,";
                    record = record + "晚上";
                    //时间段
                    map.put("time", record);
                    hashMaps.add(map);
                }
            }
            //晚上
            List<TemptureInformation> temptureInforEve = temptureInformationMapper.slectAllUnRecordEve(LocalDate.now(), ConstantInfo.student_type,liststu);
            //中午
            List<TemptureInformation> temptureInforLun = temptureInformationMapper.slectAllUnRecordLun(LocalDate.now(), ConstantInfo.student_type,liststu);
            temptureInformations.addAll(temptureInforLun);
            temptureInformations.addAll(temptureInforEve);

            if (temptureInformations.size()>0 && temptureInformations!=null) {
                for (TemptureInformation t : temptureInformations) {
                    //存放信息
                    HashMap<String, Object> map = new HashMap<>();
                    StudentInformation studentInformation = studentInformationMapper.selectByNum(t.getTemptureNum() + "");
                    if (studentInformation!=null){
                        map.put("num",studentInformation.getStudentNumber());
                        //姓名
                        map.put("name",studentInformation.getStudentName());
                        //联系方式
                        map.put("phone",studentInformation.getStudentName());
                        ClassInformation classInformation = classInformationMapper.selectByPrimaryKey(studentInformation.getClassId());
                        if (classInformation!=null){
                            //班级
                            map.put("dept",classInformation.getClassName());
                        }
                        //宿舍
                        map.put("dor",studentInformation.getStudentDormitory());
                        String record="";
                        if (t.getTemptureEve()!=null) {
                            record =record+ "晚上";
                        }
                        if (t.getTemptureLun()!=null){
                            record =record+ ",中午";
                        }if (t.getTemptureMor()!=null){
                            record =record+ ",早上";
                        }
                        //时间段
                        map.put("time",record);
                        hashMaps.add(map);
                    }
                }
            }
        }
        return hashMaps;
    }

    //查询所有的院系
    @Override
    public List<DepartmentInformation> AllDdept() {
        return departmentInformationMapper.selectAll();
    }
    //查看所有上传文件信息
    public List<LogInformation> AllRecordFile() {
        return logInformationMapper.selectAll();
    }
    
  //更新用户信息
    @Override
    public Boolean updateInfo(int id, String num, String userNme, String phone, String role, String employer, String password) {
        Boolean flag=false;
        try {
            TeacherInformation teacherInformation = teacherInformationMapper.selectByTeacherNum(num);
            if (teacherInformation!=null){
                teacherInformation.setTeacherName(userNme);
                teacherInformation.setTeacherNumber(num);
                teacherInformation.setTeacherPhone(phone);
                teacherInformation.setTeacherPassword(password);
                Integer integer = departmentInformationMapper.selectByDeptName(employer);
                teacherInformation.setDepartmentId(integer);
                UserInformation userInformation = userInformationMapper.selectTeacherByKey(teacherInformation.getId());
                if (role.equals("admin")){
                    userInformation.setRoleId(1);
                }else {
                    userInformation.setRoleId(1);
                }
                userInformationMapper.updateByPrimaryKey(userInformation);
                teacherInformationMapper.updateByPrimaryKey(teacherInformation);
                flag=true;
            }else {
                StudentInformation studentInformation = studentInformationMapper.selectByNum(num);
                studentInformation.setStudentPassword(password);
                studentInformation.setStudentPhone(phone);
                ClassInformation classInformation = classInformationMapper.selectByClassName(employer);
                studentInformation.setClassId(classInformation.getId());
                studentInformation.setStudentName(userNme);
                studentInformation.setStudentNumber(num);
                UserInformation userInformation = userInformationMapper.selectStudentByKey(studentInformation.getId());
                if (role.equals("admin")){
                    userInformation.setRoleId(1);
                }else {
                    userInformation.setRoleId(1);
                }
                userInformationMapper.updateByPrimaryKey(userInformation);
                studentInformationMapper.updateByPrimaryKey(studentInformation);
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
