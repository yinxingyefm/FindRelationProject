package pdsu.project.service;

import pdsu.project.domain.LogInformation;

import java.util.List;
import java.util.Map;

/**
 * @author ljk
 */
public interface RecordInfoSAervice {

    /***
     * 更新密码
     * @param num
     * @param oldPassword
     * @param Newpassword
     * @return
     */
    public  boolean upadtePassword(String num, String oldPassword, String Newpassword);

    /***
     * 上报信息
     * @param name
     * @param num
     * @param tempture
     * @return
     */
    public  boolean RecordTemp(String name, String num, float tempture, int temSection);

    /***
     * 查找院系负责人
     * @param dept
     * @return
     */
    public Map<String,Object> findManger(Integer dept);

    /****
     * 用户所属部门
     * @param userid
     * @return
     */

    public List<Map<String,Object>> findByUid(int userid);

    /***
     * 查询全部日志信息
     * @return
     */
    List<LogInformation> findAll();

    /**
     * 插入日志信息
     * @param logInformation
     * @return
     */
    int insertLoog(LogInformation logInformation);



}
