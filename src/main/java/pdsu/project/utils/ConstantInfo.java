package pdsu.project.utils;

/**
 * @author ljk
 */

//常量信息

public interface ConstantInfo {
    /**
     * 老师角色
     */
     static String role_teacher="老师" ;//老师角色
    /***
     * 学生角色
     */
    static String role_student="学生";

    /**
     * 学生
     */
    static  Integer student_type=1;//学生
    /***
     * 老师
     */
    static  Integer teacher_type=0;//老师
    /***
     * 最低温度
     */
    static float lowest_temp=(float)37.0;//最低温度

    /***
     * 最高温度
     */
    static  float  highest_temp= (float) 37.3;//最高温度

    /***
     * 早上
     */
    static  String  moring="8:00";//早上 8：:00
    /***
     * 中午
     */
    static  String  lunch="12:00";//中午 8：:00
    /***
     * 晚上
     */
    static  String  eveing="18:00";//早上 8：:00

    /***
     * 宿舍长
     */
    static String  dorMaster="宿舍长";
    /***
     * 舍员
     */
    static String dorNomal="舍员";
    /**
     * 男
     */
    static  String man="男";
    /***
     * 女
     */
    static  String  woman="女";
    /**
     * 是  外出
     */
    static  String  outDoorY="是";

    /**
     * 否  外出
     */
    static  String  outDoorN="否";
    /***
     * 管理员
     */
    static  String role_admin="admin";

    static  String grade1="18级";

    /**
     * 大二
     */
    static  String grade2="18级";
    /***
     * 大三
     */
    static  String grade3="17级";

    /***
     * 16级
     */
    static  String grade4="16级";
    /***
     * 是隔离
     */
    static String isolationY="是";

    /***
     * 没有隔离
     */
    static String isolationN="否";

    /***
     * 是住院
     */
    static  String isisHospital="是";

    /***
     * 本人到过重点地区
      */
   static String isBadCase="是";

    /***
     * 居家人员到过重点疫区
     */
    static String familyIsGoToBadRrea="是";

    /***
     * 已经返校
     */
    static String backSchool="是";

    /***
     * 所居住的小区或村庄是否有确诊或疑似新冠肺炎病例(0有/1没有)
     */
    static String isBadPerson="是";

    /***
     * 本人是否确诊为病例或疑似病例(0不是,1是)
     */
    static String  badCase="是";

    /***
     * 健康无状况
     */
    static String healthy="健康，无症状";


}
