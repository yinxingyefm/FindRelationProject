package pdsu.project.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljk
 */
public class Relation {

    private List<String> first=new ArrayList<>();

    private List<String> second=new ArrayList<>();

    private List<String> third=new ArrayList<>();

    private List<String> forth=new ArrayList<>();

    public List<String> getFirst() {
        return first;
    }

    public void setFirst(List<String> first) {
        this.first = first;
    }

    public List<String> getSecond() {
        return second;
    }

    public void setSecond(List<String> second) {
        this.second = second;
    }

    public List<String> getThird() {
        return third;
    }

    public void setThird(List<String> third) {
        this.third = third;
    }

    public List<String> getForth() {
        return forth;
    }

    public void setForth(List<String> forth) {
        this.forth = forth;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", forth=" + forth +
                '}';
    }
}
