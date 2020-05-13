package pdsu.project.service;

import pdsu.project.domain.RecordInfo;
import pdsu.project.domain.RecordedInformation;
import pdsu.project.domain.TempInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljk
 */

//温度统计接口
public interface TempInfoService {
//    统计师生今日温度
    public List<TempInformation> tempForOneDayForRole(String role);

   //分级统计录入信息
    public ArrayList<RecordedInformation> RecordedInformation(String role) throws Exception;

    //分级未录入的情况
    public ArrayList<RecordedInformation> UnRecordedInformation(String role, Integer dept);





}
