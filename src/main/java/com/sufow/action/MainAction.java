package com.sufow.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sufow.common.SufowResult;

@Controller
public class MainAction {
	/***
	 * 测试设置signId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/main/queryTest")
	@ResponseBody
	public SufowResult queryTest(HttpServletRequest request,HttpServletResponse response){
		SufowResult result = new SufowResult();
		response.addHeader("signId", request.getSession().getId());
		return result;
	}
	
	/**
	 * 测试返回其它项目中的对象
	 * @param request
	 * @return
	 */
	@RequestMapping("/main/querySufowResult")
	@ResponseBody
	public SufowResult querySufowResult(HttpServletRequest request){
		SufowResult result = new SufowResult();
		result.setMessage("sufow result is success");
		return result;
	}
	
	/***
	 * 测试返回cookies
	 * @param request
	 * @return
	 */
	@RequestMapping("/main/queryCookiesTest")
	@ResponseBody
	public SufowResult queryCookiesTest(HttpServletRequest request,HttpServletResponse response){
		SufowResult result = new SufowResult();
		
		System.out.println(request.getSession().getId());
		
		Cookie []cookies = request.getCookies();
		
		for(Cookie c:cookies){
			System.out.println(c.getName()+","+c.getValue());
		}
		
		Cookie cookie = new Cookie("sufow", "sufowCookie");
		response.addCookie(cookie);
		return result;
	}

}
