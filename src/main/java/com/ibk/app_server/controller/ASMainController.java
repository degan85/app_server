package com.ibk.app_server.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibk.app_server.dao.User;
import com.ibk.app_server.service.MySqlService;

@Controller
@RequestMapping(value = "/")
public class ASMainController {

	@Autowired MySqlService mySqlService;
	
	Logger logger = LoggerFactory.getLogger(ASMainController.class);
	
	public List<Map<String,String>> selectUsers() {
		return mySqlService.selectUsers();
	}
	
	public Integer deleteUsers() {
		return mySqlService.deleteUsers();
	}

	public Integer insertUser(Map<String, Object> param) {
		return mySqlService.insertUser(param);
	}
	
	public List<User> selectUsersDao() {
		return mySqlService.selectUsersDao();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String first() {
		logger.debug("Hello World!!");
		System.out.println("@@@@@@");
		return "login";
	}
	
	@RequestMapping(value = "/ss", method = RequestMethod.GET)
	public String testSS(HttpServletRequest res, Model model) {
		logger.debug("Hello World!!");
		System.out.println("ssssss");
		return "login";
	}

	
	
	
	
	
}
