package com.anchora.mce.jpaTest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anchora.mce.jpaTest.dao.UserRepository;
import com.anchora.mce.jpaTest.entity.User;


@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/api/users",method=RequestMethod.GET)
	@ResponseBody
	public List<User>  getUsers() {
		List<User> list = userRepository.findAll();
		return list;
	}
}
