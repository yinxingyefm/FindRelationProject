package pdsu.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pdsu.dqw.interceptor.Password;
import pdsu.dqw.interceptor.TemReport;
import pdsu.dqw.interceptor.User;
import pdsu.dqw.util.JWTUtil;
import pdsu.dqw.util.ResponseData;
import pdsu.project.service.RecordInfoSAervice;
import pdsu.project.service.StudentInformationService;

@RestController
@RequestMapping("/")
public class RecordController {
	@Autowired
	private RecordInfoSAervice recordInfoSAervice;
	@Autowired
	private StudentInformationService studentInformationService;
	//一日三报登录
	@RequestMapping(method=RequestMethod.POST,value="record/login")
    public  ResponseData login(@RequestBody User user) {
		boolean login=false;
    	Map<String, Object> userInfo = studentInformationService.selectUserInfo(user.getUserName(),user.getPassword());
    	if(userInfo!=null){
    		login=true;
    	}else{
    		login=false;
    	}
    	ResponseData responseData = ResponseData.ok();
    	if(login) {
    			//生成token
        		String token = JWTUtil.generToken("1", "Jersey-Security-Basic",user.getUserName());
        		responseData.putDataValue("token", token);
        		responseData.setObject(userInfo);
    	}else {
    		//用户或者密码错误
    		responseData=ResponseData.customerError();
    	}
        return responseData;
    }
   
	//一日三报修改密码
	@RequestMapping(method=RequestMethod.PUT,value="upRecordPs")
	public ResponseData updateUser(@RequestBody Password ps){
	   System.out.println("ps："+ps.toString());		  
		ResponseData responseData = ResponseData.ok();
		boolean result = recordInfoSAervice.upadtePassword(ps.getNum(), ps.getOldPassword(), ps.getNewpassword());
		if(result==true){
			responseData.setObject("修改密码成功");
		}else {
			responseData=ResponseData.updatePsError();
		}
		return responseData;
	}
	//一日三报上报
	@RequestMapping(method=RequestMethod.POST,value="temReport")
    public ResponseData temReport(@RequestBody TemReport tem) {
		 ResponseData responseData = ResponseData.ok();
		 System.out.println("TemReport:"+tem.toString());	
		 boolean recordTemp = recordInfoSAervice.RecordTemp(tem.getName(),tem.getNum(),tem.getTempture(), tem.getTemSection());
		 if (recordTemp==true){
				responseData.setObject("报备成功");
			}else {
				responseData=ResponseData.addTemRecordError();
			}
		 return responseData;
    	}
}
