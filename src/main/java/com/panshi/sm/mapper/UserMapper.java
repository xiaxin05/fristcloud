package com.panshi.sm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.panshi.sm.pojo.User;
import com.panshi.sm.pojo.UserVo;


@Mapper
public interface UserMapper {
	@Select("select * from user where name like '%${inputName}%'  limit #{page},#{limit}")
	public List<User> queryAllUser(@Param("page")Integer page,@Param("limit")Integer limit,@Param("inputName")String inputName);
	
	@Select("select count(*) from user where name like '%${inputName}%' ")
	public int queryAllUserCounr(@Param("inputName")String inputName);
	
	@Insert("insert into user(name,password,adress) values(#{user.name},#{user.password},#{user.adress});")
	public int addUser(@Param("user")User user);
	
	@Delete("delete from user where id in(${deleteIds})")
	public int deleteUser(@Param("deleteIds")String deleteIds);

	@Update("UPDATE  user SET name=#{user.name},password=#{user.password},adress=#{user.adress}  where id=#{user.id}")
	public void updateUser(@Param("user")User user);
	
}
