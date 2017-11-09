package com.anchora.mce.jpaTest.controller;


import java.util.List;

import javax.transaction.UserTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anchora.mce.jpaTest.dao.UserRepository;
import com.anchora.mce.jpaTest.entity.User;
import com.anchora.mce.jpaTest.vo.UserVo;


@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/api/users",method=RequestMethod.POST)
	@ResponseBody
	public List<User>  listUsers() {
		List<User> list = userRepository.findAll();
		return list;
	}
	
	@RequestMapping(value="/api/user/{id}",method=RequestMethod.POST)
	@ResponseBody
	public User getUsers(@PathVariable Long id) {
		User user = userRepository.findOne(id);
		return user;
	}
	
	@RequestMapping(value="/api/mod/user",method=RequestMethod.POST)
	@ResponseBody
	public String modUsers(UserVo userVo) {
		User userTemp = userRepository.findOne(userVo.getId());
		if (userTemp!=null) {
			userTemp.setAge(userVo.getAge());
			userRepository.save(userTemp);
		}
		return "ok";
	}
	
	@RequestMapping(value="/api/del/user/{id}",method=RequestMethod.POST)
	@ResponseBody
	public String delUsers(@PathVariable Long id) {
		userRepository.delete(id);
		return "ok";
	}
}
