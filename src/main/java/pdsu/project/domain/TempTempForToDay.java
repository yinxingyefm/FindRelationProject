package pdsu.project.domain;

import java.util.List;

/**
 * @author ljk
 */
public class TempTempForToDay {

    //不正常的数量
    private List<Integer> unnormal;

    //正常的数量
    private List<Integer> normal;
    //时间
    private List<String> time;

    public List<Integer> getUnnormal() {
        return unnormal;
    }

    public void setUnnormal(List<Integer> unnormal) {
        this.unnormal = unnormal;
    }

    public List<Integer> getNormal() {
        return normal;
    }

    public void setNormal(List<Integer> normal) {
        this.normal = normal;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TempTempForToDay{" +
                "unnormal=" + unnormal +
                ", normal=" + normal +
                ", time=" + time +
                '}';
    }
}
