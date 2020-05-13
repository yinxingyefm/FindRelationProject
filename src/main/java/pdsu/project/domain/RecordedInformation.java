package pdsu.project.domain;

/**
 * @author ljk
  录入和未录入信息
 */
public class RecordedInformation {

    /**
     * 数量
     */
   private Integer value;

   //描述信息
   private String name;


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RecordedInformation{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
