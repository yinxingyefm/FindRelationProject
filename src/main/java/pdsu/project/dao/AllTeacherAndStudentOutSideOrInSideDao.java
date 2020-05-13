package pdsu.project.dao;

import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author ljk
 */
public interface AllTeacherAndStudentOutSideOrInSideDao {

    /**
     * 查询老师或者学生外出的数量
     * type 1 为学生 0 为老师
     * @param date
     * @param type
     * @return
     */
     public Integer   outsideStudentNum(@Param("date") LocalDate date, @Param("type") Integer type);


    /***
     * 查询学生或者老师没有外出的数量
     * @param date
     * @param type
     * @return
     */
    public Integer   insideStudentNum(@Param("date") LocalDate date, @Param("type") Integer type);








}
