package pdsu.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdsu.project.dao.FirendRelationMapper;
import pdsu.project.test.Relation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljk
 */
@Service
public class RelationShipService {
   @Autowired
   private FirendRelationMapper bean;

    public  List<String> findFreand(String num){
        List<String> friendId = bean.findFriendId(1 + "");
        List<String> listFr=new ArrayList<>();
        listFr.add(num);
        List<String> friendChildId=null;
        System.out.println(friendId);
        for (int i=0;i<friendId.size();i++){
            friendChildId= bean.findFriendId(friendId.get(i));
            System.out.println(friendChildId);
            System.out.println(friendId.get(i)+"第二代");
            if (friendChildId.size()>0){
                for (int j=0;j<friendChildId.size();j++){
                    for (int k=0;k<listFr.size();k++){
                        System.out.println(friendChildId.get(j)+"666666");
                        if (listFr.get(k).equals(friendChildId.get(j))){
                            friendChildId.remove(j);
                            System.out.println(j);
                        }
                    }
                }
            }
            listFr.add(friendId.get(i));
            listFr.addAll(friendChildId);
            System.out.println(listFr+"遍历的所有的数据");
        }
        return  friendChildId;
    }



    public  Relation findAllFreand(String num){
        ArrayList<String> objects = new ArrayList<>();
       Relation relations=new Relation();
        //第一代
        objects.add(num);
        List<String> friendId = bean.findFriendId(num);
        relations.setFirst(friendId);
        objects.addAll(friendId);
        //第二代
        List<String> second=new ArrayList<>();
        if (friendId.size()>0){
           for (String s:friendId) {
               List<String> sec=   bean.SingGo(s,objects);
               second.addAll(sec);
               objects.addAll(sec);
           }
       }
        relations.setSecond(second);
        System.out.println(second+"第二代信息");
       //第三代
        List<String> third=new ArrayList<>();
        if (second.size()>0){
            for (String s:second) {
                List<String>  th=bean.SingGo(s,objects);
                third.addAll(th);
                objects.addAll(th);
            }
        }
        relations.setThird(third);
//第四代
        List<String> forth=new ArrayList<>();
        if (second.size()>0){
            for (String s:third) {
                List<String>  fo=bean.SingGo(s,objects);
                forth.addAll(fo);
                objects.addAll(fo);
            }
        }
        relations.setThird(third);
       relations.setForth(forth);
        return relations;
    }





}
