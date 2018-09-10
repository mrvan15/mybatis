package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
    public List<User> getAll();
    public Long saveUser(User user);
    public Long delete(Integer id);
    public Long update(String name,Integer id);
    public User findByName(String name);
    public String ceshiMq(String key,String message);
}
