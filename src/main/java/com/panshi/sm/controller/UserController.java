package com.panshi.sm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.panshi.sm.pojo.ResponsePojo;
import com.panshi.sm.pojo.User;
import com.panshi.sm.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ResponsePojo query(Integer page,Integer limit,String inputName) {
		return userService.queryAllUser(page,limit,inputName) ;
	}
	
	@PostMapping("/user")
	public ResponsePojo addUser(@RequestBody User user) {
		ResponsePojo entity = new ResponsePojo();
		try {
			userService.addUser(user) ;
			entity.setCode(1);
		} catch (Exception e) {
			entity.setCode(0);
			entity.setMsg(e.getMessage());
		}
		return entity;
	}
	
	@DeleteMapping("/user/{deleteIds}")
	public ResponsePojo deleteUser(String deleteIds) {
		ResponsePojo entity = new ResponsePojo();
		try {
			userService.deleteUser(deleteIds) ;
			entity.setCode(1);
		} catch (Exception e) {
			entity.setCode(0);
			entity.setMsg(e.getMessage());
		}
		return entity;
	}
	
	
	@PutMapping("/user/{id}")
	public ResponsePojo updateUser(Integer id,@RequestBody User user) {
		ResponsePojo entity = new ResponsePojo();
		try {
			userService.updateUser(user) ;
			entity.setCode(1);
		} catch (Exception e) {
			entity.setCode(0);
			entity.setMsg(e.getMessage());
		}
		return entity;
	}
	
}
