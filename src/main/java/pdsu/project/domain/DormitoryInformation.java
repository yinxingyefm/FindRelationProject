package pdsu.project.domain;

public class DormitoryInformation {
    private Integer dormitoryId;

    private String dormitoryName;



    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public String getDormitoryName() {
        return dormitoryName;
    }

    public void setDormitoryName(String dormitoryName) {
        this.dormitoryName = dormitoryName == null ? null : dormitoryName.trim();
    }


}