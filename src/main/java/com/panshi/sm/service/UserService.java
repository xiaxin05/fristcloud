package com.panshi.sm.service;


import com.panshi.sm.pojo.ResponsePojo;
import com.panshi.sm.pojo.User;
import com.panshi.sm.pojo.UserVo;

public interface UserService {
	public ResponsePojo queryAllUser(Integer page, Integer limit, String inputName);
	public int addUser(User user);
	public void deleteUser(String deleteIds);
	public void updateUser(User user);
}
