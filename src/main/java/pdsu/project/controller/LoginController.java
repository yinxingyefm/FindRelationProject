package pdsu.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import pdsu.dqw.interceptor.User;
import pdsu.dqw.util.JWTUtil;
import pdsu.dqw.util.ResponseData;
import pdsu.project.service.StudentInformationService;

@RestController
public class LoginController {
	@Autowired
	private StudentInformationService studentInformationService;

	@RequestMapping(method=RequestMethod.POST,value="login")
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
    		if(userInfo.get("role").equals("admin")){
    			//生成token
        		String token = JWTUtil.generToken("1", "Jersey-Security-Basic",user.getUserName());
        		responseData.putDataValue("token", token);
        		responseData.setObject(userInfo);
    		}else {
    			responseData=ResponseData.NoPower();
			}
    		
    	}else {
    		//用户或者密码错误
    		responseData=ResponseData.customerError();
    	}
        return responseData;
    }
   

}
