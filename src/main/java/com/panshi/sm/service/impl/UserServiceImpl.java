package com.panshi.sm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panshi.sm.mapper.UserMapper;
import com.panshi.sm.pojo.ResponsePojo;
import com.panshi.sm.pojo.User;
import com.panshi.sm.pojo.UserVo;
import com.panshi.sm.service.UserService;

@Service
public  class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper um;
	
	public ResponsePojo queryAllUser(Integer page, Integer limit,String inputName) {
		if (inputName==null) {
			inputName="";
		}
		Integer sum = (page-1)*limit;
		List<User> list = um.queryAllUser(sum, limit,inputName);
		int queryAllCount = um.queryAllUserCounr(inputName);
		ResponsePojo userRetun = new ResponsePojo();
		userRetun.setData(list);
		userRetun.setCount(queryAllCount);
		return userRetun;
	}

	public int addUser(User user) {
		return um.addUser(user);
	}

	public void deleteUser(String deleteIds) {
		um.deleteUser(deleteIds);
	}

	public void updateUser(User user) {
		um.updateUser(user);
	}


}
