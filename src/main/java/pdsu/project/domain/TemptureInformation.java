package pdsu.project.domain;

import java.util.Date;

public class TemptureInformation {

    //自增id
    private Integer id;
    //学号
    private Integer temptureNum;

    //早上温度
    private Float temptureMor;
   //中午温度
    private Float temptureLun;
    //晚上温度
    private Float temptureEve;
   //日期
    private Date temptureDate;
    //类型
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemptureNum() {
        return temptureNum;
    }

    public void setTemptureNum(Integer temptureNum) {
        this.temptureNum = temptureNum;
    }

    public Float getTemptureMor() {
        return temptureMor;
    }

    public void setTemptureMor(Float temptureMor) {
        this.temptureMor = temptureMor;
    }

    public Float getTemptureLun() {
        return temptureLun;
    }

    public void setTemptureLun(Float temptureLun) {
        this.temptureLun = temptureLun;
    }

    public Float getTemptureEve() {
        return temptureEve;
    }

    public void setTemptureEve(Float temptureEve) {
        this.temptureEve = temptureEve;
    }

    public Date getTemptureDate() {
        return temptureDate;
    }

    public void setTemptureDate(Date temptureDate) {
        this.temptureDate = temptureDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TemptureInformation{" +
                "id=" + id +
                ", temptureNum=" + temptureNum +
                ", temptureMor=" + temptureMor +
                ", temptureLun=" + temptureLun +
                ", temptureEve=" + temptureEve +
                ", temptureDate=" + temptureDate +
                ", type=" + type +
                '}';
    }
}