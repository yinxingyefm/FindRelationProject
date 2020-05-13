package pdsu.project.domain;

/**
 * @author ljk
 */
public class ExcelTeacherDomain {

    private String  id;

    /***
     *性别
     */

    private String num;
    /***
     * 性别
     */
    private String sex;

    //上报时间
    private  String reportTime;
    //院系
    private String deptName;

    //姓名
    private String name;
    //本人电话
    private String myPhone;
    /**
     * 紧急联系人姓名
     */
    private String paraentName;
    /**
     * 紧急联系人电话
     */
    private String paraentPhone;

    /**
     * 我的常住地
     */
    private String myOffenHome;

    /***
     * 常住地详细地址
     */
    private String myOffenHomeDeatil;

    /***
     * 本人户籍所在地
     */
    private  String localHome;

    /**
     * 本人今日体温
     */
    private String temp;
    /***
     * 目前键康状态
     */
    private String healthy;
    /***
     * 健康状况
     */
    private String healthyCondition;
    /***
     * 当前所在地区
     */
    private  String nowArea;
    /***
     * 当前详细所在地址
     */
    private String nowDetailArea;
    /***
     * 是否为确诊病例
     */
    private String badCase;

    private String badCaseTime;
    /***
     * 是否外出
     */
    private String isOut;
    /**
     * 外出时间
     */
   private String outTime;

    /**
     * 外出地点
     */
   private String outArea;
    /***
     * 返回时间
     */
   private String backTime;

    /***
     * 交通方式以及班次
     */
   private String traffic;

    /**
     * 是否去过疫情地区或者接触过人
     */
   private String isBadCase;
    /**
     * 经过的疫情地区
     */
   private  String badArea;
    /***
     * 是否在平顶山
     */
   private String isPing;
    /***
     * 是否隔离
     */
   private String  isolation;

    /***
     * 是否强制隔离
     */
   private String  mandatoryIsolation;
    /***
     * 强制在家隔离
     */
   private String  inHomeIsolation;

    /***
     * 隔离开始时间
     */
   private String isolationBeginTime;
    /***
     * 隔离结束时间
     */
    private String isolationEndTime;

    /***
     * 是否就诊入院
     */
    private String isHospital;
    /***
     * 是否去过重点地区
     */
    private String familyIsGoToBadRrea;
    /***
     * 去过的重点地区
     */
    private String familyGoToBadRrea;
    /***
     * 去过的重点地区的时间
     */
    private String familyGoToBadRreaTime;

    /***
     * 具体国家名字
     */
    private String contry;


    /***
     * 其它事项
     */
    private String other;

    /***
     * 小区是否有患病者
     */
    private String isBadPerson;


    /***
     * 同意上述请求
     */

//     7.2.1、请输入具体国家名称,
// 8、本人目前是否在平顶山市区（新华区、卫东区、湛河区、新城区、高新区）,
// 9、本人是否隔离,
// 9.1、是否医疗机构强制隔离,
// 9.2、是否自行居家隔离,
// 9.2.1、隔离开始时间,
// 9.2.2、隔离结束时间,
// 10、本人是否有就诊住院,
// 11、共同居住的家庭成员是否到过（经过）疫情重点区，是否接触过疑似病患及疫情重点地区人员如湖北、武汉、温州、韩国、其他国家,
// 11.1、选择共同居住的家庭成员到过（经过）疫情重点区的城市或国家,
// 11.1.1、具体国家名称,
// 11.2、共同居住的家庭成员到过（经过）疫情重点区或接触过疫情重点区人员的具体时间,
// 12、所居住的小区或村庄是否有确诊或疑似新冠肺炎病例, 本人承诺以上填报信息真实、准确，如有瞒报、漏报、迟报、错报、谎报，导致疫情失真和蔓延失控，将依法依规承担相应责任。 ]




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMyPhone() {
        return myPhone;
    }

    public void setMyPhone(String myPhone) {
        this.myPhone = myPhone;
    }

    public String getParaentName() {
        return paraentName;
    }

    public void setParaentName(String paraentName) {
        this.paraentName = paraentName;
    }

    public String getParaentPhone() {
        return paraentPhone;
    }

    public void setParaentPhone(String paraentPhone) {
        this.paraentPhone = paraentPhone;
    }

    public String getMyOffenHome() {
        return myOffenHome;
    }

    public void setMyOffenHome(String myOffenHome) {
        this.myOffenHome = myOffenHome;
    }

    public String getMyOffenHomeDeatil() {
        return myOffenHomeDeatil;
    }

    public void setMyOffenHomeDeatil(String myOffenHomeDeatil) {
        this.myOffenHomeDeatil = myOffenHomeDeatil;
    }

    public String getLocalHome() {
        return localHome;
    }

    public void setLocalHome(String localHome) {
        this.localHome = localHome;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHealthy() {
        return healthy;
    }

    public void setHealthy(String healthy) {
        this.healthy = healthy;
    }

    public String getHealthyCondition() {
        return healthyCondition;
    }

    public void setHealthyCondition(String healthyCondition) {
        this.healthyCondition = healthyCondition;
    }

    public String getNowArea() {
        return nowArea;
    }

    public void setNowArea(String nowArea) {
        this.nowArea = nowArea;
    }

    public String getNowDetailArea() {
        return nowDetailArea;
    }

    public void setNowDetailArea(String nowDetailArea) {
        this.nowDetailArea = nowDetailArea;
    }

    public String getBadCase() {
        return badCase;
    }

    public void setBadCase(String badCase) {
        this.badCase = badCase;
    }

    public String getBadCaseTime() {
        return badCaseTime;
    }

    public void setBadCaseTime(String badCaseTime) {
        this.badCaseTime = badCaseTime;
    }

    public String getIsOut() {
        return isOut;
    }

    public void setIsOut(String isOut) {
        this.isOut = isOut;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getOutArea() {
        return outArea;
    }

    public void setOutArea(String outArea) {
        this.outArea = outArea;
    }

    public String getBackTime() {
        return backTime;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getIsBadCase() {
        return isBadCase;
    }

    public void setIsBadCase(String isBadCase) {
        this.isBadCase = isBadCase;
    }

    public String getBadArea() {
        return badArea;
    }

    public void setBadArea(String badArea) {
        this.badArea = badArea;
    }

    public String getIsPing() {
        return isPing;
    }

    public void setIsPing(String isPing) {
        this.isPing = isPing;
    }

    public String getIsolation() {
        return isolation;
    }

    public void setIsolation(String isolation) {
        this.isolation = isolation;
    }

    public String getMandatoryIsolation() {
        return mandatoryIsolation;
    }

    public void setMandatoryIsolation(String mandatoryIsolation) {
        this.mandatoryIsolation = mandatoryIsolation;
    }

    public String getInHomeIsolation() {
        return inHomeIsolation;
    }

    public void setInHomeIsolation(String inHomeIsolation) {
        this.inHomeIsolation = inHomeIsolation;
    }

    public String getIsolationBeginTime() {
        return isolationBeginTime;
    }

    public void setIsolationBeginTime(String isolationBeginTime) {
        this.isolationBeginTime = isolationBeginTime;
    }

    public String getIsolationEndTime() {
        return isolationEndTime;
    }

    public void setIsolationEndTime(String isolationEndTime) {
        this.isolationEndTime = isolationEndTime;
    }

    public String getIsHospital() {
        return isHospital;
    }

    public void setIsHospital(String isHospital) {
        this.isHospital = isHospital;
    }

    public String getFamilyIsGoToBadRrea() {
        return familyIsGoToBadRrea;
    }

    public void setFamilyIsGoToBadRrea(String familyIsGoToBadRrea) {
        this.familyIsGoToBadRrea = familyIsGoToBadRrea;
    }

    public String getFamilyGoToBadRrea() {
        return familyGoToBadRrea;
    }

    public void setFamilyGoToBadRrea(String familyGoToBadRrea) {
        this.familyGoToBadRrea = familyGoToBadRrea;
    }

    public String getFamilyGoToBadRreaTime() {
        return familyGoToBadRreaTime;
    }

    public void setFamilyGoToBadRreaTime(String familyGoToBadRreaTime) {
        this.familyGoToBadRreaTime = familyGoToBadRreaTime;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getIsBadPerson() {
        return isBadPerson;
    }

    public void setIsBadPerson(String isBadPerson) {
        this.isBadPerson = isBadPerson;
    }


    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    @Override
    public String toString() {
        return "ExcelTeacherDomain{" +
                "id='" + id + '\'' +
                ", num='" + num + '\'' +
                ", sex='" + sex + '\'' +
                ", reportTime='" + reportTime + '\'' +
                ", deptName='" + deptName + '\'' +
                ", name='" + name + '\'' +
                ", myPhone='" + myPhone + '\'' +
                ", paraentName='" + paraentName + '\'' +
                ", paraentPhone='" + paraentPhone + '\'' +
                ", myOffenHome='" + myOffenHome + '\'' +
                ", myOffenHomeDeatil='" + myOffenHomeDeatil + '\'' +
                ", localHome='" + localHome + '\'' +
                ", temp='" + temp + '\'' +
                ", healthy='" + healthy + '\'' +
                ", healthyCondition='" + healthyCondition + '\'' +
                ", nowArea='" + nowArea + '\'' +
                ", nowDetailArea='" + nowDetailArea + '\'' +
                ", badCase='" + badCase + '\'' +
                ", badCaseTime='" + badCaseTime + '\'' +
                ", isOut='" + isOut + '\'' +
                ", outTime='" + outTime + '\'' +
                ", outArea='" + outArea + '\'' +
                ", backTime='" + backTime + '\'' +
                ", traffic='" + traffic + '\'' +
                ", isBadCase='" + isBadCase + '\'' +
                ", badArea='" + badArea + '\'' +
                ", isPing='" + isPing + '\'' +
                ", isolation='" + isolation + '\'' +
                ", mandatoryIsolation='" + mandatoryIsolation + '\'' +
                ", inHomeIsolation='" + inHomeIsolation + '\'' +
                ", isolationBeginTime='" + isolationBeginTime + '\'' +
                ", isolationEndTime='" + isolationEndTime + '\'' +
                ", isHospital='" + isHospital + '\'' +
                ", familyIsGoToBadRrea='" + familyIsGoToBadRrea + '\'' +
                ", familyGoToBadRrea='" + familyGoToBadRrea + '\'' +
                ", familyGoToBadRreaTime='" + familyGoToBadRreaTime + '\'' +
                ", contry='" + contry + '\'' +
                ", other='" + other + '\'' +
                ", isBadPerson='" + isBadPerson + '\'' +
                '}';
    }
}


