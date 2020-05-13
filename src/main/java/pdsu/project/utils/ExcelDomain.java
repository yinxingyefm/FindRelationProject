package pdsu.project.utils;

/**
 * @author ljk
 */
public class ExcelDomain {

    //选好

    private String  id;


    private String sex;

    private String num;

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

    //上报时间
    private  String reportTime;
    //院系
    private String deptName;
    //班级
    private  String className;
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

    public String getMyOffenHomeDeatil() {
        return myOffenHomeDeatil;
    }

    public void setMyOffenHomeDeatil(String myOffenHomeDeatil) {
        this.myOffenHomeDeatil = myOffenHomeDeatil;
    }

    /***
     * 本人户籍所在地
     */
    private  String localHome;
    /**
     * 宿舍
     */
    private String dor;
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

    public String getOutArea() {
        return outArea;
    }

    public void setOutArea(String outArea) {
        this.outArea = outArea;
    }

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
     * 是否范平
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
     * 是否返校
     */
    private String backSchool;
    /***
     * 返校时间
     */
    private String backSchoolTime;
    /***
     * 返校工具以及班次
     */
    private String backSchoolTools;
    /***
     * 其它事项
     */
    private String other;

    /***
     * 小区是否有患病者
     */
    private String isBadPerson;

    public String getIsBadPerson() {
        return isBadPerson;
    }

    public void setIsBadPerson(String isBadPerson) {
        this.isBadPerson = isBadPerson;
    }

    /***
     * 同意上述请求
     */
    private String agree;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public String getLocalHome() {
        return localHome;
    }

    public void setLocalHome(String localHome) {
        this.localHome = localHome;
    }

    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
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

    public String getBackSchool() {
        return backSchool;
    }

    public void setBackSchool(String backSchool) {
        this.backSchool = backSchool;
    }

    public String getBackSchoolTime() {
        return backSchoolTime;
    }

    public void setBackSchoolTime(String backSchoolTime) {
        this.backSchoolTime = backSchoolTime;
    }

    public String getBackSchoolTools() {
        return backSchoolTools;
    }

    public void setBackSchoolTools(String backSchoolTools) {
        this.backSchoolTools = backSchoolTools;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }

    @Override
    public String toString() {
        return "ExcelDomain{" +
                "id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                ", num='" + num + '\'' +
                ", reportTime='" + reportTime + '\'' +
                ", deptName='" + deptName + '\'' +
                ", className='" + className + '\'' +
                ", name='" + name + '\'' +
                ", myPhone='" + myPhone + '\'' +
                ", paraentName='" + paraentName + '\'' +
                ", paraentPhone='" + paraentPhone + '\'' +
                ", myOffenHome='" + myOffenHome + '\'' +
                ", myOffenHomeDeatil='" + myOffenHomeDeatil + '\'' +
                ", localHome='" + localHome + '\'' +
                ", dor='" + dor + '\'' +
                ", temp='" + temp + '\'' +
                ", healthy='" + healthy + '\'' +
                ", healthyCondition='" + healthyCondition + '\'' +
                ", nowArea='" + nowArea + '\'' +
                ", nowDetailArea='" + nowDetailArea + '\'' +
                ", badCase='" + badCase + '\'' +
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
                ", backSchool='" + backSchool + '\'' +
                ", backSchoolTime='" + backSchoolTime + '\'' +
                ", backSchoolTools='" + backSchoolTools + '\'' +
                ", other='" + other + '\'' +
                ", isBadPerson='" + isBadPerson + '\'' +
                ", agree='" + agree + '\'' +
                '}';
    }
}


