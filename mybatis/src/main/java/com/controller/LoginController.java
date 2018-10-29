package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;

@RestController
public class LoginController {
	
	@RequestMapping("login")
	public String login(String name,String pwd,HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if(name.equals("root")&&pwd.equals("root")) {
            User user = new User();
            user.setName(name);
            session.setAttribute("user",user);
            return "登录成功";
            System.out.println("yyy");
	    System.out.println("sse");

        } else {
            return "用户名或密码错误!";
	    System.out.println("sss");
        }
   
	}

}
