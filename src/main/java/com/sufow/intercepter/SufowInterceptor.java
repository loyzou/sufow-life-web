package com.sufow.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SufowInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("¡£¡£¡£¡£À¹½ØÆ÷²âÊÔ¡£¡£¡£¡£¡£");
		
		String url = request.getRequestURI();
		// ÅÐ¶ÏÊÇ·ñÐèÒªµÇÂ¼
		boolean needLogin =  this.needLogin(url);
		if(needLogin){
			response.setHeader("signId", "needLogin");
			return false;
		}
		
		return true;
	}

	private boolean needLogin(String url) {
		if(url.contains("account")){
			return true;
		}
		return false;
	}
}
