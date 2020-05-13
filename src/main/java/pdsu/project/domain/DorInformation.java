package pdsu.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ljk
 */
public class DorInformation {


    private List<Map<String, Object>>  dormitoryInfo=new ArrayList<>();


    public List<Map<String, Object>> getDormitoryInfo() {
        return dormitoryInfo;
    }

    public void setDormitoryInfo(List<Map<String, Object>> dormitoryInfo) {
        this.dormitoryInfo = dormitoryInfo;
    }

    @Override
    public String toString() {
        return "DorInformation{" +
                "dormitoryInfo=" + dormitoryInfo +
                '}';
    }
}
