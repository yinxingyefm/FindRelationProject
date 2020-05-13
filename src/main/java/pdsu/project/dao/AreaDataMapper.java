package pdsu.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pdsu.project.domain.AreaData;

public interface AreaDataMapper {
    int deleteByPrimaryKey(Integer codeId);

    int insert(AreaData record);

    AreaData selectByPrimaryKey(Integer codeId);

    List<AreaData> selectAll();

    int updateByPrimaryKey(AreaData record);

    //根据报备信息查询外出地点id
    Integer selectAreaId(Integer id);

    Integer selectByCityAndArea(@Param("cname") String cname, @Param("aname") String aname);

    Integer selectByCity(@Param("cname") String cname);


}