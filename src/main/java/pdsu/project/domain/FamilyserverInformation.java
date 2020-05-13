package pdsu.project.domain;

import java.util.Date;

public class FamilyserverInformation {
    private Integer famserverId;


    private Date famserverTime;

    private Integer city;

    private Integer reportId;

    public Integer getFamserverId() {
        return famserverId;
    }

    public void setFamserverId(Integer famserverId) {
        this.famserverId = famserverId;
    }

    public Date getFamserverTime() {
        return famserverTime;
    }

    public void setFamserverTime(Date famserverTime) {
        this.famserverTime = famserverTime;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }
}