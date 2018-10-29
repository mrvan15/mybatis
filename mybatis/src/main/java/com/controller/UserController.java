package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController
public class UserController {
	private Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="/",method=RequestMethod.GET)
    public List<User> findAll(){
    	List<User> user = userService.getAll();
		return user;
    }
    
    @RequestMapping(value="/api/save",method=RequestMethod.GET)
    public String saveUser() {
    	User user = new User();
         user.setName("rst");
         user.setAge(25);
         userService.saveUser(user);
         redisUtil.set("saves", user);
		return "dddd";
    	
    }
    
    @RequestMapping(value="/api/remove",method=RequestMethod.GET)
    public String removeUser() {
    	Long math = userService.delete(2);
		return math.toString();
    	
    }
    
    @RequestMapping(value="/api/update",method=RequestMethod.GET)
    public String modifyUser() {
    	String name = "bbb";
    	Integer id = 1;
    	Long math = userService.update(name, id);
		return math.toString();
    	
    }
    
    @RequestMapping(value="/api/findByName",method=RequestMethod.GET)
    public User findByName() {
    	String name = "bbb";
    	User user = userService.findByName(name);
    	log.info("age====="+user.getAge().toString());
		return user;
    	
    }
    
    @RequestMapping(value="/api/mq",method=RequestMethod.GET)
    public String ceshiMq() {
    	for(int i=0;i<5;i++) {
    		String message = "这是第" + i + "条推送"; 
    		try {
    			userService.ceshiMq("chat",message);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
		return "success";
    	
    }
}
