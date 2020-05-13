package pdsu.project.domain;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author ljk
 */
public class TempInformation {

 //时间
  private   String time;

  //不正人常数量
  private Integer unnormal;

  //正常人的数量
  private Integer  normal;

  //所有的统计温度所有的人数
  private Integer all;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
        return "TempInformation{" +
                "time='" + time + '\'' +
                ", unnormal=" + unnormal +
                ", normal=" + normal +
                ", all=" + all +
                '}';
    }
}
