package pdsu.project.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BackschoolInformation {
    private Integer backschoolId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date backschoolTime;

    private String backschoolVehicle;

    private Integer reportId;

    public Integer getBackschoolId() {
        return backschoolId;
    }

    public void setBackschoolId(Integer backschoolId) {
        this.backschoolId = backschoolId;
    }

    public Date getBackschoolTime() {
        return backschoolTime;
    }

    public void setBackschoolTime(Date backschoolTime) {
        this.backschoolTime = backschoolTime;
    }

    public String getBackschoolVehicle() {
        return backschoolVehicle;
    }

    public void setBackschoolVehicle(String backschoolVehicle) {
        this.backschoolVehicle = backschoolVehicle == null ? null : backschoolVehicle.trim();
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }
}