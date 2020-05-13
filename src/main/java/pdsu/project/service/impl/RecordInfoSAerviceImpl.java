package pdsu.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdsu.project.dao.*;
import pdsu.project.domain.*;
import pdsu.project.service.RecordInfoSAervice;
import pdsu.project.utils.ConstantInfo;

import java.time.LocalDate;
import java.util.*;

/**
 * @author ljk
 */


@Service
@Transactional
public class RecordInfoSAerviceImpl implements RecordInfoSAervice {

@Autowired
private StudentInformationMapper studentInformationMapper;

@Autowired
private TeacherInformationMapper teacherInformationMapper;


@Autowired
private TemptureInformationMapper temptureInformationMapper;


@Autowired
private DepartmentInformationMapper departmentInformationMapper;

@Autowired
private LogInformationMapper logInformationMapper;

@Autowired
private UserInformationMapper userInformationMapper;

@Autowired
private  ClassInformationMapper classInformationMapper;
    @Override
    public boolean upadtePassword(String num, String oldPassword, String Newpassword) {

        Boolean flag=false;

        StudentInformation studentInformation =
                studentInformationMapper.selectByNum(num);
           if (studentInformation!=null &&studentInformation.getStudentPassword().equals(oldPassword)){
               studentInformation.setStudentPassword(Newpassword);
               studentInformationMapper.updateByPrimaryKey(studentInformation);
               flag=true;
               return flag;
           }else {
               try {
                   TeacherInformation teacherInformation =
                           teacherInformationMapper.selectByTeacherNum(num);
                if (teacherInformation!=null && teacherInformation.getTeacherPassword().equals(oldPassword))
                {
                    teacherInformation.setTeacherPassword(Newpassword);
                }
                teacherInformationMapper.updateByPrimaryKey(teacherInformation);
                flag=true;
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
        return flag;
    }

    @Override
    public boolean RecordTemp(String name, String num, float tempture, int temSection) {
        boolean flag=false;
        TemptureInformation temptureInformation1 = temptureInformationMapper.selectByNum1(Integer.parseInt(num), LocalDate.now());
        if (temptureInformation1!=null){
            StudentInformation studentInformation = studentInformationMapper.selectByNum(num);
            if (studentInformation!=null){
               TemptureInformation temptureInformation = new TemptureInformation();
            	switch(temSection){
                case 0 :
                	if(temptureInformation1.getTemptureMor()!=null){
                		return false;
                		}else {
                			temptureInformation1.setTemptureMor(tempture);
						}
                   break; 
                case 1 :
                	if(temptureInformation1.getTemptureLun()!=null){
                		return false;
                		}else {
                			temptureInformation1.setTemptureLun(tempture);
						}
                   break; 
                case 2:
                	if(temptureInformation1.getTemptureEve()!=null){
                		return false;
                		}else{
                			temptureInformation1.setTemptureEve(tempture);
						}
                   break; 
            }
                temptureInformation.setTemptureDate(new Date());
                temptureInformationMapper.updateByPrimaryKey(temptureInformation1);
                flag=true;
                return  flag;
            }else {
                return false;
            }
        }else {
            TemptureInformation temptureInformation = new TemptureInformation();
            StudentInformation studentInformation = studentInformationMapper.selectByNum(num);
            if (studentInformation!=null){
            	temptureInformation.setTemptureNum(Integer.parseInt(num));
                temptureInformation.setType(ConstantInfo.student_type);
            }else{
            	return false;
            }
            if (temSection==0){
                temptureInformation.setTemptureMor(tempture);
            }if (temSection==1){
                temptureInformation.setTemptureLun(tempture);
            }if (temSection==2){
                temptureInformation.setTemptureEve(tempture);
            }
            //设置时间
            temptureInformation.setTemptureDate(new Date());
            //进行日期填报
            temptureInformationMapper.insert(temptureInformation);
            flag=true;
        }
        return flag;
    }

    @Override
    public Map<String, Object> findManger(Integer dept) {
        DepartmentInformation departmentInformation = departmentInformationMapper.selectByPrimaryKey(dept);
        HashMap<String, Object> map = new HashMap<>();
        if (departmentInformation!=null){
         UserInformation userInformation=userInformationMapper.selectIfo(departmentInformation.getDepartmentName());
        
         if (userInformation!=null){
             try {
            	 
                 TeacherInformation teacherInformation = teacherInformationMapper.selectById(userInformation.getTeacherId());
                 if (teacherInformation!=null){
                     map.put("num",teacherInformation.getTeacherNumber());
                     map.put("userName",teacherInformation.getTeacherName());
                     map.put("department",userInformation.getDescb());
                     map.put("phone",teacherInformation.getTeacherPhone());
                 }
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
        }
        return map;
    }

    @Override
    public List<Map<String, Object>> findByUid(int userid) {
        List<Map<String, Object>> list=new ArrayList<>();
        UserInformation userInformation = userInformationMapper.selectByPrimaryKey(userid);
        if (userInformation!=null){
            if (userInformation.getTeacherId()!=null){
                List<DepartmentInformation> departmentInformations = departmentInformationMapper.selectAll();

                for (DepartmentInformation d:departmentInformations) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("depId",d.getDepartmentId());
                    map.put("depName",d.getDepartmentName());
                    list.add(map);
                }
                return list;
            }else {
            	
                //StudentInformation studentInformation = studentInformationMapper.selectByNum(userInformation.getStudentId() + "");
                StudentInformation studentInformation = studentInformationMapper.selectById(userInformation.getStudentId());
                Integer studentDepartment = studentInformation.getStudentDepartment();
                List<Integer> allClassId = studentInformationMapper.selectAllClassId(studentDepartment);
                List<ClassInformation> classInformations = classInformationMapper.selectAll(allClassId);
                for (ClassInformation d:classInformations) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("classId",d.getId());
                    map.put("className",d.getClassName());
                    list.add(map);
                }
                return  list;
            }
        }
        return null;

    }

    @Override
    public List<LogInformation> findAll() {

        return logInformationMapper.selectAll();
    }

    @Override
    public int insertLoog(LogInformation logInformation) {
        return logInformationMapper.insert(logInformation);
    }
}
