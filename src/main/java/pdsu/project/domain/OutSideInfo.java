package pdsu.project.domain;

/**
 * @author ljk
 */
//外出信息
public class OutSideInfo {

      //时间
      private String  data;

      //体温
      private  String  temperature;

      //地址
      private String   outAddress;
      //电话
      private  String tel;

      public String getData() {
            return data;
      }

      public void setData(String data) {
            this.data = data;
      }

      public String getTemperature() {
            return temperature;
      }

      public void setTemperature(String temperature) {
            this.temperature = temperature;
      }

      public String getOutAddress() {
            return outAddress;
      }

      public void setOutAddress(String outAddress) {
            this.outAddress = outAddress;
      }

      public String getTel() {
            return tel;
      }

      public void setTel(String tel) {
            this.tel = tel;
      }

      @Override
      public String toString() {
            return "OutSideInfo{" +
                    "data='" + data + '\'' +
                    ", temperature='" + temperature + '\'' +
                    ", outAddress='" + outAddress + '\'' +
                    ", tel='" + tel + '\'' +
                    '}';
      }
}
