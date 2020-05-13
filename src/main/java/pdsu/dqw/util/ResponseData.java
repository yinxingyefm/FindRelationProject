package pdsu.dqw.util;
import java.util.HashMap;
import java.util.Map;
public class ResponseData {
	private final String message;
    private final int code;
    private final Map<String, Object> data = new HashMap<String, Object>();
    public ResponseData(String message, int code, Object object) {
		super();
		this.message = message;
		this.code = code;
		this.object = object;
	}

	private  Object object;
 
    public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getMessage() {
        return message;
    }
 
    public int getCode() {
        return code;
    }
 
    public Map<String, Object> getData() {
        return data;
    }
 
    public ResponseData putDataValue(String key, Object value) {
        data.put(key, value);
        return this;
    }
    public ResponseData backSuccessData(Object value) {
      
        return new ResponseData(200,"success",value);
    }
    private ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }
    private ResponseData(int code, String message,Object object) {
        this.code = code;
        this.message = message;
        this.object=object;
    }
 
    public static ResponseData ok() {
        return new ResponseData(200, "Ok");
    }
 
    public static ResponseData notFound() {
        return new ResponseData(404, "Not Found");
    }
 
    public static ResponseData badRequest() {
        return new ResponseData(400, "Bad Request");
    }
 
    public static ResponseData forbidden() {
        return new ResponseData(403, "Forbidden");
    }
 
    public static ResponseData unauthorized() {
        return new ResponseData(401, "unauthorized");
    }
 
    public static ResponseData serverInternalError() {
        return new ResponseData(500, "Server Internal Error");
    }
    public static ResponseData ImportFileError() {
        return new ResponseData(508, "Import File Error");
    }
    public static ResponseData UploadNullFile() {
        return new ResponseData(507, "Upload NUll");
    }
 
    public static ResponseData customerError() {
        return new ResponseData(1001, "customer Error");
    }
    public static ResponseData updatePsError() {
        return new ResponseData(509, "学号输入错误或原密码有误");
    }
    public static ResponseData updateUser() {
        return new ResponseData(510, "Update Error");
    }
    public static ResponseData addTemRecordError() {
        return new ResponseData(511, "已录入或学号不正确");
    }
   
    public static ResponseData NoPower() {
        return new ResponseData(512, "没有权限!");
    }
   



}
