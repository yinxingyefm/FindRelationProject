package pdsu.dqw.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import pdsu.dqw.util.JWTUtil;
import pdsu.dqw.util.ResponseData;
public class HeaderTokenInterceptor implements HandlerInterceptor {
	private static final Logger LOG = Logger.getLogger(HeaderTokenInterceptor.class);
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object handler) throws Exception {
		ResponseData responseData = null;
		// 获取我们请求头中的token验证字符
		String headerToken = httpServletRequest.getHeader("token");
		// 检测当前页面,我们设置当页面不是登录页面时对其进行拦截
		// 具体方法就是检测URL中有没有login字符串
		if (!httpServletRequest.getRequestURI().contains("login")) {
			if (headerToken == null) {
				// 如果token不存在的话,返回错误信息。
				responseData=ResponseData.customerError();
			}
			try {
				// 对token进行更新与验证
				headerToken = JWTUtil.updateToken(headerToken);
				LOG.debug("token验证通过,并续期了");
			} catch (Exception e) {
				LOG.debug("token验证出现异常!");
				// 当token验证出现异常返回错误信息,token不匹配
				responseData=ResponseData.customerError();
			}
		}
		if(responseData!=null) {//如果有错误信息
			httpServletResponse.getWriter().write(JSON.toJSONString(responseData));
			return false;
		}else {
			// 将token加入返回页面的header
			httpServletResponse.setHeader("token", headerToken);
			return true;
		}
	}
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {
	}
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {
	}
}
