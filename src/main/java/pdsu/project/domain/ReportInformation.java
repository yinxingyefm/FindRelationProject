package pdsu.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ReportInformation {
    private Integer reportId;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date reportTime;

    private Double temperature;

    private String health;

    private String nowDetailaddress;

    private Integer nowAddress;

    private Integer ifDermine;

    private Integer out;

    private Integer teacherPds;

    private Integer isolation;

    private Integer inpatient;

    private Integer serverlyArea;

    private Integer familySeverelyArea;

    private Integer studentBackschool;

    private Integer areaDisease;

    private String number;

    private Integer type;

    private String others;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health == null ? null : health.trim();
    }

    public String getNowDetailaddress() {
        return nowDetailaddress;
    }

    public void setNowDetailaddress(String nowDetailaddress) {
        this.nowDetailaddress = nowDetailaddress == null ? null : nowDetailaddress.trim();
    }

    public Integer getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(Integer nowAddress) {
        this.nowAddress = nowAddress;
    }

    public Integer getIfDermine() {
        return ifDermine;
    }

    public void setIfDermine(Integer ifDermine) {
        this.ifDermine = ifDermine;
    }

    public Integer getOut() {
        return out;
    }

    public void setOut(Integer out) {
        this.out = out;
    }

    public Integer getTeacherPds() {
        return teacherPds;
    }

    public void setTeacherPds(Integer teacherPds) {
        this.teacherPds = teacherPds;
    }

    public Integer getIsolation() {
        return isolation;
    }

    public void setIsolation(Integer isolation) {
        this.isolation = isolation;
    }

    public Integer getInpatient() {
        return inpatient;
    }

    public void setInpatient(Integer inpatient) {
        this.inpatient = inpatient;
    }

    public Integer getServerlyArea() {
        return serverlyArea;
    }

    public void setServerlyArea(Integer serverlyArea) {
        this.serverlyArea = serverlyArea;
    }

    public Integer getFamilySeverelyArea() {
        return familySeverelyArea;
    }

    public void setFamilySeverelyArea(Integer familySeverelyArea) {
        this.familySeverelyArea = familySeverelyArea;
    }

    public Integer getStudentBackschool() {
        return studentBackschool;
    }

    public void setStudentBackschool(Integer studentBackschool) {
        this.studentBackschool = studentBackschool;
    }

    public Integer getAreaDisease() {
        return areaDisease;
    }

    public void setAreaDisease(Integer areaDisease) {
        this.areaDisease = areaDisease;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others == null ? null : others.trim();
    }

    @Override
    public String toString() {
        return "ReportInformation{" +
                "reportId=" + reportId +
                ", reportTime=" + reportTime +
                ", temperature=" + temperature +
                ", health='" + health + '\'' +
                ", nowDetailaddress='" + nowDetailaddress + '\'' +
                ", nowAddress=" + nowAddress +
                ", ifDermine=" + ifDermine +
                ", out=" + out +
                ", teacherPds=" + teacherPds +
                ", isolation=" + isolation +
                ", inpatient=" + inpatient +
                ", serverlyArea=" + serverlyArea +
                ", familySeverelyArea=" + familySeverelyArea +
                ", studentBackschool=" + studentBackschool +
                ", areaDisease=" + areaDisease +
                ", number='" + number + '\'' +
                ", type=" + type +
                ", others='" + others + '\'' +
                '}';
    }
}