package pdsu.project.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ljk
 */
public class Utils {

    //三个数排序
    public static float  max(float a,float b,float c){
        float max;
        if (a > b && a > c) {
            max = a;
        } else if (c > a && c > b) {
            max = c;
        } else
            max = b;
        return max;
    }

    //全部都不为空
    public static   Integer count(Float a, Float b,Float c){
        Integer count=0;
        if (a!=null&&
                b!=null &&c!=null){
            count+=1;
        }
        return count;
    }


    /***
     * 将一个集合转化为字符串
     * @param list
     * @return
     */
    public  static String lisTAsString(List<String> list){
        //创建一个字符串数组
        String [] strings=new String[list.size()];
        String s;
        //向字符串里边添加数据
        for (Integer i=0;i<list.size();i++){
            s = list.get(i)+",";
            strings[i]=s;
        }
        //创建字符串缓冲数组
        StringBuffer buffer = new StringBuffer();
        for (Integer j=0;j<strings.length;j++) {
            buffer.append(strings[j]);
        }
        String lists = buffer.toString();
        String substring = lists.substring(0, lists.length() - 1);
       //转换为切割好的字符串
        return  substring;
    }


    public static ExcelDomain   excelDomain(List<String> list){
        ExcelDomain domain = new ExcelDomain();
        domain.setId(list.get(0));
        domain.setReportTime(list.get(1));
        domain.setDeptName(list.get(2));
        domain.setClassName(list.get(3));
        domain.setName(list.get(4));
        domain.setSex(list.get(5));
        domain.setNum(list.get(6));
        domain.setMyPhone(list.get(7));
        domain.setParaentName(list.get(8));
        domain.setParaentPhone(list.get(9));
        domain.setMyOffenHome(list.get(10));
        domain.setMyOffenHomeDeatil(list.get(11));
        domain.setLocalHome(list.get(12));
        domain.setDor(list.get(13));
        domain.setTemp(list.get(14));
        domain.setHealthy(list.get(15));
        domain.setHealthyCondition(list.get(16));
        domain.setNowArea(list.get(17));
        domain.setNowDetailArea(list.get(18));
        domain.setBadCase(list.get(19));
//        System.out.println(list.get(20));
        domain.setIsOut(list.get(20));
        domain.setOutTime(list.get(21));
        domain.setOutArea(list.get(22));
        domain.setBackTime(list.get(23));
        domain.setTraffic(list.get(24));
        domain.setIsBadCase(list.get(25));
        domain.setBadArea(list.get(26));
        domain.setIsPing(list.get(27));
        domain.setIsolation(list.get(28));
        domain.setMandatoryIsolation(list.get(29));
        domain.setInHomeIsolation(list.get(30));
        domain.setIsolationBeginTime(list.get(31));
        domain.setIsolationEndTime(list.get(32));
        domain.setIsHospital(list.get(33));
        domain.setFamilyIsGoToBadRrea(list.get(34));
        domain.setFamilyGoToBadRrea(list.get(35));
        domain.setFamilyGoToBadRreaTime(list.get(36));
        domain.setBackSchool(list.get(37));
        domain.setBackSchoolTime(list.get(38));
        domain.setBackSchoolTools(list.get(39));
        domain.setOther(list.get(40));
        domain.setIsBadPerson(list.get(41));
        domain.setAgree(list.get(42));
        return  domain;
    }

    /***
     * 存放省市县信息
     */
    public static List<String> Areea(String s)
    {
        ArrayList<String> list = new ArrayList<>();
        int index = s.indexOf(" ");
        int i = s.lastIndexOf(" ");
        if (s.length()>6){
            //省
            String substring = s.substring(0, index);
            //市
            list.add(substring);
            String substring1 = s.substring(index+1,i);
            list.add(substring1);
            //县/区
            String substring2 = s.substring(i + 1, s.length());
            list.add(substring2);
        }else {
            //市
            String substring = s.substring(0, index);
            System.out.println(substring);
            list.add(substring);
            String substring1 = s.substring(index + 1, s.length());
            list.add(substring1);
        }
        return  list;
    }

    //宿舍信息
    public static Integer DorNum(String s){
//        String s1="湖滨校区9号楼6层621房间";
        int indexOf = s.indexOf("区");
//        System.out.println(indexOf);
        int c = s.lastIndexOf("层");
        String substring = s.substring(indexOf+1, indexOf + 2);
//        System.out.println(substring);
//        System.out.println(c);
        String substring1 = s.substring(c + 1, c + 4);
        String n= substring+substring1;
        int anInt = Integer.parseInt(n);
        return  anInt;
    }


    public  static Date StringAsDate(String s)
    {
        Date d=null;
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        try {
            d= f.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  d;
    }

    public  static Date StringAsDate1(String s)
    {
        String s1="2020年"+s;
        String substring = s1.substring(0, 4);
        String substring1 = s1.substring(5, 7);
        String substring2 = s1.substring(8, 10);

        String s2=substring+"-"+substring1+"-"+substring2+" "+"00:00:00";
        Date d=null;
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        try {
            d= f.parse(s2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  d;
    }

    /***
     * 年级
     * @param nu
     * @return
     */
  public static  String Grade(String nu){
      String substring = nu.substring(0, 2);
      return  substring;
  }


}
