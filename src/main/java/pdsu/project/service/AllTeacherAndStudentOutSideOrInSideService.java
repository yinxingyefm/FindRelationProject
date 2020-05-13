package pdsu.project.service;

import pdsu.project.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ljk
 */
public interface AllTeacherAndStudentOutSideOrInSideService {

    /**
     * 查询老师或者学生的外出或者统计信息
     * @param role
     * @return
     */
    public AllTeacherAndStudentOutSideOrInSide  Information(String role);

//    获取xx人 每天外出地点
    public List<OutSideInfo>  AllOutsideInformation(String role, String num);

    //查询不正常温度的人的信息
    public  List<UnusualInformation> unmalForTime(String role, String time);

     //获取指定时间师生外出的人员信息
    public ArrayList<OutSideInfoForSomeOneDay> forTimeAndRole(String role, String time);








}
