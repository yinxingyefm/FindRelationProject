package pdsu.project.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class OutInformation {
    private Integer outId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date outTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date backTime;

    private String vehicle;

    private Integer outArea;

    private Integer reportId;

    public Integer getOutId() {
        return outId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle == null ? null : vehicle.trim();
    }

    public Integer getOutArea() {
        return outArea;
    }

    public void setOutArea(Integer outArea) {
        this.outArea = outArea;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }
}