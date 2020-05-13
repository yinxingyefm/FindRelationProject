package pdsu.project.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ljk
 */
public class AllTeacherAndStudentOutSideOrInSide implements Serializable {

    //所有的外出信息
    private List<Integer> inside = new ArrayList<Integer> ();

    //所有外出的数量
    private List<Integer> outside = new ArrayList<Integer> ();

    //一星期的日期
    private List<String> time =new ArrayList<String>();



    public List<Integer> getInside() {
        return inside;
    }

    public void setInside(List<Integer> inside) {
        this.inside = inside;
    }

    public List<Integer> getOutside() {
        return outside;
    }

    public void setOutside(List<Integer> outside) {
        this.outside = outside;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }



    @Override
    public String toString() {
        return "AllTeacherAndStudentOutSideOrInSide{" +
                "inside=" + inside +
                ", time=" + time +
                ", outside=" + outside +
                '}';
    }
}
