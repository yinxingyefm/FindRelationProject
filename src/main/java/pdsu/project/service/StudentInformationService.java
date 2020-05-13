package pdsu.project.service;

/**
 * @author ljk
 */

import pdsu.project.domain.DorInformation;
import pdsu.project.domain.StudentInformation;

import java.util.List;
import java.util.Map;

/***
 * 学生业务逻辑接口
 */
public interface StudentInformationService {
    /***
     * 通过班级名称查询班级信息
     * @param className
     * @return
     */
     public Map<String,Object> selectClassInfoByClassName(String className, Integer page);

     //登录信息
     public  Map<String,Object> selectUserInfo(String number, String password);

// 根据宿舍号查询宿舍成员信息
    public DorInformation selectDorInfo(Integer dormitoryNum);




    //根据通过id查询
    public Map<String,Object> selectById(Integer id);

    //查询所有的信息
//    public List<Map<String,Object>>  findAll();


    public Map<String,Object> selectByNum(String id);

    //查询所有的信息
    public List<Map<String,Object>>  findAllByPage(Integer page, Integer type);



}
