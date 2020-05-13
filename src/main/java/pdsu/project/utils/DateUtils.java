package pdsu.project.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author ljk
 */
public class DateUtils {

    /***
     * 得到从当前这一天算起前七天的信息
     * @return
     */
    public static List<LocalDate> returnWeekDate(){
        LocalDate date = LocalDate.now();
        ArrayList<LocalDate> dateArrayList = new ArrayList<>();
        for (int i=6;i>0;i--){
            LocalDate localDate = date.minusDays(i);
            dateArrayList.add(localDate);
        }
        dateArrayList.add(date);
        return  dateArrayList;
    }

    /**
     * 传入一星期的数据,然后格式化为字符串输出
     * @param weeek
     * @return
     */
   public static List<String> returnWeekDateAsString(List<LocalDate> weeek){
        List<String> list=new ArrayList<String>();
       for (LocalDate l: weeek) {
           String s = l.toString();
           String substring = s.substring(5, 10);
           if(substring.contains("0")){
               if (substring.contains("10")|| substring.contains("20")||substring.contains("30")){
                   list.add(substring);
               }else {
                   String replace = substring.replace("0", "");
                   System.out.println(replace);
                   list.add(replace);
               }
           }else {
               list.add(s);
           }
       }
        return list;
   }


   //把一个日期转化为字符串输出
   public static  String DateAsString(Date date){
       SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
       String format = dateFormater.format(date);
       return format;
   }

   //把一个字符切割后形成一个localdate
   public static LocalDate timeAsDate(String time){
       int i = time.indexOf("-");
       String m= time.substring(0, i);
       Integer mouth=Integer.parseInt(m);
       String  d=time.substring(i+1,time.length());
       Integer day = Integer.parseInt(d);
      //形成当前时间
       LocalDate date = LocalDate.of(2020, mouth, day);
       return  date;

   }


}
