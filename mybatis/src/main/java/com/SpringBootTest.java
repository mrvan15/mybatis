package com;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.dao.UserDao;
import com.entity.User;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest
public class SpringBootTest {

	@Autowired
	private UserDao userDao;
	
	//@Autowired
	// private StringRedisTemplate stringRedisTemplate;
	
	@Test
	public void Test() {
		User user = new User();
		user.setName("edg");
		user.setAge(11);
		Long math = userDao.save(user);
	Assert.assertEquals(math.toString(), "12");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void Test2() {
		String name = "bbc";
		User user = userDao.findByName(name);
		Assert.assertEquals(user.getName(), "777");
	}
	
	@Test
	public void Test3() {
//		   List<String> list =new ArrayList<String>();
//	        list.add("a");
//	        list.add("b");
//	        list.add("v");
//	        stringRedisTemplate.opsForValue().set("abc", "测试");
//	        stringRedisTemplate.opsForList().leftPushAll("qq",list); // 向redis存入List
//	        stringRedisTemplate.opsForList().range("qwe",0,-1).forEach(value ->{
	           System.out.println("222");
	//        });
	}
}
