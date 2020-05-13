package pdsu.project.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class IsolationInformation {
    private Integer isolationId;

    private Integer isolationHospital;

    private Integer isolationHome;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date isolationStart;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date isolationEnd;

    private Integer reportId;

    public Integer getIsolationId() {
        return isolationId;
    }

    public void setIsolationId(Integer isolationId) {
        this.isolationId = isolationId;
    }

    public Integer getIsolationHospital() {
        return isolationHospital;
    }

    public void setIsolationHospital(Integer isolationHospital) {
        this.isolationHospital = isolationHospital;
    }

    public Integer getIsolationHome() {
        return isolationHome;
    }

    public void setIsolationHome(Integer isolationHome) {
        this.isolationHome = isolationHome;
    }

    public Date getIsolationStart() {
        return isolationStart;
    }

    public void setIsolationStart(Date isolationStart) {
        this.isolationStart = isolationStart;
    }

    public Date getIsolationEnd() {
        return isolationEnd;
    }

    public void setIsolationEnd(Date isolationEnd) {
        this.isolationEnd = isolationEnd;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }
}