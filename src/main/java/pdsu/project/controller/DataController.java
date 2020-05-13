package pdsu.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pdsu.dqw.interceptor.Ps;
import pdsu.dqw.interceptor.Usermag;
import pdsu.dqw.util.ResponseData;
import pdsu.project.domain.AllSchoolNumInArea;
import pdsu.project.domain.AllTeacherAndStudentOutSideOrInSide;
import pdsu.project.domain.DepartmentInformation;
import pdsu.project.domain.DorInformation;
import pdsu.project.domain.LogInformation;
import pdsu.project.domain.OutSideInfo;
import pdsu.project.domain.OutSideInfoForSomeOneDay;
import pdsu.project.domain.RecordInfo;
import pdsu.project.domain.RecordedInformation;
import pdsu.project.domain.TempInformation;
import pdsu.project.domain.TempTempForToDay;
import pdsu.project.domain.UnusualInformation;
import pdsu.project.service.AllTeacherAndStudentOutSideOrInSideService;
import pdsu.project.service.RecordInfoSAervice;
import pdsu.project.service.StudentInformationService;
import pdsu.project.service.TempInfoService;
import pdsu.project.service.TempTempForToDayService;
import pdsu.project.service.UpdateInfoService;
import pdsu.project.service.ViewAllSchoolAreaInformationService;

@RestController
@RequestMapping("/")
public class DataController {
	@Autowired
	private AllTeacherAndStudentOutSideOrInSideService outService;
	@Autowired
	private ViewAllSchoolAreaInformationService areaService;
	@Autowired
	private StudentInformationService studentInformationService;
	@Autowired
	private TempInfoService tempInfoService;
	@Autowired
	private TempTempForToDayService weekTempService;
	@Autowired
	private UpdateInfoService updateInfoService;
	@Autowired
	private RecordInfoSAervice recordInfoSAervice;
	//统计外出情况
	@GetMapping("outside/{role}")
	public ResponseData outside(@PathVariable("role") String role){
		ResponseData responseData = ResponseData.ok();
		AllTeacherAndStudentOutSideOrInSide data = outService.Information(role);
		responseData.setObject(data);
		return responseData;
	}
	//统计每天各地区变化
	@GetMapping("china/{id}")
	public ResponseData stuAndTerAreaInformation(@PathVariable("id") int id){
		ResponseData responseData = ResponseData.ok();
		List<AllSchoolNumInArea> information = areaService.StudentAndTeacherAreaInformation(id);
		responseData.setObject(information);
		return responseData;
	}
	//统计师生在各个地区一星期的人数变化
	@GetMapping("population/{id}")
	public ResponseData stuAndterAreaForWeek(@PathVariable("id") int id){
		ResponseData responseData = ResponseData.ok();
		List<Map<String, Object>> data = areaService. StudentAndTeacherAreaInformationForWeekAll(id);
		responseData.setObject(data);         
		return responseData;
	}
	//通过班级名称查询班级信息
	@GetMapping("classinfo/{className}/{page}")
	public ResponseData selectClassInfoByClassName(@PathVariable("className") String className,@PathVariable("page") Integer page){
		ResponseData responseData = ResponseData.ok();
		Map<String, Object> data = studentInformationService.selectClassInfoByClassName(className,page);
		responseData.setObject(data);
		return responseData;
	}
	//根据宿舍号查询宿舍成员信息
	@GetMapping("dormitoryInfo/{dormitoryNum}")
	public ResponseData selectDorInfo(@PathVariable("dormitoryNum")   int dormitoryNum){
		ResponseData responseData = ResponseData.ok();
	    DorInformation data = studentInformationService.selectDorInfo(dormitoryNum);
		responseData.setObject(data);
		return responseData;
	}
	//统计一周正常体温变化
		@GetMapping("temp/line/{role}")
		public ResponseData tempForOneDayForRole(@PathVariable("role") String role) throws Exception{
			ResponseData responseData = ResponseData.ok();
			System.out.println("role:"+role);
			 TempTempForToDay data = weekTempService.selectAWeekforRole(role);
			if(data!=null){
				responseData.setObject(data);
				return responseData;
			}else{
				return responseData;
			}
		}
	//获取指定时间师生外出人员信息
		@RequestMapping("outside/{role}/{time}")
		public ResponseData detailOutMag(@PathVariable("role") String role,@PathVariable("time") String time){
			System.out.println("role:"+role+"time:"+time);
			ResponseData responseData = ResponseData.ok();
			ArrayList<OutSideInfoForSomeOneDay> forTimeAndRole = outService.forTimeAndRole(role, time);
			responseData.setObject(forTimeAndRole);
			return responseData;
		}
	//统计师生今日的温度 	
		@GetMapping("temp/{role}")
		public ResponseData TodayTemMag(@PathVariable("role") String role){
			System.out.println("role:"+role);
			ResponseData responseData = ResponseData.ok();
			List<TempInformation> tempForOneDayForRole = tempInfoService.tempForOneDayForRole(role);
			responseData.setObject(tempForOneDayForRole);
			return responseData;
		}
   //统计录入情况(显示录入的未录入)/enter/:{role}/:{grade}
		@RequestMapping("enter/{role}")
		public ResponseData ReportMag(@PathVariable("role") String role) throws Exception{
			System.out.println("role:"+role);
			ResponseData responseData = ResponseData.ok();
			ArrayList<RecordedInformation> information = tempInfoService.RecordedInformation(role);
			responseData.setObject(information);
			return responseData;
		}
	
	//查看未录入人员信息(学未生0,老师1)
		@RequestMapping("unenter/detail/{role}/{page}")
		public ResponseData Unusualdetail(@PathVariable("role") Integer role,@PathVariable("page") Integer page){
			System.out.println("role:"+role);
			ResponseData responseData = ResponseData.ok();
			ArrayList<HashMap<String,Object>> list = updateInfoService.UnRecordInfo(role,page);
			responseData.setObject(list);
			return responseData;
		}
	//获取指定时间师生体温异常/unusual/:{role}/:{time}
		@RequestMapping("unusual/{role}/{time}")
		public ResponseData detailTimMag(@PathVariable("role") String role,@PathVariable("time") String time){
			System.out.println("role:"+role+"time:"+time);
			ResponseData responseData = ResponseData.ok();
			List<UnusualInformation> unmalForTime = outService.unmalForTime(role, time);
			responseData.setObject(unmalForTime);
			return responseData;
		}
     //分页查看所有人员/userList(学生为1，老师为0)
		@RequestMapping("userList/{role}/{page}")
		public ResponseData userList(@PathVariable("role") Integer role,@PathVariable("page") Integer page){
			ResponseData responseData = ResponseData.ok();
			List<Map<String, Object>> list = studentInformationService.findAllByPage(page, role);
			Integer count = updateInfoService.count(role);
			responseData.putDataValue("countpage",count);
			responseData.putDataValue("studentlist",list);
			return responseData;
		}
      //修改密码
		@RequestMapping(method=RequestMethod.PUT,value="updateps")
		public ResponseData updateUser(@RequestBody Ps ps){
			System.out.println(ps.toString());
			ResponseData responseData = ResponseData.ok();
			Boolean result = updateInfoService.updateUserInfo(ps.getNum(),ps.getPassword());
			if(result==true){
				responseData.setObject("修改密码成功");
			}else {
				responseData=ResponseData.updatePsError();
			}
			return responseData;
		}
		
		//根据id查看用户 /user/:{id}
		@GetMapping("user/{id}")
		public ResponseData getUserbyId(@PathVariable("id") Integer id){
			ResponseData responseData = ResponseData.ok();
			System.out.println("查看人员信息："+id);
			Map<String, Object> map = studentInformationService.selectById(id);
			responseData.setObject(map);
			return responseData;
		}
		//根据学号或工号查找用户/user/:{num}
		@GetMapping("user/num/{num}")
		public ResponseData getUserbyNum(@PathVariable("num") String num){
			ResponseData responseData = ResponseData.ok();
			Map<String, Object> map = studentInformationService.selectByNum(num);
			responseData.setObject(map);
			return responseData;
		}
		//获取指定师生每天外出地点/outSide/:{role}/:{num}
			@RequestMapping(value="outSide/{role}/{num}")
			public ResponseData OneOutAdr(@PathVariable("role") String role,@PathVariable("num") String num){
				System.out.println("role:"+role+"num:"+num);
				ResponseData responseData = ResponseData.ok();
				List<OutSideInfo> allOutsideInformation = outService.AllOutsideInformation(role, num);
				responseData.setObject(allOutsideInformation);
				return responseData;
				}
		//查看院系负责人
			@RequestMapping(value="depLeader/{depid}")
			public ResponseData depLeader(@PathVariable("depid") Integer depid){
				ResponseData responseData = ResponseData.ok();
				Map<String, Object> map = recordInfoSAervice.findManger(depid);
				responseData.setObject(map);
				return responseData;
				}	
		//根据院系查找角色具体未录入的人员(学生为1，老师为0)
			@RequestMapping(value="unenterbyDep/detail/{departmentid}/{role}")
			public ResponseData UnrecordBydep(@PathVariable("departmentid") Integer departmentid,@PathVariable("role") Integer role){
				System.out.println("departmentid:"+departmentid+"role:"+role);
				ResponseData responseData = ResponseData.ok();
				ArrayList<HashMap<String, Object>> list = updateInfoService.UnRecordInfo(departmentid, role);
				System.out.println("list.size()"+list.size());
				responseData.setObject(list);
				return responseData;
				}
		//全部院系的数据
			@GetMapping("alldepartments")
			public ResponseData alldepartments(){
				ResponseData responseData = ResponseData.ok();
				List<DepartmentInformation> list = updateInfoService.AllDdept();
				responseData.setObject(list);
				return responseData;
			}
		//全部上传文件的日志信息
			@GetMapping("allRecordFile")
			public ResponseData alllogRecordFile(){
				ResponseData responseData = ResponseData.ok();
				List<LogInformation> list = updateInfoService.AllRecordFile();
				responseData.setObject(list);
				return responseData;
			}
			
		//修改用户信息
			@RequestMapping(method=RequestMethod.PUT,value="updateUser")
			public ResponseData editUser(@RequestBody Usermag user){
			   System.out.println("user:"+user.toString());		  
				ResponseData responseData = ResponseData.ok();
				Boolean boolean1 = updateInfoService.updateInfo(user.getId(),user.getNum(),user.getUserName(),user.getPhone(),user.getRole(),user.getEmployer(),user.getPassword());
				if (boolean1==true){
					responseData.setObject("用户信息更新成功");
				}else {
					responseData=ResponseData.updateUser();
				}
				return responseData;
			}
			//根据院系id查找负责人
			@GetMapping("depLeader/{depid}")
			public ResponseData findManger(@PathVariable("depid") Integer depid){
				ResponseData responseData = ResponseData.ok();
				Map<String, Object> findManger = recordInfoSAervice.findManger(depid);
				responseData.setObject(findManger);
				return responseData;
			}
			//根据userid显示全部院系或则此用户所在院系全部班级
			@GetMapping("DeporClass/{userid}")
			public ResponseData DeporClass(@PathVariable("userid") Integer userid){
				ResponseData responseData = ResponseData.ok();
				List<Map<String, Object>> list = recordInfoSAervice.findByUid(userid);
				responseData.setObject(list);
				return responseData;
			}
}

















