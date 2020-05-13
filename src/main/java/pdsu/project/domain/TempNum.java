package pdsu.project.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ljk
 */

/***
 * 温度统计信息
 */
public class TempNum  implements Serializable {


    private Date time;

    //不正常人数
    private  Integer  unnormal;

    //正常人数
    private Integer   normal;

    //所有人数
    private  Integer all;


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUnnormal() {
        return unnormal;
    }

    public void setUnnormal(Integer unnormal) {
        this.unnormal = unnormal;
    }

    public Integer getNormal() {
        return normal;
    }

    public void setNormal(Integer normal) {
        this.normal = normal;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "TempNum{" +
                "time=" + time +
                ", unnormal=" + unnormal +
                ", normal=" + normal +
                ", all=" + all +
                '}';
    }
}
