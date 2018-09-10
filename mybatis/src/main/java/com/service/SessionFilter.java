package com.service;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.CookieGenerator;

public class SessionFilter  extends OncePerRequestFilter implements Filter{

	@Override
	public boolean isLoggable(LogRecord record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 从cookie中获取sessionId，如果此次请求没有sessionId，重写为这次请求设置一个sessionId
		HttpSession session = getSession(request);
		//通过response将cookie返回
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		response.addCookie(cookie);
		
	}
	 
	public HttpSession getSession(HttpServletRequest request) {
		// 从request中解析cookie
		HttpSession session = null;
		Cookie [] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("JSESSIONID")) {
					String sessionId = cookie.getValue();
					session = request.getSession();
				}
			}
		}
		
		if(session == null) {
			session = request.getSession();
		}
		
		return session;
		
	}

}
