package com.dao;

import java.awt.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.entity.User;

@Mapper
public interface UserDao {
	@Select("select * from tb_user")
	@Results({
		@Result(property="id",column="id"),
		@Result(property="name",column="name"),
		@Result(property="age",column="age")
	})
   java.util.List<User> getAll();
   
   @Insert("insert into tb_user(name,age) values(#{name},#{age})")
   @Options(useGeneratedKeys = true,keyColumn="id",keyProperty="id")
   Long save(User user);
   
   @Delete("delete from tb_user where id=#{id}")
   Long delete(@Param("id") Integer id);
   
   
   @Update("update tb_user t set t.name=#{name} where t.id=#{id}")
    Long update(@Param("name")String name,@Param("id") Integer id);
   
   @Select("select * from tb_user where name=#{name}")
   User findByName(@Param("name")String name);
   
}
