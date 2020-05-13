package pdsu.project.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljk
 */
public class AreaInfoFoWeek {

    //城市名字
    private  String name;

    //
    private  String type;

     private  String stack;
     //每天信息变化的数量
     private List<Integer> data=new ArrayList<Integer>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AreaInfoFoWeek{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", stack='" + stack + '\'' +
                ", data=" + data +
                '}';
    }
}
