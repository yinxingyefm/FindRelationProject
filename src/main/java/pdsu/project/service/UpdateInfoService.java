package pdsu.project.service;

import pdsu.project.domain.DepartmentInformation;
import pdsu.project.domain.LogInformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ljk
 */
public interface UpdateInfoService {

    public Boolean updateUserInfo(String num, String password);

    //返回所有信息条数,传入角色类型
    public  Integer count(Integer type);

    //显示未录入人的信息
    public ArrayList<HashMap<String, Object>> UnRecordInfo(Integer dept, Integer type);

    //查询所有院系
    public List<DepartmentInformation> AllDdept();
   //查看所有上传文件信息
    public List<LogInformation> AllRecordFile();
    /****
     *  更新用户信息
     * @param id
     * @param num
     * @param userNme
     * @param phone
     * @param role
     * @param employer
     * @param password
     * @return
     */
    public Boolean updateInfo(int id, String num, String userNme, String phone, String role, String employer, String password);


}
