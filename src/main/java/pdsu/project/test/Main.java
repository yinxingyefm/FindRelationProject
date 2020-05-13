package pdsu.project.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pdsu.project.dao.FirendRelationMapper;
import pdsu.project.dao.TempInformationdao;
import pdsu.project.domain.FirendRelation;
import pdsu.project.domain.RecordedInformation;
import pdsu.project.service.RecordInfoSAervice;
import pdsu.project.service.StudentInformationService;
import pdsu.project.service.TempInfoService;
import pdsu.project.service.UpdateInfoService;
import pdsu.project.service.impl.ExcelTool;
import pdsu.project.service.impl.RelationShipService;
import pdsu.project.utils.DifList;
import pdsu.project.utils.Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * @author ljk
 */
public class Main {
    public static void main(String[] args) throws Exception {
      ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        RelationShipService bean = classPathXmlApplicationContext.getBean(RelationShipService.class);
        Relation allFreand = bean.findAllFreand("1");
        System.out.println(allFreand);


    }


}














//        FirendRelationMapper bean = classPathXmlApplicationContext.getBean(FirendRelationMapper.class);
//        List<String> friendId = bean.findFriendId(1 + "");
//        System.out.println(friendId);
//        for (int i=0;i<1;i++){
//            List<String> friendChildId = bean.findFriendId(friendId.get(i));
//            System.out.println(friendChildId);
//            for (int j=0;j<friendChildId.size();j++){
//                System.out.println(friendId.get(j));
//                if ("1".equals(friendChildId.get(j))){
//                    System.out.println("pp");
//                    friendChildId.remove(j);
//                    System.out.println(j);
//                }
//            }
//
//            System.out.println(friendChildId);
//        }