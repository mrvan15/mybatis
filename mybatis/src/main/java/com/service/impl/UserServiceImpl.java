package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.User;
import com.service.RedisService;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	
	
	
	@Autowired
	private RedisService redisService;
	
	@Override
	public List<User> getAll() {
		
		return userdao.getAll();
	}

	@Override
	public Long saveUser(User user) {
		// TODO Auto-generated method stub
		return userdao.save(user);
	}

	@Override
	public Long delete(Integer id) {
		// TODO Auto-generated method stub
		return userdao.delete(id);
	}

	@Override
	public Long update(String name, Integer id) {
		// TODO Auto-generated method stub
		return userdao.update(name, id);
	}

	@Override
	public User findByName(String name) {
		User user = userdao.findByName(name);
	//	redisService.set("name", user);
		return userdao.findByName(name);
	}

	@Override
	public String ceshiMq(String key, String message) {
		redisService.convertAndSend(key, message);
		return "success";
	}
	
	

}