package pdsu.project.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdsu.project.dao.*;
import pdsu.project.domain.*;
import pdsu.project.service.StudentInformationService;
import pdsu.project.utils.ConstantInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ljk
 */
@Service
@Transactional
public class StudentInformationServiceImpl implements StudentInformationService {

    /***
     * 注入学生信息接口
     */
    @Autowired
   private   StudentInformationMapper studentInformationMapper;

    @Autowired
    private UserInformationMapper userInformationMapper;

    //班级信息
    @Autowired
    private ClassInformationMapper classInformationMapper;

    //权限信息
    @Autowired
    private PermissionInformationMapper permissionInformationMapper;


    /***
     * 注入老师的信息
     */
    @Autowired
    private TeacherInformationMapper teacherInformationMapper;

    //根据班级名查询班级信息
    @Override
    public Map<String, Object> selectClassInfoByClassName(String className,Integer page) {
        HashMap<String, Object> info = new HashMap<>();
        ClassInformation classInformation = classInformationMapper.selectByClassName(className);
        if(classInformation!=null){
            Integer classId =classInformation.getId();
            List<StudentInformation> studentInformations = studentInformationMapper.selectAll(classId,page,10);
            Integer count=   studentInformationMapper.selectCount(classId);
            ArrayList<Map<String, Object>> maps = new ArrayList<>();
            for (StudentInformation s:studentInformations) {
                HashMap<String, Object> stringObjectHashMap = new HashMap<>();
//            学号
                stringObjectHashMap.put("id",s.getStudentNumber());
                //姓名
                stringObjectHashMap.put("name",s.getStudentName());
                //宿舍号
                stringObjectHashMap.put("dormitoryNum",s.getStudentDormitory());
                //电话号码
                stringObjectHashMap.put("tel",s.getStudentPhone());
//            封装数据
                maps.add(stringObjectHashMap);
            }
            info.put("classStuInfo",maps);
            info.put("count",count);
            return info;

        }
     return null;
    }

    /***
     * 返回查询的信息
     * @param number
     * @param password
     * @return
     */
    @Override
    public Map<String, Object> selectUserInfo(String number, String password) {
        //作为储存信息的实体
        HashMap<String, Object> map = new HashMap<>();
        //根据账号或者密码查询信息
        StudentInformation studentInformation = studentInformationMapper.selectByPrimaryKey(number, password);
        System.out.println(studentInformation);
        if(studentInformation!=null){
           //查询对应的角色
//            int parseInt = Integer.parseInt(studentInformation.getStudentNumber();
            //查询用户信息表
            UserInformation userInformation = userInformationMapper.selectStudentByKey(studentInformation.getId());
            //查询权限表
            Integer roleId = userInformation.getRoleId();
            String roleName = null;
            try {
                roleName = studentInformationMapper.roleName(roleId);
            } catch (Exception e) {
                System.out.println(e.getMessage()+"出错了");
            }
            map.put("studentInformation",studentInformation);
            map.put("role",roleName);
            return map;
        }else {
            //查询对应的老师信息
            TeacherInformation teacherInformation = teacherInformationMapper.selectByPrimaryKey(number, password);
            if (teacherInformation!=null){
                int parseInt =   Integer.parseInt(teacherInformation.getTeacherNumber());
                //查询用户信息
                UserInformation userInformation = userInformationMapper.selectTeacherByKey(teacherInformation.getId());
                String roleName = studentInformationMapper.roleName(userInformation.getRoleId());
                map.put("teacherInformation",teacherInformation);
                map.put("role",roleName);
                return  map;
            }
            //查询对应的权限
          else {
              return  null;
            }
        }
    }

    /***
     * 根据宿舍号查询宿舍id
     * @param dormitoryNum
     * @return
     */

    
    public DorInformation selectDorInfo(Integer dormitoryNum) {
        //定义一个集合存储所要显示的信息
      ArrayList<Map<String, Object>> maps = new ArrayList<>();
      //根据宿舍号查询一个宿舍的信息
      List<StudentInformation> studentInformations = studentInformationMapper.selectByDorNum(dormitoryNum);
      for (StudentInformation s:studentInformations) {
          HashMap<String, Object> map = new HashMap<>();
          //根据学号查相应的身份
          UserInformation userInformation = userInformationMapper.selectStudentByKey(Integer.parseInt(s.getStudentNumber()));
          	if(s!=null){
          		 map.put("id",s.getStudentNumber());
                   map.put("name",s.getStudentName());
                   map.put("te",s.getStudentPhone());
                   maps.add(map);
          	}
             else {
              return  null;
              }
          }
      DorInformation dorInformation = new DorInformation();
      dorInformation.setDormitoryInfo(maps);
      return  dorInformation;  
    }


  //14
    //根据Id查询修改逻辑
    @Override
    public Map<String, Object> selectById(Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        //根据id来查询信息
        UserInformation userInformation1 = userInformationMapper.selectByPrimaryKey(id);
        if (userInformation1.getTeacherId()!=null){
            //根据用户信息查询老师信息
            TeacherInformation teacherInformation = teacherInformationMapper.selectById(userInformation1.getTeacherId());
            if (teacherInformation!=null){

                UserInformation userInformation = userInformationMapper.selectTeacherByKey(Integer.parseInt(teacherInformation.getTeacherNumber()));
                String roleName = null;
                try {
                    roleName = studentInformationMapper.roleName(userInformation.getRoleId());
                } catch (Exception e) {
                    roleName=null;
                }
                map.put("id",teacherInformation.getTeacherNumber());
                map.put("username",teacherInformation.getTeacherName());
                //老师没有专业.分配院系
                String deptName = teacherInformationMapper.selecrByDepartId(teacherInformation.getDepartmentId());
                //院系名称
                map.put("employer",deptName);
                //密码
                map.put("password",teacherInformation.getTeacherPassword());
                //电话
                map.put("phone",teacherInformation.getTeacherContactPhone());
                //角色
                map.put("role",roleName);
                return  map;
            }else{
                return  null;
            }
        }
       else {
            StudentInformation studentInformation = studentInformationMapper.selectById(userInformation1.getStudentId());
            if (studentInformation!=null){
//                List<String> roles= studentInformationMapper.selectRoleNameByNum(teacherInformation.getTeacherNumber());
                UserInformation userInformation = userInformationMapper.selectStudentByKey(studentInformation.getId());
                //查询权限表
                Integer roleId = userInformation.getRoleId();
                String roleName = null;
                try {
                    roleName = studentInformationMapper.roleName(roleId);
                } catch (Exception e) {
                    roleName=null;
                    System.out.println(e.getMessage()+"数据为空了");
                }
                map.put("id",studentInformation.getId());
                map.put("username",studentInformation.getStudentName());
                //存放班级
                ClassInformation classInformation = classInformationMapper.selectByPrimaryKey(studentInformation.getClassId());
                map.put("employer",classInformation.getClassName());
                map.put("password",studentInformation.getStudentPassword());
                map.put("phone",studentInformation.getStudentContactPhone());
                map.put("role",roleName);
                return  map;
            }
        }
        return null;
    }





    @Override
    public Map<String, Object> selectByNum(String id) {
        HashMap<String, Object> map = new HashMap<>();
        StudentInformation s = studentInformationMapper.selectByNum(id);
        if (s!=null){
            map.put("id",s.getId());
            map.put("num",s.getStudentNumber());
            map.put("userName",s.getStudentName());
            map.put("phone",s.getStudentContactPhone());
            //存放班级
            map.put("employer",classInformationMapper.selectByPrimaryKey(s.getClassId()).getClassName());
            //为学生的id
            UserInformation userInformation = userInformationMapper.selectStudentByKey(s.getId());
            String roleName = null;
            try {
                roleName = studentInformationMapper.roleName(userInformation.getRoleId());
            } catch (Exception e) {
                System.out.println(roleName+"出错了...数据为空");
            }
            map.put("role",roleName);
        }else {
            TeacherInformation t = null;
            try {
                t = teacherInformationMapper.selectByTeacherNum(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            map.put("id",t.getId());
            map.put("num",t.getTeacherNumber());
            map.put("userName",t.getTeacherName());
            map.put("phone",t.getTeacherPhone());
            //存放老师的院系
            String deptName = teacherInformationMapper.selecrByDepartId(t.getDepartmentId());
            map.put("employer",deptName);
            //查询老师信息
            UserInformation userInformation = userInformationMapper.selectTeacherByKey(Integer.parseInt(t.getTeacherNumber()));
            String roleName = null;
            try {
                roleName = studentInformationMapper.roleName(userInformation.getRoleId());
            } catch (Exception e) {
                System.out.println(e.getMessage()+"角色为空");
            }
            map.put("role",roleName);
        }
        return map;
    }

    @Override
    public List<Map<String, Object>> findAllByPage(Integer page,Integer type) {
        Page<Object> objects = PageHelper.startPage(page, 10);
        ArrayList<Map<String, Object>> maps = new ArrayList<>();
        if (ConstantInfo.teacher_type.equals(type)){
            List<TeacherInformation> selectAll = teacherInformationMapper.selectAllByPag((page-1)*10,10);
            for (TeacherInformation t:selectAll) {
                UserInformation userInformation = userInformationMapper.selectTeacherByKey(t.getId());
                HashMap<String, Object> map = new HashMap<>();
                map.put("id",userInformation.getId());
                map.put("num",t.getTeacherNumber());
                map.put("userName",t.getTeacherName());
                map.put("phone",t.getTeacherPhone());
                //存放老师的院系
                String deptName = teacherInformationMapper.selecrByDepartId(t.getDepartmentId());
                map.put("employer",deptName);
                //查询老师信息

                String roleName = null;
                try {
                    roleName = studentInformationMapper.roleName(userInformation.getRoleId());
                } catch (Exception e) {
                    System.out.println(e.getMessage()+"角色为空");
                }
                map.put("role",roleName);
                maps.add(map);
            }
        }else {
            List<StudentInformation> allStudent = studentInformationMapper.selectAllStudentByPage((page-1)*10,10);
            for (StudentInformation s: allStudent) {
                UserInformation userInformation = userInformationMapper.selectStudentByKey(s.getId());
                HashMap<String, Object> map = new HashMap<>();
                map.put("id",userInformation.getId());
                map.put("num",s.getStudentNumber());
                map.put("userName",s.getStudentName());
                map.put("phone",s.getStudentContactPhone());
                //存放班级
                map.put("employer",classInformationMapper.selectByPrimaryKey(s.getClassId()).getClassName());
                //为学生的id
                String roleName = null;
                try {
                    roleName = studentInformationMapper.roleName(userInformation.getRoleId());
                } catch (Exception e) {
                    System.out.println(roleName+"出错了...数据为空");
                }
                map.put("role",roleName);
                maps.add(map);
            }
        }
        return maps;

    }


}
