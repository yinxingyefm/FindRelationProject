package pdsu.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pdsu.project.domain.FirendRelation;

public interface FirendRelationMapper {
	List<FirendRelation> findChild(String parnum);
    //查询朋友节点
	List<String> findFriendId(String parnum);

	List<String > SingGo(@Param("num") String num, @Param("list") List<String> list);


}
